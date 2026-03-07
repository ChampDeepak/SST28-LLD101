public abstract class Exporter 
{

    public final ExportResult export(ExportRequest req) throws Exception
    {
        validate(req); 
        return doExport(req); 
    }

    abstract ExportResult doExport(ExportRequest req);

    private final void validate(ExportRequest req) throws Exception 
    {
        if(req==null) throw new Exception("ExportRequest Object can not be null"); 
        else if(req.body==null) throw new Exception("Request Body can not be null");
        else if(req.title==null) throw new Exception("Request Title can not be null"); 
    }
}
