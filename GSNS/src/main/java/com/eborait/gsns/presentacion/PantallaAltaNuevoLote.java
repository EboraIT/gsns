package com.eborait.gsns.presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
<<<<<<< HEAD
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
=======
>>>>>>> branch 'Presentation' of git@github.com:escolanojorge/eborait.git

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.eborait.gsns.dominio.entitymodel.excepciones.GSNSException;

public class PantallaAltaNuevoLote extends JPanel {
	private JTextField textField;
	private JPanel contentPane;
	private JTextField txtIdentificador;
	private JTextField txtFechaAlta;
	private JTextField txtCantidad;
	private JTextField txtNombreVacuna;
	private JTextField txtFarmaceutica;
	private JTextField txtFechaAprobacion;

	public PantallaAltaNuevoLote(final Main frame) {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BorderLayout(0, 0));

		JPanel topPanel = new JPanel();
		add(topPanel, BorderLayout.NORTH);
		topPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));

		JPanel midPanel = new JPanel();
		add(midPanel, BorderLayout.CENTER);
<<<<<<< HEAD
		
		JButton btnVolver = new JButton("Volver al menú principal");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.cambiarPanel(frame.getPanelMain());
			}
		});
		topPanel.add(btnVolver);
		
		JLabel lblTitulo = new JLabel("Alta Nuevo Lote");
=======

		JButton btnVolver = new JButton("Volver al menú principal");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.cambiarPanel(frame.getPanelMain());
			}
		});
		topPanel.add(btnVolver);

		JLabel lblTitulo = new JLabel("Gestión Sistema Nacional de Salud/Alta nuevo lote de vacunas");
>>>>>>> branch 'Presentation' of git@github.com:escolanojorge/eborait.git
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		topPanel.add(lblTitulo);
		midPanel.setLayout(null);
<<<<<<< HEAD
		
		JLabel lblNewLabel = new JLabel("Identificador Lote:");
		lblNewLabel.setBounds(10, 69, 97, 14);
		midPanel.add(lblNewLabel);
		
		txtIdentificador = new JTextField();
		txtIdentificador.setBounds(117, 66, 86, 20);
		midPanel.add(txtIdentificador);
		txtIdentificador.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha Alta:");
		lblNewLabel_1.setBounds(10, 109, 97, 14);
		midPanel.add(lblNewLabel_1);
		
		txtFechaAlta = new JTextField();
		txtFechaAlta.setBounds(117, 106, 86, 20);
		midPanel.add(txtFechaAlta);
		txtFechaAlta.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Cantidad de Vacunas:");
		lblNewLabel_2.setBounds(10, 153, 116, 14);
		midPanel.add(lblNewLabel_2);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(117, 150, 86, 20);
		midPanel.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre de Vacuna:");
		lblNewLabel_3.setBounds(237, 64, 116, 14);
		midPanel.add(lblNewLabel_3);
		
		txtNombreVacuna = new JTextField();
		txtNombreVacuna.setBounds(344, 61, 86, 20);
		midPanel.add(txtNombreVacuna);
		txtNombreVacuna.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Farmaceutica:");
		lblNewLabel_4.setBounds(237, 110, 116, 14);
		midPanel.add(lblNewLabel_4);
		
		txtFarmaceutica = new JTextField();
		txtFarmaceutica.setBounds(344, 107, 86, 20);
		midPanel.add(txtFarmaceutica);
		txtFarmaceutica.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Fecha de Aprobación:");
		lblNewLabel_5.setBounds(237, 156, 116, 14);
		midPanel.add(lblNewLabel_5);
		
		txtFechaAprobacion = new JTextField();
		txtFechaAprobacion.setBounds(344, 153, 86, 20);
		midPanel.add(txtFechaAprobacion);
		txtFechaAprobacion.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("LOTE");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(10, 30, 46, 14);
		midPanel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Vacuna");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7.setBounds(237, 32, 73, 14);
		midPanel.add(lblNewLabel_7);
		
		JButton btnAlta = new JButton("Confirmar Alta");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarLote(frame);;
			}
		});
		btnAlta.setBounds(10, 223, 420, 23);
		midPanel.add(btnAlta);
=======
>>>>>>> branch 'Presentation' of git@github.com:escolanojorge/eborait.git
		
	}

	/*
	 * 
	 */
	protected void registrarLote(Main frame) {
		if(validar()) {
			try {
				
				frame.getGestorRepartoVacunas().altaNuevoLoteVacunas(txtIdentificador.getText(),ParseFecha(txtFechaAlta.getText()),Integer.parseInt(txtCantidad.getText()),
						txtNombreVacuna.getText(),txtFarmaceutica.getText(),txtFechaAprobacion.getText());
			} catch (GSNSException gsnse) {
				JOptionPane.showMessageDialog(frame, gsnse.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(frame, "Rellena todos los campos.", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
		}
		
	}
	
	/**
	 * Valida los campos de texto .
	 * 
	 * @return true si la validación es correcta, false de lo contrario. 
	 */
	private boolean validar() {
		JTextField[] textFields = { txtIdentificador,txtFechaAlta,txtCantidad,txtNombreVacuna,txtFarmaceutica,txtFechaAprobacion };
		for (JTextField jTextField : textFields) {
			if (jTextField.getText().length() == 0)
				return false;
		}
		return true;
	}
	
	/*
	 * Convierte un String en fecha(Date)
	 * @param fecha que pasas como cadena dd/MM/yyyy
	 * @return Objeto date
	 */
	public static Date ParseFecha(String fecha) {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date fechaDate = null;
		try {
			fechaDate = formato.parse(fecha);
		}
		catch (ParseException ex)
		{
			System.out.println(ex);
		}
		return fechaDate;
	}
}
