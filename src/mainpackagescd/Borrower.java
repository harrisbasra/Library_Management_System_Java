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
}
