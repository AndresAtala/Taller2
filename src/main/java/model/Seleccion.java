package model;

import java.util.Collection;

public class Seleccion {

	private Collection<Jugador> jugadores;
	private String nombre;
	private int RankingFifa;
	private int ID;

	public Seleccion() {
	}

	public Seleccion(Collection<Jugador> jugadores, String nombre, int rankingFifa, int ID) {
		this.jugadores = jugadores;
		this.nombre = nombre;
		this.RankingFifa = rankingFifa;
		this.ID = ID;
	}

	public Seleccion(String nombre, int rankingFifa, int id, String jugadores) {
	}

	public Collection<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(Collection<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public String getNombreSeleccion() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getRankingFifa() {
		return RankingFifa;
	}

	public void setRankingFifa(int rankingFifa) {
		this.RankingFifa = rankingFifa;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}
}
