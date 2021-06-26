package model.exceptions;

public abstract class NotFoundException extends Exception{
    public NotFoundException(String NotFoundObject){
        super("No " + NotFoundObject + " is found");
    }
}
