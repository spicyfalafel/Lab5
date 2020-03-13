package Dragon;

import java.util.*;

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
    public MyDragonsCollection(HashSet<Dragon> dragons){
        creationDate = new Date();
        this.dragons = dragons;
    }
    public void show(){
        if(dragons.size() == 0) System.out.println("Коллекция пуста. Добавьте дракончиков.");
        for (Dragon d : dragons){
            System.out.println("----------");
            System.out.println(d.getAllInfoColumn());
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
            System.out.println("добавлен");
        }
    }
    public void addIfMin(Dragon dragon){
        if(dragons.iterator().next().getValue()<dragon.getValue()){
            add(dragon);
            System.out.println("добавлен");
        }
    }

    //  удалить из коллекции все элементы, меньшие, чем заданный
    public void removeLower(Dragon dragon){
        Iterator<Dragon> iterator = dragons.iterator();
        while(iterator.hasNext()){
            long id = dragon.getId();
            if(id == iterator.next().getId()){
                iterator.forEachRemaining(dragons::remove);
            }
        }
    }

    public HashSet<Dragon> filterStartsWithName(String name){
        HashSet<Dragon> dr = new HashSet<>();
        for (Dragon d : dragons){
            if(d.getName().trim().startsWith(name)){
                dr.add(d);
            }
        }
        return dr;
    }
    public void printDescending(){
        ArrayList<Dragon> dr = new ArrayList<>(dragons);
        Collections.reverse(dr);
        for(Dragon d : dr){
            System.out.println(d.getAllInfoColumn());
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
        while (dragons.iterator().hasNext()) {
            Dragon dragon = dragons.iterator().next();
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
        for(float t : a){
            System.out.println(a + " ");
        }
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