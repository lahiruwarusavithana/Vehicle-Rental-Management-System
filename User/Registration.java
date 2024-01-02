package User;
import Admin.AdminHome;
import Admin.MainHomepage;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Admin.Sqlconnection;
import Details.Login;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class Registration extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField email;
	private JTextField username;
	private JTextField pw;
	private JTextField nic;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
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
	Connection connection = null;
	private JTextField tphone;
	
	public Registration() {
		connection = Sqlconnection.dbConnector();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 497, 376);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration Form");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(186, 11, 136, 23);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login log = new Login();
				log.setVisible(true);
				log.setLocationRelativeTo(null);
				dispose();
			try {
					String query = "INSERT INTO user (Name,Email,NIC,Username,Password,Telephone) values (?,?,?,?,?,?)";
									
					PreparedStatement pst = connection.prepareStatement(query);
					
					pst.setString(1,name.getText());
					pst.setString(2,email.getText());
					pst.setString(3,nic.getText());
					pst.setString(4,username.getText());
					pst.setString(5,pw.getText());
					pst.setString(6,tphone.getText());
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Data Saved");
					pst.close();

				}catch(Exception e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(321, 291, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Name :");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(33, 73, 71, 19);
		contentPane.add(lblNewLabel_1);
		
		name = new JTextField();
		name.setBounds(114, 72, 296, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Email :");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(33, 103, 71, 20);
		contentPane.add(lblNewLabel_2);
		
		email = new JTextField();
		email.setBounds(114, 103, 296, 20);
		contentPane.add(email);
		email.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("NIC Number :");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(33, 137, 79, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("User Name :");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(33, 168, 71, 14);
		contentPane.add(lblNewLabel_4);
		
		username = new JTextField();
		username.setBounds(114, 165, 296, 20);
		contentPane.add(username);
		username.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Password :");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(33, 197, 71, 19);
		contentPane.add(lblNewLabel_5);
		
		pw = new JTextField();
		pw.setBounds(114, 196, 296, 20);
		contentPane.add(pw);
		pw.setColumns(10);
		
		nic = new JTextField();
		nic.setBounds(114, 134, 296, 20);
		contentPane.add(nic);
		nic.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Telephone:");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setBounds(33, 238, 71, 14);
		contentPane.add(lblNewLabel_7);
		
		tphone = new JTextField();
		tphone.setBounds(114, 235, 296, 20);
		contentPane.add(tphone);
		tphone.setColumns(10);
	}
}
