package Dragon;

import java.util.*;
import java.util.stream.Collectors;

public class MyDragonsCollection {

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

    /**
     * конструктор, который использую в чтении из файла
     * @param dragons
     */
    public MyDragonsCollection(HashSet<Dragon> dragons){
        creationDate = new Date();
        this.dragons = dragons;
    }

    public void show(){
        if(dragons.size() == 0) System.out.println("Коллекция пуста. Добавьте дракончиков.");
        for (Dragon d : dragons){
            System.out.println("----------");
            System.out.println(d.toString());
        }
    }
    public void clear(){
        dragons.clear();
    }
    public void add(Dragon dragon){
        this.dragons.add(dragon);
    }
    public void addIfMax(Dragon dragon){
        if(findMaxValue()<dragon.getValue()){
            add(dragon);
            System.out.println("Дракон добавлен");
        }
    }
    public void addIfMin(Dragon dragon){
        if(dragons.stream().anyMatch(d -> (d.getValue()<dragon.getValue()))){
            System.out.println("Не добавлен, т.к. не меньший");
        }else{
            add(dragon);
            System.out.println("Дракон добавлен");
        }
    }

    private ArrayList<Dragon> sorted(){
        ArrayList<Dragon> dr = new ArrayList<>(dragons);
        Collections.sort(dr);
        return dr;
    }

    /**
     * удалить из коллекции все элементы, меньшие, чем заданный
     * @param dragon
     */
    public void removeLower(Dragon dragon) {
        dragons.stream().filter(d -> d.getValue() < dragon.getValue()).
                forEach(dr -> {
                    System.out.println("Удален дракон с id " + dr.getId());
                    dragons.remove(dr);
                });
    }
    /**
     * фильтрует коллекцию, оставляет только тех, чьи имена начинаются с name
     * @param name является началом имени драконов которых нужно получить
     * @return
     */
    public HashSet<Dragon> filterStartsWithName(String name){
        HashSet<Dragon> dr = new HashSet<>();
        for (Dragon d : dragons){
            if(d.getName().trim().startsWith(name)){
                dr.add(d);
            }
        }
        return dr;
    }

    /**
     * простой метод для вывода коллекции в обратном порядке
     */
    public void printDescending(){
        ArrayList<Dragon> dr = sorted();
        for(Dragon d : dr){
            System.out.println(d.toString());
        }
    }
    public boolean removeById(long id){
        Dragon dragon = findById(id);
        if(dragon != null){
            this.dragons.remove(dragon);
            return true;
        }
        return false;
    }

    public float findMaxValue(){
        float maxRes = 0;
        for(Dragon dragon1 : dragons){
            if(dragon1.getValue()>maxRes) maxRes = dragon1.getValue();
        }
        return maxRes;
    }

    public Dragon findById(long id) {
        Iterator<Dragon> it = dragons.iterator();
        while (it.hasNext()) {
            Dragon dragon = it.next();
            if (dragon.getId() == id) {
                return dragon;
            }
        }
        return null;
    }

    public void printFieldAscendingWingspan(){
        Iterator<Dragon> it = dragons.iterator();
        HashSet<Float> a = new HashSet<>();
        while(it.hasNext()){
            a.add(it.next().getWingspan());
        }
        System.out.println(a);
    }

    public void printCollectionInfo(){
        System.out.println("Тип коллекции: Dragon");
        System.out.println("Дата инициализации: " + creationDate);
        System.out.println("Количество элементов: " + dragons.size());
    }

    public HashSet<Dragon> getDragons() {
        return dragons;
    }
}
