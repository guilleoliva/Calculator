package junit;
/**
 * Тест производительности
 */
import com.prog.Calculator;
import org.junit.Assert;
import org.junit.After;
import org.junit.Test;
import java.util.Random;

public class PerformanceTest {
    private Calculator calc = new Calculator();
    private Random random = new Random();
    private int operations = 100;
    private double expectedSpeedOperationInOneSecond = 10.0;

    public String generateData(){
        Double data = random.nextDouble();
        return data.toString();
    }

    @Test
    public void perfTest001(){
        double start = System.currentTimeMillis();
        int count = 0;
        while(count < 100){
            Calculator.setValueA(generateData());
            Calculator.setValueB(generateData());
            calc.clickButton();
            count++;
        }
        long stop = System.currentTimeMillis();
        double dif = (stop-start) / 1000.0;

        double actualSpeedOperationInOneSecond = operations / dif;

        System.out.println("Actual Speed Operation In One Second = "+actualSpeedOperationInOneSecond);
        Assert.assertTrue(actualSpeedOperationInOneSecond > expectedSpeedOperationInOneSecond);

    }

    @After
    public void clear(){
        calc = null;
        random = null;
        operations = 0;
        expectedSpeedOperationInOneSecond = 0;
    }
}
