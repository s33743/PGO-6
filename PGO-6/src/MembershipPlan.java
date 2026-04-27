
public abstract class MembershipPlan {
implements Billable{

}

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

    public abstract String getPlanType();

    public String getPlanCode() {
        return planCode;
    }

    public String getClientName() {
        return clientName;
    }

    public int getMonths() {
        return months;
    }

    public double getBaseMonthlyFee() {
        return baseMonthlyFee;
    }

    public boolean isAutoRenew() {
        return autoRenew;
    }

    public abstract double calculateMonthlyNetPrice ();

    public double calculateMonthlyGrossPrice() {
        return 0;
    }

    public double calculateTotalNetPrice() {
        return 0;
    }

    public final void printSummary() {
        System.out.println(
                "Kod planu: " + getPlanCode() +
                        ", Klient: " + getClientName() +
                        ", Liczba miesięcy trwania planu: " + getMonths() +
                        ", Bazowa opłata miesięczna: " + getBaseMonthlyFee() +
                        ", Czy plan odnawia się automatycznie: " + isAutoRenew() +
                        ", Miesięczna cena netto: " + calculateMonthlyNetPrice() +
                        ", Miesięczna cena brutto: " + calculateMonthlyGrossPrice() +
                        ", Cena całego planu: " + calculateTotalNetPrice()
        );
    }

    @Override
    public String toString() {
        return "MembershipPlan{" +
                "planCode='" + planCode + '\'' +
                ", clientName='" + clientName + '\'' +
                ", months=" + months +
                ", baseMonthlyFee=" + baseMonthlyFee +
                ", autoRenew=" + autoRenew +
                '}';
    }
}
