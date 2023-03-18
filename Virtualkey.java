 import java.util.*; 
import java.io.*; 
public class Virtualkey
{
 private static final String DIRECTORY_PATH = "D:\\Virtualkey\\File";
 public static void main(String[] args)
 {
 Scanner scanner = new Scanner(System.in);
 System.out.println("-----------------------");
 System.out.println("\t Welcome to Lockers.com");
 System.out.println("\t Developed by Mariyam Nabila");
 System.out.println("-----------------------");
 int ch;
 do
 {
 System.out.println("\nPlease select an choice:");
 System.out.println("1. Retrieve the file names in ascending order.");
 System.out.println("2. File operations.");
 System.out.println("3. Exit.");
 ch = scanner.nextInt();
 switch (ch)
 {
 case 1:
 retrieveFileNames();
 break;
 case 2:
 fileOperations(scanner);
 break;
 case 3:
 System.out.println("\nThank you for using Lockers.com!");
 break;
 default:
 System.out.println("\nInvalid option. Please select the option again.");
 break;
 }
 }while (ch != 3);
 scanner.close();
 }
 private static void retrieveFileNames()
 {
 File directory = new File(DIRECTORY_PATH);
 File[] files = directory.listFiles();
 if(files.length == 0)
 {
 System.out.println("\nThe directory is empty.");
 }
 else
 {
 Arrays.sort(files);
 System.out.println("\nThe files in " + directory.getAbsolutePath() + " are:");
 for(File file : files)
 {
 System.out.println(file.getName());
 }
 }
 }
 private static void fileOperations(Scanner scanner)
 {
 int ch;
 do
 {
 System.out.println("\nPlease select a file operation:");
 System.out.println("1. Add a file");
 System.out.println("2. Delete a file");
 System.out.println("3. Search for a file");
 System.out.println("4. Back to main menu");
 ch = scanner.nextInt();
 switch (ch)
 {
 case 1:
 addFile(scanner);
 break;
 case 2:
 deleteFile(scanner);
 break;
 case 3:
 searchFile(scanner);
 break;
 case 4:
 break;
 default:
 System.out.println("\nInvalid option. Please select again.");
 break;
 }
 }
 while (ch != 4);
 }
 private static void addFile(Scanner scanner)
 {
 System.out.println("\nEnter the name of the file to be added:");
 String fName = scanner.next();
 File file = new File(DIRECTORY_PATH + "\\" + fName);
 try{
 if(file.createNewFile())
 {
 System.out.println("\nThe file " + fName + " has been added successfully.");
 }
 else
 {
 System.out.println("\nThe file " + fName + " already exists in the directory.");
 }
 }catch(IOException e){
 System.out.println("\nAn error occurred while adding the file.");
 }
 }
 private static void deleteFile(Scanner scanner)
 {
 System.out.println("\nEnter the name of the file to be deleted:");
 String fName = scanner.next();
 File file = new File(DIRECTORY_PATH + "\\" + fName);
 if (file.delete())
 {
 System.out.println("\nThe file " + fName + " has been deleted successfully.");
 }
 else
 {
 System.out.println("\nThe file " + fName + " was not deleted successfully. It may not exist in the directory.");
 }
 }
 private static void searchFile(Scanner scanner)
 {
 System.out.println("\nEnter the name of the file to be searched:");
 String fName = scanner.next();
 File directory = new File(DIRECTORY_PATH);
 File[] files = directory.listFiles();
 boolean fileFound = false;
 for (File file : files)
 {
 if (file.getName().equalsIgnoreCase(fName))
 {
 System.out.println("\nThe file " + fName + " has been found in the directory.");
 fileFound = true;
 break; 
}
 }
 if (!fileFound)
 {
 System.out.println("\nThe file " + fName + " was not found in the directory.");
 }
 }
 }

