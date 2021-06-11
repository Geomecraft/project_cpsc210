package model;

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
    public void addTag(String tag){
        this.tags.add(tag);
    }


    public boolean checkAnswer(String response) {
        return (response.equals(this.answer));
    }


}
