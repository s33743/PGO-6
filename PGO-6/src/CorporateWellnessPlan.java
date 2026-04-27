public class CorporateWellnessPlan extends MembershipPlan implements Freezable, RemoteAccess{

    private int employeeCount;
    private int workshopsPerMonth;
    private boolean onlineDashboard;

    public int getEmployeeCount() {
        return employeeCount;
    }

    public int getWorkshopsPerMonth() {
        return workshopsPerMonth;
    }

    public boolean isOnlineDashboard() {
        return onlineDashboard;
    }

    public CorporateWellnessPlan(String planCode,
                                 String clientName,
                                 int months,
                                 double baseMonthlyFee,
                                 boolean autoRenew,
                                 int employeeCount,
                                 int workshopsPerMonth,
                                 boolean onlineDashboard) {
        super(planCode, clientName, months, baseMonthlyFee, autoRenew);

        this.employeeCount = employeeCount;
        this.workshopsPerMonth = workshopsPerMonth;
        this.onlineDashboard = onlineDashboard;
    }

    @Override
    public String getPlanType() {
        return "CORPORATE WELLNESS PLAN";
    }

    @Override
    public double calculateMonthlyNetPrice() {
        double cena = this.getBaseMonthlyFee();

        cena += this.getEmployeeCount() * 18;
        cena += this.getWorkshopsPerMonth() * 220;

        if (getEmployeeCount()>=20) {
            cena *= 0.88;
        }
        if (isOnlineDashboard()) {
            cena += 80;
        }
        return cena;
    }

    @Override
    public boolean hasOnlineAccess() {
        return this.isOnlineDashboard();
    }

    @Override
    public boolean canFreeze() {
        return this.getMonths() >= 6 && this.getWorkshopsPerMonth() == 0;
    }
}
