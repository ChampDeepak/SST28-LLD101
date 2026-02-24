import java.util.List;

public class LoggingService 
{
    public static void print(String raw, List<String> errors, DBConfirmationMessage message)
    {
        System.out.println("=== Student Onboarding ===");
        System.out.println("INPUT: " + raw);
        if(errors.isEmpty()) 
        {
            if(message!=null)
            {
                System.out.println("OK: created student " + message.getNewStudentId());
                System.out.println("Saved. Total students: " + message.getTotalStudents());
                System.out.println("CONFIRMATION:");
                System.out.println(message.getNewStudentDetails());
            }
            else System.out.println("DB Error: Error in writing the student data in db.");
        }
        else
        {
            System.out.println("ERROR: cannot register");
            for (String e : errors) System.out.println("- " + e);
        }
    }
}
