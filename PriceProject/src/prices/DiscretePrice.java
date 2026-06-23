package prices;

/**
 * DiscretePrice - מימוש בדיד של מחיר
 * מייצג מחיר באמצעות שקלים, אגורות ואחוז הנחה (כולם מספרים שלמים)
 * 
 * הערה: discountFactor מייצג את החלק שנותר מהמחיר לאחר ההנחה
 * לדוגמה: 0.3 = 70% הנחה (נשאר 30% מהמחיר)
 * 
 * @author Student - Final Version (Fixed)
 */
public class DiscretePrice extends Price {
    
    // ========== Fields - Discrete Representation ==========
    private int shekel;
    private int agora;
    private int discountPercent;  // 0-100 (אחוז ההנחה האמיתי)
    
    // ========== Constructor ==========
    
    public DiscretePrice(int shekel, int agora, int discountPercent) {
        this.shekel = shekel < 0 ? 0 : shekel;
        this.agora = (agora < 0) ? 0 : (agora >= 100 ? 99 : agora);
        this.discountPercent = (discountPercent < 0) ? 0 : (discountPercent > 100 ? 100 : discountPercent);
    }
    
    // ========== Implementing Price's abstract methods ==========
    
    @Override
    public double getBasePrice() {
        return shekel + agora / 100.0;
    }
    
    @Override
    public void setBasePrice(double price) {
        if (price < 0) price = 0;
        this.shekel = (int) price;
        this.agora = (int) Math.round((price - this.shekel) * 100);
        if (this.agora >= 100) {
            this.shekel += this.agora / 100;
            this.agora %= 100;
        }
    }
    
    @Override
    public double getDiscountFactor() {
        // מחזיר את החלק שנותר: 70% → 0.3
        return (100 - discountPercent) / 100.0;
    }
    
    @Override
    public void setDiscountFactor(double factor) {
        // factor הוא החלק שנותר (0.3 = 70% הנחה)
        // ממיר לאחוז הנחה: discountPercent = (1 - factor) * 100
        if (factor < 0) factor = 0;
        if (factor > 1) factor = 1;
        double percent = (1 - factor) * 100;
        this.discountPercent = (int) Math.round(percent);
        if (this.discountPercent < 0) this.discountPercent = 0;
        if (this.discountPercent > 100) this.discountPercent = 100;
    }
    
    @Override
    public double costAfterDiscount() {
        // מחיר סופי = מחיר מקורי × החלק שנותר
        return getBasePrice() * getDiscountFactor();
    }
    
    // ========== raise & reduce (Overloading as required) ==========
    
    @Override
    public void raise(int shekel, int agora) {
        int newAgora = this.agora + agora;
        int newShekel = this.shekel + shekel;
        if (newAgora >= 100) {
            newShekel += newAgora / 100;
            newAgora %= 100;
        }
        if (newAgora < 0) newAgora = 0;
        if (newShekel < 0) newShekel = 0;
        this.shekel = newShekel;
        this.agora = newAgora;
    }
    
    @Override
    public void raise(int percent) {
        if (percent < 0) percent = 0;
        double multiplier = 1 + percent / 100.0;
        double newPrice = getBasePrice() * multiplier;
        this.shekel = (int) newPrice;
        this.agora = (int) Math.round((newPrice - this.shekel) * 100);
        if (this.agora >= 100) {
            this.shekel += this.agora / 100;
            this.agora %= 100;
        }
    }
    
    @Override
    public void reduce(int shekel, int agora) {
        int newAgora = this.agora - agora;
        int newShekel = this.shekel - shekel;
        while (newAgora < 0) {
            newAgora += 100;
            newShekel--;
        }
        if (newShekel < 0) {
            newShekel = 0;
            newAgora = 0;
        }
        this.shekel = newShekel;
        this.agora = newAgora;
    }
    
    @Override
    public void reduce(int percent) {
        if (percent < 0) percent = 0;
        if (percent >= 100) {
            this.shekel = 0;
            this.agora = 0;
        } else {
            double multiplier = 1 - percent / 100.0;
            double newPrice = getBasePrice() * multiplier;
            this.shekel = (int) newPrice;
            this.agora = (int) Math.round((newPrice - this.shekel) * 100);
            if (this.agora >= 100) {
                this.shekel += this.agora / 100;
                this.agora %= 100;
            }
        }
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
        return String.format("The original price is %d shekels and %d agorot. The discount is: %d%%. The final price is: %.2f NIS.",
                shekel, agora, discountPercent, costAfterDiscount());
    }
}