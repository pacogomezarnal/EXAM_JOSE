import Model.ConexionDB;
import vistas.VentanaPrincipal;


public class Main {

	public static void main(String[] args) {
		
		boolean conect = ConexionDB.getInstance().connectDB();
		if (conect) {
			VentanaPrincipal.getInstance();
		}
		else {
			System.out.println("NO SE PUDO CONECTAR");
		}
	}

}
