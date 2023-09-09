package org.example;

public class Word {
    private int level;
    private String word;
    private String meaning;

    public Word(){}

    public Word(int level, String word, String meaning) {
        this.level = level;
        this.word = word;
        this.meaning = meaning;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    @Override
    public String toString() {
        String slevel = "";
        for(int i = 0 ; i < level; i++)
            slevel += "*";

        String str = String.format("%-3s", slevel) + String.format("%15s", word) + "  " + meaning;
        return str;
    }

    public String toFileString(){
        return this.level + "|" + this.word + "|" + this.meaning;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (word == null ? 0 : word.hashCode());
        result = 31 * result + (meaning == null ? 0 : meaning.hashCode());

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Word) {
            Word temp = (Word) obj;
            return word.equals(temp.word) && meaning.equals(temp.meaning);
        }
        return false;
    }
}
