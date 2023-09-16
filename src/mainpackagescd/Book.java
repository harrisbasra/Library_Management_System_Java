package mainpackagescd;

public class Book extends Item {
    static int nextId;
    String author;
    int year;

    Book(String t, String a, int y){

        itemType = 1;
        id = nextId++;
        title = t;
        author = a;
        year = y;

        System.out.println("New Book Added: ID: "+id+" Title: "+title+" Author: "+author+" Year: "+year);
    }

    Book(int i, String t, String a, int y){

        itemType = 1;
        id = nextId++;
        title = t;
        author = a;
        year = y;

        System.out.print("New Book Added: ");
    }

    public void displayDetails(){
        System.out.println("ID: "+ id + " Title: " + title + " by Author: " + author + "(" + year + ")");
    }
}
