package com.eborait.gsns.presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.eborait.gsns.dominio.entitymodel.excepciones.GSNSException;

/**
 * Pantalla cálculo de entrega de vacunas.
 *
 * @author Jorge Fernández Escolano
 * @author Roberto Esteban Olivares
 * @version 1.0
 * @since 1.0
 */
public class PantallaCalculoEntrega extends PanelBase {

	/** El serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Crea el panel.
	 * 
	 * @param frame JFrame de la aplicación.
	 */
	public PantallaCalculoEntrega(final Main frame) {
		super(frame, "Gestión Sistema Nacional de Salud/Cálculo de Reparto de Vacunas");

		JLabel lblSeleccionarRegion = new JLabel("Seleccione una región:");
		lblSeleccionarRegion.setBounds(10, 36, 201, 14);
		midPanel.add(lblSeleccionarRegion);

		final JLabel lblPoblacion = new JLabel();
		lblPoblacion.setBounds(242, 64, 181, 20);
		midPanel.add(lblPoblacion);

		final JComboBox<String> comboRegion = new JComboBox<>(frame.getGestorGSNS().getNombresRegion());
		comboRegion.setBounds(242, 36, 181, 20);
		comboRegion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					lblPoblacion.setText(formatearPoblacion(
							frame.getGestorGSNS().getRegionPorId(comboRegion.getSelectedIndex() + 1).getPoblacion()));
				} catch (GSNSException gsnse) {
					JOptionPane.showMessageDialog(frame, gsnse.getMessage(), Main.ERROR, JOptionPane.ERROR_MESSAGE);
					frame.cambiarPanel(frame.getPanelMain());
				}
			}
		});
		midPanel.add(comboRegion);

		JLabel lblPoblacionTitulo = new JLabel("Población:");
		lblPoblacionTitulo.setBounds(10, 64, 201, 14);
		midPanel.add(lblPoblacionTitulo);

		JLabel lblIA = new JLabel("Introduzca la IA:");
		lblIA.setBounds(10, 92, 201, 14);
		midPanel.add(lblIA);

		final JTextField txtIA = new JTextField();
		txtIA.setColumns(10);
		txtIA.setBounds(242, 92, 181, 20);
		midPanel.add(txtIA);

		final JLabel lblReparto = new JLabel("Vacunas a repartir:");
		lblReparto.setBounds(444, 36, 413, 14);
		midPanel.add(lblReparto);

		JButton btnCalcularReparto = new JButton("Calcular");
		btnCalcularReparto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtIA.getText().length() != 0) {
					try {
						int reparto = frame.getGestorGSNS().getGestorRepartoVacunas().calcularEntregasRegion(
								comboRegion.getSelectedIndex() + 1, Integer.parseInt(txtIA.getText()));
						lblReparto.setText("Vacunas a repartir: " + formatearPoblacion(reparto));

					} catch (NumberFormatException nfe) {
						JOptionPane.showMessageDialog(frame,
								"Se ha producido un error al realizar el cálculo: La IA no es correcta. Introduce un número entero.",
								Main.ERROR, JOptionPane.ERROR_MESSAGE);
					} catch (GSNSException gsnse) {
						JOptionPane.showMessageDialog(frame, gsnse.getMessage(), Main.ERROR, JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(frame, "Rellena todos los campos.", "Advertencia",
							JOptionPane.WARNING_MESSAGE);
				}
			}

		});
		btnCalcularReparto.setBounds(10, 131, 847, 23);
		midPanel.add(btnCalcularReparto);

		comboRegion.setSelectedIndex(0);
	}

	/**
	 * Añade el separador de miles a un número entero.
	 * 
	 * @param poblacion Población de la región.
	 * @return Una cadena con la población formateada.
	 * 
	 * @see DecimalFormat
	 */
	private String formatearPoblacion(int poblacion) {
		return new DecimalFormat("###,###.##").format(poblacion);
	}

}
