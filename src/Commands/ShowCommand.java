package Commands;

import Dragon.MyDragonsCollection;

public class ShowCommand extends Command {

    public ShowCommand(CommandReceiver receiver) {
        super(receiver);
    }


    @Override
    public int getNumberOfRequiredArgs() {
        return 0;
    }

    public String getDescription() {
        return "вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }

    @Override
    public void execute(String[] cmdArgs) {
        receiver.getCollection().show();
    }
}
