package Commands;

import Exceptions.NotValidTypeOfArgumentException;
import Exceptions.PrepodLomaetMoyuProguException;
import Exceptions.WrongArgumentsNumberException;

public interface Executable {
    void execute(String[] cmdArgs);
}
