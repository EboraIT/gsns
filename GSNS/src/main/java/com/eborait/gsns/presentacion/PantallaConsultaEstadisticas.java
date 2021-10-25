package com.eborait.gsns.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class PantallaConsultaEstadisticas extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaConsultaEstadisticas frame = new PantallaConsultaEstadisticas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param frame 
	 */
	public PantallaConsultaEstadisticas(final Main frame) {
		setTitle("Consulta de Estadisticas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnTotalVacunados = new JButton("Total Vacunados");
		btnTotalVacunados.setBounds(10, 45, 227, 58);
		contentPane.add(btnTotalVacunados);
		
		JButton btnTotalVacunadosRegion = new JButton("Total Vacunados por Regi\u00F3n");
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
