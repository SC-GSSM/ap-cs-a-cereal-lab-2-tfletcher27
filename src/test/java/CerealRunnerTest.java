import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Path;

public class CerealRunnerTest
{
    @BeforeEach
    public void resetCereals() throws Exception
    {
        Field cerealsField = CerealRunner.class.getDeclaredField("cereals");
        cerealsField.setAccessible(true);
        cerealsField.set(null, new ArrayList<Cereal>());
    }

    private void setCereals(ArrayList<Cereal> cereals) throws Exception
    {
        Field cerealsField = CerealRunner.class.getDeclaredField("cereals");
        cerealsField.setAccessible(true);
        cerealsField.set(null, cereals);
    }

    @Test
    public void filterCarbsPerCup_returns_only_cereals_in_inclusive_range() throws Exception
    {
        ArrayList<Cereal> cereals = new ArrayList<Cereal>();
        cereals.add(new Cereal("Low Crunch", 100, 2.0, 8.0, 0.5));
        cereals.add(new Cereal("Edge High", 110, 1.0, 9.0, 0.5));
        cereals.add(new Cereal("Edge Low", 90, 3.0, 17.0, 1.0));
        cereals.add(new Cereal("Too High", 120, 1.0, 19.0, 1.0));
        cereals.add(new Cereal("Quarter Cup", 80, 2.0, 4.5, 0.25));

        setCereals(cereals);

        ArrayList<Cereal> results = CerealRunner.filterCarbsPerCup(17, 18);

        assertEquals(3, results.size());
        assertEquals("Edge High", results.get(0).getName());
        assertEquals("Edge Low", results.get(1).getName());
        assertEquals("Quarter Cup", results.get(2).getName());
    }

    @Test
    public void highestPercentFiber_returns_cereal_with_greatest_fiber_per_calorie() throws Exception
    {
        ArrayList<Cereal> cereals = new ArrayList<Cereal>();
        cereals.add(new Cereal("Bran Bits", 100, 5.0, 20.0, 1.0));
        cereals.add(new Cereal("Fiber King", 120, 7.0, 18.0, 1.0));
        cereals.add(new Cereal("Light Crunch", 80, 3.0, 14.0, 1.0));

        setCereals(cereals);

        Cereal result = CerealRunner.highestPercentFiber();

        assertNotNull(result);
        assertEquals("Fiber King", result.getName());
    }

    @Test
    public void findNetCarbsPerCup_computes_carbs_minus_fiber_for_one_cup() 
    {
        Cereal cereal = new Cereal("Test Flakes", 100, 2.0, 14.0, 0.75);

        double result = CerealRunner.findNetCarbsPerCup(cereal);

        assertEquals(16.0, result, 0.0001);
    }

    @Test
    public void question4_includes_required_multiline_comment_answer() throws Exception
    {
        String source = Files.readString(Path.of("src/main/java/CerealRunner.java"));

        assertTrue(source.contains("All-Bran with Extra Fiber"),
                "question 4 should check All-Bran with Extra Fiber");
        assertTrue(source.contains("Apple Jacks"),
                "question 4 should check Apple Jacks");
        assertTrue(source.contains("Cocoa Puffs"),
                "question 4 should check Cocoa Puffs");

        assertTrue(
            source.toLowerCase().contains("/* question 4 answer"),
            "question 4 should include a written comment in CerealRunner.java");
    }
}
