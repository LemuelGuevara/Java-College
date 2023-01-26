package OOPMyStringClass;

import java.util.*;

class MyString
{
    private final char[] charArray;
    private final int charArrayLength;

    // Constructor that takes in a char array and the length of the array
    MyString(char[] ch, int arrayLength)
    {
        this.charArray = ch;
        this.charArrayLength = arrayLength;
    }

    // A getter method for returning the length of the char array
    public int getCharArrayLength()
    {
        return charArrayLength;
    }

    // Gets and displays the first word in the array
    public void firstWord()
    {
        System.out.print("\nFirst word: ");

        for (int i = 0; i < getCharArrayLength(); i++)
            if (charArray[i] == ' ')
                break;
            else
                System.out.print(charArray[i]);
    }

    // Gets and displays the last word in the string
    public void lastWord()
    {
        int whiteSpaceIndex = 0;

        System.out.print("\nLast word: ");

        // Gets the index of the whitespace
        for (int i = 0; i < getCharArrayLength(); i++)
            if (charArray[i] == ' ')
                whiteSpaceIndex = i;

        // Iterates trough the array by using the index of found whitespace
        for (int i = whiteSpaceIndex; i < getCharArrayLength(); i++)
            System.out.print(charArray[i]);
    }

    // Displays the string in a reverse order
    public void reverse()
    {
        System.out.print("\nReverse order of the string: ");

        for (int i = getCharArrayLength() - 1; i >= 0; i--)
            System.out.print(charArray[i]);
    }

    // Displays the number of words in the given string
    public void numOfWords()
    {
        // Initially set to 1 to also count the whitespace at the end of the array
        int wordCount = 1;

        System.out.print("\nNumber of words: ");

        // Counts the number of the words by counting the whitespaces in between words
        for (int i = 0; i < getCharArrayLength(); i++)
            if(charArray[i] == ' ')
                wordCount++;

        System.out.println("Number of words: " + wordCount);
    }
}

public class OOPMyStringClass
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String str;

        System.out.println("Enter a string: ");
        str = in.nextLine();

        char[] ch = str.toCharArray();

        MyString myStr = new MyString(ch, str.length());
        myStr.firstWord();
        myStr.lastWord();
        myStr.reverse();
        myStr.numOfWords();
    }
}
