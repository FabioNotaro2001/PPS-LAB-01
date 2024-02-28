import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import thirdExercise.ThirdVersionCircularList;

public class ThirdVersionCircularListTest {
    ThirdVersionCircularList list = new ThirdVersionCircularList();

    @Test
    void correctMultipleAdd(){
        this.list.add(1);
        this.list.add(2);
        this.list.add(3);
        assertEquals(3, this.list.size());
    }

    @Test
    void correctFilteredNext(){
        this.correctMultipleAdd();
        assertEquals(Optional.of(3), this.list.filteredNext(element -> element > 2));
    }

    @Test 
    void correctFilteredNextByReturningAtTheBeginning(){
        this.list.add(1);
        this.list.add(2);
        this.list.add(2);
        this.list.add(2);
        this.list.next();
        assertEquals(Optional.of(1), this.list.filteredNext(element -> element != 2));
    }

    @Test
    void correctFilteredNextWhenConditionUnsatisfied(){
        this.correctMultipleAdd();
        assertEquals(Optional.empty(), this.list.filteredNext(element -> element > 10));

    }
    
    
}
