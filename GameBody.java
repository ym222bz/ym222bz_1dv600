package v2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class GameBody {
    private boolean runGame;
    private int lives;
    private boolean isHard;
    private ArrayList<Boolean> Journal = new ArrayList<Boolean>();
    private Data gameData = new Data();
    protected Set<Character> lettersGuessed = new HashSet<Character>();
    protected Set<Character> Wrongletters = new HashSet<Character>();
    protected Set<Character> wordGuessed = new HashSet<Character>();
    public Set<Character> lettersToGuess = new HashSet<Character>();
    private InputData input = new InputData();
    private char letter;
    protected String wordToGuess;

    public GameBody()
    {
        this.isHard = false;
        this.lives = 5;
        
    }

    public GameBody(int liveCount, boolean isHard)
    {
        this.lives = liveCount;
        this.isHard = isHard;
        
    }

    public GameBody(int liveCount)
    {
        this.lives = liveCount;
        this.isHard = false;
    }

    public GameBody(boolean isHard)
    {
        this.isHard = isHard;
        this.lives = 5;
        
    }

    protected boolean Journalizing(boolean action)
    {
        try
        {
            Journal.add(action);
            return true;
        }
        catch (Exception ex)
        {
            return false;
        }
    }

    protected boolean letterInTheWord(char letter, Set<Character> lettersToGuess) {
        if (lettersToGuess.contains(letter))
        {
            Journalizing(true);
            return lettersToGuess.contains(letter); // возможно
        }
        else
        {
            Journalizing(false);
            return lettersToGuess.contains(letter); // возможно
        }

    }

    protected void lifeLost() {
        lives--;
    }

    protected void InitializeGame() {
        wordToGuess = gameData.GetRandomWord();
        runGame = true;
        Wrongletters = new HashSet<Character>();

        hintLettersToGuess();
        // Puts first letter like hint idk if its necessary
        lettersGuessed.add(wordToGuess.charAt(0));


        System.out.println("Guess the word!");
        while (runGame) {
            KindaUI();
            showWordToGuess(wordToGuess, lettersGuessed);
            System.out.println("Guess a letter!");
            letter = input.EnterData();
            pickLetter(letter);
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
    }

    protected void GuessedAdd(char letter, Set<Character> lettersGuessed) {
        lettersGuessed.add(letter);
    }

    protected void wrongLetter(char letter, Set<Character> Wrongletters) {
        Wrongletters.add(letter);
    }

    protected void hintLettersToGuess() {
        for (Character a : wordToGuess.toCharArray()) {
            lettersToGuess.add(a);
        }
    }

    protected boolean pickLetter(char letter) {
    	int counter = 0;
        try
        {
            do {
            	counter++;

                if (Wrongletters.contains(letter) || lettersGuessed.contains(letter)) {
                    System.out.println(letter + " is the same letter.");
                    System.out.println("guess a new letter!");
                  
                    if (counter > 500)
                    {
                    	throw new NullPointerException("He's dead, Kirk!");
                    }
                    break; //BUG
                }
            } while (Wrongletters.contains(letter) || lettersGuessed.contains(letter));
            return true;
        }
        catch (Exception ex)
        {
            return false;
        }
    }

    //Shows the word to guess.
    protected void showWordToGuess(String wordToGuess,
                                 Set<Character> lettersGuessed) {
    	wordGuessed.clear();
        for (int i = 0; i < wordToGuess.length(); i++) {

            // what to reveal to the user
            if (lettersGuessed.contains(wordToGuess.charAt(i))) {
                System.out.print(wordToGuess.charAt(i));

            } else {
                System.out.print("-");
                wordGuessed.add('*');
            }
        }
        System.out.println();
    }

    protected void KindaUI() {

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

    protected boolean isGameOver()
    {
        try
        {
        	System.out.println(" You gussed " + lettersGuessed.size() +" of " + gameData.GetOriginalWord().length() + " letters ");
            return ((lives == 0) || (this.lettersGuessed.size() == gameData.GetOriginalWord().length()));
        }
        catch(Exception ex)
        {
            System.out.println(lettersGuessed.size());
            System.out.println(gameData.GetOriginalWord().length());
            return false;
        }

    }
}
