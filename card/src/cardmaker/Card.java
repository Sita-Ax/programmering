package cardmaker;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

// The Card class represents a single card in the memory game.
// It extends JLabel to display the card's image and implements MouseListener to handle mouse events.
public class Card extends JLabel implements MouseListener {

	private transient Icon faceIcon; // Icon for the front of the card
	private transient Icon backIcon; // Icon for the back of the card
	private boolean faceUp = false; // Indicates whether the card is face up or face down
	private int number; // Number corresponding to the face of the card
	private boolean mousePressedOn = false; // Indicates if the mouse was pressed on this card
	private transient CardController controller; // Reference to the controller handling game logic

	// Constructor for the Card class
	public Card(Icon face, Icon back, int number, CardController controller) {
		// Initializes the card with the back icon showing
		super(back);
		this.faceIcon = face;
		this.backIcon = back;
		this.number = number;
		this.controller = controller;
		// Add mouse listener to handle mouse events
		this.addMouseListener(this);
	}

	// Additional constructor for creating a card with ImageIcon parameters
	public Card(ImageIcon imageIcon, ImageIcon backIcon2, int number2) {
		// This constructor can be used for creating a card with specific ImageIcon
		// objects
	}

	// Returns the number to identifying the face of the Card
	public int getNumber() {
		return number;
	}

	// Sets whether the card is face up or face down and updates the icon
	// accordingly,
	// check if the coordinates are over the icon return true if it�s over icon
	// othewise false and calls mouseClicked and mousePressed
	public void setFaceUp(boolean faceUp) {
		this.faceUp = faceUp;
		this.setIcon(faceUp ? this.faceIcon : this.backIcon);
	}

	// Attempts to turn the card face up by notifying the controller from
	// mussedClicked on
	public void turnUp() {
		if (!this.faceUp) {
			this.controller.turnUp(this);
		}
	}

	// Turns the card face down
	public void turnDown() {
		setFaceUp(false);
	}

	// Invoked when the mouse button has been clicked (pressed and released) on the
	// card.
	@Override
	public void mouseClicked(MouseEvent e) {
		if (!this.faceUp) {
			this.turnUp();
		}
	}

	// Invoked when a mouse button has been pressed on the card
	@Override
	public void mousePressed(MouseEvent e) {
		this.mousePressedOn = true;
	}

	// Invoked when a mouse button has been released on the card
	@Override
	public void mouseReleased(MouseEvent e) {
		if (this.mousePressedOn) {
			// Mouse is no longer pressed
			this.mousePressedOn = false;
		}
	}

	// Invoked when the mouse enters the card's area
	@Override
	public void mouseEntered(MouseEvent e) {
		// No specific action required when mouse enters
	}

	// Invoked when the mouse exits the card's area
	@Override
	public void mouseExited(MouseEvent e) {
		// Forget the previous mouse press
		this.mousePressedOn = false;
	}

}
