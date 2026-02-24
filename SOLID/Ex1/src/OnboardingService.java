
import java.util.*;

public class OnboardingService 
{
    // private final FakeDb db;

    // public OnboardingService(FakeDb db) { this.db = db; }

    // Intentionally violates SRP: parses + validates + creates ID + saves + prints.
    public void registerFromRawInput(String raw) 
    {
        System.out.println("INPUT: " + raw);

        // Now OnboardingService is not responsible for parsing logic. 
        Map<String,String> kv = InputParser.parse(raw); 

        
        // In next 11 lines: user input is validated
        String name = kv.getOrDefault("name", "");
        String email = kv.getOrDefault("email", "");
        String phone = kv.getOrDefault("phone", "");
        String program = kv.getOrDefault("program", "");

        // Now OnboardingService is not responsible for validation logic. 
        boolean isValidInput = Validate.isValidInput(kv); 
        if(!isValidInput) return; 


        // In next 9 lines: user info is saved in db & success message is printed  
        // String id = IdUtil.nextStudentId(db.count());
        // StudentRecord rec = new StudentRecord(id, name, email, phone, program);

        // db.save(rec);

        // System.out.println("OK: created student " + id);
        // System.out.println("Saved. Total students: " + db.count());
        // System.out.println("CONFIRMATION:");
        // System.out.println(rec);
    }
}
