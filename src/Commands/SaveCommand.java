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
            System.out.println("введите файл (с расширением)");
            XmlStaff.writeCollectionToFile(receiver.getCollection().getDragons(), cmdArgs[0]);
            System.out.println("save done");
        }catch (FileNotFoundException e){
            System.out.println("файл для сохранения не найден. возможно препод убрал права на файл или директорию.");
        }
    }

    @Override
    public String getDescription() {
        return "сохранить коллекцию в файл";
    }
}
