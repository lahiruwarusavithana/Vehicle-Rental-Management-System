package Details;
import User.Home;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Admin.Sqlconnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Booking_Form extends JFrame {

	private JPanel contentPane;
	private JTextField lid;
	private JTextField date;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Booking_Form frame = new Booking_Form();
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
	public Booking_Form() {
		
		connection = Sqlconnection.dbConnector();
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 385);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Booking Form");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(200, 41, 178, 20);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
		
			Login lg = new Login();
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query = "INSERT INTO `booking`(`user_id`, `LocationID`, `Date`) VALUES (?,?,?)";
									
					PreparedStatement ps = connection.prepareStatement(query);
					
					
					ps.setInt(1,lg.userIdPublic);
					ps.setString(2,lid.getText());
					ps.setString(3,date.getText());
					
					ps.execute();
					
					JOptionPane.showMessageDialog(null, "Data Saved");
					
					ps.close();

				}catch(Exception e1){
					
					e1.printStackTrace();
				}
				
				Home mn = new Home();
				
				mn.setVisible(true);
				
				mn.setLocationRelativeTo(null);
				
				dispose();
				
				
			
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(422, 292, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("LocationID");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(63, 131, 100, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Select Date");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(63, 226, 116, 14);
		contentPane.add(lblNewLabel_3);
		
		lid = new JTextField();
		lid.setBounds(242, 129, 178, 20);
		contentPane.add(lid);
		lid.setColumns(10);
		
		date = new JTextField();
		date.setBounds(242, 224, 178, 20);
		contentPane.add(date);
		date.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("User Home");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Home hm = new Home();
				
				hm.setVisible(true);
				
				hm.setLocationRelativeTo(null);
				
				dispose();
			}
		});
		btnNewButton_1.setBounds(40, 292, 116, 23);
		contentPane.add(btnNewButton_1);
	}
}
