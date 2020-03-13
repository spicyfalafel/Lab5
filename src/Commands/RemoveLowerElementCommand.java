package Commands;

import Dragon.Dragon;

import java.util.Scanner;

/**
 * The type Remove lower element command.
 */
public class RemoveLowerElementCommand extends Command {
    /**
     * Instantiates a new Remove lower element command.
     *
     * @param receiver the receiver
     */
    public RemoveLowerElementCommand(CommandReceiver receiver) {
        super(receiver);
    }

    @Override
    public int getNumberOfRequiredArgs() {
        return 0;
    }

    @Override
    public void execute(String[] cmdArgs) {
        Scanner sc = new Scanner(System.in);
        InputHelper helper = new InputHelper(sc);
        Dragon dr = helper.scanDragon("дракона");
        receiver.getCollection().removeLower(dr);
    }

    @Override
    public String getDescription() {
        return "удалить из коллекции все элементы, меньшие, чем заданный";
    }
}
