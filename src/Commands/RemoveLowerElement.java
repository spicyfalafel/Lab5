package Commands;

import Dragon.Dragon;

import java.util.Scanner;

public class RemoveLowerElement extends Command {
    public RemoveLowerElement(CommandReceiver receiver) {
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
}
