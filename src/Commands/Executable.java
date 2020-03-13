package Commands;

import Exceptions.NoSuchDragonException;

/**
 * шаблон команда
 */
public interface Executable {
    /**
     * Execute.
     *
     * @param cmdArgs the cmd args
     * @throws NoSuchDragonException the no such dragon exception
     */
// Exception - костыль, можно изменить
    void execute(String[] cmdArgs) throws NoSuchDragonException;
}
