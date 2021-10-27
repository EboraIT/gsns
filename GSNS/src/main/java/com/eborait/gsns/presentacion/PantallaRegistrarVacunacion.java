package com.eborait.gsns.presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JList;

public class PantallaRegistrarVacunacion extends JPanel {
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textDNI;
	private JTextField textFecha;

	public PantallaRegistrarVacunacion(final Main frame) {
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

		JLabel lblTitulo = new JLabel("Gestión Sistema Regional de Salud/Registro de Vacunacion");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		topPanel.add(lblTitulo);
		midPanel.setLayout(null);
		
		textNombre = new JTextField();
		textNombre.setBounds(59, 36, 86, 20);
		midPanel.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(3, 39, 46, 14);
		midPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Apellidos:");
		lblNewLabel_1.setBounds(3, 83, 46, 14);
		midPanel.add(lblNewLabel_1);
		
		textApellidos = new JTextField();
		textApellidos.setBounds(59, 80, 86, 20);
		midPanel.add(textApellidos);
		textApellidos.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("DNI:");
		lblNewLabel_2.setBounds(3, 129, 46, 14);
		midPanel.add(lblNewLabel_2);
		
		textDNI = new JTextField();
		textDNI.setBounds(59, 126, 86, 20);
		midPanel.add(textDNI);
		textDNI.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Tipo Vacuna:");
		lblNewLabel_3.setBounds(217, 39, 69, 14);
		midPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Fecha:");
		lblNewLabel_4.setBounds(3, 176, 46, 14);
		midPanel.add(lblNewLabel_4);
		
		textFecha = new JTextField();
		textFecha.setBounds(59, 173, 86, 20);
		midPanel.add(textFecha);
		textFecha.setColumns(10);
		
		JButton btnRegistrarVacunacion = new JButton("Registrar Vacunacion");
		btnRegistrarVacunacion.setBounds(3, 223, 427, 23);
		midPanel.add(btnRegistrarVacunacion);
		
	}
}
