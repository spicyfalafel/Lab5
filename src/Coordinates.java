public class Coordinates {
    private Integer x; //Поле не может быть null
    private long y;

    public Coordinates(Integer x, long y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public long getY() {
        return y;
    }
}
