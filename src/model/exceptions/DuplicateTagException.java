package model.exceptions;

public class DuplicateTagException extends DuplicateException{
    public DuplicateTagException(String tagName){
        super(tagName + " tag");
    }
}
