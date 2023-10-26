package controller;

import model.Jugador;
import model.Seleccion;
import model.data.dao.SeleccionDAO;
import model.data.dao.JugadorDAO;
import org.jooq.DSLContext;
import java.util.List;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

public class SeleccionController {
    private SeleccionDAO seleccionDAO;
    private DSLContext query;

    public SeleccionController(DSLContext query) {
        this.query = query;
        this.SeleccionDAO = new SeleccionDAO(query);
    }

    public void agregarSeleccion(String nombre, int RankingFifa, int ID, String Jugadores) {
        Seleccion nuevaSeleccion = new Seleccion(nombre, RankingFifa, ID, Jugadores);
        SeleccionDAO.agregarSeleccion(query, nuevaSeleccion);
    }

    public void agregarJugador(String nombre, int Numero, String posicion, String seleccion) {
        Jugador nuevoJugador = new Jugador(nombre, Numero, posicion, seleccion);
        JugadorDAO.agregarJugador(query, nuevoJugador);
    }

    public static Seleccion buscarSeleccion(DSLContext query, Object nombreSeleccion) {
        Result<Record> resultados = query.select().from(table("Seleccion")).where(field("ID").eq(nombreSeleccion)).fetch();

        if (resultados.isEmpty()) {
            return null;
        } else {
            Record record = resultados.get(0);
            String nombre = record.get("nombre", String.class);
            int RankingFifa = record.get("RankingFifa", Integer.class);
            int ID = record.get("ID", Integer.class);
            String Jugadores = record.get("Jugadores", String.class);
            Seleccion seleccion = new Seleccion(nombre, RankingFifa, ID, Jugadores);
            return seleccion;
        }
    }
    public static Seleccion buscarJugador(DSLContext query, Object nombreJugador) {
        Result<Record> resultados = query.select().from(table("Jugador")).where(field("nombre").eq(nombreJugador)).fetch();

        if (resultados.isEmpty()) {
            return null;
        } else {
            Record record = resultados.get(0);
            String nombre = record.get("nombre", String.class);
            int numero = record.get("numero", Integer.class);
            String posicion= record.get("posicion", String.class);
            String Seleccion = record.get("seleccion", String.class);
            Jugador Jugador = new Jugador(nombre, numero, posicion, Seleccion);
            return Jugador;
        }
    }
}