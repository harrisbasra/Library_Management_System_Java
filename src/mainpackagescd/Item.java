package mainpackagescd;

 class Item implements Configuration {
    int id;
    String title;
    int itemType;
    int popularityCount;
    boolean isBorrowed;
    double itemPrice;
    @Override
    public void displayDetails(){

    }
    @Override
    public double calculatePrice(){
       return 0.0;
    }
}
