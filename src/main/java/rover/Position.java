package rover;

import java.util.Objects;

public class Position {
     int x;
     int y;
     Cardinal facing;

    public Position(int x, int y, Cardinal facing) {
        this.x = x;
        this.y = y;
        this.facing = facing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y && facing == position.facing;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, facing);
    }
}
