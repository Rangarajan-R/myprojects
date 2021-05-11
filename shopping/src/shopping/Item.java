package shopping;



class Item{
  // properties
  private String iname;
  private int qty;
  private double price;
  private double totalPrice;
  java.util.Date date=new java.util.Date(); 
  // constructor
  Item(String iname, int qty, 
              double price, double totalPrice) {
    this.iname = iname;
    this.qty = qty;
    this.price = price;
    this.totalPrice = totalPrice;
  }

  // getter methods
  public String getIname() {
    return iname;
  }
  public int getQty() {
    return qty;
  }
  public double getPrice() {
    return price;
  }
  public double getTotalPrice() {
    return totalPrice;
  }

  // displayFormat
  public static void displayFormat() {
    System.out.print(
        "\nName      Quantity    Price   Total Price     Date\n");
  }

  // display
  public void display() {
    System.out.format("%-9s %8d %10.2f %10.2f %30s\n", 
         iname, qty, price, totalPrice,date);
    
  }
}

