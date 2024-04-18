package com.pattern.learn.utility;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DirectoryLister {
    private static final String ROOT = "/Users/ilialataria/Desktop/JavaProject";
    public static   List<String> getDirectories() {
        Path sourceDir = Paths.get(ROOT);
        List<String> directories = new ArrayList<>();
        try (Stream<Path> stream = Files.walk(sourceDir)) {
            stream.filter(Files::isDirectory)
                    .forEach(s -> directories.add(s.toString()));
        } catch (IOException e) {
            System.err.println("Error accessing or traversing the directory");
            e.printStackTrace();
        }
        return directories;
    }


}
