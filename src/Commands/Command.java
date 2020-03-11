package Commands;

public abstract class Command implements Executable {
    protected CommandReceiver receiver;
    abstract public int getNumberOfRequiredArgs();

    public Command(CommandReceiver receiver){
        this.receiver = receiver;
    }

    public String getDescription(){
        return "no description";
    }
}
