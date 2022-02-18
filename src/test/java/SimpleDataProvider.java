import org.testng.annotations.DataProvider;

public class SimpleDataProvider {
    @DataProvider(name = "4Invocations2MethodsProvider")
    public static Object[][] data1(){
        return new Object[][]{
                new Object[]{"Invocation 1, 1st Parameter","Invocation 1, 2nd Parameter"},
                new Object[]{"Invocation 2, 1st Parameter","Invocation 2, 2nd Parameter"},
                new Object[]{"Invocation 3, 1st Parameter","Invocation 3, 2nd Parameter"},
                new Object[]{"Invocation 4, 1st Parameter","Invocation 4, 2nd Parameter"}};



        }

    }

