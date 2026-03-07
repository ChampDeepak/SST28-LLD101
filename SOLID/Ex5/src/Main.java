public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Export Demo ===");

        ExportRequest req = new ExportRequest("Weekly Report", SampleData.longBody());
        
        PdfExporter pdf = new PdfExporter();
        Exporter csv = new CsvExporter();
        Exporter json = new JsonExporter();

        try { 
                System.out.println("PDF: " + pdf.export(req));}
        catch (RuntimeException ex){
            System.out.println("ERROR: " + ex.getMessage()); 
        }

        System.out.println("CSV: " + safe(csv, req));
        System.out.println("JSON: " + safe(json, req));
    }

    private static String safe(Exporter e, ExportRequest r) throws Exception {
        try {
            ExportResult out = e.export(r);
            return "OK bytes=" + out.bytes.length;
        } catch (RuntimeException ex) {
            return "ERROR: " + ex.getMessage();
        }
    }
}
