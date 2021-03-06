package com.eborait.gsns.presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.eborait.gsns.dominio.entitymodel.excepciones.GSNSException;

/**
 * Pantalla de registro de vacunación.
 *
 * @author Jorge Fernández Escolano
 * @author Roberto Esteban Olivares
 * @version 1.0
 * @since 1.0
 */
public class PantallaRegistrarVacunacion extends PanelBase {

	/** El serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** El campo de texto de nombre. */
	private final JTextField txtNombre;

	/** El campo de texto de apellidos. */
	private final JTextField txtApellidos;

	/** El campo de texto de dni. */
	private final JTextField txtDni;

	/** El campo de texto de fecha. */
	private final JTextField txtFecha;

	/** El desplegable de tipo vacuna. */
	private JComboBox<String> comboTipoVacuna;

	/** El desplegable de de region. */
	private final JComboBox<String> comboRegion;

	/** El desplegable de grupo prioridad. */
	private final JComboBox<String> comboGrupoPrioridad;

	/** The checkbox de segunda dosis. */
	private final JCheckBox chkSegundaDosis;

	/**
	 * Crea el panel.
	 * 
	 * @param frame JFrame de la aplicación.
	 */
	public PantallaRegistrarVacunacion(final Main frame) {
		super(frame, "Gestión Sistema Regional de Salud/Registro de vacunación");

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
			comboTipoVacuna = new JComboBox<>(frame.getGestorGSNS().getGestorRepartoVacunas().getTipoVacunas());
			comboTipoVacuna.setBounds(242, 86, 181, 20);
			midPanel.add(comboTipoVacuna);
		} catch (GSNSException gsnse) {
			JOptionPane.showMessageDialog(frame, gsnse.getMessage(), Main.ERROR, JOptionPane.ERROR_MESSAGE);
			frame.cambiarPanel(frame.getPanelMain());
		}
		comboGrupoPrioridad = new JComboBox<>(frame.getGestorGSNS().getNombresGrupoPrioridad());
		comboGrupoPrioridad.setBounds(676, 86, 181, 20);
		midPanel.add(comboGrupoPrioridad);

		JLabel lblGrupoPrioridad = new JLabel("Grupo de prioridad:");
		lblGrupoPrioridad.setBounds(444, 86, 201, 14);
		midPanel.add(lblGrupoPrioridad);

		comboRegion = new JComboBox<>(frame.getGestorGSNS().getNombresRegion());
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
				boolean correcto = frame.getGestorGSNS().getGestorVacunacion().registrarVacunacion(txtFecha.getText(),
						txtNombre.getText(), txtApellidos.getText(), txtDni.getText(),
						comboTipoVacuna.getSelectedItem().toString(), comboGrupoPrioridad.getSelectedIndex() + 1,
						comboRegion.getSelectedIndex() + 1, chkSegundaDosis.isSelected());
				if (correcto) {
					JOptionPane.showMessageDialog(frame, "La vacunación se ha registrado correctamente.", Main.INFO,
							JOptionPane.INFORMATION_MESSAGE);
					frame.cambiarPanel(frame.getPanelMain());
				}
			} catch (GSNSException gsnse) {
				JOptionPane.showMessageDialog(frame, gsnse.getMessage(), Main.ERROR, JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(frame, "Rellena todos los campos.", Main.WARNING,
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
		return !(comboGrupoPrioridad.getSelectedIndex() == -1 || comboRegion.getSelectedIndex() == -1
				|| comboTipoVacuna.getSelectedItem() == null);
	}
}
