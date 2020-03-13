package Commands;

public class FilterStartsWithNameCommand extends Command {
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
            System.out.println(receiver.getCollection().filterStartsWithName(cmdArgs[0]));
        }catch (Exception e){
            System.out.println("капут");
        }
    }

    @Override
    public String getDescription() {
        return "вывести элементы, значение поля name которых начинается с заданной подстроки";
    }
}
