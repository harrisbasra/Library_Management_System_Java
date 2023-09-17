package mainpackagescd;

public class Book extends Item {
    static int nextId;
    String author;
    int year;

    Book(int iT, String t, String a, int y, int pC, double p$){

        itemType = iT;
        id = nextId++;
        title = t;
        author = a;
        year = y;
        popularityCount = pC;
        itemPrice = p$;

        System.out.println("New Book Added: ID: "+id+" Title: "+title+" Author: "+author+" Year: "+year);
    }

    Book(int iT, int i, String t, String a, int y, int pC, int p$){

        itemType = 1;
        id = nextId++;
        title = t;
        author = a;
        year = y;

        System.out.print("New Book Added: ");
    }

    public void displayDetails(){
        System.out.println("ID: "+ id + " Title: " + title + " by Author: " + author + "(" + year + ") with popularity: " + popularityCount + " priced at : $"+ itemPrice);
    }
}
