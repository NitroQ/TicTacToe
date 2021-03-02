package maingame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.awt.Cursor;

public class SignUp {
	
	Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    Statement st = null;
    
	Credentials id1;
	public JFrame frame;
	private JTextField txtUsername;
	private JTextField textField_3;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_4;
	private JLabel lblNewLabel_1;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp window = new SignUp(null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SignUp(Credentials id) {
		id1 =id;
		initialize();
	}
	

	public void callLogin() {
		Login lg = new Login(id1);
		lg.frame.setVisible(true);
		frame.dispose();
		
	}
	
	public void setStuff() {
		
		String fName = txtUsername.getText();
		String uName = textField_3.getText();
		String pass1 = String.valueOf(passwordField.getPassword());
		try{
			
            String query = "INSERT INTO `credentials`(`name`, `username`, `password`) VALUES (?,?,?)";
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginnu","root","");
             ps = con.prepareStatement(query);
             ps.setString(1, fName);
             ps.setString(2, uName);
             ps.setString(3, pass1);
             
		}catch(HeadlessException | SQLException ex){
			JOptionPane.showMessageDialog(null, ex);
		}
		id1.setFname(fName);
		id1.setUname(uName);
		id1.setpass1(pass1);
	}
	
	
	public boolean checkFields(){
		String sName = txtUsername.getText();
		String uName = textField_3.getText();
		String mail = textField_4.getText();
		String pass1 = String.valueOf(passwordField.getPassword());
		String pass2 = String.valueOf(passwordField_1.getPassword());
	
		
		
		if(sName.trim().equals("") || uName.trim().equals("")|| mail.trim().equals("")|| pass1.trim().equals("") || pass2.trim().equals("")){
			 JOptionPane.showMessageDialog(null, "One Or More Fields Are Empty","Empty Fields",2);
	            return false;
		}else if(!pass1.equals(pass2)) {
			JOptionPane.showMessageDialog(null, "Password Doesn't Match","Confirm Password",2); 
			 return false;
		}else {
			return true;
		}
		
	}
	
	private void initialize() {
		Dimension ss = Toolkit.getDefaultToolkit ().getScreenSize ();
		Dimension frameSize = new Dimension (900, 824);
		
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.getContentPane().setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
		frame.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
		frame.setBounds (ss.width / 2 - frameSize.width / 2, ss.height/2 - frameSize.height/2,frameSize.width, frameSize.height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("X");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 System.exit(0);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBorder(new RoundedBorder(15));
		btnNewButton.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(827, 27, 50, 28);
		frame.getContentPane().add(btnNewButton);
		
		txtUsername = new JTextField();
		txtUsername.setBorder(null);
		txtUsername.setFont(new Font("Product Sans", Font.PLAIN, 19));
		txtUsername.setBackground(Color.WHITE);
		txtUsername.setBounds(456, 196, 363, 48);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBorder(null);
		textField_3.setFont(new Font("Product Sans", Font.PLAIN, 19));
		textField_3.setBackground(Color.WHITE);
		textField_3.setBounds(456, 295, 363, 48);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBorder(null);
		passwordField_1.setBackground(Color.WHITE);
		passwordField_1.setBounds(461, 581, 358, 54);
		frame.getContentPane().add(passwordField_1);
		
		textField_4 = new JTextField();
		textField_4.setBorder(null);
		textField_4.setFont(new Font("Product Sans", Font.PLAIN, 19));
		textField_4.setBackground(Color.WHITE);
		textField_4.setBounds(456, 388, 363, 48);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(null);
		passwordField.setBackground(Color.WHITE);
		passwordField.setBounds(456, 487, 363, 48);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_11 = new JLabel("Sign Up");
		lblNewLabel_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(checkFields()) {
					setStuff();
					JOptionPane.showMessageDialog(null, "Account Registered!");
					callLogin();
				}

			}
		});
		lblNewLabel_11.setForeground(new Color(255, 181, 0));
		lblNewLabel_11.setFont(new Font("Luckiest Guy", Font.BOLD, 22));
		lblNewLabel_11.setBounds(744, 732, 86, 28);
		frame.getContentPane().add(lblNewLabel_11);
		
		lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				callLogin();
			}
		});
		lblNewLabel_1.setBounds(732, 76, 114, 43);
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Luckiest Guy", Font.BOLD, 33));
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
					if(checkFields()) {
						setStuff();
						JOptionPane.showMessageDialog(null, "Account Registered!");
						callLogin();
					}
				
			}
		});
		Image img2 = new ImageIcon(this.getClass().getResource("/Ellipse 1.png")).getImage();
		lblNewLabel_10.setIcon(new ImageIcon(img2));
		lblNewLabel_10.setBounds(744, 650, 165, 82);
		frame.getContentPane().add(lblNewLabel_10);
		
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/GroupsSignup.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(0, 0, 900, 824);
		frame.getContentPane().add(lblNewLabel);
		
		
		
	
		
	
		
		
		
		
		
		
	
		
		
		
		
		
		
	}
}
