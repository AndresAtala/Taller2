package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaMenu {
    private JFrame frame;
    private JPanel panel;

    public VentanaMenu() {
        frame = new JFrame("Ventana con botones");
        panel = new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        agregarBotones();
        agregarSalir();

        frame.add(panel);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    private void agregarBotones() {
        JButton agregarSeleccion = new JButton("Agregar Selección");
        JButton buscarSeleccion = new JButton("Buscar Selección");
        JButton agregarJugador = new JButton("Agregar Jugador");
        JButton buscarJugador = new JButton("Buscar Jugador");

        panel.add(agregarSeleccion);
        panel.add(buscarSeleccion);
        panel.add(agregarJugador);
        panel.add(buscarJugador);

        // Aquí puedes agregar ActionListener para los botones si deseas manejar eventos específicos para cada botón
    }

    private void agregarSalir() {
        JButton salir = new JButton("Salir");
        salir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panel.add(salir);
    }

    public static void main(String[] args) {
        new VentanaMenu();
    }
}
