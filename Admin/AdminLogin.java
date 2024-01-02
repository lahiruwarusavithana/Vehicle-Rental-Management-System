package Admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;

public class AdminLogin extends JFrame {

	private JPanel contentPane;
	private JTextField User;
	private JPasswordField User_pw;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
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
	public AdminLogin() {
		
		//Connect with Sqlconnection
		connection = Sqlconnection.dbConnector();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin Login Page");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(113, 36, 180, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(52, 107, 82, 14);
		contentPane.add(lblNewLabel_1);
		
		User = new JTextField();
		User.setBounds(175, 106, 180, 20);
		contentPane.add(User);
		User.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(52, 171, 86, 14);
		contentPane.add(lblNewLabel_2);
		
		User_pw = new JPasswordField();
		User_pw.setBounds(175, 170, 180, 20);
		contentPane.add(User_pw);
		
		//Administrator Login button to access the Admin home
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
				try {
					
					//Matching username and password in the database for logging to AdminHome 
					String query = "SELECT * FROM admin WHERE Username = ? and Password = ?";
					java.sql.PreparedStatement pst = connection.prepareStatement(query);
					
					pst.setString(1,User.getText() );      
					pst.setString(2,User_pw.getText() );
					
					ResultSet rs = pst.executeQuery();
					
					int count = 0 ;
					while(rs.next() ) {
						count++;
					}
					
					rs.close();
					pst.close();
					
					//checking Username and password 
					if(count ==1)
					{
						JOptionPane.showMessageDialog(null, "Username and password correct");
					
						//after matching username and password linking to AdminHome using button
					    AdminHome ah = new AdminHome();
					    ah.setVisible(true);
					    ah.setLocationRelativeTo(null);//Center the frame 
						dispose();		 //dispose the frame
						
					}
					else {
						JOptionPane.showMessageDialog(null, "Username and password not correct");
					}
		
					}catch(Exception e1){
						
					JOptionPane.showMessageDialog(null, e1);
					}
	
					}
				
		});
		
		btnNewButton.setBounds(147, 233, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("Images\\Project2.jpg")); //selecting image for the admin login page
		lblNewLabel_3.setBounds(0, 0, 594, 361);
		contentPane.add(lblNewLabel_3);
	}
}
