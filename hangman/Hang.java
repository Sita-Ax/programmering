package hangman.hangman;

public class Hang {

	private static String[] words = { "family", "bestfriends", "computer", "fruit", "teacher", "bag" };//an array
	private static String word = words[(int) (Math.random() * words.length)];	//saved in random * 6

	
	public static String getWord() {									//this is the word
		return word;
	}
	public static void setWord(String word) {
		Hang.word = word;
	}
	
}
