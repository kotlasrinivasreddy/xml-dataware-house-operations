
import java.util.*;
public class MainMenu {
    public static void main(String[] args)
    {

        Scanner sc= new Scanner(System.in);
        while(true) //infinite loop
        {
            System.out.println("Press 1 for validating xml on xsd\nPress 2 for querying already existing xml " +
                    "instances\nPress any other number to exit");
            int selected_option = sc.nextInt();
            if (selected_option == 1) //for validation of xml
                ValidateXml.validateXml();
            else if (selected_option == 2) //for querying the already existing xml
                FireQuery.fireDynamicQuery();
            else
                break; // break out of while loop
        } // end of infinite while loop

        System.out.println("****!!!!@@@@   TAATA BYEEE BYEEE  --  Querying XML is FUN   @@@@!!!!****");
    }
}
