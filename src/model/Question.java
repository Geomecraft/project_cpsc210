package model;

import model.exceptions.DuplicateTagException;

import java.util.ArrayList;

public abstract class Question {

    protected String name;
    protected String description;
    protected String answer;
    protected ArrayList<String> tags;
    protected int points;

    Question(){
    }

    Question(String name, String description, String answer, ArrayList<String> tags, int points){
        this.name = name;
        this.description = description;
        this.answer = answer;
        this.tags = tags;
        this.points = points;
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

    public ArrayList<String> getTags() {
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

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public void setPoints(int points) {
        this.points = points;
    }


    //actual methods
    //EFFECTS: add the tag to this question, throw duplicateTagException if the tag is already on this question
    //MODIFIES: this
    public void addTag(String tagName) throws DuplicateTagException{
        if (tags.contains(tagName)){
            throw new DuplicateTagException(tagName);
        }
        this.tags.add(tagName);
    }

    //EFFECTS: check if the recieved answer is the same as the intended answer
    public boolean checkAnswer(String response) {
        return (response.equals(this.answer));
    }


}
