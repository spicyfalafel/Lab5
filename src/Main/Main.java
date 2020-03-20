package Main;

import Commands.*;
import Dragon.MyDragonsCollection;
import Exceptions.NoSuchCommandException;
import Exceptions.NoSuchDragonException;
import Exceptions.WrongArgumentsNumberException;
import XML.XmlStaff;
import org.jdom2.JDOMException;
import org.jdom2.input.JDOMParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    private static CommandsInvoker invoker;
    private static String defaultFileName = "input.xml";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = System.getenv("INPUT_PATH");
        System.out.println("имя файла, полученное из переменной окружения:" + fileName);
        MyDragonsCollection drakoniNelegalnie;
        try {
            File file = new File("input.xml");
            if (fileName != null) {
                file = new File(fileName);
                if (!file.exists() || file.isDirectory()) {
                    System.out.println("xml файла по пути " + file.getAbsolutePath() + " не нашлось, использую input.xml");
                    file = new File("input.xml");
                    System.out.println(file.getAbsolutePath());
                }else{
                    System.out.println("Файл существует, попытаемся считать коллекцию");
                }
            }else{
                System.out.println("переменная равна null, использую input.xml");
            }
            drakoniNelegalnie = new MyDragonsCollection(XmlStaff.fromXmlToDragonList(file));
        }catch (FileNotFoundException | NullPointerException e) {
            System.out.println("файл не нашелся или нет прав на чтение.");
            drakoniNelegalnie = tryToGetFromDefaultFile();
        } catch (JDOMParseException e){
            System.out.println("Данный файл не удалось распарсить, проверьте правильность ввода данных.");
            drakoniNelegalnie = tryToGetFromDefaultFile();
        } catch (JDOMException e) {
            System.out.println("файл не получилось распарсовать");
            drakoniNelegalnie = tryToGetFromDefaultFile();
        }
        System.out.println("коллекция инициализована. show - показать коллекцию");
        System.out.println("help - помощь");
        //я клиент
        //вызывающий объект и несколько объектов команд принадлежат объекту клиента
        // Клиент решает, какие команды выполнить и когда.
        // Чтобы выполнить команду он передает объект команды объекту invoker.

        invoker = CommandsInvoker.getInstance();
        CommandReceiver mainReceiver = new CommandReceiver(invoker.getMapOfRegisteredCommands(),
                drakoniNelegalnie);
        invoker.register("info", new InfoCommand(mainReceiver));
        invoker.register("help", new HelpCommand(mainReceiver));
        invoker.register("exit", new ExitCommand(mainReceiver));
        invoker.register("clear", new ClearCommand(mainReceiver));
        invoker.register("remove_by_id", new RemoveByIdCommand(mainReceiver));
        invoker.register("add", new AddElementCommand(mainReceiver));
        invoker.register("show", new ShowCommand(mainReceiver));
        invoker.register("add", new AddElementCommand(mainReceiver));
        invoker.register("update", new UpdateIdCommand(mainReceiver));
        invoker.register("filter_starts_with_name", new FilterStartsWithNameCommand(mainReceiver));
        invoker.register("add_if_max", new AddIfMaxCommand(mainReceiver));
        invoker.register("add_if_min", new AddIfMinCommand(mainReceiver));
        invoker.register("remove_lower", new RemoveLowerElementCommand(mainReceiver));
        invoker.register("print_field_ascending_wingspan", new PrintFieldAscendingWingspanCommand(mainReceiver));
        invoker.register("print_descending", new PrintDescendingCommand(mainReceiver));
        invoker.register("save", new SaveCommand(mainReceiver));
        invoker.register("execute_script", new ExecuteScriptCommand(mainReceiver));

        // можно было идентифицировать имена команд через поле в самих классах команд
        // и использовать вместо HashMap<String, Commands.Command> ArrayList<Commands.Command>, но что,
        // если у меня появится два класса с одинаковыми значениями этого поля имени команды?
        // в мапе ключи уникальны
        // конечно, сама команда не знает своё имя, и наверно это плохо

        while (!mainReceiver.userWantsToExit()) {
            try {
                try {
                    String userInput = scanner.nextLine().trim();
                    executeCommand(userInput);
                } catch (NoSuchElementException e) {
                    if (!scanner.hasNext()) {
                        executeCommand("exit");
                    }
                }
            } catch (Exception e) {
                scanner = new Scanner(System.in);
            }
        }
    }

    public static void executeCommand(String userInput){
        String[] splitted = userInput.split(" ");
        String commandName = splitted[0];
        String[] arguments = new String[splitted.length - 1];
        System.arraycopy(splitted, 1, arguments, 0, splitted.length - 1);
        try {
            invoker.execute(commandName, arguments);
        } catch (WrongArgumentsNumberException e) {
            System.out.println("введите команду с правильным количеством аргументов");
        } catch (NoSuchCommandException e) {
            System.out.println("help покажет доступные команды. Осторожно, не опечатайтесь!");
        } catch (NoSuchElementException e) {
            System.out.println("^D в моей программе не работает");
        } catch (StackOverflowError e) {
            System.out.println("стэк сломан. поздравляю.");
        } catch (NoSuchDragonException e) {
            System.out.println("возможно, стоит изучить доступных драконов по команде show?");
        }
    }
    public static MyDragonsCollection tryToGetFromDefaultFile(){
        System.out.println("Попытаемся получить коллекцию из файла " + defaultFileName);
        try{
            return new MyDragonsCollection(XmlStaff.fromXmlToDragonList(new File(defaultFileName)));
        }catch (JDOMException e){
            System.out.println("Не удалось распарсить файл " + defaultFileName);
        } catch (FileNotFoundException e){
            System.out.println("Не удалось найти файл " + defaultFileName);
        }
        return new MyDragonsCollection();
    }
}
