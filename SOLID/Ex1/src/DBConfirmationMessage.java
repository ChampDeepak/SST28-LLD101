
public class DBConfirmationMessage 
{
    private String newStudentId; 
    private int totalStudents; 
    private String newStudentDetails; 
    

    DBConfirmationMessage(String newStudentId, int totalStudents, String newStudentDetails)
    {
        this.newStudentId = newStudentId;
        this.totalStudents = totalStudents;
        this.newStudentDetails = newStudentDetails; 
    }

    public String getNewStudentId() {
        return newStudentId;
    }

    public int getTotalStudents() {
        return totalStudents;
    }

    public String getNewStudentDetails() {
        return newStudentDetails;
    }

    
}
