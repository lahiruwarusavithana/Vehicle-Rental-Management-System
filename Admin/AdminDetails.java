package Admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AdminDetails extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminDetails frame = new AdminDetails();
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
	
	//create the SQL connection 
	Connection connection = null ;
	
	public AdminDetails() {
		
		//Connect with Sqlconnection
		connection = Sqlconnection.dbConnector();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 415);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin Details");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(241, 22, 139, 14);
		contentPane.add(lblNewLabel);
		
		//add admin button to enter the add admin interface
		JButton btnNewButton = new JButton("Add Admins");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//create object of AddAdmin class to connect with AdminDetails class using button
				AddAdmin add = new AddAdmin();
				add.setVisible(true);
				add.setLocationRelativeTo(null); //Center the frame 
				dispose();		 //dispose the frame
				
			}
		});
		btnNewButton.setBounds(429, 302, 111, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Admin Home");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//create object of AdminHome class to connect with AdminDetails class using button
				AdminHome ad3 = new AdminHome();
				ad3.setVisible(true);
				ad3.setLocationRelativeTo(null);//Center the frame 
				dispose();		 //dispose the frame
				
			}
		});
		btnNewButton_1.setBounds(42, 302, 111, 23);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 94, 502, 170);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		//Show admin button to load the admin table
		JButton btnNewButton_2 = new JButton("Show Admin");
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					//Retrieve Admin table using SQL query
					String query = "SELECT AdminID,Username FROM admin ";
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
		btnNewButton_2.setBounds(235, 58, 129, 23);
		contentPane.add(btnNewButton_2);
	}
}
