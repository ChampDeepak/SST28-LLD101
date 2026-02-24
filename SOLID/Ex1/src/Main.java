public class Main 
{
    public static void main(String[] args) 
    {
        
        FakeDb db = new FakeDb();
        OnboardingService svc = new OnboardingService();

        String raw = "name=Riya;email=riya@sst.edu;phone=9876543210;program=CSE";
        svc.registerFromRawInput(raw);

        System.out.println();
        System.out.println("-- DB DUMP --");
        System.out.print(TextTable.render3(db));
    }
}
