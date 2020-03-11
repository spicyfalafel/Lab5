import java.sql.SQLOutput;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

public class MyDragonsCollection extends HashSet<Dragon>{

    /*
    Михаил, [29.02.20 21:42]
    Короче если будешь использовать jabx там понадобиться класс, который хранит в себе эту самую коллекцию

    Михаил, [29.02.20 21:43]
    У меня есть класс Collection

    Михаил, [29.02.20 21:43]
    И вся его суть хранить коллекцию элементов

    Михаил, [29.02.20 21:43]
    Для нормального парсинга

    Михаил, [29.02.20 21:46]
    Тупо приватное поле моей коллекции, геттер и сеттер🌚
     */

    private HashSet<Dragon> dragons;
    private Date creationDate;

    /**
     * Конструктор для пустой коллекции драконов
     */
    public MyDragonsCollection(){
        creationDate = new Date();
        dragons = new HashSet<>();
    }

    public MyDragonsCollection(HashSet<Dragon> dragons){
        this.dragons = dragons;
        creationDate = new Date();
    }

    public void show(){
        while(this.dragons.iterator().hasNext()){
            System.out.println(this.dragons.iterator().next().getAllInfoColumn());
        }
    }
    public void addIfMax(Dragon dragon){
        //TODO
        // if(dragons.)
    }

    public void addIfMin(Dragon dragon){

    }

    public void removeLower(Dragon dragon){

    }

    public void updateId(long id){
        Dragon dragon = findById(id);
        if(dragon != null){
            System.out.println("id поменяется автоматически.");
            System.out.println("введите имя");
            //TODO ВВОД
            //TODO ВСЕ ПРОВЕРИТЬ НА ВЕРНЫЙ ВВОД
            System.out.println("введите координаты. целые числа.");
            //TODO ВВОД (ТУТ Х И Y В РАЗНЫХ СТРОКАХ)
            System.out.println("введите возраст");
            //TODO ВВОД
            System.out.println("введите размах крыльев. или че это.");
            //TODO ВВОД
            System.out.println("введите тип дракона. Для ввода значений null использовать пустую строку. Enum'ы такие: ");
            for(DragonType type : DragonType.values()){
                System.out.print(type.toString() + " ");
            }
            //TODO ВВОД ЕНАМОВ
            // МОЖЕТ БЫТЬ null
            System.out.println("введите character. Enum'ы такие: ");
            for(DragonType type : DragonType.values()){
                System.out.print(type.toString() + " ");
            }
            //TODO
            System.out.println("введите killer. Для ввода значений null использовать пустую строку.");
            //пробелы считаются?
            //TODO

        }else{
            System.out.println("дракона с таким id найти не можем.");
        }
    }
    public MyDragonsCollection filterStartsWithName(String name){
        return null;
        //TODO
    }

    public void printDescending(){

    }
    //TODO прочекать
    public boolean removeById(long id){
        Dragon dragon = findById(id);
        if(dragon != null){
            this.dragons.remove(dragon);
            return true;
            }
        return false;
    }

    public Dragon findById(long id) {
        while (dragons.iterator().hasNext()) {
            Dragon dragon = dragons.iterator().next();
            if (dragon.getId() == id) {
                return dragon;
            }
        }
        return null;
    }

    public void printFieldAscendingWingspan(int wingspan){

    }
}
