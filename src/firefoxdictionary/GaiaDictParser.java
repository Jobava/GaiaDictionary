package firefoxdictionary;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Jobava
 */
public class GaiaDictParser {

    private final String locale;
    private final String description;
    private final String date;
    private final String version;

    public final List<Word> wordList = new ArrayList<>();

    public GaiaDictParser(String fileName) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line = reader.readLine(); //the first line from the chrome dictionary
        this.locale = line.split("locale=\"")[1].split("\"")[0];
        this.description = line.split("description=\"")[1].split("\"")[0];
        this.date = line.split("date=\"")[1].split("\"")[0];
        this.version = line.split("version=\"")[1].split("\"")[0];

        line = reader.readLine();
        //Now read the rest of the lines
        while (line != null) {
            if (! line.trim().startsWith("<w")) {
                break;
            }
            //First, create member variables of a new word
            String word_ = "";
            int freq_ = 0;

            word_ = line.split("flags=\"\">")[1].split("<")[0];
            freq_ = Integer.parseInt(line.split("f=\"")[1].split("\"")[0]);
            wordList.add(new Word(word_, freq_, freq_));
            line = reader.readLine();
        }
        Collections.sort(wordList);
    }
}
