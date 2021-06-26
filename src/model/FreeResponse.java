package model;

import java.util.ArrayList;

public class FreeResponse extends Question{
    public FreeResponse(String name, String description, String answer, ArrayList<String> tags, int points){
        super(name,description,answer,tags,points);
    }

    @Override
    public boolean checkAnswer(String response){
        return true;
    }

}
