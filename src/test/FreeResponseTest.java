package test;

import model.FreeResponse;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class FreeResponseTest {
    FreeResponse fr1;

    @Before
    public void setup() {
        fr1 = new FreeResponse("Computer Science Principle Q1", "Why is code clone a bad idea?",
                "It takes resources to matain when modifying and causes coupling between methods and classes",
                new ArrayList<>(), 4);
    }

    @Test
    public void checkAnswerTest() {
        assertTrue(fr1.checkAnswer("I don't knwo the answer I didn't study"));
    }
}
