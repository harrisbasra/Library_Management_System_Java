package mainpackagescd;

public class Newspaper extends Item {
    static int nextId;
    String publisherCompany;
    String date;

    Newspaper(String t, String d, String pC){

        itemType = 3;
        id = nextId++;
        title = t;
        date = d;
        publisherCompany = pC;

        System.out.println("New Book Added: ID:"+ id + " Title: " + title + " by Company: " + publisherCompany + " on "+date);
    }

    Newspaper(int i, String t, String d, String pC){

        itemType = 3;
        id = i;
        title = t;
        date = d;
        publisherCompany = pC;

        System.out.print("New Book Added: ");
    }

    public void displayDetails(){
        System.out.println("ID: "+ id + " Title: " + title + " by Company: " + publisherCompany + " on "+date+ " with popularity at: "+ popularityCount + " priced at : $"+ itemPrice);
    }
}
