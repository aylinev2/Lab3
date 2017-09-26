import java.io.IOException;
import java.net.URL;
import java.util.Scanner;


/**
 * A class that searches for words and computes word counts for certain urls.
 *
 */
public class WebScraping {

    /**
     * @param args unused input arguments
     */
    public static void main(final String[] args) {
        String url = urlToString("http://erdani.com/tdpl/hamlet.txt");
        int count = totalWordCount(url);
        int horCount = wordOccourrences(url, "hor");
        System.out.println("Total words: " + count);
        System.out.println("Total amount of time the word Hor occured : " + horCount);

    }

    /**
     * a method that returns the total amount of words.
     * @param url a String
     * @return total word count
     */
    public static int totalWordCount(final String url) {
       String[] words = url.split(" ");
       int count = words.length;
       return count;
    }

    /**
     * a method that returns the total amount of times that a certain word occurs.
     * @param url a String
     * @param wordLookingFor a String
     * @return total word count
     */
    public static int wordOccourrences(final String url, final String wordLookingFor) {
        String[] words = url.split(" ");
        int count = 0;

        while (count < words.length) {
            if (words[count].equalsIgnoreCase(wordLookingFor)) {
                count++;
            }
        }

        return count;
    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
    Scanner urlScanner;
    try {
        urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
    } catch (IOException e) {
        return "";
    }
    String contents = urlScanner.useDelimiter("\\A").next();
    urlScanner.close();
    return contents;
}
}
