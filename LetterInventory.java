/* CS 314 STUDENTS: FILL IN THIS HEADER AND THEN COPY AND PASTE IT TO YOUR
 * LetterInventory.java AND AnagramSolver.java CLASSES.
 *
 * Student information for assignment:
 *
 *  On my honor, Ami Dave, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  UTEID: ad56333
 *  email address: amidave@utexas.edu
 *  TA name: Devon
 *  Number of slip days I am using: 0
 */
public class LetterInventory {
	final int NUM_LETTERS_IN_ALPHABET;
	int[] letterFrequencies;
	int numLetters;
	
	/**
	 * Creates a LetterInventory for the given input string
	 * @param inputString the String for which a LetterInventory is created
	 */
	public LetterInventory(String inputString) {
		if (inputString == null) {
			throw new IllegalArgumentException("Violation of precondition: word must not be null.");
		}
		NUM_LETTERS_IN_ALPHABET = 26;
		letterFrequencies = new int[NUM_LETTERS_IN_ALPHABET];

		// Initially sets all of the letter frequencies to 0
		for (int k = 0; k < NUM_LETTERS_IN_ALPHABET; k++) {
			letterFrequencies[k] = 0;
		}

		char[] letters = inputString.toCharArray();

		// Converts case of each letter in the given input string to lowercase and for each letter 
		// that appears in the given string, increments the frequency corresponding to that letter
		// in the list containing the frequencies of each letter in the English alphabet
		for (int i = 0; i < letters.length; i++) {
			letters[i] = Character.toLowerCase(letters[i]);
			if (letters[i] >= 'a' && letters[i] <= 'z') {
				int currentLetterIndex = (NUM_LETTERS_IN_ALPHABET - 1 - ('z' - letters[i]));
				letterFrequencies[currentLetterIndex] = letterFrequencies[currentLetterIndex] + 1;
				numLetters++;
			}
		}
	}
	
	
	/**
	 * Creates a LetterInventory for the given list of letter frequencies
	 * @param letterFrequenciesList list containing the frequencies of each letter
	 */
	private LetterInventory(int[] letterFrequenciesList) {
		NUM_LETTERS_IN_ALPHABET = 26;
		letterFrequencies = new int[NUM_LETTERS_IN_ALPHABET];

		// Creates a deep copy of the list by copying each element from the given list
		// into the letterFrequencies list
		for (int k = 0; k < NUM_LETTERS_IN_ALPHABET; k++) {
			letterFrequencies[k] = letterFrequenciesList[k];
			numLetters += letterFrequencies[k];
		}
	}
	
	
	/**
	 * Gets the frequency of the given character from this LetterInventory given that the character
	 * is an English letter
	 * @param character the character for which the frequency needs to be returned
	 * @return an a number corresponding to the frequency of the given character in this
	 * LetterInventory
	 */
	public int get(char character) {
		int characterFrequency = 0;
		if (!(Character.toLowerCase(character) >= 'a' && Character.toLowerCase(character) <= 'z')) {
			throw new IllegalArgumentException("Violation of precondition: character must be "
					+ "an English letter");
		}
		if (size() > 0) {
			// Gets the frequency corresponding to the given letter from the letterFrequencies list
			int indexOfCharacter = (NUM_LETTERS_IN_ALPHABET - 1 
					- ('z' - Character.toLowerCase(character)));
			characterFrequency = letterFrequencies[indexOfCharacter];
		}
		return characterFrequency;
	}
	

