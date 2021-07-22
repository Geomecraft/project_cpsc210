package model;

import model.exceptions.DuplicateQuestionException;
import model.exceptions.DuplicateTagException;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Question {

    protected String name;
    protected String description;
    protected String answer;
    protected ArrayList<Tag> tags;
    protected int points;

    Question(String name, String description, String answer, ArrayList<Tag> tags, int points) {
        this.name = name;
        this.description = description;
        this.answer = answer;
        this.tags = tags;
        this.points = points;
    }

    Question(Question question) {
        this.name = question.name;
        this.description = question.description;
        this.answer = question.answer;
        this.tags = question.tags;
        this.points = question.points;
    }



    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAnswer() {
        return answer;
    }

    public ArrayList<Tag> getTags() {
        return tags;
    }

    public int getPoints() {
        return points;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

//    public void setTags(ArrayList<Tag> tags) {
//        this.tags = tags;
//    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Question)) {
            return false;
        }
        Question question = (Question) o;
        return Objects.equals(this.hashCode(), question.hashCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }


    //actual methods
    //EFFECTS: add the tag to this question, throw duplicateTagException if the tag is already on this question
    //MODIFIES: this
    public void addTag(Tag tag) throws DuplicateTagException, DuplicateQuestionException {
        if (tags.contains(tag)) {
            throw new DuplicateTagException(tag.name);
        }
        this.tags.add(tag);
        if (!tag.getQuestions().contains(this)) {
            tag.addQuestion(this);
        }
    }

    //EFFECTS: check if the recieved answer is the same as the intended answer
    public boolean checkAnswer(String response) {
        return (response.equals(this.answer));
    }

}
