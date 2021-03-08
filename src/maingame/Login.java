package maingame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
import java.util.Properties;
import java.awt.Cursor;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Random;

public class Login {
	
	// Set Global Variables ------------------------------------------
	Credentials id1;
	private ArrayList<String> user, pass, name, email;
	public JFrame frame;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JButton privacy;
	private JButton terms;
	private JButton aboutus;
	private JLabel uservalidation;
	private JLabel passvalidation;
	
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
		//initializing arraylist with existing database -------------------------------------------
		user = new ArrayList<String>();
		pass = new ArrayList<String>();
		name = new ArrayList<String>();
		email = new ArrayList<String>();
		//adding existing users --------------------------------------------------------
		user.add("Frank"); pass.add("frank"); name.add("Frank Vincent"); email.add("frankgesmundo10@gmail.com");
		user.add("Gabby"); pass.add("gab123"); name.add("Gabrille"); email.add("gabbydavid408@gmail.com");
		if(!id1.equals(null)) {
		user.add(id1.getUname()); pass.add(id1.getpass1()); name.add(id1.getFname()); email.add(id1.getemail());
		}
	}
	//Finds the username Index (used for login) -----------------------------------
	private int UserFind(String name) {
		int b = 0;
		for (int i = 0; i < 2; i++) {
		    if(user.get(i).contains(name)) 
		    	b += i;
		    
		    }
		return b;
	}
	//finds the email if it exist in the database --------------------------------
	private boolean FindEmail(String eemail) {
		boolean a = false;
		String c = "";
		if(!id1.equals(null)) {
			c += id1.getemail();
		}
	
		for (int i = 0; i < 2; i++) {
		    if(email.get(i).contains(eemail) || c.equals(eemail)) {
		    	a = true;
		    
		    }
		}
		return a;
	}
	//gets the index of the email in the database ---------------------------------
	private int FindUserEmail(String usermail) {
		String credmail = "";
		if(!id1.equals(null)) {
			credmail += id1.getemail();
		}
		
		int mailIndex = 0;
		if(credmail.equals(usermail) && !credmail.equals("")) {
			mailIndex += 2;
		}else{
			for (int i = 0; i < 2; i++) {
		    if(email.get(i).contains(usermail)) 
		    	mailIndex += i;
	  
		    }
		}
		return mailIndex;
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
		}
		if (uName.trim().toLowerCase().equals("username")) {
			uservalidation.setVisible(true);
		}
		if (pass1.trim().toLowerCase().equals("password")) {
			passvalidation.setVisible(true);
		}
		else if (uName.trim().equals("")) {
			 JOptionPane.showMessageDialog(null, "Username is Required","Input Username",2);
	            return false;
		}
		else if (pass1.trim().equals("")) {
			 JOptionPane.showMessageDialog(null, "Password is Required","Input Password",2);
	            return false;
		}
		else {
			return true;
		}
		return false;		
	}
	
	private boolean checkLogin() {
		//Checks textfields for data ---------------------------------
		String uName = txtUsername.getText();
		String pass1 = String.valueOf(txtPassword.getPassword());
		//getting the data -------------------------------------------
			int userD = UserFind(uName);
			String usName = user.get(userD);
			String opass = pass.get(userD);
		
		//comparing data to existing database -----------------------
		if(!pass1.equals(opass) || !uName.equals(usName)) {
			JOptionPane.showMessageDialog(null, "Username/Password Doesn't Match","Check Username/Password",2); 
			//return value
			 return false;
		}else {
			id1.setFname(name.get(userD));
			//return value
			return true;
		}
	
	}
	private String forgotPass(String email) {
		 //this method emails the user for his verification code -----------------------------------------
		
		//Login email API ---------------------------------------------------
		  final String user="tictactoeprojectjava@gmail.com";
		  final String password="penge4nagrade";
		  
		//Sends to: ---------------------------------------------------
		  String to= email;
		  
		//Generates a code -------------------------------------------
		  Random r = new Random();
	      String rand = String.valueOf(r.nextInt((90000 - 10000) + 1) + 0);
	      
		   //Get the session variables  -------------------------------
		   Properties props = new Properties();  
		   props.put("mail.smtp.host", "smtp.gmail.com");
	        props.put("mail.smtp.port", "465");
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.socketFactory.port", "465");
	        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		     
		   Session session = Session.getDefaultInstance(props,  
		    new javax.mail.Authenticator() {  
		      protected PasswordAuthentication getPasswordAuthentication() {  
		    return new PasswordAuthentication(user,password);  
		      }  
		    });  
		  
		   //Composing the message --------------------------------------  
		    try {  
		     MimeMessage message = new MimeMessage(session);  
		     message.setFrom(new InternetAddress(user));  
		     message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
		     message.setSubject("Forgot Password");  
		     message.setText("Your Recovery Code is: " + rand);  
		       
		    //Send the code -------------------------------------------- 
		     Transport.send(message);  
		   
		     } catch (MessagingException e) {
		    	 e.printStackTrace();
		    	 }  
		    //returns verification code to the method for verification ----------------------------
		    return rand;
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
				int exitconfirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "", JOptionPane.YES_NO_OPTION);
				if (exitconfirmation == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
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
				txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 22));
				txtUsername.setText("");
				
				}
				uNamelbl.setVisible(true);
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtUsername.getText().trim().equals("") || 
						txtUsername.getText().trim().toLowerCase().equals("username")) {
				txtUsername.setFont(new Font("Luckiest Guy", Font.PLAIN, 22));
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
				// checks if text fields are populated -----------------------
				if(checkFields()) {
					//checks if the user is in the database ------------------
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
				// checks if text fields are populated -----------------------
				if(checkFields()) {
					//checks if the user is in the database ------------------
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
					txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 22));
					txtPassword.setText("");
				}
				passwordlbl.setVisible(true);
				txtPassword.setEchoChar((char)0);
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (String.valueOf(txtPassword.getPassword()).trim().equals("") || 
						String.valueOf(txtPassword.getPassword()).trim().toLowerCase().equals("password")) {
					txtPassword.setFont(new Font("Luckiest Guy", Font.PLAIN, 22));
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
		
		//Forgot Password-----------------------------------------------------
		JLabel lblNewLabel = new JLabel("Forgot Password?");
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel.setForeground(new Color(208, 49, 45));
				
				  // Email Verification 
		        String mail = JOptionPane.showInputDialog("Input Account Email: ");
		        if (FindEmail(mail)) {
		        //Sends code via user's email ---------------------------------
		        String verification = forgotPass(mail);
		        String code = JOptionPane.showInputDialog("Input Code: ");
		        	//checks if code matches with user input ------------------
		        	if(verification.equals(code)) {
		        		//finds the index of the email and change its password
		        		int mailInt = FindUserEmail(mail);
		        		String newpass = JOptionPane.showInputDialog("New Password: ");
		        		String repnewpass = JOptionPane.showInputDialog("Repeat Password: ");
		        			if(newpass.equals(repnewpass)) {
		        				pass.set(mailInt, newpass);
		        			}else {
		        				JOptionPane.showMessageDialog(null, "Password Did Not Match, Try Again", "Failed", 2);
		        			}
		        	}
		        }else {
		        	//print if the email does not exist in the database ------------------------------------
		        	 JOptionPane.showMessageDialog(null, "You are not yet signed up in this email.","User not Found",2);
		        }
			}
			public void mouseEntered(MouseEvent e) {
				lblNewLabel.setText("<HTML><U>Forgot Password?</U></HTML>");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel.setText("Forgot Password?");
			}
		});
		lblNewLabel.setBounds(404, 321, 161, 28);
		lblNewLabel.setForeground(new Color(255, 181, 0));
		lblNewLabel.setFont(new Font("Luckiest Guy", Font.PLAIN, 15));
		frame.getContentPane().add(lblNewLabel);
		
		// privacy button -----------------------------------------------------------------------------------------------------------------------
		privacy = new JButton("Privacy");
		privacy.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				privacy.setText("<HTML><U>Privacy</U></HTML>");
			}
			public void mouseExited(MouseEvent e) {
				privacy.setText("Privacy");
			}
		});
		privacy.setFocusPainted(false);
		privacy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openWebPage("https://sites.google.com/view/tictactoeproject/privacy-policy?authuser=0");
			}
		});
		privacy.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		privacy.setContentAreaFilled(false);
		privacy.setBorderPainted(false);
		privacy.setBounds(567, 450, 83, 23);
		frame.getContentPane().add(privacy);
		
		// terms of service button -----------------------------------------------------------------------------------------------------------------
		terms = new JButton("Terms");
		terms.setHorizontalAlignment(SwingConstants.LEADING);
		terms.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				terms.setText("<HTML><U>Terms</U></HTML>");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				terms.setText("Terms");
			}
		});
		terms.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		terms.setFocusPainted(false);
		terms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openWebPage("https://sites.google.com/view/tictactoeproject/terms?authuser=0");
			}
		});
		terms.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		terms.setContentAreaFilled(false);
		terms.setBorderPainted(false);
		terms.setBounds(635, 450, 77, 23);
		frame.getContentPane().add(terms);
		
		// about us button ---------------------------------------------------------------------------------------------------------------------------------
		aboutus = new JButton("About Us");
		aboutus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openWebPage("https://sites.google.com/view/tictactoeproject/home");
			}
		});
		aboutus.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				aboutus.setText("<HTML><U>About Us</U></HTML>");
			}
			public void mouseExited(MouseEvent e) {
				aboutus.setText("About Us");
			}
		});
		aboutus.setHorizontalAlignment(SwingConstants.LEADING);
		aboutus.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		aboutus.setFocusPainted(false);
		aboutus.setContentAreaFilled(false);
		aboutus.setBorderPainted(false);
		aboutus.setBounds(700, 450, 90, 23);
		frame.getContentPane().add(aboutus);
		
		uservalidation = new JLabel("is required. *");
		uservalidation.setForeground(Color.ORANGE);
		uservalidation.setHorizontalAlignment(SwingConstants.RIGHT);
		uservalidation.setBounds(622, 144, 105, 14);
		uservalidation.setVisible(false);
		frame.getContentPane().add(uservalidation);
		
		passvalidation = new JLabel("is required. *");
		passvalidation.setHorizontalAlignment(SwingConstants.RIGHT);
		passvalidation.setForeground(Color.ORANGE);
		passvalidation.setBounds(622, 234, 105, 14);
		passvalidation.setVisible(false);
		frame.getContentPane().add(passvalidation);
		
		// Background Image --------------------------------------------------
		JLabel background = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/LoginSmall.png")).getImage();
		background.setIcon(new ImageIcon(img));
		background.setBounds(0, 0, 800, 484);
		frame.getContentPane().add(background);
		
	}

	public void openWebPage(String url){
	   try {         
	     java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
	   }
	   catch (java.io.IOException e) {
	       System.out.println(e.getMessage());
	   }
	}

	public void setVisible(boolean b) {
		
	}
}

