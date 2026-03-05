

class RuleResult {
    public final boolean passed;
    public final String reason; 
    
    RuleResult(boolean passed, String reason)
    {
        this.passed = passed;
        this.reason = reason; 
    }
    public static RuleResult pass()
    {
        return new RuleResult(true, null); 
    }
    public static RuleResult fail(String string) 
    {
        return new RuleResult(false, string); 
    }
}
