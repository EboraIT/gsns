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

import com.eborait.gsns.dominio.entitymodel.excepciones.GSNSException;

import javax.swing.JButton;
import javax.swing.SwingConstants;

public class PantallaConsultaEstadisticas extends JPanel {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * 
	 * @param frame
	 */
	public PantallaConsultaEstadisticas(final Main frame) {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BorderLayout(0, 0));

		JPanel topPanel = new JPanel();
		add(topPanel, BorderLayout.NORTH);
		topPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));

		JLabel lblTitulo = new JLabel("Consultar Estadisticas");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		topPanel.add(lblTitulo);

		JPanel midPanel = new JPanel();
		add(midPanel, BorderLayout.CENTER);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.cambiarPanel(frame.getPanelMain());
			}
		});
		topPanel.add(btnVolver);

		JButton btnTotalVacunados = new JButton("Total Vacunados");
		btnTotalVacunados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// frame.cambiarPanel(new TotalVacunados(frame));
			}
		});
		btnTotalVacunados.setBounds(10, 45, 227, 58);
		midPanel.add(btnTotalVacunados);

		JButton btnTotalVacunadosRegion = new JButton("Total Vacunados por Region");
		btnTotalVacunadosRegion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// frame.cambiarPanel(new TotalVacunados(frame));
			}
		});
		btnTotalVacunadosRegion.setBounds(422, 45, 227, 58);
		midPanel.add(btnTotalVacunadosRegion);

		JButton btnPorcentajeVacunados = new JButton("Porcentaje Vacunados");
		btnPorcentajeVacunados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// frame.cambiarPanel(new TotalVacunados(frame));
			}
		});
		btnPorcentajeVacunados.setBounds(10, 167, 227, 58);
		midPanel.add(btnPorcentajeVacunados);

		JButton btnPorcentajeVacunadosRegion = new JButton("Porcentaje Vacunados por Region");
		btnPorcentajeVacunadosRegion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// frame.cambiarPanel(new TotalVacunados(frame));
			}
		});
		btnPorcentajeVacunadosRegion.setBounds(422, 167, 227, 58);
		midPanel.add(btnPorcentajeVacunadosRegion);

	}

}
