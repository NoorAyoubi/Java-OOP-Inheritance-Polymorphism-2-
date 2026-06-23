package prices;

/**
 * מחלקה אבסטרקטית המייצגת מחיר עם הנחה.
 * מהווה חוזה משותף ל-DiscretePrice ו-DecimalPrice.
 * כל תת-מחלקה חופשית לייצג את המחיר וההנחה בדרך שלה.
 * 
 * הערה: discountFactor מייצג את החלק שנותר מהמחיר לאחר ההנחה
 * לדוגמה: 0.3 = 70% הנחה (נשאר 30% מהמחיר)
 * 
 * @author Student - Final Version (Fixed)
 */
public abstract class Price {
    
    // ========== Abstract Methods - Price Representation ==========
    
    /** @return המחיר לפני הנחה כ-double */
    public abstract double getBasePrice();
    
    /** קובע מחיר חדש לפני הנחה */
    public abstract void setBasePrice(double price);
    
    // ========== Abstract Methods - Discount Representation ==========
    
    /** 
     * @return גורם ההנחה - החלק שנותר מהמחיר לאחר ההנחה
     * 0.0 = 100% הנחה, 1.0 = 0% הנחה
     */
    public abstract double getDiscountFactor();
    
    /** קובע גורם הנחה חדש (בין 0 ל-1) - החלק שנותר */
    public abstract void setDiscountFactor(double factor);
    
    // ========== Convenience Methods (Percent-based) ==========
    
    /** @return אחוז ההנחה (0-100) */
    public double getDiscountPercent() {
        return (1 - getDiscountFactor()) * 100;  // 0.3 → 70%
    }
    
    /** קובע אחוז הנחה (0-100) */
    public void setDiscountPercent(double percent) {
        setDiscountFactor((100 - percent) / 100.0);  // 70% → 0.3
    }
    
    // ========== Core Business Logic ==========
    
    /** @return המחיר לאחר הנחה */
    public double costAfterDiscount() {
        return getBasePrice() * getDiscountFactor();  // price × remaining part
    }
    
    // ========== Overloading - raise & reduce ==========
    
    /** העלאה בסכום קבוע (שקלים ואגורות) */
    public void raise(int shekel, int agora) {
        double amount = shekel + agora / 100.0;
        setBasePrice(getBasePrice() + amount);
    }
    
    /** העלאה באחוזים */
    public void raise(int percent) {
        setBasePrice(getBasePrice() * (1 + percent / 100.0));
    }
    
    /** הורדה בסכום קבוע (שקלים ואגורות) */
    public void reduce(int shekel, int agora) {
        double amount = shekel + agora / 100.0;
        setBasePrice(Math.max(getBasePrice() - amount, 0));
    }
    
    /** הורדה באחוזים */
    public void reduce(int percent) {
        setBasePrice(getBasePrice() * (1 - percent / 100.0));
    }
    
    // ========== Object Methods ==========
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Price)) return false;
        
        Price other = (Price) obj;
        final double EPSILON = 0.001;
        
        return Math.abs(this.getBasePrice() - other.getBasePrice()) < EPSILON &&
               Math.abs(this.getDiscountFactor() - other.getDiscountFactor()) < EPSILON;
    }
    
    @Override
    public String toString() {
        return String.format("The original price is %.2f NIS. The discount is: %.0f%%. The final price is: %.2f NIS.",
                getBasePrice(), getDiscountPercent(), costAfterDiscount());
    }
}