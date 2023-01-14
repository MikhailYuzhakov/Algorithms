import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Seminar1
 */
public class Fibbonachi {

    public static void main(String[] args) {
        Integer count = 100;
        long time1 = CalculateFibbonachi.simpleFibbonachi((long)count);
        System.out.println("Время выполнения подсчета чисел циклом = " + time1 + " нс");
        long time2 = CalculateFibbonachi.binetFormula((long)count);
        System.out.println("Время выполнения подсчета чисел формулой Бине = " + time2 + " нс");    
    }
}

// считаем числа Фиббоначи перебором
class CalculateFibbonachi {
    public static long simpleFibbonachi(Long n) {
        ArrayList<BigInteger> list = new ArrayList<BigInteger>();
        BigInteger res;
        list.add(BigInteger.valueOf(0)); list.add(BigInteger.valueOf(1));
        long t1 = System.nanoTime();
        for (int i = 1; i < n; i++) {
            res = list.get(i - 1);
            list.add(res.add(list.get(i)));
        }
        long dt = System.nanoTime() - t1;
        System.out.println(list.get(list.size()-1));
        return dt;
    }

    //считаем числа Фиббоначи через формулу Бине
    public static long binetFormula(Long n) {
        long t1 = System.nanoTime();
        BigInteger res = BigInteger.valueOf((long) ((Math.pow(((1 + Math.sqrt(5))/2), (double)n) - 
                                        Math.pow(((1 - Math.sqrt(5))/2), (double)n))/Math.sqrt(5)));
        long dt = System.nanoTime() - t1;
        System.out.println(res);
        return dt;
    }
}