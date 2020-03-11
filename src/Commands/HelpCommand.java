package Commands;

public class HelpCommand extends Command {

    @Override
    public int getNumberOfRequiredArgs() {
        return 0;
    }

    public HelpCommand(CommandReceiver receiver){
        super(receiver);
    }
    @Override
    public void execute(String[] cmdArgs) {
        receiver.printHelp();
    }

    @Override
    public String getDescription() {
        return "вывести справку по доступным командам";
    }
}
