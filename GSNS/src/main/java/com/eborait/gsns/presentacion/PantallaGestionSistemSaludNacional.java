package com.eborait.gsns.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class PantallaGestionSistemSaludNacional extends JPanel {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public PantallaGestionSistemSaludNacional(final Main frame) {
		
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BorderLayout(0, 0));
		
		JPanel topPanel = new JPanel();
		add(topPanel, BorderLayout.NORTH);
		topPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
		
		JPanel midPanel = new JPanel();
		add(midPanel, BorderLayout.CENTER);
		
		JButton btnCalculoEntrega = new JButton("Calculo de Entrega");
		btnCalculoEntrega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.cambiarPanel(new PantallaCalculoEntrega(frame));
			}
		});
		midPanel.add(btnCalculoEntrega);
		
		JButton btnAltaNuevoLote = new JButton("Alta Nuevo Lote");
		btnAltaNuevoLote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.cambiarPanel(new PantallaAltaNuevoLote(frame));
			}
		});
		midPanel.add(btnAltaNuevoLote);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.cambiarPanel(frame.getPanelMain());
			}
		});
		topPanel.add(btnVolver);
		
		JLabel lblTitulo = new JLabel("Gestión Sistema Regional de Salud");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		topPanel.add(lblTitulo);
		
		
		
		
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(563, 287, 89, 23);
		contentPane.add(btnAtras);
	}
}
