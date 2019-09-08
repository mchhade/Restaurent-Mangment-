package Default;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Order extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNumberTable;
	private JPanel ViewOrder;
	private JTable table;
	private JScrollPane scrollPane;
	private JPanel Tools;
	private JButton btnEdit;
	private JButton btnDelete;
	private JButton btnNewOrder;
	private JPanel Total;
	private JLabel lblTotal;
	
	private JPanel panel;
	private JButton btnBack;
	private JPanel panel_1;
	private JPanel panel_2;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Order(int number,DefaultTableModel model,int total) {
		
		
		DefaultTableModel OrderMOdel=new DefaultTableModel();
		OrderMOdel=model;
		
		int tableNumber=number;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		ViewOrder = new JPanel();
		contentPane.add(ViewOrder, BorderLayout.CENTER);
		
		table = new JTable(OrderMOdel);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
		ViewOrder.add(scrollPane);
		
		Tools = new JPanel();
		contentPane.add(Tools, BorderLayout.EAST);
		Tools.setLayout(new GridLayout(5, 0, 0, 0));
		
		btnNewOrder = new JButton("NEW ORDER");
		btnNewOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewOrder frame = new NewOrder(tableNumber);
				frame.setResizable(false);
				frame.setVisible(true);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				
			}
		});
		btnNewOrder.setFont(new Font("Tahoma", Font.BOLD, 14));
		Tools.add(btnNewOrder);
		
		btnEdit = new JButton("Change Table");
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 14));
		Tools.add(btnEdit);
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boolean check=true;
				do {
					String newTable=JOptionPane.showInputDialog(null, "Enter New Table Number");
					if(!newTable.isEmpty()) {
					if(Integer.parseInt(newTable)==JOptionPane.CANCEL_OPTION)
					
				try {
					int newtab=Integer.parseInt(newTable);
					String url="jdbc:sqlserver://localhost\\\\locahost:1433;databaseName=Restaurant;integratedSecurity=true;";
					Connection connection=null;
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					connection=DriverManager.getConnection(url);
					Statement statement=connection.createStatement();
					statement.executeUpdate("Update order_table set table_order="+newtab+"where table_order="+number);
					
				}
				 catch (Exception e2) {
					// TODO: handle exception
					check=false;
				}
					}
				} while (check==false);
			
				
		
			}
			});
		btnDelete = new JButton("DELETE");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		Tools.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					String url="jdbc:sqlserver://localhost\\\\locahost:1433;databaseName=Restaurant;integratedSecurity=true;";
					Connection connection=null;
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					connection=DriverManager.getConnection(url);
					Statement statement=connection.createStatement();
					statement.executeUpdate("delete from order_table where table_order="+number);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		Total = new JPanel();
		contentPane.add(Total, BorderLayout.SOUTH);
		Total.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblTotal = new JLabel("TOTAL : "+total);
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotal.setVerticalAlignment(SwingConstants.TOP);
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 35));
		Total.add(lblTotal);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		btnBack = new JButton("");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				model.setRowCount(0);
		dispose();
		
			
		}});
		panel_1.add(btnBack);
		btnBack.setText("Back");
		btnBack.setForeground(Color.BLACK);
		btnBack.setBackground(Color.WHITE);
		
	
		btnBack.setHorizontalAlignment(SwingConstants.LEFT);
		btnBack.setFont(new Font("Showcard Gothic", Font.BOLD | Font.ITALIC, 25));
	
		
		panel_2 = new JPanel();
		panel.add(panel_2);
		
		lblNumberTable = new JLabel("Number Table : "+number);
		panel_2.add(lblNumberTable);
		lblNumberTable.setBackground(new Color(240, 240, 240));
		lblNumberTable.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumberTable.setFont(new Font("Tahoma", Font.BOLD, 35));
		
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				model.setRowCount(0);
				Connection con= null;
				String url ="jdbc:sqlserver://localhost\\locahost:1433;databaseName=Restaurant;integratedSecurity=true;";
				try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); con =DriverManager.getConnection(url);
				if(con!=null)
				{ String query="select * from order_table where table_order="+tableNumber;
					Statement statement=con.createStatement();
					ResultSet resultSet=statement.executeQuery(query);
					while (resultSet.next()) {
						String name=resultSet.getString(2);
						String type=resultSet.getString(3);
						ResultSet resultSet2 = null;
						int price=0;
						int quantity=0;
						try {
							Statement statement2=con.createStatement();
						resultSet2=statement2.executeQuery("select price_food from food where name_food='"+name+"' and class_food='"+type+"'");
						resultSet2.next();
						 
						 }catch(Exception ex) {
							 }
						price =resultSet2.getInt(1);
						 quantity=resultSet.getInt(4);
						 price =resultSet2.getInt(1);
						 quantity=resultSet.getInt(4);
						price=quantity*price;
						
						model.addRow(new Object[] {resultSet.getInt(1),name,quantity,price});
						 }
						
			}
				int totalNew=0,i;
				for(i=0;i<model.getRowCount();i++)
					totalNew=totalNew+Integer.parseInt(model.getValueAt(i, 3).toString());
				lblTotal.setText("TOTAL : "+totalNew);
				}catch (Exception e2) {
					// TODO: handle exception
				}
				
			}	
		});
		model.addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				Connection con= null;
				try{
					
					String url ="jdbc:sqlserver://localhost\\locahost:1433;databaseName=Restaurant;integratedSecurity=true;";
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); con =DriverManager.getConnection(url);
				 	int IndexRow=table.getSelectedRow();
					int IndexColumn=table.getSelectedColumn();
					String id=model.getValueAt(IndexRow, 0).toString();
					String after=model.getValueAt(IndexRow, IndexColumn).toString();
					if(IndexColumn==2) {
						if(after.isEmpty())
							JOptionPane.showMessageDialog(null, "Quantity is Required");
						
						else {
						try {
							int quantity =Integer.parseInt(after);
							if(quantity>0) {
							String query = "update order_table set quantity_order="+quantity+" where id_order="+id;
							Statement st = con.createStatement(); 
							st.executeUpdate(query);
							JOptionPane.showMessageDialog(null, "Quantity changed to "+after);
							int totalNew=0,i;
							for(i=0;i<model.getRowCount();i++)
								totalNew=totalNew+Integer.parseInt(model.getValueAt(i, 3).toString());
							lblTotal.setText("TOTAL : "+totalNew);
							}
							else
								JOptionPane.showMessageDialog(null, "Quantity must be Greatear than 0");
						}catch(Exception ex) {
							JOptionPane.showMessageDialog(null, "Quantity must be Number");
							ex.printStackTrace();
						}	
						}
					}
				}catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				Connection con= null;
				String url ="jdbc:sqlserver://localhost\\locahost:1433;databaseName=Restaurant;integratedSecurity=true;";
				try{Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
				con =DriverManager.getConnection(url);
				
				}catch(Exception ex) {}
				// TODO Auto-generated method stub
				JTable tab=(JTable)e.getSource();
				int colomnIndex= tab.getSelectedColumn();
				int rowIndex=tab.getSelectedRow();
				if(colomnIndex==0){
				String id=model.getValueAt(rowIndex, 0).toString();
				
				int answer=JOptionPane.showConfirmDialog(null, "Are you Sure to Delete ","Delete employer ",JOptionPane.YES_NO_OPTION);
				if(answer==JOptionPane.YES_OPTION) {
					String query="delete from order_table where id_order="+id;
					try {
						Statement st=con.createStatement();
						st.executeUpdate(query);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				int totalNew=0,i;
				for(i=0;i<model.getRowCount();i++)
					totalNew=totalNew+Integer.parseInt(model.getValueAt(i, 3).toString());
				lblTotal.setText("TOTAL : "+totalNew);
					
		}
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
	}
}
