import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

import secondExercise.SecondVersionCircularList;

public class SecondVersionCircularListTest {
    SecondVersionCircularList list = new SecondVersionCircularList();

    @Test
    void isInitiallyEmpty(){
        assertTrue(this.list.isEmpty());
    }

    @Test
    void correctSingleAdd(){
        this.list.add(1);
        assertAll(
            () -> assertFalse(this.list.isEmpty()),
            () -> assertEquals(1, this.list.size())
        );
    }

    @Test
    void correctMultipleAdd(){
        this.list.add(1);
        this.list.add(2);
        this.list.add(3);
        assertEquals(3, this.list.size());
    }

    @Test
    void correctGetForwardIterator(){
        this.correctMultipleAdd();
        Iterator<Integer> iteratorResult = this.list.forwardIterator();
        assertAll(
            () -> assertEquals(1, iteratorResult.next()),
            () -> assertEquals(2, iteratorResult.next()),
            () -> assertEquals(3, iteratorResult.next())
        ); 
    }

    @Test 
    void correctFirstElementAsNextElementCase(){
        this.correctMultipleAdd();
        Iterator<Integer> iteratorResult = this.list.forwardIterator();
        for(int i = 0; i < this.list.size(); i++){
            iteratorResult.next();
        }
        assertEquals(1, iteratorResult.next());
    }

    @Test
    void correctGetBackwardIterator(){
        this.correctMultipleAdd();
        Iterator<Integer> iteratorResult = this.list.backwardIterator();
        assertAll(
            () -> assertEquals(3, iteratorResult.next()),
            () -> assertEquals(2, iteratorResult.next()),
            () -> assertEquals(1, iteratorResult.next())
        ); 

    }

    @Test 
    void correctLastElementAsNextElementCase(){
        this.correctMultipleAdd();
        Iterator<Integer> iteratorResult = this.list.backwardIterator();
        for(int i = 0; i < this.list.size(); i++){
            iteratorResult.next();
        }
        assertEquals(3, iteratorResult.next());
    }

    @Test
    void emptyListCannotMoveForward(){
        assertThrows(IllegalStateException.class, () -> this.list.forwardIterator().next());
    }

    @Test
    void emptyListCannotMoveBackward(){
        assertThrows(IllegalStateException.class, () -> this.list.backwardIterator().next());
    }
    


}
