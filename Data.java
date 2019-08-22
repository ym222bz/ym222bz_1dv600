package v2;


import java.util.ArrayList;

public class Data {
    private static String originalWord;
    private static String guessingWord = "";
    private String[] Words = { "hello", "animal", "elephant", "world", "table",
            "triangle", "system", "constant", "square", "point", "implement","chair", "someone", "character", "template" };
    public boolean SetOriginalWord(String ow) // Setting by player
    {
    try
    {
        originalWord = ow;
        return true;
    }
    catch (Exception ex)
    {
        return false;
    }
    }

    public String GetOriginalWord()
    {
        return originalWord;
    }

    private int randNum(int min, int max)
    {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    public String GetRandomWord()
    {
        int min = 0;
        int max = Words.length - 1; // возможно тут (сюда положим баг)
        int wordToGuessPosition = randNum(min, max);
        this.SetOriginalWord(Words[wordToGuessPosition]);
        return Words[wordToGuessPosition];
    }

    public String GetRandomWord(char firstLetter) // Get Random Words from List sorted by first letter
    {
        ArrayList<String> rightWords = new ArrayList<String>();
        for (String s:Words)
        {
           if (s.charAt(0) == firstLetter)
           {
               rightWords.add(s);
           }
        }
        if (rightWords.size() == 0)
        {
            rightWords.add("Empty");
        }
        int min = 0;
        int max = rightWords.size() - 1; // возможно тут (сюда положим баг)
        int wordToGuessPosition = randNum(min, max);
        this.SetOriginalWord(rightWords.get(wordToGuessPosition));
        return rightWords.get(wordToGuessPosition);
}

    public String GetRandomWord(char firstLetter, int min, int max) // Get Random Words from List sorted by first letter
    {
        ArrayList<String> rightWords = new ArrayList<String>();
        for (String s:Words)
        {
            if (s.charAt(0) == firstLetter)
            {
                rightWords.add(s);
            }
        }
        if (min < 0)
        {
            min = 0;
        }
        if (max > rightWords.size() - 1)
        {
            max = rightWords.size() - 1;
        }
        int wordToGuessPosition = randNum(min, max);
        this.SetOriginalWord(rightWords.get(wordToGuessPosition));
        return rightWords.get(wordToGuessPosition);
    }

    public boolean SetGuessWord()
    {
        try
        {
            char[] bufferWord = originalWord.toCharArray();
            //System.out.println(bufferWord);
            for (int i = 0; i < originalWord.length(); i++)
            {
                bufferWord[i] = '*';
                guessingWord += bufferWord[i];
            }
            //System.out.println(guessingWord);
            return true;
        }
        catch (Exception ex)
        {
            return false;
        }
    }

    public String GetGuessWord()
    {
        return guessingWord;
    }


}
