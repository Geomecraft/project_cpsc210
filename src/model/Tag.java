package model;

import model.exceptions.DuplicateQuestionException;
import model.exceptions.DuplicateTagException;

import java.util.ArrayList;
import java.util.Objects;

public class Tag {
    String name;
    ArrayList<Question> questions; //refers to the name of the question

    public Tag(String name, ArrayList<Question> questions) {
        this.name = name;
        this.questions = questions;
    }

    public Tag(Tag tag) {
        this.name = tag.name;
        this.questions = tag.questions;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

//    public void setQuestions(ArrayList<Question> questions) {
//        this.questions = questions;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tag tag = (Tag) o;
        return Objects.equals(this.hashCode(), tag.hashCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }



    //actual methods
    //EFFECTS: add the question to this tag, throw duplicateQuestionException if
    // the question is already connect to this tag
    //MODIFIES: this
    public void addQuestion(Question question) throws DuplicateTagException, DuplicateQuestionException {
        if (questions.contains(question)) {
            throw new DuplicateQuestionException(question.name);
        }
        this.questions.add(question);
        if (!question.getTags().contains(this)) {
            question.addTag(this);
        }
    }

//    public void deleteQuestion(String questionName) throws QuestionNotFoundException{
//        if (!questions.contains(questionName)){
//            throw new QuestionNotFoundException(questionName);
//        }
//        this.questions.remove(questionName);
//    }
}
