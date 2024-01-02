package User;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Admin.Sqlconnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Edit_Driver extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */

	
	public static void main(String[] args) {
		

		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Edit_Driver frame = new Edit_Driver();
					frame.setVisible(true);
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
	
	public Edit_Driver() {
		
		connection = Sqlconnection.dbConnector();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 409);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit Driver");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(246, 33, 89, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Driver ID :");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(99, 110, 85, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(216, 107, 181, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Driver Name :");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(99, 147, 85, 14);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(216, 143, 181, 23);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("NIC :");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(99, 181, 85, 14);
		contentPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(216, 177, 181, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Update Driver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					
			   
					String query = "UPDATE driver SET driverid = '" + textField.getText() +" ', name ='"+textField_1.getText()+"', nic = '"+textField_2.getText()+"' where driverid ='"+textField.getText()+"' ";
					java.sql.PreparedStatement pst = connection.prepareStatement(query);
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null,  "Driver details Updated");
					
					pst.close();
					
					query = "SELECT * FROM driver" ;
					java.sql.PreparedStatement pst1 = connection.prepareStatement(query);
					
					ResultSet rs = pst1.executeQuery();

					rs.close();
					pst1.close();
					
				}catch(Exception e1){
					
					JOptionPane.showMessageDialog(null, e1.getMessage());

				}
					

			}
		});
		btnNewButton.setBounds(342, 281, 111, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DisplayDriver dd = new DisplayDriver();
				dd.setVisible(true);
				dd.setLocationRelativeTo(null);
				dispose();
				
				
			}
		});
		btnNewButton_1.setBounds(80, 281, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
