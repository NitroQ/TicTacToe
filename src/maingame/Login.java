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


public class Login {
	Credentials id1;
	
	public JFrame frame;
	private JTextField textField;
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
	
		
		String uName = textField.getText();
		String pass1 = String.valueOf(passwordField.getPassword());
		String usName = id1.getUname();
		String opass = id1.getpass1();
		
		if( uName.trim().equals("")|| pass1.trim().equals("")){
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
		Dimension frameSize = new Dimension (1280, 720);
		
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.getContentPane().setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
		frame.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
		frame.setBounds (ss.width / 2 - frameSize.width / 2, ss.height/2 - frameSize.height/2,frameSize.width, frameSize.height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
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
		lblNewLabel_1.setFont(new Font("Luckiest Guy", Font.BOLD, 41));
		lblNewLabel_1.setBounds(785, 99, 170, 57);
		frame.getContentPane().add(lblNewLabel_1);
		
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
		btnNewButton.setBounds(1111, 25, 50, 28);
		frame.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBorder(null);
		textField.setFont(new Font("Product Sans", Font.PLAIN, 19));
		textField.setBackground(Color.WHITE);
		textField.setBounds(609, 269, 471, 45);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("");
		Image img3 = new ImageIcon(this.getClass().getResource("/Login.png")).getImage();
		lblNewLabel_5.setIcon(new ImageIcon(img3));
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
		lblNewLabel_5.setBounds(1012, 557, 105, 48);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_4 = new JLabel("");
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
		Image img2 = new ImageIcon(this.getClass().getResource("/Ellipse 1.png")).getImage();
		lblNewLabel_4.setIcon(new ImageIcon(img2));
		lblNewLabel_4.setBounds(1002, 489, 131, 78);
		frame.getContentPane().add(lblNewLabel_4);
		
		
		
		passwordField = new JPasswordField();
		passwordField.setBorder(null);
		passwordField.setFont(new Font("Product Sans", Font.PLAIN, 19));
		passwordField.setBounds(609, 395, 471, 45);
		frame.getContentPane().add(passwordField);
		
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/GroupLogin.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(0, 0, 1280, 720);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		
		
		
	
		
		
	}
}

