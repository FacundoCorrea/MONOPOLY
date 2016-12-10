package net.franciscovillegas.cei.obligatorio.gui;


import java.awt.EventQueue;

import javax.swing.JFrame;

import net.franciscovillegas.cei.obligatorio.common.Observer;
import net.franciscovillegas.cei.obligatorio.common.Server;
import net.franciscovillegas.cei.obligatorio.common.dto.*;
import net.miginfocom.swing.MigLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.List;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnEntrar;
	private Server server ;
	private DefaultListModel<String> listModel;
	private TableroIU window;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login(null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login(Server server) {
		this.server = server;
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
		frame.setBounds(100, 100, 402, 109);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[][][][][][grow]", "[][][][][grow]"));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, "flowx,cell 0 0 6 5,grow");
		
		JLabel lblUsuario = new JLabel("Usuario");
		panel.add(lblUsuario);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		panel.add(lblContrasea);
		
		textField_1 = new JTextField();
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String usuario = textField.getText();
				String contraseña = textField_1.getText();
				try{
				JugadorDTO jugador = server.getLoginController().autenticar(usuario, contraseña);
					if(jugador != null)
					{
						server.getPartidaController().agregarJugador(jugador);
						List<Observer> observadores = server.getObservers();
						for(Observer o : observadores)
						{
							server.getPartidaController().agregarObserver(o);
						}
						frame.dispose();
						
					}else{
						
					}
				} catch (RemoteException e1)
				{
					e1.printStackTrace();
				}
			}
		});
		panel.add(btnEntrar);
	}

	public void addMessage(String messaje) {
		listModel.addElement(messaje);
	}

	public void setServer(Server server) {
		this.server = server;
	}
}
