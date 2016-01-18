package firefoxdictionary;

import java.util.Objects;

/**
 *
 * @author Jobava
 */
class Word implements Comparable<Word> {

    private final String word;
    private final int freq;
    private final int originalFreq;

    public Word(String word, int freq, int originalFreq) {
        this.word = word;
        this.freq = freq;
        this.originalFreq = originalFreq;
    }

    @Override
    public String toString() {
        return "word=" + this.getWord() + "," + "f=" + this.getFreq() + "flags=,originalFreq=" + this.getOriginalFreq();
    }

    @Override
    public boolean equals(Object o) {
        if ((o == null) || (o.getClass() != this.getClass())) {
            return false;
        }
        Word other = (Word) o;
        return other.getWord().equals(this.getWord());
    }
    
    @Override
    public int compareTo(Word w) {
        if (w.getFreq() > this.getFreq()) {
            return 1;
        } else if (w.getFreq() < this.getFreq()) {
            return -1;
        }
        return 0;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.word);
        hash = 41 * hash + this.freq;
        hash = 41 * hash + this.originalFreq;
        return hash;
    }

    /**
     * @return the word
     */
    public String getWord() {
        return word;
    }

    /**
     * @return the freq
     */
    public int getFreq() {
        return freq;
    }

    /**
     * @return the originalFreq
     */
    public int getOriginalFreq() {
        return originalFreq;
    }
}
