package Admin;
import Details.Login;
import User.Registration;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;


public class MainHomepage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainHomepage window = new MainHomepage();
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainHomepage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 40));
		frame.getContentPane().setBackground(Color.WHITE);
		

		frame.setBounds(100, 100, 816, 466);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Vehicle Rental Management System");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 32));
		lblNewLabel.setBounds(128, 24, 558, 55);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("New User");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				Registration reg = new  Registration();
				reg.setVisible(true);
				reg.setLocationRelativeTo(null);//Center the frame 
			

			}
		});
		btnNewButton.setBounds(128, 131, 165, 41);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Registered User");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Login lg = new Login();
				lg.setVisible(true);
				lg.setLocationRelativeTo(null);
			
			}
		});
		btnNewButton_1.setBounds(128, 212, 165, 41);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Administrator");
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		
		btnNewButton_2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {	
				
				frame.setVisible(false);
				AdminLogin ad = new AdminLogin();
				ad.setVisible(true);
				ad.setLocationRelativeTo(null);//Center the frame 

			}		
			
		});
		
		btnNewButton_2.setBounds(128, 299, 165, 41);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 30));
		lblNewLabel_1.setIcon(new ImageIcon("Images//project.jpeg"));
		lblNewLabel_1.setBounds(138, 131, 662, 296);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
