public class ShowCommand implements Command {
    MyDragonsCollection collection;
    public ShowCommand(MyDragonsCollection collection){
        this.collection = collection;
    }
    @Override
    public void execute() {
        collection.show();
    }

    @Override
    public String getDescription() {
        return "вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
}
