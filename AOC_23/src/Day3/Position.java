package Day3;

public class Position {
    private int line, position;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    private int number = 0;
    public Position(int line, int position) {
        this.line = line;
        this.position = position;
    }

    public int getLine() {
        return line;
    }

    public int getPosition() {
        return position;
    }
}
