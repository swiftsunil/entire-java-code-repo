package com.pearson.qa.ocv2;
import com.pearson.qa.ocv2.StringBuilder.StringBuilderClass;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Sunil Kumar on 10/28/2014.
 */
public class StringManipiulationCompleteTests {
    final static String filename = "C:\\Users\\Sunil Kumar\\Desktop\\Tools and Languages\\" +
            "Automation Installation and Training folder\\TRAINING PROJECTS\\ENTIRE JAVA CODE project\\" +
            "entire-java-code-project\\FileReaderTextFile.txt";
    Logger logger = Logger.getLogger(StringManipiulationCompleteTests.class);

    @Test
    public  void validateStringManipulation() {
        // StringBuilder with 16 empty elements
        StringBuilder sb = new StringBuilder();
        sb.append("Hello from JCG");
        logger.debug("sb appends a string: " + sb);
        // append a character
        char c = '!';
        sb.append(c);
        logger.debug("sb after appending a char: " + sb);

        sb.insert(6, "everyone ");
        logger.debug("sb after insert: " + sb);

        // StringBulder with a initialized capacity
        StringBuilder sbnew = new StringBuilder(15);
        sbnew.append(123456789);
        logger.debug("sb with length " + sbnew.length() + " and capacity " + sbnew.capacity() +
                " appends an int: " + sbnew);
        // delete 234
        sbnew.delete(1, 4);
        logger.debug("sb after delete: " + sbnew);

        // read from a file and append into a StringBuilder every new line
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));

            StringBuilder sbFile = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                // append the line of the file
                sbFile.append(line);
                // separate the line with a '@'
                sbFile.append('@');
                // read the next line of the file
                line = br.readLine();
            }
            // this string contains the character sequence
            String readFile = sbFile.toString();
            br.close();
            logger.debug("from file: " + readFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


