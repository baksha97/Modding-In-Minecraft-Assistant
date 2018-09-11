package utils.enums;

import java.util.Arrays;

/**
 * Created by loaner on 5/19/17.
 */
public enum CurriculumType {
    FIRE,
    ICE;

    public static String[] getNames() {
        return Arrays.stream(CurriculumType.class.getEnumConstants()).map(Enum::name).toArray(String[]::new);
    }
}
