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

    /*
            ДА ТУТ МНОГО ПОЧТИ ОДИНАКОВЫХ МЕТОДОВ ДЛЯ ENUM'ОВ.
            задача:
                проверить правильность ввода значения Enum'а-аргумента
            как ее решить я не знаю.
     */

    // TODO CHECK
    // для характера дракона
    public DragonCharacter scanCharacterNotNull(String cheVvodit){
        System.out.println("Доступные значения DragonCharacter: ");
        for(DragonCharacter t : DragonCharacter.values()){
            System.out.println(t + " ");
        }
        while(true){
            String str = scanNotEmptyLine(cheVvodit);
            try{
                return DragonCharacter.valueOf(str);
            }catch(IllegalArgumentException|NullPointerException e){
                System.out.println("введите нормально плиз");
            }
        }
    }
    // для типа дракона
    public DragonType scanDragonTypeCanBeNull(String cheVvodit){
        System.out.println("Доступные значения DragonCharacter: ");
        for(DragonType t : DragonType.values()){
            System.out.println(t + " ");
        }
        while(true){
            String str = scanLine(cheVvodit);
            try{
                if(str.equals("")) return null;
                return DragonType.valueOf(str);
            }catch(NullPointerException|IllegalArgumentException e){
                System.out.println("введите нормально плиз");
            }
        }
    }
    public Color scanColor(String cheVvodit){
        System.out.println("Доступные значения Color: ");
        for(Color t : Color.values()){
            System.out.println(t + " ");
        }
        while(true){
            String str = scanLine(cheVvodit);
            try{
                if(str.equals("")) return null;
                return Color.valueOf(str);
            }catch(IllegalArgumentException|NullPointerException e){
                System.out.println("введите нормально плиз");
            }
        }
    }
    public Country scanCountry(String cheVvodit){
        System.out.println("Доступные значения Country: ");
        for(Country t : Country.values()){
            System.out.println(t + " ");
        }
        while(true){
            String str = scanLine(cheVvodit);
            try{
                if(str.equals("")) return null;
                return Country.valueOf(str);
            }catch(IllegalArgumentException|NullPointerException e){
                System.out.println("введите нормально плиз");
            }
        }
    }





    public int scanInteger(String cheVvodit){
        while(true) {
            String res = scanNotEmptyLine(cheVvodit);
            try{
                return Integer.parseInt(res);
            }catch (Exception e){
                System.out.println("введите нормально плиз");
            }
        }
    }

    public int scanIntegerPositive(String cheVvodit){
        int res=0;
        while(res<=0){
            res = scanInteger(cheVvodit);
        }
        return res;
    }

    public float scanFloat(String cheVvodit){
        while(true) {
            String res = scanNotEmptyLine(cheVvodit);
            try{
                return Float.parseFloat(res);
            }catch (Exception e){
                System.out.println("введите нормально плиз");
            }
        }
    }

    public float scanFloatPositive(String cheVvodit){
        float res=0;
        while(res<=0){
            res = scanFloat(cheVvodit);
        }
        return res;
    }

    public long scanLong(String cheVvodit){
        while(true) {
            String res = scanNotEmptyLine(cheVvodit);
            try{
                return Long.parseLong(res);
            }catch (Exception e){
                System.out.println("введите нормально плиз");
            }
        }
    }


    public LocalDateTime scanLocalDateTimeNoNull(String cheVvodit){
        System.out.println(cheVvodit);
        int god = scanIntegerPositive("год");
        System.out.println("Доступные значения Month: ");
        Month mon;
        for(Month t : Month.values()){
            System.out.println(t + " ");
        }
        while(true){
            String str = scanNotEmptyLine(cheVvodit);
            try{
                mon = Month.valueOf(str);
                int day = scanIntegerPositive("день");
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
        int x = scanInteger("координата Х места");
        long y = scanLong("координата Y места");
        float z = scanFloat("координата Z места");
        String locName = scanStringArg("название места");
        return new Location(x, y, z, locName);
    }

    public Dragon scanDragon(String cheVvdoit){
        String name = scanStringArg("имя дракона");
        System.out.println("Координаты.");
        int x = scanInteger("Х");
        int y = scanInteger("Y");
        Coordinates coordinates = new Coordinates(x, y);
        int age = scanIntegerPositive("возраст дракона");
        float wingspan = scanFloatPositive("размах крыльев (да, размах крыльев, да это число)");
        DragonType type = scanDragonTypeCanBeNull("тип дракона");
        DragonCharacter character = scanCharacterNotNull("характер дракона");
        Person killer = scanPerson("убийца дракона!");
        return new Dragon(name, coordinates, age,
                wingspan, type, character, killer);
    }
    public Person scanPerson(String cheVvodit){
        System.out.println("введите " + cheVvodit);
        String name = scanLine("имя");
        if(name.equals("")) return null;
        LocalDateTime birthday = scanLocalDateTimeNoNull("дата рождения");
        Color hairColor = scanColor("цвет волос");
        Country country = scanCountry("национальность");
        Location loc = scanLocation("локацию");
        return new Person(name, birthday, hairColor, country, loc);
    }
}