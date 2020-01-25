package ru.avalon.java.actions;

import java.io.File;

/**
 * Действие, которое копирует файлы в пределах дискового
 * пространства.
 */
public class FileDeleteAction implements Action {
    /**
     * {@inheritDoc}
     */
    private String del;
    public FileDeleteAction(String delPath){
        del = delPath;
    }
    @Override
    public void run() {
        /*
         * TODO №2 Реализуйте метод run класса FileDeleteAction
         */
        //int count = 0;
        File in = new File(this.del);
        in.delete();        
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
         * TODO №3 Реализуйте метод close класса FileDeleteAction
         */
    }
}
