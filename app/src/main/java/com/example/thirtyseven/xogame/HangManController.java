package com.example.thirtyseven.xogame;

/**
 * Created by ThirtySeven on 10.04.2017.
 */

class HangManController {

    private HangManModel model;

    public HangManController(HangManModel hangManModel) {
        model = hangManModel;
    }

    public void setWord(String word) {
        model.setWord(word);
    }

    public void acceptGuess(String letter) {
        if (model.getWord().contains(letter)){
            showLetter(letter);
        } else model.setGallowPart(model.getGallowPart() + 1);
    }

    private void showLetter(String letter) {
        model.setRiddle(findLetters(letter, model.getRiddle(), model.getWord()));
    }

    private String findLetters(char letter, String riddle, String word)
    {
        String updatedRiddle = "";
        int i = 0;
        char[] riddleArray = riddle.toCharArray();
        char[] wordArray = word.toCharArray();
        for (char symbol: wordArray) {
            if(symbol == letter) riddleArray[i]=letter;
            i++;
            updatedRiddle = String.copyValueOf(riddleArray);
        }
        return updatedRiddle;
    }
}
