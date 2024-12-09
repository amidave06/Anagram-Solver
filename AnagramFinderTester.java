import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


public class AnagramFinderTester {


    private static final String testCaseFileName = "testCaseAnagrams.txt";
    private static final String dictionaryFileName = "d3.txt";

    /**
     * main method that executes tests.
     * @param args Not used.
     */
    public static void main(String[] args) {

//    	cs314StudentTestsForLetterInventory();
//    	letterInventoryTests();

        // tests on the anagram solver itself
//        boolean displayAnagrams = getChoiceToDisplayAnagrams();
//        AnagramSolver solver 
//                = new AnagramSolver(AnagramMain.readWords(dictionaryFileName));
//        runAnagramTests(solver, displayAnagrams);
    }

    private static void cs314StudentTestsForLetterInventory() {
    	// test 1: LetterInventory get() method
        LetterInventory letterInventory1 = new LetterInventory("Ami Paras Dave 2006!!!");
        int expected = 4;
        if (letterInventory1.get('a') == expected) {
        	System.out.println("Passed test 1, LetterInventory get() method");
        } else {
        	System.out.println("Failed test 1, LetterInventory get() method");
        }
        
    	// test 2: LetterInventory get() method
        letterInventory1 = new LetterInventory("supercalifragilisticexpialidociousIIIII");
        expected = 12;
        if (letterInventory1.get('i') == expected) {
        	System.out.println("Passed test 2, LetterInventory get() method");
        } else {
        	System.out.println("Failed test 2, LetterInventory get() method");
        }

    	// test 3: LetterInventory size() method
        letterInventory1 = new LetterInventory(
        		"alabamaalaskaarizonaarksansascaliforniacoloradoconnecticut");
        expected = 58;
        if (letterInventory1.size() == expected) {
        	System.out.println("Passed test 3, LetterInventory size() method");
        } else {
        	System.out.println("Failed test 3, LetterInventory size() method");
        }
        
    	// test 4: LetterInventory size() method
        letterInventory1 = new LetterInventory("!!!!@@@@####$$$%%%^^^&&&***((()))____+++Z");
        expected = 1;
        if (letterInventory1.size() == expected) {
        	System.out.println("Passed test 4, LetterInventory size() method");
        } else {
        	System.out.println("Failed test 4, LetterInventory size() method");
        }
        
    	// test 5: LetterInventory isEmpty() method
        letterInventory1 = new LetterInventory("!!!!@@@@####$$$%%%^^^&&&***((()))____+++Z");
        LetterInventory letterInventory2 = new LetterInventory("z");
        if (letterInventory1.subtract(letterInventory2).isEmpty()) {
        	System.out.println("Passed test 5, LetterInventory isEmpty() method");
        } else {
        	System.out.println("Failed test 5, LetterInventory isEmpty() method");
        }
        
    	// test 6: LetterInventory isEmpty() method
        letterInventory1 = new LetterInventory(")))))))))))))))))))))))))))))))");
        letterInventory2 = new LetterInventory("-----------------------------");
        if (letterInventory1.subtract(letterInventory2).isEmpty()) {
        	System.out.println("Passed test 6, LetterInventory isEmpty() method");
        } else {
        	System.out.println("Failed test 6, LetterInventory isEmpty() method");
        }
        
    	// test 7: LetterInventory toString() method
        letterInventory1 = new LetterInventory("hihihihihihihihi");
        String expectedString = "hhhhhhhhiiiiiiii";
        if (letterInventory1.toString().equals(expectedString)) {
        	System.out.println("Passed test 7, LetterInventory toString() method");
        } else {
        	System.out.println("Failed test 7, LetterInventory toString() method");
        }
        
    	// test 8: LetterInventory toString() method
        letterInventory1 = new LetterInventory("zyxwvutsrqponmlkjihgfedcba");
        expectedString = "abcdefghijklmnopqrstuvwxyz";
        if (letterInventory1.toString().equals(expectedString)) {
        	System.out.println("Passed test 8, LetterInventory toString() method");
        } else {
        	System.out.println("Failed test 8, LetterInventory toString() method");
        }
        
    	// test 9: LetterInventory add() method
        letterInventory1 = new LetterInventory("elephantrhinomouselion");
        letterInventory2 = new LetterInventory("elephantrhinomouselion");
        expectedString = "aaeeeeeehhhhiiiillllmmnnnnnnoooooopprrssttuu";
        if (letterInventory1.add(letterInventory2).toString().equals(expectedString)) {
        	System.out.println("Passed test 9, LetterInventory add() method");
        } else {
        	System.out.println("Failed test 9, LetterInventory add() method");
        }
        
    	// test 10: LetterInventory add() method
        letterInventory1 = new LetterInventory("TexasWashington");
        letterInventory2 = new LetterInventory("%%%%!!!!C#####&&&&");
        expectedString = "aaceghinnossttwx";
        if (letterInventory1.add(letterInventory2).toString().equals(expectedString)) {
        	System.out.println("Passed test 10, LetterInventory add() method");
        } else {
        	System.out.println("Failed test 10, LetterInventory add() method");
        }
        
    	// test 11: LetterInventory subtract() method
        letterInventory1 = new LetterInventory("Wyoming");
        letterInventory2 = new LetterInventory("Missouri");
        if (letterInventory1.subtract(letterInventory2) == null) {
        	System.out.println("Passed test 11, LetterInventory subtract() method");
        } else {
        	System.out.println("Failed test 11, LetterInventory subtract() method");
        }
        
    	// test 12: LetterInventory subtract() method
        letterInventory1 = new LetterInventory("CS 314");
        letterInventory2 = new LetterInventory("CS 311");
        expectedString = "";
        if (letterInventory1.subtract(letterInventory2).toString().equals(expectedString)) {
        	System.out.println("Passed test 12, LetterInventory subtract() method");
        } else {
        	System.out.println("Failed test 12, LetterInventory subtract() method");
        }
        
    	// test 13: LetterInventory equals() method
        letterInventory1 = new LetterInventory("Mississippi");
        letterInventory2 = new LetterInventory("siiissMpspi");
        if (letterInventory1.equals(letterInventory2)) {
        	System.out.println("Passed test 13, LetterInventory equals() method");
        } else {
        	System.out.println("Failed test 13, LetterInventory equals() method");
        }
        
    	// test 14: LetterInventory equals() method
        letterInventory1 = new LetterInventory("VolleyeballGymnastics");
        expectedString = "aabceegillllmnosstvyy";
        if (!(letterInventory1.equals(letterInventory2))) {
        	System.out.println("Passed test 14, LetterInventory equals() method");
        } else {
        	System.out.println("Failed test 14, LetterInventory equals() method");
        }
        
    	// test 15: LetterInventory equals() method
        letterInventory1 = new LetterInventory("VolleyeballGymnastics");
        expectedString = "aabceegillllmnosstvyy";
        if (!(letterInventory1.equals(letterInventory2))) {
        	System.out.println("Passed test 15, LetterInventory equals() method");
        } else {
        	System.out.println("Failed test 15, LetterInventory equals() method");
        }
        
        // test 16: LetterInventory constructor
        LetterInventory letterInventory3 = new LetterInventory("Hello!!");
        expectedString = "ehllo";
        if (letterInventory3.toString().equals(expectedString) && letterInventory3.size() == 5) {
        	System.out.println("Passed test 16, LetterInventory constructor");
        } else {
        	System.out.println("Failed test 16, LetterInventory constructor");
        }
        
        // test 17: LetterInventory constructor
        LetterInventory letterInventory4 = new LetterInventory("________");
        expectedString = "";
        if (letterInventory4.toString().equals(expectedString) && letterInventory4.size() == 0) {
        	System.out.println("Passed test 17, LetterInventory constructor");
        } else {
        	System.out.println("Failed test 17, LetterInventory constructor");
        }
        
        // test 18: AnagramSolver getAnagrams() method & implicitly testing AnagramSolver 
        // constructor
        AnagramSolver newAnagramSolver = new AnagramSolver(AnagramMain.readWords("d2.txt"));
    	ArrayList<List<String>> allAnagrams = new ArrayList<List<String>>();
    	
    	ArrayList<String> firstAnagram = new ArrayList<String>();
    	firstAnagram.add("he");
    	firstAnagram.add("planet");
    	
    	ArrayList<String> secondAnagram = new ArrayList<String>();
    	secondAnagram.add("plane");
    	secondAnagram.add("the");
    	
    	ArrayList<String> thirdAnagram = new ArrayList<String>();
    	thirdAnagram.add("plea");
    	thirdAnagram.add("then");
    	
    	allAnagrams.add(firstAnagram);
    	allAnagrams.add(secondAnagram);
    	allAnagrams.add(thirdAnagram);
    	
    	if (newAnagramSolver.getAnagrams("Elephant", 2).equals(allAnagrams)) {
        	System.out.println("Passed test 18, AnagramSolver getAnagrams() method");
        } else {
        	System.out.println("Failed test 18, AnagramSolver getAnagrams() method");
    	}
    	
    	
    	// test 19: AnagramSolver getAnagrams & implicitly testing AnagramSolver constructor
    	allAnagrams = new ArrayList<List<String>>();
    	firstAnagram = new ArrayList<String>();
    	firstAnagram.add("hello");
    	firstAnagram.add("pointing");
    	firstAnagram.add("rid");
    	
    	secondAnagram = new ArrayList<String>();
    	secondAnagram.add("hide");
    	secondAnagram.add("pointing");
    	secondAnagram.add("roll");
    	
    	thirdAnagram = new ArrayList<String>();
    	thirdAnagram.add("hill");
    	thirdAnagram.add("ignored");
    	thirdAnagram.add("point");
    	
    	ArrayList<String> fourthAnagram = new ArrayList<String>();
    	fourthAnagram.add("hill");
    	fourthAnagram.add("noting");
    	fourthAnagram.add("period");
    	
    	ArrayList<String> fifthAnagram = new ArrayList<String>();
    	fifthAnagram.add("hold");
    	fifthAnagram.add("pint");
    	fifthAnagram.add("religion");
    	
    	ArrayList<String> sixthAnagram = new ArrayList<String>();
    	sixthAnagram.add("ill");
    	sixthAnagram.add("nothing");
    	sixthAnagram.add("period");
    	
    	allAnagrams.add(firstAnagram);
    	allAnagrams.add(secondAnagram);
    	allAnagrams.add(thirdAnagram);
    	allAnagrams.add(fourthAnagram);
    	allAnagrams.add(fifthAnagram);
    	allAnagrams.add(sixthAnagram);
    	
    	if (newAnagramSolver.getAnagrams("Dolphin, Lion, Tiger", 3).equals(allAnagrams)) {
        	System.out.println("Passed test 19, AnagramSolver getAnagrams() method");
        } else {
        	System.out.println("Failed test 19, AnagramSolver getAnagrams() method");
    	}
    }

