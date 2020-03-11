import java.util.HashMap;
import java.util.Map;

public class CommandReceiver {
    HashMap<String, Command> allCommands = new HashMap<>();

    private boolean userWantsToExit = false;

    public boolean userWantsToExit() {
        return userWantsToExit;
    }

    public void printHelp(){
        for(Map.Entry<String, Command> entry : allCommands.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue().getDescription());
        }
    }

    public void exit(){
        userWantsToExit = true;
    }

}
