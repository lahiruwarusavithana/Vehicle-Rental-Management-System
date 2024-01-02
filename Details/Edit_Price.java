package Details;
import Admin.AdminHome;

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
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;

public class Edit_Price extends JFrame {

	private JPanel contentPane;
	private JTextField locateID;
	private JTextField vehicleID;
	private JTextField drop;
	private JTextField price;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Edit_Price frame = new Edit_Price();
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
	private JTextField pick;
	
	public Edit_Price() {
		
		connection = Sqlconnection.dbConnector();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 385);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit Price");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(222, 20, 178, 25);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					String query = "UPDATE location SET LocationID = '" + locateID.getText() +" ', VehicleID ='"+vehicleID.getText()+"', Dropup ='"+drop.getText()+"',Pickup ='"+pick.getText()+"', Price='"+price.getText()+"' where LocationID ='"+locateID.getText()+"' ";
					java.sql.PreparedStatement pst = connection.prepareStatement(query);
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null,  "Updated");
					
					pst.close();
					
					query = "SELECT * FROM location" ;
					java.sql.PreparedStatement pst1 = connection.prepareStatement(query);
					
					ResultSet rs = pst1.executeQuery();
					
					
					
					rs.close();
					pst1.close();
					
				}catch(Exception e1){
					
					JOptionPane.showMessageDialog(null, e1.getMessage());

				}
				
				
				
				
			}
				
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(389, 287, 110, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Location ID");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(69, 72, 116, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Pickup");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(69, 158, 116, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Dropup");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(69, 195, 116, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Price");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(69, 235, 116, 14);
		contentPane.add(lblNewLabel_5);
		
		locateID = new JTextField();
		locateID.setBounds(217, 70, 149, 20);
		contentPane.add(locateID);
		locateID.setColumns(10);
		
		vehicleID = new JTextField();
		vehicleID.setBounds(217, 109, 149, 20);
		contentPane.add(vehicleID);
		vehicleID.setColumns(10);
		
		drop = new JTextField();
		drop.setBounds(217, 193, 149, 20);
		contentPane.add(drop);
		drop.setColumns(10);
		
		price = new JTextField();
		price.setBounds(217, 233, 149, 20);
		contentPane.add(price);
		price.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Price_Table pt1 = new Price_Table();
				pt1.setVisible(true);
				pt1.setLocationRelativeTo(null);
				dispose();
				
			}
		});
		btnNewButton_1.setBounds(67, 287, 118, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("Vehicle ID");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(69, 108, 116, 14);
		contentPane.add(lblNewLabel_4);
		
		pick = new JTextField();
		pick.setBounds(217, 152, 149, 20);
		contentPane.add(pick);
		pick.setColumns(10);
	}
}
