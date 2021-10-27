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

public class PantallaRegistrarVacunacion extends JPanel {
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textDNI;
	private JTextField textFecha;
	private JComboBox<String> comboTipoVacuna;

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

		textNombre = new JTextField();
		textNombre.setBounds(242, 36, 181, 20);
		midPanel.add(textNombre);
		textNombre.setColumns(10);

		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(444, 36, 201, 14);
		midPanel.add(lblApellidos);

		textApellidos = new JTextField();
		textApellidos.setBounds(676, 36, 181, 20);
		midPanel.add(textApellidos);
		textApellidos.setColumns(10);

		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(10, 61, 201, 14);
		midPanel.add(lblDni);

		textDNI = new JTextField();
		textDNI.setBounds(242, 61, 181, 20);
		midPanel.add(textDNI);
		textDNI.setColumns(10);

		JLabel lblVacuna = new JLabel("Tipo Vacuna:");
		lblVacuna.setBounds(10, 86, 201, 14);
		midPanel.add(lblVacuna);

		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(444, 61, 201, 14);
		midPanel.add(lblFecha);

		textFecha = new JTextField();
		textFecha.setBounds(676, 61, 181, 20);
		midPanel.add(textFecha);
		textFecha.setColumns(10);

		JButton btnRegistrarVacunacion = new JButton("Registrar Vacunacion");
		btnRegistrarVacunacion.setBounds(10, 117, 847, 23);
		midPanel.add(btnRegistrarVacunacion);
		try {
			comboTipoVacuna = new JComboBox<>((String[]) frame.getGestorRepartoVacunas().getTipoVacunas().toArray());
			comboTipoVacuna.setBounds(242, 86, 181, 20);
			midPanel.add(comboTipoVacuna);
		} catch (GSNSException gsnse) {
			JOptionPane.showMessageDialog(frame, gsnse.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			throw gsnse;
		}

	}
}
