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

import com.eborait.gsns.dominio.entitymodel.excepciones.GSNSException;

public class PantallaGestionSistemaNacionalSalud extends JPanel {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Crea el panel.
	 * 
	 * @param frame JFrame de la aplicación.
	 * @throws GSNSException Si se produce una excepción de la aplicación.
	 */
	public PantallaGestionSistemaNacionalSalud(final Main frame) {
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

		JLabel lblTitulo = new JLabel("Gestión Sistema Nacional de Salud");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		topPanel.add(lblTitulo);
		midPanel.setLayout(null);

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

		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(563, 287, 89, 23);
		add(btnAtras);
	}
}
