package maingame;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Welcomepage {

	public JFrame frame;
	private JButton privacy;
	private JButton terms;
	private JButton aboutus;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcomepage window = new Welcomepage();
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
	public Welcomepage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		// JFrame initialization -----------------------------------------------------------------------------------------------------------------
		frame = new JFrame();
		frame.setBounds (100, 100, 1096, 630);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
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
		privacy.setBounds(890, 596, 83, 23);
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
		terms.setBounds(946, 596, 77, 23);
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
		aboutus.setBounds(996, 596, 90, 23);
		frame.getContentPane().add(aboutus);
		
		// play button --------------------------------------------------------------------------------------------------------------------------
		JButton playbtn = new JButton("");
		Image buttonplay = new ImageIcon(this.getClass().getResource("/playborderyellow.png")).getImage();
		playbtn.setIcon(new ImageIcon(buttonplay));
		playbtn.addMouseListener(new MouseAdapter() {
			// change icon when mouse hovers -----------------------------------------------------------------------------------------------------
			public void mouseEntered(MouseEvent e) {
				Image hoverplay = new ImageIcon(this.getClass().getResource("/playhmm.png")).getImage();
				playbtn.setIcon(new ImageIcon(hoverplay));
			}
			public void mouseExited(MouseEvent e) {
				playbtn.setIcon(new ImageIcon(buttonplay));
			}
		});
		// redirects to Login frame when button is clicked ---------------------------------------------------------------------------------------
		playbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Credentials cd = new Credentials();
				Login in = new Login(cd);
				in.frame.setVisible(true);
				frame.dispose();
			}
		});
		playbtn.setBorderPainted(false);
		playbtn.setContentAreaFilled(false);
		playbtn.setBounds(580, 241, 407, 402);
		frame.getContentPane().add(playbtn);
		
		// Code Vision Studios logo -------------------------------------------------------------------------------------------------------------
		JLabel logo = new JLabel("");
		Image LOGO = new ImageIcon(this.getClass().getResource("/logooo.png")).getImage();
		logo.setIcon(new ImageIcon(LOGO));
		logo.setBounds(10, 532, 161, 87);
		frame.getContentPane().add(logo);
		
		JButton Close = new JButton("X");
		Close.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		Close.setBounds(1041, 11, 45, 30);
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
		Mini.setBounds(993, 11, 45, 30);
		frame.getContentPane().add(Mini);
		
		// facebook icon ------------------------------------------------------------------------------------------------------------------------
		JButton fb = new JButton("");
		fb.setBorder(null);
		fb.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				Image facebook2 = new ImageIcon(this.getClass().getResource("/fb2.png")).getImage();
				fb.setIcon(new ImageIcon(facebook2));
			}
			public void mouseExited(MouseEvent e) {
				Image facebook = new ImageIcon(this.getClass().getResource("/fb.png")).getImage();
				fb.setIcon(new ImageIcon(facebook));
			}
		});
		// redirects to link inserted when clicked -----------------------------------------------------------------------------------------------
		fb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openWebPage("https://www.facebook.com/gabbydavid51");
			}
		});
		Image facebook = new ImageIcon(this.getClass().getResource("/fb.png")).getImage();
		fb.setIcon(new ImageIcon(facebook));
		fb.setFocusPainted(false);
		fb.setContentAreaFilled(false);
		fb.setRolloverEnabled(false);
		fb.setBounds(175, 572, 50, 50);
		frame.getContentPane().add(fb);
		
		// twitter icon ---------------------------------------------------------------------------------------------------------------------------
		JButton twt = new JButton();
		twt.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				Image twitter2 = new ImageIcon(this.getClass().getResource("/twt2.png")).getImage();
				twt.setIcon(new ImageIcon(twitter2));
			}
			public void mouseExited(MouseEvent e) {
				Image twitter = new ImageIcon(this.getClass().getResource("/twt.png")).getImage();
				twt.setIcon(new ImageIcon(twitter));
			}
		});
		twt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openWebPage("");
			}
		});
		Image twitter = new ImageIcon(this.getClass().getResource("/twt.png")).getImage();
		twt.setIcon(new ImageIcon(twitter));
		twt.setFocusPainted(false);
		twt.setBorderPainted(false);
		twt.setContentAreaFilled(false);
		twt.setBounds(226, 572, 50, 50);
		frame.getContentPane().add(twt);
		
		// instagram icon ------------------------------------------------------------------------------------------------------------------------
		JButton ig = new JButton();
		ig.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				Image insta2 = new ImageIcon(this.getClass().getResource("/ig2.png")).getImage();
				ig.setIcon(new ImageIcon(insta2));
			}
			public void mouseExited(MouseEvent e) {
				Image insta = new ImageIcon(this.getClass().getResource("/ig.png")).getImage();
				ig.setIcon(new ImageIcon(insta));
			}
		});
		ig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openWebPage("");
			}
		});
		Image insta = new ImageIcon(this.getClass().getResource("/ig.png")).getImage();
		ig.setIcon(new ImageIcon(insta));
		ig.setFocusPainted(false);
		ig.setBorderPainted(false);
		ig.setContentAreaFilled(false);
		ig.setBounds(277, 572, 50, 50);
		frame.getContentPane().add(ig);
		
		// discord icon ---------------------------------------------------------------------------------------------------------------------------
		JButton dc = new JButton();
		dc.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				Image discord2 = new ImageIcon(this.getClass().getResource("/dc2.png")).getImage();
				dc.setIcon(new ImageIcon(discord2));
			}
			public void mouseExited(MouseEvent e) {
				Image discord = new ImageIcon(this.getClass().getResource("/dc.png")).getImage();
				dc.setIcon(new ImageIcon(discord));
			}
		});
		dc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openWebPage("");
			}
		});
		Image discord = new ImageIcon(this.getClass().getResource("/dc.png")).getImage();
		dc.setIcon(new ImageIcon(discord));
		dc.setFocusPainted(false);
		dc.setBorderPainted(false);
		dc.setContentAreaFilled(false);
		dc.setBounds(328, 572, 50, 50);
		frame.getContentPane().add(dc);
		
		// tictactoe logo --------------------------------------------------------------------------------------------------------------------
		JLabel tictactoename = new JLabel("");
		Image tictac = new ImageIcon(this.getClass().getResource("/tictactoename.png")).getImage();
		tictactoename.setIcon(new ImageIcon(tictac));
		tictactoename.setBounds(-25, 28, 442, 389);
		frame.getContentPane().add(tictactoename);
		
		// background image --------------------------------------------------------------------------------------------------------------------
		JLabel background = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/aaaa.png")).getImage();
		background.setIcon(new ImageIcon(img));
		background.setBounds(0, 0, 1096, 630);
		frame.getContentPane().add(background);	
		
	}
	
	// connects to browser ----------------------------------------------------------------------------------------------------------------------
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
