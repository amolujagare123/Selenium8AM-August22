package TestNgDemos.ParameterizationDemo;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ClassThree {

    @Parameters({"myUsername","myPassword","myUrl"})
    @Test
    public void classThreeTest1(String user,String pass,String u)
    {
        String url = u;
        String username = user;
        String password = pass;

        System.out.println("url:"+url);
        System.out.println("username:"+username);
        System.out.println("password:"+password);
        System.out.println("classThreeTest1");
    }

    @Test
    public void classThreeTest2()
    {
        System.out.println("classThreeTest2");
    }
    @Test
    public void classThreeTest3()
    {
        System.out.println("classThreeTest3");
    }
}
