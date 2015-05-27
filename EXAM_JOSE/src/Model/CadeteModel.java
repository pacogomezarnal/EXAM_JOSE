package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class CadeteModel {

	private final String ID = "id";
	private final String NOM = "nombre";
	private final String APELL = "apellidos";
	private final String EDAD = "edad";
	private final String NAC = "nacionalidad";
	private final String EQ = "equipo";
	
	private Connection conexion;
	private ResultSet resultado;
	private Statement statement;
	
	public CadeteModel() {

		conexion = ConexionDB.getConexion();
	}
	
	public Cadete consultaCadete(int idCadete) {
		Cadete c = new Cadete();
		try {
			statement = conexion.createStatement();
			resultado = statement.executeQuery("select * from cadetes where id = "+idCadete+";");
			while (resultado.next()) {
				c.setId(resultado.getInt(ID));
				c.setNombre(resultado.getString(NOM));
				c.setApellidos(resultado.getString(APELL));
				c.setEdad(resultado.getInt(EDAD));
				c.setNacionalidad(resultado.getString(NAC));
				c.setEquipo(resultado.getInt(EQ));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
				resultado.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return c;
	}
	
	public ArrayList<Cadete> consutaCadetesEquipo(int idEquipo) { 
		ArrayList<Cadete> cadetes = new ArrayList<Cadete>();
		try {
			statement = conexion.createStatement();
			resultado = statement.executeQuery("select * from cadetes where equipo = "+idEquipo+";");
			while (resultado.next()) {
				
				int id = resultado.getInt(ID);
				String nom = resultado.getString(NOM);
				String apell = resultado.getString(APELL);
				int edad = resultado.getInt(EDAD);
				String nac = resultado.getString(NAC);
				int eq = resultado.getInt(EQ);
				
				Cadete c = new Cadete(id, nom, apell, edad, nac, eq);
				
				cadetes.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close(); 
				resultado.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cadetes;
	}

}
