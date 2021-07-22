package test;

import model.MultipleChoice;
import model.Question;
import model.Tag;
import model.exceptions.DuplicateQuestionException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class TagTest {
    Tag tag1;

    @Before
    public void setup() {
        tag1 = new Tag("Design Recipe", new ArrayList<>());
    }

    @Test
    public void getterAndSetterTest() {
        tag1.setName("Function");
        assertEquals(tag1.getName(), "Function");
    }

    @Test
    public void testEquals() {
        Tag tag1Copy = new Tag(tag1);
        assertEquals(tag1, tag1);
        assertNotEquals(tag1,null);
        assertNotEquals(tag1,"Design Recipe");
        assertTrue(tag1.equals(tag1Copy) && tag1Copy.equals(tag1));
    }


    @Test
    public void addQuestionNewTest() {
        MultipleChoice mc1 = new MultipleChoice("testQuestion", "no description", "none", new ArrayList<>(), 0);
        Question q1 = mc1;
        Question q1Copy = new MultipleChoice(mc1);
        try {
            tag1.addQuestion(q1);
        } catch (Exception e) {
            fail("An unexpected exception occured");
        }
        assertEquals(tag1.getQuestions(), new ArrayList<>(Arrays.asList(q1)));
        assertEquals(q1.getTags(), new ArrayList<>(Arrays.asList(tag1)));
        try {
            tag1.addQuestion(q1Copy);
            fail("An Exception should have occured");
        } catch (DuplicateQuestionException e) { } catch (Exception e) {
            fail("An unexpected exception occured");
        }
    }

    @Test
    public void addQuestionAlreadyKnowsTagTest() {
        MultipleChoice mc1 = new MultipleChoice("testQuestion",
                "no description", "none", new ArrayList<>(Arrays.asList(tag1)), 0);
        Question q1 = mc1;
        try {
            tag1.addQuestion(q1);
        } catch (Exception e) {
            fail("An unexpected exception occured");
        }
        assertEquals(tag1.getQuestions(), new ArrayList<>(Arrays.asList(q1)));
        assertEquals(q1.getTags(), new ArrayList<>(Arrays.asList(tag1)));
    }

}
