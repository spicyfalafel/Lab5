package Dragon;

public class Location {
    private int x;
    private Long y; //Поле не может быть null
    private Float z; //Поле не может быть null
    private String name; //Поле не может быть null

    public Location(int x, Long y, Float z, String name) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }

    @Override
    public String toString() {
        return x +" "+ y +" "+ z +" "+ name;
    }
}