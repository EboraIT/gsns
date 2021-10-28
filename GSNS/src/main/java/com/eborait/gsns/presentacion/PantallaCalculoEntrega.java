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
<<<<<<< HEAD
import javax.swing.border.EmptyBorder;

import com.eborait.gsns.dominio.entitymodel.RegionEnum;
import com.eborait.gsns.dominio.entitymodel.excepciones.GSNSException;

import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

=======
>>>>>>> branch 'Presentation' of git@github.com:escolanojorge/eborait.git
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class PantallaCalculoEntrega extends JPanel {
	private JTextField txtIA;
	private JComboBox<String> comboRegion;
	private JLabel lblCalculo;

	public PantallaCalculoEntrega(final Main frame) {
		setBorder(new EmptyBorder(5, 5, 5, 5));
<<<<<<< HEAD
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
=======
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
>>>>>>> branch 'Presentation' of git@github.com:escolanojorge/eborait.git
		
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
				if(validar()) {
					int reparto = 0;
					try {
						reparto = frame.getGestorRepartoVacunas().calcularEntregasRegion(comboRegion.getSelectedIndex()+1,
								Integer.parseInt(txtIA.getText()));
						lblCalculo.setText("" + String.valueOf(reparto));
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (GSNSException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//lblCalculo.setText("Vacunas a repartir:"+reparto);
					}else {
						JOptionPane.showMessageDialog(frame, "Rellena todos los campos.", "Advertencia",
								JOptionPane.WARNING_MESSAGE);
					}
				}
				
		});
		btnCalcularReparto.setBounds(10, 192, 430, 23);
		add(btnCalcularReparto);
		
		JLabel lblNewLabel_3 = new JLabel("Vacunas a repartir:");
		lblNewLabel_3.setBounds(133, 240, 97, 14);
		add(lblNewLabel_3);
		
		lblCalculo = new JLabel("");
		lblCalculo.setBounds(240, 240, 200, 14);
		add(lblCalculo);
		
		
		
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
