package com.jessie.guessnumber;

import java.util.List;

public class Answer {
    private List<String> numbers;

    List<String> getNumbers() {
        return numbers;
    }

    void setNumbers(List<String> numbers) {
        this.numbers = numbers;
    }

    public String compareTo(Answer playerAnswer) {

        int size = numbers.size();
        String[] answerArr = numbers.toArray(new String[size]);
        String[] playerAnswerArr = playerAnswer.getNumbers().toArray(new String[size]);
        int countA = 0;
        int countB = 0;
        for (int x = 0; x < 4; x++) {
            if (answerArr[x].equals(playerAnswerArr[x])) {
                countA++;
            }
        }
        for (int y = 0; y < 4; y++) {
            for (int z = 0; z < 4; z++) {
                if (answerArr[y].equals(playerAnswerArr[z])) {
                    countB++;
                    break;
                }
            }
        }
        countB -= countA;
        return countA + "A" + countB + "B";
    }
}
