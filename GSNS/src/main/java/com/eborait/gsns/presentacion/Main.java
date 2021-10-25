package com.eborait.gsns.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.eborait.gsns.dominio.controller.GestorEstadisticas;
import com.eborait.gsns.dominio.controller.GestorRepartoVacunas;
import com.eborait.gsns.dominio.controller.GestorVacunacion;

public class Main extends JFrame {

	private JPanel contentPane;
	private JPanel panelActual;
	private PanelMain panelMain;
	private GestorEstadisticas gestorEstadisticas;
	private GestorRepartoVacunas gestorRepartoVacunas;
	private GestorVacunacion gestorVacunacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(0, 0, 900, 500);
		setTitle("Gestión Sistema Nacional de Salud");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		panelMain = new PanelMain(this);
		panelActual = panelMain;
		contentPane.add(panelActual, BorderLayout.CENTER);
		setContentPane(contentPane);

		gestorEstadisticas = new GestorEstadisticas();
		gestorRepartoVacunas = new GestorRepartoVacunas();
		gestorVacunacion = new GestorVacunacion();
	}

	public void cambiarPanel(JPanel nuevoPanel) {
		contentPane.remove(panelActual);
		panelActual = nuevoPanel;
		contentPane.add(panelActual, BorderLayout.CENTER);
		setContentPane(contentPane);
	}

	public PanelMain getPanelMain() {
		return panelMain;
	}

	public GestorEstadisticas getGestorEstadisticas() {
		return gestorEstadisticas;
	}

	public GestorRepartoVacunas getGestorRepartoVacunas() {
		return gestorRepartoVacunas;
	}

	public GestorVacunacion getGestorVacunacion() {
		return gestorVacunacion;
	}

}
