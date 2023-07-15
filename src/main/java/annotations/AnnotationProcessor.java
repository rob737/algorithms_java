package annotations;

import annotations.assignment.AuditExecution;
import annotations.assignment.AuditMethod;
import annotations.assignment.Pilot;
import array.Anagram;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
* Create a custom annotation that prints time taken for algorithm to run if annotated over a method.
* */
public class AnnotationProcessor {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Object obj = new Anagram();
        calculateExecutionTime(obj);
    }

    /*
    * Similarly, Spring boot must be enumerating all classes in classpath and performing operation based on the annotation defined.
    * */
    private static void calculateExecutionTime(Object obj) throws InvocationTargetException, IllegalAccessException {
        Class<?> clazz = obj.getClass();
        if(!clazz.isAnnotationPresent(AuditExecution.class)){
            System.out.println("Not annotated");
        }
        for(Method method : clazz.getDeclaredMethods()){
            if(method.isAnnotationPresent(AuditMethod.class)){
                var start = System.currentTimeMillis();
                method.setAccessible(true);
                method.invoke(obj);
                var end = System.currentTimeMillis();
                System.out.println("Total execution time for method " + method.getName() + " is " + (end - start) + " ms");
            }
        }
    }

}
