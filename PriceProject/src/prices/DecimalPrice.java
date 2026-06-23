package prices;

/**
 * DecimalPrice - מימוש עשרוני של מחיר
 * מייצג מחיר באמצעות מספר עשרוני וגורם הנחה בין 0 ל-1
 * 
 * הערה: discountFactor מייצג את החלק שנותר מהמחיר לאחר ההנחה
 * לדוגמה: 0.3 = 70% הנחה (נשאר 30% מהמחיר)
 * 
 * @author Student - Final Version
 */
public class DecimalPrice extends Price {
    
    // ========== Fields - Decimal Representation ==========
    private double price;
    private double discountFactor;  // החלק שנותר (0.3 = 70% הנחה)
    
    // ========== Constructor ==========
    
    public DecimalPrice(double price, double discountFactor) {
        setPrice(price);
        setDiscountFactor(discountFactor);
    }
    
    // ========== Private Helpers ==========
    
    private void setPrice(double price) {
        this.price = price < 0 ? 0 : price;
    }
    
    // ========== Implementing Price's abstract methods ==========
    
    @Override
    public double getBasePrice() {
        return price;
    }
    
    @Override
    public void setBasePrice(double price) {
        setPrice(price);
    }
    
    @Override
    public double getDiscountFactor() {
        return discountFactor;
    }
    
    @Override
    public void setDiscountFactor(double factor) {
        this.discountFactor = factor < 0 ? 0 : (factor > 1 ? 1 : factor);
    }
    
    // ========== raise & reduce (Overloading as required) ==========
    
    @Override
    public void raise(int shekel, int agora) {
        double amount = shekel + agora / 100.0;
        setPrice(price + amount);
    }
    
    @Override
    public void raise(int percent) {
        if (percent < 0) percent = 0;
        setPrice(price * (1 + percent / 100.0));
    }
    
    @Override
    public void reduce(int shekel, int agora) {
        double amount = shekel + agora / 100.0;
        setPrice(Math.max(price - amount, 0));
    }
    
    @Override
    public void reduce(int percent) {
        if (percent < 0) percent = 0;
        if (percent >= 100) {
            setPrice(0);
        } else {
            setPrice(price * (1 - percent / 100.0));
        }
    }
    
    // ========== Specific Methods ==========
    
    public double getPrice() {
        return price;
    }
    
    // ========== equals - Works with any Price ==========
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Price)) return false;
        
        Price other = (Price) obj;
        final double EPSILON = 0.001;
        
        return Math.abs(this.getBasePrice() - other.getBasePrice()) < EPSILON &&
               Math.abs(this.getDiscountFactor() - other.getDiscountFactor()) < EPSILON;
    }
    
    // ========== toString ==========
    
    @Override
    public String toString() {
        return String.format("The original price is %.2f NIS. The discount is: %.0f%%. The final price is: %.2f NIS.",
                price, getDiscountPercent(), costAfterDiscount());
    }
}