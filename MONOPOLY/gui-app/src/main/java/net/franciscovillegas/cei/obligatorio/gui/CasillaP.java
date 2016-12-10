package net.franciscovillegas.cei.obligatorio.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;

import net.franciscovillegas.cei.obligatorio.common.dto.JugadorDTO;
import net.miginfocom.swing.MigLayout;
import javax.swing.SpringLayout;

public class CasillaP extends JPanel {

	private JFrame frame;
	private JLabel lblJP1;
	private JLabel lblJP2;
	private JLabel lblJP3;
	private JLabel lblJP4;
	private JugadorDTO dueño = null;
	private int precio;
	
	public void setDueño(JugadorDTO jugador){
		this.dueño = jugador;
	}
	
	public JugadorDTO getDueño(){
		return this.dueño;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CasillaP window = new CasillaP();
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
	public CasillaP() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		lblJP1 = new JLabel("JP1");
		lblJP1.setVisible(false);
		springLayout.putConstraint(SpringLayout.NORTH, lblJP1, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblJP1, 10, SpringLayout.WEST, this);
		add(lblJP1);
		
		lblJP2 = new JLabel("JP2");
		lblJP2.setVisible(false);
		springLayout.putConstraint(SpringLayout.WEST, lblJP2, 0, SpringLayout.WEST, lblJP1);
		springLayout.putConstraint(SpringLayout.SOUTH, lblJP2, -10, SpringLayout.SOUTH, this);
		add(lblJP2);
		
		lblJP3 = new JLabel("JP3");
		lblJP3.setVisible(false);
		springLayout.putConstraint(SpringLayout.NORTH, lblJP3, 0, SpringLayout.NORTH, lblJP2);
		add(lblJP3);
		
		lblJP4 = new JLabel("JP4");
		lblJP4.setVisible(false);
		springLayout.putConstraint(SpringLayout.EAST, lblJP3, 0, SpringLayout.EAST, lblJP4);
		springLayout.putConstraint(SpringLayout.SOUTH, lblJP4, 0, SpringLayout.SOUTH, lblJP1);
		springLayout.putConstraint(SpringLayout.EAST, lblJP4, -10, SpringLayout.EAST, this);
		add(lblJP4);
		initialize();
	}


	public JLabel getLabel(int i)
	{
		JLabel j = null;
		
		switch (i) {
		case 0:
			j = lblJP1;
			break;
		case 1:
			j = lblJP2;
			break;
		case 2:
			j = lblJP3;
			break;
		case 3:
			j = lblJP4;
			break;

		default:
			break;
		}
		return j;
	}
	
	private void initialize() {

	}
}
