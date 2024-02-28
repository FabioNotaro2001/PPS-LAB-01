package thirdExercise;

import java.util.Optional;
import java.util.function.Predicate;
import tdd.CircularListImpl;

public class ThirdVersionCircularList extends CircularListImpl{
    public Optional<Integer> filteredNext(Predicate<Integer> condition){
        for(int i = 0; i < list.size(); i++){
            Optional<Integer> nextElementInList = super.next();
            if(condition.test(nextElementInList.get())){
                return nextElementInList;
            }
        }
        return Optional.empty();
    }
    
}
