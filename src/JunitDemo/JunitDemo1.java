package JunitDemo;

import org.junit.*;

public class JunitDemo1 {


    @BeforeClass
    public static void beforeClassDemo()
    {
        System.out.println("beforeClassDemo");
    }

    @AfterClass
    public static void afterClassDemo()
    {
        System.out.println("afterClassDemo");
    }




    @Before
    public void beforeDemo()
    {
        System.out.println("beforeDemo");
    }
    @After
    public void afterDemo()
    {
        System.out.println("afterDemo");
    }

    @Test
    public void test1()
    {
        System.out.println("test1");
    }
    @Test
    public void test2()
    {
        System.out.println("test2");
    }
    @Test
    public void test3()
    {
        System.out.println("test3");
    }
}
