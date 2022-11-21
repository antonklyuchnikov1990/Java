public class Tests {

    @BeforeSuite
    public void before() {
        System.out.println("BeforeSuite run");
    }

//    @BeforeSuite
//    public void before1() {
//        System.out.println("BeforeSuite1 run");
//    }

    @Test(priority = 3)
    public static void test3() {
        System.out.println("Test3 run");
    }

    @Test
    public static void test5() {
        System.out.println("Test5 run");
    }

    @Test(priority = 4)
    public static void test4() {
        System.out.println("Test4 run");
    }

    @Test(priority = 1)
    public static void test1() {
        System.out.println("Test1 run");
    }

    @Test(priority = 3)
    public static void test31() {
        System.out.println("Test3.1 run");
    }

    @AfterSuite
    public static void after() {
        System.out.println("AfterSuite run");
    }

}
