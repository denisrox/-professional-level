package less1;

import java.util.ArrayList;
import java.util.Arrays;

public class WorkWitchArray<T> {
    private T[] mass;
    WorkWitchArray(T ... mass)
    {
        this.mass=mass;
    }
    public void swap(int x, int y){
        T temp= mass[x];
        mass[x]=mass[y];
        mass[y]=temp;
    }

    public T[] getMass() {
        return mass;
    }
    public void showInfo(){
        for (T element:mass) {
            System.out.printf(element+" ");
        }
        System.out.println("");
    }
    public ArrayList<T> getArrayList()
    {
        return new ArrayList<T>(Arrays.asList(mass));
    }
}
