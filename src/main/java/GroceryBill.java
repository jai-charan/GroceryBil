import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class GroceryBill {
    private double amount;
    private final ArrayList<String> groceryItems;
    private final List<Number> itemsPrice;

    public GroceryBill(double amount){
        this.amount=amount;
        this.groceryItems = new ArrayList<>(Arrays.asList("Onion","Tomato","Apple","Kiwi","Salt","Rice"));
        this.itemsPrice = new ArrayList<>(Arrays.asList(20, 30, 200, 50, 10, 34.5));
    }

    private void calculateInGrams(int index, int value) {
        double price = (itemsPrice.get(index).doubleValue() * value)/1000 ;
        amount = amount + price;
    }

    private void calculateInKilograms(int index, int value) {
        double price = itemsPrice.get(index).doubleValue() * value ;
        amount = amount + price;
    }
    public void calculate(String item, String quantity) throws Exception{
        if (groceryItems.contains(item)) {
            int length = quantity.length();
            int index = groceryItems.indexOf(item);
            String numericPart = quantity.replaceAll("[^0-9]", "");
            int value = Integer.parseInt(numericPart);

            if(quantity.charAt(length-2) == 'K'){
                calculateInKilograms(index, value);
            }
            else {
                calculateInGrams(index , value);
            }

        }
    }
    public double displayBill() {
        return amount;
    }
}
