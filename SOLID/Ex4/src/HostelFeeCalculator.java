import java.util.*;

public class HostelFeeCalculator {
    // private final FakeBookingRepo repo;

    // public HostelFeeCalculator(FakeBookingRepo repo) { this.repo = repo; }

    // Solved: OCP violation: switch + add-on branching + printing + persistence.
    

     static Money calculateMonthly(BookingRequest req) {
        
        // removed switch-case on room types
        double base = LegacyRoomTypes.roomPrice(req.roomType);
        

        // now Add-ons can be added without editing the core fee algorithm
        double add = 0.0;
        AddOnCost addOnCost = new AddOnCost(); 
        for (AddOn a : req.addOns) add  += addOnCost.getAddOnFee(a); 
        

        return new Money(base + add);
    }
}
