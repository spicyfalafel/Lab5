package Commands;

public class RemoveByIdCommand extends Command {
    public RemoveByIdCommand(CommandReceiver receiver) {
        super(receiver);
    }

    @Override
    public int getNumberOfRequiredArgs() {
        return 1;
    }

    @Override
    public void execute(String[] cmdArgs) {
        receiver.getCollection().removeById(Integer.parseInt(cmdArgs[0]));
    }
}
