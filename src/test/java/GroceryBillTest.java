import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public
class GroceryBillTest {

    @Test
    public void shouldReturnValueOf40RupeesWhen2KgOfOnionsIsBought() throws Exception{
        GroceryBill groceryBill = new GroceryBill(0);

        groceryBill.calculate("Onion","2Kg");
        double billExpected = groceryBill.displayBill();

        assertThat(billExpected , is(closeTo(40.0,0.1)));
    }

    @Test
    public void shouldReturnTheBillWhenMultipleProductsOfKgMetricsAreAdded() throws Exception{
        GroceryBill groceryBill = new GroceryBill(0);

        groceryBill.calculate("Onion","2Kg");
        groceryBill.calculate("Apple","1Kg");
        groceryBill.calculate("Rice","3Kg");
        double billExpected = groceryBill.displayBill();

        assertThat(billExpected , is(closeTo(343.5,0.1)));
    }
    @Test
    public void shouldReturnTheBillWhenMultipleProductsOfGmMetricsAreAdded() throws Exception{
        GroceryBill groceryBill = new GroceryBill(0);

        groceryBill.calculate("Onion","500gm");
        groceryBill.calculate("Apple","5Kg");
        groceryBill.calculate("Rice","300gm");

        double billExpected = groceryBill.displayBill();

        assertThat(billExpected , is(closeTo(1020.35,0.1)));
    }

}
