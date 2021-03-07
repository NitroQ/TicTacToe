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
import java.awt.Cursor;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Insets;


public class SignUp {

    // Global Variable declaration ----------------------------------------------
	Credentials id1;
	public JFrame frame;
	private JTextField txtname;
	private JTextField txtUsername;
	private JPasswordField textPass;
	private JPasswordField textreppass;
	private JTextField txtEmail;
	private JLabel Loginbtn;
	private JLabel pName;
	private JLabel uName;
	private JLabel mailE;
	private JLabel PasswordLbl;
	private JLabel RepPasswordlbl;
	private JCheckBox Agreechkbox;
	

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
		
		// initializes Credentials.java and/or receive its data ----------------------------------
		id1 =id;
		initialize();
	}
	

	public void callLogin() {
		
		// Calls Login Jframe Method ---------------------------------------------------------
		Login lg = new Login(id1);
		lg.frame.setVisible(true);
		frame.dispose();
		
	}
	
	public void setStuff() {
		
		// Sends data to Credentials to save user data -------------------------------------------
		String fName = txtname.getText();
		String uName = txtUsername.getText();
		String pass1 = String.valueOf(textPass.getPassword());
	
		id1.setFname(fName);
		id1.setUname(uName);
		id1.setpass1(pass1);
	}
	
	
	public boolean checkFields(){ 
		/* 
		 * Checks all Fields if its empty and matches required format ------------------------------------
		 */
		String sName = txtname.getText();
		String uName = txtUsername.getText();
		String mail = txtEmail.getText();
		String pass1 = String.valueOf(textPass.getPassword());
		String pass2 = String.valueOf(textreppass.getPassword());
		
	
		if(sName.trim().equals("") || uName.trim().equals("")|| mail.trim().equals("")|| pass1.trim().equals("") || pass2.trim().equals("")){
			 JOptionPane.showMessageDialog(null, "One Or More Fields Are Empty","Empty Fields",2);
	            return false;
		}else if(!pass1.equals(pass2)) {
			JOptionPane.showMessageDialog(null, "Password Doesn't Match","Confirm Password",2); 
			 return false;
		}else if(Agreechkbox.isSelected() == false){
			JOptionPane.showMessageDialog(null, "Agree to the Terms and Conditions","Confirm Service Usage",2); 
			return false;
		}else {
			return true;
		}
		
	}
	
	private void initialize() {

		// JFrame location -------------------------------------------------------
		Dimension ss = Toolkit.getDefaultToolkit ().getScreenSize ();
		Dimension frameSize = new Dimension (900, 824);
	
		// JFrame initialization -------------------------------------------------
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.getContentPane().setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
		frame.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
		frame.setBounds (ss.width / 2 - frameSize.width / 2, ss.height/2 - frameSize.height/2,frameSize.width, frameSize.height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Close Button -----------------------------------------------------------
		JButton Close = new JButton("X");
		Close.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 System.exit(0);
			}
		});
		Close.setFocusPainted(false);
		Close.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		Close.setBackground(new Color(62, 62, 62));
		Close.setForeground(new Color(255, 255, 255));
		Close.setBounds(845, 11, 45, 30);
		frame.getContentPane().add(Close);
		
		//Minimize Button --------------------------------------------------------
		JButton Mini = new JButton("_");
		Mini.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Mini.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setState(JFrame.ICONIFIED);
			}
		});
		Mini.setFocusPainted(false);
		Mini.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		Mini.setBackground(new Color(62, 62, 62));
		Mini.setForeground(new Color(255, 255, 255));
		Mini.setBounds(797, 11, 45, 30);
		frame.getContentPane().add(Mini);
		
		
		
		// *Sign up Form* 
		
		// Player Name Label and TextField--------------------------------------
		pName = new JLabel("Player Name");
		pName.setFont(new Font("Luckiest Guy", Font.PLAIN, 22));
		pName.setForeground(new Color(255, 181, 0));
		pName.setBounds(450, 153, 142, 28);
		pName.setVisible(false);
		frame.getContentPane().add(pName);
		
		
		txtname = new JTextField();
		txtname.setText("Player Name");
		txtname.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtname.getText().trim().equals("") || 
						txtname.getText().trim().toLowerCase().equals("player name")) {
				txtname.setText("");
				}
				pName.setVisible(true);

			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtname.getText().trim().equals("") || 
						txtname.getText().trim().toLowerCase().equals("player name")) {
				txtname.setText("Player Name");
				pName.setVisible(false);
				}
				
			}
		});
		txtname.setBorder(null);
		txtname.setFont(new Font("Luckiest Guy", Font.PLAIN, 22));
		txtname.setBackground(Color.WHITE);
		txtname.setBounds(456, 189, 363, 43);
		frame.getContentPane().add(txtname);
		txtname.setColumns(10);
		
		//Username label and Text Field ---------------------------------------
		uName = new JLabel("Username");
		uName.setFont(new Font("Luckiest Guy", Font.PLAIN, 22));
		uName.setForeground(new Color(255, 181, 0));
		uName.setVisible(false);
		uName.setBounds(450, 243, 126, 28);
		frame.getContentPane().add(uName);
		
		txtUsername = new JTextField();
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtUsername.getText().trim().equals("") || 
						txtUsername.getText().trim().toLowerCase().equals("username")) {
				txtUsername.setText("");
				
				}
				uName.setVisible(true);
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtUsername.getText().trim().equals("") || 
						txtUsername.getText().trim().toLowerCase().equals("username")) {
				txtUsername.setText("Username");
				uName.setVisible(false);
				}
			}
		});
		txtUsername.setText("Username");
		txtUsername.setBorder(null);
		txtUsername.setFont(new Font("Luckiest Guy", Font.PLAIN, 22));
		txtUsername.setBackground(Color.WHITE);
		txtUsername.setBounds(456, 274, 363, 43);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		//Email Label and TextField ----------------------------------------------
		   mailE = new JLabel("Email");
			mailE.setFont(new Font("Luckiest Guy", Font.PLAIN, 22));
			mailE.setForeground(new Color(255, 181, 0));
			mailE.setVisible(false);
			mailE.setBounds(450, 328, 86, 28);
			frame.getContentPane().add(mailE);
			
			txtEmail = new JTextField("");
			txtEmail.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					if (txtEmail.getText().trim().equals("") || 
							txtEmail.getText().trim().toLowerCase().equals("email")) {
						txtEmail.setText("");
					}
					mailE.setVisible(true);
				}
				@Override
				public void focusLost(FocusEvent e) {
					if (txtEmail.getText().trim().equals("") || 
							txtEmail.getText().trim().toLowerCase().equals("email")) {
						txtEmail.setText("Email");
					mailE.setVisible(false);
					}
				}
			});
			txtEmail.setText("Email");
			txtEmail.setBorder(null);
			txtEmail.setFont(new Font("Luckiest Guy", Font.PLAIN, 22));
			txtEmail.setBackground(Color.WHITE);
			txtEmail.setBounds(456, 358, 363, 43);
			frame.getContentPane().add(txtEmail);
			txtEmail.setColumns(10);
			
			// Password Label and TextField ---------------------------------------------------
			PasswordLbl = new JLabel("Password");
			PasswordLbl.setFont(new Font("Luckiest Guy", Font.PLAIN, 22));
			PasswordLbl.setForeground(new Color(255, 181, 0));
			PasswordLbl.setVisible(false);
			PasswordLbl.setBounds(450, 412, 120, 28);
			frame.getContentPane().add(PasswordLbl);
			
			textPass = new JPasswordField("Password");
			textPass.setEchoChar((char)0);
			textPass.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					if (String.valueOf(textPass.getPassword()).trim().equals("") || 
							String.valueOf(textPass.getPassword()).trim().toLowerCase().equals("password")) {
					textPass.setText("");
					}
					PasswordLbl.setVisible(true);
					textPass.setEchoChar((char)0);
					
				}
				
				@Override
				public void focusLost(FocusEvent e) {
					if (String.valueOf(textPass.getPassword()).trim().equals("") || 
							String.valueOf(textPass.getPassword()).trim().toLowerCase().equals("password")) {
						textPass.setText("Password");
					PasswordLbl.setVisible(false);
					textPass.setEchoChar((char)0); 
					}else if(!String.valueOf(textPass.getPassword()).trim().equals("") || 
							!String.valueOf(textPass.getPassword()).trim().toLowerCase().equals("password")){
						textPass.setEchoChar('*'); 
					}
					
				}
			});
			textPass.setFont(new Font("Luckiest Guy", Font.PLAIN, 22));
			textPass.setBorder(null);
			textPass.setBackground(Color.WHITE);
			textPass.setBounds(456, 444, 363, 43);
			frame.getContentPane().add(textPass);
		
		// Repeat Password label and Textfield ---------------------------------------------------------
		RepPasswordlbl = new JLabel("Repeat Password");
		RepPasswordlbl.setFont(new Font("Luckiest Guy", Font.PLAIN, 22));
		RepPasswordlbl.setForeground(new Color(255, 181, 0));
		RepPasswordlbl.setVisible(false);
		RepPasswordlbl.setBounds(450, 498, 257, 33);
		frame.getContentPane().add(RepPasswordlbl);
		
		textreppass = new JPasswordField("Repeat Password");
		textreppass.setEchoChar((char)0);
		textreppass.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (String.valueOf(textreppass.getPassword()).trim().equals("") || 
						String.valueOf(textreppass.getPassword()).trim().toLowerCase().equals("repeat password")) {
					textreppass.setText("");
					
				}
				RepPasswordlbl.setVisible(true);
				textreppass.setEchoChar((char)0);
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (String.valueOf(textreppass.getPassword()).trim().equals("") || 
						String.valueOf(textreppass.getPassword()).trim().toLowerCase().equals("repeat password")) {
					textreppass.setText("Repeat Password");
				RepPasswordlbl.setVisible(false);
				textreppass.setEchoChar((char)0); 
				}else if(!String.valueOf(textreppass.getPassword()).trim().equals("") || 
						!String.valueOf(textreppass.getPassword()).trim().toLowerCase().equals("repeat password")){
					textreppass.setEchoChar('*'); 
				}
			}
		});
		textreppass.setFont(new Font("Luckiest Guy", Font.PLAIN, 22));
		textreppass.setBorder(null);
		textreppass.setBackground(Color.WHITE);
		textreppass.setBounds(456, 532, 358, 43);
		frame.getContentPane().add(textreppass);
		
		
		//Signup Label/Button ---------------------------------------------------
		JLabel SignupLbl = new JLabel("Sign Up");
		SignupLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(checkFields()) {
					setStuff();
					JOptionPane.showMessageDialog(null, "Account Registered!");
					callLogin();
				}

			}
		});
		SignupLbl.setForeground(new Color(255, 181, 0));
		SignupLbl.setFont(new Font("Luckiest Guy", Font.PLAIN, 20));
		SignupLbl.setBounds(739, 727, 86, 28);
		frame.getContentPane().add(SignupLbl);
		
		// Signup Shape/ Button -------------------------------------------------
		JLabel SignUpbtn = new JLabel("");
		SignUpbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		SignUpbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
					if(checkFields()) {
						setStuff();
						JOptionPane.showMessageDialog(null, "Account Registered!");
						callLogin();
					}
				
			}
		});
		Image img2 = new ImageIcon(this.getClass().getResource("/Ellipse60p.png")).getImage();
		SignUpbtn.setIcon(new ImageIcon(img2));
		SignUpbtn.setBounds(744, 662, 60, 60);
		frame.getContentPane().add(SignUpbtn);
		
		
		// Login Tab Label ------------------------------------------------------
		Loginbtn = new JLabel("Login");
		Loginbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Loginbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				callLogin();
			}
		});
		Loginbtn.setBounds(732, 77, 114, 43);
		Loginbtn.setForeground(new Color(0, 0, 0));
		Loginbtn.setFont(new Font("Luckiest Guy", Font.PLAIN, 33));
		frame.getContentPane().add(Loginbtn);
		
		// Agree Label -----------------------------------------------------------
		JLabel agree = new JLabel("I Agree to The Terms of Service");
		agree.setForeground(new Color(255, 181, 0));
		agree.setFont(new Font("Luckiest Guy", Font.PLAIN, 19));
		agree.setBounds(496, 596, 329, 30);
		frame.getContentPane().add(agree);
		
		// Tictac Toe gif -------------------------------------------------------
		JLabel gifXO = new JLabel("");
		Image img5 = new ImageIcon(this.getClass().getResource("/TicTac160p.gif")).getImage();
		gifXO.setIcon(new ImageIcon(img5));
		gifXO.setBounds(222, 40, 160, 160);
		frame.getContentPane().add(gifXO);
		
		// Agree Checkbox -------------------------------------------------------
				Agreechkbox = new JCheckBox("");
				Agreechkbox.setMinimumSize(new Dimension(30, 30));
				Agreechkbox.setMaximumSize(new Dimension(30, 30));
				Agreechkbox.setMargin(new Insets(0, 0, 0, 0));
				Agreechkbox.setSize(new Dimension(10, 10));
				Agreechkbox.setPreferredSize(new Dimension(30, 30));
				Agreechkbox.setBackground(new Color(62, 62, 62));
				Agreechkbox.setSelected(false);
				Agreechkbox.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						
					}
				});
				Agreechkbox.setBounds(471, 596, 21, 23);
				frame.getContentPane().add(Agreechkbox);
	
		// Jlabel Background ----------------------------------------------------
		JLabel Background = new JLabel("");
		Background.setHorizontalTextPosition(SwingConstants.RIGHT);
		Background.setFont(new Font("Luckiest Guy", Font.PLAIN, 23));
		Image img = new ImageIcon(this.getClass().getResource("/SignUp2.png")).getImage();
		Background.setIcon(new ImageIcon(img));
		Background.setBounds(0, 0, 900, 824);
		frame.getContentPane().add(Background);		
		
	
		
		
		
	}
}
