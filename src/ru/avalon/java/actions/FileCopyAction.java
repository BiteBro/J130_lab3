package ru.avalon.java.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

/**
 * Действие, которое копирует файлы в пределах дискового
 * пространства.
 */
public class FileCopyAction implements Action {
    /**
     * {@inheritDoc}
     */
    private String inFile;
    private String outFile;
    public FileCopyAction(String inPath, String outPath){
        inFile = inPath;
        outFile = outPath;
    }
    
    @Override
    public void run() {
        /*
         * TODO №2 Реализуйте метод run класса FileCopyAction
         */
        
        //File in = new File("J130_lab-3/src/source/Java2015.zip");
        //File out = new File("J130_lab-3/src/rezult/Java2015.zip");
        
        try(InputStream is = new FileInputStream(this.inFile)){ 
            try( OutputStream os = new FileOutputStream(this.outFile)){
                byte[] buffer = new byte[1024];
                int lenght;
                while((lenght = is.read(buffer)) > 0){
                    os.write(buffer, 0, lenght);
                }
            } catch (IOException ex){
                System.out.println("File does not copy " + ex);
              }  
        } catch (IOException ex){
                System.out.println("File not found " + ex);
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
         * TODO №3 Реализуйте метод close класса FileCopyAction
         */
    }
}
