package Commands;

import Exceptions.NoSuchCommandException;
import Exceptions.NotValidTypeOfArgumentException;
import Exceptions.PrepodLomaetMoyuProguException;
import Exceptions.WrongArgumentsNumberException;

import java.util.ArrayList;
import java.util.HashMap;

public class CommandsInvoker {
    // ИНВОКЕР ЭТО ПОСЕТИТЕЛЬ РЕСТОРАНА
    // РЕСТОРАН ПОКА ЧТО МАЛ, ПОСЕТИТЕЛЬ ОДИН: ШАБЛОН СИНГЛТОН
    // в случае программы инвокер это то что вызывает команды.
    // не нужно же такого больше одного

    // проверка команд на правильность ввода тоже тут.

    private static CommandsInvoker instance;

    private HashMap<String, Command> registeredCommands = new HashMap<>();

    public static CommandsInvoker getInstance(){
        if (instance == null) {
            instance = new CommandsInvoker();
        }
        return instance;
    }

    private CommandsInvoker(){
    }

    public void register(String commandName, Command command){
        registeredCommands.put(commandName, command);
    }
    public void execute(String commandName, String[] arguments) throws NoSuchCommandException,
                                                                        WrongArgumentsNumberException,
                                                                        NotValidTypeOfArgumentException,
                                                                        PrepodLomaetMoyuProguException {
        if(registeredCommands.containsKey(commandName)){
            // не забыть про пробелы перед командами
            Command command = registeredCommands.get(commandName);
            int requiredArgs = command.getNumberOfRequiredArgs();
            if(requiredArgs == arguments.length){
               if(requiredArgs != 0){
                    // тут какая-то проверка на то валидны аргументы или не TODO
                   command.execute(arguments);
               }else{
                   command.execute(arguments);
               }
            }else{
                throw new WrongArgumentsNumberException(requiredArgs, arguments.length);
            }
        }else{
            throw new NoSuchCommandException(commandName);
        }
    }
    public HashMap<String, Command> getMapOfRegisteredCommands(){
        return registeredCommands;
    }
}