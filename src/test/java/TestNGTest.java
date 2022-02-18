import org.testng.annotations.Test;

public class TestNGTest {
    @Test(dataProvider = "4Invocations2MethodsProvider ",
    dataProviderClass = SimpleDataProvider.class)
    public void test3(String oneStringParameter,String secondStringParameter){
        System.out.println(oneStringParameter+" ; "+secondStringParameter);
    }
}
