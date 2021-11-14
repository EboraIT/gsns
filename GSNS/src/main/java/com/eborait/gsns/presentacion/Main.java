package com.eborait.gsns.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import java.util.logging.Logger;
import java.util.logging.Level;

import com.eborait.gsns.dominio.controller.GestorGSNS;

/**
 * Pantalla principal de la aplicación.
 *
 * @author Jorge Fernández Escolano
 * @author Roberto Esteban Olivares
 * @version 1.0
 * @since 1.0
 */
public class Main extends JFrame {

	/** El serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** El content pane. */
	private JPanel contentPane;

	/** El panel actual. */
	private JPanel panelActual;

	/** El panel principal. */
	private PanelMain panelMain;

	/** El gestor de la aplicación. */
	private transient GestorGSNS gestorGSNS;

	/**
	 * Constante Error.
	 */
	public static final String ERROR = "Error";

	/**
	 * Constante Información.
	 */
	public static final String INFO = "Información";

	/**
	 * Constante Advertencia.
	 */
	public static final String WARNING = "Advertencia";

	/** Objeto Logger. */
	private static final Logger LOG = Logger.getLogger(Main.class.getName());

	/**
	 * Lanza la aplicación.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					LOG.log(Level.SEVERE, "", e);
				}
			}
		});
	}

	/**
	 * Crea el JFrame.
	 */
	public Main() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(0, 0, 900, 500);
		setTitle("Gestión Sistema Nacional de Salud");
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		panelMain = new PanelMain(this);
		panelActual = panelMain;
		contentPane.add(panelActual, BorderLayout.CENTER);
		setContentPane(contentPane);
		this.gestorGSNS = new GestorGSNS();
	}

	/**
	 * Sustituye el panel actual por uno nuevo.
	 *
	 * @param nuevoPanel el nuevo panel
	 */
	public void cambiarPanel(JPanel nuevoPanel) {
		contentPane.remove(panelActual);
		panelActual = nuevoPanel;
		contentPane.add(panelActual, BorderLayout.CENTER);
		setContentPane(contentPane);
	}

	/**
	 *
	 * @return El panel principal.
	 */
	public PanelMain getPanelMain() {
		return panelMain;
	}

	/**
	 *
	 * @return El gestor de la aplicación.
	 */
	public GestorGSNS getGestorGSNS() {
		return gestorGSNS;
	}

}
