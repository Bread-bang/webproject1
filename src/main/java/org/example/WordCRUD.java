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
        word = word.trim();
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
    public void update() {
        Word target = null;

        // 단어 입력 받기
        System.out.print("수정할 단어를 입력하세요 : ");
        String wordToModify = sc.next();

        // 수정할 단어 가져오기
        try{
            target = (Word)selectOne(wordToModify);
        }catch(ClassCastException e) {
            System.out.println("해당 단어는 없습니다. 다시 시도해주세요!");
        }

        // 뜻 수정하기
        System.out.print("수정할 뜻을 알려주세요 : ");
        String modifiedMeaning = sc.next();
        target.setMeaning(modifiedMeaning);
    }

    @Override
    public void delete() {
        Word target = null;

        // 단어 입력 받기
        System.out.print("삭제할 단어를 입력하세요 : ");
        String wordToDelete = sc.next();

        // 수정할 단어 가져오기
        try{
            target = (Word)selectOne(wordToDelete);
        }catch(ClassCastException e) {
            System.out.println("해당 단어는 없습니다. 다시 시도해주세요!");
        }

        // 삭제
        words.remove(target);
    }

    @Override
    public Object selectOne(String wordToModify) {
        Word selected;
        for(Word word : words){
            if(word.getWord().equals(wordToModify)){
                selected = word;
                return selected;
            }
        }
        return 0;
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
