package model.exceptions;

public class DuplicateQuestionException extends DuplicateException {
    public DuplicateQuestionException(String questionName) {
        super(questionName + " question");
    }
}
