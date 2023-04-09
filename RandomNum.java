 

import java.util.Arrays;
import java.util.Random;


public class RandomNum {
    private Random rand;

    public RandomNum(int seed){
        this.rand = new Random(123);
    }

    public double[] RandArray(int num) {

        double[] randArray = new double[num];

        for (int i = 0; i < num; i++) {
            randArray[i] = this.rand.nextDouble();
        }
        return randArray;
    }


}
