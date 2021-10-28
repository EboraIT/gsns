package com.eborait.gsns.presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

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
		
		JButton btnVolver = new JButton("Volver al menú principal");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.cambiarPanel(frame.getPanelMain());
			}
		});
		topPanel.add(btnVolver);
		
		JLabel lblTitulo = new JLabel("Alta Nuevo Lote");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		topPanel.add(lblTitulo);
		midPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Identificador Lote:");
		lblNewLabel.setBounds(10, 11, 97, 14);
		midPanel.add(lblNewLabel);
		
		txtIdentificador = new JTextField();
		txtIdentificador.setBounds(117, 8, 86, 20);
		midPanel.add(txtIdentificador);
		txtIdentificador.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha Alta:");
		lblNewLabel_1.setBounds(10, 51, 97, 14);
		midPanel.add(lblNewLabel_1);
		
		txtFechaAlta = new JTextField();
		txtFechaAlta.setBounds(117, 48, 86, 20);
		midPanel.add(txtFechaAlta);
		txtFechaAlta.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Cantidad de Vacunas:");
		lblNewLabel_2.setBounds(10, 95, 116, 14);
		midPanel.add(lblNewLabel_2);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(117, 92, 86, 20);
		midPanel.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre de Vacuna:");
		lblNewLabel_3.setBounds(10, 140, 116, 14);
		midPanel.add(lblNewLabel_3);
		
		txtNombreVacuna = new JTextField();
		txtNombreVacuna.setBounds(117, 137, 86, 20);
		midPanel.add(txtNombreVacuna);
		txtNombreVacuna.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Farmaceutica:");
		lblNewLabel_4.setBounds(10, 186, 116, 14);
		midPanel.add(lblNewLabel_4);
		
		txtFarmaceutica = new JTextField();
		txtFarmaceutica.setBounds(117, 183, 86, 20);
		midPanel.add(txtFarmaceutica);
		txtFarmaceutica.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Fecha de Aprobación:");
		lblNewLabel_5.setBounds(10, 232, 116, 14);
		midPanel.add(lblNewLabel_5);
		
		txtFechaAprobacion = new JTextField();
		txtFechaAprobacion.setBounds(117, 229, 86, 20);
		midPanel.add(txtFechaAprobacion);
		txtFechaAprobacion.setColumns(10);
		
	}
}
