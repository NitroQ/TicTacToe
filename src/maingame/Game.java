package maingame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.MatteBorder;


public class Game {
	
	// setting global variables -----------------------------------------------------------------------------------------------------------------
	JFrame frame;
	Credentials id1;
	private JPanel panel;
	private JButton[][] board;
	private boolean hasWinner;
	private JMenuBar menuBar;
	private JMenu file, diff, mode;
	private JMenuItem newGame, quit;
	private JMenuItem sizethree, sizefour;
	private JMenuItem twoplayer, AI;
	private String currentPlayer;
	private JLabel lblNewLabel;
	private JButton helpbutton;
	private JButton privacy;
	private JButton terms;
	private JButton aboutus;
	private JLabel logomenu;
	private JButton newGamebtn;
	private JLabel newGamelbl;
	private JLabel logoutlbl;
	private JButton logoutbtn;					     
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game window = new Game(null);
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
	public Game(Credentials id) {
		id1 =id;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		// JFrame and JPanel initialization ----------------------------------------------------------------------------------------------------------
		frame = new JFrame();
		panel = new JPanel(new GridLayout(3, 3));
		panel.setLocation(307, 61);
		panel.setSize(779, 558);
		frame.getContentPane().add(panel);
		frame.setTitle("TIC TAC TOE");
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(217, 217, 217));
		frame.setUndecorated(true);
		frame.setBounds(100, 100, 1096, 630);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		// initializing the fields -------------------------------------------------------------------------------------------------------------------
		currentPlayer = "X"; 
		board = new JButton[3][3];
		hasWinner = false;
		initializeMenuBar();
		initializeBoard();
	}
	
	// initializing the menu bar ---------------------------------------------------------------------------------------------------------------------
	private void initializeMenuBar() {
		
		// close button ------------------------------------------------------------------------------------------------------------------------------
		JButton exitbutton = new JButton("X");
		exitbutton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				exitbutton.setBackground(new Color(217, 217, 217));
				exitbutton.setForeground(new Color(0, 0, 0));
			}
			public void mouseExited(MouseEvent e) {
				exitbutton.setBackground(new Color(255, 181, 0));
				exitbutton.setForeground(Color.WHITE);
			}
		});
		exitbutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exitbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// confirm dialog ---------------------------------------------------------------------------------------------------------------------
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
		frame.getContentPane().add(exitbutton);
		
		// minimize button ----------------------------------------------------------------------------------------------------------------------------
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
				frame.setState(JFrame.ICONIFIED);
			}
		});
		minibutton.setFocusPainted(false);
		minibutton.setForeground(Color.WHITE);
		minibutton.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		minibutton.setBackground(new Color(255, 181, 0));
		minibutton.setBorderPainted(false);
		minibutton.setBounds(998, 10, 42, 30);
		frame.getContentPane().add(minibutton);
		
		// new instance of menu bar -----------------------------------------------------------------------------------------------------------------
		menuBar = new JMenuBar();
		menuBar.setBackground(new Color(62, 62, 62));
		menuBar.setBounds(0, 0, 1096, 50);
		
		// file menu --------------------------------------------------------------------------------------------------------------------------------
		file = new JMenu("FILE");
		file.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				file.setForeground(new Color(255, 181, 0));
			}
			public void mouseExited(MouseEvent e) {
				file.setForeground(Color.WHITE);
			}
		});
		file.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		file.setForeground(Color.WHITE);
		file.setContentAreaFilled(false);

		// new game menu item inside of file -----------------------------------------------------------------------------------------------------------
		newGame = new JMenuItem("New Game");
		// adding a shortcut key -----------------------------------------------------------------------------------------------------------------------
		KeyStroke ctrlN = KeyStroke.getKeyStroke(KeyEvent.VK_N, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask());
		newGame.setAccelerator(ctrlN);
		newGame.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetBoard(); 
			}
		});
		
		// quit button ---------------------------------------------------------------------------------------------------------------------------------
		quit = new JMenuItem("Quit");
		KeyStroke ctrlW = KeyStroke.getKeyStroke(KeyEvent.VK_W, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask());
		quit.setAccelerator(ctrlW);
		quit.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0); 
			}
		});
		
		// difficulty menu -----------------------------------------------------------------------------------------------------------------------------
		diff = new JMenu("DIFFICULTY");
		diff.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				diff.setForeground(new Color(255, 181, 0));
			}
			public void mouseExited(MouseEvent e) {
				diff.setForeground(Color.WHITE);
			}
		});
		diff.setForeground(Color.WHITE);
		diff.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		
		// 3X3 menu item -------------------------------------------------------------------------------------------------------------------------------
		sizethree = new JMenuItem("3 x 3");
		sizethree.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		
		// 4X4 menu item -------------------------------------------------------------------------------------------------------------------------------
		sizefour = new JMenuItem("4 x 4");
		sizefour.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		sizefour.setToolTipText("COMING SOON");
	
		// mode menu -----------------------------------------------------------------------------------------------------------------------------------
		mode = new JMenu("MODE");
		mode.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				mode.setForeground(new Color(255, 181, 0));
			}
			public void mouseExited(MouseEvent e) {
				mode.setForeground(Color.WHITE);
			}
		});
		mode.setForeground(Color.WHITE);
		mode.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		mode.setContentAreaFilled(false);
		
		// VS. PLAYER menu item ------------------------------------------------------------------------------------------------------------------------
		twoplayer = new JMenuItem("VS. HUMAN");
		twoplayer.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		
		// VS. COMPUTER menu item ----------------------------------------------------------------------------------------------------------------------
		AI = new JMenuItem("VS. COMPUTER");
		AI.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		AI.setToolTipText("COMING SOON");
		
		// Code Vision Studios logo --------------------------------------------------------------------------------------------------------------------
		logomenu = new JLabel("");
		Image menulogo = new ImageIcon(this.getClass().getResource("/golo.png")).getImage();
		logomenu.setIcon(new ImageIcon(menulogo));
		menuBar.add(logomenu);
		
		// adding menu items to their respective menus and menus to the menubar
		file.add(newGame);
		file.add(quit);
		menuBar.add(file);
		diff.add(sizethree);
		diff.add(sizefour);
		menuBar.add(diff);
		mode.add(twoplayer);
		mode.add(AI);
		menuBar.add(mode);
		frame.getContentPane().add(menuBar);
		
		// help -------------------------------------------------------------------------------------------------------------------------------------
		helpbutton = new JButton("HELP");
		helpbutton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				helpbutton.setForeground(new Color(255, 181, 0));
			}
			public void mouseExited(MouseEvent e) {
				helpbutton.setForeground(Color.WHITE);
			}
		});
		// JOptionPane that shows the mechanics --------------------------------------------------------------------------------------------------
		helpbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String html = "<html><body width = '%1s'><h1>RULES FOR TIC-TAC-TOE</h>"
						+ "<p>1. The game is played on a grid that's 3 squares by 3 squares by default, "
						+ "but there is the option of changing it to 4 squares by 4 squares. <br><br>"
						+ "<p>2. You are X, your friend (or the computer) is O. "
						+ "Players take turns putting their marks in empty squares.<br><br>"
						+ "<p>3. The first player to get 3 of her marks in a row (up, down, across, or diagonally) "
						+ "is the winner.<br><br>"
						+ "4. When all 9 squares are full, the game is over. If no player has 3 marks in a row, "
						+ "the game ends in a tie.";
				
				int width = 500;
				JOptionPane.showMessageDialog(null, String.format(html, width, width));
			}
		});
		helpbutton.setForeground(Color.WHITE);
		helpbutton.setFocusPainted(false);
		helpbutton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		helpbutton.setContentAreaFilled(false);
		helpbutton.setBorderPainted(false);
		menuBar.add(helpbutton);
		
		// privacy button -----------------------------------------------------------------------------------------------------------------------
		privacy = new JButton("Privacy");
		privacy.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		privacy.setBounds(0, 596, 83, 23);
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
		terms.setBounds(68, 596, 77, 23);
		frame.getContentPane().add(terms);
		
		// about us button ---------------------------------------------------------------------------------------------------------------------------------
		aboutus = new JButton("About Us");
		aboutus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		aboutus.setBounds(133, 596, 90, 23);
		frame.getContentPane().add(aboutus);
		
		// new game label ------------------------------------------------------------------------------------------------------------------------
		newGamelbl = new JLabel("NEW GAME");
		newGamelbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		newGamelbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				resetBoard();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				newGamelbl.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				newGamelbl.setForeground(new Color(0, 0, 0));
			}
		});
		newGamelbl.setFont(new Font("Luckiest Guy", Font.PLAIN, 20));
		newGamelbl.setBounds(197, 548, 100, 23);
		frame.getContentPane().add(newGamelbl);
		
		// new game button ("O") -----------------------------------------------------------------------------------------------------------------
		newGamebtn = new JButton("O");
		newGamebtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		newGamebtn.setFocusPainted(false);
		newGamebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetBoard();
			}
		});
		newGamebtn.setBorderPainted(false);
		newGamebtn.setContentAreaFilled(false);
		newGamebtn.setVerticalAlignment(SwingConstants.BOTTOM);
		newGamebtn.setFont(new Font("Luckiest Guy", Font.PLAIN, 55));
		newGamebtn.setBounds(133, 530, 77, 69);
		frame.getContentPane().add(newGamebtn);
		
		// logout label ---------------------------------------------------------------------------------------------------------------------------
		logoutlbl = new JLabel("LOG OUT");
		logoutlbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logoutlbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Confirmation", JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.YES_OPTION){
					Credentials cd = new Credentials();
					Login in = new Login(cd);
					in.frame.setVisible(true);
					frame.dispose();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				logoutlbl.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				logoutlbl.setForeground(new Color(0, 0, 0));
			}
		});
		logoutlbl.setFont(new Font("Luckiest Guy", Font.PLAIN, 20));
		logoutlbl.setBounds(55, 548, 90, 23);
		frame.getContentPane().add(logoutlbl);
		
		// logout button ("X") -----------------------------------------------------------------------------------------------------------------
		logoutbtn = new JButton("X");
		logoutbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logoutbtn.setFocusPainted(false);
		logoutbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Confirmation", JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.YES_OPTION) {
					Credentials cd = new Credentials();
					Login in = new Login(cd);
					in.frame.setVisible(true);
					frame.dispose();
				}     
			}
		});
		logoutbtn.setBorderPainted(false);
		logoutbtn.setContentAreaFilled(false);
		logoutbtn.setVerticalAlignment(SwingConstants.BOTTOM);
		logoutbtn.setFont(new Font("Luckiest Guy", Font.PLAIN, 53));
		logoutbtn.setBounds(0, 530, 67, 69);
		frame.getContentPane().add(logoutbtn);
		
		lblNewLabel_2 = new JLabel("Welcome,");
		lblNewLabel_2.setFont(new Font("Luckiest Guy", Font.PLAIN, 25));
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setBounds(24, 247, 120, 50);
		frame.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel(id1.getFname());
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Luckiest Guy", Font.PLAIN, 30));
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setBounds(24, 280, 262, 50);
		frame.getContentPane().add(lblNewLabel_3);
		
		//Tic Tac Toe Image --------------------------------------------------------------------------------------------------------------
		JLabel lblNewLabel_1 = new JLabel("");
		Image tictac = new ImageIcon(this.getClass().getResource("/tictactoename250p.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(tictac));
		lblNewLabel_1.setBounds(-43, 10, 250, 253);
		frame.getContentPane().add(lblNewLabel_1);
		
		// background image ---------------------------------------------------------------------------------------------------------------------
		lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/backgame2.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(0, 0, 1096, 630);
		frame.getContentPane().add(lblNewLabel);
		
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
	
	// clears the board ---------------------------------------------------------------------------------------------------------------------------
	private void resetBoard() {
		currentPlayer = "X";
		hasWinner = false;
		for (int i = 0; i < 3; i++) { 
			for (int j = 0; j < 3; j++) {
				board[i][j].setText(""); 
			}
		}
	}
	
	// initializes the board -----------------------------------------------------------------------------------------------------------------
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
					// enables user to put their character on a button ---------------------------------------------------------------------------------
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
	
	// toggles player/ switches players -----------------------------------------------------------------------------------------------------------------
	private void togglePlayer() {
		if (currentPlayer.equals("X"))
			currentPlayer = "O";
		else 
			currentPlayer = "X";
	}
	
	// checks if any of the conditions are true to declare a winner ----------------------------------------------------------------------------------------
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
		else if (!board[0][0].getText().equals("") && !board[1][0].getText().equals("") && !board[2][0].getText().equals("") && 
				!board[0][1].getText().equals("") && !board[1][1].getText().equals("") && !board[2][1].getText().equals("") &&
				!board[0][2].getText().equals("") && !board[1][2].getText().equals("") && !board[2][2].getText().equals("") &&
				!board[0][0].getText().equals("") && !board[0][1].getText().equals("") && !board[0][2].getText().equals("") &&
				!board[1][0].getText().equals("") && !board[1][1].getText().equals("") && !board[1][2].getText().equals("") &&
				!board[2][0].getText().equals("") && !board[2][1].getText().equals("") && !board[2][2].getText().equals("")) {
			JOptionPane.showMessageDialog(null, "It's a tie!");
		}
	}
	
	public void setVisible(boolean b) {
		}
	}

