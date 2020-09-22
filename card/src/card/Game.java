package card;
import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Window;
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
import javax.swing.JPanel;


public class Game implements ActionListener  {

	// the frame is the window
	private Window window;
	private JFrame mainFrame;
	private Container mainContentPane;
	// 0-6 front side and 7 backside
	private ImageIcon cardIcon[];

	
	//this is a constractior
	public Game() {

		super();
		
		// this is the whole frame is created and this is memory
		this.mainFrame = new JFrame("Memory Game");
		
		// the exit button in the right corner in the frame
		this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// this is the size on the frame
		this.mainFrame.setSize(1000, 1000);
		// the content say what you can do in the game and that is on the frame
		this.mainContentPane = this.mainFrame.getContentPane();
		// color of frame
		this.mainContentPane.setBackground(Color.RED);
		// the boxLayout get the buttons from up to down
		// //docs.oracle.com/javase/tutorial/uiswing/layout/box.html
		this.mainContentPane.setLayout(new BoxLayout(this.mainContentPane, BoxLayout.PAGE_AXIS));
		// menu bar
		JMenuBar menuBar = new JMenuBar();
		this.mainFrame.setJMenuBar(menuBar);
		// game menu
		JMenu gameMenu = new JMenu("Game Menu! ");
		menuBar.add(gameMenu);
		// the menu in the frame
		newMenuItem("New Game! ", gameMenu, this);
		newMenuItem("Exit! ", gameMenu, this);
		// create generic submenu creater that i can put rules etc
		JMenu aboutMenu = new JMenu("About ");
		gameMenu.add(aboutMenu);
		newMenuItem("About! ", aboutMenu, this);
//		// load the cards
		this.cardIcon = loadCardIcon();

		JInternalFrame window = new JInternalFrame("Image");
		mainFrame.add(window);
		window.setSize(700, 700);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel contentPane = new JPanel(new BorderLayout());
		
		contentPane.setBackground(Color.BLUE);
		
		JLabel cardLabel = new JLabel(new ImageIcon("1.jpg"));
		cardLabel.setBounds(1, 1, 150, 150);
		cardLabel.setVisible(true);
		
		JLabel cardLabel1 = new JLabel(new ImageIcon("2.jpg"));
		cardLabel1.setBounds(1, 151, 150, 150);
		cardLabel1.setVisible(true);
		
		JLabel cardLabel2 = new JLabel(new ImageIcon("3.jpg"));
		cardLabel2.setBounds(1, 301, 150, 150);
		cardLabel2.setVisible(true);
		
		JLabel cardLabel3 = new JLabel(new ImageIcon("4.jpg"));
		cardLabel3.setBounds(151 ,1, 150, 150);
		cardLabel3.setVisible(true);
		
		JLabel cardLabel4 = new JLabel(new ImageIcon("5.jpg"));
		cardLabel4.setBounds(301, 1,150,150);
		cardLabel4.setVisible(true);
		
		JLabel cardLabel5 = new JLabel(new ImageIcon("6.jpg"));
		cardLabel5.setBounds(451, 1, 150, 150);
		cardLabel5.setVisible(true);
		
		contentPane.add(cardLabel);
		contentPane.add(cardLabel1);
		contentPane.add(cardLabel2);
		contentPane.add(cardLabel3);
		contentPane.add(cardLabel4);
		contentPane.add(cardLabel5);

		window.add(contentPane);
		
		window.setVisible(true);
		
	}

	private void prepareGUI() {
		// TODO Auto-generated method stub
		
	}

	private ImageIcon[] loadCardIcon() {

		ImageIcon icon[] = new ImageIcon[6];
		for (int i = 0; i < 6; i++) {
			// put the image in the program
			
			String fileName = "";
			icon[i] = new ImageIcon("jpg");
			icon[1] = new ImageIcon("1.jpg");
			icon[2] = new ImageIcon("2.jpg");
			icon[3] = new ImageIcon("3.jpg");
			icon[4] = new ImageIcon("4.jpg");
			icon[5] = new ImageIcon("5.jpg");
//			icon[6] = new ImageIcon("6.jpg");
//			icon[7] = new ImageIcon("7.jpg");
			System.out.println("ico 7st");
		}
		return icon;
	}

	public JPanel makeCard() {
		// the card are getting 3row and 4 columns
		JPanel panel = new JPanel(new GridLayout(3, 4));
		// all card have the same back
		ImageIcon backIcon = this.cardIcon[3];
//		System.out.println(cardIcon[0]);
		cardController controller = new cardController();
		// 3*4 grid request 12 cards
		int cardToAdd[] = new int[12];
		for (int i = 0; i < 7; i++) {
			cardToAdd[2 * i] = i;
			cardToAdd[2 * i + 1] = i;
		}

		randomCardArray(cardToAdd);
		// Because we will random later we must have the card an object
		for (int i = 0; i < cardToAdd.length; i++) {
			int number = cardToAdd[i];
			Card newCard = new Card( this.cardIcon[number], backIcon, number);
			System.out.println("adcard put in 12");
			panel.add(newCard);
		}
		return panel;
	
	}

	// random method to get the card mixed up//swap
	private void randomCardArray(int[] cards) {

		Random random = new Random();
		for (int i = 0; i < cards.length; i++) {
			int index = random.nextInt(cards.length);
			System.out.println("rand 12 st");
			// swap
			int s = cards[index];
			cards[index] = cards[i];
			cards[i] = s;
		}
		// we need controller that control's the card behaviors and also game
	}

	private void newMenuItem(String string, JMenu gameMenu, ActionListener listener) {
		JMenuItem newItem = new JMenuItem(string);
		newItem.setActionCommand(string);
		// the listener takes the listner and put it in here
		newItem.addActionListener(listener);
		System.out.println("newit put in 4");
		// put in new items
		gameMenu.add(newItem);

	}

	public void newGame() {
		// remove all old card
		this.mainContentPane.removeAll();
		// mainWindow
		this.mainFrame.setVisible(true);
		// make new card set
		this.mainContentPane.add(makeCard());
		System.out.println("newg at last ");
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("New Game! "))
			if(e.getActionCommand()== "New Game! ") {
//				mainFrame.getContentPane().removeAll();
				window = new Window(this.mainFrame);
////				dispose();
			}
			newGame();
		System.out.println("act after rep this is last");
		if (e.getActionCommand().equals("Exit! "));
//			System.exit(0);
	}

	private void dispose() {
		// TODO Auto-generated method stub
		
	}
}