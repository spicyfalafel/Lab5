package Commands;

/**
 * The type Print field ascending wingspan command.
 */
public class PrintFieldAscendingWingspanCommand extends Command {
    /**
     * Instantiates a new Print field ascending wingspan command.
     *
     * @param receiver the receiver
     */
    public PrintFieldAscendingWingspanCommand(CommandReceiver receiver) {
        super(receiver);
    }

    @Override
    public int getNumberOfRequiredArgs() {
        return 0;
    }

    @Override
    public void execute(String[] cmdArgs) {
        receiver.getCollection().printFieldAscendingWingspan();
    }

    @Override
    public String getDescription() {
        return "вывести значения поля wingspan в порядке возрастания";
    }
}
