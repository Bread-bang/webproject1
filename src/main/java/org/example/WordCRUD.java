package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD{
    ArrayList<Word> list;
    Scanner sc;
    WordCRUD(Scanner sc){
        list = new ArrayList<>();
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
        Word one = (Word)add();
        list.add(one);
        System.out.println("새 단어가 단어장에 추가 되었습니다.");
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
}
