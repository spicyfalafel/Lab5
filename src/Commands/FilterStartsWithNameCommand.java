package Commands;

import Dragon.Dragon;

import java.util.HashSet;
import java.util.Iterator;

/**
 * The type Filter starts with name command.
 */
public class FilterStartsWithNameCommand extends Command {
    /**
     * Instantiates a new Filter starts with name command.
     *
     * @param receiver the receiver
     */
    public FilterStartsWithNameCommand(CommandReceiver receiver) {
        super(receiver);
    }

    @Override
    public int getNumberOfRequiredArgs() {
        return 1;
    }

    @Override
    public void execute(String[] cmdArgs) {
        try{
            HashSet<Dragon> res = receiver.getCollection()
                    .filterStartsWithName(cmdArgs[0]);
            if(res.size()!=0){
                System.out.println("Элементов в коллекции имена которых начинаются" +
                        "со строки " + cmdArgs[0] + ": " + res.size());
                for (Dragon dragon : res) {
                    System.out.println(dragon.getAllInfoColumn());
                }
            }else{
                System.out.println("Драконов с именами начинающихся с " + cmdArgs[0] + " нет.");
            }
        }catch (Exception e){ //по-моему их тут быть не может
            System.out.println("капут");
        }
    }

    @Override
    public String getDescription() {
        return "вывести элементы, значение поля name которых начинается с заданной подстроки";
    }
}
