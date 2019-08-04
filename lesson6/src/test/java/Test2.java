import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class Test2 {

    @Parameterized.Parameters
    public static Collection<Object[]>data(){
        return Arrays.asList(new Object[][]{
                {false,new int[]{4,4,4,4,4}},
                {false,new int[]{1,1,1,1,1}},
                {true,new int[]{4,1,1,1,1}},
                {false,new int[]{3,3,3,3,3}},
                {false,new int[]{1,1,1,1,3}},
                {false,new int[]{4,4,4,4,3}}
        });
    }


    private boolean a;
    private int[] b;
    public Test2(boolean a,int[] b){
        this.a =a;
        this.b =b;
    }
    @Test
    public void startTest(){
        Assert.assertEquals(a,main.arrayValidity(b));
    }
}
