package com.eborait.gsns.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class PantallaGestionSistemSaludNacional extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public PantallaGestionSistemSaludNacional(final Main frame) {
		setTitle("Gesti\u00F3n Sistema de Salud Nacional");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JButton btnAltaNuevoLote = new JButton("Alta Nuevo Lote");
		btnAltaNuevoLote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.cambiarPanel(new PantallaAltaNuevoLote(frame));
			}
		});
		btnAltaNuevoLote.setBounds(60, 104, 175, 45);
		contentPane.add(btnAltaNuevoLote);
		
		JButton btnCalculoEntrega = new JButton("Calculo Entrega");
		btnCalculoEntrega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.cambiarPanel(new PantallaCalculoEntrega(frame));
			}
		});
		btnCalculoEntrega.setBounds(427, 104, 175, 45);
		contentPane.add(btnCalculoEntrega);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(563, 287, 89, 23);
		contentPane.add(btnAtras);
	}
}
