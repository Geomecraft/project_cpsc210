package test;

import model.FreeResponse;
import model.MultipleChoice;
import model.Question;
import model.exceptions.DuplicateTagException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class QuestionsTest {
    Question q1;
    Question q2;

    MultipleChoice mc1;
    FreeResponse fr1;

    @Before
    public void setup(){
        mc1 = new MultipleChoice("Calc 1 Derivative Q1",
                "What is the derivative of x^2 ?" +
                        "A. 1/3x^3" +
                        "B. 2x" +
                        "C. x" +
                        "D. 2",
                "B",
                        new ArrayList<String>(),
                2
                );
        q1 = mc1;

        fr1 = new FreeResponse("Calc 1 Derivative Q11",
                "What is the equation of tangent line at x=4 for function f(x)=(3x-5)^2 ?\n" +
                        "Show your work",
                "42(x-4)+49",
                new ArrayList<String>(),
                4);
        q2 = fr1;
    }

    @Test
    public void testAddTag(){
        try {
            q1.addTag("Calc 1");
        }catch(Exception e){
            fail("An unexpected exception occured");
        }
        assertEquals(q1.getTags(), new ArrayList<String>(Arrays.asList("Calc 1")));
        try{
            q1.addTag("Calc 1");
            fail("An Exception should have occured");
        }catch(DuplicateTagException e){
            System.out.println(e.getMessage());
        }catch(Exception e){
            fail("An unexpected exception occured");
        }
    }

    @Test
    public void testCheckAnswerMC(){
        assertFalse(q1.checkAnswer("A"));
        assertTrue(q1.checkAnswer("B"));
        assertFalse(q1.checkAnswer("C"));
        assertFalse(q1.checkAnswer("D"));

        q1.setAnswer("A");
        assertTrue(q1.checkAnswer("A"));
        assertFalse(q1.checkAnswer("B"));
        assertFalse(q1.checkAnswer("C"));
        assertFalse(q1.checkAnswer("D"));
    }

    public void testCheckAnswerFR(){
        assertTrue(q2.checkAnswer("ugryk"));
        assertTrue(q2.checkAnswer("42(x-4)+49"));
    }
}
