package User;

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
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JScrollPane;

public class Vehicle extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vehicle frame = new Vehicle();
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
	
	public Vehicle() {
		
		connection = Sqlconnection.dbConnector();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Vehicle");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(178, 11, 85, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Load Table");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query = "SELECT * FROM vehicle ";
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
		btnNewButton.setBounds(142, 35, 121, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 63, 333, 138);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("Home");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home hm = new Home();
				hm.setVisible(true);
				hm.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_1.setBounds(295, 212, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
