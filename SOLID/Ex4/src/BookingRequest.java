import java.util.*;

public class BookingRequest {
    public final int roomType;
    public final List<AddOn> addOns;
    private final FakeBookingRepo repo;
    Money monthly; 
    Money deposit; 

    public BookingRequest(int roomType, List<AddOn> addOns) {
        this.roomType = roomType;
        this.addOns = addOns;
        this.monthly = HostelFeeCalculator.calculateMonthly(this);
        this.deposit = new Money(5000.00); 
        this.repo = new FakeBookingRepo();
    }

    // Separation of Concern: ReceiptPrinter.print() is handeling printing logic
    public void print()
    {
        ReceiptPrinter.print(this, monthly, deposit);
    }

    // Separation of Concern: repo.save() is handeling saving logic and it is independendent from print() method 
    public void save() {
        String bookingId = "H-" + (7000 + new Random(1).nextInt(1000)); // deterministic-ish
        repo.save(bookingId, this, monthly, deposit);
    }
}
