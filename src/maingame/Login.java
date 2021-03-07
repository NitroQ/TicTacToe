package maingame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Cursor;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


public class Login {
	
	// Set Global Variables ------------------------------------------
	Credentials id1;
	private ArrayList<String> user, pass, name,email;
	public JFrame frame;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	
	// Launch the application-----------------------------------------

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login(null);
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
	public Login(Credentials id) {
		
		// initializes Credentials.java and/or receive its data ----------------------------------
		id1 = id;
		setData();
		initialize();
	}
	private void setData() {
		user = new ArrayList<String>();
		pass = new ArrayList<String>();
		name = new ArrayList<String>();
		email = new ArrayList<String>();
		
		user.add("Frank"); pass.add("frank"); name.add("Frank Vincent"); email.add("frankgesmundo10@gmail.com");
		user.add("Gabby"); pass.add("gab123"); name.add("Gabrille"); email.add("frankgesmundo10@gmail.com");
		if(!id1.equals(null)) {
		user.add(id1.getUname()); pass.add(id1.getpass1()); name.add(id1.getFname()); email.add(id1.getemail());
		}
	}
	
	public int UserFind(String name) {
		int b = 0;
		for (int i = 0; i < 2; i++) {
		    if(user.get(i).contains(name)) 
		    	b += i;
		    
		    }
		return b;
	}
	
	private boolean checkFields(){
		/* 
		 * Checks all Fields if its empty and matches required format ------------------------------------
		 */
		String uName = txtUsername.getText();
		String pass1 = String.valueOf(txtPassword.getPassword());
		
		if (uName.trim().toLowerCase().equals("username") && pass1.trim().toLowerCase().equals("password")){
			 JOptionPane.showMessageDialog(null, "One Or More Fields Are Empty","Empty Fields",2);
	            return false;
		}else if (uName.trim().equals("")){
			 JOptionPane.showMessageDialog(null, "Username is Required","Input Username",2);
	            return false;
		}else if (pass1.trim().equals("")){
			 JOptionPane.showMessageDialog(null, "Password is Required","Input Password",2);
	            return false;
		}else{
			return true;
		}
		
	}
	private boolean checkLogin() {
	
		String uName = txtUsername.getText();
		String pass1 = String.valueOf(txtPassword.getPassword());
		
			int userD = UserFind(uName);
			String usName = user.get(userD);
			String opass = pass.get(userD);
		
		
		if(!pass1.equals(opass) || !uName.equals(usName)) {
			JOptionPane.showMessageDialog(null, "Username/Password Doesn't Match","Check Username/Password",2); 
			 return false;
		}else {
			return true;
		}
	
	}
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// JFrame location -------------------------------------------------------
		Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = new Dimension (800, 484);
		
