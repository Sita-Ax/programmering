package com.example.hangman;

import java.util.Scanner;

public class Hangman2 {
	// This mean that you have 7 guesses.
	public static final int MAX_COUNT = 7;
	private static int count = 0;
	private static int wrongGuess = 0;
	// This is the secret word to find
	private static String wordToFind;
	private static String words = "**************";
	// The letters founded
	private static char[] wordFound;
	// Your guesses
	private static String tryLetter = "You have: ";

	public static void main(String[] args) {

		wordToFind = Hang.getWord();
		welcomeWords();
		menu();
	}

	public static void menu() {

		System.out.println("Choose GL to play and found the letters");
		System.out.println("Choose GW to play and found the Word");
		System.out.println("Choose GS to see the gamestatus");
		System.out.println("Choose EXIT to exit the game.");
		Scanner input = new Scanner(System.in);
		String str = input.next();

		switch (str) {

			case "GL":
				// Reset guesses
				count = 0;
				// Reset wrong guesses
				wrongGuess = 0;
				// Get a new word
				wordToFind = Hang.getWord();
				// Reset games status
				setupGame(wordToFind);
				play();
				menu();
				break;

			case "GW":
				while (wordToFind.contains("*") && count < 7) {
				}
				count = 0;
				wrongGuess = 0;
				wordToFind = Hang.getWord();
				setupGame(wordToFind);
				playWord(str);
				menu();
				break;

			case "GS":
				gameStatus();
				menu();
				break;
			case "EXIT":
				System.out.println("Exiting the game. Goodbye!");
				System.exit(0);
				break;
			default:
				System.out.println("Wrong choice! ");
				menu();
		}
	}

	public static void welcomeWords() {

		System.out.println(" ");
		System.out.println("************************************");
		System.out.println("*************WELCOME****************");
		System.out.println("*********** HANGMAN GAME ***********");
		System.out.println("************************************");
		System.out.println("************************************");
		System.out.println(" ");
	}

	// Random words to find
	public static void nextWord() {
		wordToFind = Hang.getWord();
		setupGame(wordToFind);
		System.out.println("");
	}

	static void setupGame(String letters) {
		// The secret word convert to a char array so the word becomes letters
		wordFound = wordToFind.toCharArray();
		// Instead of a string
		for (int i = 0; i < (wordFound.length); i++) {
			wordFound[i] = '*';
		}
	}

	public static void play() {
		Scanner input = new Scanner(System.in);
		while (wrongGuess < MAX_COUNT) {
			System.out.print("The secretword: ");
			System.out.println(wordFound);
			System.out.println("Enter a letter: ");
			// Users input
			String str = input.next();
			// This found the letter
			enter(str);
			// Keep the first letter
			if (str.length() > 1) {
				str = str.substring(0, 1);
			}
			// Last letter
			System.out.println("\n " + wordFoundContent());
			// If the letter is wrong
			if (wrongGuess >= MAX_COUNT) {
				hangmanImage();
			}
			// If the word is right
			if (wordFound()) {
				winnerWords();
				break;
			}
		}
	}

	static void gameStatus() {
		// How many Wrongguesses you have left and how many letters you have
		System.out.println(
				"You have " + (MAX_COUNT - wrongGuess) + " wrongguesses remaining and you have " + count + " letters.");
	}

	private static boolean checkingChar(String letters) {
		if (letters.length() != 1 || Character.isDigit(letters.charAt(0))) {
			System.out.println("** ERROR: Just a letter no number! **");
			System.out.println(" ");
			gameStatus();
			return false;
		}
		return true;
	}

	// Method that update after found letter
	public static void enter(String tryletter) {
		// Check so it's not numbers
		if (!checkingChar(tryletter))
			return;
		// Does the word have this letter
		if (wordToFind.contains(tryletter)) {
			count++;
			gameStatus();
			// The index is the letter and saves on the right spot if it's right
			int index = wordToFind.indexOf(tryletter);
			while (index >= 0) {
				wordFound[index] = tryletter.charAt(0);
				// it will be next letter that is right
				index = wordToFind.indexOf(tryletter, index + 1);
			}
		} else {
			// If the letter don't exist use the hangman
			wrongGuess++;
			hangmanImage();
		}
	}

	// Method to guess the hole word in one time
	public static void playWord(String guess) {
		Scanner input = new Scanner(System.in);
		System.out.print("The secretword: ");
		System.out.println(wordFound);
		System.out.println("Enter a Word: ");
		String user = input.next();
		if (user.equals(wordToFind)) {
			System.out.println("WIN");
			winnerWords();
		} else {
			System.out.println("LOSE");
			wrongGuess++;
			hangmanImage();
		}
	}

	// The content in the word + wordToFind it will print out the secret word
	static String wordFoundContent() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < wordFound.length; i++) {
			builder.append(wordFound[i]);
			// To space between the letters
			if (i < wordFound.length - 1) {
				builder.append(" ");
			}
		}
		return builder.toString();
	}

	// When the word is right it got to decide if it's right word
	public static boolean wordFound() {
		// For that, we just need to convert the wordFound to String and then compare
		// this new String with wordFind
		return wordToFind.contentEquals(new String(wordFound));
	}

	public static void winnerWords() {

		System.out.println(" ");
		System.out.println("************************************");
		System.out.println("******** CONGRATS! YOU WON! ********");
		System.out.println("************************************");
		System.out.println("************************************");
		System.out.println(" ");
	}

	public static void hangmanImage() {

		if (wrongGuess == 1) {
			System.out.println("Wrong guess, try again");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("___|___");
			System.out.println();
		}
		if (wrongGuess == 2) {
			System.out.println("Wrong guess, try again");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (wrongGuess == 3) {
			System.out.println("Wrong guess, try again");
			System.out.println("   ____________");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   | ");
			System.out.println("___|___");
		}
		if (wrongGuess == 4) {
			System.out.println("Wrong guess, try again");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (wrongGuess == 5) {
			System.out.println("Wrong guess, try again");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |           |");
			System.out.println("   |           |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (wrongGuess == 6) {
			System.out.println("Wrong guess, try again");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |           |");
			System.out.println("   |           |");
			System.out.println("   |          / \\ ");
			System.out.println("___|___      /   \\");
		}
		if (wrongGuess == 7) {
			System.out.println("GAME OVER!");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |          _|_");
			System.out.println("   |         / | \\");
			System.out.println("   |          / \\ ");
			System.out.println("___|___      /   \\");
			System.out.println("GAME OVER! The word was " + wordToFind);
		}
	}

	// Getters and Setters
	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Hangman2.count = count;
	}

	public static int getWrongGuess() {
		return wrongGuess;
	}

	public static void setWrongGuess(int wrongGuess) {
		Hangman2.wrongGuess = wrongGuess;
	}

	public static String getWordToFind() {
		return wordToFind;
	}

	public static void setWordToFind(String wordToFind) {
		Hangman2.wordToFind = wordToFind;
	}

	public static String getWords() {
		return words;
	}

	public static void setWords(String words) {
		Hangman2.words = words;
	}

	public static char[] getWordFound() {
		return wordFound;
	}

	public static void setWordFound(char[] wordFound) {
		Hangman2.wordFound = wordFound;
	}

	public static String getTryLetter() {
		return tryLetter;
	}

	public static void setTryLetter(String tryLetter) {
		Hangman2.tryLetter = tryLetter;
	}

}