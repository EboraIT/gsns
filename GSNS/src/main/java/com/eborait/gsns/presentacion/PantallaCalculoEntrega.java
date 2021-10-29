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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.eborait.gsns.dominio.entitymodel.excepciones.GSNSException;

public class PantallaCalculoEntrega extends JPanel {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtIA;
	private JComboBox<String> comboRegion;
	private JLabel lblCalculo;

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
				frame.cambiarPanel(frame.getPanelMain());
			}
		});
		topPanel.add(btnVolver);

		JLabel lblTitulo = new JLabel("Gestión Sistema Nacional de Salud/Calculo de Reparto de Vacunas");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		topPanel.add(lblTitulo);
		midPanel.setLayout(null);

		JLabel lblSeleccionarRegion = new JLabel("Seleccione una región:");
		lblSeleccionarRegion.setBounds(10, 36, 201, 14);
		midPanel.add(lblSeleccionarRegion);

		comboRegion = new JComboBox<String>();
		comboRegion.setBounds(242, 36, 181, 20);
		midPanel.add(comboRegion);

		JLabel lblPoblacionTitulo = new JLabel("Población:");
		lblPoblacionTitulo.setBounds(10, 64, 201, 14);
		midPanel.add(lblPoblacionTitulo);

		JLabel lblPoblacion = new JLabel(comboRegion.getSelectedItem().toString());
		lblPoblacion.setBounds(242, 64, 181, 20);
		midPanel.add(lblPoblacion);

		JLabel lblIA = new JLabel("Introduzca la IA:");
		lblIA.setBounds(10, 92, 201, 14);
		midPanel.add(lblIA);

		txtIA = new JTextField();
		txtIA.setColumns(10);
		txtIA.setBounds(242, 92, 181, 20);
		midPanel.add(txtIA);

		JButton btnCalcularReparto = new JButton("Calcular");
		btnCalcularReparto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validar()) {
					int reparto = 0;
					try {
						reparto = frame.getGestorRepartoVacunas().calcularEntregasRegion(
								comboRegion.getSelectedIndex() + 1, Integer.parseInt(txtIA.getText()));
						lblCalculo.setText("" + String.valueOf(reparto));
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (GSNSException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					// lblCalculo.setText("Vacunas a repartir: "+reparto);
				} else {
					JOptionPane.showMessageDialog(frame, "Rellena todos los campos.", "Advertencia",
							JOptionPane.WARNING_MESSAGE);
				}
			}

		});
		btnCalcularReparto.setBounds(10, 131, 847, 23);
		midPanel.add(btnCalcularReparto);

		JLabel lblReparto = new JLabel("Vacunas a repartir:");
		lblReparto.setBounds(444, 36, 413, 14);
		midPanel.add(lblReparto);

		lblCalculo = new JLabel("");
		lblCalculo.setBounds(333, 500, 97, 14);
		midPanel.add(lblCalculo);

	}

	/**
	 * Valida los campos de texto .
	 * 
	 * @return true si la validación es correcta, false de lo contrario.
	 */
	private boolean validar() {
		JTextField[] textFields = { txtIA };
		for (JTextField jTextField : textFields) {
			if (jTextField.getText().length() == 0)
				return false;
		}
		return true;
	}

}
