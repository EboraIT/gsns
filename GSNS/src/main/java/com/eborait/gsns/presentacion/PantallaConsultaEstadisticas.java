package com.eborait.gsns.presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import com.eborait.gsns.dominio.entitymodel.excepciones.GSNSException;

/**
 * Pantalla de consulta de estadísticas.
 *
 * @author Jorge Fernández Escolano
 * @author Roberto Esteban Olivares
 * @version 1.0
 * @since 1.0
 */
public class PantallaConsultaEstadisticas extends PanelBase {

	/** El serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** El desplegable de total region. */
	private final JComboBox<String> comboTotalRegion;

	/** El desplegable de porcentaje region. */
	private final JComboBox<String> comboPorcentajeRegion;

	/**
	 * Crea el panel.
	 * 
	 * @param frame JFrame de la aplicación.
	 */
	public PantallaConsultaEstadisticas(final Main frame) {
		super(frame, "Consultar estadísticas");

		final JLabel lblTotalVacPrimeraDosis = new JLabel("Total vacunados (primera dosis):");
		lblTotalVacPrimeraDosis.setBounds(211, 50, 377, 14);
		midPanel.add(lblTotalVacPrimeraDosis);

		final JLabel lblTotalVacSegundaDosis = new JLabel("Total vacunados (segunda dosis):");
		lblTotalVacSegundaDosis.setBounds(211, 75, 377, 14);
		midPanel.add(lblTotalVacSegundaDosis);

		final JLabel lblTotalDosisAdministradas = new JLabel("Total dosis administradas:");
		lblTotalDosisAdministradas.setBounds(211, 100, 377, 14);
		midPanel.add(lblTotalDosisAdministradas);

		JButton btnTotalVacunados = new JButton("Total vacunados");
		btnTotalVacunados.setBounds(10, 50, 191, 64);
		btnTotalVacunados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int totalPrimera = frame.getGestorGSNS().getGestorEstadisticas().consultarTotalVacunados(false);
					int totalSegunda = frame.getGestorGSNS().getGestorEstadisticas().consultarTotalVacunados(true);
					int total = totalPrimera + totalSegunda;
					lblTotalVacPrimeraDosis.setText("Total vacunados (primera dosis): " + totalPrimera);
					lblTotalVacSegundaDosis.setText("Total vacunados (segunda dosis): " + totalSegunda);
					lblTotalDosisAdministradas.setText("Total dosis administradas: " + total);
				} catch (GSNSException gsnse) {
					JOptionPane.showMessageDialog(frame, gsnse.getMessage(), Main.ERROR, JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		midPanel.setLayout(null);
		midPanel.add(btnTotalVacunados);

		final JLabel lblTotalVacunadosRegionPrimera = new JLabel("Total vacunados por región (primera dosis):");
		lblTotalVacunadosRegionPrimera.setBounds(211, 200, 377, 14);
		midPanel.add(lblTotalVacunadosRegionPrimera);

		final JLabel lblTotalVacunadosRegionSegunda = new JLabel("Total vacunados por región (segunda dosis):");
		lblTotalVacunadosRegionSegunda.setBounds(211, 225, 377, 14);
		midPanel.add(lblTotalVacunadosRegionSegunda);

		final JLabel lblTotalDosisAdministradasRegion = new JLabel("Total dosis administradas por región:");
		lblTotalDosisAdministradasRegion.setBounds(211, 250, 377, 14);
		midPanel.add(lblTotalDosisAdministradasRegion);

		JButton btnVacunadosPorRegion = new JButton("Total vacunados por región");
		btnVacunadosPorRegion.setBounds(10, 232, 191, 32);
		btnVacunadosPorRegion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int totalPrimera = frame.getGestorGSNS().getGestorEstadisticas()
							.consultarTotalVacunadosPorRegion(comboTotalRegion.getSelectedIndex() + 1, false);
					int totalSegunda = frame.getGestorGSNS().getGestorEstadisticas()
							.consultarTotalVacunadosPorRegion(comboTotalRegion.getSelectedIndex() + 1, true);
					int total = totalPrimera + totalSegunda;
					lblTotalVacunadosRegionPrimera
							.setText("Total vacunados por región (primera dosis): " + totalPrimera);
					lblTotalVacunadosRegionSegunda
							.setText("Total vacunados por región (segunda dosis): " + totalSegunda);
					lblTotalDosisAdministradasRegion.setText("Total dosis administradas por región: " + total);
				} catch (GSNSException gsnse) {
					JOptionPane.showMessageDialog(frame, gsnse.getMessage(), Main.ERROR, JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		midPanel.add(btnVacunadosPorRegion);

		final JLabel lblPorcentajePrimera = new JLabel("Porcentaje vacunados (primera dosis):");
		lblPorcentajePrimera.setBounds(211, 129, 377, 14);
		midPanel.add(lblPorcentajePrimera);

		final JLabel lblPorcentajeCompletamente = new JLabel("Porcentaje vacunados (pauta completa):");
		lblPorcentajeCompletamente.setBounds(211, 175, 377, 14);
		midPanel.add(lblPorcentajeCompletamente);

		JButton btnPorcentaje = new JButton("Porcentaje vacunados");
		btnPorcentaje.setBounds(10, 125, 191, 64);
		btnPorcentaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double porcentajePrimera = frame.getGestorGSNS().getGestorEstadisticas()
							.consultarPorcentajeVacunadosSobreRecibidas(false);
					double porcentajeSegunda = frame.getGestorGSNS().getGestorEstadisticas()
							.consultarPorcentajeVacunadosSobreRecibidas(true);
					lblPorcentajePrimera.setText("Porcentaje vacunados (primera dosis): " + porcentajePrimera + "%");
					lblPorcentajeCompletamente
							.setText("Porcentaje vacunados (pauta completa): " + porcentajeSegunda + "%");
				} catch (GSNSException gsnse) {
					JOptionPane.showMessageDialog(frame, gsnse.getMessage(), Main.ERROR, JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		midPanel.add(btnPorcentaje);

		final JLabel lblPorcentaje1Dosisregion = new JLabel("Porcentaje vacunados por región (primera dosis):");
		lblPorcentaje1Dosisregion.setBounds(211, 294, 377, 14);
		midPanel.add(lblPorcentaje1Dosisregion);

		final JLabel lblPorcentajeDosisRegionCompleta = new JLabel("Porcentaje vacunados por región (pauta completa):");
		lblPorcentajeDosisRegionCompleta.setBounds(211, 340, 377, 14);
		midPanel.add(lblPorcentajeDosisRegionCompleta);

		JButton btnPorcentajeRegion = new JButton("Porcentaje vacunados por región");
		btnPorcentajeRegion.setBounds(10, 322, 191, 32);
		btnPorcentajeRegion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double porcentajePrimera = frame.getGestorGSNS().getGestorEstadisticas()
							.consultarPorcentajeVacunadosSobreRecibidasEnRegion(
									comboPorcentajeRegion.getSelectedIndex() + 1, false);
					double porcentajeSegunda = frame.getGestorGSNS().getGestorEstadisticas()
							.consultarPorcentajeVacunadosSobreRecibidasEnRegion(
									comboPorcentajeRegion.getSelectedIndex() + 1, true);

					lblPorcentaje1Dosisregion
							.setText("Porcentaje vacunados por región (primera dosis): " + porcentajePrimera + "%");
					lblPorcentajeDosisRegionCompleta
							.setText("Porcentaje vacunados por región (pauta completa): " + porcentajeSegunda + "%");
				} catch (GSNSException gsnse) {
					JOptionPane.showMessageDialog(frame, gsnse.getMessage(), Main.ERROR, JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnPorcentajeRegion.setHorizontalAlignment(SwingConstants.RIGHT);
		midPanel.add(btnPorcentajeRegion);

		comboTotalRegion = new JComboBox<>(frame.getGestorGSNS().getNombresRegion());
		comboTotalRegion.setBounds(10, 200, 191, 21);
		midPanel.add(comboTotalRegion);

		comboPorcentajeRegion = new JComboBox<>(frame.getGestorGSNS().getNombresRegion());
		comboPorcentajeRegion.setBounds(10, 290, 191, 21);
		midPanel.add(comboPorcentajeRegion);
	}

}