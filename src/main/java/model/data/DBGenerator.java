package model.data;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.jooq.impl.DSL.foreignKey;
import static org.jooq.impl.DSL.primaryKey;
import static org.jooq.impl.SQLDataType.INTEGER;
import static org.jooq.impl.SQLDataType.VARCHAR;

public class DBGenerator {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void iniciarBD(String nombreBD) {
        DSLContext create = DBConnector.createDSLContext("", USERNAME, PASSWORD);
        crearBaseDato(create, nombreBD);
        create = DBConnector.createDSLContext(nombreBD, USERNAME, PASSWORD);
        crearTablaSeleccion(create);
        crearTablaJugadores(create);
    }

    private static Connection conectarBaseDatos() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/";
        return DriverManager.getConnection(url, USERNAME, PASSWORD);
    }

    private static void crearBaseDato(DSLContext create, String nombreBD) {
        create.createDatabaseIfNotExists(nombreBD).execute();
    }

    private static DSLContext actualizarConexion(Connection connection, String nombreBD) throws SQLException {
        DBConnector.closeConnection(connection);
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + nombreBD, USERNAME, PASSWORD);
        return DSL.using(connection);
    }

    private static void crearTablaSeleccion(DSLContext create) {
        create.createTableIfNotExists("seleccion")
                .column("ID", INTEGER)
                .column("nombre", VARCHAR(100))
                .column("ranking fifa", INTEGER)
                .column("bandera", VARCHAR(100))
                .constraint(primaryKey("ID"))
                .execute();
    }

    private static void crearTablaJugadores(DSLContext create) {
        create.createTableIfNotExists("jugador")
                .column("nombre", VARCHAR(100))
                .column("Numero", INTEGER)
                .column("posicion", VARCHAR(100))
                .column("seleccion", VARCHAR(100))
                .constraint(primaryKey("nombre"))
                .execute();
    }

    private static void relacionarTabla(DSLContext create, String nombreTabla, String claveForanea, String nombreTablaRelacion) {
        create.alterTableIfExists(nombreTabla)
                .alterConstraint(foreignKey(claveForanea)
                        .references(nombreTablaRelacion))
                .enforced();
    }
}