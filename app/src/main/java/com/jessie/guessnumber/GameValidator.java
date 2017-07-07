package com.jessie.guessnumber;

import java.util.Arrays;
import java.util.List;

public class GameValidator {

    public boolean isRepeated(Answer answer) {
        List<String> numbers = answer.getNumbers();
        int size = numbers.size();
        String[] verifyNumbersArr = numbers.toArray(new String[size]);
        Arrays.sort(verifyNumbersArr);
        for (int i = 1; i < size; i++) {
            if (verifyNumbersArr[i].equals(verifyNumbersArr[i - 1])) {
                return true;
            }
        }
        return false;
    }
}

