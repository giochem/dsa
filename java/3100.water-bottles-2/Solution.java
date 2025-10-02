class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int operation = 0;
        int extra = 0;
        while (numBottles > 0) {
            operation += numBottles;
            int empty = numBottles + extra;
            int full = 0;
            while (empty >= numExchange) {
                full++;
                empty -= numExchange;
                numExchange++;
            }
            extra = empty;
            numBottles = full;
        }
        return operation;
    }
}