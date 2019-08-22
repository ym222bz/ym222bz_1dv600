package v2;

import java.util.Scanner;

public class InputData {
    public char EnterData(){
        Scanner input = new Scanner(System.in);
        try
        {
            char output = input.nextLine().trim().toLowerCase().charAt(0);
            //input.close();
            return output;

        }
        catch (Exception ex)
        {
           // input.close();
            return '!';
        }
    }
}
