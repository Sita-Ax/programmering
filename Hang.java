package hangman;

import java.util.ArrayList;
import java.util.Arrays;

public class Hang {

	
// private static void list(final String letter) {
	
//	String[] words = { "family", "best friends", "computer", "fruit", "teacher", "bag" };
//	ArrayList dynamicStringArray = new ArrayList(6);
//	dynamicStringArray.addAll(Arrays.asList(words));
//	ArrayList<String> letters = new ArrayList<String>();
//	letters.add("family");
//	letters.add("best friends");
//	letters.add("computer");
//	letters.add("fruit");
//	letters.add("teacher");
//	letters.add("bag");

//		welcomeWords();
//		hangman.Hang.newGame();
//		hangman.Hang.wordFoundContent();
//		hangman.Hang.play();
//		
//	}	
//public static void welcomeWords(){
//	
//    System.out.println(" ");
//    System.out.println("************************************");
//    System.out.println("*************WELCOME****************");
//    System.out.println("*********** HANGMAN GAME ***********");
//    System.out.println("************************************");
//    System.out.println("************************************");
//    System.out.println(" ");
// }
//private static boolean checkingChar(String letter) {
//	 if (letter.length() != 1 || Character.isDigit(letter.charAt(0))) {
//	    System.out.println("** ERROR: Just a letter no number! **");
//		System.out.println(" ");
//	    return false;
//	    }
//	    return true;
//	    }
//		
//	private String[] words = { "family", "best friends", "computer", "fruit", "teacher", "bag" };
//	static Random rand = new Random();
//	public static int maxCount = 7;
//	public static int guessed = 0;
//	public static String guess = "*";
//	public static String wordToFind;
//	static char [] wordFound;


//	public static String tryLetter = "You guessed on: ";
//	
//	public static String nextWord() {
//		
//		return words[rand.nextInt(words.length)];
//	}
//	
//	public static void newGame() {			//Metod till att starta nytt spel
//		guessed = 0;
//		letters.clear();
//		wordToFind = nextWord();
//		wordFound = new char[wordToFind.length()];		//till bokstäver
//		for (int i = 0; i < wordFound.length; i++) {
//			wordFound[i] = '*';
//		}
//		System.out.println(wordToFind);
//	}
//	
//	public static boolean wordFound() {		//denna betyder att ordet är hittat av användaren
//		return wordToFind.contentEquals(new String(wordFound));
//	}
//	
//	public static void wordsLetter(String letter) {	//metod som gör uppdatering efter en hittade bokstav
////		if (!letters.contains[letter]){
//			if(wordToFind.contains(letter)) {
//				int index = wordToFind.indexOf(letter);
//				
//				while (index >= 0) {
//					wordFound[index] = letter.charAt(0);
//					index = wordToFind.indexOf(letter, index + 1);
//				}
//			}else {
//				guessed++;	//om inte boktaven finns
//			}
//		letters.add(letter);	//bokstäver som hittar sin plats
//	}
////	}
//	static String wordFoundContent() {		//metoden som hittar bokstäver
//		
//		StringBuilder builder = new StringBuilder();
//		
//		for(int i = 0; i < wordFound.length; i++) {
//			builder.append(wordFound[i]);
//			
//			if(i < wordFound.length - 1) {
//				builder.append(" ");
//			}
//		} return builder.toString();
//	}
//	
//	public static void play() {
//		
//		try(Scanner input = new Scanner(System.in)){
//			while (guessed < maxCount) {
//				System.out.println("Enter a letter: ");
//				
//				String str = input.next();				//användarens val
//				
//				if(str.length() > 1) {			//vlilken hittad
//					str = str.substring(0, 1);
//				}
//				
//				wordsLetter(str);			//updtatera wad vi har hittat
//				
//				System.out.println("\n " + wordFoundContent());		//förra bokstav
//				
//				int guessWrong = (maxCount - guessed);
//				if(guessed >=maxCount) {
//					hangmanImage();
//				}
//				
//				if(wordFound()) {				//om ordet hittas
//					winnerWords();
//					break;
//				}else {
//					System.out.println("You have " + (maxCount - guessed)+ " guesses remaining: " );//hur många gissningar man har kvar
//				}
//			}
//
//			if(guessed == maxCount) {			//om man förlorar
//				
//			}
//	}
//	}
//	public static void winnerWords(){
//		 
//	   System.out.println(" ");
//	   System.out.println("************************************");
//	   System.out.println("******** CONGRATS! YOU WON! ********");
//	   System.out.println("************************************");
//	   System.out.println("************************************");
//	   System.out.println(" ");
//	      }
//	public static void hangmanImage() {
//		
//		if (guessed == 1) {
//			System.out.println("Wrong guess, try again");
//			System.out.println();
//			System.out.println();
//			System.out.println();
//			System.out.println();
//			System.out.println("___|___");
//			System.out.println();
//		}
//		if (guessed== 2) {
//			System.out.println("Wrong guess, try again");
//			System.out.println("   |");
//			System.out.println("   |");
//			System.out.println("   |");
//			System.out.println("   |");
//			System.out.println("   |");
//			System.out.println("   |");
//			System.out.println("   |");
//			System.out.println("___|___");
//		}
//		if (guessed == 3) {
//			System.out.println("Wrong guess, try again");
//			System.out.println("   ____________");
//			System.out.println("   |");
//			System.out.println("   |");
//			System.out.println("   |");
//			System.out.println("   |");
//			System.out.println("   |");
//			System.out.println("   |");
//			System.out.println("   | ");
//			System.out.println("___|___");
//		}
//		if (guessed == 4) {
//			System.out.println("Wrong guess, try again");
//			System.out.println("   ____________");
//			System.out.println("   |          _|_");
//			System.out.println("   |         /   \\");
//			System.out.println("   |        |     |");
//			System.out.println("   |         \\_ _/");
//			System.out.println("   |");
//			System.out.println("   |");
//			System.out.println("   |");
//			System.out.println("___|___");
//		}
//		if (guessed == 5) {
//			System.out.println("Wrong guess, try again");
//			System.out.println("   ____________");
//			System.out.println("   |          _|_");
//			System.out.println("   |         /   \\");
//			System.out.println("   |        |     |");
//			System.out.println("   |         \\_ _/");
//			System.out.println("   |           |");
//			System.out.println("   |           |");
//			System.out.println("   |");
//			System.out.println("___|___");
//		}
//		if (guessed == 6) {
//			System.out.println("Wrong guess, try again");
//			System.out.println("   ____________");
//			System.out.println("   |          _|_");
//			System.out.println("   |         /   \\");
//			System.out.println("   |        |     |");
//			System.out.println("   |         \\_ _/");
//			System.out.println("   |           |");
//			System.out.println("   |           |");
//			System.out.println("   |          / \\ ");
//			System.out.println("___|___      /   \\");
//		}
//		if (guessed == 7) {
//			System.out.println("GAME OVER!");
//			System.out.println("   ____________");
//			System.out.println("   |          _|_");
//			System.out.println("   |         /   \\");
//			System.out.println("   |        |     |");
//			System.out.println("   |         \\_ _/");
//			System.out.println("   |          _|_");
//			System.out.println("   |         / | \\");
//			System.out.println("   |          / \\ ");
//			System.out.println("___|___      /   \\");
//			System.out.println("GAME OVER! The word was " + wordToFind);
//		}
//	}	
//	
//	public Hang() {
//		
//	}
//
//	public String[] getList() {
//		return words;
//	}
//
//	public void setList(String []word) {
//
//		this.words = word;
//	}

}
