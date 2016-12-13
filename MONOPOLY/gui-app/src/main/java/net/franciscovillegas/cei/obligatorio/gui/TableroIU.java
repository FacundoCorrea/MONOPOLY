package net.franciscovillegas.cei.obligatorio.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.SpringLayout;

import net.franciscovillegas.cei.obligatorio.common.Server;
import net.franciscovillegas.cei.obligatorio.common.dto.*;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.event.ActionEvent;

public class TableroIU {

	private JFrame frame;
	private JugadorDTO jugador;
	private Server server;
	private List<JugadorDTO> jugadores;
	private DefaultListModel<String> listModel;
	private JLabel lblEsperandoJugadores;
	private JButton button;
	private JButton btnNo;
	private JLabel lblDinero;	
	CasillaTipo[][] posiciones = new CasillaTipo[16][1];
	private JButton btnTirarDado;
	private int posicion;
	private JButton btnSalirDeLa;
	private int intento = 0;
	JLabel lblTurno;
	private JLabel lblDado;
	private boolean carcel = false;
	private JLabel lblMonopolito;
	private int posAnterior = -1;
    private List<String> suertes = new ArrayList<String>();
	private List<String> destinos = new ArrayList<String>();
	private JLabel lblInfo;

	private CasillaP panel, panel_1, panel_2, panel_3, panel_4, panel_5, panel_6, panel_7, panel_8, panel_9, panel_10, panel_11, panel_12, panel_13, panel_14, panel_15;
	private JLabel lblUte;
	private JLabel lblOse;
	private JLabel lblInicio;
	private JLabel lblMaldonado;
	private JLabel lblMontevideo;
	private JLabel lblPolicia;
	private JLabel lblParis;
	private JLabel lblToulouse;
	private JLabel lblParadaLibre;
	private JLabel lblMoscu;
	private JLabel lblSanPetersburgo;
	private JLabel lblCarcel;
	private JLabel lblGotham;
	private JLabel lblMetropolis;
	private JLabel lblNewLabel;
	private JLabel label;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel lblNewLabel_3;
	private JLabel label_4;
	private JLabel label_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableroIU window = new TableroIU(null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param server 
	 */
	public TableroIU(Server server) {
		this.server = server;
		jugadores = new ArrayList<JugadorDTO>();
		posicion = 0;
		initialize();
		llenarPosiciones();
		llenarListas();

	}
	
	public void setVisible() {
		frame.setVisible(true);
	}
        private JugadorDTO getSiguienteJugador(JugadorDTO jugador){
		int i = getJugadorPos(jugador);
		i = i++;
		
		if(i >= jugadores.size()){
			i = 0;
		}
		
		return jugadores.get(i);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(50, 50, 528, 543);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		panel = new CasillaP(CasillaTipo.INICIO);
		SpringLayout springLayout_5 = (SpringLayout) panel.getLayout();
		panel.setBackground(Color.RED);
		springLayout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 100, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 100, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(panel);
		
		panel_1 = new CasillaP(CasillaTipo.PROPIEDAD);
		SpringLayout springLayout_6 = (SpringLayout) panel_1.getLayout();
		panel_1.setPrecio(100);
		springLayout.putConstraint(SpringLayout.WEST, panel_1, 0, SpringLayout.EAST, panel);
		panel_1.setBackground(Color.GREEN);
		springLayout.putConstraint(SpringLayout.NORTH, panel_1, 0, SpringLayout.NORTH, panel);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_1, 0, SpringLayout.SOUTH, panel);
		frame.getContentPane().add(panel_1);
		
		panel_2 = new CasillaP(CasillaTipo.SUERTE);
		SpringLayout springLayout_1 = (SpringLayout) panel_2.getLayout();
		springLayout.putConstraint(SpringLayout.EAST, panel_1, 0, SpringLayout.WEST, panel_2);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_2, -414, SpringLayout.SOUTH, frame.getContentPane());
		panel_2.setBackground(Color.BLUE);
		springLayout.putConstraint(SpringLayout.WEST, panel_2, 200, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, panel_2, 0, SpringLayout.NORTH, panel);
		frame.getContentPane().add(panel_2);
		
