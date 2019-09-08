package Default;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class NewOrder extends JFrame {

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
	JButton b;
	public NewOrder(int number) {
		int num=number;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel ClassFoodView = new JPanel();
		contentPane.add(ClassFoodView);
		ClassFoodView.setLayout(new BorderLayout(0, 0));
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnBack.setVerticalAlignment(SwingConstants.TOP);
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBackground(Color.BLACK);
		ClassFoodView.add(btnBack, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		ClassFoodView.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(4, 4, 0, 0));
		
		JButton btnColdEntiries = new JButton("Cold Entries");
		
		panel.add(btnColdEntiries);
		btnColdEntiries.setBackground(Color.CYAN);
		btnColdEntiries.setFont(new Font("Tahoma", Font.BOLD, 21));
		
		JButton btnHotEntries = new JButton("Hot Entries");
		panel.add(btnHotEntries);
		btnHotEntries.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		btnHotEntries.setBackground(Color.CYAN);
		
		JButton btnburger = new JButton("Burger");
		panel.add(btnburger);
		btnburger.setBackground(Color.CYAN);
		btnburger.setFont(new Font("Tahoma", Font.BOLD, 21));
		
		JButton btnPasta = new JButton("Pasta");
		panel.add(btnPasta);
		btnPasta.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		btnPasta.setBackground(Color.CYAN);
		
		JButton btngrill = new JButton("Grill");
		
		panel.add(btngrill);
		btngrill.setBackground(Color.GREEN);
		btngrill.setForeground(Color.BLACK);
		btngrill.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		
		JButton btnSeaFood = new JButton("Sea Food");
		panel.add(btnSeaFood);
		btnSeaFood.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnSeaFood.setBackground(Color.GREEN);
		
		JButton btnMainPlat = new JButton("Plat");
		panel.add(btnMainPlat);
		btnMainPlat.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		btnMainPlat.setBackground(Color.GREEN);
		
		JButton btnStake = new JButton("Stake");
		panel.add(btnStake);
		btnStake.setBackground(Color.GREEN);
		btnStake.setFont(new Font("Tahoma", Font.BOLD, 21));
		
		JButton btnShake = new JButton("Shake");
		panel.add(btnShake);
		btnShake.setBackground(Color.ORANGE);
		btnShake.setFont(new Font("Tahoma", Font.BOLD, 21));
		
		JButton btnHotDrink = new JButton("Hot Drink");
		panel.add(btnHotDrink);
		btnHotDrink.setBackground(Color.ORANGE);
		btnHotDrink.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		
		JButton btnColdDrink = new JButton("Cold Drink");
		panel.add(btnColdDrink);
		btnColdDrink.setBackground(Color.ORANGE);
		btnColdDrink.setFont(new Font("Tahoma", Font.BOLD, 21));
		
		JButton btnJuice = new JButton("Juice");
		panel.add(btnJuice);
		btnJuice.setBackground(Color.ORANGE);
		btnJuice.setForeground(Color.BLACK);
		btnJuice.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		
		JButton btnVirginJuice = new JButton("Virgin Juice");
		panel.add(btnVirginJuice);
		btnVirginJuice.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		btnVirginJuice.setBackground(Color.PINK);
		
		JButton btnCoktail = new JButton("Cockteil");
		btnCoktail.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnCoktail.setBackground(Color.PINK);
		panel.add(btnCoktail);
		
		JButton btnDesert = new JButton("Desert");
		btnDesert.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		btnDesert.setBackground(Color.PINK);
		panel.add(btnDesert);
		
		JButton btnShisha = new JButton("Shisha");
		panel.add(btnShisha);
		btnShisha.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		btnShisha.setBackground(Color.PINK);
		
		JPanel NameFood = new JPanel();
		contentPane.add(NameFood);
		NameFood.setLayout(new BorderLayout(0, 0));
		
		JPanel Name_food = new JPanel();
		Name_food.setLayout(new FlowLayout(FlowLayout.LEFT));
		NameFood.add(Name_food);
		
		// Cold entries
			btnColdEntiries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Name_food.removeAll();
				Object o=e.getSource();
				 JButton b=null;
				if(o instanceof JButton)
					  b = (JButton)o;
				String type=b.getText();
				
				Connection con= null;
				String url ="jdbc:sqlserver://localhost\\locahost:1433;databaseName=Restaurant;integratedSecurity=true;";
				try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); con =DriverManager.getConnection(url);
				
				if(con!=null)
				{
					String query="select name_food from food where class_food='"+b.getText()+"'";
					Statement st=con.createStatement();
					ResultSet resultSet=st.executeQuery(query);
					
					while(resultSet.next()) {
						
						JButton button=new JButton(""+resultSet.getString(1));
						button.setBackground(Color.CYAN);
						button.setPreferredSize(new Dimension(220,150));
						button.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
						Name_food.add(button);
						button.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								Connection con= null;
								String url ="jdbc:sqlserver://localhost\\locahost:1433;databaseName=Restaurant;integratedSecurity=true;";
								try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); con =DriverManager.getConnection(url);
								if(con!=null) {
									String query="insert into order_table(aliment_order,type_order,quantity_order,table_order)values('"+button.getText()+"','"+type+"',1,"+num+")";
									Statement statement =con.createStatement();
									statement.executeUpdate(query);
									}
								}catch(Exception ex) {
									ex.printStackTrace();
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
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				finally {
					try {
						con.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			NameFood.validate();
            NameFood.repaint();
			}
		});
			//Hot entries
			btnHotEntries.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Name_food.removeAll();
					Object o=e.getSource();
					 b=null;
					if(o instanceof JButton)
						  b = (JButton)o;
					String type=b.getText();
					
					Connection con= null;
					String url ="jdbc:sqlserver://localhost\\locahost:1433;databaseName=Restaurant;integratedSecurity=true;";
					try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); con =DriverManager.getConnection(url);
					
					if(con!=null)
					{
						String query="select name_food from food where class_food='"+b.getText()+"'";
						Statement st=con.createStatement();
						ResultSet resultSet=st.executeQuery(query);
						
						while(resultSet.next()) {
							
							JButton button=new JButton(""+resultSet.getString(1));
							button.setBackground(Color.MAGENTA);
							button.setPreferredSize(new Dimension(220,150));
							button.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
							Name_food.add(button);
							button.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
									// TODO Auto-generated method stub
									Connection con= null;
									String url ="jdbc:sqlserver://localhost\\locahost:1433;databaseName=Restaurant;integratedSecurity=true;";
									try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); con =DriverManager.getConnection(url);
									if(con!=null) {
										String query="insert into order_table(aliment_order,type_order,quantity_order,table_order)values('"+button.getText()+"','"+type+"',1,"+num+")";
										Statement statement =con.createStatement();
										statement.executeUpdate(query);
										}
									}catch(Exception ex) {
										ex.printStackTrace();
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
					}catch(Exception ex) {
						ex.printStackTrace();
					}
					finally {
						try {
							con.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				NameFood.validate();
	            NameFood.repaint();
				}
			});
			// Burger
			btnburger.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Name_food.removeAll();
					Object o=e.getSource();
					JButton b=null;
					if(o instanceof JButton)
						  b = (JButton)o;
					String type=b.getText();
					
					Connection con= null;
					String url ="jdbc:sqlserver://localhost\\locahost:1433;databaseName=Restaurant;integratedSecurity=true;";
					try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); con =DriverManager.getConnection(url);
					
					if(con!=null)
					{
						String query="select name_food from food where class_food='"+b.getText()+"'";
						Statement st=con.createStatement();
						ResultSet resultSet=st.executeQuery(query);
						
						while(resultSet.next()) {
							
							JButton button=new JButton(""+resultSet.getString(1));
							button.setBackground(Color.ORANGE);
							button.setPreferredSize(new Dimension(220,150));
							button.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
							Name_food.add(button);
							button.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
									// TODO Auto-generated method stub
									Connection con= null;
									String url ="jdbc:sqlserver://localhost\\locahost:1433;databaseName=Restaurant;integratedSecurity=true;";
									try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); con =DriverManager.getConnection(url);
									if(con!=null) {
										String query="insert into order_table(aliment_order,type_order,quantity_order,table_order)values('"+button.getText()+"','"+type+"',1,"+num+")";
										Statement statement =con.createStatement();
										statement.executeUpdate(query);
										}
									}catch(Exception ex) {
										ex.printStackTrace();
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
					}catch(Exception ex) {
						ex.printStackTrace();
					}
					finally {
						try {
							con.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				NameFood.validate();
	            NameFood.repaint();
				}
			});
			// Pasta
			btnPasta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Name_food.removeAll();
					Object o=e.getSource();
					JButton b=null;
					if(o instanceof JButton)
						  b = (JButton)o;
					String type=b.getText();
					
					Connection con= null;
					String url ="jdbc:sqlserver://localhost\\locahost:1433;databaseName=Restaurant;integratedSecurity=true;";
					try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); con =DriverManager.getConnection(url);
					
					if(con!=null)
					{
						String query="select name_food from food where class_food='"+b.getText()+"'";
						Statement st=con.createStatement();
						ResultSet resultSet=st.executeQuery(query);
						
						while(resultSet.next()) {
							
							JButton button=new JButton(""+resultSet.getString(1));
							button.setBackground(Color.GREEN);
							button.setPreferredSize(new Dimension(220,150));
							button.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
							Name_food.add(button);
							button.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
									// TODO Auto-generated method stub
									Connection con= null;
									String url ="jdbc:sqlserver://localhost\\locahost:1433;databaseName=Restaurant;integratedSecurity=true;";
									try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); con =DriverManager.getConnection(url);
									if(con!=null) {
										String query="insert into order_table(aliment_order,type_order,quantity_order,table_order)values('"+button.getText()+"','"+type+"',1,"+num+")";
										Statement statement =con.createStatement();
										statement.executeUpdate(query);
										}
									}catch(Exception ex) {
										ex.printStackTrace();
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
					}catch(Exception ex) {
						ex.printStackTrace();
					}
					finally {
						try {
							con.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				NameFood.validate();
	            NameFood.repaint();
				}
			});
			//Grill
			btngrill.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Name_food.removeAll();
					Object o=e.getSource();
					JButton b=null;
					if(o instanceof JButton)
						  b = (JButton)o;
					String type=b.getText();
					
					Connection con= null;
					String url ="jdbc:sqlserver://localhost\\locahost:1433;databaseName=Restaurant;integratedSecurity=true;";
					try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); con =DriverManager.getConnection(url);
					
					if(con!=null)
					{
						String query="select name_food from food where class_food='"+b.getText()+"'";
						Statement st=con.createStatement();
						ResultSet resultSet=st.executeQuery(query);
						
						while(resultSet.next()) {
							
							JButton button=new JButton(""+resultSet.getString(1));
							button.setBackground(Color.MAGENTA);
							button.setPreferredSize(new Dimension(220,150));
							button.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
							Name_food.add(button);
							button.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
									// TODO Auto-generated method stub
									Connection con= null;
									String url ="jdbc:sqlserver://localhost\\locahost:1433;databaseName=Restaurant;integratedSecurity=true;";
									try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); con =DriverManager.getConnection(url);
									if(con!=null) {
										String query="insert into order_table(aliment_order,type_order,quantity_order,table_order)values('"+button.getText()+"','"+type+"',1,"+num+")";
										Statement statement =con.createStatement();
										statement.executeUpdate(query);
										}
									}catch(Exception ex) {
										ex.printStackTrace();
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
					}catch(Exception ex) {
						ex.printStackTrace();
					}
					finally {
						try {
							con.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				NameFood.validate();
	            NameFood.repaint();
				}
			});
			//Seafood
			btnSeaFood.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Name_food.removeAll();
					Object o=e.getSource();
					JButton b=null;
					if(o instanceof JButton)
						  b = (JButton)o;
					String type=b.getText();
					
					Connection con= null;
					String url ="jdbc:sqlserver://localhost\\locahost:1433;databaseName=Restaurant;integratedSecurity=true;";
					try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); con =DriverManager.getConnection(url);
					
					if(con!=null)
					{
						String query="select name_food from food where class_food='"+b.getText()+"'";
						Statement st=con.createStatement();
						ResultSet resultSet=st.executeQuery(query);
						
						while(resultSet.next()) {
							
							JButton button=new JButton(""+resultSet.getString(1));
							button.setBackground(Color.CYAN);
							button.setPreferredSize(new Dimension(220,150));
							button.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
							Name_food.add(button);
							button.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
									// TODO Auto-generated method stub
									Connection con= null;
									String url ="jdbc:sqlserver://localhost\\locahost:1433;databaseName=Restaurant;integratedSecurity=true;";
									try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); con =DriverManager.getConnection(url);
									if(con!=null) {
										String query="insert into order_table(aliment_order,type_order,quantity_order,table_order)values('"+button.getText()+"','"+type+"',1,"+num+")";
										Statement statement =con.createStatement();
										statement.executeUpdate(query);
										}
									}catch(Exception ex) {
										ex.printStackTrace();
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
					}catch(Exception ex) {
						ex.printStackTrace();
					}
					finally {
						try {
							con.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				NameFood.validate();
	            NameFood.repaint();
				}
			});
			//Plat
			btnMainPlat.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Name_food.removeAll();
					Object o=e.getSource();
					JButton b=null;
					if(o instanceof JButton)
						  b = (JButton)o;
					String type=b.getText();
					
					Connection con= null;
					String url ="jdbc:sqlserver://localhost\\locahost:1433;databaseName=Restaurant;integratedSecurity=true;";
					try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); con =DriverManager.getConnection(url);
					
					if(con!=null)
					{
						String query="select name_food from food where class_food='"+b.getText()+"'";
						Statement st=con.createStatement();
						ResultSet resultSet=st.executeQuery(query);
						
						while(resultSet.next()) {
							
							JButton button=new JButton(""+resultSet.getString(1));
							button.setBackground(Color.CYAN);
							button.setPreferredSize(new Dimension(220,150));
							button.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
							Name_food.add(button);
							button.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
									// TODO Auto-generated method stub
									Connection con= null;
									String url ="jdbc:sqlserver://localhost\\locahost:1433;databaseName=Restaurant;integratedSecurity=true;";
									try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); con =DriverManager.getConnection(url);
									if(con!=null) {
										String query="insert into order_table(aliment_order,type_order,quantity_order,,table_order)values('"+button.getText()+"','"+type+"',1,"+num+")";
										Statement statement =con.createStatement();
										statement.executeUpdate(query);
										}
									}catch(Exception ex) {
										ex.printStackTrace();
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
					}catch(Exception ex) {
						ex.printStackTrace();
					}
					finally {
						try {
							con.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				NameFood.validate();
	            NameFood.repaint();
				}
			});
			// Stake
			btnStake.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Name_food.removeAll();
					Object o=e.getSource();
					JButton b=null;
					if(o instanceof JButton)
						  b = (JButton)o;
					String type=b.getText();
					
					Connection con= null;
					String url ="jdbc:sqlserver://localhost\\locahost:1433;databaseName=Restaurant;integratedSecurity=true;";
					try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); con =DriverManager.getConnection(url);
					
					if(con!=null)
					{
						String query="select name_food from food where class_food='"+b.getText()+"'";
						Statement st=con.createStatement();
						ResultSet resultSet=st.executeQuery(query);
						
						while(resultSet.next()) {
							
							JButton button=new JButton(""+resultSet.getString(1));
							button.setBackground(Color.CYAN);
							button.setPreferredSize(new Dimension(220,150));
							button.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
							Name_food.add(button);
							button.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
									// TODO Auto-generated method stub
									Connection con= null;
									String url ="jdbc:sqlserver://localhost\\locahost:1433;databaseName=Restaurant;integratedSecurity=true;";
									try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); con =DriverManager.getConnection(url);
									if(con!=null) {
										String query="insert into order_table(aliment_order,type_order,quantity_order,table_order)values('"+button.getText()+"','"+type+"',1,"+num+")";
										Statement statement =con.createStatement();
										statement.executeUpdate(query);
										}
									}catch(Exception ex) {
										ex.printStackTrace();
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
					}catch(Exception ex) {
						ex.printStackTrace();
					}
					finally {
						try {
							con.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				NameFood.validate();
	            NameFood.repaint();
				}
			});
			// Shake
			btnShake.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Name_food.removeAll();
					Object o=e.getSource();
					JButton b=null;
					if(o instanceof JButton)
						  b = (JButton)o;
					String type=b.getText();
					
					Connection con= null;
					String url ="jdbc:sqlserver://localhost\\locahost:1433;databaseName=Restaurant;integratedSecurity=true;";
					try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); con =DriverManager.getConnection(url);
					
					if(con!=null)
					{
						String query="select name_food from food where class_food='"+b.getText()+"'";
						Statement st=con.createStatement();
						ResultSet resultSet=st.executeQuery(query);
						
						while(resultSet.next()) {
							
							JButton button=new JButton(""+resultSet.getString(1));
							button.setBackground(Color.CYAN);
							button.setPreferredSize(new Dimension(220,150));
							button.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
							Name_food.add(button);
							button.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
									// TODO Auto-generated method stub
									Connection con= null;
									String url ="jdbc:sqlserver://localhost\\locahost:1433;databaseName=Restaurant;integratedSecurity=true;";
									try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); con =DriverManager.getConnection(url);
									if(con!=null) {
										String query="insert into order_table(aliment_order,type_order,quantity_order,table_order)values('"+button.getText()+"','"+type+"',1,"+num+")";
										Statement statement =con.createStatement();
										statement.executeUpdate(query);
										}
									}catch(Exception ex) {
										ex.printStackTrace();
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
					}catch(Exception ex) {
						ex.printStackTrace();
					}
					finally {
						try {
							con.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				NameFood.validate();
	            NameFood.repaint();
				}
			});
			// Hot Drink
			btnHotDrink.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Name_food.removeAll();
					Object o=e.getSource();
					JButton b=null;
					if(o instanceof JButton)
						  b = (JButton)o;
					String type=b.getText();
					
					Connection con= null;
					String url ="jdbc:sqlserver://localhost\\locahost:1433;databaseName=Restaurant;integratedSecurity=true;";
					try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); con =DriverManager.getConnection(url);
					
					if(con!=null)
					{
						String query="select name_food from food where class_food='"+b.getText()+"'";
						Statement st=con.createStatement();
						ResultSet resultSet=st.executeQuery(query);
						
						while(resultSet.next()) {
							
							JButton button=new JButton(""+resultSet.getString(1));
							button.setBackground(Color.CYAN);
							button.setPreferredSize(new Dimension(220,150));
							button.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
							Name_food.add(button);
							button.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
									// TODO Auto-generated method stub
									Connection con= null;
									String url ="jdbc:sqlserver://localhost\\locahost:1433;databaseName=Restaurant;integratedSecurity=true;";
									try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); con =DriverManager.getConnection(url);
									if(con!=null) {
										String query="insert into order_table(aliment_order,type_order,quantity_order,table_order)values('"+button.getText()+"','"+type+"',1,"+num+")";
										Statement statement =con.createStatement();
										statement.executeUpdate(query);
										}
									}catch(Exception ex) {
										ex.printStackTrace();
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
					}catch(Exception ex) {
						ex.printStackTrace();
					}
					finally {
						try {
							con.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				NameFood.validate();
	            NameFood.repaint();
				}
			});
			//Cold Drink
			btnColdDrink.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Name_food.removeAll();
					Object o=e.getSource();
					JButton b=null;
					if(o instanceof JButton)
						  b = (JButton)o;
					String type=b.getText();
					
					Connection con= null;
					String url ="jdbc:sqlserver://localhost\\locahost:1433;databaseName=Restaurant;integratedSecurity=true;";
					try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); con =DriverManager.getConnection(url);
					
					if(con!=null)
					{
						String query="select name_food from food where class_food='"+b.getText()+"'";
						Statement st=con.createStatement();
						ResultSet resultSet=st.executeQuery(query);
						
						while(resultSet.next()) {
							
							JButton button=new JButton(""+resultSet.getString(1));
							button.setBackground(Color.CYAN);
							button.setPreferredSize(new Dimension(220,150));
							button.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
							Name_food.add(button);
							button.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
									// TODO Auto-generated method stub
									Connection con= null;
									String url ="jdbc:sqlserver://localhost\\locahost:1433;databaseName=Restaurant;integratedSecurity=true;";
									try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); con =DriverManager.getConnection(url);
									if(con!=null) {
										String query="insert into order_table(aliment_order,type_order,quantity_order)values('"+button.getText()+"','"+type+"',1,"+num+")";
										Statement statement =con.createStatement();
										statement.executeUpdate(query);
										}
									}catch(Exception ex) {
										ex.printStackTrace();
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
					}catch(Exception ex) {
						ex.printStackTrace();
					}
					finally {
						try {
							con.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				NameFood.validate();
	            NameFood.repaint();
				}
			});
			// Juice
			btnJuice.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Name_food.removeAll();
					Object o=e.getSource();
					JButton b=null;
					if(o instanceof JButton)
						  b = (JButton)o;
					String type=b.getText();
					
					Connection con= null;
					String url ="jdbc:sqlserver://localhost\\locahost:1433;databaseName=Restaurant;integratedSecurity=true;";
					try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); con =DriverManager.getConnection(url);
					
					if(con!=null)
					{
						String query="select name_food from food where class_food='"+b.getText()+"'";
						Statement st=con.createStatement();
						ResultSet resultSet=st.executeQuery(query);
						
						while(resultSet.next()) {
							
							JButton button=new JButton(""+resultSet.getString(1));
							button.setBackground(Color.CYAN);
							button.setPreferredSize(new Dimension(220,150));
							button.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
							Name_food.add(button);
							button.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
									// TODO Auto-generated method stub
									Connection con= null;
									String url ="jdbc:sqlserver://localhost\\locahost:1433;databaseName=Restaurant;integratedSecurity=true;";
									try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); con =DriverManager.getConnection(url);
									if(con!=null) {
										String query="insert into order_table(aliment_order,type_order,quantity_order,table_order)values('"+button.getText()+"','"+type+"',1,"+num+")";
										Statement statement =con.createStatement();
										statement.executeUpdate(query);
										}
									}catch(Exception ex) {
										ex.printStackTrace();
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
					}catch(Exception ex) {
						ex.printStackTrace();
					}
					finally {
						try {
							con.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				NameFood.validate();
	            NameFood.repaint();
				}
			});
			// Virgin Juice
			btnVirginJuice.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Name_food.removeAll();
					Object o=e.getSource();
					JButton b=null;
					if(o instanceof JButton)
						  b = (JButton)o;
					String type=b.getText();
					
					Connection con= null;
					String url ="jdbc:sqlserver://localhost\\locahost:1433;databaseName=Restaurant;integratedSecurity=true;";
					try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); con =DriverManager.getConnection(url);
					
					if(con!=null)
					{
						String query="select name_food from food where class_food='"+b.getText()+"'";
						Statement st=con.createStatement();
						ResultSet resultSet=st.executeQuery(query);
						
						while(resultSet.next()) {
							
							JButton button=new JButton(""+resultSet.getString(1));
							button.setBackground(Color.CYAN);
							button.setPreferredSize(new Dimension(220,150));
							button.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
							Name_food.add(button);
							button.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
									// TODO Auto-generated method stub
									Connection con= null;
									String url ="jdbc:sqlserver://localhost\\locahost:1433;databaseName=Restaurant;integratedSecurity=true;";
									try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); con =DriverManager.getConnection(url);
									if(con!=null) {
										String query="insert into order_table(aliment_order,type_order,quantity_order,table_order)values('"+button.getText()+"','"+type+"',1,"+num+")";
										Statement statement =con.createStatement();
										statement.executeUpdate(query);
										}
									}catch(Exception ex) {
										ex.printStackTrace();
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
					}catch(Exception ex) {
						ex.printStackTrace();
					}
					finally {
						try {
							con.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				NameFood.validate();
	            NameFood.repaint();
				}
			});
			// Cocktail
			btnCoktail.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Name_food.removeAll();
					Object o=e.getSource();
					JButton b=null;
					if(o instanceof JButton)
						  b = (JButton)o;
					String type=b.getText();
					
					Connection con= null;
					String url ="jdbc:sqlserver://localhost\\locahost:1433;databaseName=Restaurant;integratedSecurity=true;";
					try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); con =DriverManager.getConnection(url);
					
					if(con!=null)
					{
						String query="select name_food from food where class_food='"+b.getText()+"'";
						Statement st=con.createStatement();
						ResultSet resultSet=st.executeQuery(query);
						
						while(resultSet.next()) {
							
							JButton button=new JButton(""+resultSet.getString(1));
							button.setBackground(Color.CYAN);
							button.setPreferredSize(new Dimension(220,150));
							button.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
							Name_food.add(button);
							button.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
									// TODO Auto-generated method stub
									Connection con= null;
									String url ="jdbc:sqlserver://localhost\\locahost:1433;databaseName=Restaurant;integratedSecurity=true;";
									try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); con =DriverManager.getConnection(url);
									if(con!=null) {
										String query="insert into order_table(aliment_order,type_order,quantity_order)values('"+button.getText()+"','"+type+"',1,"+num+")";
										Statement statement =con.createStatement();
										statement.executeUpdate(query);
										}
									}catch(Exception ex) {
										ex.printStackTrace();
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
					}catch(Exception ex) {
						ex.printStackTrace();
					}
					finally {
						try {
							con.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				NameFood.validate();
	            NameFood.repaint();
				}
			});
			// Desert
			btnDesert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Name_food.removeAll();
					Object o=e.getSource();
					JButton b=null;
					if(o instanceof JButton)
						  b = (JButton)o;
					String type=b.getText();
					
					Connection con= null;
					String url ="jdbc:sqlserver://localhost\\locahost:1433;databaseName=Restaurant;integratedSecurity=true;";
					try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); con =DriverManager.getConnection(url);
					
					if(con!=null)
					{
						String query="select name_food from food where class_food='"+b.getText()+"'";
						Statement st=con.createStatement();
						ResultSet resultSet=st.executeQuery(query);
						
						while(resultSet.next()) {
							
							JButton button=new JButton(""+resultSet.getString(1));
							button.setBackground(Color.CYAN);
							button.setPreferredSize(new Dimension(220,150));
							button.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
							Name_food.add(button);
							button.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
									// TODO Auto-generated method stub
									Connection con= null;
									String url ="jdbc:sqlserver://localhost\\locahost:1433;databaseName=Restaurant;integratedSecurity=true;";
									try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); con =DriverManager.getConnection(url);
									if(con!=null) {
										String query="insert into order_table(aliment_order,type_order,quantity_order,table_order)values('"+button.getText()+"','"+type+"',1,"+num+")";
										Statement statement =con.createStatement();
										statement.executeUpdate(query);
										}
									}catch(Exception ex) {
										ex.printStackTrace();
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
					}catch(Exception ex) {
						ex.printStackTrace();
					}
					finally {
						try {
							con.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				NameFood.validate();
	            NameFood.repaint();
				}
			});
			// Shisha
			btnShisha.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Name_food.removeAll();
					Object o=e.getSource();
					JButton b=null;
					if(o instanceof JButton)
						  b = (JButton)o;
					String type=b.getText();
					
					Connection con= null;
					String url ="jdbc:sqlserver://localhost\\locahost:1433;databaseName=Restaurant;integratedSecurity=true;";
					try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); con =DriverManager.getConnection(url);
					
					if(con!=null)
					{
						String query="select name_food from food where class_food='"+b.getText()+"'";
						Statement st=con.createStatement();
						ResultSet resultSet=st.executeQuery(query);
						
						while(resultSet.next()) {
							
							JButton button=new JButton(""+resultSet.getString(1));
							button.setBackground(Color.CYAN);
							button.setPreferredSize(new Dimension(220,150));
							button.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
							Name_food.add(button);
							button.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
									// TODO Auto-generated method stub
									Connection con= null;
									String url ="jdbc:sqlserver://localhost\\locahost:1433;databaseName=Restaurant;integratedSecurity=true;";
									try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); con =DriverManager.getConnection(url);
									if(con!=null) {
										String query="insert into order_table(aliment_order,type_order,quantity_order,table_order)values('"+button.getText()+"','"+type+"',1,"+num+")";
										Statement statement =con.createStatement();
										statement.executeUpdate(query);
										}
									}catch(Exception ex) {
										ex.printStackTrace();
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
					}catch(Exception ex) {
						ex.printStackTrace();
					}
					finally {
						try {
							con.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				NameFood.validate();
	            NameFood.repaint();
				}
			});
	}
}
