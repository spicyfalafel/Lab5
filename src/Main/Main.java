package Main;

import Commands.*;
import Dragon.MyDragonsCollection;
import Exceptions.NoSuchCommandException;
import Exceptions.NotValidTypeOfArgumentException;
import Exceptions.WrongArgumentsNumberException;
import XML.XmlStaff;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    private static CommandReceiver mainReceiver;
    private static CommandsInvoker invoker;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = System.getenv("INPUT_PATH");
        System.out.println("имя файла, полученное из переменной окружения:" + fileName);
        MyDragonsCollection drakoniNelegalnie;
        try{
            File file = new File("input.xml");
            if (fileName != null) {
                file = new File(fileName);
                if(!file.exists() || file.isDirectory()) {
                    System.out.println("файла по пути " + file.getAbsolutePath() + " не нашлось, использую input.xml");
                    file = new File("input.xml");
                }
            }else{
                System.out.println("переменная равна null, использую input.xml");
            }
            drakoniNelegalnie = new MyDragonsCollection(XmlStaff.fromXmlToDragonList(file));
        }catch (FileNotFoundException|NullPointerException e){
            System.out.println("input.xml тоже не нашлось lol ну создавай сам коллекцию тогда");
            e.printStackTrace();
            drakoniNelegalnie = new MyDragonsCollection();
        }

        System.out.println("коллекция была получена из файла, посмотреть - show");
        System.out.println("help - помощь");
        //я клиент
        //вызывающий объект и несколько объектов команд принадлежат объекту клиента
        // Клиент решает, какие команды выполнить и когда.
        // Чтобы выполнить команду он передает объект команды объекту invoker.
        //TODO ВВОД КОТОРЫЙ ПРОВЕРЯЕТ отсутсвие прав доступа к файлу

        invoker = CommandsInvoker.getInstance();
        mainReceiver = new CommandReceiver(invoker.getMapOfRegisteredCommands(),
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

        while(!mainReceiver.userWantsToExit()){
            String userInput = scanner.nextLine().trim();
            executeCommand(userInput);
        }
        scanner.close();
    }
    public static void executeCommand(String userInput){
        String[] splitted = userInput.split(" ");
        String commandName = splitted[0];
        String[] arguments = new String[splitted.length-1];
        System.arraycopy(splitted, 1, arguments, 0, splitted.length - 1);
        try{
            invoker.execute(commandName, arguments);
        }catch(WrongArgumentsNumberException e) {
            System.out.println("введите команду с правильным количеством аргументов");
        }catch (NoSuchCommandException e){
            System.out.println("help покажет доступные команды. Осторожно, не опечатайтесь!");
        }catch (NoSuchElementException e){
            System.out.println("^D в моей программе не работает");
        }catch (StackOverflowError e){
            System.out.println("стэк сломан. поздравляю.");
        }catch (NotValidTypeOfArgumentException e){
            System.out.println("Не тот тип аргумента");
        }
    }
}
