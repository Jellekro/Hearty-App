package com.example.xdhacks;

<<<<<<< HEAD
import com.example.xdhacks.Activities.Ingredient;

=======
>>>>>>> 59bc76d2362f995250f2019884385a22860bbd97
import org.junit.Test;
import org.junit.Assert;

public class IngridientTest {
    @Test
    public void constrcutorTest() {
        Ingredient newI = new Ingredient("sauce",30);
        Assert.assertTrue(newI.getName() == "sauce");
        Assert.assertTrue(newI.getCalCount() == 30);
    }

    @Test
    public void equalsTrue() {
        Ingredient newI = new Ingredient("sauce",30);
        Ingredient newJ = new Ingredient("sauce",30);
        Assert.assertTrue(newI.equals(newJ));
    }

    @Test
    public void equalsFalse() {
        Ingredient newI = new Ingredient("sauce",30);
        Ingredient newJ = new Ingredient("saucy",30);
        Assert.assertFalse(newI.equals(newJ));
    }
}
