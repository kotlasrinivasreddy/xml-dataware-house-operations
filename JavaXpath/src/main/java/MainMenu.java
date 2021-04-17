
import java.util.*;
public class MainMenu {
    public static void main(String[] args)
    {

        Scanner sc= new Scanner(System.in);
        while(true) //infinite loop
        {
            System.out.println("Press 1 for validating xml using user provided xsd, xml paths\nPress 2 for querying already existing xml instances\n"+
                    "Press 3 for storing new xml data warehouse\nPress any other number to exit");
            int selected_option = sc.nextInt();
            if (selected_option == 1) //for validation of xml
                ValidateXml.validateXml();
            else if (selected_option == 2) //for querying the already existing xml
                FireQuery.fireDynamicQuery();
            else if(selected_option ==3) //storing new xml data warehouse
                StoreXmlDataWarehouse.store();
//            else if(selected_option ==4) // this condition is for testing purpose. comment it after testing
//            {
//                System.out.println("Enter dw name");
//                String dw_name= sc.next();
//                new GetRequiredFromDvfa().loadParseDvfa(dw_name);
//            }
            else
                break; // break out of while loop
        } // end of infinite while loop

        System.out.println("**!!@@ TAATA BYEEE BYEEE -- Querying XML & DW operations is FUN @@!!**");
    }
}
