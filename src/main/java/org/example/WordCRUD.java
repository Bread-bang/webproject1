package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class WordCRUD implements ICRUD{
    LinkedHashSet<Word> words;

    Scanner sc;
    WordCRUD(Scanner sc){
        words = new LinkedHashSet<>();
        this.sc = sc;
    }

    @Override
    public Object add() {
        System.out.print("=> 난이도(1, 2, 3) & 새 단어 입력 : ");
        int level = sc.nextInt();
        String word = sc.nextLine();
        System.out.print("뜻 입력 : ");
        String meaning = sc.nextLine();
        return new Word(0, level, word, meaning);
    }

    public void addWord(){
        Word word = (Word)add();
        if(words.add(word))
            System.out.println("[Notice] 새 단어가 단어장에 추가 되었습니다.");
        else
            System.out.println("[Notice] 이미 단어장에 있습니다.");
    }

    @Override
    public int update(Object obj) {
        return 0;
    }

    @Override
    public int delete(Object obj) {
        return 0;
    }

    @Override
    public void selectOne(int id) {

    }

    public void listAll(){
        System.out.println("--------------------------------");
        int i = 1;
        for (Word word : words) {
            System.out.println(i + "  " + word.toString());
            i++;
        }
        System.out.println("--------------------------------");
    }
}
