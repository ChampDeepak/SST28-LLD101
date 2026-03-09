public class SmsSender extends NotificationSender {
    public SmsSender(AuditLog audit) { super(audit); }

    @Override
    public NotificationOutput doSend(NotificationInput n) {
        // Ignores subject; base type doesn't clarify expectations (smell)
        String content = "SMS -> to=" + n.phone + " body=" + n.body;
        String auditMessage = "sms sent"; 
        return new NotificationOutput(auditMessage, content); 
    }
}
