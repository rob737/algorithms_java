package annotations;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ObjectToJsonConverter {

    private static void checkIfSerializable(Object object) throws Exception {
        if(object == null){
            throw new Exception("The object to serialize is null");
        }
        Class<?> clazz = object.getClass();
        if(!clazz.isAnnotationPresent(JsonSerializable.class)){
            throw new Exception("The class" + clazz.getSimpleName() + "is not annotated with JsonSerializable.");
        }
    }

    private static void initializeObject(Object object) throws Exception{
        Class<?> clazz = object.getClass();
        for(Method method : clazz.getDeclaredMethods()){
            if(method.isAnnotationPresent(Init.class)){
                method.setAccessible(true); // It allows us to execute private methods.
                method.invoke(object);
            }
        }
    }

    private static String getJsonString(Object object) throws Exception{
        Class<?> clazz = object.getClass();
        Map<String,String> jsonElementsMap = new HashMap<>();
        for(Field field : clazz.getDeclaredFields()){
            field.setAccessible(true);
            if(field.isAnnotationPresent(JsonElement.class)){
                jsonElementsMap.put(getKey(field), (String) field.get(object));
            }
        }
        String jsonString = jsonElementsMap.entrySet()
                .stream()
                .map(entry -> "\"" + entry.getKey() + "\":\"" + entry.getValue() + "\"")
                .collect(Collectors.joining(","));

        return "{" + jsonString + "}";
    }

    private static String getKey(Field field){
        // return attribute key if decorated otherwise user defined field name.
        String value = field.getAnnotation(JsonElement.class).key();
        return value.isEmpty() ? field.getName() : value;
    }

    private static String convertToJson(Object object) throws Exception{
        checkIfSerializable(object);
        initializeObject(object);
        return getJsonString(object);
    }


    public static void main(String[] args) throws Exception {
        Person person = new Person("Robin","Srivastava","31");
        String result = convertToJson(person);
        System.out.println(result);
    }
}
