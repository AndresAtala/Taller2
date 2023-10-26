package model.data.dao;
import model.Jugador;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Record1;
import org.jooq.Result;
import org.jooq.Table;

import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.*;


public class JugadorDAO {
    public static boolean validarExistenciaJugador(DSLContext query, String columnaTabla, Object dato) {
        Result<Record> resultados = query.select().from(table("Jugador")).where(field(columnaTabla).eq(dato)).fetch();
        return resultados.size() >= 1;
    }
    public static void agregarJugador(DSLContext query, Jugador jugador) {
        Table tablaCafe = table(name("Jugador"));
        query.insertInto(tablaCafe,
                        field("nombre"),
                        field("numero"),
                        field("posicion"),
                        field("seleccion"))

                .values(jugador.getNombre(),
                        jugador.getNumero(),
                        jugador.getPosicion(),
                        jugador.getSeleccion())

                .execute();
    }
    public static Jugador buscarJugador(DSLContext query, Object nombreJugador) {
        Result<Record> resultados = query.select().from(table("jugador")).where(field("nombre").eq(nombreJugador)).fetch();

        if (resultados.isEmpty()) {
            return null;
        } else {
            Record record = resultados.get(0);
            String nombre = record.get("nombre", String.class);
            int numero = record.get("numero", Integer.class);
            String posicion = record.get("posicion", String.class);
            String seleccion = record.get("seleccion", String.class);

            Jugador jugador = new Jugador(nombre, numero, posicion, seleccion);
            return jugador;
        }
    }

}