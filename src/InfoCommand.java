public class InfoCommand implements Command {
    @Override
    public void execute() {
        //TODO
    }

    @Override
    public String getDescription() {
        return "вывести в стандартный поток вывода информацию о коллекции " +
                "(тип, дата инициализации, количество элементов и т.д.)";
    }
}
