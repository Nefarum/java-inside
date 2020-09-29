package fr.umlv.javainside;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class JSONPrinter {
    public static String toJSON(Record record){
        Objects.requireNonNull(record);
        return Arrays.stream(record.getClass().getRecordComponents())
               .map(elt -> elt.getName())
               .collect(Collectors.joining(","));
    }
}
