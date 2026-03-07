import java.nio.charset.StandardCharsets;

public class JsonExporter extends Exporter {

    public ExportResult doExport(ExportRequest req) {
        // inconsistent handling (surprise)
        String json = "{\"title\":\"" + jsonFormatter(req.title) + "\",\"body\":\"" + jsonFormatter(req.body) + "\"}";
        return new ExportResult("application/json", json.getBytes(StandardCharsets.UTF_8));
    }

    private String jsonFormatter(String s) {
        return s.replace("\"", "\\\"");
    }
}
