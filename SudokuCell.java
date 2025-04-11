
package myjava.sudokuproject;
public class SudokuCell {

    private int value;
    private boolean isEditable;

    public SudokuCell(int value, boolean isEditable) {
        this.value = value;
        this.isEditable = isEditable;
    }

    public int getValue() { return value; }
    public void setValue(int value) {
        if (isEditable) this.value = value;
    }
    public boolean isEditable() { return isEditable; }
}

