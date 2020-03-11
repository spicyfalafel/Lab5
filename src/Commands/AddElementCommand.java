package Commands;

import Dragon.*;
import java.util.Scanner;

public class AddElementCommand extends Command {
    private Scanner sc = new Scanner(System.in);

    public AddElementCommand(CommandReceiver receiver) {
        super(receiver);
    }

    @Override
    public int getNumberOfRequiredArgs() {
        return 0;
    }

    // drakon1 10 10 18 15.5 WATER GOOD Slava GREEN RUSSIA 11 11 11 Divan

    @Override
    public void execute(String[] cmdArgs){
        InputHelper inputHelper = new InputHelper(sc);
        Dragon dr = inputHelper.scanDragon("дракон");
        receiver.getCollection().add(dr);
        System.out.println("Дракон добавлен успешно!");
    }

    @Override
    public String getDescription() {
        return "добавить новый элемент в коллекцию";
    }
}
