public abstract class MembershipPlan {

    private String planCode;
    private String clientName;
    private int months;
    private double baseMonthlyFee;
    private boolean autoRenew;

    public MembershipPlan(String planCode, String clientName, int months, double baseMonthlyFee, boolean autoRenew) {

        this.planCode = planCode;
        this.clientName = clientName;
        this.months = months;
        this.baseMonthlyFee = baseMonthlyFee;
        this.autoRenew = autoRenew;
    }

    public String

    public abstract String getPlanType ();

    public abstract double calculateMonthlyNetPrice ();

    public double calculateMonthlyGrossPrice() {
        return 0;
    }

    public double calculateTotalNetPrice() {
        return 0;
    }

    public final void printSummary() {
        return 0;
    }

    public String toString() {

        return
    }

}
