class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int operation = 0;
        int extra = 0;
        while (numBottles > 0) {
            operation += numBottles;
            int empty = (numBottles + extra) % numExchange;
            numBottles = (numBottles + extra) / numExchange;
            extra = empty;
        }
        return operation;
    }
}