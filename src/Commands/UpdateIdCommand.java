package Commands;

import Dragon.*;
import java.util.Scanner;

/**
 * The type Update id command.
 */
public class UpdateIdCommand extends Command{
    /**
     * Instantiates a new Update id command.
     *
     * @param receiver the receiver
     */
    public UpdateIdCommand(CommandReceiver receiver) {
        super(receiver);
    }

    @Override
    public int getNumberOfRequiredArgs() {
        return 1;
    }


    /**
     * апдейтит дракона по указанному id. реализован так: сначала удаляет элемент,
     * потом создает новый и присваивает ему id прошлого.
     * @param cmdArgs id дракона для обновления
     */
    @Override
    public void execute(String[] cmdArgs) {
        try{
            Scanner sc = new Scanner(System.in);
            InputHelper inputHelper = new InputHelper(sc);
            long id = Long.parseLong(cmdArgs[0].trim());
            if(receiver.getCollection().removeById(id)){
                Dragon dr = inputHelper.scanDragon();
                dr.changeId(id);
                System.out.println("Дракон добавлен успешно!");
                receiver.getCollection().add(dr);
            }else{
                System.out.println("Дракона с id " + id + " в коллекции не нашлось.");
            }
        }catch (NumberFormatException e){
            System.out.println("ID - это число");
        }
    }

    @Override
    public String getDescription() {
        return "обновить значение элемента коллекции, id которого равен заданному";
    }
}