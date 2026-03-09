public abstract class NotificationSender {
    protected final AuditLog audit;
    protected NotificationSender(AuditLog audit) { this.audit = audit; }
    public void send(NotificationInput n)
    {
        NotificationOutput notificationOutput = doSend(n); 
        audit.add(notificationOutput.auditMessage);
        System.out.println(notificationOutput.content);
    }
    abstract NotificationOutput doSend(NotificationInput n); 
}
