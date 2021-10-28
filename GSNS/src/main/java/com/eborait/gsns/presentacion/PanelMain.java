package com.eborait.gsns.presentacion;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Pantalla principal de la aplicación.
 * 
 * @author Jorge Fernández Escolano
 * @author Roberto Esteban Olivares
 * @since 1.0
 * @version 1.0
 *
 */
public class PanelMain extends JPanel {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Crea el panel.
	 * 
	 * @param frame JFrame de la aplicación.
	 */
	public PanelMain(final Main frame) {
		setLayout(null);

		JLabel lblMensajeBienvenida = new JLabel("¡Bienvenido!");
		lblMensajeBienvenida.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMensajeBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensajeBienvenida.setBounds(215, 23, 470, 30);
		add(lblMensajeBienvenida);

		JLabel lblMensajeDescripcion = new JLabel("Este es el programa de gestión del Sistema Nacional de Salud.");
		lblMensajeDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMensajeDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensajeDescripcion.setBounds(215, 60, 470, 30);
		add(lblMensajeDescripcion);

		JLabel lblMensajeMenu = new JLabel("Selecciona una opción:");
		lblMensajeMenu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMensajeMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensajeMenu.setBounds(215, 115, 470, 30);
		add(lblMensajeMenu);

		JButton btnConsultarEstadisticas = new JButton("Consultar estadadísticas");
		btnConsultarEstadisticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.cambiarPanel(new PantallaConsultaEstadisticas(frame));
			}
		});
		btnConsultarEstadisticas.setBounds(68, 211, 209, 38);
		btnConsultarEstadisticas.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(btnConsultarEstadisticas);

		JButton btnGestionSNS = new JButton("Gestion Sistema Nacional de Salud");
		btnGestionSNS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.cambiarPanel(new PantallaGestionSistemaNacionalSalud(frame));
			}
		});
		btnGestionSNS.setBounds(345, 211, 209, 38);
		btnGestionSNS.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(btnGestionSNS);

		JButton btnGestionSRS = new JButton("Gestión Sistema Regional de Salud");
		btnGestionSRS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.cambiarPanel(new PantallaGestionSistemaRegionalSalud(frame));
			}
		});
		btnGestionSRS.setBounds(622, 211, 209, 38);
		btnGestionSRS.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(btnGestionSRS);
		
		
	}
}
