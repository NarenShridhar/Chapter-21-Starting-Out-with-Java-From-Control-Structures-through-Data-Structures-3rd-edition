import java.io.*;
import java.util.Scanner;

public class TracingGenealogies
{
	public static void genealogyTracer() throws FileNotFoundException
	{
		/**
			Created a File object file which will be used to hold the filename
			of a file. 
		*/

		File file;

		/**
			Created a Scanner object called inputFile. Within the below whileLoop, 
			a File object will be passed into this object. 
		*/

		Scanner inputFile;

		/**
			Created a String variable fileName which will hold the name of the file
			that will be given by the user. 
		*/

		String fileName;

		/**
			Created a String variable ancestorName to hold the name of the
			ancestor that the user is searching for. 
		*/

		String ancestorName;

		/**
			Created a String variable descendantName to hold the name of the
			ancestor that the user is searching for. 
		*/

		String descendantName;

		/**
			Created a Scanner object called keyboard to take in the user's input. 
		*/

		Scanner keyboard = new Scanner(System.in);

		/**
			Get the filename. 
		*/

		System.out.println("User, please enter a filename: ");

		/**
			Set the filename. 
		*/

		fileName = keyboard.nextLine();

		/**
			Created a char variable missingFile to serve within the while loop to 
			prompt the user to re-enter a filename while an exception is thrown
			resulting from the file being missing. 
		*/

		char missingFile = 'y';

		/**
			DO! - while the missingFile is equal to 'Y'...
			Remember, this type of problem only works with a do-while loop.
			Attempting to solve this problem with a while loop DOES NOT WORK!
		*/

		do
		{
			/**
				Try to open the file from the fileName that the user has entered from
				within the main program. 
			*/

			try
			{
				/**
					Created a File object called file from the directory given in fileName. 
					If this file does not exist, and exception will be thrown. 
				*/

				file = new File(fileName);

				/**
					Assigned the File object file to the Scanner object inputFile, now the
					file can be read. 
				*/

				inputFile = new Scanner(file);

				/**
					Inform the user the file was found. 
				*/

				System.out.println("The file was found");

				/**
					If the filename does exist, missingFile is now set to 'N', which results
					in the while loop no longer executing, since the File object file
					now holds a working directory. 
				*/

				missingFile = 'N';

				/**
					Get the ancestor name.
				*/

				System.out.println("User, please enter the name of the ancestor you are searching for: ");

				/**
					Set the ancestor name. 
				*/

				ancestorName = keyboard.nextLine();

				/**
					Print the contents of the file to the user. 
				*/

				//System.out.println("These are the contents of the file you selected: ");

				/*while(inputFile.hasNext())
				{
					String line = inputFile.nextLine();

					System.out.println(line);
				}*/

				/**
				
				*/

				while(inputFile.hasNext())
				{
					String line = inputFile.nextLine();

					if(line.startsWith(ancestorName))
					{
						String str = line;

						str = str.trim();

						String[] tokens = str.split(",");

						System.out.println("Below is how you should enter the descendant name in order for the program "
							+ "to determine if the descendant you are searching for has descended from the ancester you entered.");

						for(String s : tokens)
						{
							System.out.println(s);
						}

						/**
							Get the descendant name.
						*/

						System.out.println("User, please enter the name of the descendant you are searching for: ");

						/**
							Set the descendant name. 
						*/

						descendantName = keyboard.nextLine();

						for(int i = 0; i < tokens.length; i++)
						{
							if(tokens[i].equalsIgnoreCase(descendantName))
							{
								System.out.println(str);
							}

							/*else
							{
								System.out.println(descendantName + " is NOT a descendant of " + ancestorName);
							}*/
						}

					}



					/*else
					{
						System.out.println("The ancestor you entered does not exist.");
					}*/


				}

				inputFile.close();

			}

			/**
				Catch block catches the corresponding FileNotFoundException that is thrown 
				by the try block. 
			*/

			catch(FileNotFoundException e)
			{
				/**
					If the exception is thrown, it means that the fileName given by the user
					did not exist. This corresponding catch block within the while loop
					will prompt the user to re-enter a fileName, and will attempt
					to assign it once again to the File object file. If it still does not work, 
					the loop will prompt the user to enter a different file. So on and so forth. 
				*/

				System.out.println("User, the filename you entered is missing.");
				System.out.println("It is either in another directory, or does not exist.");
				System.out.println("User, you need another filename. Please enter it now.");
				fileName = keyboard.nextLine();
			}

		}while(Character.toUpperCase(missingFile) == 'Y');


	}
}