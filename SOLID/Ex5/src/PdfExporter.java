import java.nio.charset.StandardCharsets;

public class PdfExporter {
    
    public ExportResult export(ExportRequest req) {
        // LSP violation: tightens precondition arbitrarily
        if (req.body.length() > 20) {
            throw new IllegalArgumentException("PDF cannot handle content > 20 chars");
        }
        String fakePdf = "PDF(" + req.title + "):" + req.body;
        return new ExportResult("application/pdf", fakePdf.getBytes(StandardCharsets.UTF_8));
    }
}
