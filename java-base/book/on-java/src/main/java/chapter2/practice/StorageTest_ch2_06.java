package chapter2.practice;

import java.sql.SQLOutput;

/**
 * Write a program that includes and calls the storage() method defined as a
 * code fragment in this chapter.
 * @author lh
 */
public class StorageTest_ch2_06 {
    public static void main(String[] args){
        class StoreStuff{
            int storage(String s){
                return s.getBytes().length;
            }
        }

        StoreStuff x = new StoreStuff();
        System.out.println(x.storage("hi"));
    }
}
