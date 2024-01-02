package Details;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Admin.AdminHome;
import Admin.Sqlconnection;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class DisplayUser extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField userID;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayUser frame = new DisplayUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection connection = null ;
	/**
	 * Create the frame.
	 */
	public DisplayUser() {
		
	
		connection = Sqlconnection.dbConnector();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 385);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Information");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(192, 21, 152, 24);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Show User Table");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				String query = "SELECT UserID,Name,Email,NIC FROM user ";
				java.sql.PreparedStatement pst = connection.prepareStatement(query);
				
				ResultSet rs = pst.executeQuery(); 
				
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
				rs.close();
				pst.close();
				
				}catch(Exception e2){
					JOptionPane.showMessageDialog(null, e2.getMessage());
					
				}
			}
		});
		btnNewButton.setBounds(192, 70, 140, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 111, 479, 143);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("User ID");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(182, 291, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		userID = new JTextField();
		userID.setBounds(278, 289, 109, 20);
		contentPane.add(userID);
		userID.setColumns(10);
		
		JButton UserDelete = new JButton("Delete");
		UserDelete.setFont(new Font("Tahoma", Font.PLAIN, 13));
		UserDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					String query = "DELETE FROM user where UserID = '" + userID.getText() + " ' ";
					java.sql.PreparedStatement pst = connection.prepareStatement(query);
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Deleted");
					
					query = "SELECT * FROM user" ;
					java.sql.PreparedStatement pst1 = connection.prepareStatement(query);
					
					ResultSet rs = pst1.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					rs.close();
					pst.close();
					pst1.close();
					
				}catch(Exception e1){
					
					JOptionPane.showMessageDialog(null, e1.getMessage());

				}
					

			}
		});
		
		UserDelete.setBounds(414, 287, 98, 23);
		contentPane.add(UserDelete);
		
		JButton btnNewButton_2 = new JButton("Admin Home");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminHome ad1 = new AdminHome();
				ad1.setVisible(true);
				ad1.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_2.setBounds(33, 287, 109, 23);
		contentPane.add(btnNewButton_2);
	}
}
