package hangman;

import java.util.Scanner;

public class Hangman1 {
	// it´s mean that you have 7 guesses.
	public static int maxCount = 7;
	public static int count = 0;
	public static int wrongGuess = 0;
	// this is the secret word to find
	public static String wordToFind; 
	public static String words ="**************";
	// the letters founded
	static char[] wordFound; 												
	// your guesses
	public static String tryLetter = "You have: "; 

	public static void main(String[] args) {

		wordToFind = Hang.getWord();
		welcomeWords();
		menu();
	}

	public static void menu() {

		System.out.println("Choose GL to play and found the letters");
		System.out.println("Choose GW to play and found the Word");
		System.out.println("Choose GS to see the gamestatus");
		Scanner input = new Scanner(System.in);
		String str = input.next();

		switch (str) {

		case "GL":
			setupGame(wordToFind);
			play();
			menu();
			break;

		case "GW":					//it's not ready
			while (wordToFind.contains("*")&&count < 7) {}
			setupGame(wordToFind);
			playWord(str);
			menu();
			break;

		case "GS":
			gameStatus();
			menu();
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
	// random words to find
	public static void nextWord() {

		wordToFind = Hang.getWord();
		setupGame(wordToFind);
		System.out.println("");
	}

	static void setupGame(String letters) {

		// the secret word convert to a char array so the word becomes letters
		wordFound = wordToFind.toCharArray(); 
		// instead of at string
		for (int i = 0; i < (wordFound.length); i++) {
			wordFound[i] = '*';
		}
	}

	public static void play() {

		Scanner input = new Scanner(System.in); 
		while (wrongGuess < maxCount) {
			System.out.print("The secretword: ");
			System.out.println(wordFound);
			System.out.println("Enter a letter: ");
			// users input
			String str = input.next();
			// this found the letter
			enter(str); 			
			// keep the first letter
			if (str.length() > 1) { 
				str = str.substring(0, 1);
			}
			// last letter
			System.out.println("\n " + wordFoundContent()); 
			// if the letter is wrong
			if (wrongGuess >= maxCount) { 
				hangmanImage();
			}
			// if the word is right
			if (wordFound()) { 
				winnerWords();
				break;
			}
		}
	}

	static void gameStatus() {
		// how many Wrongguesses you have left and how many letters you have
		System.out.println("You have " + (maxCount - wrongGuess) + " wrongguesses remaining and you have "+ count + " letters.");
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

	public static void enter(String tryletter) { 			// metod som gör uppdatering efter en hittade bokstav
		 //not numbers
		 checkingChar(tryletter);	
		// does the word have this letter
		if (wordToFind.contains(tryletter)) { 
			count++;
			gameStatus();
			// the index is the letter and saves on the right spot if it's right
			int index = wordToFind.indexOf(tryletter);												
			while (index >= 0) {
//						System.out.println("index enter() " + index); // i can see what position the index got 
//						System.out.println("index enter() " + tryletter);	//i can see what "letter" it is.
//						wordFound[index] = tryletter.charAt(index);		//try to save the letter but index just have one position and that is 0 so i can't get it in here
				// because the index is 0 i got to change index to 0 so it can right out the other index the letter 1
				wordFound[index] = tryletter.charAt(0); 
				// it will be next letter that is right
				index = wordToFind.indexOf(tryletter, index + 1);
			}
		} else {
			// if the letter don't exist use the hangman
			wrongGuess++; 
			hangmanImage();
		}
	}

	public static void playWord(String guess) {
		
		Scanner input = new Scanner (System.in);
//		while(wordToFind.contains("*")&&count<7) {
			System.out.print("The secretword: ");
			System.out.println(wordFound);
			System.out.println("Enter a Word: ");
			String user = input.next();
			//string used length so don't need to count
			for(int i = 0; i < wordToFind.length(); i++) {		
				System.out.println(words);
			//is guess the first letter är position 0 i min guess om guess är längre än 0
				if(user.charAt(i) == wordToFind.charAt(0)) {
					//when charAt is equals to guesses save
					user += wordToFind.charAt(i);					
					System.out.println("jjjjj");
					//were is the letter in my string
				}else if (wordToFind.charAt(i) != '*') {		
					user += wordToFind.charAt(i);
					System.out.println("kkkkkkk");
				}else {					
					//if i don't have this letter don't do anything
					user += "*";
					System.out.println("vvvvvv");
				}	
				if(wordToFind.equals(user)) {
				count++;
				hangmanImage();
			}
			if(guess.equals(wordFound)) {
				winnerWords();
			}//hideword------word klakl	wordToFind längde
		}
	}

	static String wordFoundContent() { // the content in the word + wordToFind it will print out the secret word
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < wordFound.length; i++) {
			builder.append(wordFound[i]);
			// do space between the letters
			if (i < wordFound.length - 1) { 
				builder.append(" ");
			}
		}
		return builder.toString();
	}
	
	public static boolean wordFound() { // when the word is right it got to decide if it's right word
		// For that, we just need to convert the wordFound to String and then compare this new String with wordFind
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