    private static boolean getChoiceToDisplayAnagrams() {
        Scanner console = new Scanner(System.in);
        System.out.print("Enter y or Y to display anagrams during tests: ");
        String response = console.nextLine();
        console.close();
        return response.length() > 0 
                && response.toLowerCase().charAt(0) == 'y';
    }

    private static boolean showTestResults(Object expected, Object actual, 
            int testNum, String featureTested) {
        
        System.out.println("Test Number " + testNum + " testing " 
                + featureTested);
        System.out.println("Expected result: " + expected);
        System.out.println("Actual result: " + actual);
        boolean passed = (actual == null && expected == null) 
                || (actual != null && actual.equals(expected));
        if (passed) {
            System.out.println("Passed test " + testNum);
        } else {
            System.out.println("!!! FAILED TEST !!! " + testNum);
        }
        System.out.println();
        return passed;
    }

    /**
     * Method to run tests on Anagram solver itself.
     * pre: the files d3.txt and testCaseAnagrams.txt are in the local directory
     * 
     * assumed format for file is
     * <NUM_TESTS>
     * <TEST_NUM>
     * <MAX_WORDS>
     * <PHRASE>
     * <NUMBER OF ANAGRAMS>
     * <ANAGRAMS>
     */
    private static void runAnagramTests(AnagramSolver solver, 
            boolean displayAnagrams) {
        
        int solverTestCases = 0;
        int solverTestCasesPassed = 0;
        Stopwatch st = new Stopwatch();
        try {
            Scanner sc = new Scanner(new File(testCaseFileName));
            final int NUM_TEST_CASES = Integer.parseInt(sc.nextLine().trim());
            System.out.println(NUM_TEST_CASES);
            for (int i = 0; i < NUM_TEST_CASES; i++) {
                // expected results
                TestCase currentTest = new TestCase(sc);
                solverTestCases++;
                st.start();
                // actual results
                List<List<String>> actualAnagrams 
                    = solver.getAnagrams(currentTest.phrase, currentTest.maxWords);
                st.stop();
                if(displayAnagrams) {
                    displayAnagrams("actual anagrams", actualAnagrams);
                    displayAnagrams("expected anagrams", currentTest.anagrams);
                }


                if(checkPassOrFailTest(currentTest, actualAnagrams))
                    solverTestCasesPassed++;
                System.out.println("Time to find anagrams: " + st.time());
                /* System.out.println("Number of calls to recursive helper method: " 
                        + NumberFormat.getNumberInstance(Locale.US).format(AnagramSolver.callsCount));*/
            }
            sc.close();
        } catch(IOException e) {
            System.out.println("\nProblem while running test cases on AnagramSolver. Check" +
                            " that file testCaseAnagrams.txt is in the correct location.");
            System.out.println(e);
            System.out.println("AnagramSolver test cases run: " + solverTestCases);
            System.out.println("AnagramSolver test cases failed: " 
                        + (solverTestCases - solverTestCasesPassed));
        }
        System.out.println("\nAnagramSolver test cases run: " + solverTestCases);
        System.out.println("AnagramSolver test cases failed: " + (solverTestCases - solverTestCasesPassed));
    }


