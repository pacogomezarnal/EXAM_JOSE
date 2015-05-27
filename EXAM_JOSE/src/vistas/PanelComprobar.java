package vistas;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Model.IngresoLaby;

public class PanelComprobar extends JPanel {
	
	private IngresoLaby ingresar;
	
	private JTextField textId, textApellido, textMensaje;
	private JButton btnComprobar, btnAtras;
	
	public PanelComprobar() {
		
		ingresar = new IngresoLaby();
		
		setName("Comprobacion");
		setSize(430, 350);
		setLayout(null);
		
		colocaComponentes();
	}
	
	private void consultaDatos() {
		int id = Integer.parseInt(textId.getText());
		String apellido = textApellido.getText();
		
	}
	
	/**
	 * cambia al panel Equipos
	 */
	private void cambiaPanelAnterior() {
		CardLayout cl = (CardLayout) VentanaPrincipal.getInstance().getContentPane().getLayout();
		cl.show(VentanaPrincipal.getInstance().getContentPane(), VentanaPrincipal.getInstance().getPanelEquipo().getName());
	}
	
	/**
	 * Coloca los componentes de la ventana
	 */
	private void colocaComponentes() {
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(34, 57, 46, 14);
		add(lblId);
		
		JLabel lblApellido = new JLabel("1er Apellido");
		lblApellido.setBounds(192, 57, 131, 14);
		add(lblApellido);
		
		textId = new JTextField();
		textId.setBounds(34, 82, 86, 20);
		add(textId);
		textId.setColumns(10);
		
		textApellido = new JTextField();
		textApellido.setBounds(192, 82, 118, 20);
		add(textApellido);
		textApellido.setColumns(10);
		
		btnComprobar = new JButton("Comprobar");
		btnComprobar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				consultaDatos();
			}
		});
		btnComprobar.setBounds(34, 129, 362, 23);
		add(btnComprobar);
		
		textMensaje = new JTextField();
		textMensaje.setEditable(false);
		textMensaje.setBounds(34, 163, 362, 20);
		add(textMensaje);
		textMensaje.setColumns(10);
		
		btnAtras = new JButton("Atras");
		btnAtras.setBounds(165, 225, 89, 23);
		add(btnAtras);
		btnAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cambiaPanelAnterior();
			}
		});
	}
}
