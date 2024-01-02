package User;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import Admin.AdminHome;
import Admin.Sqlconnection;
import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class DisplayDriver extends JFrame {

	private JPanel contentPane;
	private JTextField driverID;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayDriver frame = new DisplayDriver();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection = null;
	/**
	 * Create the frame.
	 */
	public DisplayDriver() {
		connection = Sqlconnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 617, 465);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDisplayDriver = new JLabel("Display Driver");
		lblDisplayDriver.setForeground(Color.WHITE);
		lblDisplayDriver.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblDisplayDriver.setBounds(249, 11, 103, 31);
		contentPane.add(lblDisplayDriver);
		
		JButton btnLoadTable = new JButton("Load Table");
		btnLoadTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "select * from driver";
					
					PreparedStatement pts1 = connection.prepareStatement(query);
					ResultSet db = pts1.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(db));
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
			
			}
		});
		btnLoadTable.setBounds(249, 65, 103, 20);
		contentPane.add(btnLoadTable);
		
		JLabel lblDriverId = new JLabel("Driver ID");
		lblDriverId.setForeground(Color.WHITE);
		lblDriverId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDriverId.setBounds(324, 312, 47, 14);
		contentPane.add(lblDriverId);
		
		driverID = new JTextField();
		driverID.setBounds(381, 310, 61, 20);
		contentPane.add(driverID);
		driverID.setColumns(10);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				   try {
						
						String query = "DELETE FROM driver where DriverID = '" + driverID.getText() + " ' ";
						
						java.sql.PreparedStatement pst = connection.prepareStatement(query);
						
						pst.execute();
						
						JOptionPane.showMessageDialog(null,"" + driverID.getText() +" "+ "Deleted");
						
						query = "SELECT * FROM driver" ;
						java.sql.PreparedStatement pst1 = connection.prepareStatement(query);
						
						ResultSet rs = pst1.executeQuery();
						
						table.setModel(DbUtils.resultSetToTableModel(rs));
						
						rs.close();
						pst.close();
						pst1.close();
						
					}catch(Exception e1){
						
						JOptionPane.showMessageDialog(null, e1.getMessage());

					}
			}
		});
		btnDelete.setBounds(468, 309, 89, 23);
		contentPane.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 96, 520, 182);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Admin Home");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminHome ad4 = new AdminHome();
				ad4.setVisible(true);
				ad4.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton.setBounds(37, 309, 135, 23);
		contentPane.add(btnNewButton);
		
		JButton editdriver = new JButton("Edit ");
		editdriver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				Edit_Driver ed = new Edit_Driver();
				ed.setVisible(true);
				ed.setLocationRelativeTo(null);
				dispose();
				
				
			}
		});
		editdriver.setBounds(182, 309, 89, 23);
		contentPane.add(editdriver);
	}
}
