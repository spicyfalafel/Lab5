package Commands;


import Exceptions.WrongArgumentsNumberException;

public class InfoCommand extends Command {
    @Override
    public int getNumberOfRequiredArgs() {
        return 0;
    }

    public InfoCommand(CommandReceiver receiver){
        super(receiver);
    }


    @Override
    public String getDescription() {
        return "вывести в стандартный поток вывода информацию о коллекции " +
                "(тип, дата инициализации, количество элементов и т.д.)";
    }

    @Override
    public void execute(String[] cmdArgs) {
            receiver.getCollection().printCollectionInfo();
    }
}
