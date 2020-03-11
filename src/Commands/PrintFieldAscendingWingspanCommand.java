package Commands;

public class PrintFieldAscendingWingspanCommand extends Command {
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
}
