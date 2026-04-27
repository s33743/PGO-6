
public abstract class MembershipPlan implements Billable {

    public static final double STAWKA_VAT = 0.23;

    private String planCode;
    private String clientName;
    private int months;
    private double baseMonthlyFee;
    private boolean autoRenew;

    public MembershipPlan(String planCode, String clientName, int months, double baseMonthlyFee, boolean autoRenew) {

        if (
                planCode == null || planCode.isEmpty() ||
                        clientName == null || clientName.isEmpty() ||
                        months <= 0 || baseMonthlyFee <= 0
        ) {
            throw new IllegalArgumentException(
                    "Podano nieprawidłowe dane: "
            );
        }

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
        return this.calculateMonthlyNetPrice() * (1+STAWKA_VAT);
    }
    public double calculateTotalNetPrice() {
        return this.calculateMonthlyNetPrice() * this.getMonths();
    }

    public final void printSummary() {
        System.out.println("Kod planu: " + this.getPlanCode() +
                        ", Klient: " + this.getClientName() +
                        ", Liczba miesięcy trwania planu: " + this.getMonths() +
                        ", Bazowa opłata miesięczna: " + this.getBaseMonthlyFee() +
                        ", Czy plan odnawia się automatycznie: " + this.isAutoRenew() +
                        ", Miesięczna cena netto: " + this.calculateMonthlyNetPrice() +
                        ", Miesięczna cena brutto: " + this.calculateMonthlyGrossPrice() +
                        ", Cena netto całego planu: " + this.calculateTotalNetPrice()
        );
    }

    @Override
    public String toString() {
        return "MembershipPlan{" +
                "planCode='" + this.planCode + '\'' +
                ", clientName='" + this.clientName + '\'' +
                ", months=" + this.months +
                ", baseMonthlyFee=" + this.baseMonthlyFee +
                ", autoRenew=" + this.autoRenew +
                '}';
    }
}
