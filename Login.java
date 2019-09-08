package Default;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	private JPanel contentPane;
	private JTextField user;
	private JPasswordField password;
	static Login frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Login();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogIn = new JLabel("LOG IN");
		lblLogIn.setForeground(Color.CYAN);
		lblLogIn.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLogIn.setBounds(177, 51, 75, 14);
		contentPane.add(lblLogIn);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsername.setBounds(90, 100, 75, 20);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(90, 140, 75, 14);
		contentPane.add(lblPassword);
		
		user = new JTextField();
		user.setBounds(190, 102, 86, 20);
		contentPane.add(user);
		user.setColumns(10);
		
		JButton btnLogIn = new JButton("LOG IN");
		
		btnLogIn.setBounds(131, 184, 92, 36);
		contentPane.add(btnLogIn);
		
		password = new JPasswordField();
		password.setBounds(190, 139, 86, 20);
		contentPane.add(password);
		
		JLabel userror = new JLabel("");
		userror.setForeground(Color.RED);
		userror.setBounds(286, 105, 56, 14);
		contentPane.add(userror);
		
		JLabel passerror = new JLabel("");
		passerror.setForeground(Color.RED);
		passerror.setBounds(286, 142, 56, 14);
		contentPane.add(passerror);
		btnLogIn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				userror.setText("");
				passerror.setText("");
				boolean check=true;
				if(user.getText().isEmpty()) {
					userror.setText("Required");
					check=false;}
				if(password.getText().isEmpty()) {
					passerror.setText("Required");
					check=false;}
				if(check) {
					
					Connection con= null;
					String url ="jdbc:sqlserver://localhost\\locahost:1433;databaseName=Restaurant;integratedSecurity=true;";
					try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); con =DriverManager.getConnection(url);
					if(con!=null)
					{
					
					String query = "select * from identify where username='"+user.getText()+"' and password='"+password.getText()+"' "; 
					Statement st = con.createStatement(); 
					ResultSet rs = st.executeQuery(query);
					
					if(rs.next()) {
						if(rs.getRow()==1) {
					//	JOptionPane.showMessageDialog(null, "");
							String fonction = rs.getString(3);
							if(fonction.equals("admin")) {
								Admin admin=new Admin(rs.getInt(4));
								admin.setVisible(true);
								admin.setExtendedState(JFrame.MAXIMIZED_BOTH);
								admin.setResizable(false);
								admin.setVisible(true);
								frame.dispose();
							}
							if(fonction.equals("employer")) {
								Table table=new Table();
								table.setVisible(true);
								table.setExtendedState(JFrame.MAXIMIZED_BOTH);
								table.setResizable(false);
								frame.dispose();
							}
								
						}
						
					}
					else
						JOptionPane.showMessageDialog(null, "Username Or Password Invalid");
					}
					
					
					
					
					} catch (SQLException | ClassNotFoundException ex) {
						JOptionPane.showMessageDialog(null,"Impossible to connect " + ex.toString());
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
	}
}
