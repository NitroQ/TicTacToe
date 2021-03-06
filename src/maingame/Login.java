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
import java.awt.Cursor;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


public class Login {
	Credentials id1;
	
	public JFrame frame;
	private JTextField txtUsername;
	private JPasswordField passwordField;
	// Launch the application

	
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
		id1 = id;
		initialize();
	}
	
	private boolean checkFields(){
	
		String uName = txtUsername.getText();
		String pass1 = String.valueOf(passwordField.getPassword());
		String usName = id1.getUname();
		String opass = id1.getpass1();
		
		if (uName.trim().equals("")|| pass1.trim().equals("")){
			 JOptionPane.showMessageDialog(null, "One Or More Fields Are Empty","Empty Fields",2);
	            return false;
		}else if(!pass1.equals(opass) || !uName.equals(usName)) {
			JOptionPane.showMessageDialog(null, "Username/Password Doesn't Match","Check Username/Password",2); 
			 return false;
		}else {
			return true;
		}
		
	}
	private void eraseMem(){
		 id1.setUname(null);
		 id1.setpass1(null);
		
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = new Dimension (800, 484);
		
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.getContentPane().setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
		frame.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
		frame.setBounds (ss.width / 2 - frameSize.width / 2, ss.height/2 - frameSize.height/2,frameSize.width, frameSize.height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("");
		Image img5 = new ImageIcon(this.getClass().getResource("/TicTac150p.gif")).getImage();
		lblNewLabel_6.setIcon(new ImageIcon(img5));
		lblNewLabel_6.setBounds(193, 33, 150, 150);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_1 = new JLabel("SignUp");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SignUp in = new SignUp(id1);
				in.frame.setVisible(true);
				frame.dispose();
			}
		});
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Luckiest Guy", Font.BOLD, 27));
		lblNewLabel_1.setBounds(529, 56, 170, 57);
		frame.getContentPane().add(lblNewLabel_1);
		
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
		btnNewButton.setBounds(731, 22, 50, 28);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Username");
		lblNewLabel_3.setFont(new Font("Luckiest Guy", Font.PLAIN, 19));
		lblNewLabel_3.setVisible(false);
		lblNewLabel_3.setForeground(new Color(255, 181, 0));
		lblNewLabel_3.setBounds(396, 137, 114, 28);
		frame.getContentPane().add(lblNewLabel_3);
		
		
		txtUsername = new JTextField();
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtUsername.getText().trim().equals("") || 
						txtUsername.getText().trim().toLowerCase().equals("username")) {
				txtUsername.setText("");
				
				}
				lblNewLabel_3.setVisible(true);
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtUsername.getText().trim().equals("") || 
						txtUsername.getText().trim().toLowerCase().equals("username")) {
				txtUsername.setText("Username");
				lblNewLabel_3.setVisible(false);
				}
			}
		});
		txtUsername.setText("Username");
		txtUsername.setBorder(null);
		txtUsername.setFont(new Font("Luckiest Guy", Font.PLAIN, 22));
		txtUsername.setBackground(Color.WHITE);
		txtUsername.setBounds(405, 171, 322, 48);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Login");
		lblNewLabel_5.setFont(new Font("Luckiest Guy", Font.BOLD, 19));
		lblNewLabel_5.setForeground(new Color(255, 181, 0));
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Image img4 = new ImageIcon(this.getClass().getResource("/Ellipse 1.png")).getImage();
				lblNewLabel_5.setIcon(new ImageIcon(img4));
				if(checkFields()) {
					eraseMem();
					Game tictac = new Game();
					tictac.frame_1.setVisible(true);
					frame.dispose();
				}
			}
		});
		lblNewLabel_5.setBounds(665, 377, 105, 48);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_4 = new JLabel("X");
		lblNewLabel_4.setFont(new Font("Luckiest Guy", Font.BOLD, 69));
		lblNewLabel_4.setForeground(new Color(255, 181, 0));
		lblNewLabel_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(checkFields()) {
					eraseMem();
					Game tictac = new Game();
					tictac.frame_1.setVisible(true);
					frame.dispose();
				}
			}
		});
		
		lblNewLabel_4.setBounds(669, 329, 131, 78);
		frame.getContentPane().add(lblNewLabel_4); 
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Luckiest Guy", Font.PLAIN, 19));
		lblNewLabel_2.setForeground(new Color(255, 181, 0));
		lblNewLabel_2.setVisible(false);
		lblNewLabel_2.setBounds(394, 219, 140, 45);
		frame.getContentPane().add(lblNewLabel_2);
		
		passwordField = new JPasswordField("Password");
		passwordField.setEchoChar((char)0);
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (String.valueOf(passwordField.getPassword()).trim().equals("") || 
						String.valueOf(passwordField.getPassword()).trim().toLowerCase().equals("password")) {
					passwordField.setText("");
				}
				lblNewLabel_2.setVisible(true);
				passwordField.setEchoChar((char)0);
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (String.valueOf(passwordField.getPassword()).trim().equals("") || 
						String.valueOf(passwordField.getPassword()).trim().toLowerCase().equals("password")) {
					passwordField.setText("Password");
				lblNewLabel_2.setVisible(false);
				passwordField.setEchoChar((char)0); 
				}else if(!String.valueOf(passwordField.getPassword()).trim().equals("") || 
						!String.valueOf(passwordField.getPassword()).trim().toLowerCase().equals("password")){
					passwordField.setEchoChar('*'); 
				}
			}
		});
		passwordField.setBorder(null);
		passwordField.setFont(new Font("Luckiest Guy", Font.PLAIN, 22));
		passwordField.setBounds(405, 260, 322, 45);
		frame.getContentPane().add(passwordField);
		
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/LoginSmall.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(0, 0, 800, 484);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		
		
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}

