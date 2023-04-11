import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class Test {

    @Test
    public void testAnimalConstructorValid() {
        Animal animal = new Animal(1, "Loner", "Coyote");
        Assert.assertEquals(1, animal.getAnimalID());
        Assert.assertEquals("Loner", animal.getAnimalNickname());
        Assert.assertEquals("Coyote", animal.getAnimalSpecies());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAnimalConstructorInvalid() {
        new Animal(-1, null, "");
    }

}

public class CoyoteTest {

    @Test
    public void testCoyoteGetters() {
        Coyote coyote = new Coyote(1, "Loner", "Coyote");
        Assert.assertArrayEquals(new int[] {19, 20, 21}, coyote.getFeedWindow());
        Assert.assertEquals(10, coyote.getPrepTime());
        Assert.assertEquals(5, coyote.getFeedTime());
        Assert.assertEquals(5, coyote.getCleanTime());
    }

}

public class BeaverTest {

    @Test
    public void testBeaverGetters() {
        Beaver beaver = new Beaver(1, "Biter", "Beaver");
        Assert.assertArrayEquals(new int[] {8, 9, 10}, beaver.getFeedWindow());
        Assert.assertEquals(0, beaver.getPrepTime());
        Assert.assertEquals(5, beaver.getFeedTime());
        Assert.assertEquals(5, beaver.getCleanTime());
    }

}

public class FoxTest {

    @Test
    public void testFoxGetters() {
        Fox fox = new Fox(1, "Slinky", "Fox");
        Assert.assertArrayEquals(new int[] {0, 1, 2}, fox.getFeedWindow());
        Assert.assertEquals(5, fox.getPrepTime());
        Assert.assertEquals(5, fox.getFeedTime());
        Assert.assertEquals(5, fox.getCleanTime());
    }

}

public class PorcupineTest {

    @Test
    public void testPorcupineGetters() {
        Porcupine porcupine = new Porcupine(1, "Prickly", "Porcupine");
        Assert.assertArrayEquals(new int[] {19, 20, 21}, porcupine.getFeedWindow());
        Assert.assertEquals(0, porcupine.getPrepTime());
        Assert.assertEquals(5, porcupine.getFeedTime());
        Assert.assertEquals(10, porcupine.getCleanTime());
    }

}

public class RaccoonTest {

    @Test
    public void testRaccoonGetters() {
        Raccoon raccoon = new Raccoon(1, "Rocky", "Raccoon");
        Assert.assertArrayEquals(new int[] {0, 1, 2}, raccoon.getFeedWindow());
        Assert.assertEquals(0, raccoon.getPrepTime());
        Assert.assertEquals(5, raccoon.getFeedTime());
        Assert.assertEquals(5, raccoon.getCleanTime());
    }

}

public class TaskTest {

    @Test
    public void testTaskConstructor() {
        Task task = new Task(1, "Kit feeding", 30, 2);
        Assert.assertEquals(1, task.getTaskID());
        Assert.assertEquals("Kit feeding", task.getDescription());
        Assert.assertEquals(30, task.getDuration());
        Assert.assertEquals(2, task.getMaxWindow());
    }

    @Test
    public void testSetTaskID() {
        Task task = new Task(1, "Kit feeding", 30, 2);
        task.setTaskID(2);
        Assert.assertEquals(2, task.getTaskID());

        try {
            task.setTaskID(-1);
            Assert.fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Invalid taskID", e.getMessage());
        }
    }

    @Test
    public void testSetDescription() {
        Task task = new Task(1, "Kit feeding", 30, 2);
        task.setDescription("Rebandage leg wound");
        Assert.assertEquals("Rebandage leg wound", task.getDescription());

        try {
            task.setDescription(null);
            Assert.fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Invalid description", e.getMessage());
        }

        try {
            task.setDescription("");
            Assert.fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Invalid description", e.getMessage());
        }
    }

    @Test
    public void testSetDuration() {
        Task task = new Task(1, "Kit feeding", 30, 2);
        task.setDuration(20);
        Assert.assertEquals(20, task.getDuration());

        try {
            task.setDuration(-1);
            Assert.fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Invalid duration", e.getMessage());
        }
    }

    @Test
    public void testSetMaxWindow() {
        Task task = new Task(1, "Kit feeding", 30, 2);
        task.setMaxWindow(3);
        Assert.assertEquals(3, task.getMaxWindow());

        try {
            task.setMaxWindow(-1);
            Assert.fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Invalid maxWindow", e.getMessage());
        }
    }
}

