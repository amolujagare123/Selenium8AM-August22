package TestNgDemos.Demo2;

import org.testng.annotations.*;

public class ClassTwo {



  /*  @BeforeSuite
    public void beforeMySuite()
    {
        System.out.println("beforeMySuite");
    }

    @AfterSuite
    public void afterMySuite()
    {
        System.out.println("afterMySuite");
    }
*/
    @Test
    public void classTwoTest1()
    {
        System.out.println("classTwoTest1");
    }

  @Test (groups = {"email","validation"})
  public void classTwoTest2()
    {
        System.out.println("classTwoTest2");
    }
    @Test
    public void classTwoTest3()
    {
        System.out.println("classTwoTest3");
    }
}
