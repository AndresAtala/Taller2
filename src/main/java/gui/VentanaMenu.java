package gui;

import controller.SeleccionController;
import model.data.DBConnector;
import model.data.DBGenerator;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class VentanaMenu {
    private JFrame frame;
    private JPanel panel;

    public VentanaMenu(SeleccionController controller) {
        frame = new JFrame("Ventana con botones");
        panel = new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        agregarBotones(controller);
        agregarSalir();

        frame.add(panel);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    private void agregarBotones(SeleccionController controller) {
        JButton agregarSeleccion = new JButton("Agregar Selección");
        JButton buscarSeleccion = new JButton("Buscar Selección");
        JButton agregarJugador = new JButton("Agregar Jugador");
        JButton buscarJugador = new JButton("Buscar Jugador");

        panel.add(agregarSeleccion);
        panel.add(buscarSeleccion);
        panel.add(agregarJugador);
        panel.add(buscarJugador);

        agregarJugador.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VentanaAgregarJugador ventanaAgregarJugador = new VentanaAgregarJugador(controller);
            }
        });

        buscarJugador.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VentanaBuscarJugador ventanaBuscarJugador = new VentanaBuscarJugador(controller);
            }
        });

        agregarSeleccion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VentanaAgregarSeleccion ventanaAgregarSeleccion = new VentanaAgregarSeleccion(controller);
            }
        });

        buscarSeleccion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VentanaBuscarSeleccion ventanaBuscarSeleccion = new VentanaBuscarSeleccion(controller);
            }
        });
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
        String nombreBD = "BD";
        String usuario = "root";
        String password = "";
        DSLContext query = DBConnector.createDSLContext(nombreBD, usuario, password);
        DBGenerator.iniciarBD(nombreBD);

        SeleccionController controller = new SeleccionController(query);
        VentanaMenu ventanaMenu = new VentanaMenu(controller);
    }

}
