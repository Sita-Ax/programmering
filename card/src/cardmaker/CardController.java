package cardmaker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class CardController implements ActionListener {

	private ArrayList<Card> turnedCards;
	private Timer turnDownsTimer;
	// terms of milliseconds to turn the card agian
	private static final int TURN_DOWN_DELAY = 2000;
	private int score;
	private Game game;

	public CardController(Game game) {
		this.turnedCards = new ArrayList<>();
		this.turnDownsTimer = new Timer(TURN_DOWN_DELAY, this);
		this.turnDownsTimer.setRepeats(false);
		this.score = 0;
		this.game = game;
	}

	// Compare if the two card are the same
	public boolean turnUp(Card card) {
		if (this.turnedCards.size() < 2) {
			this.turnedCards.add(card);
			// Turn the card face up
			card.setFaceUp(true);
			// If two cards are turned up
			if (this.turnedCards.size() == 2) {
				// Check for a match
				if (checkMatch()) {
					this.score++;
					// Show messsage for a matched pair and update the score
					JOptionPane.showMessageDialog(card, "Matched! Score: " + this.score);
					this.game.updateScore(this.score);
					// Clear the turned card if the match is found
					this.turnedCards.clear();
				} else {
					// Timer start for the cards turn back card if no match found
					this.turnDownsTimer.start();
				}
				// Increment guesses after two cards are turned Up
				this.game.incrementGuesses();
			}
			return true;
		}
		return false;
	}

	// Check if the turned cards are the same
	private boolean checkMatch() {
		if (this.turnedCards.size() == 2) {
			Card firstCard = this.turnedCards.get(0);
			Card secondCard = this.turnedCards.get(1);
			return firstCard.getNumber() == secondCard.getNumber();
		}
		return false;
	}

	// Turn down the cards when the timer is finished
	@Override
	public void actionPerformed(ActionEvent e) {
		// Turn down the card
		for (Card card : this.turnedCards) {
			card.turnDown();
			// Set the card face down
			card.setFaceUp(false);
		}
		// Clear the turned cards
		this.turnedCards.clear();
	}

	public int getScore() {
		return this.score;
	}

}
