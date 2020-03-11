public interface Command {
    void execute();
    default String getDescription(){
        return "no desctiption";
    }
}
