import java.util.ArrayList;
public class TestOrders {
    public static void main(String[] args) {

        // menu itmes
        Item item1 = new Item();
        Item item2 = new Item();
        Item item3 = new Item();
        Item item4 = new Item();

        // Order Variables

        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order();
        Order order4 = new Order();

        //item1
        item1.name="Mocha";
        item1.price=2;
        //item2
        item2.name="latte";
        item2.price=1.5;
        //item3
        item3.name="drip coffee";
        item3.price=4;
        //item4
        item4.name="cappuccino";
        item4.price=4.5;
        
        //oreder1
        order1.name="Cindhuri";
        //order2
        order2.name="Jimmy";
        //order3
        order3.name="Noah";
        //order4
        order4.name="Sam";

        //System.out.println(item3.name);
        // ad item1 to roder2
        System.out.println(order2.total);
        order2.items.add(item1);
        order2.total=+item1.price;
        System.out.println(order2.total);

        //order3 ordrered a cappuccino
        order3.items.add(item4);
        System.out.println(order3.items.get(0));
    }
}
