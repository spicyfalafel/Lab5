package Commands;

import Commands.Command;
import Dragon.Dragon;
import Dragon.MyDragonsCollection;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CommandReceiver {
    // РЕСИВЕР ЭТО ПОВАР

    // У ПОВАРА ЕСТЬ УМЕНИЯ
    private HashMap<String, Command> registeredCommands;

    // У ПОВАРА ЕСТЬ ИНГРЕДИЕНТЫ
    private MyDragonsCollection collection;

    public HashMap<String, Command> getRegisteredCommands() {
        return registeredCommands;
    }

    public MyDragonsCollection getCollection() {
        return collection;
    }

    public CommandReceiver(HashMap<String, Command> registeredCommands, MyDragonsCollection collection){
        this.registeredCommands = registeredCommands;
        this.collection = collection;
    }

    private boolean userWantsToExit = false;

    public boolean userWantsToExit() {
        return userWantsToExit;
    }

    public void printHelp(){
        //для сортировки по ключу (алфавиту)
        Map<String, Command> treeMap = new TreeMap<String, Command>(registeredCommands);
        for(Map.Entry<String, Command> entry : treeMap.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue().getDescription());
        }
    }

    public void exit(){
        userWantsToExit = true;
        // или можно System.exit(0)...
    }
}