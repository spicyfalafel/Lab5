package Commands;

import Dragon.*;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Scanner;

public class InputHelper {
    private Scanner sc;
    public InputHelper(Scanner sc){
        this.sc = sc;
    }

    // возможно этот метод уменьшает код
    // ПРИВАТНЫЙ ДЛЯ ВОЗМОЖНО ПУСТОЙ ЛИНИИ
    private String scanLine(String cheVvodit){
        System.out.println("введите " + cheVvodit);
        return sc.nextLine().trim();
    }
    // ПРИВАТНЫЙ ДЛЯ НЕПУСТОЙ ЛИНИИ
    private  String scanNotEmptyLine(String cheVvodit){
        String res = scanLine(cheVvodit);
        while(res.isBlank()) {
            System.out.println("Строка не должна быть пустой или состоять только из пробелов.");
            System.out.println("Введите " + cheVvodit + " заново.");
            res = sc.nextLine();
        }
        return res.trim();
    }
    // Все Стринговые аргументы в лабе не могут быть пустыми. Имена то есть.
    public String scanStringArg(String cheVvodit){
        String str = scanLine(cheVvodit);
        while(str==null || str.equals("")){
            System.out.println("Не может быть пустой. Введите " + cheVvodit + " еще раз.");
            str = sc.nextLine();
        }
        return str;
    }

    public Enum<?> scanEnum(String cheVvodit, boolean canBeNull, Class<? extends Enum> enumType){
        while(true) {
            String str = scanLine(cheVvodit);
            try {
                if (str.equals("") && canBeNull) return null;
                else if (str.equals("")){
                    throw new NullPointerException();
                }
                return Enum.valueOf(enumType, str);
            } catch (IllegalArgumentException | NullPointerException e) {
                System.out.println("введите нормально плиз");
            }
        }
    }
    public int scanInteger(String cheVvodit, boolean positiveOnly){
        while(true) {
            String input = scanNotEmptyLine(cheVvodit);
            int res;
            try{
                res = Integer.parseInt(input);
                if(positiveOnly && (res<=0)){
                    System.out.println("необходимо ввести число большее нуля");
                }else{
                    return res;
                }
            }catch (Exception e){
                System.out.println("введите нормально плиз");
            }
        }
    }
    public float scanFloat(String cheVvodit, boolean positiveOnly){
        while(true) {
            String input = scanNotEmptyLine(cheVvodit);
            float res;
            try{
                res = Float.parseFloat(input);
                if(positiveOnly && (res<=0)){
                    System.out.println("необходимо ввести число большее нуля");
                }else{
                    return res;
                }
            }catch (Exception e){
                System.out.println("введите нормально плиз");
            }
        }
    }
    public long scanLong(String cheVvodit, boolean positiveOnly){
        while(true) {
            String input = scanNotEmptyLine(cheVvodit);
            long res;
            try{
                res = Long.parseLong(input);
                if(positiveOnly && (res<=0)){
                    System.out.println("необходимо ввести число большее нуля");
                }else{
                    return res;
                }
            }catch (Exception e){
                System.out.println("введите нормально плиз");
            }
        }
    }
    public LocalDateTime scanLocalDateTimeNoNull(String cheVvodit){
        System.out.println(cheVvodit);
        int god = scanInteger("год", true);
        System.out.println("Доступные значения Month: ");
        Month mon;
        for(Month t : Month.values()){
            System.out.println(t + " ");
        }
        while(true){
            String str = scanNotEmptyLine(cheVvodit);
            try{
                mon = Month.valueOf(str);
                int day = scanInteger("день", true);
                return LocalDateTime.of(god, mon, day, 0, 0);
            }catch(IllegalArgumentException|NullPointerException e){
                System.out.println("введите нормально плиз");
            }catch (DateTimeException e){
                System.out.println("Число не то для месяца. еще раз");
            }
        }
    }
    public Location scanLocation(String cheVvodit){
        System.out.println("введите " + cheVvodit);
        int x = scanInteger("координата Х места", false);
        long y = scanLong("координата Y места", false);
        float z = scanFloat("координата Z места", false);
        String locName = scanStringArg("название места");
        return new Location(x, y, z, locName);
    }

    public Dragon scanDragon(String cheVvdoit){
        String name = scanStringArg("имя дракона");
        System.out.println("Координаты.");
        int x = scanInteger("Х", false);
        int y = scanInteger("Y", false);
        Coordinates coordinates = new Coordinates(x, y);
        int age = scanInteger("возраст дракона", true);
        float wingspan = scanFloat("размах крыльев (да, размах крыльев, да это число)", true);
        DragonType type = (DragonType) scanEnum("тип дракона", true, DragonType.class);
        DragonCharacter character = (DragonCharacter) scanEnum("характер дракона", false, DragonCharacter.class);
        Person killer = scanPerson("убийца дракона");
        return new Dragon(name, coordinates, age,
                wingspan, type, character, killer);
    }
    public Person scanPerson(String cheVvodit){
        System.out.println("введите " + cheVvodit);
        String name = scanLine("имя");
        if(name.equals("")) return null; // Person может быть пустым
        LocalDateTime birthday = scanLocalDateTimeNoNull("дата рождения");
        Color hairColor = (Color) scanEnum("цвет волос", true, Color.class);
        Country country = (Country) scanEnum("национальность", true, Country.class);
        Location loc = scanLocation("локацию");
        return new Person(name, birthday, hairColor, country, loc);
    }
}