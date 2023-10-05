package coding1;

import java.io.File;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

class Project1 {
    public static void main(String[] args) {
        File folder = new File("C:\\Users\\Mecer\\Desktop\\testing");
        folder.mkdirs();
        Scanner scan = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("--LockedMe.com--  --Developed by Innocent Malwane-- \n");
                System.out.println("--Choose one of the following functions--   \n");
                System.out.println("1. Display files in ascending order\n");
                System.out.println("2. Business level operations  \n");
                System.out.println("3. Terminate the Program");
                System.out.println("Choose one of the above options  \n");

                int choice = scan.nextInt();
                switch (choice) {
                    case 1:
                        File[] arr = folder.listFiles();
                        Arrays.sort(arr);
                        if (arr.length > 0) {
                            for (File file : arr) {
                                if (file.isFile()) {
                                    System.out.println(file.getName());
                                }
                            }
                        } else {
                            System.out.println("Directory is empty.");
                        }
                        break;

                    case 2:
                        boolean temp = true;
                        while (temp) {
                            System.out.println("1 : Add a file in the existing Directory");
                            System.out.println("2 : Delete a file from the existing Directory. ");
                            System.out.println("3 : Search a user-specified file from the Directory");
                            System.out.println("4 : Back to the previous menu");
                            System.out.println("5 : Terminate the Program");

                            int choice2 = scan.nextInt();

                            switch (choice2) {
                                case 1:
                                    System.out.println(" Enter a file name: ");
                                    String fileName = scan.next();
                                    File newFile = new File(folder, fileName);
                                    if (newFile.exists()) {
                                        System.out.println(" File already exists. ");
                                    } else {
                                        try {
                                            newFile.createNewFile();
                                            System.out.println(" File added successfully. ");
                                        } catch (Exception e) {
                                            System.out.println(" Error creating the file. ");
                                        }
                                    }
                                    break;

                                case 2:
                                    System.out.println(" Enter a file name to delete: ");
                                    String fileToDelete = scan.next();
                                    File file = new File(folder, fileToDelete);
                                    if (file.exists() && file.isFile()) {
                                        if (file.delete()) {
                                             System.out.println(" File successfully deleted. ");
                                        } else {
                                            System.out.println(" Error deleting the file. ");
                                        }
                                    } else {
                                        System.out.println(" File not found. ");
                                    }
                                    break;

                                case 3:
                                    System.out.println(" Enter a keyword or file name to search: ");
                                    String search = scan.next();

                                    File[] matchingFiles = folder.listFiles((dir, name) -> name.startsWith(search));
                                    if (matchingFiles.length > 0) {
                                        for (File matchingFile : matchingFiles) {
                                            System.out.println(matchingFile.getName());
                                        }
                                    } else {
                                        System.out.println(" No matching files found. ");
                                    }
                                    break;

                                case 4:
                                    temp = false;
                                    break;

                                case 5:
                                    System.out.println(" Program terminated successfully. ");
                                    scan.close();
                                    System.exit(0);

                                default:
                                    System.out.println(" Input correct value and retry. ");
                            }
                        }
                        break;

                    case 3:
                        System.out.println(" Program terminated successfully. ");
                        scan.close(); 
                        System.exit(0);

                    default:
                        System.out.println(" Input correct value and retry. ");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println(" Invalid input. Please enter a valid option. ");
                scan.nextLine(); 
            }
        }
    }
}
