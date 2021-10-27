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

public class PantallaAltaEntregaVacunas extends JPanel {
	private JTextField txtIdEntrega;
	private JTextField txtLote;
	private JTextField txtFecha;
	private JTextField txtCantidad;
	private JComboBox<String> comboPrioridad;
	private JComboBox<String> comboRegion;
	private JComboBox<String> comboTipoVacuna;

	/**
	 * Create the frame.
	 * 
	 * @throws GSNSException
	 */
	public PantallaAltaEntregaVacunas(final Main frame) throws GSNSException {
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

		comboPrioridad = new JComboBox<String>();
		comboPrioridad.setBounds(242, 148, 181, 20);
		midPanel.add(comboPrioridad);

		comboRegion = new JComboBox<String>();
		comboRegion.setBounds(242, 176, 181, 20);
		midPanel.add(comboRegion);

		try {
			comboTipoVacuna = new JComboBox<String>(
					(String[]) frame.getGestorRepartoVacunas().getTipoVacunas().toArray());
			comboTipoVacuna.setBounds(676, 36, 181, 20);
			midPanel.add(comboTipoVacuna);
		} catch (GSNSException gsnse) {
			JOptionPane.showMessageDialog(frame, gsnse.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			throw gsnse;
		}
	}

	private void registrarAlta(Main frame) {
		if (validar()) {
			try {
				frame.getGestorVacunacion().altaEntregaVacunas(txtIdEntrega.getText(), txtLote.getText(),
						txtFecha.getText(), Integer.parseInt(txtCantidad.getText()),
						comboPrioridad.getSelectedIndex() + 1, comboTipoVacuna.getSelectedItem().toString(),
						comboRegion.getSelectedIndex() + 1);
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(frame,
						"Se ha producido un error al registrar el alta: NumberFormatException.", "Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(frame, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(frame, "Rellena todos los campos.", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	private boolean validar() {
		JTextField[] textFields = { txtIdEntrega, txtLote, txtFecha, txtCantidad };
		for (JTextField jTextField : textFields) {
			if (jTextField.getText().length() == 0)
				return false;
		}
		return true;
	}
}
