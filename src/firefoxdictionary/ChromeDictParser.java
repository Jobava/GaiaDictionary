package firefoxdictionary;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jobava
 */
public class ChromeDictParser {

    private final String dictName;
    private final String locale;
    private final String description;
    private final String date;
    private final String version;

    public final List<Word> wordList = new ArrayList<>();

    public ChromeDictParser(String fileName) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line = reader.readLine(); //the first line from the chrome dictionary

        String[] tokens = line.split(",");

        //This is needed because we can't assign immutable variables in a loop
        //we can only assign them once
        String dictName_ = "";
        String locale_ = "";
        String description_ = "";
        String date_ = "";
        String version_ = "";

        //just reading the first line
        for (int i = 0; i < tokens.length; ++i) {
            String tok = tokens[i].trim();
            if (tok.startsWith("dictionary")) {
                dictName_ = tok.split("=")[1];
            } else if (tok.startsWith("locale")) {
                locale_ = tok.split("=")[1];
            } else if (tok.startsWith("description")) {
                description_ = tok.split("=")[1];
            } else if (tok.startsWith("date")) {
                date_ = tok.split("=")[1];
            } else if (tok.startsWith("version")) {
                version_ = tok.split("=")[1];
            }
        }

        this.dictName = dictName_;
        this.locale = locale_;
        this.description = description_;
        this.date = date_;
        this.version = version_;

        line = reader.readLine();
        //Now read the rest of the lines
        while (line != null) {
            tokens = line.split(",");

            //First, create member variables of a new word
            String word_ = "";
            String freq_ = "";
            String originalFreq_ = "";
            for (int i = 0; i < tokens.length; ++i) {
                String tok = tokens[i].trim();
                if (tok.startsWith("word")) {
                    word_ = tok.split("=")[1];
                } else if (tok.startsWith("f=")) {
                    freq_ = tok.split("=")[1];
                } else if (tok.startsWith("originalFreq")) {
                    originalFreq_ = tok.split("=")[1];
                }
            }
            Word w = new Word(word_, Integer.parseInt(freq_), Integer.parseInt(originalFreq_));
            wordList.add(w);
            line = reader.readLine();
        }
    }
}