		// JFrame initialization -------------------------------------------------
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.getContentPane().setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
		frame.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
		frame.setBounds (ss.width / 2 - frameSize.width / 2, ss.height/2 - frameSize.height/2,frameSize.width, frameSize.height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// Tic Tac Toe Gif -------------------------------------------------------
		JLabel lblNewLabel_6 = new JLabel("");
		Image img5 = new ImageIcon(this.getClass().getResource("/TicTac150p.gif")).getImage();
		lblNewLabel_6.setIcon(new ImageIcon(img5));
		lblNewLabel_6.setBounds(193, 33, 150, 150);
		frame.getContentPane().add(lblNewLabel_6);
		
		//Exit Button---------------------------------------------------------------
		JButton Close = new JButton("X");
		Close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		Close.setFocusPainted(false);
		Close.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		Close.setBackground(new Color(62, 62, 62));
		Close.setForeground(new Color(255, 255, 255));
		Close.setBounds(745, 11, 45, 30);
		frame.getContentPane().add(Close);
		
		// Minimize Button -----------------------------------------------------------
		JButton minimize = new JButton("_");
		minimize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setState(JFrame.ICONIFIED);
			}
		});
		minimize.setFocusPainted(false);
		minimize.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		minimize.setBackground(new Color(62, 62, 62));
		minimize.setForeground(new Color(255, 255, 255));
		minimize.setBounds(697, 11, 45, 30);
		frame.getContentPane().add(minimize);
		
		// Signup Tab ------------------------------------------------------------------
		JLabel signuplbl = new JLabel("SignUp");
		signuplbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SignUp in = new SignUp(id1);
				in.frame.setVisible(true);
				frame.dispose();
			}
		});
		signuplbl.setForeground(Color.BLACK);
		signuplbl.setFont(new Font("Luckiest Guy", Font.PLAIN, 27));
		signuplbl.setBounds(534, 56, 170, 57);
		frame.getContentPane().add(signuplbl);
		
		// Username Label and TextField ---------------------------------------------
		JLabel uNamelbl = new JLabel("Username");
		uNamelbl.setFont(new Font("Luckiest Guy", Font.PLAIN, 19));
		uNamelbl.setVisible(false);
		uNamelbl.setForeground(new Color(255, 181, 0));
		uNamelbl.setBounds(396, 137, 114, 28);
		frame.getContentPane().add(uNamelbl);
		
		txtUsername = new JTextField("Username");
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtUsername.getText().trim().equals("") || 
						txtUsername.getText().trim().toLowerCase().equals("username")) {
				txtUsername.setText("");
				
				}
				uNamelbl.setVisible(true);
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtUsername.getText().trim().equals("") || 
						txtUsername.getText().trim().toLowerCase().equals("username")) {
				txtUsername.setText("Username");
				uNamelbl.setVisible(false);
				}
			}
		});
		txtUsername.setBorder(null);
		txtUsername.setFont(new Font("Luckiest Guy", Font.PLAIN, 22));
		txtUsername.setBackground(Color.WHITE);
		txtUsername.setBounds(405, 171, 322, 48);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		// Login Label/ Button -----------------------------------------------
		JLabel Loginlbl = new JLabel("Login");
		Loginlbl.setFont(new Font("Luckiest Guy", Font.PLAIN, 19));
		Loginlbl.setForeground(new Color(255, 181, 0));
		Loginlbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(checkFields()) {
					if(checkLogin()) {
					Game tictac = new Game();
					tictac.frame.setVisible(true);
					frame.dispose();
					}
				}
			}
		});
		Loginlbl.setBounds(665, 377, 105, 48);
		frame.getContentPane().add(Loginlbl);
		
		JLabel xbutton = new JLabel("X");
		xbutton.setFont(new Font("Luckiest Guy", Font.BOLD, 69));
		xbutton.setForeground(new Color(255, 181, 0));
		xbutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		xbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(checkFields()) {
					if(checkLogin()) {
					Game tictac = new Game();
					tictac.frame.setVisible(true);
					frame.dispose();
					}
				}
			}
		});
		
		xbutton.setBounds(669, 329, 131, 78);
		frame.getContentPane().add(xbutton); 
		
		
		// Password Label and Text Field ----------------------------------------------
		JLabel passwordlbl = new JLabel("Password");
		passwordlbl.setFont(new Font("Luckiest Guy", Font.PLAIN, 19));
		passwordlbl.setForeground(new Color(255, 181, 0));
		passwordlbl.setVisible(false);
		passwordlbl.setBounds(394, 219, 140, 45);
		frame.getContentPane().add(passwordlbl);
		
		txtPassword = new JPasswordField("Password");
		txtPassword.setEchoChar((char)0);
		txtPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (String.valueOf(txtPassword.getPassword()).trim().equals("") || 
						String.valueOf(txtPassword.getPassword()).trim().toLowerCase().equals("password")) {
					txtPassword.setText("");
				}
				passwordlbl.setVisible(true);
				txtPassword.setEchoChar((char)0);
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (String.valueOf(txtPassword.getPassword()).trim().equals("") || 
						String.valueOf(txtPassword.getPassword()).trim().toLowerCase().equals("password")) {
					txtPassword.setText("Password");
				passwordlbl.setVisible(false);
				txtPassword.setEchoChar((char)0); 
				}else if(!String.valueOf(txtPassword.getPassword()).trim().equals("") || 
						!String.valueOf(txtPassword.getPassword()).trim().toLowerCase().equals("password")){
					txtPassword.setEchoChar('*'); 
				}
			}
		});
		txtPassword.setBorder(null);
		txtPassword.setFont(new Font("Luckiest Guy", Font.PLAIN, 22));
		txtPassword.setBounds(405, 260, 322, 45);
		frame.getContentPane().add(txtPassword);
		
		// Background Image --------------------------------------------------
		JLabel background = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/LoginSmall.png")).getImage();
		background.setIcon(new ImageIcon(img));
		background.setBounds(0, 0, 800, 484);
		frame.getContentPane().add(background);
		
		
		
		
		
		
	}

	public void setVisible(boolean b) {
		
	}
}

