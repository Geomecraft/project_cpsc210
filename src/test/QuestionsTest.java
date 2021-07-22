package test;

import model.FreeResponse;
import model.MultipleChoice;
import model.Question;
import model.Tag;
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
    public void setup() {
        mc1 = new MultipleChoice("Calc 1 Derivative Q1",
                "What is the derivative of x^2 ?"
                        + "A. 1/3x^3"
                        + "B. 2x"
                        + "C. x"
                        + "D. 2",
                "B",
                new ArrayList<>(),
                2
                );
        q1 = mc1;

        fr1 = new FreeResponse("Calc 1 Derivative Q11",
                "What is the equation of tangent line at x=4 for function f(x)=(3x-5)^2 ?\n"
                        + "Show your work",
                "42(x-4)+49",
                new ArrayList<>(),
                4);
        q2 = fr1;
    }

    @Test
    public void getterAndSetterTest() {
        q1.setName("Calc 1 Antiderivative Q1");
        q1.setDescription("What is the antiderivative of x^2 ?\n"
                + "A. 1/3x^3\n"
                + "B. 2x\n"
                + "C. x\n"
                + "D. 2\n");
        q1.setAnswer("A");
        q1.setPoints(3);
        assertEquals(q1.getName(),"Calc 1 Antiderivative Q1");
        assertEquals(q1.getDescription(),"What is the antiderivative of x^2 ?\n"
                + "A. 1/3x^3\n"
                + "B. 2x\n"
                + "C. x\n"
                + "D. 2\n");
        assertEquals(q1.getAnswer(),"A");
        assertEquals(q1.getPoints(),3);
    }

    @Test
    public void testEquals() {
        Question q1Copy = new MultipleChoice(mc1);
        assertEquals(q1, q1);
        assertNotEquals(q1,"Calc 1 Derivative Q11");
        assertTrue(q1.equals(q1Copy) && q1Copy.equals(q1));
        assertTrue(q1.equals(mc1) && (mc1.equals(q1Copy)));
    }

    @SuppressWarnings("checkstyle:MethodLength")
    @Test
    public void testAddTag() {
        //Adding a tag normally
        Tag calc1 = new Tag("Calc 1", new ArrayList<>());
        try {
            q1.addTag(calc1);
        } catch (Exception e) {
            fail("An unexpected exception occured");
        }
        assertEquals(q1.getTags(), new ArrayList<>(Arrays.asList(calc1)));
        assertEquals(calc1.getQuestions(), new ArrayList<>(Arrays.asList(q1)));
        try {
            q1.addTag(calc1);
            fail("An Exception should have occured");
        } catch (DuplicateTagException e) { } catch (Exception e) {
            fail("An unexpected exception occured");
        }

        //Adding another tag when the tag already knows the question
        Tag calc1Knowsq1 = new Tag("Calc 1 version 2", new ArrayList<>(Arrays.asList(q1)));
        try {
            q1.addTag(calc1Knowsq1);
        } catch (Exception e) {
            fail("An unexpected exception occured");
        }
        assertEquals(q1.getTags(), new ArrayList<>(Arrays.asList(calc1, calc1Knowsq1)));
        assertEquals(calc1Knowsq1.getQuestions(), new ArrayList<>(Arrays.asList(q1)));
    }


    @Test
    public void testCheckAnswer() {
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

}
