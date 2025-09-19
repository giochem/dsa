import java.util.*;

class Spreadsheet {
    Map<String, Integer> spreadsheet = new HashMap<>();

    public Spreadsheet(int rows) {
        for (char ch = 'A'; ch <= 'Z'; ++ch) {
            for (int j = 1; j <= rows; ++j) {
                String cellName = ch + Integer.toString(j);
                spreadsheet.put(cellName, 0);
            }
        }
    }

    public void setCell(String cell, int value) {
        spreadsheet.put(cell, value);
    }

    public void resetCell(String cell) {
        spreadsheet.put(cell, 0);
    }

    public int getValue(String formula) {
        String[] cells = formula.substring(1).split("\\+");
        int num1 = spreadsheet.containsKey(cells[0]) ? spreadsheet.get(cells[0]) : Integer.parseInt(cells[0]);
        int num2 = spreadsheet.containsKey(cells[1]) ? spreadsheet.get(cells[1]) : Integer.parseInt(cells[1]);
        return num1 + num2;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */