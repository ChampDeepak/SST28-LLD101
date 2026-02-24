import java.util.List;

public interface DB 
{
    public void save(StudentRecord r);
    public int count();
    public List<StudentRecord> all(); 
}
