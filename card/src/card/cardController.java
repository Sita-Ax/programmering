package card;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.Timer;

public class cardController implements ActionListener  {

	private Vector turnedCards;
	private Timer turnDownsTimer;
	// terms of milisec
	private final int turnDownDelay = 2000;

	public cardController() {

		this.turnedCards = new Vector(2);
		this.turnDownsTimer = new Timer(this.turnDownDelay, this);
		this.turnDownsTimer.setRepeats(false);
		System.out.println("cardcont");
	}

//this compare if the two card is the same
	public boolean turnUp(Card card) {
		if (this.turnedCards.size() < 2)
			return doAddCard(card);
		return false;
	}
//this take the turned card and compare if they are the same clear this two places
	private boolean doAddCard(Card card) {
		if (this.turnedCards.size() == 2) {
			Card otherCard = (Card) this.turnedCards.get(0);
			if (otherCard.getNumber() == card.getNumber())
				this.turnedCards.clear();
			else
				this.turnDownsTimer.start();
		}
		return true;
	}

	//this get the card to turnDown the card
	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < this.turnedCards.size(); i++) {
			Card card = (Card) this.turnedCards.get(i);
			card.turnDown();
		}
		this.turnedCards.clear();
	}
	// add code snippet about controller to the card and game class
	
}
