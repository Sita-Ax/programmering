package cardmaker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Game implements ActionListener {

	// This frame is the window
	private JFrame mainFrame;
	private Container mainContentPane;
	// Array to hold the card images (0-6 front side, 7 backside)
	private ImageIcon[] cardIcon;
	private CardController controller;
	private JLabel scoreLabel;
	// Total number of cards matches in the game
	private int totalMatches;
	// Number of correct matches
	private int score;
	// Number of gusses made by user
	private int guesses;
	// If game has started or not
	private boolean gameStarted;

	// Constructor
	public Game() {
		// Headframe is created
		this.mainFrame = new JFrame("Memory Game");
		// The exit button in the right corner in the frame
		this.mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		// Set the size of the frame
		this.mainFrame.setSize(800, 800);
		// Get the content pane of the frame
		this.mainContentPane = this.mainFrame.getContentPane();
		// Background color of content pane
		this.mainContentPane.setBackground(Color.RED);
		// The layout as boxLayout
		// //docs.oracle.com/javase/tutorial/uiswing/layout/box.html
		this.mainContentPane.setLayout(new BoxLayout(this.mainContentPane, BoxLayout.PAGE_AXIS));
		// Create and set the menu bar
		JMenuBar menuBar = new JMenuBar();
		this.mainFrame.setJMenuBar(menuBar);
		// Create the game menu
		JMenu gameMenu = new JMenu("Game Menu! ");
		menuBar.add(gameMenu);
		// Add menu items to the game menu
		newMenuItem("New Game! ", gameMenu, this);
		newMenuItem("Exit! ", gameMenu, this);
		// Create generic submenu creater that i can put rules etc
		JMenu aboutMenu = new JMenu("About ");
		gameMenu.add(aboutMenu);
		newMenuItem("About! ", aboutMenu, this);

		// Load the card icons
		this.cardIcon = loadCardIcon();
		// Initialize the card controller
		this.controller = new CardController(this);
		// Initialize the score label
		this.scoreLabel = new JLabel("Score: 0");
		this.mainContentPane.add(this.scoreLabel);
		// Make the frame visible
		this.mainFrame.setVisible(true);
		// No game started yet
		this.gameStarted = false;
		this.totalMatches = 6;
		this.score = 0;
		this.guesses = 0;

	}

	// Load card Icons
	private ImageIcon[] loadCardIcon() {
		ImageIcon[] icons = new ImageIcon[7];
		for (int i = 0; i < 6; i++) {
			icons[i] = new ImageIcon((i + 1) + ".jpg");
		}
		icons[6] = new ImageIcon("7.jpg");
		return icons;
	}

	// Create a new menu item and add it to the menu
	private void newMenuItem(String text, JMenu gameMenu, ActionListener listener) {
		JMenuItem newItem = new JMenuItem(text);
		newItem.setActionCommand(text);
		// The listener takes the listner and put it in here
		newItem.addActionListener(listener);
		// Put in new items
		gameMenu.add(newItem);
	}

	// Create the card panel
	public JPanel makeCardPanel() {
		// Set the panel layout so the card are getting 3 row and 4 columns
		JPanel panel = new JPanel(new GridLayout(3, 4));
		// All card have the same back pic 7
		ImageIcon backIcon = this.cardIcon[6];

		// Create an array to hold the card numbers 3*4 grid request 12 cards
		int[] cardToAdd = new int[12];
		for (int i = 0; i < 6; i++) {
			cardToAdd[2 * i] = i;
			cardToAdd[2 * i + 1] = i;
		}
		// Randomize the card order
		randomCardArray(cardToAdd);
		// Add the cards to the panel
		for (int i = 0; i < cardToAdd.length; i++) {
			int number = cardToAdd[i];
			Card newCard = new Card(this.cardIcon[number], backIcon, number, controller);
			panel.add(newCard);
		}
		return panel;
	}

	// Randomize the order of the cards
	private void randomCardArray(int[] cards) {
		Random random = new Random();
		for (int i = 0; i < cards.length; i++) {
			int index = random.nextInt(cards.length);
			int s = cards[index];
			cards[index] = cards[i];
			cards[i] = s;
		}
	}

	// Start a new game
	public void newGame() {
		// remove all old cards
		this.mainContentPane.removeAll();
		this.controller = new CardController(this);
		this.score = 0;
		this.guesses = 0;
		// Add a new set of cards
		this.mainContentPane.add(makeCardPanel(), BorderLayout.CENTER);
		this.mainFrame.add(this.scoreLabel);
		this.totalMatches = 6;
		// Reset the score
		this.updateScore(0);
		this.gameStarted = true;
		this.mainFrame.revalidate();
		this.mainFrame.repaint();
	}

	// Update the score label
	private void updateScoreLabel() {
		// Update the score- and guesses labels.
		this.scoreLabel.setText("Score: " + this.score + " | Guesses: " + this.guesses);
	}

	public void updateScore(int score) {
		// Update the score
		this.score = score;
		// Update the score label
		updateScoreLabel();
		// Check if all match are found and game is over
		if (score == this.totalMatches && this.gameStarted) {
			// Show a message asking if the user wants to play agian or not
			int option = JOptionPane.showConfirmDialog(this.mainFrame, "You won! Do you want to play again?",
					"Game Over", JOptionPane.YES_NO_OPTION);
			// If yes, start a new game
			if (option == JOptionPane.YES_OPTION) {
				newGame();
			} else {
				// If no, exit the game
				System.exit(0);
			}
		}
	}

	// Increment guesses and update the score label
	public void incrementGuesses() {
		// Increment guesses every turn
		this.guesses++;
		// Update the score and guesses labels
		updateScore(this.score);
	}

	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if ("New Game! ".equals(command)) {
			newGame();
		}
		if (("Exit! ".equals(command))) {
			System.exit(0);
		}
	}
}