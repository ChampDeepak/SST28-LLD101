

class AttendanceRule implements EligibilityRule {
    public RuleResult check(StudentProfile s) {
        if (s.attendancePct < 75)
            return RuleResult.fail("attendance below 75");
        return RuleResult.pass();
    }
}