package ru.avalon.java.actions;

import java.io.IOException;
import java.nio.file.*;

/**
 * Действие, которое копирует файлы в пределах дискового
 * пространства.
 */
public class FileRenameAction implements Action {
    /**
     * {@inheritDoc}
     */
    private String inFile;
    private String outFile;
    public FileRenameAction(String inPath, String outPath){
        inFile = inPath;
        outFile = outPath;
    }
    @Override
    public void run() {
        /*
         * TODO №2 Реализуйте метод run класса FileRenameAction
         */        
        Path in =Paths.get(inFile);
        Path out =Paths.get(outFile);
        try {
            Files.move(in, out);
        } catch (IOException ex) {
            System.out.println("Не получилось изменить имя файла" + ex);
        }
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void close() throws Exception {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();            
        }
        /*
         * TODO №3 Реализуйте метод close класса FileRenameAction
         */
    }
}
