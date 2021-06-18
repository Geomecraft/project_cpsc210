package model.exceptions;

public class DuplicateTagException extends Exception{
    public DuplicateTagException(String tag){
        super(tag + " tag already exists for this question");
    }
}
