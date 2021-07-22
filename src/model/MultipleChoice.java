package model;

import java.util.ArrayList;

public class MultipleChoice extends Question {

    public MultipleChoice(String name, String description, String answer, ArrayList<Tag> tags, int points) {
        super(name,description,answer,tags,points);
    }

    public MultipleChoice(MultipleChoice mc) {
        super(mc);
    }

}
