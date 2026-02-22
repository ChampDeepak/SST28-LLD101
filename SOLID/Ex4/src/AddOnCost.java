import java.util.HashMap;

public class AddOnCost 
{
    private HashMap<AddOn, Double> priceMap; 
    AddOnCost()
    {
        priceMap = new HashMap<>(); 
        priceMap.put(AddOn.GYM, 300.0); 
        priceMap.put(AddOn.LAUNDRY, 500.0); 
        priceMap.put(AddOn.MESS, 1000.0); 
    }
    public double getAddOnFee(AddOn service)  
    {
        return this.priceMap.get(service); 
    } 
}
