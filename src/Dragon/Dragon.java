package Dragon;

import java.util.Date;

public class Dragon implements Comparable<Dragon>{

    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    
    private String name; //Поле не может быть null, Строка не может быть пустой

    private Coordinates coordinates; //Поле не может быть null
    //TODO проверить
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private int age; //Значение поля должно быть больше 0
    private float wingspan; //Значение поля должно быть больше 0
    private DragonType type; //Поле может быть null
    private DragonCharacter character; //Поле не может быть null
    private Person killer; //Поле может брыть null

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
    public Dragon(String name, Coordinates coordinates, int age, float wingspan,
                  DragonType type, DragonCharacter character, Person killer){
        this.name = name;
        this.coordinates = coordinates;
        this.age = age;
        this.wingspan = wingspan;
        this.type = type;
        this.character = character;
        this.killer = killer;
        creationDate = new Date();
        generateId();
    }

    /**
     * ИСПОЛЬЗУЮ ТОЛЬКО ДЛЯ КОМАНДЫ ОБНОВЛЕНИЯ ПО ID. КОСТЫЛЬ.
     * @param id
     * @param name
     * @param coordinates
     * @param age
     * @param wingspan
     * @param type
     * @param character
     * @param killer
     */
    public Dragon(Long id, String name, Coordinates coordinates, int age, float wingspan, DragonType type,
                  DragonCharacter character, Person killer){
        this.name = name;
        this.coordinates = coordinates;
        this.age = age;
        this.wingspan = wingspan;
        this.type = type;
        this.character = character;
        this.killer = killer;
        creationDate = new Date();
        this.id = id;
    }

    public float getValue(){
        return this.wingspan*this.age;
    }

    public Dragon(String name, Coordinates coordinates, int age, float wingspan,
                  DragonCharacter character){
        this.name = name;
        this.coordinates = coordinates;
        this.age = age;
        this.wingspan = wingspan;
        this.character = character;
        generateId();
        creationDate = new Date();
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
        //this.id = (idInc-=-1);
    }

    public String getAllInfoColumn(){
        //если будет время можно рефлексией наверно
        StringBuilder builder = new StringBuilder();
        builder.append("id: ").append(this.id).append("\n")
                .append("name: ").append(this.name).append("\n")
                .append("coordinates: ").append(coordinates.getX().toString())
                .append(", ").append(coordinates.getY()).append("\n")
                .append("creationDate: ").append(this.creationDate.toString()).append("\n")
                .append("age: ").append(this.age).append("\n")
                .append("wingspan: ").append(this.wingspan).append("\n")
                .append("type: ").append((type == null) ? "null" : this.type.toString()).append("\n")
                .append("character: ").append(this.character.toString()).append("\n")
                .append("killer: ").append((this.killer==null) ? "null" : this.killer.toString()).append("\n");
        return builder.toString();
        //быстрее ли через StringBuilder?
    }
    // небезопасно
    public void changeId(long id){
        this.id = id;
    }


    @Override
    public int compareTo(Dragon dragon) {
        // не люблю плохих драконов
        if(dragon.getCharacter().equals(DragonCharacter.EVIL)
                && !(this.getCharacter().equals(DragonCharacter.EVIL))){
            return 1;
        }
        return Float.compare(getValue(), dragon.getValue());
    }
}