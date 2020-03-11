import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CommandsInvoker {
    private final HashMap<String, Command> commandMap = new HashMap<>();
    public void register(String commandName, Command command){
        commandMap.put(commandName, command);
    }
    public void execute(String commandName) throws NoSuchCommandException{
        if(commandMap.containsKey(commandName)){
            Command command = commandMap.get(commandName);
            command.execute();
        }else{
            throw new NoSuchCommandException(commandName);
        }
    }
    public ArrayList<String> getListOfRegisteredCommands(){
        return new ArrayList<>(commandMap.keySet());
    }
}
