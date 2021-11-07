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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.eborait.gsns.dominio.entitymodel.excepciones.GSNSException;

/**
 * Pantalla de consulta de estadísticas.
 *
 * @author Jorge Fernández Escolano
 * @author Roberto Esteban Olivares
 * @version 1.0
 * @since 1.0
 */
public class PantallaConsultaEstadisticas extends JPanel {
	
	/** El serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** El desplegable de total region. */
	private JComboBox<String> comboTotalRegion;
	
	/** El desplegable de porcentaje region. */
	private JComboBox<String> comboPorcentajeRegion;

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

		JLabel lblTitulo = new JLabel("Consultar estadísticas");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		topPanel.add(lblTitulo);

		final JLabel lblTotalVacPrimeraDosis = new JLabel("Total vacunados (primera dosis):");
		lblTotalVacPrimeraDosis.setBounds(159, 100, 228, 14);
		midPanel.add(lblTotalVacPrimeraDosis);

		final JLabel lblTotalVacSegundaDosis = new JLabel("Total vacunados (segunda dosis):");
		lblTotalVacSegundaDosis.setBounds(159, 125, 228, 14);
		midPanel.add(lblTotalVacSegundaDosis);

		final JLabel lblTotalDosisAdministradas = new JLabel("Total dosis administradas:");
		lblTotalDosisAdministradas.setBounds(159, 150, 228, 14);
		midPanel.add(lblTotalDosisAdministradas);

		JButton btnTotalVacunados = new JButton("Total vacunados");
		btnTotalVacunados.setBounds(10, 100, 139, 64);
		btnTotalVacunados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int totalPrimera = frame.getGestorGSNS().getGestorEstadisticas().consultarTotalVacunadosPrimeraDosis();
					int totalSegunda = frame.getGestorGSNS().getGestorEstadisticas().consultarTotalVacunadosSegundaDosis();
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

		final JLabel lblTotalVacunadosRegionPrimera = new JLabel("Total vacunados por región (primera dosis):");
		lblTotalVacunadosRegionPrimera.setBounds(598, 100, 282, 14);
		midPanel.add(lblTotalVacunadosRegionPrimera);

		final JLabel lblTotalVacunadosRegionSegunda = new JLabel("Total vacunados por región (segunda dosis):");
		lblTotalVacunadosRegionSegunda.setBounds(598, 125, 282, 14);
		midPanel.add(lblTotalVacunadosRegionSegunda);

		final JLabel lblTotalDosisAdministradasRegion = new JLabel("Total dosis administradas por región:");
		lblTotalDosisAdministradasRegion.setBounds(598, 150, 282, 14);
		midPanel.add(lblTotalDosisAdministradasRegion);

		JButton btnVacunadosPorRegion = new JButton("Total vacunados por región");
		btnVacunadosPorRegion.setBounds(397, 132, 191, 32);
		btnVacunadosPorRegion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int totalPrimera = frame.getGestorGSNS().getGestorEstadisticas()
							.consultarTotalVacunadosPorRegionPrimeraDosis(comboTotalRegion.getSelectedIndex() + 1);
					int totalSegunda = frame.getGestorGSNS().getGestorEstadisticas()
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

		final JLabel lblPorcentajePrimera = new JLabel("Porcentaje vacunados (primera dosis):");
		lblPorcentajePrimera.setBounds(159, 194, 228, 14);
		midPanel.add(lblPorcentajePrimera);

		final JLabel lblPorcentajeCompletamente = new JLabel("Porcentaje vacunados (pauta completa):");
		lblPorcentajeCompletamente.setBounds(159, 240, 228, 14);
		midPanel.add(lblPorcentajeCompletamente);

		JButton btnPorcentaje = new JButton("Porcentaje vacunados");
		btnPorcentaje.setBounds(10, 190, 139, 64);
		btnPorcentaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int porcentajePrimera = frame.getGestorGSNS().getGestorEstadisticas()
							.consultarPorcentajeVacunadosSobreRecibidasPrimeraDosis();
					int porcentajeSegunda = frame.getGestorGSNS().getGestorEstadisticas()
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

		final JLabel lblPorcentaje1Dosisregion = new JLabel("Porcentaje vacunados por región (primera dosis):");
		lblPorcentaje1Dosisregion.setBounds(598, 194, 282, 14);
		midPanel.add(lblPorcentaje1Dosisregion);

		final JLabel lblPorcentajeDosisRegionCompleta = new JLabel("Porcentaje vacunados por región (pauta completa):");
		lblPorcentajeDosisRegionCompleta.setBounds(598, 240, 282, 14);
		midPanel.add(lblPorcentajeDosisRegionCompleta);

		JButton btnPorcentajeRegion = new JButton("Porcentaje vacunados por región");
		btnPorcentajeRegion.setBounds(397, 222, 191, 32);
		btnPorcentajeRegion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int porcentajePrimera = frame.getGestorGSNS().getGestorEstadisticas()
							.consultarPorcentajeVacunadosSobreRecibidasEnRegionPrimeraDosis(
									comboTotalRegion.getSelectedIndex() + 1);
					int porcentajeSegunda = frame.getGestorGSNS().getGestorEstadisticas()
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

		comboTotalRegion = new JComboBox<String>(frame.getGestorGSNS().getNombresRegion());
		comboTotalRegion.setBounds(397, 100, 191, 21);
		midPanel.add(comboTotalRegion);

		comboPorcentajeRegion = new JComboBox<String>(frame.getGestorGSNS().getNombresRegion());
		comboPorcentajeRegion.setBounds(397, 190, 191, 21);
		midPanel.add(comboPorcentajeRegion);
	}

}