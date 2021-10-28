package com.eborait.gsns.presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.eborait.gsns.dominio.entitymodel.RegionEnum;
import com.eborait.gsns.dominio.entitymodel.excepciones.GSNSException;
import javax.swing.BoxLayout;
import javax.swing.border.TitledBorder;
import java.awt.Component;

public class PantallaConsultaEstadisticas extends JPanel {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> comboTotalRegion;
	private JComboBox<String> comboPorcentajeRegion;
	private JLabel lblTotalVacPrimeraDosis;
	private JLabel lblTotalVacSegundaDosis;
	private JLabel lblTotalDosisAdministradas;
	private JLabel lblTotalVacunadosRegionPrimera;
	private JLabel lblTotalVacunadosRegionSegunda;
	private JLabel lblTotalDosisAdministradasRegion;
	private JLabel lblPorcentajePrimera;
	private JLabel lblPorcentajeCompletamente;
	private JLabel lblPorcentaje1Dosisregion;
	private JLabel lblPorcentajeDosisRegionCompleta;

	/**
	 * Crea el panel.
	 * 
	 * @param frame JFrame de la aplicación.
	 */
	public PantallaConsultaEstadisticas(final Main frame) {
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

		JLabel lblTitulo = new JLabel("Consulta estadísticas");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		topPanel.add(lblTitulo);

		JButton btnTotalVacunados = new JButton("Total vacunados");
		btnTotalVacunados.setBounds(10, 100, 139, 64);
		btnTotalVacunados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int totalPrimera = frame.getGestorEstadisticas().consultarTotalVacunadosPrimeraDosis();
					int totalSegunda = frame.getGestorEstadisticas().consultarTotalVacunadosSegundaDosis();
					int total = totalPrimera + totalSegunda;
					lblTotalVacPrimeraDosis.setText("Total vacunados (primera dosis): " + String.valueOf(totalPrimera));
					lblTotalVacSegundaDosis.setText("Total vacunados (segunda dosis): " + String.valueOf(totalSegunda));
					lblTotalDosisAdministradas.setText("Total dosis administradas: " + total);
				} catch (GSNSException gsnse) {
					JOptionPane.showMessageDialog(frame, gsnse.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		midPanel.setLayout(null);
		midPanel.add(btnTotalVacunados);

		lblTotalVacPrimeraDosis = new JLabel("Total vacunados (primera dosis):");
		lblTotalVacPrimeraDosis.setBounds(159, 100, 228, 14);
		midPanel.add(lblTotalVacPrimeraDosis);

		lblTotalVacSegundaDosis = new JLabel("Total vacunados (segunda dosis):");
		lblTotalVacSegundaDosis.setBounds(159, 125, 228, 14);
		midPanel.add(lblTotalVacSegundaDosis);

		lblTotalDosisAdministradas = new JLabel("Total dosis administradas:");
		lblTotalDosisAdministradas.setBounds(159, 150, 228, 14);
		midPanel.add(lblTotalDosisAdministradas);

		JButton btnVacunadosPorRegion = new JButton("Total vacunados por región");
		btnVacunadosPorRegion.setBounds(397, 132, 191, 32);
		btnVacunadosPorRegion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int totalPrimera = frame.getGestorEstadisticas()
							.consultarTotalVacunadosPorRegionPrimeraDosis(comboTotalRegion.getSelectedIndex() + 1);
					int totalSegunda = frame.getGestorEstadisticas()
							.consultarTotalVacunadosPorRegionSegundaDosis(comboTotalRegion.getSelectedIndex() + 1);
					int total = totalPrimera + totalSegunda;
					lblTotalVacunadosRegionPrimera
							.setText("Total vacunados por región (primera dosis): " + String.valueOf(totalPrimera));
					lblTotalVacunadosRegionSegunda
							.setText("Total vacunados por región (segunda dosis): " + String.valueOf(totalSegunda));
					lblTotalDosisAdministradasRegion.setText("Total dosis administradas por región: " + total);
				} catch (GSNSException gsnse) {
					JOptionPane.showMessageDialog(frame, gsnse.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		midPanel.add(btnVacunadosPorRegion);

		lblTotalVacunadosRegionPrimera = new JLabel("Total vacunados por región (primera dosis):");
		lblTotalVacunadosRegionPrimera.setBounds(598, 100, 282, 14);
		midPanel.add(lblTotalVacunadosRegionPrimera);

		lblTotalVacunadosRegionSegunda = new JLabel("Total vacunados por región (segunda dosis):");
		lblTotalVacunadosRegionSegunda.setBounds(598, 125, 282, 14);
		midPanel.add(lblTotalVacunadosRegionSegunda);

		lblTotalDosisAdministradasRegion = new JLabel("Total dosis administradas por región:");
		lblTotalDosisAdministradasRegion.setBounds(598, 150, 282, 14);
		midPanel.add(lblTotalDosisAdministradasRegion);

		JButton btnPorcentaje = new JButton("Porcentaje vacunados");
		btnPorcentaje.setBounds(10, 190, 139, 64);
		btnPorcentaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int porcentajePrimera = frame.getGestorEstadisticas()
							.consultarPorcentajeVacunadosSobreRecibidasPrimeraDosis();
					int porcentajeSegunda = frame.getGestorEstadisticas()
							.consultarPorcentajeVacunadosSobreRecibidasSegundaDosis();
					lblPorcentajePrimera.setText(
							"Porcentaje vacunados (primera dosis): " + String.valueOf(porcentajePrimera) + "%");
					lblPorcentajeCompletamente.setText(
							"Porcentaje vacunados (pauta completa): " + String.valueOf(porcentajeSegunda) + "%");
				} catch (GSNSException gsnse) {
					JOptionPane.showMessageDialog(frame, gsnse.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		midPanel.add(btnPorcentaje);

		lblPorcentajePrimera = new JLabel("Porcentaje vacunados (primera dosis):");
		lblPorcentajePrimera.setBounds(159, 194, 228, 14);
		midPanel.add(lblPorcentajePrimera);

		lblPorcentajeCompletamente = new JLabel("Porcentaje vacunados (pauta completa):");
		lblPorcentajeCompletamente.setBounds(159, 240, 228, 14);
		midPanel.add(lblPorcentajeCompletamente);

		JButton btnPorcentajeRegion = new JButton("Porcentaje vacunados por región");
		btnPorcentajeRegion.setBounds(397, 222, 191, 32);
		btnPorcentajeRegion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int porcentajePrimera = frame.getGestorEstadisticas()
							.consultarPorcentajeVacunadosSobreRecibidasEnRegionPrimeraDosis(
									comboTotalRegion.getSelectedIndex() + 1);
					int porcentajeSegunda = frame.getGestorEstadisticas()
							.consultarPorcentajeVacunadosSobreRecibidasEnRegionSegundaDosis(
									comboTotalRegion.getSelectedIndex() + 1);

					lblPorcentaje1Dosisregion.setText("Porcentaje vacunados por región (primera dosis): "
							+ String.valueOf(porcentajePrimera) + "%");
					lblPorcentajeDosisRegionCompleta.setText("Porcentaje vacunados por región (pauta completa): "
							+ String.valueOf(porcentajeSegunda) + "%");
				} catch (GSNSException gsnse) {
					JOptionPane.showMessageDialog(frame, gsnse.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnPorcentajeRegion.setHorizontalAlignment(SwingConstants.RIGHT);
		midPanel.add(btnPorcentajeRegion);

		comboTotalRegion = new JComboBox<String>(RegionEnum.getNombres());
		comboTotalRegion.setBounds(397, 100, 191, 21);
		midPanel.add(comboTotalRegion);

		lblPorcentaje1Dosisregion = new JLabel("Porcentaje vacunados por región (primera dosis):");
		lblPorcentaje1Dosisregion.setBounds(598, 194, 282, 14);
		midPanel.add(lblPorcentaje1Dosisregion);

		lblPorcentajeDosisRegionCompleta = new JLabel("Porcentaje vacunados por región (pauta completa):");
		lblPorcentajeDosisRegionCompleta.setBounds(598, 240, 282, 14);
		midPanel.add(lblPorcentajeDosisRegionCompleta);

		comboPorcentajeRegion = new JComboBox<String>(RegionEnum.getNombres());
		comboPorcentajeRegion.setBounds(397, 190, 191, 21);
		midPanel.add(comboPorcentajeRegion);
	}

}