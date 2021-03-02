package maingame;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Game {

//	private JFrame frame;
	JFrame frame_1;
	private JPanel panel;
	private JButton[][] board;
	private boolean hasWinner;
	private JMenuBar menuBar;
	private JMenu file, diff, mode, help;
	private JMenuItem newGame, quit;
	private JMenuItem sizethree, sizefour, sizefive, sizesix;
	private JMenuItem twoplayer, AI;
	private String currentPlayer;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton helpbutton;
	private JButton privacy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game window = new Game();
					window.frame_1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Game() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
//		frame = new JFrame();
		frame_1 = new JFrame();
		panel = new JPanel(new GridLayout(3, 3));
		panel.setLocation(26, 51);
		panel.setSize(550, 556);
		frame_1.getContentPane().add(panel);
		frame_1.setTitle("TIC TAC TOE");
		frame_1.setResizable(false);
		frame_1.getContentPane().setBackground(new Color(217, 217, 217));
		frame_1.setUndecorated(true);
		frame_1.setBounds(100, 100, 1096, 630);
		frame_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_1.setLocationRelativeTo(null);
		frame_1.getContentPane().setLayout(null);
		
		currentPlayer = "X"; 
		board = new JButton[3][3];
		hasWinner = false;
		initializeMenuBar();
		initializeBoard();
	}
	
	private void initializeMenuBar() {
		
		JButton exitbutton = new JButton("X");
		exitbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitbutton.setBackground(new Color(217, 217, 217));
				exitbutton.setForeground(new Color(0, 0, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exitbutton.setBackground(new Color(255, 181, 0));
				exitbutton.setForeground(Color.WHITE);
			}
		});
		exitbutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exitbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitbutton.setFocusPainted(false);
		exitbutton.setForeground(Color.WHITE);
		exitbutton.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
		exitbutton.setBackground(new Color(255, 181, 0));
		exitbutton.setBorderPainted(false);
		exitbutton.setBounds(1044, 4, 42, 25);
		frame_1.getContentPane().add(exitbutton);
		
		JButton minibutton = new JButton("_");
		minibutton.setVerticalAlignment(SwingConstants.BOTTOM);
		minibutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				minibutton.setBackground(new Color(217, 217, 217));
				minibutton.setForeground(new Color(0, 0, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				minibutton.setBackground(new Color(255, 181, 0));
				minibutton.setForeground(Color.WHITE);
			}
		});
		minibutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		minibutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame_1.setState(JFrame.ICONIFIED);
			}
		});
		minibutton.setFocusPainted(false);
		minibutton.setForeground(Color.WHITE);
		minibutton.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		minibutton.setBackground(new Color(255, 181, 0));
		minibutton.setBorderPainted(false);
		minibutton.setBounds(998, 4, 42, 25);
		frame_1.getContentPane().add(minibutton);
		
		menuBar = new JMenuBar();
		menuBar.setBackground(new Color(62, 62, 62));
		menuBar.setBounds(0, 0, 1096, 34);
		file = new JMenu("FILE");
		file.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				file.setForeground(new Color(255, 181, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				file.setForeground(Color.WHITE);
			}
		});
		file.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		file.setForeground(Color.WHITE);
		file.setContentAreaFilled(false);

		newGame = new JMenuItem("New Game");
		newGame.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetBoard(); 
			}
		});
		quit = new JMenuItem("Quit");
		quit.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0); 
			}
		});
		
		diff = new JMenu("DIFFICULTY");
		diff.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				diff.setForeground(new Color(255, 181, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				diff.setForeground(Color.WHITE);
			}
		});
		diff.setForeground(Color.WHITE);
		diff.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
	
		sizethree = new JMenuItem("3 x 3");
		sizethree.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		sizefour = new JMenuItem("4 x 4");
		sizefour.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		sizefive = new JMenuItem("5 x 5");
		sizefive.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		sizesix = new JMenuItem("6 x 6");
		sizesix.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
	
		mode = new JMenu("MODE");
		mode.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mode.setForeground(new Color(255, 181, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				mode.setForeground(Color.WHITE);
			}
		});
		mode.setForeground(Color.WHITE);
		mode.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		mode.setContentAreaFilled(false);
		
		twoplayer = new JMenuItem("VS. HUMAN");
		twoplayer.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		AI = new JMenuItem("VS. COMPUTER");
		AI.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
//		help = new JMenu("HELP");
//		help.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
//		help.setForeground(Color.WHITE);
//		help.setForeground(Color.WHITE);
//		help.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		
		file.add(newGame);
		file.add(quit);
		menuBar.add(file);
		diff.add(sizethree);
		diff.add(sizefour);
		diff.add(sizefive);
		diff.add(sizesix);
		menuBar.add(diff);
		mode.add(twoplayer);
		mode.add(AI);
		menuBar.add(mode);
