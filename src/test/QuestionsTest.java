package test;

import model.FreeResponse;
import model.MultipleChoice;
import model.Question;
import model.exceptions.DuplicateTagException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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
    public void testCheckAnswer(){

    }
}
