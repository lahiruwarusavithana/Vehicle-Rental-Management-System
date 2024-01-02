package Admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

/*Inherit from JFrame*/

public class AddAdmin extends JFrame {

	private JPanel contentPane;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					AddAdmin frame = new AddAdmin();
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
	
	private JTextField adUser;
	private JPasswordField adpw;
	
	public AddAdmin() {
		
		//Connect with Sqlconnection
		connection = Sqlconnection.dbConnector();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 609, 416);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit Admin");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(169, 44, 121, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Admin Username");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setBounds(83, 122, 137, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Admin Password");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_3.setBounds(83, 192, 143, 14);
		contentPane.add(lblNewLabel_3);
		
		adUser = new JTextField();
		adUser.setBounds(230, 120, 143, 20);
		contentPane.add(adUser);
		adUser.setColumns(10);
		
		adpw = new JPasswordField();
		adpw.setBounds(230, 190, 143, 20);
		contentPane.add(adpw);
		
		//adding new admin to the system
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				try {
					
					//Insert new username and password into Admin table
					String query = "INSERT INTO admin (Username,Password) values (?,?)";
									
					PreparedStatement pst = connection.prepareStatement(query);
					
					pst.setString(1,adUser.getText()); 
					pst.setString(2,adpw.getText());   
					
					pst.execute(); 
					
					JOptionPane.showMessageDialog(null, "Username and Password added");
					
					pst.close();
				}catch(Exception e1) {
					
					JOptionPane.showMessageDialog(null, "You have entered invalid username or password");
				}
				
				//create object of AdminDetails class to connect with AdminDetails class using button
				AdminDetails adt = new AdminDetails();
				adt.setVisible(true);
				adt.setLocationRelativeTo(null); //Center the frame 
				dispose();		//close the frame
			}
		});
		btnNewButton.setBounds(284, 253, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//create object of AdminDetails class to connect with AddAdmin class using button
				AdminDetails ad6 = new AdminDetails(); 
				ad6.setVisible(true);   
				ad6.setLocationRelativeTo(null);  //Center the frame 
				dispose();  //dispose the frame
			}
		});
		btnNewButton_1.setBounds(84, 253, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("Images//project2.jpg"));
		lblNewLabel_1.setBounds(0, 0, 593, 377);
		contentPane.add(lblNewLabel_1);
	}
}
