package hangman;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hangman1 {

		private static String[] words = { "family", "best friends", "computer", "fruit", "teacher", "bag" };
		public static Random rand = new Random();		//it´used to random a word
		public static int maxCount = 7;		//it´s mean that you have 7 guesses.
		public static int wrongGuess = 0;		
		public static String guess = "*";
		public static String wordToFind;		//this is the secret word to find
		static char [] wordFound;			//the letters founded
		public static String tryLetter = "You guessed on: ";		///your guesses
		public static ArrayList<String> letters = new ArrayList<String>();
		
		public static void main (String[] args) {
			
			welcomeWords();		
			menu();
		}

		public static void menu() {
			
			System.out.println("Choose GL to play and found the letters");
			System.out.println("Choose GW to play and found the Word");
			System.out.println("Choose GS to see the gamestatus");
			
			Scanner input = new Scanner(System.in);
			String str = input.next();
		
		switch(str) {
		
			case "GL":
		
				play();
				newGame();
				setupGame(letters);
				enter(guess);
				checkingChar(str);
			break;
			
			case "GW":
				play();
				wordFoundContent();
				nextWord();
				wordFound();
			break;
			
			case "GS":
				gameStatus();
			break;
			default: System.out.println("Wrong choice! ");
		}	
		}	
		
	public static void welcomeWords(){
		
	    System.out.println(" ");
	    System.out.println("************************************");
	    System.out.println("*************WELCOME****************");
	    System.out.println("*********** HANGMAN GAME ***********");
	    System.out.println("************************************");
	    System.out.println("************************************");
	    System.out.println(" ");
	 }
	
		public static String nextWord() {		//random words to find
			
			return words[rand.nextInt(words.length)];
		}	
		
		public static void newGame() {			//start a new game
			wrongGuess = 0;
			letters.clear();
			wordToFind = nextWord();
			wordFound = new char[wordToFind.length()];		//in letters
			for (int i = 0; i < wordFound.length; i++) {
				wordFound[i] = '*';	
			}
			System.out.println(wordToFind);
		}
		
		static void setupGame(ArrayList<String> letters) {
			
			char[] wordFound = words[rand.nextInt(words.length)].toCharArray();
	//		Object [] letters1 =  letters.toArray();
			
			for(int i = 0; i < ((CharSequence) letters).length(); i++) {
				wordFound[i] = '*';
				
				}
			System.out.println(letters);
		}

			public static void play() {
			
			try(Scanner input = new Scanner(System.in)){		//play as long as the wrong guesses is lower than 7
				while (wrongGuess < maxCount) {
					System.out.println("The secretword: " + wordToFind);
					System.out.println("Enter a letter: ");
					String str = input.next();				//users input
					
					if(str.length() > 1) {			//keep the first letter
						str = str.substring(0, 1);
					}
	
					enter(str);			//this is found
					
					System.out.println("\n " + wordFoundContent());		//förra bokstav
					
					int guessWrong = (maxCount - wrongGuess);
					if(wrongGuess >=maxCount) {
						hangmanImage();
					}
					
					if(wordFound()) {				//om ordet hittas
						winnerWords();
						break;
					}
				}

				if(wrongGuess == maxCount) {			//om man förlorar
					
				}
		}
		}
			static void gameStatus(){
				
				System.out.println("You have " + (maxCount - wrongGuess)+ " guesses remaining and: " + " letters left" );//hur många gissningar man har kvar
				System.out.println(tryLetter);
				menu();
			}
			
			private static boolean checkingChar(String letter) {
		 if (letter.length() != 1 || Character.isDigit(letter.charAt(0))) {
		    System.out.println("** ERROR: Just a letter no number! **");
			System.out.println(" ");
		    return false;
		    }
		    return true;
		    }
			
		public static void enter(String guess) {	//metod som gör uppdatering efter en hittade bokstav
			if (!letters.contains(guess)){			// has the letter been used
				if(wordToFind.contains(guess)) {		//does the word have this letter
					int index = wordToFind.indexOf(guess); 	//if the letter is in the word change to*
					
					while (index >= 0) {
						wordFound[index] = guess.charAt(0);
						index = wordToFind.indexOf(guess, index + 1);
					}
				}else {
					hangmanImage();
					wrongGuess++;	//if the letter don't exist use the hangman
				}
			letters.add(guess);	//keep the letter in the place
		}
		}
		static String wordFoundContent() {		//the content in the word
			
			StringBuilder builder = new StringBuilder();
			
			for(int i = 0; i < wordFound.length; i++) {
				builder.append(wordFound[i]);
		
				if(i < wordFound.length - 1) {
					builder.append(" ");
				}
		}
			return builder.toString();
		}
		public static boolean wordFound() {		//the 
//Under Hangman-spelet måste vi hantera det ord som hittats av användaren i vår HangmanGame-klass. Först måste vi ha en metod för att avgöra om ordet att hitta har hittats. För det behöver vi bara omvandla wordFound-matrisen till String och sedan jämföra denna nya String med wordFind:
			return wordToFind.contentEquals(new String(wordFound));
		}
		
		public static void winnerWords(){
			 
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
			if (wrongGuess== 2) {
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

		public String[] getWord() {
			return words;
		}

		public void setWord(String []word) {

			this.words = word;
		}

}