    // print out all of the anagrams in a list of anagram
    private static void displayAnagrams(String type,
                    List<List<String>> anagrams) {

        System.out.println("Results for " + type);
        System.out.println("num anagrams: " + anagrams.size());
        System.out.println("anagrams: ");
        for (List<String> singleAnagram : anagrams) {
            System.out.println(singleAnagram);
        }
    }


    // determine if the test passed or failed
    private static boolean checkPassOrFailTest(TestCase currentTest,
                    List<List<String>> actualAnagrams) {

        boolean passed = true;
        System.out.println();
        System.out.println("Test number: " + currentTest.testCaseNumber);
        System.out.println("Phrase: " + currentTest.phrase);
        System.out.println("Word limit: " + currentTest.maxWords);
        System.out.println("Expected Number of Anagrams: " 
                    + currentTest.anagrams.size());
        if(actualAnagrams.equals(currentTest.anagrams)) {
            System.out.println("Passed Test");
        } else {
            System.out.println("\n!!! FAILED TEST CASE !!!");
            System.out.println("Recall MAXWORDS = 0 means no limit.");
            System.out.println("Expected number of anagrams: " 
                        + currentTest.anagrams.size());
            System.out.println("Actual number of anagrams:   " 
                        + actualAnagrams.size());
            if(currentTest.anagrams.size() == actualAnagrams.size()) {
                System.out.println("Sizes the same, "
                        + "but either a difference in anagrams or"
                        + " anagrams not in correct order.");
            }
            System.out.println();
            passed = false;
        }  
        return passed;
    }

