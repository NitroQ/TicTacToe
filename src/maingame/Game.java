package maingame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.MatteBorder;


public class Game {
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
	private JLabel lblNewLabel;
	private JButton btnNewButton_1;
	private JButton helpbutton;
	private JButton privacy;
	private JButton terms;
	private JLabel logomenu;
	private JLabel playerplaying;

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
		frame_1 = new JFrame();
		panel = new JPanel(new GridLayout(3, 3));
		panel.setLocation(307, 61);
		panel.setSize(779, 558);
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
				int exitconfirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "", JOptionPane.YES_NO_OPTION);
				if (exitconfirmation == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		exitbutton.setFocusPainted(false);
		exitbutton.setForeground(Color.WHITE);
		exitbutton.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
		exitbutton.setBackground(new Color(255, 181, 0));
		exitbutton.setBorderPainted(false);
		exitbutton.setBounds(1044, 10, 42, 30);
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
		minibutton.setBounds(998, 10, 42, 30);
		frame_1.getContentPane().add(minibutton);
		
		menuBar = new JMenuBar();
		menuBar.setBackground(new Color(62, 62, 62));
		menuBar.setBounds(0, 0, 1096, 50);
		
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
		
		logomenu = new JLabel("");
		Image menulogo = new ImageIcon(this.getClass().getResource("/golo.png")).getImage();
		logomenu.setIcon(new ImageIcon(menulogo));
		menuBar.add(logomenu);
		
		file.add(newGame);
		file.add(quit);
		menuBar.add(file);
		diff.add(sizethree);
		diff.add(sizefour);
		menuBar.add(diff);
		mode.add(twoplayer);
		mode.add(AI);
		menuBar.add(mode);
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
					Credentials cd = new Credentials();
					Login in = new Login(cd);
					in.frame.setVisible(true);
					frame_1.dispose();
				}     
			}
		});
		logoutbtn.setFocusPainted(false);
		logoutbtn.setContentAreaFilled(false);
		logoutbtn.setBorderPainted(false);
		logoutbtn.setBounds(31, 490, 111, 82);
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
		newGamebtn.setBounds(152, 490, 117, 94);
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
		btnNewButton_1.setBounds(31, 421, 111, 50);
		frame_1.getContentPane().add(btnNewButton_1);
		
		privacy = new JButton("Privacy");
		privacy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				privacy.setText("<HTML><U>Privacy</U></HTML>");
			}
			@Override
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
		privacy.setBounds(0, 596, 83, 23);
		frame_1.getContentPane().add(privacy);
		
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
		terms.setBounds(70, 596, 77, 23);
		frame_1.getContentPane().add(terms);
		
		lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/back game.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
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
				btn.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						btn.setBackground(new Color(217, 217, 217));
						btn.setForeground(Color.WHITE);
					}
					@Override
					public void mouseExited(MouseEvent e) {
						btn.setBackground(Color.WHITE);
						btn.setForeground(new Color(0, 0, 0));
					}
				});
				btn.setVerticalAlignment(SwingConstants.BOTTOM);
				btn.setFont(new Font("Luckiest Guy", Font.PLAIN, 150));
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
		JLabel text = new JLabel("Congratulations!", JLabel.CENTER);
		JLabel text2 = new JLabel("PLAYER " + currentPlayer + " WON!", JLabel.CENTER);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
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

