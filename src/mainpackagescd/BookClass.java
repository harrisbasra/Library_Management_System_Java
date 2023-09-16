package mainpackagescd;

public class BookClass {
    static int nextId;
    int id;
    String title;
    String author;
    int year;

    BookClass(String t, String a, int y){
        id = nextId++;
        title = t;
        author = a;
        year = y;

        System.out.print("New Book Added: ");
    }

    BookClass(int i, String t, String a, int y){
        id = nextId++;
        title = t;
        author = a;
        year = y;

        System.out.print("New Book Added: ");
    }

    void displayDetails(){
        System.out.println("ID: "+ nextId + " Title: " + title + " by Author: " + author + "(" + year + ")");
    }
}
