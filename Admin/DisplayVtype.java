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
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class DisplayVtype extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField vidtext;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayVtype frame = new DisplayVtype();
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
	public DisplayVtype() {
		
		//Connect with Sqlconnection
		connection = Sqlconnection.dbConnector();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 395);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Vehicle Type");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(224, 31, 117, 24);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Show Vehicle Type");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
				//Retrieve vehicle table from databse using SQL query 
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
		btnNewButton.setBounds(210, 82, 141, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 136, 497, 125);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		//link to admin home page
		JButton btnNewButton_1 = new JButton("Admin Home");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				AdminHome ad2 = new AdminHome();
				ad2.setVisible(true);
				ad2.setLocationRelativeTo(null);//Center the frame 
				dispose();		 //dispose the frame
			}
		});
		btnNewButton_1.setBounds(36, 295, 109, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Edit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//create object of EditVtype class to connect with DisplayVtype class using button
				EditVtype ed = new EditVtype();
				ed.setVisible(true);
				ed.setLocationRelativeTo(null);//Center the frame 
				dispose();		 //dispose the frame

			}
		});
		btnNewButton_2.setBounds(167, 295, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("V_ID");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(312, 299, 39, 14);
		contentPane.add(lblNewLabel_1);
		
		vidtext = new JTextField();
		vidtext.setBounds(370, 296, 62, 20);
		contentPane.add(vidtext);
		vidtext.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Delete");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					//Delete Vehicle type from Vehicle table using SQL query
					String query = "DELETE FROM vehicle where VehicleID = '" + vidtext.getText() + " ' ";
					java.sql.PreparedStatement pst = connection.prepareStatement(query);
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null,"" + vidtext.getText() + " "+"Deleted");
					
					//Again recall to the Vehicle table using SQL query
					query = "SELECT * FROM vehicle" ;
					java.sql.PreparedStatement pst1 = connection.prepareStatement(query);
					
					ResultSet rs = pst1.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					rs.close();
					pst1.close();
					
				}catch(Exception e1){
		
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnNewButton_3.setBounds(442, 295, 89, 23);
		contentPane.add(btnNewButton_3);
	}

}
