public class HelpCommand implements Command{
    private CommandReceiver receiver;

    public HelpCommand(CommandReceiver receiver){
        this.receiver = receiver;
    }
    @Override
    public void execute() {
        receiver.printHelp();
    }

    @Override
    public String getDescription() {
        return "вывести справку по доступным командам";
    }
}
