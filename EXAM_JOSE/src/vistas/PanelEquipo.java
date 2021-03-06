package vistas;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

import Model.Cadete;
import Model.CadeteModel;

public class PanelEquipo extends JPanel {
	
	private static final int IDEQUIPO = 3;
	private CadeteModel modeloCadete;
	
	private JTextField textNombre, text1Apellido, text2Apellido, textNacionalidad, textId;
	private JButton btnAtras, btnSiguiente;
	private JComboBox<Cadete> boxEquipo;
	
	public PanelEquipo() {
		
		modeloCadete = new CadeteModel();
		
		setName("Equipo");
		setSize(430, 350);
		setLayout(null);
		
		colocaComponentes();
		cargaCadetes();
		
	}
	
	/**
	 * A�ade los Cadetes constultados al comboBox boxEquipo
	 */
	private void cargaCadetes() {
		boxEquipo.removeAll();
		ArrayList<Cadete> cadetes = modeloCadete.consutaCadetesEquipo(IDEQUIPO);
		// rellenamos el combo box
		for (Cadete c: cadetes) {
			boxEquipo.addItem(c);
		}
	}
	
	/**
	 * Coloca los datos del cadete seleccionado
	 * @param selectedIndex indice seleccionado del combo box
	 */
	private void muestraDatosCadete(int selectedIndex) {
		Cadete c = boxEquipo.getItemAt(selectedIndex);
		String[] apellidos = divideApellidos(c.getApellidos()); 
		textNombre.setText(c.getNombre());
		text1Apellido.setText(apellidos[0]);
		text2Apellido.setText(apellidos[1]);
		textNacionalidad.setText(c.getNacionalidad());
		textId.setText(c.getId()+"");
	}
	
	/**
	 * Separa los apellidos en dos strings diferentes
	 * @param apellidos string de los apellidos del cadete
	 * @return Array de 2 Strings con los apellidos separados
	 */
	private String[] divideApellidos(String apellidos) {
		String[] division = new String[2];
		int espacio = apellidos.indexOf(" ", 0);
		division[0] = apellidos.substring(0, espacio);
		division[1] = apellidos.substring(1+espacio);
		return division;
	}
	
	/**
	 * cambia al panel Comprobacion
	 */
	private void cambiaPanelSiguiente() {
		CardLayout cl = (CardLayout) VentanaPrincipal.getInstance().getContentPane().getLayout();// obtenemos el cardLayout
		cl.show(VentanaPrincipal.getInstance().getContentPane(), VentanaPrincipal.getInstance().getPanelComprobacion().getName());// mostramos el panel Comprobacion
	}
	
	/**
	 * cambia al panel Principal
	 */
	private void cambiaPanelAnterior() {
		CardLayout cl = (CardLayout) VentanaPrincipal.getInstance().getContentPane().getLayout();// obtenemos el cardLayout
		cl.show(VentanaPrincipal.getInstance().getContentPane(), VentanaPrincipal.getInstance().getPanelPrincipal().getName());// mostramos el panel Principal
	}
	
	/**
	 * Coloca los componentes de la ventana
	 */
	private void colocaComponentes() {
		
		JLabel lblEquipo = new JLabel("Equipo");
		lblEquipo.setBounds(10, 40, 46, 14);
		add(lblEquipo);
		
		boxEquipo = new JComboBox<Cadete>();
		boxEquipo.setBounds(10, 65, 110, 20);
		add(boxEquipo);
		boxEquipo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int sel = boxEquipo.getSelectedIndex();
				if (sel != -1){
					muestraDatosCadete(sel);
				}
			}
		});
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(165, 40, 46, 14);
		add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setBounds(165, 65, 86, 20);
		add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("1\u00BA Apellido");
		lblApellido.setBounds(165, 96, 86, 14);
		add(lblApellido);
		
		text1Apellido = new JTextField();
		text1Apellido.setEditable(false);
		text1Apellido.setBounds(165, 121, 86, 20);
		add(text1Apellido);
		text1Apellido.setColumns(10);
		
		JLabel lblApellido_1 = new JLabel("2\u00BA Apellido");
		lblApellido_1.setBounds(165, 152, 86, 14);
		add(lblApellido_1);
		
		text2Apellido = new JTextField();
		text2Apellido.setEditable(false);
		text2Apellido.setBounds(165, 177, 86, 20);
		add(text2Apellido);
		text2Apellido.setColumns(10);
		
		JLabel lblNacionalidad = new JLabel("Nacionalidad");
		lblNacionalidad.setBounds(165, 208, 86, 14);
		add(lblNacionalidad);
		
		textNacionalidad = new JTextField();
		textNacionalidad.setEditable(false);
		textNacionalidad.setBounds(165, 233, 86, 20);
		add(textNacionalidad);
		textNacionalidad.setColumns(10);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(313, 40, 46, 14);
		add(lblId);
		
		textId = new JTextField();
		textId.setEditable(false);
		textId.setBounds(302, 65, 86, 20);
		add(textId);
		textId.setColumns(10);
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setBounds(309, 288, 89, 23);
		add(btnSiguiente);
		btnSiguiente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cambiaPanelSiguiente();
			}
		});
		
		btnAtras = new JButton("Atras");
		btnAtras.setBounds(10, 288, 89, 23);
		add(btnAtras);
		btnAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cambiaPanelAnterior();
			}
		});
	}
}
