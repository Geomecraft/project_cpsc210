package model;

import model.exceptions.DuplicateQuestionException;
import model.exceptions.DuplicateTagException;
import model.exceptions.QuestionNotFoundException;
import model.exceptions.TagNotFoundException;

import java.util.ArrayList;

public class ProblemBank {
    ArrayList<Question> questions;
    ArrayList<Tag> tags;
    ArrayList<Question> selected;

    public ProblemBank(ArrayList<Question> questions, ArrayList<Tag> tags, ArrayList<Question> selected) {
        this.questions = questions;
        this.tags = tags;
        this.selected = selected;
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

    public ArrayList<Question> getSelected() {
        return selected;
    }

    public void setSelected(ArrayList<Question> selected) {
        this.selected = selected;
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

    public void removeTagFromExistingQuestion(Tag tag, Question question) throws QuestionNotFoundException, TagNotFoundException {
        if (!questions.contains(question)) {
            throw new QuestionNotFoundException(question.getName());
        }

        if (!tags.contains(tag)) {
            throw new TagNotFoundException(tag.getName());
        }
    }
}
