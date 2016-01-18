package firefoxdictionary;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Jobava
 */
public class FirefoxDictionary {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        //ChromeDictParser chrome = new ChromeDictParser("ro_wordlist.combined");
        //System.out.println(chrome.wordList.get(1500));
        //System.out.println(chrome.wordList.get(1501));
        //System.out.println(chrome.wordList.get(1502));
        //System.out.println(chrome.wordList.get(1503));

        //for (Word w: chrome.wordList) {
        //    if (w.getFreq() != w.getOriginalFreq()) {
        //        System.out.println ("The word " + w.getWord() + " freq: " + w.getFreq() +
        //                ", origFreq: " + w.getOriginalFreq());
        //    }
        //}
        
        //int minFreq = 255;
        //int maxFreq = 0;
        //for (Word w : chrome.wordList) {
        //    int fr = w.getFreq();
        //    if (fr > maxFreq) {
        //        maxFreq = fr;
        //    }
        //    if (fr < minFreq) {
        //        minFreq = fr;
        //    }
        //}
        //System.out.println ("minFr: " + minFreq + ", maxFr: " + maxFreq);
        
        //int []freqs = new int[255];
        //for (Word w : chrome.wordList) {
        //    ++freqs[w.getFreq()]; //increment
        //}
        //for (int i=0; i<freqs.length; ++i) {
        //    if (freqs[i] != 0) {
        //        System.out.println(i + "\t" + freqs[i]);
        //    }
        //}
        
        /////////////////////////////
        //GaiaDictParser gaia = new GaiaDictParser("ro_wordlist.xml");
        
//        int minFreq = 255;
//        int maxFreq = 0;
//        for (Word w : gaia.wordList) {
//            int fr = w.getFreq();
//            if (fr > maxFreq) {
//                maxFreq = fr;
//            }
//            if (fr < minFreq) {
//                minFreq = fr;
//            }
//        }
//        System.out.println ("minFr: " + minFreq + ", maxFr: " + maxFreq);
        
//        int []freqs = new int[256];
//        for (Word w : gaia.wordList) {
//            ++freqs[w.getFreq()]; //increment
//        }
//        for (int i=0; i<freqs.length; ++i) {
//            if (freqs[i] != 0) {
//                System.out.println(i + "\t" + freqs[i]);
//            }
//        }
        
        ////////////////////////////////
        
        //ChromeDictParser chrome = new ChromeDictParser("ro_wordlist.combined");
        //GaiaDictParser gaia = new GaiaDictParser("ro_wordlist.xml");
        //Set<String> chromeSet = new HashSet<>();
        //for (Word w:chrome.wordList) {
        //    chromeSet.add(w.getWord().toLowerCase());
        //}
        //int i=0;
        //for (Word w:gaia.wordList) {
        //    if (!(chromeSet.contains(w.getWord().toLowerCase()))) {
        //        System.out.println( (++i) + " " + w.getWord());
        //    }
        //}
//        ChromeDictParser chrome = new ChromeDictParser("ro_wordlist.combined");
//        PrintWriter writer = new PrintWriter("new_wordlist.xml", "UTF-8");
//        writer.println("<wordlist locale=\"ro\" description=\"Română\" date=\"1408019089\" version=\"2\">");
//        for (Word w:chrome.wordList) {
//            writer.print(" <w f=\"" + w.getFreq() + "\" flags=\"\">" + w.getWord().trim() + "</w>\n");
//        }
//        writer.println("</wordlist>");
//        writer.close();
        
        GaiaDictParser gaia = new GaiaDictParser("uk_wordlist.xml");
        int maxFreq = 0;
        for (Word w:gaia.wordList) {
            if (w.getFreq() > maxFreq) {
                maxFreq = w.getFreq();
            }
        }
        
        PrintWriter writer = new PrintWriter("new_uk_wordlist.xml", "UTF-8");
        writer.println("<wordlist locale=\"ro\" description=\"Română\" date=\"1408019089\" version=\"2\">");
        for (Word w:gaia.wordList) {
            //int newFreq = (int)Math.ceil(Math.log(((double)maxFreq) / ((double)w.getFreq())) / Math.log(1.073913) + 0.5);
            int newFreq = (int)Math.ceil(Math.log(((double)maxFreq) / ((double)w.getFreq())) / Math.log(1.05622) + 0.5);
            writer.print(" <w f=\"" + newFreq + "\" flags=\"\">" + w.getWord().trim() + "</w>\n");
        }
        writer.println("</wordlist>");
        writer.close();
        
    }

}
