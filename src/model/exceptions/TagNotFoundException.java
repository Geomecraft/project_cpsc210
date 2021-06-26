package model.exceptions;

public class TagNotFoundException extends NotFoundException{
    public TagNotFoundException(String tagName){
        super("tag named " + tagName);
    }
}
