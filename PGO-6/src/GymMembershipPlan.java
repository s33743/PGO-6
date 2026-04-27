public class GymMembershipPlan extends MembershipPlan implements Freezable {

    private int entriesPerMonth;
    private boolean saunaAccess;

    public boolean isSaunaAccess() {
        return saunaAccess;
    }

    public int getEntriesPerMonth() {
        return entriesPerMonth;
    }

    public GymMembershipPlan(String planCode,
                             String clientName,
                             int months,
                             double baseMonthlyFee,
                             boolean autoRenew,
                             int entriesPerMonth,
                             boolean saunaAccess) {
        super(planCode, clientName, months, baseMonthlyFee, autoRenew);
    }

    @Override
    public String getPlanType() {
        return "GYM MEMBERSHIP PLAN";
    }

    @Override
    public double calculateMonthlyNetPrice() {
        double cena = this.getBaseMonthlyFee();

        cena += getEntriesPerMonth() * 4;
        if (this.isSaunaAccess()) {
            cena += 25;
        }
        if (this.isAutoRenew()) {
            cena -= 10;
        }
        return cena;
    }

    public boolean canFreeze() {
        return this.getMonths() >= 3;
    }
}
