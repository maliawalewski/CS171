/**
 * class to represent a position in a path
 */
public class Position {
    private int i;     //row
    private int j;     //column
    private char val;  //1, 0, or 'X'

    // reference to the previous position (parent) that leads to this position on a path
    private Position parent;

    /**
     *   Constructor for null parent
     *   @param i row
     *   @param j column
     *   @param v value: 1, 0, or X
     */
    public Position(int i, int j, char v){
        this.i = i; 
        this.j = j; 
        this.val = v;
        parent = null;
    }

    /**
     *   Constructor for non-null parent
     *   @param i row
     *   @param j column
     *   @param v value: 1, 0, or X
     *   @param p parent position
     */
    public Position(int i, int j, char v, Position p){
        this.i = i; 
        this.j = j;
        this.val = v;
        parent = p;
    }

    /**
     *   Override toString from Object
     *   @return String representation of object
     */
    @Override
    public String toString() {
        return "(" + i + "," + j + ")";
    }

    /**
      *  return Row
      *  @return row
      */
    public int getI() {
        return i;
    }

    /**
      *  return Column
      *  @return Column
      */
    public int getJ() {
        return j;
    }

    /**
      *  return Val
      *  @return value
      */
    public char getVal() {
        return val;
    }

    public void setVal(char val){
      this.val = val;
    }

    /**
      *  return parent
      *  @return parent
      */
    public Position getParent() {
        return parent;
    }


}
