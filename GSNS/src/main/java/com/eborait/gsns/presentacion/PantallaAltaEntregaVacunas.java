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

/**
 * Pantalla alta entrega de vacunas.
 *
 * @author Jorge Fernández Escolano
 * @author Roberto Esteban Olivares
 * @version 1.0
 * @since 1.0
 */
public class PantallaAltaEntregaVacunas extends JPanel {

	/** El serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** El campo de texto del id de entrega. */
	private JTextField txtIdEntrega;

	/** El campo de texto de lote. */
	private JTextField txtLote;

	/** El campo de texto de fecha. */
	private JTextField txtFecha;

	/** El campo de texto de cantidad. */
	private JTextField txtCantidad;

	/** El desplegable de grupo de prioridad. */
	private JComboBox<String> comboGrupoPrioridad;

	/** El desplegable de regione. */
	private JComboBox<String> comboRegion;

	/** El desplegable de tipo de vacuna. */
	private JComboBox<String> comboTipoVacuna;

	/**
	 * Crea el panel.
	 * 
	 * @param frame JFrame de la aplicación.
	 */
	public PantallaAltaEntregaVacunas(final Main frame) {
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

		JLabel lblTitulo = new JLabel("Gestión Sistema Regional de Salud/Alta entrega de vacunas");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		topPanel.add(lblTitulo);
		midPanel.setLayout(null);

		JLabel lblIdEntrega = new JLabel("Identificador de la entrega:");
		lblIdEntrega.setBounds(10, 36, 201, 14);
		midPanel.add(lblIdEntrega);

		txtIdEntrega = new JTextField();
		txtIdEntrega.setBounds(242, 36, 181, 20);
		midPanel.add(txtIdEntrega);
		txtIdEntrega.setColumns(10);

		JLabel lblLote = new JLabel("Lote de vacunación:");
		lblLote.setBounds(10, 64, 201, 14);
		midPanel.add(lblLote);

		txtLote = new JTextField();
		txtLote.setColumns(10);
		txtLote.setBounds(242, 64, 181, 20);
		midPanel.add(txtLote);

		JLabel lblFecha = new JLabel("Fecha de alta:");
		lblFecha.setBounds(10, 92, 201, 14);
		midPanel.add(lblFecha);

		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(242, 92, 181, 20);
		midPanel.add(txtFecha);

		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(10, 120, 201, 14);
		midPanel.add(lblCantidad);

		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(242, 120, 181, 20);
		midPanel.add(txtCantidad);

		JLabel lblPrioridad = new JLabel("Grupo de prioridad:");
		lblPrioridad.setBounds(10, 148, 201, 14);
		midPanel.add(lblPrioridad);

		JLabel lblTipoVacuna = new JLabel("Tipo de vacuna:");
		lblTipoVacuna.setBounds(444, 36, 201, 14);
		midPanel.add(lblTipoVacuna);

		JLabel lblRegion = new JLabel("Región de la entrega:");
		lblRegion.setBounds(10, 176, 201, 14);
		midPanel.add(lblRegion);

		JLabel lblEntrega = new JLabel("Entrega");
		lblEntrega.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEntrega.setBounds(10, 11, 413, 14);
		midPanel.add(lblEntrega);

		JLabel lblVacuna = new JLabel("Vacuna");
		lblVacuna.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblVacuna.setBounds(444, 11, 413, 14);
		midPanel.add(lblVacuna);

		JButton btnNewButton = new JButton("Registrar alta");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarAlta(frame);
			}
		});
		btnNewButton.setBounds(10, 215, 847, 23);
		midPanel.add(btnNewButton);

		comboGrupoPrioridad = new JComboBox<String>(GrupoPrioridad.getNombres());
		comboGrupoPrioridad.setBounds(242, 148, 181, 20);
		midPanel.add(comboGrupoPrioridad);

		comboRegion = new JComboBox<String>(RegionEnum.getNombres());
		comboRegion.setBounds(242, 176, 181, 20);
		midPanel.add(comboRegion);

		try {
			comboTipoVacuna = new JComboBox<>(frame.getGestorRepartoVacunas().getTipoVacunas());
			comboTipoVacuna.setBounds(676, 36, 181, 20);
			midPanel.add(comboTipoVacuna);
		} catch (GSNSException gsnse) {
			JOptionPane.showMessageDialog(frame, gsnse.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			frame.cambiarPanel(frame.getPanelMain());
		}
	}

	/**
	 * Invoca al gestor para realizar el alta de entrega de vacunas.
	 * 
	 * @param frame JFrame de la aplicación.
	 */
	private void registrarAlta(Main frame) {
		if (validar()) {
			try {
				boolean correcto = frame.getGestorVacunacion().altaEntregaVacunas(txtIdEntrega.getText(),
						txtLote.getText(), txtFecha.getText(), Integer.parseInt(txtCantidad.getText()),
						comboGrupoPrioridad.getSelectedIndex() + 1, comboTipoVacuna.getSelectedItem().toString(),
						comboRegion.getSelectedIndex() + 1);
				if (correcto) {
					JOptionPane.showMessageDialog(frame, "La entrega se ha registrado correctamente.", "Información",
							JOptionPane.INFORMATION_MESSAGE);
					frame.cambiarPanel(frame.getPanelMain());
				}
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(frame,
						"Se ha producido un error al registrar el alta: La cantidad no es correcta. Introduce un número entero.",
						"Error", JOptionPane.ERROR_MESSAGE);
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
		JTextField[] textFields = { txtIdEntrega, txtLote, txtFecha, txtCantidad };
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
