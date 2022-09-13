package TestNgDemos.ParameterizationDemo;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ClassTwo {




    @Parameters({"myUsername","myPassword","myUrl"})
    @Test
    public void classTwoTest1(String user,String pass,String u)
    {
        String url = u;
        String username = user;
        String password = pass;

        System.out.println("url:"+url);
        System.out.println("username:"+username);
        System.out.println("password:"+password);

        System.out.println("classTwoTest1");
    }

  @Test
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
