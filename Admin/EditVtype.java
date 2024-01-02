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
import javax.swing.JSlider;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class EditVtype extends JFrame {

	private JPanel contentPane;
	private JTextField vid;
	private JTextField vtype;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditVtype frame = new EditVtype();
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
	public EditVtype() {
		
		//Connect with Sqlconnection
		connection = Sqlconnection.dbConnector();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 411);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit Vehicle Type");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(214, 30, 161, 24);
		contentPane.add(lblNewLabel);
		
		//Update button in edit vehicle type
		JButton btnNewButton = new JButton("Update");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		try {
			        //Update new Vehicle ID and Vehicle type into Vehicle table using SQL query
	                String query = "UPDATE vehicle SET VehicleID = '" + vid.getText() +" ', Vtype ='"+vtype.getText()+"' where VehicleID ='"+vid.getText()+"' ";
					java.sql.PreparedStatement pst = connection.prepareStatement(query);
					
					pst.execute();
					JOptionPane.showMessageDialog(null,  "Updated");
					
					pst.close();
				
					query = "SELECT * FROM vehicle" ; //reload the vehicle table 
					java.sql.PreparedStatement pst1 = connection.prepareStatement(query);
					ResultSet rs = pst1.executeQuery();

					rs.close();
					pst1.close();
					
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null, e1.getMessage());

				}
			}
		});
		btnNewButton.setBounds(356, 280, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Vehicle ID");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(123, 128, 95, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Vehicle Type");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(122, 201, 115, 14);
		contentPane.add(lblNewLabel_2);
		
		vid = new JTextField();
		vid.setBounds(284, 126, 161, 20);
		contentPane.add(vid);
		vid.setColumns(10);
		
		vtype = new JTextField();
		vtype.setBounds(284, 199, 161, 20);
		contentPane.add(vtype);
		vtype.setColumns(10);
		
		//back button to go back to previous interface
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//create object of DisplayVtype class to connect with EditVtype class using button
				DisplayVtype dvt = new DisplayVtype();
				dvt.setVisible(true);
				dvt.setLocationRelativeTo(null);  //Center the frame 
				dispose();		 //dispose the frame
				
			}
		});
		btnNewButton_1.setBounds(123, 280, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
