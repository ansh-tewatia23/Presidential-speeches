
/**
 * Analyze the speeches of presidents from 3 different eras
 *
 * @author Ansh Tewatia and Neel Gullatti
 * @version 10/20
 */
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class Presidentialspeeches
{
   public static String extractJsonValue(String json, String key) { //method for extracting info
    String keyTarget = "\"" + key + "\":";
    int keyIndex = json.indexOf(keyTarget);
    if (keyIndex == -1) {
        return "";
    }

    // Locate the first opening quote after the key
    int startQuote = json.indexOf("\"", keyIndex + keyTarget.length());
    if (startQuote == -1) {
        return "";
    }

    // Locate the matching closing quote
    int endQuote = json.indexOf("\"", startQuote + 1);
    
    // Handle escaped quotes inside the speech text (e.g., \")
    while (endQuote != -1 && json.charAt(endQuote - 1) == '\\') {
        endQuote = json.indexOf("\"", endQuote + 1);
    }

    if (endQuote == -1) {
        return "";
    }

    return json.substring(startQuote + 1, endQuote);
}

    
    
    public static void main(String[] args) throws IOException { //gets rid of error
       // Accessing a specific file inside the speeches folder
       
       //sets up all the files for access
        File speechFile1 = new File("speeches/Washington_1789.json");
       
        
        
        String jsonContent1 = "";
        Scanner fileScan1 = new Scanner(speechFile1);
        
        while (fileScan1.hasNextLine()) {
            jsonContent1 += fileScan1.nextLine() + " ";
        }
        fileScan1.close();
        
        
        File speechFile2 = new File("speeches/Andrew_Jackson_1829.json");
       
        String jsonContent2 = "";
        Scanner fileScan2 = new Scanner(speechFile2);
        
        while (fileScan2.hasNextLine()) {
            jsonContent2 += fileScan2.nextLine() + " ";
        }
        fileScan2.close();
        
        
        File speechFile3 = new File("speeches/Abraham_Lincoln_1860.json");
       
        String jsonContent3= "";
        Scanner fileScan3= new Scanner(speechFile3);
        
        while (fileScan3.hasNextLine()) {
            jsonContent3 += fileScan3.nextLine() + " ";
        }
        fileScan3.close();

        
        File speechFile4 = new File("speeches/Andrew_Johnson_1868.json");
       
        String jsonContent4 = "";
        Scanner fileScan4 = new Scanner(speechFile4);
        
        while (fileScan4.hasNextLine()) {
            jsonContent4 += fileScan4.nextLine() + " ";
        }
        fileScan4.close();
        
        
        File speechFile5 = new File("speeches/Barack_Obama_2010.json");
       
        String jsonContent5 = "";
        Scanner fileScan5 = new Scanner(speechFile5);
        
        while (fileScan5.hasNextLine()) {
            jsonContent5 += fileScan5.nextLine() + " ";
        }
        fileScan5.close();
        
        
        File speechFile6 = new File("speeches/Bill_Clinton_1995.json");
       
        String jsonContent6 = "";
        Scanner fileScan6 = new Scanner(speechFile6);
        
        while (fileScan6.hasNextLine()) {
            jsonContent6 += fileScan6.nextLine() + " ";
        }
        fileScan6.close();
        
        String president = extractJsonValue(jsonContent1, "president");
        String date = extractJsonValue(jsonContent1, "date");
        String speechText = extractJsonValue(jsonContent1, "text");
    
        System.out.println("President: " + president);
        System.out.println("Date: " + date);
       
        
        //initialize variables for analysis
        int wordCount = 0;
        
        boolean inWord = false;
        int chars= 0;
        String currentWord= "";
        int peopleCounter=0;
        int governmentCounter=0;
        int unitedCounter=0;
        int ourCounter=0;
        
        
        for (int i = 0; i < jsonContent1.length(); i++) {
            char c = jsonContent1.charAt(i);
            
            // If it's not a whitespace character
            if (!Character.isWhitespace(c)) {
                chars++;
                if (!inWord) {
                    wordCount++; // Found the start of a new word!
                    inWord = true;
                    
                                        
                    
                }
                currentWord+=c;
            } else {
                inWord = false; // Hit a space, so we are outside a word
                if (currentWord.equalsIgnoreCase("people")) {//counts out vital words
                    peopleCounter++;
                }
                if (currentWord.equalsIgnoreCase("government")) {
                    governmentCounter++;
                }
                if (currentWord.equalsIgnoreCase("united")) {
                    unitedCounter++;
                }
                if (currentWord.equalsIgnoreCase("our")) {
                    ourCounter++;
                }
                currentWord= "";
            }
        }

        System.out.println("Total Words: " + wordCount);
        System.out.println("Average word length: "+String.format("%.2f", ((double)chars/wordCount)));
        System.out.println("The word 'People' used "+peopleCounter+" times (" + String.format("%.2f", (double)peopleCounter / wordCount * 100) + "%)");
        System.out.println("The word 'government' used "+governmentCounter+" times (" + String.format("%.2f", (double)governmentCounter / wordCount * 100) + "%)");
        System.out.println("The word 'united' used "+unitedCounter+" times (" + String.format("%.2f", (double)unitedCounter / wordCount * 100) + "%)");
        System.out.println("The word 'our' used "+ourCounter+" times (" + String.format("%.2f", (double)ourCounter / wordCount * 100) + "%)");
        System.out.println("");
        
        String president2 = extractJsonValue(jsonContent2, "president");
        String date2 = extractJsonValue(jsonContent2, "date");
        
        System.out.println("President: " + president2);
        System.out.println("Date: " + date2);
        
        int wordCount2 = 0;
        boolean inWord2 = false;
        int chars2 = 0;
        String currentWord2 = "";
        int peopleCounter2 = 0;
        int governmentCounter2 = 0;
        int unitedCounter2 = 0;
        int ourCounter2 = 0;
        
        for (int i = 0; i < jsonContent2.length(); i++) {
            char c = jsonContent2.charAt(i);
            if (!Character.isWhitespace(c)) {
                chars2++;
                if (!inWord2) {
                    wordCount2++;
                    inWord2 = true;
                }
                currentWord2 += c;
            } else {
                inWord2 = false;
                if (currentWord2.equalsIgnoreCase("people")) {
                    peopleCounter2++;
                }
                if (currentWord2.equalsIgnoreCase("government")) {
                    governmentCounter2++;
                }
                if (currentWord2.equalsIgnoreCase("united")) {
                    unitedCounter2++;
                }
                if (currentWord2.equalsIgnoreCase("our")) {
                    ourCounter2++;
                }
                currentWord2 = "";
            }
        }

        System.out.println("Total Words: " + wordCount2);
        System.out.println("Average word length: "+String.format("%.2f", ((double)chars2/wordCount2)));
        System.out.println("The word 'People' used " + peopleCounter2 + " times (" + String.format("%.2f", (double)peopleCounter2 / wordCount2 * 100) + "%)");
        System.out.println("The word 'government' used " + governmentCounter2 + " times (" + String.format("%.2f", (double)governmentCounter2 / wordCount2 * 100) + "%)");
        System.out.println("The word 'united' used " + unitedCounter2 + " times (" + String.format("%.2f", (double)unitedCounter2 / wordCount2 * 100) + "%)");
        System.out.println("The word 'our' used " + ourCounter2 + " times (" + String.format("%.2f", (double)ourCounter2 / wordCount2 * 100) + "%)");
        System.out.println();
        
        String president3 = extractJsonValue(jsonContent3, "president");
        String date3 = extractJsonValue(jsonContent3, "date");
        
        System.out.println("President: " + president3);
        System.out.println("Date: " + date3);
        
        int wordCount3 = 0;
        boolean inWord3 = false;
        int chars3 = 0;
        String currentWord3 = "";
        int peopleCounter3 = 0;
        int governmentCounter3 = 0;
        int unitedCounter3 = 0;
        int ourCounter3 = 0;
        
        for (int i = 0; i < jsonContent3.length(); i++) {
            char c = jsonContent3.charAt(i);
            if (!Character.isWhitespace(c)) {
                chars3++;
                if (!inWord3) {
                    wordCount3++;
                    inWord3 = true;
                }
                currentWord3 += c;
            } else {
                inWord3 = false;
                if (currentWord3.equalsIgnoreCase("people")) {
                    peopleCounter3++;
                }
                if (currentWord3.equalsIgnoreCase("government")) {
                    governmentCounter3++;
                }
                if (currentWord3.equalsIgnoreCase("united")) {
                    unitedCounter3++;
                }
                if (currentWord3.equalsIgnoreCase("our")) {
                    ourCounter3++;
                }
                currentWord3 = "";
            }
        }

        System.out.println("Total Words: " + wordCount3);
        System.out.println("Average word length: "+String.format("%.2f", ((double)chars3/wordCount3)));
        System.out.println("The word 'People' used " + peopleCounter3 + " times (" + String.format("%.2f", (double)peopleCounter3 / wordCount3 * 100) + "%)");
        System.out.println("The word 'government' used " + governmentCounter3 + " times (" + String.format("%.2f", (double)governmentCounter3 / wordCount3 * 100) + "%)");
        System.out.println("The word 'united' used " + unitedCounter3 + " times (" + String.format("%.2f", (double)unitedCounter3 / wordCount3 * 100) + "%)");
        System.out.println("The word 'our' used " + ourCounter3 + " times (" + String.format("%.2f", (double)ourCounter3 / wordCount3 * 100) + "%)");
        System.out.println();
        
        
        String president4 = extractJsonValue(jsonContent4, "president");
        String date4 = extractJsonValue(jsonContent4, "date");
        
        System.out.println("President: " + president4);
        System.out.println("Date: " + date4);
        
        int wordCount4 = 0;
        boolean inWord4 = false;
        int chars4 = 0;
        String currentWord4 = "";
        int peopleCounter4 = 0;
        int governmentCounter4 = 0;
        int unitedCounter4 = 0;
        int ourCounter4 = 0;
        
        for (int i = 0; i < jsonContent4.length(); i++) {
            char c = jsonContent4.charAt(i);
            if (!Character.isWhitespace(c)) {
                chars4++;
                if (!inWord4) {
                    wordCount4++;
                    inWord4 = true;
                }
                currentWord4 += c;
            } else {
                inWord4 = false;
                if (currentWord4.equalsIgnoreCase("people")) {
                    peopleCounter4++;
                }
                if (currentWord4.equalsIgnoreCase("government")) {
                    governmentCounter4++;
                }
                if (currentWord4.equalsIgnoreCase("united")) {
                    unitedCounter4++;
                }
                if (currentWord4.equalsIgnoreCase("our")) {
                    ourCounter4++;
                }
                currentWord4 = "";
            }
        }

        System.out.println("Total Words: " + wordCount4);
        System.out.println("Average word length: "+String.format("%.2f", ((double)chars4/wordCount4)));
        System.out.println("The word 'People' used " + peopleCounter4 + " times (" + String.format("%.2f", (double)peopleCounter4 / wordCount4 * 100) + "%)");
        System.out.println("The word 'government' used " + governmentCounter4 + " times (" + String.format("%.2f", (double)governmentCounter4 / wordCount4 * 100) + "%)");
        System.out.println("The word 'united' used " + unitedCounter4 + " times (" + String.format("%.2f", (double)unitedCounter4 / wordCount4 * 100) + "%)");
        System.out.println("The word 'our' used " + ourCounter4 + " times (" + String.format("%.2f", (double)ourCounter4 / wordCount4 * 100) + "%)");
        System.out.println();
        
        
        String president5 = extractJsonValue(jsonContent5, "president");
        String date5 = extractJsonValue(jsonContent5, "date");
        
        System.out.println("President: " + president5);
        System.out.println("Date: " + date5);
        
        int wordCount5 = 0;
        boolean inWord5 = false;
        int chars5 = 0;
        String currentWord5 = "";
        int peopleCounter5 = 0;
        int governmentCounter5 = 0;
        int unitedCounter5 = 0;
        int ourCounter5 = 0;
        
        for (int i = 0; i < jsonContent5.length(); i++) {
            char c = jsonContent5.charAt(i);
            if (!Character.isWhitespace(c)) {
                chars5++;
                if (!inWord5) {
                    wordCount5++;
                    inWord5 = true;
                }
                currentWord5 += c;
            } else {
                inWord5 = false;
                if (currentWord5.equalsIgnoreCase("people")) {
                    peopleCounter5++;
                }
                if (currentWord5.equalsIgnoreCase("government")) {
                    governmentCounter5++;
                }
                if (currentWord5.equalsIgnoreCase("united")) {
                    unitedCounter5++;
                }
                if (currentWord5.equalsIgnoreCase("our")) {
                    ourCounter5++;
                }
                currentWord5 = "";
            }
        }

        System.out.println("Total Words: " + wordCount5);
        System.out.println("Average word length: "+String.format("%.2f", ((double)chars5/wordCount5)));
        System.out.println("The word 'People' used " + peopleCounter5 + " times (" + String.format("%.2f", (double)peopleCounter5 / wordCount5 * 100) + "%)");
        System.out.println("The word 'government' used " + governmentCounter5 + " times (" + String.format("%.2f", (double)governmentCounter5 / wordCount5 * 100) + "%)");
        System.out.println("The word 'united' used " + unitedCounter5 + " times (" + String.format("%.2f", (double)unitedCounter5 / wordCount5 * 100) + "%)");
        System.out.println("The word 'our' used " + ourCounter5 + " times (" + String.format("%.2f", (double)ourCounter5 / wordCount5 * 100) + "%)");
        System.out.println();
        
        
        String president6 = extractJsonValue(jsonContent6, "president");
        String date6 = extractJsonValue(jsonContent6, "date");
        
        System.out.println("President: " + president6);
        System.out.println("Date: " + date6);
        
        int wordCount6 = 0;
        boolean inWord6 = false;
        int chars6 = 0;
        String currentWord6 = "";
        int peopleCounter6 = 0;
        int governmentCounter6 = 0;
        int unitedCounter6 = 0;
        int ourCounter6 = 0;
        
        for (int i = 0; i < jsonContent6.length(); i++) {
            char c = jsonContent6.charAt(i);
            if (!Character.isWhitespace(c)) {
                chars6++;
                if (!inWord6) {
                    wordCount6++;
                    inWord6 = true;
                }
                currentWord6 += c;
            } else {
                inWord6 = false;
                if (currentWord6.equalsIgnoreCase("people")) {
                    peopleCounter6++;
                }
                if (currentWord6.equalsIgnoreCase("government")) {
                    governmentCounter6++;
                }
                if (currentWord6.equalsIgnoreCase("united")) {
                    unitedCounter6++;
                }
                if (currentWord6.equalsIgnoreCase("our")) {
                    ourCounter6++;
                }
                currentWord6 = "";
            }
        }

        System.out.println("Total Words: " + wordCount6);
        System.out.println("Average word length: "+String.format("%.2f", ((double)chars6/wordCount6)));
        System.out.println("The word 'People' used " + peopleCounter6 + " times (" + String.format("%.2f", (double)peopleCounter6 / wordCount6 * 100) + "%)");
        System.out.println("The word 'government' used " + governmentCounter6 + " times (" + String.format("%.2f", (double)governmentCounter6 / wordCount6 * 100) + "%)");
        System.out.println("The word 'united' used " + unitedCounter6 + " times (" + String.format("%.2f", (double)unitedCounter6 / wordCount6 * 100) + "%)");
        System.out.println("The word 'our' used " + ourCounter6 + " times (" + String.format("%.2f", (double)ourCounter6 / wordCount6 * 100) + "%)");
        
}
}
