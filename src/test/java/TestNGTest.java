import org.testng.annotations.Test;

import java.util.Map;

public class TestNGTest {
    @Test(dataProvider = "4Invocations2MethodsProvider",
    dataProviderClass = SimpleDataProvider.class)
    public void test3(String oneStringParameter,String secondStringParameter){
        System.out.println(oneStringParameter+" ; "+secondStringParameter);
    }

    @Test(dataProvider = "LoginPageDataProvider",
            dataProviderClass = ExcelDataProvider.class)
    public void test4(Map<String , String> inputMatrix){
        System.out.println("Test Case name:" + inputMatrix.get("TestCase"));
        System.out.println("Username:" + inputMatrix.get("username"));
        System.out.println("Password:" + inputMatrix.get("Password"));
    }
}
