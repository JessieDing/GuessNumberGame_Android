package com.jessie.guessnumber;

import java.util.List;

public class Answer {private List<String> numbers;

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
        int A = 0;
        int B = 0;
        for (int x = 0; x < 4; x++) {
            if (answerArr[x].equals(playerAnswerArr[x])) {
                A++;
            }
        }
        for (int y = 0; y < 4; y++) {
            for (int z = 0; z < 4; z++) {
                if (answerArr[y].equals(playerAnswerArr[z])) {
                    B++;
                    break;
                }
            }
        }
        B -= A;
        return A + "A" + B + "B";
    }
}
