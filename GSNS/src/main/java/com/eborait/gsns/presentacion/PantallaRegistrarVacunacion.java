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

import com.eborait.gsns.dominio.entitymodel.GrupoPrioridad;
import com.eborait.gsns.dominio.entitymodel.RegionEnum;
import com.eborait.gsns.dominio.entitymodel.excepciones.GSNSException;
import javax.swing.JCheckBox;

public class PantallaRegistrarVacunacion extends JPanel {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtDni;
	private JTextField txtFecha;
	private JComboBox<String> comboTipoVacuna;
	private JComboBox<String> comboRegion;
	private JComboBox<String> comboGrupoPrioridad;
	private JCheckBox chkSegundaDosis;

	/**
	 * Crea el panel.
	 * 
	 * @param frame JFrame de la aplicación.
	 * @throws GSNSException Si se produce una excepción de la aplicación.
	 */
	public PantallaRegistrarVacunacion(final Main frame) throws GSNSException {
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

		JLabel lblTitulo = new JLabel("Gestión Sistema Regional de Salud/Registro de vacunación");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		topPanel.add(lblTitulo);
		midPanel.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 36, 201, 14);
		midPanel.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(242, 36, 181, 20);
		midPanel.add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(444, 36, 201, 14);
		midPanel.add(lblApellidos);

		txtApellidos = new JTextField();
		txtApellidos.setBounds(676, 36, 181, 20);
		midPanel.add(txtApellidos);
		txtApellidos.setColumns(10);

		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(10, 61, 201, 14);
		midPanel.add(lblDni);

		txtDni = new JTextField();
		txtDni.setBounds(242, 61, 181, 20);
		midPanel.add(txtDni);
		txtDni.setColumns(10);

		JLabel lblVacuna = new JLabel("Tipo Vacuna:");
		lblVacuna.setBounds(10, 86, 201, 14);
		midPanel.add(lblVacuna);

		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(444, 61, 201, 14);
		midPanel.add(lblFecha);

		txtFecha = new JTextField();
		txtFecha.setBounds(676, 61, 181, 20);
		midPanel.add(txtFecha);
		txtFecha.setColumns(10);

		JButton btnRegistrarVacunacion = new JButton("Registrar Vacunacion");
		btnRegistrarVacunacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarVacunacion(frame);
			}
		});
		btnRegistrarVacunacion.setBounds(10, 141, 847, 23);
		midPanel.add(btnRegistrarVacunacion);
		try {
			comboTipoVacuna = new JComboBox<>(frame.getGestorRepartoVacunas().getTipoVacunas());
			comboTipoVacuna.setBounds(242, 86, 181, 20);
			midPanel.add(comboTipoVacuna);
		} catch (GSNSException gsnse) {
			JOptionPane.showMessageDialog(frame, gsnse.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			throw gsnse;
		}

		comboGrupoPrioridad = new JComboBox<String>(GrupoPrioridad.getNombres());
		comboGrupoPrioridad.setBounds(676, 86, 181, 20);
		midPanel.add(comboGrupoPrioridad);

		JLabel lblGrupoPrioridad = new JLabel("Grupo de prioridad:");
		lblGrupoPrioridad.setBounds(444, 86, 201, 14);
		midPanel.add(lblGrupoPrioridad);

		comboRegion = new JComboBox<String>(RegionEnum.getNombres());
		comboRegion.setBounds(242, 111, 181, 20);
		midPanel.add(comboRegion);

		JLabel lblRegion = new JLabel("Región:");
		lblRegion.setBounds(10, 111, 201, 14);
		midPanel.add(lblRegion);

		JLabel lblSegundaDosis = new JLabel("¿Es la segunda dosis?");
		lblSegundaDosis.setBounds(444, 116, 201, 14);
		midPanel.add(lblSegundaDosis);

		chkSegundaDosis = new JCheckBox("Segunda dosis");
		chkSegundaDosis.setBounds(676, 111, 97, 23);
		midPanel.add(chkSegundaDosis);
	}

	/**
	 * Invoca al gestor para registrar la vacunación.
	 * 
	 * @param frame JFrame de la aplicación.
	 */
	private void registrarVacunacion(Main frame) {
		if (validar()) {
			try {
				frame.getGestorVacunacion().registrarVacunacion(txtFecha.getText(), txtNombre.getText(),
						txtApellidos.getText(), txtDni.getText(), comboTipoVacuna.getSelectedItem().toString(),
						comboGrupoPrioridad.getSelectedIndex() + 1, comboRegion.getSelectedIndex() + 1,
						chkSegundaDosis.isEnabled());
			} catch (GSNSException gsnse) {
				JOptionPane.showMessageDialog(frame, gsnse.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(frame, "Rellena todos los campos.", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	/**
	 * Valida los campos de texto y desplegables.
	 * 
	 * @return true si la validación es correcta, false de lo contrario. 
	 */
	private boolean validar() {
		JTextField[] textFields = { txtNombre, txtApellidos, txtFecha, txtDni };
		for (JTextField jTextField : textFields) {
			if (jTextField.getText().length() == 0)
				return false;
		}
		if (comboGrupoPrioridad.getSelectedIndex() == -1 || comboRegion.getSelectedIndex() == -1
				|| comboTipoVacuna.getSelectedItem() == null) {
			return false;
		}
		return true;
	}
}
