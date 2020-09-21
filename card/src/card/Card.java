package card;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.JLabel;
//The object of Label class is a component for placing text in a container. 
//It is used to display a single line of read only text. The text can be changed by 
//an application but a user cannot edit it directly.

//The Java MouseListener is notified whenever you change the state of mouse. 
//It is notified against MouseEvent. The MouseListener interface is found in java. awt. event package.

public class Card extends JLabel implements MouseListener {

	Icon faceIcon;
	Icon backIcon;
	// card is initially face down
	boolean faceUp = false;
	// number corresponding to the face of the card
	int number;
	// half the dimensions of the back face icon
	int iconWidhHalf, iconHeightHalf;
	boolean mousePressedOn = false;
	public cardController controller;

	public Card(cardController controller, Icon face, Icon back, int number) {

		// beginns whith faceDown
		super(back);
		//
		this.faceIcon = face;
		this.backIcon = back;
		this.number = number;
		// catch mouse click and events
		this.addMouseListener(this);
		// store icons dimension for mouse click
		System.out.println("ccc");
		this.iconWidhHalf = faceIconWidth() / 2;
		this.iconHeightHalf = backIconHeight() / 2;
//		this.controller = controller;
	}

	private int faceIconWidth() {
		return 0;
	}

	private int backIconHeight() {
		return 0;
	}

	// return the number to id the kind of faceCard
	public int getNumber() {
		return number;
	}

	// check if the coordinates are over the icon return true if it´s over icon
	// othewise false
	private boolean overIcon(int x, int y) {
		// calc the distance frome the center of the label
		int distX = Math.abs(x - (this.getWidth() / 2));
		int distY = Math.abs(y - (this.getHeight() / 2));
		// outside icon region
		if (distX > this.iconHeightHalf || distY > this.iconWidhHalf)
			return false;
		// inside icon region
		return true;
	}

	public void turnUp() {

//?????		Game.println("Card[" + number + "].turnUp()");
		if (this.faceUp)
			return;
		// the card is faceUp
		this.faceUp = true;
		// asked if the card could turn up
		this.faceUp = this.controller.turnUp(this);
		// change image when the card is allow to turn
		if (this.faceUp)
			this.setIcon(this.faceIcon);
	}

	public void turnDown() {

//???		Game.println("Card[" makeCard + number + "].turnDown()");
		// the card is faceDown
		if (!this.faceUp)
			return;
		// change image
		this.setIcon(this.backIcon);
		// card is down
		this.faceUp = false;
	}

	// Invoked when the mouse button has been clicked (pressed and released)try to
	// turn up the card.
	// override is holding info about the button click
	@Override
	public void mouseClicked(MouseEvent e) {
		if (overIcon(e.getX(), e.getY()))
			this.turnUp();
	}

	// Invoked when a mouse button has been pressed on a card. over icon so remember
	// this press
	// override is holding info about the button press
	@Override
	public void mousePressed(MouseEvent e) {
		if (overIcon(e.getX(), e.getY()))
			this.mousePressedOn = true;
	}

	// Invoked when a mouse button has been released on a card.holding information
	// about the button release
	// last press was overIcon
	@Override
	public void mouseReleased(MouseEvent e) {
		if (this.mousePressedOn) {
			// mouse is no longer pressed
			this.mousePressedOn = false;
			// it was a click, so treat it as one
			this.mouseClicked(e);
		}
	}

	// Invoked when the mouse enters a card and holding information about the mouse
	// pointer
	@Override
	public void mouseEntered(MouseEvent e) {
	}

	// Invoked when the mouse exits a card and holding information about the mouse
	// pointer
	@Override
	public void mouseExited(MouseEvent e) {
		// forget the previous mouse press
		this.mousePressedOn = false;
	}

}
