import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.*;
class FireQuery
{
	static Scanner sc = new Scanner(System.in);
	public static void fireDynamicQuery() {
		//System.out.println("Enter the dimension on which you want to perform slice operation");

		while (true) //infinite loop
		{
			System.out.println("Press 1 to perform slice operation\nPress 2 to perform dice operation\n" +
					"Press 3 to perform drill-up/roll-up operation\nPress any other number to exit");
			int selected_option = sc.nextInt();
			if (selected_option == 1)
			{
				System.out.println("************You have selected slice operation*************");
				//Slice.slice(); // calling slice method
				SliceParam.slice_take_input();
			} //slice if loop
			else if (selected_option == 2)
			{
				System.out.println("****^^^^^You have selected dice operation^^^^^****");
				//Dice.dice();
				DiceParam.dice_take_input();
			} //dice else if loop
			else if (selected_option == 3)
			{
				System.out.println("****^^^^^You have selected rollup/drillup operation^^^^^****");
				//RollUp.rollUp();
				RollUPParam.rollup_take_input();
			} //rollup else if condition
			else
				break; //breaking from infinite while loop
		}// infinite while loop
	}//end of fireDynamicQuery method


	//trying to access bash shell or terminal
		//String[] args = new String[] {"/bin/bash", "-c", xquery};
		//Process proc = new ProcessBuilder(args).start();

		// -- Linux -- Run a shell command
		// Run a shell script
		// processBuilder.command("path/to/hello.sh");
		//ProcessBuilder processBuilder = new ProcessBuilder();
		//processBuilder.command("bash", "-c", "ls -l");

	//reusable method for slice, dice, rollup by passing dynamically created query
	// parameterized firingQuery method
	public static void firingQueryParam(String xquery, String dw_name, String fact_table_name)
	{
		try {
			//storing query into the file and giving that file name in query
			//all data warehouses are stored in separate folders with given dw_name inside xml-project folder
			//  /home/srinivas/IIITB/II-sem/DM/xml-project  -- location where i'm sharing all data warehouse folders
			String dir_path= "/home/srinivas/IIITB/II-sem/DM/xml-project/" + dw_name;
			String query_path= dir_path + "/current-dynamic-query.xqy";
			File yourFile = new File(query_path);
			yourFile.createNewFile(); // if file already exists will do nothing
			FileWriter myWriter = new FileWriter(query_path);
			myWriter.write(xquery); //writing dynamically generated xquery to the query-file
			myWriter.close();

			ProcessBuilder processBuilder = new ProcessBuilder();
			//processBuilder.command("bash", "-c", "cd ; cd Downloads/SaxonHE10-3J ; java -cp saxon-he-10.3.jar net.sf.saxon.Query -q:/home/srinivas/Music/current-dynamic-query.xqy -s:/home/srinivas/Music/factProductSales.xml");
			processBuilder.command("bash", "-c", "cd ; cd Downloads/SaxonHE10-3J ; java -cp saxon-he-10.3.jar net.sf.saxon.Query -q:"+ query_path+ " -s:"+ dir_path+ "/" +fact_table_name);

			Process process = processBuilder.start();
			StringBuilder output = new StringBuilder();
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			//System.out.println("inside first try block");
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}

			int exitVal = process.waitFor();
			if (exitVal == 0) {
				System.out.println("Success!");
				System.out.println(output);
				//System.exit(0);
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	} //end of firingQuery method


	public static void firingQuery(String xquery)
	{
		try {
			//storing query into the file and giving that file name in query
			File yourFile = new File("/home/srinivas/Music/current-dynamic-query.xqy");
			yourFile.createNewFile(); // if file already exists will do nothing
			FileWriter myWriter = new FileWriter("/home/srinivas/Music/current-dynamic-query.xqy");
			myWriter.write(xquery); //writing dynamically generated xquery to the query-file
			myWriter.close();

			ProcessBuilder processBuilder = new ProcessBuilder();
			processBuilder.command("bash", "-c", "cd ; cd Downloads/SaxonHE10-3J ; java -cp saxon-he-10.3.jar net.sf.saxon.Query -q:/home/srinivas/Music/current-dynamic-query.xqy -s:/home/srinivas/Music/factProductSales.xml");

			Process process = processBuilder.start();
			StringBuilder output = new StringBuilder();
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			//System.out.println("inside first try block");
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}

			int exitVal = process.waitFor();
			if (exitVal == 0) {
				System.out.println("Success!");
				System.out.println(output);
				//System.exit(0);
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	} //end of firingQuery method


} //end of class FireQuery