    // class to handle the parameters for an anagram test 
    // and the expected result
    private static class TestCase {

        private int testCaseNumber;
        private String phrase;
        private int maxWords;
        private List<List<String>> anagrams;

        // pre: sc is positioned at the start of a test case
        private TestCase(Scanner sc) {
            testCaseNumber = Integer.parseInt(sc.nextLine().trim());
            maxWords = Integer.parseInt(sc.nextLine().trim());
            phrase = sc.nextLine().trim();
            anagrams = new ArrayList<>();
            readAndStoreAnagrams(sc);
        }

        // pre: sc is positioned at the start of the resulting anagrams
        // read in the number of anagrams and then for each anagram:
        //  - read in the line
        //  - break the line up into words
        //  - create a new list of Strings for the anagram
        //  - add each word to the anagram
        //  - add the anagram to the list of anagrams
        private void readAndStoreAnagrams(Scanner sc) {
            int numAnagrams = Integer.parseInt(sc.nextLine().trim());
            for (int j = 0; j < numAnagrams; j++) {
                String[] words = sc.nextLine().split("\\s+");
                ArrayList<String> anagram = new ArrayList<>();
                for (String st : words) {
                    anagram.add(st);
                }
                anagrams.add(anagram);
            }
            assert anagrams.size() == numAnagrams 
                    : "Wrong number of angrams read or expected";
        }
    }
}
