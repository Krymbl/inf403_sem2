package org.example;

import java.io.IOException;

public class CreatrQuestions {

    public static void main(String[] args) {
        Questions questions = createSampleQuestions();
        LoadAndSaves loadAndSaves = new LoadAndSaves();
        try {
            loadAndSaves.saveQuestions(questions);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Questions createSampleQuestions() {
        Questions questions = new Questions();

        questions.question1 = "Сколько океанов на земле?";
        questions.response1 = new String[]{"3", "4", "5"};
        questions.goodResponseIndex1 = 2;

        questions.question2 = "Сколько материков на земле?";
        questions.response2 = new String[]{"5", "6", "7"};
        questions.goodResponseIndex2 = 1;

        questions.question3 = "Столица России?";
        questions.response3 = new String[]{"Казань", "Санкт-Петербург", "Москва"};
        questions.goodResponseIndex3 = 2;

        return questions;
    }
}
