package Commands;

public class PrintDescendingCommand extends Command {
    public PrintDescendingCommand(CommandReceiver receiver) {
        super(receiver);
    }

    @Override
    public int getNumberOfRequiredArgs() {
        return 0;
    }

    @Override
    public void execute(String[] cmdArgs) {
        receiver.getCollection().printDescending();
    }

    @Override
    public String getDescription() {
        return "вывести элементы коллекции в порядке убывания";
    }
}
