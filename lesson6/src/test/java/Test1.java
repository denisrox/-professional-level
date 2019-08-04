import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class Test1 {

    @Parameterized.Parameters
    public static Collection<Object[]>data(){
        return Arrays.asList(new Object[][]{
                {new int[]{1,2,3,4,5,6},new int[]{5,6}},
                {new int[]{7,3,6,4},new int[]{}},
                {new int[]{4,3,6,7},new int[]{3,6,7}},
                {new int[]{7,3,6,5},new int[]{}}
        });
    }


    private int[] a;
    private int[] b;
    public Test1(int[] a,int[] b){
        this.a =a;
        this.b =b;
    }
    @Test
    public void startTest(){
        Assert.assertTrue(Arrays.equals(b, main.arrayСonversion(a)));
    }
}
