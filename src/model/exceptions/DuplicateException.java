package model.exceptions;

public abstract class DuplicateException extends Exception{
    public DuplicateException(String duplicatedObject){
        super(duplicatedObject + " already exists for this question");
    }
}
