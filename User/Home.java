package User;

import Details.Booking_Form;

import Details.Login;
import Details.Booking_Form;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Admin.Sqlconnection;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

	private JPanel contentPane;
	private String welcomeNote;
	private JLabel lblWelcome;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	Connection connection = null ;
	
	public Home() {
		connection = Sqlconnection.dbConnector();
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Home");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(140, 11, 159, 46);
		contentPane.add(lblNewLabel);
		 
		Login lg = new Login();
		lblNewLabel.setText("Welcome  "+lg.userNamePublic);
		
		JButton btnNewButton = new JButton("Display");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Vehicle vhcl = new Vehicle();
				vhcl.setVisible(true);
				
				vhcl.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton.setBounds(306, 81, 86, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Display the Vehicle Type :");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(34, 85, 262, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Display the Location :");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(34, 127, 262, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("Display");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				Price pr = new Price();
				pr.setVisible(true);
				pr.setLocationRelativeTo(null);
				dispose();
			
			}
		});
		btnNewButton_1.setBounds(306, 123, 86, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Booking");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Booking_Form bf = new Booking_Form();
				bf.setVisible(true);
				bf.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_2.setBounds(272, 213, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Login log = new Login();
				log.setVisible(true);
				log.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_3.setBackground(Color.LIGHT_GRAY);
		btnNewButton_3.setBounds(74, 213, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel welcome = new JLabel("");
		welcome.setBounds(35, 29, 95, 14);
		contentPane.add(welcome);
	}
}
