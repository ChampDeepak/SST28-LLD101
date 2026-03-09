public class WhatsAppSender extends NotificationSender {
    
    public WhatsAppSender(AuditLog audit) { super(audit); }

    @Override
    public NotificationOutput doSend(NotificationInput n) {
        // LSP violation: tightens precondition
        String auditMessage; 
        String content; 
        if (n.phone == null || !n.phone.startsWith("+")) 
        {
            // throw new IllegalArgumentException("phone must start with + and country code");
            content = "WA ERROR: phone must start with + and country code";
            auditMessage = "WA failed"; 
        }
        else
        {
            content = "WA -> to=" + n.phone + " body=" + n.body;
            auditMessage = "wa sent"; 
        }
        return new NotificationOutput(auditMessage, content); 
    }
}
