package io.github.twowinsh87.ch0402;

public class CarInventory {
    private int incomingCount;
    private int totalCount;

    public CarInventory(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getExpectedTotalCount(int incomingCount){
        return totalCount + incomingCount;
    }
}
