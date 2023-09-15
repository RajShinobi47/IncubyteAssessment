import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SpacecraftTest {
    private Spacecraft spacecraft;

    @BeforeEach
    public void setUp() {
        spacecraft = new Spacecraft(0, 0, 0, "N");
    }

    @Test
    public void testMoveForward() {
        spacecraft.moveForward();
        assertEquals(1, spacecraft.getY());
    }

    @Test
    public void testMoveBackward() {
        spacecraft.moveBackward();
        assertEquals(-1, spacecraft.getY());
    }

    @Test
    public void testTurnLeft() {
        spacecraft.turnLeft();
        assertEquals("W", spacecraft.getDirection());
    }

    @Test
    public void testTurnRight() {
        spacecraft.turnRight();
        assertEquals("E", spacecraft.getDirection());
    }

    @Test
    public void testTurnUp() {
        spacecraft.turnUp();
        assertEquals("Up", spacecraft.getDirection());
    }

    @Test
    public void testTurnDown() {
        spacecraft.turnDown();
        assertEquals("Down", spacecraft.getDirection());
    }

    @Test
    public void testMultipleCommands() {
        spacecraft.executeCommands("frbuld");
        assertEquals(1, spacecraft.getX());
        assertEquals(1, spacecraft.getY());
        assertEquals(0, spacecraft.getZ());
        assertEquals("Up", spacecraft.getDirection());
    }
}
