package prices;

public class MaxPrice {
    
    public static Price maxPrice(Price p1, Price p2) {
        return p1.costAfterDiscount() >= p2.costAfterDiscount() ? p1 : p2;
    }
    
    public static void main(String[] args) {
        Price p1 = new DiscretePrice(7, 60, 70);  // 7.60 NIS, 70% discount
        Price p2 = new DecimalPrice(7.6, 0.3);    // 7.60 NIS, 70% discount
        
        System.out.println("Price 1: " + p1);
        System.out.println("Price 2: " + p2);
        
        Price max = maxPrice(p1, p2);
        System.out.println("\nMax price after discount:");
        System.out.println(max);
    }
}