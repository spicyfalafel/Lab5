package Commands;

public class ClearCommand extends Command {

    public ClearCommand(CommandReceiver receiver) {
        super(receiver);
    }

    @Override
    public int getNumberOfRequiredArgs() {
        return 0;
    }

    @Override
    public void execute(String[] cmdArgs) {
        receiver.getCollection().clear();
    }

    @Override
    public String getDescription() {
        return "очистить коллекцию";
    }
}
