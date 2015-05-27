package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class IngresoLaby {
	//CONSULTA A LA BASE DE DATOS
	private final static String CHECK_SEL="SELECT cod FROM cod WHERE id=";
	private final static String COD_COL="cod";
	
	//Conexion
	private Connection conexion = null;// maneja la conexió
	private Statement instruccion = null;
	private ResultSet conjuntoResultados = null;

	public IngresoLaby() {
		//Obtenemos la conexion de datos
		conexion=ConexionDB.getConexion();		
	}

}
