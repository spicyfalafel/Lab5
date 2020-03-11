package Commands;

import Dragon.*;

import java.util.Scanner;

public class UpdateIdCommand extends Command{
    public UpdateIdCommand(CommandReceiver receiver) {
        super(receiver);
    }

    @Override
    public int getNumberOfRequiredArgs() {
        return 1;
    }

    @Override
    public void execute(String[] cmdArgs) {
        while(true){
            try{
                Scanner sc = new Scanner(System.in);
                InputHelper inputHelper = new InputHelper(sc);
                long id = Long.parseLong(cmdArgs[0].trim());
                receiver.getCollection().removeById(id);
                Dragon dr = inputHelper.scanDragon("дракон");
                dr.changeId(id);
                System.out.println("Дракон добавлен успешно!");
            }catch (NumberFormatException e){
                System.out.println("ID - это число");
            }
        }
    }
}