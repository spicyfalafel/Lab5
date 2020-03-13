package Commands;

import Exceptions.NoSuchCommandException;
import Exceptions.NoSuchDragonException;
import Exceptions.WrongArgumentsNumberException;

import java.util.HashMap;

/**
 * шаблон Команда.
 * вызывает команды
 */
public class CommandsInvoker {


    // проверка команд на правильность ввода тоже тут.

    private HashMap<String, Command> registeredCommands = new HashMap<>();

    /**
     * ИНВОКЕР ЭТО ПОСЕТИТЕЛЬ РЕСТОРАНА
     * РЕСТОРАН ПОКА ЧТО МАЛ, ПОСЕТИТЕЛЬ ОДИН: ШАБЛОН СИНГЛТОН
     * в случае программы инвокер это то что вызывает команды.
     * не нужно же такого больше одного
     *
     */
    private static CommandsInvoker instance;

    /**
     * Get instance commands invoker.
     *
     * @return the commands invoker
     */
    public static CommandsInvoker getInstance(){
        if (instance == null) {
            instance = new CommandsInvoker();
        }
        return instance;
    }
    private CommandsInvoker(){
    }

    /**
     * регистрирует команду, т.е. сопоставляет строчку с самой командой
     *
     * @param commandName строка, по которой будет вызываться команда
     * @param command     сама команда
     */
    public void register(String commandName, Command command){
        registeredCommands.put(commandName, command);
    }

    /**
     * метод для выполнения команды
     *
     * @param commandName имя команды
     * @param arguments   аргументы
     * @throws NoSuchCommandException        если команда неправильно введена
     * @throws WrongArgumentsNumberException если аргументов не то количество что нужно
     * @throws NoSuchDragonException         если не нашло какого-то дракона
     */
    public void execute(String commandName, String[] arguments) throws NoSuchCommandException,
                                                                        WrongArgumentsNumberException, NoSuchDragonException {
        if(registeredCommands.containsKey(commandName)){
            Command command = registeredCommands.get(commandName);
            int requiredArgs = command.getNumberOfRequiredArgs();
            if(requiredArgs == arguments.length){
               command.execute(arguments);
            }else{
                throw new WrongArgumentsNumberException(requiredArgs, arguments.length);
            }
        }else{
            throw new NoSuchCommandException(commandName);
        }
    }

    /**
     * используется, например, в команде help
     *
     * @return мапа зарегистрированных команд
     */
    public HashMap<String, Command> getMapOfRegisteredCommands(){
        return registeredCommands;
    }
}