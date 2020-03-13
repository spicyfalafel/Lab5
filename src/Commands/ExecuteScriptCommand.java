package Commands;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import Main.Main;

public class ExecuteScriptCommand extends Command {
    public ExecuteScriptCommand(CommandReceiver receiver) {
        super(receiver);
    }

    @Override
    public int getNumberOfRequiredArgs() {
        return 1;
    }

    @Override
    public void execute(String[] cmdArgs) {
        try(BufferedReader reader = new BufferedReader(new FileReader(cmdArgs[0]))){
            String line;
            while((line = reader.readLine()) != null){
                Main.executeCommand(line);
            }
        }catch(FileNotFoundException e){
            System.out.println("file not found");
        } catch (IOException e) {
            System.out.println("капут");
        }
    }

    @Override
    public String getDescription() {
        return "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.";
    }
}
