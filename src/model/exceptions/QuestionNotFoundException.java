package model.exceptions;

public class QuestionNotFoundException extends NotFoundException {
    public QuestionNotFoundException(String questionName) {
        super("question named " + questionName);
    }
}
