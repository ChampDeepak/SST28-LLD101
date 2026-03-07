import java.nio.charset.StandardCharsets;

public class CsvExporter extends Exporter {
    
    public ExportResult doExport(ExportRequest req) {
        // LSP issue: changes meaning by lossy conversion
        String csv = "title,body\n" + csvFormatter(req.title) + "," + csvFormatter(req.body) + "\n";
        return new ExportResult("text/csv", csv.getBytes(StandardCharsets.UTF_8));
    }

    String csvFormatter(String value)
    {
        String escaped = value.replace("\"", "\"\""); 
        return "\"" + escaped + "\""; 
    }
}
