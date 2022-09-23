package DataProviderDemo.DpUtil;

public class ForExcel {

    public static String convertToNumberString(String decimalNumber)
    {
        int temp = (int) Double.parseDouble(decimalNumber);
        return ""+temp;
    }
}
