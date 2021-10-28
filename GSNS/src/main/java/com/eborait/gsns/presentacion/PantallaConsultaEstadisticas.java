package com.eborait.gsns.presentacion;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.eborait.gsns.dominio.entitymodel.RegionEnum;
import com.eborait.gsns.dominio.entitymodel.excepciones.GSNSException;

public class PantallaConsultaEstadisticas extends JPanel {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> comboRegion;
	private JLabel lblTotalVacPrimeraDosis;
	private JLabel lblTotalVacSegundaDosis;
	private JLabel lblDosisAdministradas;
	private JLabel lblVacunadosRegionPrimera;
	private JLabel lblTotalVacunadosRegionSegunda;
	private JLabel lblTotalDosisAdministradasRegion;

	/**
	 * Crea el panel.
	 * 
	 * @param frame JFrame de la aplicación.
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
				try {
					int total2=totalVacunados(frame);
					int total3=totalVacunadosSegunda(frame);
					int total=total2+total3;
					lblTotalVacPrimeraDosis.setText(lblTotalVacPrimeraDosis.getText()+String.valueOf(total2));
					lblTotalVacSegundaDosis.setText(lblTotalVacSegundaDosis.getText()+String.valueOf(total3));
					lblDosisAdministradas.setText(lblDosisAdministradas.getText()+total);
				} catch (GSNSException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnTotalVacunados, 37, SpringLayout.SOUTH, topPanel);
		springLayout.putConstraint(SpringLayout.WEST, btnTotalVacunados, 0, SpringLayout.WEST, topPanel);
		add(btnTotalVacunados);
		
		JButton btnVacunadosPorRegion = new JButton("Total Vacunados por región");
		springLayout.putConstraint(SpringLayout.NORTH, btnVacunadosPorRegion, 29, SpringLayout.SOUTH, btnTotalVacunados);
		springLayout.putConstraint(SpringLayout.WEST, btnVacunadosPorRegion, 0, SpringLayout.WEST, topPanel);
		add(btnVacunadosPorRegion);
		
		lblTotalVacPrimeraDosis = new JLabel("Total Vacunados Primera Dosis:");
		springLayout.putConstraint(SpringLayout.NORTH, lblTotalVacPrimeraDosis, 17, SpringLayout.SOUTH, topPanel);
		springLayout.putConstraint(SpringLayout.WEST, lblTotalVacPrimeraDosis, 153, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, lblTotalVacPrimeraDosis, -124, SpringLayout.EAST, this);
		add(lblTotalVacPrimeraDosis);
		
		lblVacunadosRegionPrimera = new JLabel("Total Vacunados Region Primera Dosis:");
		springLayout.putConstraint(SpringLayout.WEST, lblVacunadosRegionPrimera, 19, SpringLayout.EAST, btnVacunadosPorRegion);
		add(lblVacunadosRegionPrimera);
		
		JButton btnPorcentaje = new JButton("Porcentaje Vacunados");
		springLayout.putConstraint(SpringLayout.WEST, btnPorcentaje, 0, SpringLayout.WEST, topPanel);
		add(btnPorcentaje);
		
		JButton btnPorcentajeRegion = new JButton("Porcentaje Vacunados por región");
		springLayout.putConstraint(SpringLayout.NORTH, btnPorcentajeRegion, 237, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, btnPorcentaje, -18, SpringLayout.NORTH, btnPorcentajeRegion);
		springLayout.putConstraint(SpringLayout.WEST, btnPorcentajeRegion, 0, SpringLayout.WEST, topPanel);
		btnPorcentajeRegion.setHorizontalAlignment(SwingConstants.RIGHT);
		add(btnPorcentajeRegion);
		
		JLabel lblVacuVacunados = new JLabel("% Vacunados:");
		springLayout.putConstraint(SpringLayout.WEST, lblVacuVacunados, 97, SpringLayout.EAST, btnPorcentaje);
		springLayout.putConstraint(SpringLayout.SOUTH, lblVacuVacunados, -64, SpringLayout.SOUTH, this);
		add(lblVacuVacunados);
		
		JLabel lblNewLabel_1_1 = new JLabel("% Vacunados  region:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1, 4, SpringLayout.NORTH, btnPorcentajeRegion);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1_1, 46, SpringLayout.EAST, btnPorcentajeRegion);
		add(lblNewLabel_1_1);

		comboRegion = new JComboBox<String>();
		comboRegion.setBounds(242, 176, 181, 20);
		add(comboRegion);
		
		lblTotalVacSegundaDosis = new JLabel("Total Vacunados Segunda Dosis:");
		springLayout.putConstraint(SpringLayout.NORTH, lblTotalVacSegundaDosis, 0, SpringLayout.NORTH, btnTotalVacunados);
		springLayout.putConstraint(SpringLayout.WEST, lblTotalVacSegundaDosis, 0, SpringLayout.WEST, lblTotalVacPrimeraDosis);
		add(lblTotalVacSegundaDosis);
		
		lblDosisAdministradas = new JLabel("Total Dosis Administradas:");
		springLayout.putConstraint(SpringLayout.NORTH, lblVacunadosRegionPrimera, 9, SpringLayout.SOUTH, lblDosisAdministradas);
		springLayout.putConstraint(SpringLayout.NORTH, lblDosisAdministradas, 6, SpringLayout.SOUTH, lblTotalVacSegundaDosis);
		springLayout.putConstraint(SpringLayout.WEST, lblDosisAdministradas, 0, SpringLayout.WEST, lblTotalVacPrimeraDosis);
		add(lblDosisAdministradas);
		
		lblTotalVacunadosRegionSegunda = new JLabel("Total Vacunados Region Segunda Dosis:");
		springLayout.putConstraint(SpringLayout.NORTH, lblTotalVacunadosRegionSegunda, 6, SpringLayout.SOUTH, lblVacunadosRegionPrimera);
		springLayout.putConstraint(SpringLayout.WEST, lblTotalVacunadosRegionSegunda, 0, SpringLayout.WEST, lblVacunadosRegionPrimera);
		add(lblTotalVacunadosRegionSegunda);
		
		lblTotalDosisAdministradasRegion = new JLabel("Total Dosis Administradas Region:");
		springLayout.putConstraint(SpringLayout.NORTH, lblTotalDosisAdministradasRegion, 6, SpringLayout.SOUTH, lblTotalVacunadosRegionSegunda);
		springLayout.putConstraint(SpringLayout.WEST, lblTotalDosisAdministradasRegion, 0, SpringLayout.WEST, lblVacunadosRegionPrimera);
		add(lblTotalDosisAdministradasRegion);
	}

	/*
	 * Metodo que invoca a consultar total vacunados con la segunda dosis
	 * 
	 * @param el Main frame
	 * 
	 * @return Devuelve un entero con el total de vacunados con segunda dosis.
	 */
	protected int totalVacunadosSegunda(Main frame) throws GSNSException {
		return frame.getGestorEstadisticas().consultarTotalVacunadosSegundaDosis();
	}

	/*
	 * Metodo que invoca a consultar total vacunados
	 * 
	 * @param el Main frame
	 * 
	 * @return Devuelve un entero con el total.
	 */
	private int totalVacunados(Main frame) throws GSNSException {
		return frame.getGestorEstadisticas().consultarTotalVacunadosPrimeraDosis();

	}
}