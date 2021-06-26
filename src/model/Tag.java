package model;

import model.exceptions.DuplicateQuestionException;
import model.exceptions.QuestionNotFoundException;

import java.util.ArrayList;

public class Tag {
    String name;
    ArrayList<String> questions; //refers to the name of the question

    public Tag(String name, ArrayList<String> questions) {
        this.name = name;
        this.questions = questions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<String> questions) {
        this.questions = questions;
    }


    //actual methods
    //EFFECTS: add the question to this tag, throw duplicateQuestionException if the question is already connect to this tag
    //MODIFIES: this
    public void addQuestion(String questionName) throws DuplicateQuestionException {
        if (questions.contains(questionName)){
            throw new DuplicateQuestionException(questionName);
        }
        this.questions.add(questionName);
    }

    public void deleteQuestion(String questionName) throws QuestionNotFoundException{
        if (!questions.contains(questionName)){
            throw new QuestionNotFoundException(questionName);
        }
        this.questions.remove(questionName);
    }
}
