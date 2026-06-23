package prices;

public class Main {
    
    /**
     * מחזירה את המחיר הגבוה ביותר לאחר הנחה
     * @param p1 מחיר ראשון
     * @param p2 מחיר שני
     * @return המחיר עם המחיר הסופי הגבוה יותר
     */
    public static Price maxPrice(Price p1, Price p2) {
        return p1.costAfterDiscount() >= p2.costAfterDiscount() ? p1 : p2;
    }
    
    public static void main(String[] args) {
        // יצירת שני מחירים - בדיד ועשרוני
        Price p1 = new DiscretePrice(7, 60, 70);  // 7.60 NIS, 70% discount
        Price p2 = new DecimalPrice(7.6, 0.3);    // 7.60 NIS, 70% discount
        
        // שימוש ב-toString (קיים ב-Price)
        System.out.println("Price 1: " + p1);
        System.out.println("Price 2: " + p2);
        
        // בדיקת equals בין שני סוגים שונים
        System.out.println("\nAre prices equal? " + p1.equals(p2));
        
        // שימוש ב-maxPrice - זה מה שהשאלה מבקשת להדגים
        Price max = maxPrice(p1, p2);
        System.out.println("\nMax price after discount:");
        System.out.println(max);
    }
}