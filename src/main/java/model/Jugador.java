package model;

public class Jugador {

	private Seleccion seleccion;
	private String Nombre;
	private int Numero;
	private String posicion;

	public Jugador(String nombre, int numero, String posicion, String seleccion) {
	}

	public Jugador(Seleccion seleccion, String nombre, int numero, String posicion) {
		this.seleccion = seleccion;
		this.Nombre = nombre;
		this.Numero = numero;
		this.posicion = posicion;
	}

	public Seleccion getSeleccion() {
		return seleccion;
	}

	public void setSeleccion(Seleccion seleccion) {
		this.seleccion = seleccion;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		this.Nombre = nombre;
	}

	public int getNumero() {
		return Numero;
	}

	public void setNumero(int numero) {
		this.Numero = numero;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
}
