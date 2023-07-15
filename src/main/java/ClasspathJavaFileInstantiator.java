import java.io.File;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class ClasspathJavaFileInstantiator {

    public static void main(String[] args) {
        List<Class<?>> javaClasses = getClasspathJavaClasses();
        List<Object> instances = instantiateClasses(javaClasses);

        for (Object instance : instances) {
            try{
                System.out.println(instance.getClass().getName());
            }catch (Exception exception){
                System.out.println("Exception : " + exception);
            }
        }
    }

    private static List<Class<?>> getClasspathJavaClasses() {
        List<Class<?>> javaClasses = new ArrayList<>();
        String classpath = "src/main/java";
        File classpathDir = new File(classpath);

        if (classpathDir.exists() && classpathDir.isDirectory()) {
            List<File> javaFiles = findJavaFiles(classpathDir);
            for (File javaFile : javaFiles) {
                String className = getClassName(javaFile, classpathDir);
                try {
                    Class<?> javaClass = Class.forName(className);
                    javaClasses.add(javaClass);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }

        return javaClasses;
    }

    private static List<File> findJavaFiles(File directory) {
        List<File> javaFiles = new ArrayList<>();

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    javaFiles.addAll(findJavaFiles(file));
                } else if (file.isFile() && file.getName().endsWith(".java")) {
                    javaFiles.add(file);
                }
            }
        }

        return javaFiles;
    }

    private static String getClassName(File javaFile, File baseDir) {
        String filePath = javaFile.getAbsolutePath();
        String baseDirPath = baseDir.getAbsolutePath();

        String className = filePath.substring(baseDirPath.length() + 1);
        className = className.replace(File.separator, ".");
        className = className.substring(0, className.length() - 5); // Remove ".java" extension

        return className;
    }

    private static List<Object> instantiateClasses(List<Class<?>> classes) {
        List<Object> instances = new ArrayList<>();

        for (Class<?> clazz : classes) {
            try {
                Constructor<?> constructor = clazz.getDeclaredConstructor();
                constructor.setAccessible(true); // In case the constructor is non-public
                Object instance = constructor.newInstance();
                instances.add(instance);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return instances;
    }
}
