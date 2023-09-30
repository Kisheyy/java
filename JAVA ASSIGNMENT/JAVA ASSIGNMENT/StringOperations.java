public class StringOperations {
    public static void main(String[] args) {
        String sampleString = "The quick brown fox jumps over the lazy dog.";

       
        String compareString = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG.";
        boolean lexicographicComparison = sampleString.equalsIgnoreCase(compareString);
        System.out.println("i. Lexicographic Comparison (Ignoring Case): " + lexicographicComparison);

       
        String endString = "dog.";
        boolean endsWith = sampleString.endsWith(endString);
        System.out.println("ii. Ends with \"" + endString + "\": " + endsWith);

      
        java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date date = new java.util.Date();
        String formattedDate = dateFormat.format(date);
        System.out.println("iii. Current Date and Time: " + formattedDate);

     
        for (char c = 'a'; c <= 'z'; c++) {
            int index = sampleString.indexOf(c);
            if (index != -1) {
                System.out.println("iv. Index of '" + c + "': " + index);
            }
        }

      
        String replacedString = sampleString.replaceAll("fox", "cat");
        System.out.println("v. Replaced String: " + replacedString);

      
        int startIndex = 4;
        int endIndex = 9;
        String substring = sampleString.substring(startIndex, endIndex);
        System.out.println("vi. Substring from position " + startIndex + " to " + endIndex + ": " + substring);

        
        String trimmedString = sampleString.trim();
        System.out.println("vii. Trimmed String: " + trimmedString);

      
        String lowercaseString = sampleString.toLowerCase();
        System.out.println("viii. Lowercase String: " + lowercaseString);

        int length = sampleString.length();
        System.out.println("ix. Length of the String: " + length);

    
        String anotherString = "The quick brown fox jumps over the lazy dog.";
        boolean isEqual = sampleString.equals(anotherString);
        System.out.println("x. Strings are Equal: " + isEqual);
    }
}
