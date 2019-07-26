package less3;

import jdk.internal.util.xml.impl.Input;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;


public class main {
    public static void main(String[] args) throws IOException {
        exercise1();
        exercise2();
        exercise3(1);
    }
    public static void exercise1() throws IOException {
        File file = new File("files/test1.txt");
        byte buff[]=new byte[50]; //в первых дувх заданиях файлы малого объема, думаю такого буффера для данной задаче более, чем достаточно
        FileInputStream in = new FileInputStream(file);
        int x;
        while((x=in.read(buff))>0)
        {
            System.out.print(new String(buff));
        }
        in.close();
    }
    public static void exercise2() throws IOException{
        byte buff[]=new byte[50]; //в первых дувх заданиях файлы малого объема, думаю такого буффера для данной задаче более, чем достаточно
        ArrayList<InputStream> al = new ArrayList<InputStream>();
        al.add(new FileInputStream("files/test2_1.txt"));
        al.add(new FileInputStream("files/test2_2.txt"));
        Enumeration<InputStream> e = Collections.enumeration(al);
        SequenceInputStream in = new SequenceInputStream(e);
        int x;
        File file = new File("files/test2_3.txt");
        file.delete();
        file.createNewFile();
        FileOutputStream out = new FileOutputStream(file);

//      while((x=in.read(buff))>0) //Не подскажете, почему данный пример не будет работать? (проверенно опытном путем)
//      {
//          out.write(buff);
//      }
        int byt;
        while((byt = in.read())!=-1)
        {
            out.write(byt);
        }

        in.close();
        out.close();
    }
    public static void exercise3(int page) throws IOException{
        long startTime = System.currentTimeMillis();
        File file = new File("files/A Song of Ice and Fire.txt");
        byte buff[]=new byte[1800];
        RandomAccessFile raf = new RandomAccessFile(file,"r");
        raf.seek(page*buff.length-1); //т.к. страницы "0" для обычного человека не существует
        raf.read(buff);
        System.out.println(new String(buff));
        System.out.println(System.currentTimeMillis()-startTime);
    }
}
