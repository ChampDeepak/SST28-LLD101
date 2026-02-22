import java.util.*;

public class HostelFeeCalculator {
    private final FakeBookingRepo repo;

    public HostelFeeCalculator(FakeBookingRepo repo) { this.repo = repo; }

    // OCP violation: switch + add-on branching + printing + persistence.
    public void process(BookingRequest req) {
        Money monthly = calculateMonthly(req);
        Money deposit = new Money(5000.00);

        ReceiptPrinter.print(req, monthly, deposit);

        String bookingId = "H-" + (7000 + new Random(1).nextInt(1000)); // deterministic-ish
        repo.save(bookingId, req, monthly, deposit);
    }

    private Money calculateMonthly(BookingRequest req) {
        
        // removed switch-case on room types
        double base = LegacyRoomTypes.roomPrice(req.roomType);
        

        // now Add-ons can be added without editing the core fee algorithm
        double add = 0.0;
        AddOnCost addOnCost = new AddOnCost(); 
        for (AddOn a : req.addOns) add  += addOnCost.getAddOnFee(a); 
        

        return new Money(base + add);
    }
}
