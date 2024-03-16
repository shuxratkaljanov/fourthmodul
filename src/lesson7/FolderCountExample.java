package lesson7;

import java.io.File;

public class FolderCountExample {
    static int fileCounter = 0;
    static int dCounter = 0;

    public static void main(String[] args) {

        File file = new File("C:/Users/kalja/IdeaProjects");
        files(file);
        System.out.println("Folders => " + dCounter);
        System.out.println("Files => " + fileCounter);
    }

    private static void files(File file) {
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isDirectory()) {
                files(file1);
                dCounter++;
            } else {
                fileCounter++;
            }
        }
    }

}
