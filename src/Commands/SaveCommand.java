package Commands;

import XML.XmlStaff;

import java.io.FileNotFoundException;

/**
 * The type Save command.
 */
public class SaveCommand extends Command {
    /**
     * Instantiates a new Save command.
     *
     * @param receiver the receiver
     */
    public SaveCommand(CommandReceiver receiver) {
        super(receiver);
    }

    @Override
    public int getNumberOfRequiredArgs() {
        return 1;
    }

    @Override
    public void execute(String[] cmdArgs) {
        try{
            XmlStaff.writeCollectionToFile(receiver.getCollection().getDragons(), cmdArgs[0]);
            System.out.println("save done");
        }catch (FileNotFoundException e){
            System.out.println("файл для сохранения не найден. как эта ошибка вылезти может я еще не знаю.");
        }
    }

    @Override
    public String getDescription() {
        return "сохранить коллекцию в файл";
    }
}
