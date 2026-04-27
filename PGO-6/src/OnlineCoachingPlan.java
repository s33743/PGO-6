public class OnlineCoachingPlan extends MembershipPlan implements RemoteAccess {

    private int videoConsultations;
    private boolean mealPlanIncluded;
    private boolean recordedLibraryAccess;

    public boolean isMealPlanIncluded() {
        return mealPlanIncluded;
    }

    public int getVideoConsultations() {
        return videoConsultations;
    }

    public boolean isRecordedLibraryAccess() {
        return recordedLibraryAccess;
    }

    public OnlineCoachingPlan(String planCode,
                              String clientName,
                              int months,
                              double baseMonthlyFee,
                              boolean autoRenew,
                              int videoConsultations,
                              boolean mealPlanIncluded,
                              boolean recordedLibraryAccess) {
        super(planCode, clientName, months, baseMonthlyFee, autoRenew);

        this.videoConsultations = videoConsultations;
        this.mealPlanIncluded = mealPlanIncluded;
        this.recordedLibraryAccess = recordedLibraryAccess;
    }

    @Override
    public String getPlanType() {
        return "ONLINE COACHING PLAN";
    }

    @Override
    public double calculateMonthlyNetPrice() {
        double cena = this.getBaseMonthlyFee();

        cena += this.getVideoConsultations() * 45;
        if (isMealPlanIncluded()) {
            cena += 60;
        }
        if (isRecordedLibraryAccess()) {
            cena += 20;
        }
        if (isAutoRenew()) {
            cena -= 12;
        }
        return cena;
    }

    @Override
    public boolean hasOnlineAccess() {
        return true;
    }
}
