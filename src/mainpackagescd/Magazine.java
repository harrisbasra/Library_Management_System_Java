package mainpackagescd;

public class Magazine extends Item {
    static int nextId;
    String publisherCompany;
    String[] authors;

    Magazine(String t, String[] a, String pC, int price, int popC){

        itemType = 2;
        id = nextId++;
        title = t;
        authors = a;
        publisherCompany = pC;
        itemPrice = price;
        popularityCount = popC;

        System.out.print("New Book Added: ");
        this.displayDetails();
    }

    Magazine(int i, String t, String[] a, String pC, int price, int popC){

        itemType = 2;
        id = i;
        title = t;
        authors = a;
        publisherCompany = pC;
        itemPrice = price;
        popularityCount = popC;

        System.out.print("New Book Added: ");
    }

    public void displayDetails(){
        System.out.println("ID: "+ id + " Title: " + title + " by Company: " + publisherCompany + " with popularity of: "+ popularityCount + " priced at : $"+ itemPrice + ". The Authors are: ");
        for (String author : authors) {
            System.out.println(author);
        }
    }

    @Override
    public double calculatePrice() {
        return itemPrice*popularityCount;
    }
}
