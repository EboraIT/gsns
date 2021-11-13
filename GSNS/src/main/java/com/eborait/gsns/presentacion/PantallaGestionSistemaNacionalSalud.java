package com.eborait.gsns.presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * Pantalla de gestión del Sistema Nacional de Salud.
 *
 * @author Jorge Fernández Escolano
 * @author Roberto Esteban Olivares
 * @version 1.0
 * @since 1.0
 */
public class PantallaGestionSistemaNacionalSalud extends PanelBase {

	/** El serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Crea el panel.
	 * 
	 * @param frame JFrame de la aplicación.
	 */
	public PantallaGestionSistemaNacionalSalud(final Main frame) {
		super(frame, "Gestión Sistema Nacional de Salud");
		
		JButton btnAltaNuevoLote = new JButton("Alta nuevo lote de vacunas");
		btnAltaNuevoLote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.cambiarPanel(new PantallaAltaNuevoLote(frame));
			}
		});
		btnAltaNuevoLote.setBounds(185, 167, 176, 47);
		midPanel.add(btnAltaNuevoLote);

		JButton btnCalculoEntrega = new JButton("Cálculo de entrega");
		btnCalculoEntrega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.cambiarPanel(new PantallaCalculoEntrega(frame));
			}
		});
		btnCalculoEntrega.setBounds(546, 167, 158, 47);
		midPanel.add(btnCalculoEntrega);
	}
}
