import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ClasspathFileLister {

    public static void main(String[] args) {
        List<File> javaFiles = getClasspathJavaFiles();
        for (File file : javaFiles) {
            System.out.println(file.getAbsolutePath());
        }
    }

    private static List<File> getClasspathJavaFiles() {
        List<File> javaFiles = new ArrayList<>();
//        String classpath = System.getProperty("java.class.path");
        String classpath = "src\\main\\java";
        System.out.println("Classpath : " + classpath);
        String[] classpathEntries = classpath.split(File.pathSeparator);

        for (String entry : classpathEntries) {
            File file = new File(entry);
            if (file.exists() && file.isDirectory()) {
                List<File> directoryJavaFiles = findJavaFiles(file);
                javaFiles.addAll(directoryJavaFiles);
            }
        }

        return javaFiles;
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
}
