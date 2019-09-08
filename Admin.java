package Default;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.JComboBox;


import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Admin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private JTextField textField;
	private JTextField NameFieeld;
	private JTextField AgeField;
	private JTextField SalaryField;
	private JTextField PhoneField;
	private JTextField addressField;
	private JTextField NameFood;
	private JTextField priceFood;
	private JTextField textField_1;
	private JTable tableEditFood;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Admin(int idBranche) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JTabbedPane tabbedPane = new JTabbedPane();
		
		tabbedPane.setBorder(null);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		
		contentPane.add(tabbedPane);
		
		JPanel employerView = new JPanel();
		employerView.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				model.setRowCount(0);
				Connection con= null;
				String url ="jdbc:sqlserver://localhost\\locahost:1433;databaseName=Restaurant;integratedSecurity=true;";
				try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); con =DriverManager.getConnection(url);
				if(con!=null)
				{
				
				String query = "select * from person "; 
				Statement st = con.createStatement(); 
				ResultSet rs = st.executeQuery(query);
				while(rs.next()) {
					model.addRow(new Object[] {rs.getInt(1),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11)});
				}
				con.close();
				}
				}catch (Exception ex) {
					ex.printStackTrace();
					// TODO: handle exception
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
			@Override
			public void mouseEntered(MouseEvent e) {
				model.setRowCount(0);
				Connection con= null;
				String url ="jdbc:sqlserver://localhost\\locahost:1433;databaseName=Restaurant;integratedSecurity=true;";
				try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); con =DriverManager.getConnection(url);
				if(con!=null)
				{
				
				String query = "select * from person "; 
				Statement st = con.createStatement(); 
				ResultSet rs = st.executeQuery(query);
				while(rs.next()) {
					model.addRow(new Object[] {rs.getInt(1),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11)});
				}
				con.close();
				}
				}catch (Exception ex) {
					ex.printStackTrace();
					// TODO: handle exception
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
		
		
		
		employerView.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
		//employerView.setBounds(0, 0, 10, 10);
		tabbedPane.add("View Employer",employerView);
		employerView.setLayout(new BoxLayout(employerView, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		
		employerView.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String search=textField.getText();
				model.setRowCount(0);
				Connection con= null;
				String url ="jdbc:sqlserver://localhost\\locahost:1433;databaseName=Restaurant;integratedSecurity=true;";
				try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); con =DriverManager.getConnection(url);
				if(con!=null)
				{
				
				String query = "select * from person where name_person='"+search+"'"; 
				Statement st = con.createStatement(); 
				ResultSet rs = st.executeQuery(query);
				while(rs.next()) {
					model.addRow(new Object[] {rs.getInt(1),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11)});
				}
				con.close();
				}
				}catch (Exception ex) {
					ex.printStackTrace();
					// TODO: handle exception
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
		panel.add(btnSearch);
		
		JPanel View = new JPanel();
		
		View.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
		model=new DefaultTableModel();
		String[] identifier= {"Id","Name","Age","Address","Phone","Fonction","Post","Type","Date Started","Salary"};
		model.setColumnIdentifiers(identifier);
		
		table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		View.setLayout(new FlowLayout(FlowLayout.LEFT));
		View.add(scrollPane);
		employerView.add(View);
		
		JPanel employerEdit = new JPanel();
		employerEdit.setBounds(0, 0, 10, 10);
		tabbedPane.add("Edit Employer",employerEdit);
		
		table = new JTable(model);
		JScrollPane scrollPaneEdit = new JScrollPane(table);
		scrollPaneEdit.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		employerEdit.setLayout(new FlowLayout(FlowLayout.LEFT));
		employerEdit.add(scrollPaneEdit);
		employerView.add(View);
		model.addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent arg0) {
				Connection con= null;
				try{
					
					String url ="jdbc:sqlserver://localhost\\locahost:1433;databaseName=Restaurant;integratedSecurity=true;";
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); con =DriverManager.getConnection(url);
				 	int IndexRow=table.getSelectedRow();
					int IndexColumn=table.getSelectedColumn();
					String id=model.getValueAt(IndexRow, 0).toString();
					String before=model.getValueAt(IndexRow, IndexColumn).toString();
					
					if(IndexColumn==1) {
						if(before.isEmpty())
							JOptionPane.showMessageDialog(null, "Name is Required");
						
							else if(con!=null) {
								JOptionPane.showMessageDialog(null, "Name is Changed to "+before);
								String query = "update person set name_person='"+before+"' where id="+id;
								Statement st = con.createStatement(); 
								st.executeUpdate(query);	
							}
						
							
					}
					if(IndexColumn==2) {
						if(before.isEmpty())
							JOptionPane.showMessageDialog(null, "Age is Required");
						else {
						try {
							int age =Integer.parseInt(before);
							if(age>18) {
							String query = "update person set age_person="+before+" where id="+id;
							Statement st = con.createStatement(); 
							st.executeUpdate(query);
							JOptionPane.showMessageDialog(null, "Age changed to "+before);
							}
							else
								JOptionPane.showMessageDialog(null, "Age must be Greatear than 18");
						}catch(Exception ex) {
							JOptionPane.showMessageDialog(null, "Age must be NUmber");
						}	
						}
					}
					if(IndexColumn==3) {
						if(before.isEmpty())
							JOptionPane.showMessageDialog(null, "Address is Required");
						
							else if(con!=null) {
								
								String query = "update person set address_person='"+before+"' where id="+id;
								Statement st = con.createStatement(); 
								st.executeUpdate(query);	
								JOptionPane.showMessageDialog(null, "Address is Changed to "+before);
							}
						
							
					}
					if(IndexColumn==4) {
						if(before.isEmpty())
							JOptionPane.showMessageDialog(null, "Phone is Required");
						if(before.length()!=8)
							JOptionPane.showMessageDialog(null, "Phone Must be 8 Number");
						else {
						try {
							Integer.parseInt(before);
							String query = "update person set phone_person="+before+" where id="+id;
							Statement st = con.createStatement(); 
							st.executeUpdate(query);	
							JOptionPane.showMessageDialog(null, "Phone is changed to "+before);
						}catch(Exception ex) {
							JOptionPane.showMessageDialog(null, "Phone must be NUmber");
						}
						}
					}
					if(IndexColumn==5) {
						if(before.isEmpty())
							JOptionPane.showMessageDialog(null, "Fonction is Required");
						else if(before.equals("Sale")|| before.equals("Kitchen")||before.equals("Employer") ) {
							if(con!=null) {
							JOptionPane.showMessageDialog(null," Fonction is Changed to "+before);
							String query = "update person set fonction_person='"+before+"' where id="+id;
							Statement st = con.createStatement(); 
							st.executeUpdate(query);
							}
						}
							
							else  {
								
								JOptionPane.showMessageDialog(null, "Error Fonction");
							}
					}
					if(IndexColumn==6) {
						if(before.isEmpty())
							JOptionPane.showMessageDialog(null, "Post is Required");
						else if(before.equals("Chef")|| before.equals("Comie")||before.equals("Maitre") ) {
							if(con!=null) {
							String query = "update person set post_person='"+before+"' where id="+id;
							Statement st = con.createStatement(); 
							st.executeUpdate(query);
							JOptionPane.showMessageDialog(null, "Post is Changed to "+before);}
						}
							
							else  {
								
								JOptionPane.showMessageDialog(null, "Error Post");
							}
					}
					if(IndexColumn==7) {
						if(before.isEmpty())
							JOptionPane.showMessageDialog(null, "Type is Required");
						if(!before.equals("Fixed")|| !before.equals("Sesonal")||!before.equals("Extra") )
							JOptionPane.showMessageDialog(null, "Error Fonction");
							else if(con!=null) {
								JOptionPane.showMessageDialog(null, "Type is Changed to "+before);
								String query = "update person set type_person='"+before+"' where id="+id;
								Statement st = con.createStatement(); 
								st.executeUpdate(query);	
							}
					}
					if(IndexColumn==9) {
						if(before.isEmpty())
							JOptionPane.showMessageDialog(null, "Salary is Required");
						else {
						try {
							Integer.parseInt(before);
							String query = "update person set salary_person="+before+" where id="+id;
							Statement st = con.createStatement(); 
							st.executeUpdate(query);
							JOptionPane.showMessageDialog(null, "Salary changed to "+before);
						}catch(Exception ex) {
							
							JOptionPane.showMessageDialog(null, "Salary must be NUmber"+ex.toString());
						}	
						}
					}
					
				}catch(Exception ex) {
					
				}
				finally {
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
				String name=model.getValueAt(rowIndex, 1).toString();
				String age=model.getValueAt(rowIndex, 2).toString();
				String fonction=model.getValueAt(rowIndex, 5).toString();
				String post=model.getValueAt(rowIndex, 6).toString();
				String type=model.getValueAt(rowIndex, 7).toString();
				int answer=JOptionPane.showConfirmDialog(null, "Are you Sure to Delete employer:\nid: "+id+"\nname: "+name+"\nAge: "+age+"\nPost:"+post+" \nFonction: "+fonction+"\nType:"+type,"Delete employer ",JOptionPane.YES_NO_OPTION);
				if(answer==JOptionPane.YES_OPTION) {
					String query="delete from person where id="+id;
					try {
						Statement st=con.createStatement();
						st.executeUpdate(query);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
					
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
		JPanel employerAdd = new JPanel();
		
		tabbedPane.addTab("ADD Employer", null, employerAdd, null);
		employerAdd.setLayout(null);
		
		JPanel AddView = new JPanel();
		AddView.setBounds(27, 8, 227, 159);
		employerAdd.add(AddView);
		AddView.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Dialog", Font.BOLD, 15));
		AddView.add(lblName);
		
		NameFieeld = new JTextField();
		AddView.add(NameFieeld);
		NameFieeld.setColumns(10);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 15));
		AddView.add(lblAge);
		
		AgeField = new JTextField();
		AddView.add(AgeField);
		AgeField.setColumns(10);
		
		DefaultComboBoxModel<String>FonctionModel=new DefaultComboBoxModel<String>();
		FonctionModel.addElement("Sale");
		FonctionModel.addElement("Kitchen");
		FonctionModel.addElement("Employer");
		
		JLabel lblPhone = new JLabel("Phone  (+961)");
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 15));
		AddView.add(lblPhone);
		
		PhoneField = new JTextField();
		AddView.add(PhoneField);
		PhoneField.setColumns(10);
		
		JLabel lblAddres = new JLabel("Addres");
		lblAddres.setFont(new Font("Tahoma", Font.BOLD, 15));
		AddView.add(lblAddres);
		
		addressField = new JTextField();
		AddView.add(addressField);
		addressField.setColumns(10);
		
		JLabel lblFonction = new JLabel("Fonction");
		lblFonction.setFont(new Font("Tahoma", Font.BOLD, 15));
		AddView.add(lblFonction);
		
		JComboBox<String> FonctionChoice = new JComboBox<String>(FonctionModel);
		AddView.add(FonctionChoice);
		
		JLabel lblPost = new JLabel("Post");
		lblPost.setFont(new Font("Tahoma", Font.BOLD, 15));
		AddView.add(lblPost);
		
		DefaultComboBoxModel<String>PostModel=new DefaultComboBoxModel<String>();
		PostModel.addElement("Maitre");
		PostModel.addElement("Chef");
		PostModel.addElement("Comie");
		
		JComboBox<String> PostChoice = new JComboBox<String>(PostModel);
		AddView.add(PostChoice);
		
		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Tahoma", Font.BOLD, 15));
		AddView.add(lblType);
		DefaultComboBoxModel<String>TypeModel=new DefaultComboBoxModel<String>();
		
		JComboBox<String> TypeChoice = new JComboBox<String>(TypeModel);
		AddView.add(TypeChoice);
		TypeModel.addElement("Fixed");
		TypeModel.addElement("Sesonal");
		TypeModel.addElement("Extra");
		
		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setFont(new Font("Tahoma", Font.BOLD, 15));
		AddView.add(lblSalary);
		
		SalaryField = new JTextField();
		AddView.add(SalaryField);
		SalaryField.setColumns(10);
		
		JButton btnAdd = new JButton("ADD");
		
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAdd.setBounds(47, 188, 99, 23);
		employerAdd.add(btnAdd);
		
		JLabel ErrorName = new JLabel("");
		ErrorName.setForeground(Color.RED);
		ErrorName.setBounds(254, 18, 125, 14);
		employerAdd.add(ErrorName);
		
		JLabel ErrorAge = new JLabel("");
		ErrorAge.setForeground(Color.RED);
		ErrorAge.setBounds(254, 38, 150, 14);
		employerAdd.add(ErrorAge);
		
		JLabel ErrorSalary = new JLabel("");
		ErrorSalary.setForeground(Color.RED);
		ErrorSalary.setBounds(254, 150, 145, 14);
		employerAdd.add(ErrorSalary);
		
		JLabel ErrorPhone = new JLabel("");
		ErrorPhone.setForeground(Color.RED);
		ErrorPhone.setBounds(254, 53, 168, 14);
		employerAdd.add(ErrorPhone);
		
		JLabel ErrorAddress = new JLabel("");
		ErrorAddress.setForeground(Color.RED);
		ErrorAddress.setBounds(254, 74, 63, 14);
		employerAdd.add(ErrorAddress);
		
		JPanel foodAdd = new JPanel();
		tabbedPane.addTab("ADD FOOD", null, foodAdd, null);
		foodAdd.setLayout(null);
		
		JPanel add = new JPanel();
		add.setBounds(5, 5, 248, 98);
		foodAdd.add(add);
		add.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel Menu = new JLabel("Menu");
		Menu.setFont(new Font("Tahoma", Font.BOLD, 17));
		add.add(Menu);
		DefaultComboBoxModel<String> menuModel=new DefaultComboBoxModel<String>();
		JComboBox<String> MenuName = new JComboBox<String>(menuModel);
		Connection con= null;
		try {
			
			String url ="jdbc:sqlserver://localhost\\locahost:1433;databaseName=Restaurant;integratedSecurity=true;";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); con =DriverManager.getConnection(url);
			String query = "select name_menu from menu";
			Statement st = con.createStatement(); 
			ResultSet resultSet= st.executeQuery(query);
			while (resultSet.next()) {
				menuModel.addElement(resultSet.getString(1));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		add.add(MenuName);
		
		JLabel lblNameFood = new JLabel("Name Food");
		lblNameFood.setFont(new Font("Tahoma", Font.BOLD, 17));
		add.add(lblNameFood);
		
		NameFood = new JTextField();
		add.add(NameFood);
		NameFood.setColumns(10);
		
		JLabel lblClassFood = new JLabel("Class Food");
		lblClassFood.setFont(new Font("Tahoma", Font.BOLD, 17));
		add.add(lblClassFood);
		DefaultComboBoxModel<String>ClassModel=new DefaultComboBoxModel<String>();
		JComboBox<String> ClassFood = new JComboBox<String>(ClassModel);
		ClassModel.addElement("Cold Entries");
		ClassModel.addElement("Hot Entries");
		ClassModel.addElement("Burger");
		ClassModel.addElement("Pasta");
		ClassModel.addElement("Grill");
		ClassModel.addElement("Sea Food");
		ClassModel.addElement("Plat");
		ClassModel.addElement("Stake");
		ClassModel.addElement("Cold Drink");
		ClassModel.addElement("Hot Drink");
		ClassModel.addElement("Shake");
		ClassModel.addElement("Juice");
		ClassModel.addElement("Coktail");
		ClassModel.addElement("Desert");
		ClassModel.addElement("Virgin Juice");
		ClassModel.addElement("Shisha");
		add.add(ClassFood);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 17));
		add.add(lblPrice);
		
		priceFood = new JTextField();
		add.add(priceFood);
		priceFood.setColumns(10);
		
		JButton btnAdd_1 = new JButton("ADD");
		JLabel ErrorNameFood = new JLabel("");
		ErrorNameFood.setForeground(Color.RED);
		ErrorNameFood.setBounds(257, 39, 164, 14);
		foodAdd.add(ErrorNameFood);
		
		JLabel ErrorPrice = new JLabel("");
		ErrorPrice.setForeground(Color.RED);
		ErrorPrice.setBounds(257, 88, 164, 14);
		foodAdd.add(ErrorPrice);
		btnAdd_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String menu=MenuName.getSelectedItem().toString();
				String name=NameFood.getText().toString();
				String classFood=ClassFood.getSelectedItem().toString();
				int price=0;
				Boolean check=true;
				if(name.isEmpty()) {
					ErrorNameFood.setText("Name Food is Required");
					check=false;
					}
				if(priceFood.getText().isEmpty()) {
						ErrorPrice.setText("Price is Required");
					check=false;
				}
				else {
				try {
					 price =Integer.parseInt(priceFood.getText());
					 if(price <0) {
						 ErrorPrice.setText("Price Must be Positive");
						 check=false;}
				}catch(Exception ex) {
					check=false;
					ErrorPrice.setText("Price Must be Number");
				}
				}
				if(check) {
					Connection con= null;
					try {
						
						String url ="jdbc:sqlserver://localhost\\locahost:1433;databaseName=Restaurant;integratedSecurity=true;";
						Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); con =DriverManager.getConnection(url);
						String query = "insert into food (name_food,class_food,price_food) values('"+name+"','"+classFood+"',"+price+")";
						String query2="select id_menu from menu where name_menu='"+menu+"'";
						int id_menu=0;
						Statement st = con.createStatement(); 
						st.executeUpdate(query);
						ResultSet rs=st.executeQuery(query2);
						if(rs.next())
						 id_menu=rs.getInt(1);
						rs=st.executeQuery("select max(id_food) from food");
						if(rs.next()) {
						int id_food=rs.getInt(1);
						st.executeUpdate("insert into behove values("+id_food+","+id_menu+")");	
						}	
						
					}catch(Exception ex) {
						ex.printStackTrace();
					}
					finally {
						try {
							con.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}
			}
		});
		btnAdd_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnAdd_1.setBounds(41, 119, 89, 23);
		foodAdd.add(btnAdd_1);
		
		JPanel addMenu = new JPanel();
		tabbedPane.addTab("ADD Menu", null, addMenu, null);
		addMenu.setLayout(null);
		
		JLabel lblNameMenu = new JLabel("Name Menu");
		lblNameMenu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		lblNameMenu.setBounds(28, 46, 131, 24);
		addMenu.add(lblNameMenu);
		
		textField_1 = new JTextField();
		textField_1.setBounds(163, 46, 108, 26);
		addMenu.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnAdd_2 = new JButton("ADD");
		btnAdd_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		btnAdd_2.setBounds(97, 94, 89, 23);
		addMenu.add(btnAdd_2);
		DefaultTableModel modelFood=new DefaultTableModel();

		String[] identifierFood= {"ID","Class","Name","Price"};
		modelFood.setColumnIdentifiers(identifierFood);
		JPanel editFood = new JPanel();
		tabbedPane.addTab("EDIT FOOD", null, editFood, null);
		tableEditFood = new JTable(modelFood);
		JScrollPane scrollPaneeditFood = new JScrollPane(tableEditFood);
		scrollPaneeditFood.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		editFood.add(scrollPaneeditFood);