		panel_3 = new CasillaP(CasillaTipo.POLICIA);
		SpringLayout springLayout_8 = (SpringLayout) panel_3.getLayout();
		springLayout.putConstraint(SpringLayout.EAST, panel_3, -20, SpringLayout.EAST, frame.getContentPane());
		panel_3.setBackground(Color.LIGHT_GRAY);
		springLayout.putConstraint(SpringLayout.NORTH, panel_3, 0, SpringLayout.NORTH, panel);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_3, 0, SpringLayout.SOUTH, panel);
		frame.getContentPane().add(panel_3);
		
		panel_4 = new CasillaP(CasillaTipo.PROPIEDAD);
		SpringLayout springLayout_7 = (SpringLayout) panel_4.getLayout();
		panel_4.setPrecio(150);
		panel_4.setBackground(Color.GREEN);
		springLayout.putConstraint(SpringLayout.WEST, panel_3, 1, SpringLayout.EAST, panel_4);
		springLayout.putConstraint(SpringLayout.EAST, panel_2, -1, SpringLayout.WEST, panel_4);
		springLayout.putConstraint(SpringLayout.WEST, panel_4, 301, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel_4, 0, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.NORTH, panel_4, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel_4, 401, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(panel_4);
		
		panel_5 = new CasillaP(CasillaTipo.PROPIEDAD);
		SpringLayout springLayout_16 = (SpringLayout) panel_5.getLayout();
		panel_5.setPrecio(80);
		panel_5.setBackground(Color.GREEN);
		springLayout.putConstraint(SpringLayout.NORTH, panel_5, 1, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, panel_5, 0, SpringLayout.WEST, panel);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_5, 101, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.EAST, panel_5, 0, SpringLayout.EAST, panel);
		frame.getContentPane().add(panel_5);
		
		panel_6 = new CasillaP(CasillaTipo.SERVICIO);
		SpringLayout springLayout_4 = (SpringLayout) panel_6.getLayout();
		panel_6.setPrecio(210);
		springLayout.putConstraint(SpringLayout.NORTH, panel_6, 101, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_6, -213, SpringLayout.SOUTH, frame.getContentPane());
		panel_6.setBackground(Color.MAGENTA);
		springLayout.putConstraint(SpringLayout.WEST, panel_6, 0, SpringLayout.WEST, panel);
		springLayout.putConstraint(SpringLayout.EAST, panel_6, 0, SpringLayout.EAST, panel);
		frame.getContentPane().add(panel_6);
		
		lblOse = new JLabel("OSE");
		springLayout_4.putConstraint(SpringLayout.WEST, lblOse, 38, SpringLayout.WEST, panel_6);
		springLayout_4.putConstraint(SpringLayout.SOUTH, lblOse, -41, SpringLayout.SOUTH, panel_6);
		panel_6.add(lblOse);
		
		label_3 = new JLabel("$210");
		springLayout_4.putConstraint(SpringLayout.NORTH, label_3, 6, SpringLayout.SOUTH, lblOse);
		springLayout_4.putConstraint(SpringLayout.EAST, label_3, 0, SpringLayout.EAST, lblOse);
		panel_6.add(label_3);
		
		panel_7 = new CasillaP(CasillaTipo.PROPIEDAD);
		panel_7.setPrecio(100);
		SpringLayout springLayout_15 = (SpringLayout) panel_7.getLayout();
		springLayout.putConstraint(SpringLayout.NORTH, panel_7, 101, SpringLayout.SOUTH, panel_5);
		
		lblMetropolis = new JLabel("Metropolis");
		springLayout_16.putConstraint(SpringLayout.NORTH, lblMetropolis, 43, SpringLayout.NORTH, panel_5);
		springLayout_16.putConstraint(SpringLayout.WEST, lblMetropolis, 24, SpringLayout.WEST, panel_5);
		panel_5.add(lblMetropolis);
		
		label_2 = new JLabel("$80");
		springLayout_16.putConstraint(SpringLayout.NORTH, label_2, 1, SpringLayout.SOUTH, lblMetropolis);
		springLayout_16.putConstraint(SpringLayout.EAST, label_2, 0, SpringLayout.EAST, lblMetropolis);
		panel_5.add(label_2);
		panel_7.setPrecio(120);
		panel_7.setBackground(Color.GREEN);
		springLayout.putConstraint(SpringLayout.WEST, panel_7, 0, SpringLayout.WEST, panel);
		springLayout.putConstraint(SpringLayout.EAST, panel_7, 0, SpringLayout.EAST, panel);
		frame.getContentPane().add(panel_7);
		
		panel_8 = new CasillaP(CasillaTipo.CARCEL);
		SpringLayout springLayout_14 = (SpringLayout) panel_8.getLayout();
		springLayout.putConstraint(SpringLayout.SOUTH, panel_7, -2, SpringLayout.NORTH, panel_8);
		springLayout.putConstraint(SpringLayout.WEST, panel_8, 0, SpringLayout.WEST, panel);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_8, -10, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel_8, 0, SpringLayout.EAST, panel);
		
		lblInicio = new JLabel("Inicio");
		springLayout_5.putConstraint(SpringLayout.NORTH, lblInicio, 41, SpringLayout.NORTH, panel);
		springLayout_5.putConstraint(SpringLayout.WEST, lblInicio, 37, SpringLayout.WEST, panel);
		panel.add(lblInicio);
		panel_8.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(panel_8);
		
		panel_9 = new CasillaP(CasillaTipo.PROPIEDAD);
		SpringLayout springLayout_13 = (SpringLayout) panel_9.getLayout();
		panel_9.setPrecio(95);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_9, -10, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, panel_8, 0, SpringLayout.NORTH, panel_9);
		
		lblCarcel = new JLabel("Carcel");
		springLayout_14.putConstraint(SpringLayout.NORTH, lblCarcel, 40, SpringLayout.NORTH, panel_8);
		springLayout_14.putConstraint(SpringLayout.WEST, lblCarcel, 29, SpringLayout.WEST, panel_8);
		lblCarcel.setForeground(Color.WHITE);
		panel_8.add(lblCarcel);
		springLayout.putConstraint(SpringLayout.WEST, panel_9, 0, SpringLayout.WEST, panel_1);
		springLayout.putConstraint(SpringLayout.EAST, panel_9, 0, SpringLayout.EAST, panel_1);
		panel_9.setBackground(Color.GREEN);
		frame.getContentPane().add(panel_9);
		
		panel_10 = new CasillaP(CasillaTipo.DESTINO);
		SpringLayout springLayout_2 = (SpringLayout) panel_10.getLayout();
		springLayout.putConstraint(SpringLayout.WEST, panel_10, 0, SpringLayout.WEST, panel_2);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_10, -10, SpringLayout.SOUTH, frame.getContentPane());
		panel_10.setBackground(Color.ORANGE);
		frame.getContentPane().add(panel_10);
		
		panel_11 = new CasillaP(CasillaTipo.PROPIEDAD);
		SpringLayout springLayout_12 = (SpringLayout) panel_11.getLayout();
		panel_11.setPrecio(200);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_11, -10, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel_10, -1, SpringLayout.WEST, panel_11);
		springLayout.putConstraint(SpringLayout.WEST, panel_11, 0, SpringLayout.WEST, panel_4);
		springLayout.putConstraint(SpringLayout.EAST, panel_11, 0, SpringLayout.EAST, panel_4);
		
		lblMontevideo = new JLabel("Montevideo");
		springLayout_7.putConstraint(SpringLayout.NORTH, lblMontevideo, 42, SpringLayout.NORTH, panel_4);
		springLayout_7.putConstraint(SpringLayout.EAST, lblMontevideo, -22, SpringLayout.EAST, panel_4);
		panel_4.add(lblMontevideo);
		
		label = new JLabel("$150");
		springLayout_7.putConstraint(SpringLayout.NORTH, label, 62, SpringLayout.NORTH, panel_4);
		springLayout_7.putConstraint(SpringLayout.EAST, label, -22, SpringLayout.EAST, panel_4);
		panel_4.add(label);
		panel_11.setBackground(Color.GREEN);
		frame.getContentPane().add(panel_11);
		
		panel_12 = new CasillaP(CasillaTipo.LIBRE);
		SpringLayout springLayout_11 = (SpringLayout) panel_12.getLayout();
		springLayout.putConstraint(SpringLayout.WEST, panel_12, 1, SpringLayout.EAST, panel_11);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_12, -10, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel_12, -20, SpringLayout.EAST, frame.getContentPane());
		panel_12.setBackground(Color.CYAN);
		frame.getContentPane().add(panel_12);
		
		panel_13 = new CasillaP(CasillaTipo.PROPIEDAD);
		SpringLayout springLayout_9 = (SpringLayout) panel_13.getLayout();
		springLayout.putConstraint(SpringLayout.EAST, panel_13, -20, SpringLayout.EAST, frame.getContentPane());
		panel_13.setPrecio(140);
		springLayout.putConstraint(SpringLayout.NORTH, panel_13, 1, SpringLayout.SOUTH, panel_3);
		panel_13.setBackground(Color.GREEN);
		frame.getContentPane().add(panel_13);
		
		panel_14 = new CasillaP(CasillaTipo.SERVICIO);
		SpringLayout springLayout_3 = (SpringLayout) panel_14.getLayout();
		springLayout.putConstraint(SpringLayout.NORTH, panel_14, 201, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel_14, 402, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel_14, -20, SpringLayout.EAST, frame.getContentPane());
		panel_14.setPrecio(210);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_13, 0, SpringLayout.NORTH, panel_14);
		panel_14.setBackground(Color.MAGENTA);
		frame.getContentPane().add(panel_14);
		
		panel_15 = new CasillaP(CasillaTipo.PROPIEDAD);
		SpringLayout springLayout_10 = (SpringLayout) panel_15.getLayout();
		springLayout.putConstraint(SpringLayout.SOUTH, panel_14, -1, SpringLayout.NORTH, panel_15);
		panel_15.setPrecio(100);
		springLayout.putConstraint(SpringLayout.NORTH, panel_12, 2, SpringLayout.SOUTH, panel_15);
		
		lblParadaLibre = new JLabel("Parada Libre");
		springLayout_11.putConstraint(SpringLayout.SOUTH, lblParadaLibre, -40, SpringLayout.SOUTH, panel_12);
		springLayout_11.putConstraint(SpringLayout.EAST, lblParadaLibre, -25, SpringLayout.EAST, panel_12);
		panel_12.add(lblParadaLibre);
		springLayout.putConstraint(SpringLayout.WEST, panel_15, 0, SpringLayout.WEST, panel_3);
		
		lblPolicia = new JLabel("Policia");
		springLayout_8.putConstraint(SpringLayout.NORTH, lblPolicia, 42, SpringLayout.NORTH, panel_3);
		springLayout_8.putConstraint(SpringLayout.WEST, lblPolicia, 26, SpringLayout.WEST, panel_3);
		panel_3.add(lblPolicia);
		springLayout.putConstraint(SpringLayout.EAST, panel_15, -20, SpringLayout.EAST, frame.getContentPane());
		panel_15.setBackground(Color.GREEN);
		springLayout.putConstraint(SpringLayout.NORTH, panel_15, 0, SpringLayout.NORTH, panel_7);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_15, 0, SpringLayout.SOUTH, panel_7);
		frame.getContentPane().add(panel_15);
		
		btnTirarDado = new JButton("Tirar Dado");
		btnTirarDado.setEnabled(false);
		springLayout.putConstraint(SpringLayout.SOUTH, btnTirarDado, -118, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, panel_9, 8, SpringLayout.SOUTH, btnTirarDado);
		
		lblSanPetersburgo = new JLabel("San Petersburgo");
		springLayout_13.putConstraint(SpringLayout.NORTH, lblSanPetersburgo, 43, SpringLayout.NORTH, panel_9);
		springLayout_13.putConstraint(SpringLayout.WEST, lblSanPetersburgo, 10, SpringLayout.WEST, panel_9);
		panel_9.add(lblSanPetersburgo);
		
		label_5 = new JLabel("$95");
		springLayout_13.putConstraint(SpringLayout.NORTH, label_5, 1, SpringLayout.SOUTH, lblSanPetersburgo);
		springLayout_13.putConstraint(SpringLayout.EAST, label_5, -10, SpringLayout.EAST, lblSanPetersburgo);
		panel_9.add(label_5);
		springLayout.putConstraint(SpringLayout.EAST, btnTirarDado, 0, SpringLayout.EAST, panel_1);
		
		lblMaldonado = new JLabel("Maldonado");
		springLayout_6.putConstraint(SpringLayout.NORTH, lblMaldonado, 40, SpringLayout.NORTH, panel_1);
		springLayout_6.putConstraint(SpringLayout.EAST, lblMaldonado, -25, SpringLayout.EAST, panel_1);
		panel_1.add(lblMaldonado);
		
		lblNewLabel = new JLabel("$100");
		springLayout_6.putConstraint(SpringLayout.NORTH, lblNewLabel, 0, SpringLayout.SOUTH, lblMaldonado);
		springLayout_6.putConstraint(SpringLayout.EAST, lblNewLabel, 0, SpringLayout.EAST, lblMaldonado);
		panel_1.add(lblNewLabel);
		frame.getContentPane().add(btnTirarDado);
		
		button = new JButton("Comprar");
		button.setEnabled(false);
		springLayout.putConstraint(SpringLayout.NORTH, panel_10, 8, SpringLayout.SOUTH, button);
		
		JLabel lblDestino = new JLabel("Destino");
		springLayout_2.putConstraint(SpringLayout.WEST, lblDestino, 30, SpringLayout.WEST, panel_10);
		springLayout_2.putConstraint(SpringLayout.SOUTH, lblDestino, -37, SpringLayout.SOUTH, panel_10);
		panel_10.add(lblDestino);
		springLayout.putConstraint(SpringLayout.NORTH, button, 0, SpringLayout.NORTH, btnTirarDado);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				
					server.getPartidaController().comprarPropiedad(jugador, posicion);
					Comprobar(jugador);
					
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}

			}
		});
		frame.getContentPane().add(button);
		
		btnNo = new JButton("TerminarTurno");
		springLayout.putConstraint(SpringLayout.EAST, btnNo, -11, SpringLayout.WEST, panel_15);
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pasarTurno(getSiguienteJugador(jugador));
			}

			});
		btnNo.setEnabled(false);
		springLayout.putConstraint(SpringLayout.NORTH, panel_11, 8, SpringLayout.SOUTH, btnNo);
		
		lblMoscu = new JLabel("Moscu");
		springLayout_12.putConstraint(SpringLayout.WEST, lblMoscu, 27, SpringLayout.WEST, panel_11);
		springLayout_12.putConstraint(SpringLayout.SOUTH, lblMoscu, -40, SpringLayout.SOUTH, panel_11);
		panel_11.add(lblMoscu);
		
		label_4 = new JLabel("$200");
		springLayout_12.putConstraint(SpringLayout.NORTH, label_4, 6, SpringLayout.SOUTH, lblMoscu);
		springLayout_12.putConstraint(SpringLayout.EAST, label_4, -10, SpringLayout.EAST, lblMoscu);
		panel_11.add(label_4);
		springLayout.putConstraint(SpringLayout.EAST, button, -6, SpringLayout.WEST, btnNo);
		springLayout.putConstraint(SpringLayout.NORTH, btnNo, 0, SpringLayout.NORTH, btnTirarDado);
		frame.getContentPane().add(btnNo);
		
		lblMonopolito = new JLabel("MONOPOLITO");
		springLayout.putConstraint(SpringLayout.NORTH, lblMonopolito, 266, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblMonopolito, 220, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblMonopolito, 0, SpringLayout.EAST, panel_2);
		
		JLabel lblSuerte = new JLabel("Suerte");
		springLayout_1.putConstraint(SpringLayout.NORTH, lblSuerte, 42, SpringLayout.NORTH, panel_2);
		springLayout_1.putConstraint(SpringLayout.WEST, lblSuerte, 34, SpringLayout.WEST, panel_2);
		panel_2.add(lblSuerte);
		lblMonopolito.setForeground(Color.BLACK);
		lblMonopolito.setBackground(new Color(255, 0, 0));
		frame.getContentPane().add(lblMonopolito);
		
		lblDado = new JLabel("Dado");
		springLayout.putConstraint(SpringLayout.WEST, lblDado, 44, SpringLayout.EAST, panel_7);
		springLayout.putConstraint(SpringLayout.SOUTH, lblDado, -6, SpringLayout.NORTH, btnTirarDado);
		frame.getContentPane().add(lblDado);
		
		lblDinero = new JLabel("Dinero");
		springLayout.putConstraint(SpringLayout.SOUTH, lblDinero, -32, SpringLayout.NORTH, btnNo);
		springLayout.putConstraint(SpringLayout.EAST, lblDinero, -62, SpringLayout.WEST, panel_15);
		
		lblToulouse = new JLabel("Toulouse");
		springLayout_10.putConstraint(SpringLayout.NORTH, lblToulouse, 43, SpringLayout.NORTH, panel_15);
		springLayout_10.putConstraint(SpringLayout.WEST, lblToulouse, 26, SpringLayout.WEST, panel_15);
		panel_15.add(lblToulouse);
		
		lblNewLabel_2 = new JLabel("$100");
		springLayout_10.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 6, SpringLayout.SOUTH, lblToulouse);
		springLayout_10.putConstraint(SpringLayout.WEST, lblNewLabel_2, 10, SpringLayout.WEST, lblToulouse);
		panel_15.add(lblNewLabel_2);
		frame.getContentPane().add(lblDinero);
		
		lblEsperandoJugadores = new JLabel("Esperando Jugadores...");
		springLayout.putConstraint(SpringLayout.SOUTH, lblMonopolito, -15, SpringLayout.NORTH, lblEsperandoJugadores);
		springLayout.putConstraint(SpringLayout.WEST, lblEsperandoJugadores, 12, SpringLayout.EAST, panel_7);
		
		lblGotham = new JLabel("Gotham");
		springLayout_15.putConstraint(SpringLayout.WEST, lblGotham, 23, SpringLayout.WEST, panel_7);
		springLayout_15.putConstraint(SpringLayout.SOUTH, lblGotham, -41, SpringLayout.SOUTH, panel_7);
		panel_7.add(lblGotham);
		
		label_1 = new JLabel("$100");
		springLayout_15.putConstraint(SpringLayout.NORTH, label_1, 6, SpringLayout.SOUTH, lblGotham);
		springLayout_15.putConstraint(SpringLayout.WEST, label_1, 10, SpringLayout.WEST, lblGotham);
		panel_7.add(label_1);
		springLayout.putConstraint(SpringLayout.SOUTH, lblEsperandoJugadores, -23, SpringLayout.NORTH, lblDado);
		frame.getContentPane().add(lblEsperandoJugadores);
		
		lblInfo = new JLabel("info");
		springLayout.putConstraint(SpringLayout.WEST, lblInfo, 130, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblInfo, -6, SpringLayout.NORTH, lblMonopolito);
		springLayout.putConstraint(SpringLayout.EAST, lblInfo, -42, SpringLayout.WEST, panel_14);
		
		lblUte = new JLabel("UTE");
		springLayout_3.putConstraint(SpringLayout.WEST, lblUte, 40, SpringLayout.WEST, panel_14);
		springLayout_3.putConstraint(SpringLayout.SOUTH, lblUte, -40, SpringLayout.SOUTH, panel_14);
		panel_14.add(lblUte);
		
		lblNewLabel_3 = new JLabel("$210");
		springLayout_3.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 6, SpringLayout.SOUTH, lblUte);
		springLayout_3.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, lblUte);
		panel_14.add(lblNewLabel_3);
		frame.getContentPane().add(lblInfo);
		
		btnSalirDeLa = new JButton("Salir de la Carcel");
		springLayout.putConstraint(SpringLayout.NORTH, lblInfo, 83, SpringLayout.SOUTH, btnSalirDeLa);
		springLayout.putConstraint(SpringLayout.WEST, panel_13, 3, SpringLayout.EAST, btnSalirDeLa);
		
		lblParis = new JLabel("Paris");
		springLayout_9.putConstraint(SpringLayout.WEST, lblParis, 38, SpringLayout.WEST, panel_13);
		springLayout_9.putConstraint(SpringLayout.SOUTH, lblParis, -42, SpringLayout.SOUTH, panel_13);
		panel_13.add(lblParis);
		
		lblNewLabel_1 = new JLabel("$140");
		springLayout_9.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 6, SpringLayout.SOUTH, lblParis);
		springLayout_9.putConstraint(SpringLayout.WEST, lblNewLabel_1, 10, SpringLayout.WEST, lblParis);
		panel_13.add(lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.NORTH, btnSalirDeLa, 6, SpringLayout.SOUTH, panel_2);
		springLayout.putConstraint(SpringLayout.WEST, btnSalirDeLa, 0, SpringLayout.WEST, btnNo);
		btnSalirDeLa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salirCarcel();
			}
		});
		btnSalirDeLa.setEnabled(false);
		frame.getContentPane().add(btnSalirDeLa);
		
		lblTurno = new JLabel("Turno");
		springLayout.putConstraint(SpringLayout.SOUTH, lblTurno, -36, SpringLayout.NORTH, lblInfo);
		springLayout.putConstraint(SpringLayout.EAST, lblTurno, 0, SpringLayout.EAST, button);
		frame.getContentPane().add(lblTurno);
		
		btnTirarDado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int n = server.getDadoController().tirarDado(); 
					String f = String.valueOf(n);
					lblDado.setText(f);
					updatePositions(n);
					btnTirarDado.setEnabled(false);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
	}
	
	public void addMessage(String messaje) {
		listModel.addElement(messaje);
	}
	public void setServer(Server server) {
		this.server = server;
	}

	public void actualizar() throws RemoteException
	{
		try {
			jugadores = server.getPartidaController().listarJugadores();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		System.out.println("Actualizar size: " + jugadores.size());
		
		for(int i=0; i<jugadores.size(); i++){
			switch(i){
			case 0:
				//lblJp_1.setText("JP1: "+jugadores.get(i).getNombre());	
				break;
			case 1:
				//lblJp_2.setText("JP2: "+jugadores.get(i).getNombre());
				break;
			case 2:
				//lblJp_3.setText("JP3: "+jugadores.get(i).getNombre());
				break;
			case 3:
				//lblJp_4.setText("JP4: "+jugadores.get(i).getNombre());
				break;
				default: break;
			} 
		}

	}
	
	public void empezarPartida(JugadorDTO jugador, JugadorDTO recibeTurno) {
		if(jugador.getNombre().equals(recibeTurno.getNombre())) {
			btnTirarDado.setEnabled(true);
		} 
		
		lblEsperandoJugadores.setText("");
		for(int i=1; i<=jugadores.size(); i++){
			panel.getLabel(i).setVisible(true);
		}
		lblTurno.setText("Es el turno de "+jugadores.get(0).getNombre()+" (JP1)");
		posAnterior = 0;
	}
	
	public void setJugador(JugadorDTO jugador) {
		this.jugador = jugador;
		
		mostrarDatos();
	}
        public JugadorDTO getJugador() {
		return this.jugador;
	}

        
	private void mostrarDatos(){
		lblDinero.setText("$"+this.jugador.getDinero());
	}
	
	public void cambiarPosicion(int posAnterior, int jugadorPos, int posicion) {
		getPanel(posAnterior).getLabel(jugadorPos).setVisible(false);
		getPanel(posicion).getLabel(jugadorPos).setVisible(true);
	}
	
	
	
	private CasillaP getPanel(int i){
		CasillaP aux = null;
		switch (i) {
		case 0:
			aux = panel;
			break;
		case 1:
			aux = panel_1;
			break;
		case 2:
			aux = panel_2;
			break;
		case 3:
			aux = panel_4;
			break;
		case 4:
			aux = panel_3;
			break;
		case 5:
			aux = panel_13;
			break;
		case 6:
			aux = panel_14;
			break;
		case 7:
			aux = panel_15;
			break;
		case 8:
			aux = panel_12;
			break;
		case 9:
			aux = panel_11;
			break;
		case 10:
			aux = panel_10;
			break;
		case 11:
			aux = panel_9;
			break;
		case 12:
			aux = panel_8;
			break;
		case 13:
			aux = panel_7;
			break;
		case 14:
			aux = panel_6;
			break;
		case 15:
			aux = panel_5;
			break;
		default:
			break;
		}
		return aux;
	}
	
	public void updatePositions(int dado){
		if(!carcel){
			int aux = posicion+dado;
			if(aux > 15){
				posicion = aux-16;
				this.jugador.setDinero(this.jugador.getDinero()+200);
				mostrarDatos();
			}
			else{
				posicion += dado;
			}
		}
		
		try {
			server.getPartidaController().cambiarPosicion(posAnterior, getJugadorPos(jugador)+1, posicion);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		getOpciones(posAnterior, getJugadorPos(jugador), posicion);
	}

	private int getJugadorPos(JugadorDTO jugador){
		int i = 0;
		int pos = -1;
		while(i < jugadores.size()){
			if(jugadores.get(i).getNombre().equals(jugador.getNombre())){
				pos = i;
			}
			i++;
		}
		return pos;
	}
	
	private void getOpciones(int posAnterior, int jugPos, int posicion){
		getPanel(posAnterior).getLabel(jugPos+1).setVisible(false);
		getPanel(posicion).getLabel(jugPos+1).setVisible(true);
		this.posAnterior = posicion;
		
		CasillaTipo tipo = posiciones[posicion][0];
		
		System.out.println(tipo.toString());
		boolean dueño = false;
		
		if(getPanel(posicion).getDueño() != null){
			dueño = true;
		}
		
		try {
			server.getPartidaController().accion(this.jugador, tipo.toString(), dueño);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public void actualizarTimer(int segundo) {
		lblEsperandoJugadores.setText("La partida empieza en "+segundo+" segundos.");
	}
	
	public void cambiarTurno(int pos, JugadorDTO jugador, JugadorDTO recibeTurno) {
		lblTurno.setText("Es el turno de "+recibeTurno.getNombre());
		if(jugador.getNombre().equals(recibeTurno.getNombre())){
			if(carcel){
				btnSalirDeLa.setEnabled(true);
			}
			else{
				btnSalirDeLa.setEnabled(false);
				btnTirarDado.setEnabled(true);
			}
		}
		else{
			btnTirarDado.setEnabled(false);
		}
	}
	
	
	public void pagarMulta(JugadorDTO dueño ,int cantidad){
		if(jugador.getNombre().equals(dueño.getNombre())){
			this.jugador.setDinero(this.jugador.getDinero()+cantidad);
			mostrarDatos();
		}
	}
	
	public void comprarPropiedad(JugadorDTO jugador, int posicion){
		getPanel(posicion).setDueño(jugador);
		//getPanel(posicion).lblDueÃ±o.setText(jugador.getNombre());
		//getPanel(posicion).lblDueÃ±o.setVisible(true);
		
		if(jugador.getNombre().equals(this.jugador.getNombre())){
			this.jugador.setDinero(this.jugador.getDinero()-getPanel(posicion).getPrecio());
		}
		mostrarDatos();
		pasarTurno(jugador);
	}
	
	private void salirCarcel() {
		if(carcel){
			Random r = new Random();
			int i = r.nextInt(6)+1;
			int i2 = r.nextInt(6)+1;
			
			System.out.println("R1: "+i+", R2: "+i2);
			
			intento++;
			
			if(i == i2){
				carcel = false;
				lblInfo.setText("Has salido de la carcel!");
				intento = 3;
			}
			else{
				lblInfo.setText("Has fallado! "+intento+"/3");
			}
			
			if(intento >= 3){
				btnSalirDeLa.setEnabled(false);
				btnNo.setEnabled(true);
			}
		}
	}

	
	private void pasarTurno(JugadorDTO jugador){
		System.out.println("POS: "+getJugadorPos(jugador));
		intento = 0;
		try {
			server.getPartidaController().cambiarTurno(getJugadorPos(jugador));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		button.setEnabled(false);
		btnNo.setEnabled(false);
	}
	
	public void mostrarOpciones(JugadorDTO jugador, List<String> acciones){
		if(jugador.getNombre().equals(this.jugador.getNombre())){
			if(acciones.contains("PASAR")){
				btnNo.setEnabled(true);
			}
			if(acciones.contains("COMPRAR")){
				button.setEnabled(true);
			}
			if(acciones.contains("MULTA")){
				this.jugador.setDinero(this.jugador.getDinero()-50);
				Comprobar(jugador);
				
				try {
					server.pagarMulta(darDueño(posicion), 50);
				} catch (RemoteException e) {
					e.printStackTrace();
				}
				
				mostrarDatos();
				
				btnNo.setEnabled(true);
			}
			if(acciones.contains("CARCEL")){
				carcel = true;
				posicion = 12;
				updatePositions(0);
			}
			if(acciones.contains("SUERTE")){
				btnNo.setEnabled(true);
				Random r = new Random();
				int i = r.nextInt(4);
				
					String suerte = suertes.get(i);
					
					switch (i) {
					case 0:
						this.jugador.setDinero(this.jugador.getDinero() + 100);
						mostrarDatos();
						break;
					case 1:
						this.jugador.setDinero(this.jugador.getDinero() + 150);
						mostrarDatos();
						break;	
					case 2:
						this.jugador.setDinero(this.jugador.getDinero() + 80);
						mostrarDatos();
						break;

					default:
						break;
					}
					lblInfo.setText("<html>"+suerte+"</html>");	
					Comprobar(jugador);
			}
			if(acciones.contains("DESTINO")){
				btnNo.setEnabled(true);
				Random r = new Random();
				int i = r.nextInt(4);
				String destino = destinos.get(i);
				
				switch (i) {
				case 0:
					this.jugador.setDinero(this.jugador.getDinero() -120);
					mostrarDatos();
					break;
				case 1:
					carcel = true;
					posicion = 12;
					updatePositions(0);			
					break;	
				case 2:
					this.jugador.setDinero(this.jugador.getDinero() - 80);
					mostrarDatos();
					break;
					
				case 3:
					this.jugador.setDinero(this.jugador.getDinero() - 100);
					mostrarDatos();
					break;

				default:
					break;
				}
				
				lblInfo.setText("<html>"+destino+"</html>");
				Comprobar(jugador);
			}
		}
	}
	
	private JugadorDTO darDueño(int posicion){
		return getPanel(posicion).getDueño();
	}
        private void llenarListas(){
		suertes.add("Gana una herencia de $100.");
		suertes.add("Gana la loteria $150.");
		suertes.add("Vende articulos en uso y gana $80.");
	
		destinos.add("Recaudación de impuestos pague $120");
		destinos.add("Vaya a la carcel.");
		destinos.add("Debe contratar un exterminador $80.");
		destinos.add("Se le detiene por cruzar en rojo un semaforo. Pague $100 de multa");
	}
        private void llenarPosiciones(){
		posiciones[0][0] = CasillaTipo.INICIO;
		posiciones[1][0] = CasillaTipo.PROPIEDAD;
		posiciones[2][0] = CasillaTipo.SUERTE;
		posiciones[3][0] = CasillaTipo.PROPIEDAD;
		posiciones[4][0] = CasillaTipo.POLICIA;
		posiciones[5][0] = CasillaTipo.PROPIEDAD;
		posiciones[6][0] = CasillaTipo.SERVICIO;
		posiciones[7][0] = CasillaTipo.PROPIEDAD;
		posiciones[8][0] = CasillaTipo.LIBRE;
		posiciones[9][0] = CasillaTipo.PROPIEDAD;
		posiciones[10][0] = CasillaTipo.DESTINO;
		posiciones[11][0] = CasillaTipo.PROPIEDAD;
		posiciones[12][0] = CasillaTipo.CARCEL;
		posiciones[13][0] = CasillaTipo.PROPIEDAD;
		posiciones[14][0] = CasillaTipo.SERVICIO;
		posiciones[15][0] = CasillaTipo.PROPIEDAD;
	}
        
      private void Comprobar(JugadorDTO jugador)
      {
    	  int dinero = this.jugador.getDinero();
    	  ArrayList<JugadorDTO> bien = new ArrayList<JugadorDTO>();
    	  if(this.jugador.getDinero() <=0)
    	  {
    		  this.jugador.setBancarrota(true);
    		  
    		  lblInfo.setText("Quedas en bancarrota, pierdes el juego");
    		  button.setEnabled(false);
    		  btnNo.setEnabled(false);
    		  btnSalirDeLa.setEnabled(false);
    		  btnTirarDado.setEnabled(false);
    		  this.jugador.setPerdidas(this.jugador.getPerdidas() + 1);
    		  
    	  }
    	  else
    	  {
    		  for(JugadorDTO j : jugadores)
    		  {
    			  if(j.isBancarrota() == false)
    			  {
    				  bien.add(j);
    			  }
    		  }
    	  }
    	  if (bien.size() == 1)
    	  {

    	  }
      }
}
