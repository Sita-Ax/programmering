package hangman;

import java.util.Scanner;

public class Hangman1 {

		public static int maxCount = 7;		//it´s mean that you have 7 guesses.
		public static int wrongGuess = 0;		
		public static String wordToFind;		//this is the secret word to find
		static char [] wordFound;			//the letters founded
		public static String tryLetter = "You guessed on: ";		///your guesses
		
		public static void main (String[] args) {
			
//			Scanner input = new Scanner(System.in);
			wordToFind = Hang.getWord();

//			System.out.println(wordToFind);
						
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
				setupGame(wordToFind);
				play();

			break;
			
			case "GW":
				setupGame(wordToFind);
//				play();
//				nextWord();
//				wordFound();
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
	
		public static void nextWord() {		//random words to find

			wordToFind = Hang.getWord();
			setupGame(wordToFind);
			System.out.println("");
		}	
		
		static void setupGame(String letters) {
			
		wordFound =  wordToFind.toCharArray();		//the secret word convert to a char array so the word becomes letters instead of at string	
		for(int i = 0; i < (wordFound.length); i++) {
			wordFound[i] = '*';
			}
	}	

			public static void play() {
			
			try(Scanner input = new Scanner(System.in)){		//play as long as the wrong guesses is lower than 7
				while (wrongGuess < maxCount) {
					System.out.print("The secretword: " );
					System.out.println(wordFound);
					System.out.println("Enter a letter: ");
					String str = input.next();				//users input
						enter(str);								//this found the letter 
					if(str.length() > 1) {					//keep the first letter
						str = str.substring(0, 1);
					}					
					System.out.println("\n " + wordFoundContent());		//last letter
					if(wrongGuess >= maxCount) {				//if the letter is wrong
						hangmanImage();
					}
					if(wordFound()) {				//if the word is right
						winnerWords();
						break;
					}
				}
			}
		}
			static void gameStatus(){
				
				System.out.println("You have " + (maxCount - wrongGuess)+ " guesses remaining and: " + " letters left" );//how many guesses you have left 
				System.out.println(tryLetter + " letters ");//how many letters you have found
				menu();
			}
//			
//			private static boolean checkingChar(String letters) {
//		 if (letters.length() != 1 || Character.isDigit(letters.charAt(0))) {
//		    System.out.println("** ERROR: Just a letter no number! **");
//			System.out.println(" ");
//		    return false;
//		    }
//		    return true;
//		    }
//			
		public static void enter(String tryletter) {	//metod som gör uppdatering efter en hittade bokstav
//			if (!letters.contains(tryletter)){			// has the letter been used
				if(wordToFind.contains(tryletter)) {		//does the word have this letter
					int index = wordToFind.indexOf(tryletter); 	//the index is putting the letter on the right spot if it's right
					while (index >= 0) {
						wordFound[index] = tryletter.charAt(index);
						index = wordToFind.indexOf(tryletter, index + 1);
					}
				}else {
					wrongGuess++;	//if the letter don't exist use the hangman
					hangmanImage();
				}
//			letters.add(tryletter);	//keep the letter in the place
//		}
		}
		static String wordFoundContent() {		//the content in the word
			
			StringBuilder builder = new StringBuilder();

			System.out.println("this is the content of the word: " + wordToFind);
			for(int i = 0; i < wordFound.length; i++) {
				builder.append(wordFound[i]);
		
				if(i < wordFound.length - 1) {			//do space between the letters
					builder.append(" ");
				}
		}
			return builder.toString();
		}
		public static boolean wordFound() {		//when the word is right
// Först måste vi ha en metod för att avgöra om ordet att hitta har hittats. För det behöver vi bara omvandla wordFound-matrisen till String och sedan jämföra denna nya String med wordFind:
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

}
