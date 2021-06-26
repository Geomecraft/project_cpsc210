package model;

import java.util.ArrayList;

public class problemBank {
    ArrayList<Question> questions;
    ArrayList<Tag> tags;

    public problemBank(ArrayList<Question> questions, ArrayList<Tag> tags) {
        this.questions = questions;
        this.tags = tags;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public ArrayList<Tag> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags;
    }
}
