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


public class SignUp {

    
	Credentials id1;
	public JFrame frame;
	private JTextField txtUsername;
	private JTextField txtUsername_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField txtEmail;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JCheckBox chkbox;
	

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
		String uName = txtUsername_1.getText();
		String pass1 = String.valueOf(passwordField.getPassword());
	
		id1.setFname(fName);
		id1.setUname(uName);
		id1.setpass1(pass1);
	}
	
	
	public boolean checkFields(){
		String sName = txtUsername.getText();
		String uName = txtUsername_1.getText();
		String mail = txtEmail.getText();
		String pass1 = String.valueOf(passwordField.getPassword());
		String pass2 = String.valueOf(passwordField_1.getPassword());
		
	
		if(sName.trim().equals("") || uName.trim().equals("")|| mail.trim().equals("")|| pass1.trim().equals("") || pass2.trim().equals("")){
			 JOptionPane.showMessageDialog(null, "One Or More Fields Are Empty","Empty Fields",2);
	            return false;
		}else if(!pass1.equals(pass2)) {
			JOptionPane.showMessageDialog(null, "Password Doesn't Match","Confirm Password",2); 
			 return false;
		}else if(chkbox.isSelected() == false){
			JOptionPane.showMessageDialog(null, "Agree to the Terms and Conditions","Confirm Service Usage",2); 
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
		btnNewButton.setFocusPainted(false);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBorder(new RoundedBorder(15));
		btnNewButton.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(827, 27, 50, 28);
		frame.getContentPane().add(btnNewButton);
		
		lblNewLabel_2 = new JLabel("Player Name");
		lblNewLabel_2.setFont(new Font("Luckiest Guy", Font.PLAIN, 22));
		lblNewLabel_2.setForeground(new Color(255, 181, 0));
		lblNewLabel_2.setBounds(450, 153, 142, 28);
		lblNewLabel_2.setVisible(false);
		frame.getContentPane().add(lblNewLabel_2);
		
		
		txtUsername = new JTextField();
		txtUsername.setText("Player Name");
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtUsername.getText().trim().equals("") || 
						txtUsername.getText().trim().toLowerCase().equals("player name")) {
				txtUsername.setText("");
				}
				lblNewLabel_2.setVisible(true);

			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtUsername.getText().trim().equals("") || 
						txtUsername.getText().trim().toLowerCase().equals("player name")) {
				txtUsername.setText("Player Name");
				lblNewLabel_2.setVisible(false);
				}
				
			}
		});
		
		
		
		txtUsername.setBorder(null);
		txtUsername.setFont(new Font("Luckiest Guy", Font.PLAIN, 22));
		txtUsername.setBackground(Color.WHITE);
		txtUsername.setBounds(456, 189, 363, 43);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Username");
		lblNewLabel_3.setFont(new Font("Luckiest Guy", Font.PLAIN, 22));
		lblNewLabel_3.setForeground(new Color(255, 181, 0));
		lblNewLabel_3.setVisible(false);
		lblNewLabel_3.setBounds(450, 243, 126, 28);
		frame.getContentPane().add(lblNewLabel_3);
		
		txtUsername_1 = new JTextField();
		txtUsername_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtUsername_1.getText().trim().equals("") || 
						txtUsername_1.getText().trim().toLowerCase().equals("username")) {
				txtUsername_1.setText("");
				
				}
				lblNewLabel_3.setVisible(true);
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtUsername_1.getText().trim().equals("") || 
						txtUsername_1.getText().trim().toLowerCase().equals("username")) {
				txtUsername_1.setText("Username");
				lblNewLabel_3.setVisible(false);
				}
			}
		});
		txtUsername_1.setText("Username");
		txtUsername_1.setBorder(null);
		txtUsername_1.setFont(new Font("Luckiest Guy", Font.PLAIN, 22));
		txtUsername_1.setBackground(Color.WHITE);
		txtUsername_1.setBounds(456, 274, 363, 43);
		frame.getContentPane().add(txtUsername_1);
		txtUsername_1.setColumns(10);
		
		lblNewLabel_6 = new JLabel("Repeat Password");
		lblNewLabel_6.setFont(new Font("Luckiest Guy", Font.PLAIN, 22));
		lblNewLabel_6.setForeground(new Color(255, 181, 0));
		lblNewLabel_6.setVisible(false);
		lblNewLabel_6.setBounds(450, 498, 257, 33);
		frame.getContentPane().add(lblNewLabel_6);
		
		passwordField_1 = new JPasswordField("Repeat Password");
		passwordField_1.setEchoChar((char)0);
		passwordField_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (String.valueOf(passwordField_1.getPassword()).trim().equals("") || 
						String.valueOf(passwordField_1.getPassword()).trim().toLowerCase().equals("repeat password")) {
					passwordField_1.setText("");
					
				}
				lblNewLabel_6.setVisible(true);
				passwordField_1.setEchoChar((char)0);
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (String.valueOf(passwordField_1.getPassword()).trim().equals("") || 
						String.valueOf(passwordField_1.getPassword()).trim().toLowerCase().equals("repeat password")) {
					passwordField_1.setText("Repeat Password");
				lblNewLabel_6.setVisible(false);
				passwordField_1.setEchoChar((char)0); 
				}else if(!String.valueOf(passwordField_1.getPassword()).trim().equals("") || 
						!String.valueOf(passwordField_1.getPassword()).trim().toLowerCase().equals("repeat password")){
					passwordField_1.setEchoChar('*'); 
				}
			}
		});
		passwordField_1.setFont(new Font("Luckiest Guy", Font.PLAIN, 22));
		passwordField_1.setBorder(null);
		passwordField_1.setBackground(Color.WHITE);
		passwordField_1.setBounds(456, 532, 358, 43);
		frame.getContentPane().add(passwordField_1);
		
	    lblNewLabel_4 = new JLabel("Email");
		lblNewLabel_4.setFont(new Font("Luckiest Guy", Font.PLAIN, 22));
		lblNewLabel_4.setForeground(new Color(255, 181, 0));
		lblNewLabel_4.setVisible(false);
		lblNewLabel_4.setBounds(450, 328, 86, 28);
		frame.getContentPane().add(lblNewLabel_4);
		
		txtEmail = new JTextField("");
		txtEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtEmail.getText().trim().equals("") || 
						txtEmail.getText().trim().toLowerCase().equals("email")) {
					txtEmail.setText("");
				}
				lblNewLabel_4.setVisible(true);
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtEmail.getText().trim().equals("") || 
						txtEmail.getText().trim().toLowerCase().equals("email")) {
					txtEmail.setText("Email");
				lblNewLabel_4.setVisible(false);
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
		
		lblNewLabel_5 = new JLabel("Password");
		lblNewLabel_5.setFont(new Font("Luckiest Guy", Font.PLAIN, 22));
		lblNewLabel_5.setForeground(new Color(255, 181, 0));
		lblNewLabel_5.setVisible(false);
		lblNewLabel_5.setBounds(450, 412, 120, 28);
		frame.getContentPane().add(lblNewLabel_5);
		
		passwordField = new JPasswordField("Password");
		passwordField.setEchoChar((char)0);
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (String.valueOf(passwordField.getPassword()).trim().equals("") || 
						String.valueOf(passwordField.getPassword()).trim().toLowerCase().equals("password")) {
				passwordField.setText("");
				}
				lblNewLabel_5.setVisible(true);
				passwordField.setEchoChar((char)0);
				
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				if (String.valueOf(passwordField.getPassword()).trim().equals("") || 
						String.valueOf(passwordField.getPassword()).trim().toLowerCase().equals("password")) {
					passwordField.setText("Password");
				lblNewLabel_5.setVisible(false);
				passwordField.setEchoChar((char)0); 
				}else if(!String.valueOf(passwordField.getPassword()).trim().equals("") || 
						!String.valueOf(passwordField.getPassword()).trim().toLowerCase().equals("password")){
					passwordField.setEchoChar('*'); 
				}
				
			}
		});
		passwordField.setFont(new Font("Luckiest Guy", Font.PLAIN, 22));
		passwordField.setBorder(null);
		passwordField.setBackground(Color.WHITE);
		passwordField.setBounds(456, 444, 363, 43);
		frame.getContentPane().add(passwordField);
		
		chkbox = new JCheckBox("");
		chkbox.setSelected(false);
		chkbox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
			}
		});
		chkbox.setBounds(459, 589, 21, 23);
		frame.getContentPane().add(chkbox);
		
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
		
		JLabel lblNewLabel_7 = new JLabel("");
		Image img5 = new ImageIcon(this.getClass().getResource("/TicTac160p.gif")).getImage();
		lblNewLabel_7.setIcon(new ImageIcon(img5));
		lblNewLabel_7.setBounds(222, 40, 160, 160);
		frame.getContentPane().add(lblNewLabel_7);
		
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
		lblNewLabel.setFont(new Font("Luckiest Guy", Font.PLAIN, 23));
		Image img = new ImageIcon(this.getClass().getResource("/SignUp.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(0, 0, 900, 824);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
	
		
	
		
		
		
		
		
		
	
		
		
		
		
		
		
	}
}
