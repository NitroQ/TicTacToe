package maingame;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Cursor;
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
		frame = new JFrame();
		frame.setBounds (100, 100, 1096, 630);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton exitbtn = new JButton("X");
		exitbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		
		JButton playbtn = new JButton("");
		Image buttonplay = new ImageIcon(this.getClass().getResource("/playbtn.png")).getImage();
		playbtn.setIcon(new ImageIcon(buttonplay));
		playbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Image hoverplay = new ImageIcon(this.getClass().getResource("/playhmm.png")).getImage();
				playbtn.setIcon(new ImageIcon(hoverplay));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				playbtn.setIcon(new ImageIcon(buttonplay));
			}
		});
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
		playbtn.setBounds(573, 112, 407, 402);
		frame.getContentPane().add(playbtn);
		
		JLabel logo = new JLabel("");
		Image LOGO = new ImageIcon(this.getClass().getResource("/logooo.png")).getImage();
		logo.setIcon(new ImageIcon(LOGO));
		logo.setBounds(10, 532, 161, 87);
		frame.getContentPane().add(logo);
		
		JLabel background = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/welcomeback.png")).getImage();
		background.setIcon(new ImageIcon(img));
		background.setBounds(0, 0, 1096, 630);
		frame.getContentPane().add(background);	

	}

	public void setVisible(boolean b) {
		
	}
}
