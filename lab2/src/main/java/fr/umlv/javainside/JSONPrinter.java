package fr.umlv.javainside;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class JSONPrinter {
    private Object invokeAccessor(Method accessor, Record record){
        try{
            return accessor.invoke(record);
        }
        catch(IllegalAccessException e){
            throw (IllegalAccessError) new IllegalAccessError().initCause(e);
        }
        catch(InvocationTargetException e){
            Throwable cause = e.getCause();
            if(cause instanceof RuntimeException re){
                throw re;
            }
            if(cause instanceof Error error){
                throw error;
            }
            throw new UndeclaredThrowableException(cause);
        }
    }
    public static String toJSON(Record record){
        Objects.requireNonNull(record);
        return Arrays.stream(record.getClass().getRecordComponents())
               .map(elt -> elt.getName())
               .collect(Collectors.joining(","));
    }
}