//		menuBar.add(help);
		frame_1.getContentPane().add(menuBar);
		
		helpbutton = new JButton("HELP");
		helpbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				helpbutton.setForeground(new Color(255, 181, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				helpbutton.setForeground(Color.WHITE);
			}
		});
		helpbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "INSTRUCTIONS");
			}
		});
		helpbutton.setForeground(Color.WHITE);
		helpbutton.setFocusPainted(false);
		helpbutton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		helpbutton.setContentAreaFilled(false);
		helpbutton.setBorderPainted(false);
		menuBar.add(helpbutton);
		
		JButton logoutbtn = new JButton("");
		logoutbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logoutbtn.setIcon(new ImageIcon(Game.class.getResource("/logout.png")));
		logoutbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Confirmation", JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.YES_OPTION){
					new Welcomepage().frame.setVisible(true);
					frame_1.dispose();
				}     
			}
		});
		logoutbtn.setFocusPainted(false);
		logoutbtn.setContentAreaFilled(false);
		logoutbtn.setBorderPainted(false);
		logoutbtn.setBounds(710, 525, 111, 82);
		frame_1.getContentPane().add(logoutbtn);
		
		JButton newGamebtn = new JButton("");
		newGamebtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		newGamebtn.setIcon(new ImageIcon(Game.class.getResource("/newgame.png")));
		newGamebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetBoard();
			}
		});
		newGamebtn.setFocusPainted(false);
		newGamebtn.setContentAreaFilled(false);
		newGamebtn.setBorderPainted(false);
		newGamebtn.setBounds(604, 523, 117, 94);
		frame_1.getContentPane().add(newGamebtn);		
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setIcon(new ImageIcon(Game.class.getResource("/quitbtn.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBounds(985, 560, 111, 50);
		frame_1.getContentPane().add(btnNewButton_1);
		
		privacy = new JButton("Privacy");
		privacy.setFocusPainted(false);
		privacy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openWebPage("https://www.google.com/");
			}
		});
		privacy.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		privacy.setContentAreaFilled(false);
		privacy.setBorderPainted(false);
		privacy.setBounds(586, 51, 101, 23);
		frame_1.getContentPane().add(privacy);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Game.class.getResource("/game.png")));
		lblNewLabel.setBounds(0, 0, 1096, 630);
		frame_1.getContentPane().add(lblNewLabel);
		
	}
	
	public void openWebPage(String url){
		   try {         
		     java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
		   }
		   catch (java.io.IOException e) {
		       System.out.println(e.getMessage());
		   }
	}
	
	private void resetBoard() {
		currentPlayer = "X";
		hasWinner = false;
		for (int i = 0; i < 3; i++) { 
			for (int j = 0; j < 3; j++) {
				board[i][j].setText(""); 
			}
		}
	}
	
	private void initializeBoard() {
		for (int i = 0; i < 3; i++) { 
			for (int j = 0; j < 3; j++) { 
				JButton btn = new JButton();
				btn.setFont(new Font(Font.SERIF, Font.BOLD, 100));
				btn.setForeground(new Color(0, 0, 0));
				btn.setBackground(Color.WHITE);
				btn.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
				btn.setFocusPainted(false);
				board[i][j] = btn;
				btn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (((JButton)e.getSource()).getText().equals("") &&
						hasWinner == false) {
							btn.setText(currentPlayer);
							hasWinner(); 
							togglePlayer(); 
						}
					}
				});
				panel.add(btn);
			}
		}
	}
	
	private void togglePlayer() {
		if (currentPlayer.equals("X"))
			currentPlayer = "O";
		else 
			currentPlayer = "X";
	}
	
	private void hasWinner() {
		ImageIcon kitty = new ImageIcon("C:\\Users\\PC\\OneDrive\\Desktop\\school\\images\\cat.png");
		JLabel icon = new JLabel(kitty);
		JLabel text = new JLabel("Congratulations!", JLabel.CENTER);
		JLabel text2 = new JLabel("PLAYER " + currentPlayer + " WON!", JLabel.CENTER);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(icon, BorderLayout.CENTER);
		panel.add(text, BorderLayout.NORTH);
		panel.add(text2, BorderLayout.SOUTH);
		
		Object[] options = {"Thank you!"};
			
		
		if (board[0][0].getText().equals(currentPlayer) && board[1][0].getText().equals(currentPlayer) && board[2][0].getText().equals(currentPlayer)) { 
			JOptionPane.showOptionDialog(panel, panel, "Congratulations", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
			hasWinner = true; 
		}
		else if (board[0][1].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[2][1].getText().equals(currentPlayer)) {
			JOptionPane.showOptionDialog(panel, panel, "Congratulations", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
			hasWinner = true;
		}
		else if (board[0][2].getText().equals(currentPlayer) && board[1][2].getText().equals(currentPlayer) && board[2][2].getText().equals(currentPlayer)) {
			JOptionPane.showOptionDialog(panel, panel, "Congratulations", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
			hasWinner = true;
		}
		else if (board[0][0].getText().equals(currentPlayer) && board[0][1].getText().equals(currentPlayer) && board[0][2].getText().equals(currentPlayer)) {
			JOptionPane.showOptionDialog(panel, panel, "Congratulations", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
			hasWinner = true;
		}
		else if (board[1][0].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[1][2].getText().equals(currentPlayer)) {
			JOptionPane.showOptionDialog(panel, panel, "Congratulations", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
			hasWinner = true;
		}
		else if (board[2][0].getText().equals(currentPlayer) && board[2][1].getText().equals(currentPlayer) && board[2][2].getText().equals(currentPlayer)) {
			JOptionPane.showOptionDialog(panel, panel, "Congratulations", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
			hasWinner = true;
		}
	}

	public void setVisible(boolean b) {
	}

}
