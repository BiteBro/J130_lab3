package ru.avalon.java.actions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Действие, которое перемещает файлы в пределах дискового
 * пространства.
 */
public class FileMoveAction implements Action {
    private String inFile;
    private String outFile;
    
    public FileMoveAction(String inPath, String outPath){
        inFile = inPath;
        outFile = outPath;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
        /*
         * TODO №4 Реализуйте метод run класса FileMoveAction
         */
        Path in = Paths.get(this.inFile);
        Path out = Paths.get(this.outFile);
        try {
            Files.move(in, out);
        } catch (IOException ex) {
            System.out.println("Не получилось изменить имя файла");
        }
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void close() throws Exception {
        /*
         * TODO №5 Реализуйте метод close класса FileMoveAction
         */
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();            
        }
    }
}
