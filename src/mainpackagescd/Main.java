package mainpackagescd;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookClass.nextId = 0;
        Scanner sc = new Scanner(System.in);
        int index = -1;

        Library library = new Library("books.txt");

        library.displayMenu();


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


    }
}