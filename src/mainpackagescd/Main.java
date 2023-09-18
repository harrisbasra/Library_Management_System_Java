package mainpackagescd;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Book.nextId = 0;

//        Scanner sc = new Scanner(System.in);
//        int index = -1;


        //..............................................................................................

        Library l1 = new Library("books.txt");
//        library.displayMenu();

        //..............................................................................................


//        String Auth, Title;
//        int year;
//
//        System.out.print("Enter the title of the Book : ");
//        Title = sc.nextLine();
//
//        System.out.print("Enter the author of the Book : ");
//        Auth = sc.nextLine();
//
//        System.out.print("Enter the year of publication of the Book : ");
//        year = sc.nextInt();
//
//        library.addBook(new BookClass(Title, Auth, year));
//        library.displayBooks();

//        BookClass book = new BookClass(Title, Auth, year);
//        book.Print();

        //..............................................................................................
//        String[] auth = {"AuthA", "AuthB", "AuthC"};
//
//        Item book = new Book("ABC", "XYZ", 123);
//        Item mag = new Magazine("ABC", auth, "Publisher XYZ");
//        Item akhbaar = new Newspaper("ABC", "MM-DD-YYYY", "Publisher XYZ");
//
//        library.dynamicallyIdentify(book);
//        library.dynamicallyIdentify(mag);
//        library.dynamicallyIdentify(akhbaar);
        //...............................................................................................

//        Borrower b1 = new Borrower("HarreyBe");
//        l1.borrowItem(b1);
//        l1.borrowItem(b1);

        //...............................................................................................

        l1.displayMenu();


    }
}