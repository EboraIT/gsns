package com.eborait.gsns.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.eborait.gsns.dominio.entitymodel.excepciones.GSNSException;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.SpringLayout;

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
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);

		JPanel topPanel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, topPanel, 5, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, topPanel, 5, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, topPanel, 445, SpringLayout.WEST, this);
		add(topPanel);
		topPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));

		JLabel lblTitulo = new JLabel("Consultar Estadisticas");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		topPanel.add(lblTitulo);

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
				totalVacunados(frame);
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnTotalVacunados, 37, SpringLayout.SOUTH, topPanel);
		springLayout.putConstraint(SpringLayout.WEST, btnTotalVacunados, 0, SpringLayout.WEST, topPanel);
		add(btnTotalVacunados);
		
		JButton btnVacunadosPorRegion = new JButton("Total Vacunados por región");
		springLayout.putConstraint(SpringLayout.NORTH, btnVacunadosPorRegion, 29, SpringLayout.SOUTH, btnTotalVacunados);
		springLayout.putConstraint(SpringLayout.WEST, btnVacunadosPorRegion, 0, SpringLayout.WEST, topPanel);
		add(btnVacunadosPorRegion);
		
		JLabel lblNewLabel = new JLabel("Vacunados 1 Dosis:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 4, SpringLayout.NORTH, btnTotalVacunados);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Vacunados Pauta Completa:");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -5, SpringLayout.EAST, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 116, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 73, SpringLayout.EAST, btnVacunadosPorRegion);
		add(lblNewLabel_1);
		
		JButton btnPorcentaje = new JButton("Porcentaje Vacunados");
		springLayout.putConstraint(SpringLayout.WEST, btnPorcentaje, 0, SpringLayout.WEST, topPanel);
		add(btnPorcentaje);
		
		JButton btnPorcentajeRegion = new JButton("Porcentaje Vacunados por región");
		springLayout.putConstraint(SpringLayout.NORTH, btnPorcentajeRegion, 237, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, btnPorcentaje, -18, SpringLayout.NORTH, btnPorcentajeRegion);
		springLayout.putConstraint(SpringLayout.WEST, btnPorcentajeRegion, 0, SpringLayout.WEST, topPanel);
		btnPorcentajeRegion.setHorizontalAlignment(SwingConstants.RIGHT);
		add(btnPorcentajeRegion);
		
		JLabel lblVacuVacunados = new JLabel("% Vacunados 1 Dosis:");
		springLayout.putConstraint(SpringLayout.WEST, lblVacuVacunados, 0, SpringLayout.WEST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, lblVacuVacunados, -64, SpringLayout.SOUTH, this);
		add(lblVacuVacunados);
		
		JLabel lblNewLabel_1_1 = new JLabel("% Vacunados Pauta Completa:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1, 4, SpringLayout.NORTH, btnPorcentajeRegion);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1_1, 46, SpringLayout.EAST, btnPorcentajeRegion);
		add(lblNewLabel_1_1);

	}

	private void totalVacunados(Main frame) {
		
			try {
				frame.getGestorEstadisticas().consultarTotalVacunados();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(frame, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		
	}

}