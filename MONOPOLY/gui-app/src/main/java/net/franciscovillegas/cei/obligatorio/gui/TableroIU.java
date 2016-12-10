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
import java.awt.event.ActionEvent;

public class TableroIU {

	private JFrame frame;
	private Server server;
	private TableroDTO tablero;
	private List<JugadorDTO> jugadores;
	private DefaultListModel<String> listModel;
	private JButton btnTirarDado;
	private JLabel lblDado;
	private JLabel lblMonopolito;

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
		initialize();
	}
	
	public void setVisible() {
		frame.setVisible(true);
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
		
		CasillaP panel = new CasillaP();
		panel.getLabel(0).setVisible(true); // MOVER FICHA <--------
		panel.setBackground(Color.RED);
		springLayout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 100, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 100, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(panel);
		
		CasillaP panel_1 = new CasillaP();
		springLayout.putConstraint(SpringLayout.WEST, panel_1, 0, SpringLayout.EAST, panel);
		panel_1.setBackground(Color.GREEN);
		springLayout.putConstraint(SpringLayout.NORTH, panel_1, 0, SpringLayout.NORTH, panel);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_1, 0, SpringLayout.SOUTH, panel);
		frame.getContentPane().add(panel_1);
		
		CasillaP panel_2 = new CasillaP();
		springLayout.putConstraint(SpringLayout.EAST, panel_1, 0, SpringLayout.WEST, panel_2);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_2, -414, SpringLayout.SOUTH, frame.getContentPane());
		panel_2.setBackground(Color.BLUE);
		springLayout.putConstraint(SpringLayout.WEST, panel_2, 200, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, panel_2, 0, SpringLayout.NORTH, panel);
		frame.getContentPane().add(panel_2);
		
		CasillaP panel_3 = new CasillaP();
		springLayout.putConstraint(SpringLayout.EAST, panel_3, -20, SpringLayout.EAST, frame.getContentPane());
		panel_3.setBackground(Color.LIGHT_GRAY);
		springLayout.putConstraint(SpringLayout.NORTH, panel_3, 0, SpringLayout.NORTH, panel);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_3, 0, SpringLayout.SOUTH, panel);
		frame.getContentPane().add(panel_3);
		
		CasillaP panel_4 = new CasillaP();
		panel_4.setBackground(Color.GREEN);
		springLayout.putConstraint(SpringLayout.WEST, panel_3, 1, SpringLayout.EAST, panel_4);
		springLayout.putConstraint(SpringLayout.EAST, panel_2, -1, SpringLayout.WEST, panel_4);
		springLayout.putConstraint(SpringLayout.WEST, panel_4, 301, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel_4, 0, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.NORTH, panel_4, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel_4, 401, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(panel_4);
		
		CasillaP panel_5 = new CasillaP();
		panel_5.setBackground(Color.GREEN);
		springLayout.putConstraint(SpringLayout.NORTH, panel_5, 1, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, panel_5, 0, SpringLayout.WEST, panel);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_5, 101, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.EAST, panel_5, 0, SpringLayout.EAST, panel);
		frame.getContentPane().add(panel_5);
		
		CasillaP panel_6 = new CasillaP();
		panel_6.setBackground(Color.MAGENTA);
		springLayout.putConstraint(SpringLayout.NORTH, panel_6, 0, SpringLayout.SOUTH, panel_5);
		springLayout.putConstraint(SpringLayout.WEST, panel_6, 0, SpringLayout.WEST, panel);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_6, 100, SpringLayout.SOUTH, panel_5);
		springLayout.putConstraint(SpringLayout.EAST, panel_6, 0, SpringLayout.EAST, panel);
		frame.getContentPane().add(panel_6);
		
		CasillaP panel_7 = new CasillaP();
		panel_7.setBackground(Color.GREEN);
		springLayout.putConstraint(SpringLayout.NORTH, panel_7, 1, SpringLayout.SOUTH, panel_6);
		springLayout.putConstraint(SpringLayout.WEST, panel_7, 0, SpringLayout.WEST, panel);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_7, 101, SpringLayout.SOUTH, panel_6);
		springLayout.putConstraint(SpringLayout.EAST, panel_7, 0, SpringLayout.EAST, panel);
		frame.getContentPane().add(panel_7);
		
		CasillaP panel_8 = new CasillaP();
		springLayout.putConstraint(SpringLayout.WEST, panel_8, 0, SpringLayout.WEST, panel);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_8, -10, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel_8, 0, SpringLayout.EAST, panel);
		panel_8.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(panel_8);
		
		CasillaP panel_9 = new CasillaP();
		springLayout.putConstraint(SpringLayout.SOUTH, panel_9, -10, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, panel_8, 0, SpringLayout.NORTH, panel_9);
		springLayout.putConstraint(SpringLayout.WEST, panel_9, 0, SpringLayout.WEST, panel_1);
		springLayout.putConstraint(SpringLayout.EAST, panel_9, 0, SpringLayout.EAST, panel_1);
		panel_9.setBackground(Color.GREEN);
		frame.getContentPane().add(panel_9);
		
		CasillaP panel_10 = new CasillaP();
		springLayout.putConstraint(SpringLayout.WEST, panel_10, 0, SpringLayout.WEST, panel_2);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_10, -10, SpringLayout.SOUTH, frame.getContentPane());
		panel_10.setBackground(Color.ORANGE);
		frame.getContentPane().add(panel_10);
		
		CasillaP panel_11 = new CasillaP();
		springLayout.putConstraint(SpringLayout.SOUTH, panel_11, -10, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel_10, -1, SpringLayout.WEST, panel_11);
		springLayout.putConstraint(SpringLayout.WEST, panel_11, 0, SpringLayout.WEST, panel_4);
		springLayout.putConstraint(SpringLayout.EAST, panel_11, 0, SpringLayout.EAST, panel_4);
		panel_11.setBackground(Color.GREEN);
		frame.getContentPane().add(panel_11);
		
		CasillaP panel_12 = new CasillaP();
		springLayout.putConstraint(SpringLayout.WEST, panel_12, 1, SpringLayout.EAST, panel_11);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_12, -10, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel_12, -20, SpringLayout.EAST, frame.getContentPane());
		panel_12.setBackground(Color.CYAN);
		frame.getContentPane().add(panel_12);
		
		CasillaP panel_13 = new CasillaP();
		springLayout.putConstraint(SpringLayout.NORTH, panel_13, 1, SpringLayout.SOUTH, panel_3);
		springLayout.putConstraint(SpringLayout.EAST, panel_13, -20, SpringLayout.EAST, frame.getContentPane());
		panel_13.setBackground(Color.GREEN);
		frame.getContentPane().add(panel_13);
		
		CasillaP panel_14 = new CasillaP();
		springLayout.putConstraint(SpringLayout.SOUTH, panel_13, 0, SpringLayout.NORTH, panel_14);
		springLayout.putConstraint(SpringLayout.EAST, panel_14, -20, SpringLayout.EAST, frame.getContentPane());
		panel_14.setBackground(Color.MAGENTA);
		springLayout.putConstraint(SpringLayout.NORTH, panel_14, 0, SpringLayout.NORTH, panel_6);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_14, 0, SpringLayout.SOUTH, panel_6);
		frame.getContentPane().add(panel_14);
		
		CasillaP panel_15 = new CasillaP();
		springLayout.putConstraint(SpringLayout.NORTH, panel_12, 2, SpringLayout.SOUTH, panel_15);
		springLayout.putConstraint(SpringLayout.EAST, panel_15, -20, SpringLayout.EAST, frame.getContentPane());
		panel_15.setBackground(Color.GREEN);
		springLayout.putConstraint(SpringLayout.NORTH, panel_15, 0, SpringLayout.NORTH, panel_7);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_15, 0, SpringLayout.SOUTH, panel_7);
		frame.getContentPane().add(panel_15);
		
		JPanel panel_16 = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel_16, 5, SpringLayout.NORTH, panel_5);
		springLayout.putConstraint(SpringLayout.WEST, panel_16, -90, SpringLayout.EAST, panel_1);
		springLayout.putConstraint(SpringLayout.EAST, panel_16, -10, SpringLayout.EAST, panel_1);
		panel_16.setBackground(Color.BLUE);
		frame.getContentPane().add(panel_16);
		
		JPanel panel_17 = new JPanel();
		springLayout.putConstraint(SpringLayout.EAST, panel_17, -131, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel_14, 11, SpringLayout.EAST, panel_17);
		springLayout.putConstraint(SpringLayout.WEST, panel_13, 11, SpringLayout.EAST, panel_17);
		springLayout.putConstraint(SpringLayout.WEST, panel_17, 121, SpringLayout.EAST, panel_16);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_16, 0, SpringLayout.SOUTH, panel_17);
		
		JLabel lblSuerte = new JLabel("Suerte");
		panel_16.add(lblSuerte);
		springLayout.putConstraint(SpringLayout.NORTH, panel_17, 6, SpringLayout.SOUTH, panel_4);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_17, 5, SpringLayout.SOUTH, panel_5);
		panel_17.setBackground(Color.ORANGE);
		frame.getContentPane().add(panel_17);
		
		JLabel lblDestino = new JLabel("Destino");
		panel_17.add(lblDestino);
		
		btnTirarDado = new JButton("Tirar Dado");
		springLayout.putConstraint(SpringLayout.SOUTH, btnTirarDado, -118, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, panel_9, 8, SpringLayout.SOUTH, btnTirarDado);
		springLayout.putConstraint(SpringLayout.EAST, btnTirarDado, 0, SpringLayout.EAST, panel_1);
		frame.getContentPane().add(btnTirarDado);
		
		JButton button = new JButton("Si");
		springLayout.putConstraint(SpringLayout.NORTH, panel_11, 8, SpringLayout.SOUTH, button);
		springLayout.putConstraint(SpringLayout.NORTH, panel_10, 8, SpringLayout.SOUTH, button);
		springLayout.putConstraint(SpringLayout.NORTH, button, 0, SpringLayout.NORTH, btnTirarDado);
		frame.getContentPane().add(button);
		
		JButton btnNo = new JButton("No");
		springLayout.putConstraint(SpringLayout.EAST, btnNo, -160, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel_15, 40, SpringLayout.EAST, btnNo);
		springLayout.putConstraint(SpringLayout.EAST, button, -6, SpringLayout.WEST, btnNo);
		springLayout.putConstraint(SpringLayout.NORTH, btnNo, 0, SpringLayout.NORTH, btnTirarDado);
		frame.getContentPane().add(btnNo);
		
		lblMonopolito = new JLabel("MONOPOLITO");
		springLayout.putConstraint(SpringLayout.NORTH, lblMonopolito, 60, SpringLayout.SOUTH, panel_17);
		springLayout.putConstraint(SpringLayout.WEST, lblMonopolito, -42, SpringLayout.WEST, button);
		springLayout.putConstraint(SpringLayout.EAST, lblMonopolito, -94, SpringLayout.WEST, panel_14);
		lblMonopolito.setForeground(Color.BLACK);
		lblMonopolito.setBackground(new Color(255, 0, 0));
		frame.getContentPane().add(lblMonopolito);
		
		lblDado = new JLabel("Dado");
		springLayout.putConstraint(SpringLayout.WEST, lblDado, 44, SpringLayout.EAST, panel_7);
		springLayout.putConstraint(SpringLayout.SOUTH, lblDado, -6, SpringLayout.NORTH, btnTirarDado);
		frame.getContentPane().add(lblDado);
		
		JLabel lblPregunta = new JLabel("Pregunta");
		springLayout.putConstraint(SpringLayout.SOUTH, lblMonopolito, -73, SpringLayout.NORTH, lblPregunta);
		springLayout.putConstraint(SpringLayout.SOUTH, lblPregunta, -6, SpringLayout.NORTH, button);
		springLayout.putConstraint(SpringLayout.EAST, lblPregunta, -64, SpringLayout.WEST, panel_15);
		frame.getContentPane().add(lblPregunta);
		
		btnTirarDado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int n = server.getDadoController().tirarDado(); 
					String f = String.valueOf(n);
					lblDado.setText(f);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
	}
	
	public void CambiarPosicion(int n)
	{
		if(n == 0)
		{
			
		}
	}
	public void addMessage(String messaje) {
		listModel.addElement(messaje);
	}
	public void setServer(Server server) {
		this.server = server;
	}
	
	public void actualizar() throws RemoteException
	{
		jugadores = server.getPartidaController().listarJugadores();
		String nombres = "";
		for(JugadorDTO j : jugadores)
		{
			nombres += j.getNombre();
			System.out.println(j.getNombre());
		}
		lblMonopolito.setText(nombres);
	}
}
