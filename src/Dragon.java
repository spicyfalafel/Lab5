import java.util.Date;

public class Dragon {

    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    //TODO проверить
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private int age; //Значение поля должно быть больше 0
    private float wingspan; //Значение поля должно быть больше 0
    private DragonType type; //Поле может быть null
    private DragonCharacter character; //Поле не может быть null
    private Person killer; //Поле может быть null

    private static long idInc = 0;

    /**
     * Конструктор со всеми не автогенерируемыми полями
     * @param name
     * @param coordinates
     * @param age
     * @param wingspan
     * @param type
     * @param character
     * @param killer
     */
    public Dragon(String name, Coordinates coordinates,int age, float wingspan,
                  DragonType type, DragonCharacter character, Person killer){
        this.name = name;
        this.coordinates = coordinates;
        this.age = age;
        this.wingspan = wingspan;
        this.type = type;
        this.character = character;
        this.killer = killer;
        generateId();
    }

    /**
     * Конструктор со всеми не автогенерируемыми полями и без тех полей, которые могут быть null.
     * @param name
     * @param coordinates
     * @param age
     * @param wingspan
     * @param character
     */
    public Dragon(String name, Coordinates coordinates,int age, float wingspan,
                  DragonCharacter character){
        this.name = name;
        this.coordinates = coordinates;
        this.age = age;
        this.wingspan = wingspan;
        this.character = character;
        generateId();
    }
    public void setKiller(Person killer){
        this.killer = killer;
    }
    public void setType(DragonType type){
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public int getAge() {
        return age;
    }

    public float getWingspan() {
        return wingspan;
    }

    public DragonType getType() {
        return type;
    }

    public DragonCharacter getCharacter() {
        return character;
    }

    public Person getKiller() {
        return killer;
    }

    private void generateId(){
        this.id = idInc++;
    };

    public String getAllInfoColumn(){
        //если будет время можно рефлексией наверно
        return "id: " + this.id +"\n" +
                "name: " + this.name + "\n" +
                "coordinates: " + coordinates.getX().toString() + ", " +coordinates.getY() + "\n" +
                "creationDate: " + this.creationDate.toString() + "\n" +
                "age: " + this.age + "\n" +
                "wingspan: " + this.wingspan + "\n" +
                "type: " + this.type + "\n" +
                "character: " + this.character + "\n" +
                "killer: " + this.killer + "\n";
        //быстрее ли через StringBuilder?
    }
}