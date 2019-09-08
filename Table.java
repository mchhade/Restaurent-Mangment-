package Default;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;

public class Table extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Table() {
		DefaultTableModel OrderModel = new DefaultTableModel();
		
		JButton button = null;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(10, 10));
		//DefaultButtonModel tableModel=new DefaultButtonModel();
		int i=1;
		for(i=1;i <= 100;i++) {
			 button=new JButton(""+i);
			contentPane.add(button);
			button.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Object o=e.getSource();
					JButton b=null;
					if(o instanceof JButton)
						  b = (JButton)o;
					String[] identify= {"id","Aliment","Quantity","Price"};
					OrderModel.setColumnIdentifiers(identify);
					Connection con= null;
					String url ="jdbc:sqlserver://localhost\\locahost:1433;databaseName=Restaurant;integratedSecurity=true;";
					try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); con =DriverManager.getConnection(url);
					if(con!=null)
					{ String query="select * from order_table where table_order="+b.getText();
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
							 price =resultSet2.getInt(1);
							 quantity=resultSet.getInt(4);
							
							}catch (Exception e1) {
								// TODO: handle exception
							}
							
							 price =resultSet2.getInt(1);
							 quantity=resultSet.getInt(4);
							price=quantity*price;
							
							OrderModel.addRow(new Object[] {resultSet.getInt(1),name,quantity,price});
						}
					
						int total=0,i;
						for(i=0;i<OrderModel.getRowCount();i++)
							total=total+Integer.parseInt(OrderModel.getValueAt(i, 3).toString());
						Order order=new Order(Integer.parseInt(b.getText()), OrderModel, total);
						order.setVisible(true);
						order.setExtendedState(JFrame.MAXIMIZED_BOTH);
						order.setResizable(false);
					
						
						}
					}catch(Exception exception) {
						exception.printStackTrace();
					}
					finally {
						try {
							con.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						}
					
				}
			});
			
		}
	
		
		
	}
	
	
}

