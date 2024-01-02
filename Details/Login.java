package Details;
import Admin.AdminHome;
import Admin.MainHomepage;



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Admin.Sqlconnection;
import User.Home;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField uname;
	private JTextField upw;
	
	public static String userNamePublic;
	public static int userIdPublic;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	
	public Login() {
		
		connection = Sqlconnection.dbConnector();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(187, 11, 67, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User Name :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(36, 73, 77, 14);
		contentPane.add(lblNewLabel_1);
		
		uname = new JTextField();
		uname.setBounds(135, 71, 221, 20);
		contentPane.add(uname);
		uname.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password : ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(36, 112, 77, 14);
		contentPane.add(lblNewLabel_2);
		
		upw = new JTextField();
		upw.setBounds(135, 110, 221, 20);
		contentPane.add(upw);
		upw.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
		
				
				try {
					
					String query = "SELECT * FROM user WHERE Username = ? and Password = ?";
					java.sql.PreparedStatement pst = connection.prepareStatement(query);
					
					pst.setString(1,uname.getText() );
					pst.setString(2,upw.getText() );
					
					ResultSet rs = pst.executeQuery();
					
					int count = 0 ;
					while(rs.next() ) {
						userIdPublic = rs.getInt("UserId");
						userNamePublic = rs.getString("Username");
						count++;
					}
					
					rs.close();
					pst.close();
					
					if(count ==1)
					{
						JOptionPane.showMessageDialog(null, "Login Success");
						
						dispose();
						Home hm = new Home();
						hm.setVisible(true);
						hm.setLocationRelativeTo(null);
						userNamePublic = uname.getText();
			
					}
					else  {
						JOptionPane.showMessageDialog(null, "Username and password not correct");
						
					}
		
	
					}catch(Exception e1){
					JOptionPane.showMessageDialog(null, e1);
					}
				
				
			}
		});
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(269, 204, 89, 23);
		contentPane.add(btnNewButton);
	}
}
