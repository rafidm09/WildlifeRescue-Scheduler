import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test {

    @Test
    @DisplayName("Test Animal constructor with valid input")
    public void testAnimalConstructorValid() {
        Animal animal = new Animal(1, "Loner", "Coyote");
        Assertions.assertEquals(1, animal.getAnimalID());
        Assertions.assertEquals("Loner", animal.getAnimalNickname());
        Assertions.assertEquals("Coyote", animal.getAnimalSpecies());
    }

    @Test
    @DisplayName("Test Animal constructor with invalid input")
    public void testAnimalConstructorInvalid() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Animal(-1, null, ""));
    }

}

public class CoyoteTest {

    @Test
    @DisplayName("Test Coyote getters")
    public void testCoyoteGetters() {
        Coyote coyote = new Coyote(1, "Loner", "Coyote");
        Assertions.assertArrayEquals(new int[] {19, 20, 21}, coyote.getFeedWindow());
        Assertions.assertEquals(10, coyote.getPrepTime());
        Assertions.assertEquals(5, coyote.getFeedTime());
        Assertions.assertEquals(5, coyote.getCleanTime());
    }

}

public class BeaverTest {

    @Test
    @DisplayName("Test Beaver getters")
    public void testBeaverGetters() {
        Beaver beaver = new Beaver(1, "Biter", "Beaver");
        Assertions.assertArrayEquals(new int[] {8, 9, 10}, beaver.getFeedWindow());
        Assertions.assertEquals(0, beaver.getPrepTime());
        Assertions.assertEquals(5, beaver.getFeedTime());
        Assertions.assertEquals(5, beaver.getCleanTime());
    }

}

public class FoxTest {

    @Test
    @DisplayName("Test Fox getters")
    public void testFoxGetters() {
        Fox fox = new Fox(1, "Slinky", "Fox");
        Assertions.assertArrayEquals(new int[] {0, 1, 2}, fox.getFeedWindow());
        Assertions.assertEquals(5, fox.getPrepTime());
        Assertions.assertEquals(5, fox.getFeedTime());
        Assertions.assertEquals(5, fox.getCleanTime());
    }

}

public class PorcupineTest {

    @Test
    @DisplayName("Test Porcupine getters")
    public void testPorcupineGetters() {
        Porcupine porcupine = new Porcupine(1, "Prickly", "Porcupine");
        Assertions.assertArrayEquals(new int[] {19, 20, 21}, porcupine.getFeedWindow());
        Assertions.assertEquals(0, porcupine.getPrepTime());
        Assertions.assertEquals(5, porcupine.getFeedTime());
        Assertions.assertEquals(10, porcupine.getCleanTime());
    }

}

public class RaccoonTest {

    @Test
    @DisplayName("Test Raccoon getters")
    public void testRaccoonGetters() {
        Raccoon raccoon = new Raccoon(1, "Rocky", "Raccoon");
        Assertions.assertArrayEquals(new int[] {0, 1, 2}, raccoon.getFeedWindow());
        Assertions.assertEquals(0, raccoon.getPrepTime());
        Assertions.assertEquals(5, raccoon.getFeedTime());
        Assertions.assertEquals(5, raccoon.getCleanTime());
    }

}

