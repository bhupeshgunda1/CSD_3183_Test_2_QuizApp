package com.example.QuizApp;

public class Question {
    private int _id;
    private String question;
    private String answer;


    public Question() {

    }

    public Question(int _id, String question, String answer) {
        this._id = _id;
        this.question = question;
        this.answer = answer;

    }

    public int get_id() {
        return _id;
    }


    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}


