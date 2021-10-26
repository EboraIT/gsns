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
import javax.swing.SwingConstants;

public class PantallaConsultaEstadisticas extends JPanel {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
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
		btnTotalVacunados.setBounds(10, 45, 227, 58);
		contentPane.add(btnTotalVacunados);
		
		JButton btnTotalVacunadosRegion = new JButton("Total Vacunados por Regionn");
		btnTotalVacunadosRegion.setBounds(422, 45, 227, 58);
		contentPane.add(btnTotalVacunadosRegion);
		
		JButton btnPorcentajeVacunados = new JButton("Porcentaje Vacunados");
		btnPorcentajeVacunados.setBounds(10, 167, 227, 58);
		contentPane.add(btnPorcentajeVacunados);
		
		JButton btnPorcentajeVacunadosRegion = new JButton("Porcentaje Vacunados por Region");
		btnPorcentajeVacunadosRegion.setBounds(422, 167, 227, 58);
		contentPane.add(btnPorcentajeVacunadosRegion);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(560, 286, 89, 23);
		contentPane.add(btnAtras);
	}

}
