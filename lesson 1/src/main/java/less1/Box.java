package less1;

import com.sun.org.apache.xpath.internal.operations.Or;
import less1.fruit.Apple;
import less1.fruit.Fruit;
import less1.fruit.Orange;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {
    ArrayList<T> fruits=new ArrayList<T>();
    public Box(int countFruit, T fruit){
        for(int i = 0;i<countFruit;i++)
            fruits.add(fruit);
    }
    public void add(ArrayList<T> fruits){
        this.fruits.addAll(fruits);
    }
    public void add(T fruit){
        fruits.add(fruit);
    }
    public double getWeight(){
        double WeightBox=0;
        for (T fruit:fruits) {
            WeightBox+=fruit.getWeight();
        }
        return WeightBox;
    }
    public boolean compare(Box box){

        return (getWeight()==box.getWeight());
    }
    public void pourIn(Box<T> box){
        box.add(fruits);
        fruits.clear();
    }
    public int getCountFruits()
    {
        return fruits.size();
    }
}
