package Commands;

import Dragon.MyDragonsCollection;

/**
 * The type Show command.
 */
public class ShowCommand extends Command {

    /**
     * Instantiates a new Show command.
     *
     * @param receiver the receiver
     */
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
