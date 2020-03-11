public class ExitCommand implements Command {
    CommandReceiver receiver;

    public ExitCommand(CommandReceiver receiver){
        this.receiver = receiver;
    }


    @Override
    public void execute() {
        System.out.println("byebye");
        receiver.exit();
    }

    @Override
    public String getDescription() {
        return "завершить программу (без сохранения в файл)";
    }
}
