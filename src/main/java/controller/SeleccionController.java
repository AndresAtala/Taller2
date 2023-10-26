package controller;

import model.Jugador;
import model.Seleccion;
import model.data.dao.SeleccionDAO;
import model.data.dao.JugadorDAO;
import org.jooq.DSLContext;
import java.util.List;
import org.jooq.DSLContext;

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
        Jugador nuevoJugador = new Jugador(nombre,Numero, posicion, seleccion);
        JugadorDAO.agregarJugador(query, nuevoJugador);
    }
    
}