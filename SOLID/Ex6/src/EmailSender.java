public class EmailSender extends NotificationSender {
    public EmailSender(AuditLog audit) { super(audit); }

    @Override
    public NotificationOutput doSend(NotificationInput n) {
        // LSP smell: truncates silently, changing meaning
        String body = n.body;
        // if (body.length() > 40) body = body.substring(0, 40);
        String content =  "EMAIL -> to=" + n.email + " subject=" + n.subject + " body=" + body;
        String auditMessage = "email sent";
        return new NotificationOutput(auditMessage, content); 
    }
}
