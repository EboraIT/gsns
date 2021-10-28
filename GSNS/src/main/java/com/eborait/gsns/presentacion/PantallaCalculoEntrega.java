package com.eborait.gsns.presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.eborait.gsns.dominio.entitymodel.RegionEnum;

import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class PantallaCalculoEntrega extends JPanel {
	private JTextField txtIA;
	private JComboBox<String> comboRegion;

	public PantallaCalculoEntrega(final Main frame) {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		JLabel lblCalculoDeReparto = new JLabel("Calculo de Reparto de Vacunas");
		lblCalculoDeReparto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCalculoDeReparto.setBounds(10, 11, 263, 25);
		add(lblCalculoDeReparto);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.cambiarPanel(frame.getPanelMain());
			}
		});
		btnAtras.setBounds(271, 11, 89, 23);
		add(btnAtras);
		
		JLabel lblNewLabel = new JLabel("Seleccione una región:");
		lblNewLabel.setBounds(10, 73, 125, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Población:");
		lblNewLabel_1.setBounds(10, 109, 63, 14);
		add(lblNewLabel_1);
		
		comboRegion = new JComboBox<String>(RegionEnum.getNombres());
		comboRegion.setBounds(140, 73, 93, 14);
		add(comboRegion);
		
		JLabel lblPoblacion = new JLabel(comboRegion.getSelectedItem().toString());
		lblPoblacion.setBounds(83, 109, 46, 14);
		add(lblPoblacion);
		
		JLabel lblNewLabel_2 = new JLabel("Introduzca la IA:");
		lblNewLabel_2.setBounds(10, 152, 107, 14);
		add(lblNewLabel_2);
		
		txtIA = new JTextField();
		txtIA.setBounds(102, 149, 86, 20);
		add(txtIA);
		txtIA.setColumns(10);
		
		JButton btnCalcularReparto = new JButton("Calcular");
		btnCalcularReparto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcularReparto(frame);
			}
		});
		btnCalcularReparto.setBounds(10, 192, 430, 23);
		add(btnCalcularReparto);
		
		JLabel lblNewLabel_3 = new JLabel("Vacunas a repartir:");
		lblNewLabel_3.setBounds(133, 240, 97, 14);
		add(lblNewLabel_3);
		
		JLabel lblCalculo = new JLabel("");
		lblCalculo.setBounds(240, 240, 46, 14);
		add(lblCalculo);
		
		
		
	}
}
