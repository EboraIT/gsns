package com.eborait.gsns.presentacion;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelMain extends JPanel {
	private JPanel contentPane;
	/**
	 * Create the panel.
	 */
	public PanelMain(final Main frame) {
		setLayout(null);

		JLabel lblMensajeBienvenida = new JLabel("¡Bienvenido!");
		lblMensajeBienvenida.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMensajeBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensajeBienvenida.setBounds(229, 23, 470, 30);
		add(lblMensajeBienvenida);

		JLabel lblMensajeDescripcion = new JLabel("Este es el programa de gestión del Sistema Nacional de Salud.");
		lblMensajeDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMensajeDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensajeDescripcion.setBounds(229, 60, 470, 30);
		add(lblMensajeDescripcion);

		JLabel lblMensajeMenu = new JLabel("Selecciona una opción:");
		lblMensajeMenu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMensajeMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensajeMenu.setBounds(229, 115, 470, 30);
		add(lblMensajeMenu);

		JButton btnConsultarEstadisticas = new JButton("Consultar estadadisticas");
		btnConsultarEstadisticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.cambiarPanel(new PantallaConsultaEstadisticas(frame));
			}
		});
		btnConsultarEstadisticas.setBounds(64, 211, 209, 38);
		btnConsultarEstadisticas.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(btnConsultarEstadisticas);

		JButton btnGestionSNS = new JButton("Gestion Sistema Nacional de Salud");
		btnGestionSNS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.cambiarPanel(new PantallaGestionSistemSaludNacional(frame));
			}
		});
		btnGestionSNS.setBounds(337, 211, 209, 38);
		btnGestionSNS.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(btnGestionSNS);

		JButton btnGestionSRS = new JButton("Gestión Sistema Regional de Salud");
		btnGestionSRS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.cambiarPanel(new PantallaGestionSistemaRegionalSalud(frame));
			}
		});
		btnGestionSRS.setBounds(610, 211, 209, 38);
		btnGestionSRS.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(btnGestionSRS);
	}
}
