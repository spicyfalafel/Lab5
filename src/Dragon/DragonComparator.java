package Dragon;

import java.util.Comparator;

/**
 * The type Dragon comparator.
 */
public class DragonComparator implements Comparator<Dragon> {
    @Override
    public int compare(Dragon d1, Dragon d2) {
        if(d2.getCharacter().equals(DragonCharacter.EVIL)
                && !(d1.getCharacter().equals(DragonCharacter.EVIL))){
            return 1;
        }
        if(d1.getAge()*d2.getWingspan()>d2.getWingspan()*d2.getAge()){
            return 1;
        }else if (d1.getAge()*d2.getWingspan() == d2.getWingspan()*d2.getAge()){
            return 0;
        }else{
            return -1;
        }
    }
}
