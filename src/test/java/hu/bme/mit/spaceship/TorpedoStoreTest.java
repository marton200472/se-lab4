package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    @Test
    void fire_Success() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(true, result);
        assertEquals(0, store.getTorpedoCount());
    }

    @Test
    void fire_TorpedoFail() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1,1);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(false, result);
        assertEquals(1, store.getTorpedoCount());
    }

    @Test
    void fire_Fail_NotEnough() {
        // Arrange
        TorpedoStore store = new TorpedoStore(0);

        assertThrows(IllegalArgumentException.class, ()->store.fire(1));
    }

    @Test
    void fire_Fail_ZeroOrNeg() {
        // Arrange
        TorpedoStore store = new TorpedoStore(10);

        assertThrows(IllegalArgumentException.class, ()->store.fire(0));
        assertThrows(IllegalArgumentException.class, ()->store.fire(-1));
    }

    @Test
    void isEmpty_Empty() {
        TorpedoStore store = new TorpedoStore(0);
        assertEquals(true, store.isEmpty());
    }

    @Test
    void isEmpty_NotEmpty() {
        TorpedoStore store = new TorpedoStore(10);
        assertEquals(false, store.isEmpty());
    }
}
