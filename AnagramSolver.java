import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class AnagramSolver {
	TreeMap<String, LetterInventory> wordsAndCorrespondingLetterInventories;

    /*
     * pre: list != null
     * @param list Contains the words to form anagrams from.
     */
    public AnagramSolver(Set<String> dictionary) {
    	if (dictionary == null) {
    		throw new IllegalArgumentException("Violation of precondition: list must not be null");
    	}
    	wordsAndCorrespondingLetterInventories = new TreeMap<String, LetterInventory>();
    	// For each word in the given dictionary, creates a new corresponding LetterInventory and
    	// adds the word and its corresponding LetterInventory to a TreeMap
    	for (String word : dictionary) {
    		wordsAndCorrespondingLetterInventories.put(word, new LetterInventory(word));
    	}
    }

    
    /*
     * pre: maxWords >= 0, s != null, s contains at least one 
     * English letter.
     * Return a list of anagrams that can be formed from s with
     * no more than maxWords, unless maxWords is 0 in which case
     * there is no limit on the number of words in the anagram
     */
    public List<List<String>> getAnagrams(String s, int maxWords) {
    	if (s == null || maxWords < 0) {
    		throw new IllegalArgumentException("Violation of precondition: s must not be null and "
    				+ "maxWords must be greater than or equal to 0");
    	}
    	LetterInventory sLetterInventory = new LetterInventory(s);
    	// Creates a new TreeMap containing only the words that can be created from the given 
    	// String
    	TreeMap<String, LetterInventory> updatedDictionary = updateDictionary(sLetterInventory, 
    			wordsAndCorrespondingLetterInventories);

    	// Adds each word from the newly created TreeMap, which contains only the words that can 
    	// be created from the given String, to an ArrayList of Strings
    	ArrayList<String> validChoicesForCurrentString = new ArrayList<String>();
    	for (String word : updatedDictionary.keySet()){
    		validChoicesForCurrentString.add(word);    
    	}
    	if (maxWords == 0) {
    		maxWords = s.length();
    	}
    	
		ArrayList<String> currentAnagram = new ArrayList<String>();
    	ArrayList<List<String>> allAnagrams = new ArrayList<List<String>>();
    	
    	findAnagrams(sLetterInventory, maxWords, 0, updatedDictionary, 
    			validChoicesForCurrentString, currentAnagram, allAnagrams);
    	
    	// Sorts the list containing all possible anagrams for the given String
    	AnagramComparator anagramComp = new AnagramComparator();
    	Collections.sort(allAnagrams, anagramComp);

    	return allAnagrams;
    }
    
    /**
     * This is a helper method for getAnagrams that adds lists of anangrams, which can be formed  
     * from the given String, containing less than or equal to the given max number of words to a 
     * list containing all anagrams
     * @param s LetterInventory for the String for which anagrams are being formed
     * @param maxWords the maximum number of words that can be in an anagram
     * @param startingIndex the index at which searching for potential anagrams should begin
     * @param currentDictionary TreeMap containing all the possible words (that can be formed from 
     * the given String) and their corresponding LetterInventories 
     * @param validChoicesForCurrentString list containing all of the possible words that can 
     * be formed from the given String
     * @param currentAnagram list containing the current anagram being created
     * @param allAnagrams list containing all of the anagrams for the given String
     */
    private void findAnagrams(LetterInventory s, int maxWords, int startingIndex, 
    		TreeMap<String, LetterInventory> currentDictionary, 
    		ArrayList<String> validChoicesForCurrentString, ArrayList<String> currentAnagram, 
    		ArrayList<List<String>> allAnagrams) {
    	// Base Case: If the given LetterInventory is empty, adds the current anagram to the list
    	// containing all anagrams
    	if (s.isEmpty()) {
    		ArrayList<String> anagramCopy = new ArrayList<String>(currentAnagram);
        	allAnagrams.add(anagramCopy);
    	} else if (currentAnagram.size() < maxWords) {
    		// Otherwise, check whether each word starting from the startingIndex can be formed
    		// from the given LetterInventory. If the current word can be formed from the given 
    		// LetterInventory, the current word is added to the list containing the current 
    		// anagram and the method is recursively called
    		for (int i = startingIndex; i < validChoicesForCurrentString.size(); i++) {
        		String currentWord = validChoicesForCurrentString.get(i);
				LetterInventory temp = s.subtract(currentDictionary.get(currentWord));
    			if (temp != null) {
            		currentAnagram.add(currentWord);
    				findAnagrams(temp, maxWords, i, currentDictionary, 
    						validChoicesForCurrentString, currentAnagram, allAnagrams);
    				// Backtracking: After trying to create an anagram with the current word
    				// and every other word in the list, backtracks by removing this word so that
    				// anagrams with another word can be tried to be created
    				currentAnagram.remove(currentAnagram.size() - 1);
    			} 
    		}
    	}
    }
    
    /**
     * This is a helper method for getAnagrams that filters out the current dictionary of words
     * being used for only those words that can be formed from the current word and adding only 
     * these words to a new TreeMap
     * @param currentWordLetterInventory LetterInventory for the current String for which anagrams
     * are being formed
     * @param currentDictionary TreeMap that contains all of the words in the dictionary being used
     * and their corresponding LetterInventories
     * @return
     */
    private TreeMap<String, LetterInventory> updateDictionary(
    		LetterInventory currentWordLetterInventory, 
    		TreeMap<String, LetterInventory> currentDictionary) {
    	
    	TreeMap<String, LetterInventory> updatedDictionary = new TreeMap<String, LetterInventory>();
    	
    	// For each word in the TreeMap containing all words, if the result of subtracting
    	// the frequencies for each letter of the current word from the given String is not null 
    	// (which means that the current word can be formed from the given String), the current 
    	// word and its corresponding LetterInventory is added to a TreeMap containing words 
    	// that can be formed from the given String
    	for (String word : currentDictionary.keySet()) {
    		if (currentWordLetterInventory.subtract(currentDictionary.get(word)) != null) {
    			updatedDictionary.put(word, currentDictionary.get(word));
    		}
    	}
    	return updatedDictionary;
    }

    
    /**
     * 
     * This class implements the Comparator interface to allow for lists which contain lists of 
     * anagrams to be sorted by the number of anagrams they contain and by the words in each 
     * anagram if there are lists of anagrams of the same size 
     *
     */
    private static class AnagramComparator implements Comparator<List<String>> {
    	/**
    	 * Compares two lists of anagrams based on the number of words in each list and 
    	 * by the words in each list of anagrams if both lists have the same number of words
    	 */
    	public int compare(List<String> a1, List<String> a2) {
    		int result = a1.size() - a2.size();
    		
    		// If both lists of anagrams contain the same number of words, the words at the same 
    		// positions in each list are lexicographically compared to each other
    		if (result == 0) {
    			int currentIndex = 0;
    			while (currentIndex < a1.size() && result == 0) {
    				result = a1.get(currentIndex).compareTo(a2.get(currentIndex));
    				currentIndex++;
    			}	
    		} 
    		return result;
    	}
    }

}
