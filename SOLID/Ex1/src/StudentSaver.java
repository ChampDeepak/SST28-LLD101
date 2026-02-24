import java.util.Map;

public class StudentSaver 
{
    private static final DB db = new FakeDb();
    public static DBConfirmationMessage save(Map<String, String> kv)
    {
        String name = kv.get("name");
        String email = kv.get("email");
        String phone = kv.get("phone");
        String program = kv.get("program");

        String id = IdUtil.nextStudentId(db.count());
        StudentRecord rec = new StudentRecord(id, name, email, phone, program);

        db.save(rec);

        return new DBConfirmationMessage(id, db.count(), rec.toString()); 
    }
}
