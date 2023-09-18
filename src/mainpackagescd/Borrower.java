package mainpackagescd;

import java.util.ArrayList;
import java.util.List;

public class Borrower {
    String name;
    List<Item> borrowedItems;
    Borrower(String n){
        name = n;
        borrowedItems = new ArrayList<>();
    }

    void displayBorrowedItems(){
        for (int i=0;i<borrowedItems.size();i++){
            System.out.println((i+1)+") "+borrowedItems.get(i).title);
        }
    }
}
