package test;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import java.io.IOException;

import static model.Try1.readSomeFile;
import static org.junit.Assert.assertEquals;

public class Try1Test {
    @Test
    public void testmethod() throws IOException {
        JSONObject myjson = readSomeFile();
        assertEquals(((JSONObject)myjson.get("result")).get("item"), "minecraft:oak_planks");
        assertEquals(((JSONObject)myjson.get("result")).get("count"), 4);
        assertEquals(((JSONObject)((JSONArray)myjson.get("ingredients")).get(0)).get("item"), "minecraft:oak_log");
        assertEquals(((JSONObject)myjson).get("type"), "minecraft:crafting_shaped");
    }
}
