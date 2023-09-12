package mainpackagescd;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Library {

    List<String> IDs = new ArrayList<>();
    List<String> Names = new ArrayList<>();
    List<String> Authors = new ArrayList<>();
    List<String> years = new ArrayList<>();
    String catalogueBackup;
    Library(String fileName) {

        catalogueBackup = fileName;
        String[] Books = Objects.requireNonNull(readFile(fileName)).split("\n");

        for (String book : Books) {
            String[] Elements = book.split(",");
            IDs.add(Elements[0]);
            Names.add(Elements[1]);
            Authors.add(Elements[2]);
            years.add(Elements[3]);
        }

        System.out.println("Loaded Books from file books.txt");
    }
    void displayBooks(){
        System.out.println("This Library has following Books: ");
        int serialNumber = 1;
        for (int i=0;i<IDs.size();i++, serialNumber++){
            System.out.println(serialNumber+") ID: "+ IDs.get(i)+" Book: "+ Names.get(i) +" written by : "+Authors.get(i)+"("+years.get(i)+")");
        }
    }
    void addBook(){

        Scanner sc = new Scanner(System.in);
        String Auth, Title;
        int year;

        System.out.print("Enter the title of the Book : ");
        Title = sc.nextLine();

        System.out.print("Enter the author of the Book : ");
        Auth = sc.nextLine();

        System.out.print("Enter the year of publication of the Book : ");
        year = sc.nextInt();

        BookClass book = new BookClass(Title, Auth, year);

        IDs.add(String.valueOf(book.id));
        Names.add(String.valueOf(book.title));
        Authors.add(String.valueOf(book.author));
        years.add(String.valueOf(book.year));

        writeFile("books.txt", String.valueOf(book.id)+","+book.title+","+book.author+","+book.year, true);

        System.out.println("Book Added To Catalogue Successfully");
    }
    int viewBookByID(int id){
        int regex = -1;

        for(int i=0;i<IDs.size();i++){
            if(String.valueOf(id).equals(IDs.get(i))){
                regex = i;
            }
        }

        if(regex!=-1){
            System.out.println("ID: "+ IDs.get(regex)+" Book: "+ Names.get(regex) +" written by : "+Authors.get(regex)+"("+years.get(regex)+")");
        }
        else {
            System.out.println("No Book found against the provided ID");
        }

        return regex;
    }
    void deleteBook(){

        int ID = -1;
        Scanner sc = new Scanner(System.in);

        System.out.println("Which book do you want to delete: ");

        for (int i=0;i<IDs.size();i++){
            System.out.println("ID: "+ IDs.get(i)+" Book: "+ Names.get(i) +" written by : "+Authors.get(i)+"("+years.get(i)+")");
        }

        System.out.print("\nEnter ID: ");
        ID = sc.nextInt();

        int regex = this.viewBookByID(ID);

        if(regex!=-1){
            IDs.remove(regex);
            Names.remove(regex);
            Authors.remove(regex);
            years.remove(regex);
            System.out.println("The above mentioned book was removed successfully");
        }

        this.saveCatalogue();

    }
    void saveCatalogue(){

        for(int i=0;i<IDs.size();i++){
            if(i==0){
                writeFile(catalogueBackup, IDs.get(i)+","+Names.get(i)+","+Authors.get(i)+","+years.get(i), false);
            }
            else{
                writeFile(catalogueBackup, IDs.get(i)+","+Names.get(i)+","+Authors.get(i)+","+years.get(i), true);
            }
        }

        System.out.println(Names.size()+"Data written to file successfully");

    }
    public static boolean writeFile(String fileName, String textToWrite, boolean mode) {
        try {
            FileWriter fileWriter = new FileWriter(fileName, mode);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(textToWrite);
            bufferedWriter.newLine(); // Add a newline character for clarity

            bufferedWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static String readFile(String fileName) {
        StringBuilder content = new StringBuilder();

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line).append("\n");
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return content.toString();
    }
    void editBook(){
        int ID = -1;
        Scanner sc = new Scanner(System.in);
        String editedName = "";
        String editedAuthor = "";

        System.out.println("Which book do you want to edit: ");

        for (int i=0;i<IDs.size();i++){
            System.out.println("ID: "+ IDs.get(i)+" Book: "+ Names.get(i) +" written by : "+Authors.get(i)+"("+years.get(i)+")");
        }

        System.out.print("\nEnter ID: ");
        ID = sc.nextInt();

        int regex = this.viewBookByID(ID);

        if(regex!=-1){
            System.out.print("Enter Edited Name (-1 if you don't want to change): ");
            editedName = sc.nextLine();

            System.out.print("Enter Edited Author (-1 if you don't want to change): ");
            editedAuthor = sc.nextLine();

            if(!Objects.equals(editedName, "-1")){
                if(!Objects.equals(editedName, "")){
                    Names.set(regex, editedName);
                }
            }

            if(!Objects.equals(editedAuthor, "-1")){
                if(!Objects.equals(editedAuthor, "")){
                    Authors.set(regex, editedAuthor);
                }
            }
        }

        this.saveCatalogue();
    }
    void displayMenu(){

        Scanner sc = new Scanner(System.in);
        int choice = -1;

        while (true){
            System.out.println("\nLibrary Management System Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Edit Book");
            System.out.println("3. Delete Book");
            System.out.println("4. View All Books");
            System.out.println("5. View Book by ID");
            System.out.println("6. Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();

            if(choice==1){
                this.addBook();
            } else if (choice==2) {
                this.editBook();
            } else if (choice==3) {
                this.deleteBook();
            } else if (choice==4) {
                this.displayBooks();
            } else if (choice==5) {
                System.out.println("Enter ID of Book to View: ");
                int id = sc.nextInt();
                this.viewBookByID(id);
            } else {
                System.out.println("Thanks for using our Software");
                break;
            }
        }

    }
}
