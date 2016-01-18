package firefoxdictionary;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Jobava
 */
public class Util {

    public static void sortUniqLowercase(String infile, String outfile) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(infile));
        String line = null;
        String prevLine = null;

        PrintWriter pr = new PrintWriter(outfile);
        while (null != (line = br.readLine())) {
            if (null == prevLine) {
                pr.println(line);
                prevLine = line;
                continue;
            }
            if (line.trim().toLowerCase().equals(
                    prevLine.trim().toLowerCase())) {
                continue;
            } else {
                pr.println(line);
                prevLine = line;
            }
        }
        br.close();
        pr.close();
    }
    
    public static void main (String [] args) throws IOException {
        sortUniqLowercase ("chrome_plus_dexonline_sorted.txt", "chrome_plus_dexonline_sorted_uniq.txt");
    }
}
