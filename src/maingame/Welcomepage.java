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
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Welcomepage {

	public JFrame frame;

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
		
		// close button --------------------------------------------------------------------------------------------------------------------------
		JButton exitbtn = new JButton("X");
		exitbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// confirm dialog ----------------------------------------------------------------------------------------------------------------
				int exitconfirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "", JOptionPane.YES_NO_OPTION);
				if (exitconfirmation == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		exitbtn.setFocusPainted(false);
		exitbtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		exitbtn.setBorder(new RoundedBorder(15));
		exitbtn.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
		exitbtn.setForeground(new Color(0, 0, 0));
		exitbtn.setBounds(1036, 11, 50, 28);
		frame.getContentPane().add(exitbtn);
		
		// play button --------------------------------------------------------------------------------------------------------------------------
		JButton playbtn = new JButton("");
		Image buttonplay = new ImageIcon(this.getClass().getResource("/playbtn.png")).getImage();
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
		playbtn.setBounds(589, 240, 407, 402);
		frame.getContentPane().add(playbtn);
		
		// Code Vision Studios logo -------------------------------------------------------------------------------------------------------------
		JLabel logo = new JLabel("");
		Image LOGO = new ImageIcon(this.getClass().getResource("/logooo.png")).getImage();
		logo.setIcon(new ImageIcon(LOGO));
		logo.setBounds(10, 532, 161, 87);
		frame.getContentPane().add(logo);
		
		
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
