package com.eborait.gsns.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class PantallaGestionSistemaNacionalSalud extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaGestionSistemaNacionalSalud frame = new PantallaGestionSistemaNacionalSalud();
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
	public PantallaGestionSistemaNacionalSalud(final Main frame) {
		setTitle("Gestion Sistema de Salud Nacional");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAltaNuevoLote = new JButton("Alta Nuevo Lote");
		btnAltaNuevoLote.setBounds(60, 104, 175, 45);
		contentPane.add(btnAltaNuevoLote);
		
		JButton btnCalculoEntrega = new JButton("Calculo Entrega");
		btnCalculoEntrega.setBounds(427, 104, 175, 45);
		contentPane.add(btnCalculoEntrega);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(563, 287, 89, 23);
		contentPane.add(btnAtras);
	}
}
