package com.eborait.gsns.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class PantallaGestionSistemaRegionalSalud extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaGestionSistemaRegionalSalud frame = new PantallaGestionSistemaRegionalSalud();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PantallaGestionSistemaRegionalSalud() {
		setTitle("Gesti\u00F3n Sistema Regional de Salud");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(563, 287, 89, 23);
		contentPane.add(btnAtras);
		
		JButton btnAltaEntregas = new JButton("Alta Entrega Vacunas");
		btnAltaEntregas.setBounds(92, 130, 153, 42);
		contentPane.add(btnAltaEntregas);
		
		JButton btnRegistrarVacunacion = new JButton("RegistrarVacunacion");
		btnRegistrarVacunacion.setBounds(411, 130, 153, 42);
		contentPane.add(btnRegistrarVacunacion);
	}

}
