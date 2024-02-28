package tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList {
    protected List<Integer> list = new ArrayList<Integer>();
    protected int head = -1; // Pointer to the current element to be considered.

    @Override
    public void add(int element) {
        this.list.add(element);
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return this.list.size() == 0;
    }

    @Override
    public Optional<Integer> next() {
        this.head = this.head + 1;
        checkRestartFromFirstElement();
        return getCurrentElementPointedByHead();
    }

    private Optional<Integer> getCurrentElementPointedByHead() {
        return Optional.of(this.list.get(this.head));
    }

    private void checkRestartFromFirstElement() {
        if(this.head >= this.list.size()){
            this.head = 0;
        }
    }

    @Override
    public Optional<Integer> previous() {
        this.head = this.head - 1;
        this.checkRestartFromLastElement();
        return getCurrentElementPointedByHead();
    }

    private void checkRestartFromLastElement() {
        if(this.head < 0){
            this.head = this.list.size() - 1;
        }
    }

    @Override
    public void reset() {
        this.head = -1;
    }
}
