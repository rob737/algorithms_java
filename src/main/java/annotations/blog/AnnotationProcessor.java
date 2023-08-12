package annotations.blog;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationProcessor {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Object obj = new Driver();
        calculateExecutionTime(obj);
    }

    private static void calculateExecutionTime(Object obj) throws InvocationTargetException, IllegalAccessException {
        // Gets runtime reference of our object.
        Class<?> classRef = obj.getClass();

        if(!classRef.isAnnotationPresent(AuditExecution.class)){
            System.out.println("Class is not annotated with relevant annotation");
            return;
        }

        // Gets access to each of the methods defined in the class
        for (Method method : classRef.getDeclaredMethods()) {
            if (method.isAnnotationPresent(AuditMethod.class)) {
                var start = System.currentTimeMillis();
                method.setAccessible(true);
                method.invoke(obj);
                var end = System.currentTimeMillis();
                System.out.println("Total execution time for method " + method.getName() + " is " + (end - start) + " ms");
            }
        }
    }
}
