package com.example.hangman;

import java.util.Random;

public class Hang {

	// An array of hidden words
	private static String[] words = { "family", "bestfriends", "computer", "fruit", "teacher", "bag" };
	private static Random random = new Random();

	private Hang() {
		// Private constructor to prevent instantiation
	}

	// This is the word
	public static String getWord() {
		return words[random.nextInt(words.length)];
	}
}
