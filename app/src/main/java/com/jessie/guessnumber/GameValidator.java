package com.jessie.guessnumber;

import java.util.Arrays;
import java.util.List;

public class GameValidator {
    String result = "";

    public boolean isLengthValid(Answer answer) {
        List<String> numbers = answer.getNumbers();
        if (numbers.size() != 4) {
            result = ("请输入四个数字!");
            return false;
        } else {
            return true;
        }
    }

    public boolean isRepeated(Answer answer) {
        List<String> numbers = answer.getNumbers();
        int size = numbers.size();
        String[] verifyNumbersArr = numbers.toArray(new String[size]);
        Arrays.sort(verifyNumbersArr);
        for (int i = 1; i < size; i++) {
            if (verifyNumbersArr[i].equals(verifyNumbersArr[i - 1])) {
                result = ("请勿输入重复数字!");
                return true;
            }
        }
        return false;
    }

    public boolean isCorrect(Answer answer, Answer playerAnswer) {
        List<String> answerNumbers = answer.getNumbers();
        List<String> playerNumbers = playerAnswer.getNumbers();
        if (!answerNumbers.equals(playerNumbers)) {
            return false;
        } else {
            result = ("恭喜你答对了！正确答案是：" + (answer.getNumbers()));
            return true;
        }
    }
}

