package com.eborait.gsns.presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.eborait.gsns.dominio.entitymodel.excepciones.GSNSException;

/**
 * Pantalla alta de nuevo lote de vacunas.
 *
 * @author Jorge Fernández Escolano
 * @author Roberto Esteban Olivares
 * @version 1.0
 * @since 1.0
 */
public class PantallaAltaNuevoLote extends JPanel {

	/** El serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** El label de id de lote. */
	private JLabel lblIdLote;

	/** El campo de texto de fecha de alta. */
	private JTextField txtFechaAlta;

	/** El campo de texto de cantidad. */
	private JTextField txtCantidad;

	/** El campo de texto de nombre de la vacuna. */
	private JTextField txtNombreVacuna;

	/** El campo de texto de farmacéutica. */
	private JTextField txtFarmaceutica;

	/** El campo de texto de fecha de aprobación. */
	private JTextField txtFechaAprobacion;

	/**
	 * Crea el panel.
	 * 
	 * @param frame JFrame de la aplicación.
	 * @throws GSNSException Si se produce una excepción de la aplicación.
	 */
	public PantallaAltaNuevoLote(final Main frame) throws GSNSException {
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

		JLabel lblTitulo = new JLabel("Gestión Sistema Nacional de Salud/Alta nuevo lote de vacunas");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		topPanel.add(lblTitulo);
		midPanel.setLayout(null);

		JLabel lblIdLoteTitulo = new JLabel("Identificador del lote:");
		lblIdLoteTitulo.setBounds(10, 36, 201, 14);
		midPanel.add(lblIdLoteTitulo);

		lblIdLote = new JLabel();
		lblIdLote.setBounds(242, 36, 181, 20);
		midPanel.add(lblIdLote);

		try {
			lblIdLote.setText(String.valueOf(frame.getGestorRepartoVacunas().generarIdLote()));
		} catch (GSNSException gsnse) {
			JOptionPane.showMessageDialog(frame, gsnse.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			throw gsnse;
		}
		JLabel lblFechaAlta = new JLabel("Fecha alta:");
		lblFechaAlta.setBounds(10, 64, 201, 14);
		midPanel.add(lblFechaAlta);

		txtFechaAlta = new JTextField();
		txtFechaAlta.setColumns(10);
		txtFechaAlta.setBounds(242, 64, 181, 20);
		midPanel.add(txtFechaAlta);

		JLabel lblCantidad = new JLabel("Cantidad de vacunas:");
		lblCantidad.setBounds(10, 92, 201, 14);
		midPanel.add(lblCantidad);

		txtCantidad = new JTextField();
		txtCantidad.setBounds(242, 92, 181, 20);
		midPanel.add(txtCantidad);
		txtCantidad.setColumns(10);

		JLabel lblNombreVacuna = new JLabel("Nombre de vacuna:");
		lblNombreVacuna.setBounds(444, 36, 201, 14);
		midPanel.add(lblNombreVacuna);

		txtNombreVacuna = new JTextField();
		txtNombreVacuna.setBounds(676, 36, 181, 20);
		midPanel.add(txtNombreVacuna);
		txtNombreVacuna.setColumns(10);

		JLabel lblFarmaceutica = new JLabel("Farmacéutica:");
		lblFarmaceutica.setBounds(444, 64, 201, 14);
		midPanel.add(lblFarmaceutica);

		txtFarmaceutica = new JTextField();
		txtFarmaceutica.setBounds(676, 64, 181, 20);
		midPanel.add(txtFarmaceutica);
		txtFarmaceutica.setColumns(10);

		JLabel lblFechaAprobacion = new JLabel("Fecha de aprobación:");
		lblFechaAprobacion.setBounds(444, 92, 181, 14);
		midPanel.add(lblFechaAprobacion);

		txtFechaAprobacion = new JTextField();
		txtFechaAprobacion.setBounds(676, 92, 181, 20);
		midPanel.add(txtFechaAprobacion);
		txtFechaAprobacion.setColumns(10);

		JLabel lblLote = new JLabel("Lote");
		lblLote.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLote.setBounds(10, 11, 413, 14);
		midPanel.add(lblLote);

		JLabel lblVacuna = new JLabel("Vacuna");
		lblVacuna.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblVacuna.setBounds(444, 11, 413, 14);
		midPanel.add(lblVacuna);

		JButton btnRegistrarAlta = new JButton("Registrar alta");
		btnRegistrarAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarLote(frame);
			}
		});
		btnRegistrarAlta.setBounds(10, 131, 847, 23);
		midPanel.add(btnRegistrarAlta);

	}

	/**
	 * Invoca al gestor para realizar el alta del lote de vacunas.
	 * 
	 * @param frame JFrame de la aplicación.
	 */
	private void registrarLote(Main frame) {
		if (validar()) {
			try {
				frame.getGestorRepartoVacunas().altaNuevoLoteVacunas(lblIdLote.getText(), txtFechaAlta.getText(),
						Integer.parseInt(txtCantidad.getText()), txtNombreVacuna.getText(), txtFarmaceutica.getText(),
						txtFechaAprobacion.getText());
			} catch (GSNSException gsnse) {
				JOptionPane.showMessageDialog(frame, gsnse.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(frame, "Rellena todos los campos.", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	/**
	 * Valida los campos de texto.
	 * 
	 * @return true si la validación es correcta, false de lo contrario.
	 */
	private boolean validar() {
		JTextField[] textFields = { txtFechaAlta, txtCantidad, txtNombreVacuna, txtFarmaceutica, txtFechaAprobacion };
		for (JTextField jTextField : textFields) {
			if (jTextField.getText().length() == 0)
				return false;
		}
		return true;
	}
}
