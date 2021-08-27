package model;

import model.exceptions.DuplicateQuestionException;
import model.exceptions.DuplicateTagException;
import model.exceptions.QuestionNotFoundException;

import java.util.ArrayList;

public class ProblemBank {
    ArrayList<Question> questions;
    ArrayList<Tag> tags;

    public ProblemBank(ArrayList<Question> questions, ArrayList<Tag> tags) {
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

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void addTag(Tag tag) {
        tags.add(tag);
    }

    public void addTagToExistingQuestion(Tag tag, Question question) throws QuestionNotFoundException, DuplicateQuestionException, DuplicateTagException {
        if (!questions.contains(question)) {
            throw new QuestionNotFoundException(question.getName());
        }
        if (!tags.contains(tag)) {
            tags.add(tag);
        }
        question.addTag(tag);
    }
}
