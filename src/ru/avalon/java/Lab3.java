package ru.avalon.java;

import ru.avalon.java.console.ConsoleUI;
import java.io.IOException;
import java.util.Scanner;
import ru.avalon.java.actions.*;

/**
 * Лабораторная работа №3
 * <p>
 * Курс: "Программирование на платформе Java. Разработка
 * многоуровневых приложений"
 * <p>
 * Тема: "Потоки исполнения (Threads) и многозадачность" 
 *
 * @author Daniel Alpatov <danial.alpatov@gmail.com>
 */
public class Lab3 extends ConsoleUI<Commands> {
    /**
     * Точка входа в приложение.
     * 
     * @param args 
     */
    public static void main(String[] args) {
        new Lab3().run();
    }
    /**
     * Конструктор класса.
     * <p>
     * Инициализирует экземпляр базового типа с использоавнием
     * перечисления {@link Commands}.
     */
    Lab3() {
        super(Commands.class);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCommand(Commands command) throws IOException {
        switch (command) {
            case copy:
                /*
                 * TODO №6 Обработайте команду copy
                 */
                Scanner scan = new Scanner(System.in);
                System.out.println("введите путь откуда");
                String in = scan.nextLine();
                System.out.println("введите путь куда");
                String out = scan.nextLine();
                FileCopyAction fca = new FileCopyAction(in, out);
                fca.start();
            {
                try {
                    fca.close();
                } catch (Exception ex) {
                    System.out.println("Ошибка " + ex);
                }
            }            
                break;
            case move:
                Scanner scanMove = new Scanner(System.in);
                System.out.println("введите путь откуда");
                String inMove = scanMove.nextLine();
                System.out.println("введите путь куда");
                String outMove = scanMove.nextLine();
                FileMoveAction fma = new FileMoveAction(inMove, outMove);
                fma.start();
            {
                try {
                    fma.close();
                } catch (Exception ex) {
                    System.out.println("Ошибка " + ex);
                }
            }
                /*
                 * TODO №7 Обработайте команду move
                 */
                break;
            case delete:
                /*
                 * TODO №8 Обработайте команду move
                 */
                Scanner scanDel = new Scanner(System.in);
                System.out.println("введите файл для удаления");
                String inDel = scanDel.nextLine();
                FileDeleteAction fda = new FileDeleteAction(inDel);
                fda.start();
            {
                try {
                    fda.close();
                } catch (Exception ex) {
                    System.out.println("Ошибка " + ex);
                }
            }            
                break;
            case rename:
                /*
                 * TODO №9 Обработайте команду move
                 */
                Scanner scanRen = new Scanner(System.in);
                System.out.println("введите файл для переименнования");
                String inRen = scanRen.nextLine();
                System.out.println("введите новое имя файла");
                String outRen = scanRen.nextLine()+ inRen;
                FileRenameAction fra = new FileRenameAction(inRen, outRen);
                fra.start();
            {
                try {
                    fra.close();
                } catch (Exception ex) {
                    System.out.println("Ошибка " + ex);
                }
            }            
                break;
            case exit:
                close();
                break;
                /*
                 * TODO №10 Обработайте необработанные команды
                 */
        }   
    }    
}
