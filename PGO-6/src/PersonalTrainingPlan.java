public class PersonalTrainingPlan extends MembershipPlan implements Billable {

    private int sessionsPerMonth;
    private int trainerLevel;
    private boolean dietConsultationIncluded;

    public boolean isDietConsultationIncluded() {
        return dietConsultationIncluded;
    }

    public int getTrainerLevel() {
        return trainerLevel;
    }

    public int getSessionsPerMonth() {
        return sessionsPerMonth;
    }

    public PersonalTrainingPlan(String planCode,
                                String clientName,
                                int months,
                                double baseMonthlyFee,
                                boolean autoRenew,
                                int sessionsPerMonth,
                                int trainerLevel,
                                boolean dietConsultationIncluded) {
        super(planCode, clientName, months, baseMonthlyFee, autoRenew);

        this.sessionsPerMonth = sessionsPerMonth;
        this.trainerLevel = trainerLevel;
        this.dietConsultationIncluded = dietConsultationIncluded;

        if ( trainerLevel < 1 || trainerLevel > 3 ) {
            throw new IllegalArgumentException(
                    "Trainer level must be between 1 and 3"
            );
        }
    }

    @Override
    public String getPlanType() {
        return "PERSONAL TRAINING PLAN";
    }

    @Override
    public double calculateMonthlyNetPrice() {
        double cena = this.getBaseMonthlyFee();
        cena += this.getSessionsPerMonth() * 70;
        if ( this.getTrainerLevel() == 2) {
            cena += 90;
        }
        else if (this.getTrainerLevel() == 3) {
            cena += 180;
        }
        if (this.isDietConsultationIncluded()) {
            cena += 50;
        }
        if (this.isAutoRenew()) {
            cena -= 15;
        }
        return cena;
    }
}
