public class ReportService {

    private String countryOfBranch;
    private double totalIncomeOfYear;
    private double totalProfitOfYear;

    public ReportService(String countryOfBranch, double totalIncomeOfYear, double totalProfitOfYear) {
        this.countryOfBranch = countryOfBranch;
        this.totalIncomeOfYear = totalIncomeOfYear;
        this.totalProfitOfYear = totalProfitOfYear;
    }
}
