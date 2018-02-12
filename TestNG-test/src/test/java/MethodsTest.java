import org.testng.annotations.Test;

public class MethodsTest {
    @Test(priority = 2)
    public void test1(){
        System.out.println("test1");

    }

    @Test(priority = 1)
    public void test2(){
        System.out.println("test2");
    }

    public void notAtest(){
        System.out.println("notAtest");
    }
}
