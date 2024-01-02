package Admin;

import Details.Price_Table;
import User.DisplayDriver;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Details.DisplayUser;
import User.DisplayDriver;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class AdminHome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminHome frame = new AdminHome();
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
	public AdminHome() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin Home Page");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(207, 11, 167, 24);
		contentPane.add(lblNewLabel);
		
		
		JButton d_user = new JButton("Display User");
		d_user.setFont(new Font("Times New Roman", Font.BOLD, 14));
		d_user.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DisplayUser du = new DisplayUser();
				du.setVisible(true);
				du.setLocationRelativeTo(null);  
				dispose();		               
			
			}
		});
		d_user.setBounds(105, 70, 167, 23);
		contentPane.add(d_user);
		
		JButton btnNewButton_1 = new JButton("Display Driver");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DisplayDriver dv = new DisplayDriver();
				dv.setVisible(true);
				dv.setLocationRelativeTo(null); 
				dispose();		 
			
			}
		});
		btnNewButton_1.setBounds(105, 128, 167, 23);
		contentPane.add(btnNewButton_1);
		
		//Display vehicle type button to enter the vehicle type interface 
		JButton btnNewButton_2 = new JButton("Display Vehicle Type");
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DisplayVtype vtype = new DisplayVtype();
				vtype.setVisible(true);
				vtype.setLocationRelativeTo(null);//Center the frame 
				dispose();		 //dispose the frame
			
			}
		});
		btnNewButton_2.setBounds(105, 245, 167, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Location Price");
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Price_Table pt = new Price_Table();
				pt.setVisible(true);
				pt.setLocationRelativeTo(null);
				dispose();	
		
				
			}
		});
		btnNewButton_3.setBounds(105, 187, 167, 23);
		contentPane.add(btnNewButton_3);
		
		//AdminDetails button to enter the admin details interface
		JButton btnNewButton = new JButton("Admin Details");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminDetails ae = new AdminDetails();
				ae.setVisible(true);
				ae.setLocationRelativeTo(null);//Center the frame 
				dispose();		 //dispose the frame

			}
			
		});
		btnNewButton.setBounds(105, 299, 167, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("Images\\project2.jpg")); //selecting image for the Admin Home
		lblNewLabel_1.setBounds(0, 0, 574, 367);
		contentPane.add(lblNewLabel_1);
	}
}
