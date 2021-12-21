package com.eborait.gsns.presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * Pantalla de gestión del Sistema Regional de Salud.
 *
 * @author Jorge Fernández Escolano
 * @author Roberto Esteban Olivares
 * @version 1.0
 * @since 1.0
 */
public class PantallaGestionSistemaRegionalSalud extends PanelBase {

	/** El serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Crea el panel.
	 * 
	 * @param frame JFrame de la aplicación.
	 */
	public PantallaGestionSistemaRegionalSalud(final Main frame) {
		super(frame, "Gestión Sistema Regional de Salud");

		JButton btnAltaEntregas = new JButton("Alta entrega vacunas");
		btnAltaEntregas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.cambiarPanel(new PantallaAltaEntregaVacunas(frame));
			}
		});
		btnAltaEntregas.setBounds(546, 167, 158, 47);

		JButton btnRegistrarVacunacion = new JButton("Registrar vacunación");
		btnRegistrarVacunacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.cambiarPanel(new PantallaRegistrarVacunacion(frame));
			}
		});
		btnRegistrarVacunacion.setBounds(185, 167, 176, 47);
		midPanel.setLayout(null);
		midPanel.add(btnAltaEntregas);
		midPanel.add(btnRegistrarVacunacion);
	}

}
