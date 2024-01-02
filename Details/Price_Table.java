package Details;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Admin.AdminHome;
import Admin.Sqlconnection;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.Color;

public class Price_Table extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Price_Table frame = new Price_Table();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection = null;
	protected JLabel vid;
	protected JLabel vtype;
	/**
	 * Create the frame.
	 */
	public Price_Table() {
		connection = Sqlconnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 538, 385);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPriceTable = new JLabel("Price Table");
		lblPriceTable.setForeground(Color.WHITE);
		lblPriceTable.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblPriceTable.setBounds(198, 27, 126, 22);
		contentPane.add(lblPriceTable);
		
		JButton btnLoadTable = new JButton("Load Table");
		btnLoadTable.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLoadTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try {
					String query = "select * from location" ;
					
					PreparedStatement pat = connection.prepareStatement(query);
					ResultSet rs = pat.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
			
		});
		btnLoadTable.setBounds(198, 60, 102, 22);
		contentPane.add(btnLoadTable);
		
		JButton btnNewButton = new JButton("Edit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Edit_Price ep =new Edit_Price();
				ep.setVisible(true);
				ep.setLocationRelativeTo(null);
				dispose();
		
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(379, 296, 114, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 103, 463, 182);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("Admin Home");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminHome ad5 = new AdminHome();
				ad5.setVisible(true);
				ad5.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_1.setBounds(30, 296, 126, 23);
		contentPane.add(btnNewButton_1);
	}
}
