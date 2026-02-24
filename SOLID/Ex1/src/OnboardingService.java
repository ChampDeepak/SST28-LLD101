
import java.util.*;

public class OnboardingService 
{
    DBConfirmationMessage dbConfirmationMessage; 
    
    // Intentionally violates SRP: parses + validates + creates ID + saves + prints.
    public void registerFromRawInput(String raw) 
    {
        
        // Now OnboardingService is not responsible for parsing logic. 
        Map<String,String> kv = InputParser.parse(raw); 


        // Now OnboardingService is not responsible for validation logic. 
        List<String> errors = Validate.isValidInput(kv); 
        
        // Now OnboardingService is not responsible for persistence logic.
        if(errors.isEmpty()) dbConfirmationMessage = StudentSaver.save(kv);
       
        // Now OnboardingService is not responsible for formatting & printing logic. 
        LoggingService.print(raw, errors, dbConfirmationMessage);
        
    }
}
