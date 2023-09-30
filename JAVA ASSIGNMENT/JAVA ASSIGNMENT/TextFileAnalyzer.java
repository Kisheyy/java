import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;

public class TextFileAnalyzer {
    public static void main(String[] args) {
        String filePath = "your_file_path.txt"; 
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

          
            StreamTokenizer tokenizer = new StreamTokenizer(bufferedReader);
            tokenizer.wordChars('a', 'z'); 
            int wordCount = 0;
            int charCount = 0;
            int lineCount = 0;

            int token;
            while ((token = tokenizer.nextToken()) != StreamTokenizer.TT_EOF) {
                if (token == StreamTokenizer.TT_WORD) {
                    wordCount++;
                    charCount += tokenizer.sval.length();
                } else if (token == StreamTokenizer.TT_EOL) {
                    lineCount++;
                }
            }

          
            if (charCount > 0) {
                lineCount++;
            }

         
            fileReader.close();

            System.out.println("Word count: " + wordCount);
            System.out.println("Character count: " + charCount);
            System.out.println("Line count: " + lineCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
