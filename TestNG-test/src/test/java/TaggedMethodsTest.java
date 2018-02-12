import org.testng.annotations.Test;

public class TaggedMethodsTest {
    @Test(groups = {"positive","broken"})
    public void test1(){
        System.out.println("broken test1");

    }

    @Test(groups = "positive")
    public void test2(){
        System.out.println("positibe 2");
    }
    @Test(groups = "negative")
    public void test3(){
        System.out.println("negative");
    }

}
