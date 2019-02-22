package Hangtest1;


	import java.util.HashSet;
	import java.util.Scanner;
	import java.util.Set;

	public class Hangman2 {
	       
	       
	       private Set<Character> lettersToGuess;
	       
	       private Set<Character> lettersGuessed;
	       
	       private Set<Character> Wrongletters;
	       
	       private Scanner input;
	       
	       private String wordToGuess;
	       private boolean runGame;
	       private int lives;
	       private char letter;

	       public static void main(String[] args) {
	           Hangman2 game = new Hangman2();
	           game.body();
	       }

		    
	       private String word2Guess() {
	           // todo: try to add dict or make more words
	           String[] wordList = { "hello", "animal", "elephant", "world", "table",
	                   "triangle", "system", "constant", "square", "point", "implement","chair", "someone", "character", "template" };
	           int min = 0;
	           int max = wordList.length - 1;
	           int wordToGuessPosition = randNum(min, max);
	           return wordList[wordToGuessPosition];
	       }

	       private void body() {
	           input = new Scanner(System.in);
	           
	           wordToGuess = word2Guess();
	           runGame = true;
	           lives = 5;
	           lettersToGuess = new HashSet<Character>();
	           lettersGuessed = new HashSet<Character>();
	           Wrongletters = new HashSet<Character>();

	           hintLettersToGuess();
	           // Puts first letter like hint idk if its necessary 
	           lettersGuessed.add(wordToGuess.charAt(0));
	           

	           System.out.println("Guess the word!");
	           while (runGame) {
	               KindaUI();
	               showWordToGuess(wordToGuess, lettersGuessed);
	               System.out.println("Guess a letter!");
	               
	               pickLetter();
	                   if (letterInTheWord(letter, lettersToGuess)) {
	                       GuessedAdd(letter, lettersGuessed);
	                       
	               } else {
	            	   
	                   wrongLetter(letter, Wrongletters);
	                   lifeLost();
	                   System.out.println("Try anothe one");
	                   System.out.println("You got: " + lives + " lives left");
	               }
	               showWordToGuess(wordToGuess, lettersGuessed);
	               
	               if (isGameOver()) {
	                   runGame = false;
	                   if (lives > 0) {
	                	   System.out.println("Congratulations!");
	                	   
	                   
	                   } else {
	                	   System.out.println("********---------|*******");
	    	    		   System.out.println("********|********|*******");
	    	    		   System.out.println("*******( )*******|*******");
	    	    		   System.out.println("*****************|*******");
	    	    		   System.out.println("****YOU LOST!****|*******");
	    	    		   System.out.println("_________________|_______");
	    		           System.out.println("+++++++++++++++++++++++++");
	                   }
	              
	               }
	           }
	           input.close();
	       }
	       private void lifeLost() {
	           lives--;
	       }

//here thing main thing starts. to many words 'letter' todo: to substitute it somehow cuz its rly messy 
	       private int randNum(int min, int max) {
	           return min + (int) (Math.random() * ((max - min) + 1));
	       }

	       private boolean letterInTheWord(char letter, Set<Character> lettersToGuess) {
	           return lettersToGuess.contains(letter);
	       }

	       private void GuessedAdd(char letter,
	               Set<Character> lettersGuessed) {
	           lettersGuessed.add(letter);
	       }

	       private void wrongLetter(char letter, Set<Character> Wrongletters) {
	           Wrongletters.add(letter);
	       }

	       private void hintLettersToGuess() {
	           for (Character a : wordToGuess.toCharArray()) {
	               lettersToGuess.add(a);
	           }
	       }
	       private void pickLetter() {
	           do {
	               letter = input.nextLine().trim().toLowerCase().charAt(0);
	               if (Wrongletters.contains(letter) || lettersGuessed.contains(letter)) {
	                  System.out.println(letter + " is the same letter.");
	                   System.out.println("guess a new letter!");
	               }
	           } while (Wrongletters.contains(letter) || lettersGuessed.contains(letter));
	       }

	      
	       //Shows the word to guess.
	       private void showWordToGuess(String wordToGuess,
	               Set<Character> lettersGuessed) {

	           for (int i = 0; i < wordToGuess.length(); i++) {

	               // what to reveal to the user
	               if (lettersGuessed.contains(wordToGuess.charAt(i))) {
	                   System.out.print(wordToGuess.charAt(i));
	                   
	               } else {
	            	   
	                   System.out.print("*");
	               }
	           }
	           System.out.println();
	       }

//its so ugly to do: make it better
	       private void KindaUI() {
	    	   
	    	   if (lives == 4) {
	    		   
	    	   System.out.println("*************************");
	    	   System.out.println("*************************");
	    	   System.out.println("*************************");
	    	   System.out.println("*************************"); 
	           System.out.println("_________________________");
	           System.out.println("+++++++++++++++++++++++++");
	          
	    	   }
	    	   if (lives == 3) {
	    		  
	    		   System.out.println("*****************|*******");
	    		   System.out.println("*****************|*******");
	    		   System.out.println("*****************|*******");
	    		   System.out.println("*****************|*******");
	    		   System.out.println("_________________|_______");
		           System.out.println("+++++++++++++++++++++++++");
		           
	    	   }
	    	   if (lives == 2) {
	    		   
	    		   System.out.println("********---------|*******");
	    		   System.out.println("*****************|*******");
	    		   System.out.println("*****************|*******");
	    		   System.out.println("*****************|*******");
	    		   System.out.println("_________________|_______");
		           System.out.println("+++++++++++++++++++++++++");
		           
	    	   }
	    	   if (lives == 1) {
	    		   
	    		   System.out.println("********---------|*******");
	    		   System.out.println("********|********|*******");
	    		   System.out.println("*****************|*******");
	    		   System.out.println("*****************|*******");
	    		   System.out.println("_________________|_______");
		           System.out.println("+++++++++++++++++++++++++");
		           
		          //implement 0 lives into a body method 
	    	   }

	       }
//gameover check
	       private boolean isGameOver() {
	           return ((lives == 0) || (lettersGuessed.size() == lettersToGuess.size()));
	       }

	      
	}

