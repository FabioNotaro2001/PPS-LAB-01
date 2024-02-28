import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;
import org.junit.jupiter.api.Test;

import tdd.CircularList;
import tdd.CircularListImpl;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {
    CircularList list = new CircularListImpl();

    @Test
    void isInitiallyEmpty(){
        assertTrue(list.isEmpty());
    }

    @Test
    void correctSingleAdd(){
        list.add(1);
        assertAll(
            () -> assertFalse(list.isEmpty()),
            () -> assertEquals(1, list.size()));
    }

    @Test
    void correctMultipleAdd(){
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.size());
    }

    @Test
    void correctGetNext(){
        this.correctMultipleAdd();
        assertEquals(Optional.of(1), list.next());
    }

    @Test
    void correctFirstElementAsNextElement(){
        this.correctMultipleAdd();
        for(int i = 0; i < this.list.size(); i++){
            this.list.next();
        }
        assertEquals(Optional.of(1), this.list.next());
    }

    @Test
    void correctMultipleNext(){
        this.correctMultipleAdd();
        for(int i = 0; i < this.list.size(); i++){
            assertEquals(Optional.of(i + 1), this.list.next());
        }
    }

    @Test
    void correctGetPrevious(){
        this.correctMultipleNext();
        assertEquals(Optional.of(2), this.list.previous());
    }

    @Test
    void correctLastElementAsPreviousElement(){
        this.correctMultipleAdd();
        assertEquals(Optional.of(3), this.list.previous());
    }

    @Test
    void correctReset(){
        this.correctMultipleNext();
        this.list.reset();
        assertEquals( Optional.of(1), this.list.next());
    }
}
