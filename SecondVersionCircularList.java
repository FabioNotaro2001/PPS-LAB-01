package secondExercise;

import java.util.ArrayList;
import java.util.List;

import java.util.Iterator;

public class SecondVersionCircularList {
    protected List<Integer> list = new ArrayList<>();

    public boolean isEmpty() {
        return this.list.size() == 0;
    }

    public void add(int element) {
        this.list.add(element);
    }

    public Integer size() {
        return this.list.size();
    }

    public Iterator<Integer> forwardIterator() {
        return new Iterator<Integer>() {
            int header = -1;

            @Override
            public boolean hasNext() {
                return list.size() != 0;
            }

            @Override
            public Integer next() {
                if(this.hasNext()){
                    header = header + 1;
                    if(this.header == list.size()){
                        header = 0;
                    }
                    return list.get(header);
                } else {
                    throw new IllegalStateException("Called next on empty iterator!");
                }
            }
        };
    }

    public Iterator<Integer> backwardIterator() {
        return new Iterator<Integer>() {
            int header = list.size();

            @Override
            public boolean hasNext() {
                return list.size() != 0;
            }

            @Override
            public Integer next() {
                if(this.hasNext()){
                    header = header - 1;
                    if(this.header < 0){
                        header = list.size() - 1;
                    }
                    return list.get(header);
                } else {
                    throw new IllegalStateException("Called next on empty iterator!");
                }
            }
        };
    }
}
