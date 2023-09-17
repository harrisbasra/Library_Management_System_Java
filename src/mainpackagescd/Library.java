package mainpackagescd;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Library {

    String catalogueBackup;
    List<Book> books = new ArrayList<>();
    List<Magazine> magazines = new ArrayList<>();
    List<Newspaper> newspapers = new ArrayList<>();
    List<Borrower> borrowers = new ArrayList<>();

    //..........................................................................................

    Library(String fileName) {

        catalogueBackup = fileName;
        String[] Books = Objects.requireNonNull(readFile(fileName)).split("\n");

        for (String book : Books) {
            String[] Elements = book.split(",");
            books.add(new Book(Integer.parseInt(Elements[0]),Integer.parseInt(Elements[1]), Elements[2], Elements[3], Integer.parseInt(Elements[4]), Integer.parseInt(Elements[5]), Integer.parseInt(Elements[6]) ));
        }

        System.out.println("Loaded Books from file books.txt");
    }
    void displayBooks(){
        System.out.println("This Library has following Books: ");
        int serialNumber = 1;
        for (int i=0;i<books.size();i++, serialNumber++){
            System.out.print(serialNumber+") ");
            books.get(i).displayDetails();
        }
    }
    void addBook(){

        Scanner sc = new Scanner(System.in);
        String Auth, Title;
        int year;
        double price;

        System.out.print("Enter the title of the Book : ");
        Title = sc.nextLine();

        System.out.print("Enter the author of the Book : ");
        Auth = sc.nextLine();

        System.out.print("Enter the year of publication of the Book : ");
        year = sc.nextInt();

        System.out.print("Enter the price of the Book : ");
        price = sc.nextDouble();

        Book book = new Book(1, Title, Auth, year, 0,price);

        books.add(book);

        writeFile("books.txt", String.valueOf(book.id)+","+book.title+","+book.author+","+book.year, true);

        System.out.println("Book Added To Catalogue Successfully");
    }
    int viewBookByID(int id){
        int regex = -1;

        for(int i=0;i<books.size();i++){
            if(id == books.get(i).id){
                regex = i;
            }
        }

        if(regex!=-1){
            System.out.println("ID: "+ books.get(regex).id +" Book: "+ books.get(regex).title +" written by : "+books.get(regex).author+"("+books.get(regex).year+")");
        }
        else {
            System.out.println("No Book found against the provided ID");
        }

        return regex;
    }
    int viewMagzineByID(int id){
        int regex = -1;

        for(int i=0;i<magazines.size();i++){
            if(id == magazines.get(i).id){
                regex = i;
            }
        }

        if(regex!=-1){
            magazines.get(regex).displayDetails();
        }
        else {
            System.out.println("No Magazine found against the provided ID");
        }

        return regex;
    }
    int viewNewsPaperByID(int id){
        int regex = -1;

        for(int i=0;i<newspapers.size();i++){
            if(id == newspapers.get(i).id){
                regex = i;
            }
        }

        if(regex!=-1){
            newspapers.get(regex).displayDetails();
        }
        else {
            System.out.println("No Newspapers found against the provided ID");
        }

        return regex;
    }
    void deleteBook(){

        int ID = -1;
        Scanner sc = new Scanner(System.in);

        System.out.println("Which book do you want to delete: ");

        for (Book book : books) {
            System.out.println("ID: " + book.id + " Book: " + book.title + " written by : " + book.author + "(" + book.year + ")");
        }

        System.out.print("\nEnter ID: ");
        ID = sc.nextInt();

        int regex = this.viewBookByID(ID);

        if(regex!=-1){
            books.remove(regex);
            System.out.println("The above mentioned book was removed successfully");
        }

        //this.saveCatalogue();

    }
    public static void writeFile(String fileName, String textToWrite, boolean mode) {
        try {
            FileWriter fileWriter = new FileWriter(fileName, mode);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(textToWrite);
            bufferedWriter.newLine(); // Add a newline character for clarity

            bufferedWriter.close();
        } catch (IOException ignored) {

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
        } catch (IOException ignored) {
            return null;
        }

        return content.toString();
    }
    void editBook(){
        int ID = -1;
        Scanner sc = new Scanner(System.in);
        String editedName = "";
        String editedAuthor = "";

        System.out.println("Which book do you want to delete: ");

        for (Book book : books) {
            System.out.println("ID: " + book.id + " Book: " + book.title + " written by : " + book.author + "(" + book.year + ")");
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
                    books.get(regex).title = editedName;
                }
            }

            if(!Objects.equals(editedAuthor, "-1")){
                if(!Objects.equals(editedAuthor, "")){
                    books.get(regex).author = editedAuthor;
                }
            }
        }

        //this.saveCatalogue();
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

    //..........................................................................................

    void dynamicallyIdentify(Item item){
        if(item instanceof Book){
            System.out.println("Book Identified");
            item.displayDetails();
        } else if (item instanceof Magazine) {
            System.out.println("Magazine Identified");
            item.displayDetails();
        } else if (item instanceof Newspaper) {
            System.out.println("Newspaper Identified");
            item.displayDetails();
        }
    }

    //...........................................................................................

    void borrowItem(Borrower borrower){
        int ID = -1;
        int option = 1;
        Scanner sc = new Scanner(System.in);

        System.out.println("What do you want to borrow: \n1. Book\n2. Magazine \n3. Newspaper\nEnter Serial No:");
        option = sc.nextInt();

        if(option==1){

            System.out.println("Which book do you want to borrow: ");

            for (Book book : books) {
                System.out.println("ID: " + book.id + " Book: " + book.title + " written by : " + book.author + "(" + book.year + ")");
            }

            System.out.print("\nEnter ID: ");
            ID = sc.nextInt();

            int regex = this.viewBookByID(ID);
            if(regex!=-1){
                if(!books.get(regex).isBorrowed){
                    books.get(regex).isBorrowed = true;
                    borrower.borrowedItems.add(books.get(regex));
                    books.get(regex).popularityCount++;
                    System.out.println("Person: "+borrower.name+" has borrowed book: "+books.get(regex).title);
                }
                else {
                    System.out.println("Item is already borrowed");
                }
            }

        }
        if(option==2){

            System.out.println("Which Magazine do you want to borrow: ");

            for (Magazine magazine : magazines) {
                magazine.displayDetails();
            }

            System.out.print("\nEnter ID: ");
            ID = sc.nextInt();

            int regex = this.viewMagzineByID(ID);
            if(regex!=-1){
                if(!magazines.get(regex).isBorrowed){
                    magazines.get(regex).isBorrowed = true;
                    borrower.borrowedItems.add(magazines.get(regex));
                    magazines.get(regex).popularityCount++;
                    System.out.println("Person: "+borrower.name+" has borrowed magazine: "+magazines.get(regex).title);
                }
                else {
                    System.out.println("Item is already borrowed");
                }
            }

        }
        if(option==3){

            System.out.println("Which newspaper do you want to borrow: ");

            for (Newspaper newspaper : newspapers) {
                newspaper.displayDetails();
            }

            System.out.print("\nEnter ID: ");
            ID = sc.nextInt();

            int regex = this.viewNewsPaperByID(ID);
            if(regex!=-1){
                if(!newspapers.get(regex).isBorrowed){
                    newspapers.get(regex).isBorrowed = true;
                    borrower.borrowedItems.add(newspapers.get(regex));
                    newspapers.get(regex).popularityCount++;
                    System.out.println("Person: "+borrower.name+" has borrowed newspaper: "+newspapers.get(regex).title);
                }
                else {
                    System.out.println("Item is already borrowed");
                }
            }

        }

    }
}
