package less1;

import less1.fruit.Apple;
import less1.fruit.Orange;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        //===============================1 и 2 задание====================//
        WorkWitchArray<Integer> mass = new WorkWitchArray<Integer>(1,2,3,4,5);
        mass.showInfo();
        mass.swap(1,2);
        mass.showInfo();
        ArrayList<Integer> testArrayList=mass.getArrayList();
        System.out.println(testArrayList);
        //===============================Основное задание=================//
        Box<Apple> boxApple = new Box<Apple>(6,new Apple());
        Box<Orange> boxOrange = new Box<Orange>(4,new Orange());
        System.out.println(boxApple.compare(boxOrange));
        boxApple.add(new Apple());
        System.out.println(boxApple.compare(boxOrange));

        System.out.println(boxApple.getCountFruits());
        Box<Apple> boxAppleTwo=new Box<Apple>(5,new Apple());
        boxApple.pourIn(boxAppleTwo);
        System.out.println(boxApple.getCountFruits());
        System.out.println(boxAppleTwo.getCountFruits());


    }

}