modelFood.addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent arg0) {
				
				
				Connection con= null;
				try{
					
					String url ="jdbc:sqlserver://localhost\\locahost:1433;databaseName=Restaurant;integratedSecurity=true;";
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); con =DriverManager.getConnection(url);
				 	int IndexRow=tableEditFood.getSelectedRow();
					int IndexColumn=tableEditFood.getSelectedColumn();
					
					String id=modelFood.getValueAt(IndexRow, 0).toString();
					String before=modelFood.getValueAt(IndexRow, IndexColumn).toString();
					
					if(IndexColumn==2) {
						if(before.isEmpty())
							JOptionPane.showMessageDialog(null, "Name is Required");
						
							else if(con!=null) {
								JOptionPane.showMessageDialog(null, "Name is Changed to "+before);
								String query = "update food set name_food='"+before+"' where id_food="+id;
								Statement st = con.createStatement(); 
								st.executeUpdate(query);	
							}
						
							
					}
					if(IndexColumn==3) {
						if(before.isEmpty())
							JOptionPane.showMessageDialog(null, "Price is Required");
						else {
						try {
							int age =Integer.parseInt(before);
							if(age>18) {
							String query = "update food set price_food="+before+" where id_food="+id;
							Statement st = con.createStatement(); 
							st.executeUpdate(query);
							JOptionPane.showMessageDialog(null, "Price changed to "+before);
							}
							else
								JOptionPane.showMessageDialog(null, "Age must be Greatear than 18");
						}catch(Exception ex) {
							JOptionPane.showMessageDialog(null, "Age must be NUmber");
						}	
						}
					}
									}catch(Exception ex) {
										
					
				}
				finally {
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						
					}
				}
						}
			
		});
		scrollPaneeditFood.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				modelFood.setRowCount(0);
				Connection con= null;
				String url ="jdbc:sqlserver://localhost\\locahost:1433;databaseName=Restaurant;integratedSecurity=true;";
				try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); con =DriverManager.getConnection(url);
				if(con!=null)
				{
				
				String query = "select * from food "; 
				Statement st = con.createStatement(); 
				ResultSet rs = st.executeQuery(query);
				while(rs.next()) {
					modelFood.addRow(new Object[] {rs.getInt(1),rs.getString(3),rs.getString(2),rs.getInt(4)});
				}
				con.close();
				}
				}catch (Exception ex) {
					ex.printStackTrace();
					// TODO: handle exception
				}
				finally {
					try {
						con.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						
					}
					}
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				modelFood.setRowCount(0);
				Connection con= null;
				String url ="jdbc:sqlserver://localhost\\locahost:1433;databaseName=Restaurant;integratedSecurity=true;";
				try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); con =DriverManager.getConnection(url);
				if(con!=null)
				{
				
				String query = "select * from food "; 
				Statement st = con.createStatement(); 
				ResultSet rs = st.executeQuery(query);
				while(rs.next()) {
					modelFood.addRow(new Object[] {rs.getInt(1),rs.getString(3),rs.getString(2),rs.getInt(4)});
				}
				con.close();
				}
				}catch (Exception ex) {
					
					// TODO: handle exception
				}
				finally {
					try {
						con.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						
					}
					}
			}
		});
			
			

		tableEditFood.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				JTable jTable=(JTable) e.getSource();
				int IndexColumn=jTable.getSelectedColumn();
				int RowIndex=jTable.getSelectedRow();
				String id=modelFood.getValueAt(RowIndex,0).toString();
				String classFood=(String) jTable.getValueAt(RowIndex, 1);
				String name=(String) jTable.getValueAt(RowIndex, 2);
				if(IndexColumn==0) {
					int answer=JOptionPane.showConfirmDialog(null, "DO YOU WANT DELETE FOOD \n\n\n Class Fodd : "+classFood+"\n\nName Food  : "+name+"\n\n\n\n");
				if(answer==JOptionPane.YES_OPTION) {
					Connection con= null;
					String url ="jdbc:sqlserver://localhost\\locahost:1433;databaseName=Restaurant;integratedSecurity=true;";
					try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); con =DriverManager.getConnection(url);
					if(con!=null)
					{
						String query="delet from food where id_food="+id;
						Statement statement=con.createStatement();
						statement.executeUpdate(query);
					}
					
				}catch (Exception e1) {
					// TODO: handle exception
				}
				}
				}
				if(IndexColumn==1) {
					String[] list = {"Cold Entries","Hot Entries","Burger","Pasta","Sea Food","Plat","Grill","Stake","Cold Drink","Hot Drink","Shake","Juice","Coktail","Desert","Virgin Juice","Shisha"
};
					JComboBox<Object> box = new JComboBox<Object>(list);
					box.setEditable(true);
					JOptionPane.showMessageDialog( null, box, "Select New Class", JOptionPane.QUESTION_MESSAGE);
					String before=box.getSelectedItem().toString();
					JOptionPane.showMessageDialog(null, box.getSelectedItem());
					Connection con= null;
					String url ="jdbc:sqlserver://localhost\\locahost:1433;databaseName=Restaurant;integratedSecurity=true;";
					try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); con =DriverManager.getConnection(url);
					if(con!=null)
					{
						String query="update food set class_food='"+before+"' where id_food="+id;
						Statement statement=con.createStatement();
						statement.executeUpdate(query);
					}
					
				}catch (Exception e1) {
					// TODO: handle exception
					e1.printStackTrace();
				}
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
		
		
		
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ErrorAge.setText("");
				ErrorName.setText("");
				ErrorSalary.setText("");
				ErrorPhone.setText("");
				String name=NameFieeld.getText();
				String address=addressField.getText();
				String fonction=FonctionChoice.getSelectedItem().toString();
				String type=TypeChoice.getSelectedItem().toString();
				String post=PostChoice.getSelectedItem().toString();
				int phone = 0;
				int age=0;
				int salary=0;
				int id=idBranche;
				boolean check=true;
				SimpleDateFormat formatter= new SimpleDateFormat("MM/dd/yyyy" );
				Date date = new Date(System.currentTimeMillis());
				if(AgeField.getText().isEmpty()) {
					ErrorAge.setText("Required");
					check=false;
					}
				else 
					try {
						 age=Integer.parseInt(AgeField.getText());
						 if(age<18)
							 ErrorAge.setText("Age must greater than 18");
					} catch (Exception e) {
						// TODO: handle exception
						ErrorAge.setText("Age must be Number");
						check=false;
					}
				if(SalaryField.getText().isEmpty()) {
					ErrorSalary.setText("Required");
					check=false;
					
				}
				else 
					try {
						 salary=Integer.parseInt(SalaryField.getText());
						 if(salary<0) {
							 ErrorSalary.setText("Salary Must be Positive");
							 check=false;
						 }
						 
					} catch (Exception e) {
						// TODO: handle exception
						check=false;
						ErrorSalary.setText("Salary must be Number");
					}
				if(PhoneField.getText().isEmpty()) {
					ErrorPhone.setText("Required");
					check=false;
				}
				
					
				
				else {
					
					try {
						 phone=Integer.parseInt(PhoneField.getText());
					} catch (Exception e) {
						// TODO: handle exception
						ErrorPhone.setText("Phone must be Number");
						check=false;
					}
				if(PhoneField.getText().length()!=8) {
					check=false;
					ErrorPhone.setText("Phone must be 8 Number");
					}
				}
				if(name.isEmpty()) {
					ErrorName.setText("Required");
					check=false;
				}
				if(addressField.getText().isEmpty()) {
					ErrorAddress.setText("Required");
					check=false;
				}
				if(check) {
					Connection con= null;
					String url ="jdbc:sqlserver://localhost\\locahost:1433;databaseName=Restaurant;integratedSecurity=true;";
					try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); con =DriverManager.getConnection(url);
					if(con!=null)
					{
					
					String query = "insert into Person(id_branche,name_person,age_person,address_person,phone_person,fonction_person,post_person,type_person,Date_Started,salary_person,discount_person) values("+id+",'"+name+"',"+age+",'"+address+"',"+phone+",'"+fonction+"','"+post+"','"+type+"','"+formatter.format(date)+"',"+salary+","+0+")"; 
					Statement st = con.createStatement(); 
					st.executeUpdate(query);
					con.close();
					}
					}catch (Exception e) {
						e.printStackTrace();
						// TODO: handle exception
					}
					finally {
						try {
							con.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				
				
			
			}
		});
		employerAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				ErrorAge.setText("");
				ErrorName.setText("");
				ErrorSalary.setText("");
				ErrorPhone.setText("");
				ErrorAddress.setText("");
			
			}
		});
			}
}
