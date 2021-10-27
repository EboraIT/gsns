package com.eborait.gsns.presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaGestionSistemaRegionalSalud extends JPanel {

	/**
	 * Create the frame.
	 */
	public PantallaGestionSistemaRegionalSalud(final Main frame) {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BorderLayout(0, 0));

		JPanel topPanel = new JPanel();
		add(topPanel, BorderLayout.NORTH);
		topPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));

		JPanel midPanel = new JPanel();
		add(midPanel, BorderLayout.CENTER);

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

		JButton btnAltaEntregas = new JButton("Alta Entrega Vacunas");
		btnAltaEntregas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.cambiarPanel(new PantallaAltaEntregaVacunas(frame));
			}
		});
		btnAltaEntregas.setBounds(238, 114, 158, 47);

		JButton btnRegistrarVacunacion = new JButton("Registrar Vacunación");
		btnRegistrarVacunacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.cambiarPanel(new PantallaRegistrarVacunacion(frame));
			}
		});
		btnRegistrarVacunacion.setBounds(21, 114, 176, 47);
		midPanel.setLayout(null);
		midPanel.add(btnAltaEntregas);
		midPanel.add(btnRegistrarVacunacion);
	}

}
