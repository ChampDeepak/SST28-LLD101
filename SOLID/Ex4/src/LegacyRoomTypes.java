import java.util.HashMap;

public class LegacyRoomTypes {
    public static final int SINGLE = 1;
    public static final int DOUBLE = 2;
    public static final int TRIPLE = 3;
    public static final int DELUXE = 4;
    private static HashMap<Integer, Double> priceMap; 
    
    public static String nameOf(int t) {
        return switch (t) {
            case SINGLE -> "SINGLE";
            case DOUBLE -> "DOUBLE";
            case TRIPLE -> "TRIPLE";
            default -> "DELUXE";
        };
    }

    public static double roomPrice(int roomType) 
    {
       //Building priceMap
       priceMap = new HashMap<>(); 
       priceMap.put(1, 14000.0);
       priceMap.put(2, 15000.0);
       priceMap.put(3, 12000.0); 
       priceMap.put(4, 16000.0); 

       //Returning price based on roomType 
       if(priceMap.containsKey(roomType)) return priceMap.get(roomType); 
       return priceMap.get(4); 
    }
}
