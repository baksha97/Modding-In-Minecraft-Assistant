package utils.enums;

import java.util.Arrays;

public enum ImportType {
    PRE,
    POST;

    public static String[] getNames() {
        return Arrays.stream(ImportType.class.getEnumConstants()).map(Enum::name).toArray(String[]::new);
    }
}