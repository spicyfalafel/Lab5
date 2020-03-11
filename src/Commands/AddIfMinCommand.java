package Commands;

import java.util.Scanner;

public class AddIfMinCommand extends Command {
    public AddIfMinCommand(CommandReceiver receiver) {
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
        receiver.getCollection().
                addIfMin(helper.
                        scanDragon("дракона которого надо добавить если он минимальный"));
    }
}