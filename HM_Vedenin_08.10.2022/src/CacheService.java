import java.util.HashMap;
import java.util.Map;

public class CacheService {

    public static void main(String[] args) {
        ReportService r1 = new ReportService("Germany", 1946736.05, 235974.83);
        ReportService r2 = new ReportService("Poland", 1356729.10, 247893.98);
        ReportService r3 = new ReportService("The Netherlands", 1100893.88, 102982.20);

        Map<String, ReportService> map = new HashMap<>();
            map.put("Germany", r1);
            map.put("Poland", r2);
            map.put("The Netherlands", r3);
    }
}
