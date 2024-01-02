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

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Price extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Price frame = new Price();
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
	
	public Price() {
		connection = Sqlconnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 302);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Price table");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(163, 11, 95, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_4 = new JButton("Home");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home hm = new Home();
				hm.setVisible(true);
				hm.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_4.setBackground(Color.LIGHT_GRAY);
		btnNewButton_4.setBounds(292, 229, 89, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton = new JButton("Load Table");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query = "Select *  From location";
					java.sql.PreparedStatement pst= connection.prepareStatement(query);
					
					ResultSet rs = pst.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					rs.close();
					pst.close();
				}
				catch (Exception el) {
					JOptionPane.showMessageDialog(null, el.getMessage());
				}
					
				
				
			}
		});
		btnNewButton.setBounds(157, 36, 126, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 70, 369, 148);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