	/**
	 * Gets the number of letters in this LetterInventory
	 * @return the number of letters in this LetterInventory
	 */
	public int size() {
		return numLetters;
	}
	
	
	/**
	 * Checks whether this LetterInventory is empty
	 * @return true if the size of this LetterInventory is equal to zero and false otherwise
	 */
	public boolean isEmpty() {
		if (size() == 0) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * Returns a String that contains all of the letters in this LetterInventory sorted in 
	 * alphabetical order 
	 */
	public String toString() {
		StringBuilder finalString = new StringBuilder();
		// Adds each letter the number of times that corresponds to its frequency in the 
		// letterFrequencies list to a Stringbuilder and returns the String created using the
		// StringBuilder
		for (int i = 0; i < letterFrequencies.length; i++) {
			int currentFrequency = letterFrequencies[i];
			for (int j = 0; j < currentFrequency; j++) {
				finalString.append((char) (i + 'a'));			
			}
		}
		return finalString.toString();
	}
	
	
	/**
	 * Returns a new LetterInventory that is created by adding the frequencies of letters for the 
	 * other LetterInventory to the frequencies of letters for this LetterInventory
	 * @param other another LetterInventory 
	 * @return a LetterInventory containing the sum of the frequencies of each letter for the given
	 * LetterInventory and this LetterInventory
	 */
	public LetterInventory add(LetterInventory other) {
		if (other == null) {
			throw new IllegalArgumentException("Violation of precondition: other must not be null");
		}
		
		int[] letterFrequenciesFromAdd = new int[letterFrequencies.length];
		
		// Adds the frequency of each letter for the other LetterInventory to the frequency
		// of each letter for this LetterInventory and assigns the sum of the frequencies for each
		// letter to a new list
		for (int i = 0; i < letterFrequencies.length; i++) {
			letterFrequenciesFromAdd[i] = letterFrequencies[i] + other.letterFrequencies[i];
			numLetters += letterFrequencies[i] + other.letterFrequencies[i];

		} 
		// Uses the new list to create a new LetterInventory which contains the sums of the letter 
		// frequencies for this LetterInventory and the other LetterInventory 
		LetterInventory newLetterInventory = new LetterInventory(letterFrequenciesFromAdd);

		return newLetterInventory;
	}
	
	
	/**
	 * Returns a new LetterInventory that is created by subtracting the frequencies of letters 
	 * for the other LetterInventory from the frequencies of letters for this LetterInventory
	 * @param other another LetterInventory
	 * @return a new LetterInventory containing the difference of the frequencies between this 
	 * LetterInventory and the given LetterInventory
	 */
	public LetterInventory subtract(LetterInventory other) {
		boolean containsCountsLessThanZero = false;
		if (other == null) {
			throw new IllegalArgumentException("Violation of precondition: other must not be null");
		}
		
		int[] letterFrequenciesFromSubtract = new int[letterFrequencies.length];
		
		// Subtracts the frequency of each letter for the other LetterInventory from the frequency
		// of each letter for this LetterInventory and assigns the difference of the frequencies 
		// for each letter to a new list
		for (int i = 0; i < letterFrequencies.length; i++) {
			letterFrequenciesFromSubtract[i] = letterFrequencies[i] - other.letterFrequencies[i];
			// Checks if any of the differences in letter frequencies are less than zero
			if (letterFrequenciesFromSubtract[i] < 0) {
				containsCountsLessThanZero = true;
			}
		} 
		// Uses the new list to create a new LetterInventory which contains the difference of the  
		// letter frequencies between this LetterInventory and the other LetterInventory 
		LetterInventory newLetterInventory = new LetterInventory(letterFrequenciesFromSubtract);
		
		// Returns null if any of the differences in letter frequencies are less than zero
		if (containsCountsLessThanZero) {
			return null;
		}
		return newLetterInventory;
	}	
	
	
	/**
	 * Checks whether this LetterInventory is equal to other. This LetterInventory is equal to
	 * other if the frequencies for each letter are equal. 
	 * @return true if other is equal to this  LetterInventory and false otherwise
	 */
	public boolean equals(Object other) {
		// Checks whether other is an instance of LetterInventory and whether the size of other
		// is equal to the size of this LetterInventory. If both of these are true, checks whether
		// there is any letter frequency in this LetterInventory that is not equal to its  
		// corresponding letter frequency in other
		if (other instanceof LetterInventory && ((LetterInventory) other).size() == size()) {
			for (int i = 0; i < letterFrequencies.length; i++) {
				if (letterFrequencies[i] != ((LetterInventory) other).letterFrequencies[i]) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
}
