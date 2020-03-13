package Commands;

/**
 * шаблон Команда
 */
public abstract class Command implements Executable {
    /**
     * The Receiver.
     */
    protected CommandReceiver receiver;

    /**
     * у команд типа AddElement, AddIfMin, AddIfMax, UpdateIdCommand метод возвращает 0, т.к.
     * элемент вводится построчно
     *
     * @return количество аргументов у команды
     */
    abstract public int getNumberOfRequiredArgs();

    /**
     * Instantiates a new Command.
     *
     * @param receiver the receiver
     */
    public Command(CommandReceiver receiver){
        this.receiver = receiver;
    }

    /**
     * Get description string.
     *
     * @return описание команды
     */
    public String getDescription(){
        return "ленивый разработчик не написал описание команды";
    }
}
