package model.data.dao;
import model.Seleccion;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.Table;


import static org.jooq.impl.DSL.*;

public class SeleccionDAO {
    public static boolean validarExistenciaSeleccion(DSLContext query, String columnaTabla, Object dato) {
        Result<Record> resultados = query.select().from(table("seleccion")).where(field(columnaTabla).eq(dato)).fetch();
        return resultados.size() >= 1;
    }
    public static void agregarSeleccion(DSLContext query, Seleccion seleccion) {
        Table tablaCafe = table(name("Seleccion"));
        query.insertInto(tablaCafe,
                        field("nombre"),
                        field("rankingFifa"),
                        field("ID"),
                        field("jugadores"))

                .values(seleccion.getNombreSeleccion(),
                        seleccion.getRankingFifa(),
                        seleccion.getID(),
                        seleccion.getJugadores())

                .execute();
    }
    public static Seleccion buscarSeleccion(DSLContext query, Object nombreSeleccion) {
        Result<Record> resultados = query.select().from(table("Seleccion")).where(field("nombre").eq(nombreSeleccion)).fetch();

        if (resultados.isEmpty()) {
            return null;
        } else {
            Record record = resultados.get(0);
            String nombre = record.get("nombre", String.class);
            int rankingFifa = record.get("rankingFifa", Integer.class);
            int ID = record.get("ID", Integer.class);
            String jugadores = record.get("jugadores", String.class);
            Seleccion seleccion = new Seleccion(nombre, rankingFifa, ID, jugadores);
            return seleccion;
        }
    }
}