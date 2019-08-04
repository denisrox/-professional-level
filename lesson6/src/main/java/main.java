import java.lang.reflect.Array;

public class main {
    public static void main(String[] args) {
        int testArr[]=arrayСonversion(new int[]{4,6,5});
        for (int i:testArr) {
            System.out.print(i+" ");
        }
        System.out.println("");
        ///=====2 часть======
        System.out.println(arrayValidity(new int[]{4,4,4,4,4}));
        System.out.println(arrayValidity(new int[]{1,1,1,1,1}));
        System.out.println(arrayValidity(new int[]{4,1,1,1,1}));
        System.out.println(arrayValidity(new int[]{3,3,3,3,3}));
        //System.out.println(arrayValidity(new int[]{1,1,1,1,3}));
        //System.out.println(arrayValidity(new int[]{4,4,4,4,3}));
    }
    static int[] arrayСonversion(int[] arr)
    {
        final int COUNT=4;
        int arrValue=0;
        for(int i = arr.length-1;i>-1;i--) {
            if (i < 0) throw new RuntimeException("В этом массиве нет 4 :(");
            if (arr[i] == COUNT) {
                break;
            }
            arrValue++;
        }
        int finalArray[] = new int[arrValue];
        System.arraycopy(arr,arr.length-arrValue,finalArray,0,arrValue);
        return finalArray;
    }
    static boolean arrayValidity(int[] arr)
    {
        final int ONE = 1;
        final int FOUR = 4;
        boolean isOne = false;
        boolean isFour = false;
        for (int i:arr) {
            if(i==ONE) isOne=true;
            else if(i==FOUR) isFour=true;
            else throw new RuntimeException("Лишний символ:");
        }
        if(isFour&&isOne)
            return true;
        else
            return false;
    }

}


