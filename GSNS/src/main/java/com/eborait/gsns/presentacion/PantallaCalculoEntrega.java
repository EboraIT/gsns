package com.eborait.gsns.presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.eborait.gsns.dominio.entitymodel.RegionEnum;
import com.eborait.gsns.dominio.entitymodel.excepciones.GSNSException;

/**
 * Pantalla cálculo de entrega de vacunas.
 *
 * @author Jorge Fernández Escolano
 * @author Roberto Esteban Olivares
 * @version 1.0
 * @since 1.0
 */
public class PantallaCalculoEntrega extends JPanel {

	/** El serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Crea el panel.
	 * 
	 * @param frame JFrame de la aplicación.
	 */
	public PantallaCalculoEntrega(final Main frame) {
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
			}
		});
		topPanel.add(btnVolver);

		JLabel lblTitulo = new JLabel("Gestión Sistema Nacional de Salud/Cálculo de Reparto de Vacunas");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		topPanel.add(lblTitulo);
		midPanel.setLayout(null);

		JLabel lblSeleccionarRegion = new JLabel("Seleccione una región:");
		lblSeleccionarRegion.setBounds(10, 36, 201, 14);
		midPanel.add(lblSeleccionarRegion);

		final JLabel lblPoblacion = new JLabel();
		lblPoblacion.setBounds(242, 64, 181, 20);
		midPanel.add(lblPoblacion);

		final JComboBox<String> comboRegion = new JComboBox<String>(RegionEnum.getNombres());
		comboRegion.setBounds(242, 36, 181, 20);
		comboRegion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					lblPoblacion.setText(
							formatearPoblacion(RegionEnum.valueOf(comboRegion.getSelectedIndex() + 1).getPoblacion()));
				} catch (GSNSException gsnse) {
					JOptionPane.showMessageDialog(frame, gsnse.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
						int reparto = frame.getGestorRepartoVacunas().calcularEntregasRegion(
								comboRegion.getSelectedIndex() + 1, Integer.parseInt(txtIA.getText()));
						lblReparto.setText("Vacunas a repartir: " + String.valueOf(reparto));
					} catch (GSNSException gsnse) {
						JOptionPane.showMessageDialog(frame, gsnse.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
