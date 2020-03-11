import Commands.*;
import Dragon.MyDragonsCollection;
import Exceptions.NoSuchCommandException;
import Exceptions.NotValidTypeOfArgumentException;
import Exceptions.PrepodLomaetMoyuProguException;
import Exceptions.WrongArgumentsNumberException;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //я мейн, я клиент
        //вызывающий объект и несколько объектов команд принадлежат объекту клиента
        // Клиент решает, какие команды выполнить и когда.
        // Чтобы выполнить команду он передает объект команды объекту invoker.
        //TODO ВВОД КОТОРЫЙ ПРОВЕРЯЕТ отсутсвие прав доступа к файлу

        MyDragonsCollection drakoniNelegalnie = new MyDragonsCollection();
        CommandsInvoker invoker = CommandsInvoker.getInstance();
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
        invoker.register("remove_lower", new RemoveLowerElement(mainReceiver));
        invoker.register("print_field_ascending_wingspan", new PrintFieldAscendingWingspanCommand(mainReceiver));
        invoker.register("print_descending", new PrintDescendingCommand(mainReceiver));

        // можно было идентифицировать имена команд через поле в самих классах команд
        // и использовать вместо HashMap<String, Commands.Command> ArrayList<Commands.Command>, но что,
        // если у меня появится два класса с одинаковыми значениями этого поля имени команды?
        // в мапе ключи уникальны
        // конечно, сама команда не знает своё имя, и наверно это плохо

        while(!mainReceiver.userWantsToExit()){
            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.nextLine().trim();
            String[] splitted = userInput.split(" ");
            String commandName = splitted[0];
            String[] arguments = new String[splitted.length-1];
            // научите меня нормально это реализовать
            for(int i = 1; i<splitted.length;i++){
                arguments[i-1] = splitted[i];
            }
            try{
                invoker.execute(commandName, arguments);
            }catch(NoSuchCommandException| WrongArgumentsNumberException| PrepodLomaetMoyuProguException|NotValidTypeOfArgumentException e){
                System.out.println("капут. давайте заново");
            }catch (NoSuchElementException e){
                System.out.println("^D в моей программе не работает");
            }
        }
    }
}
