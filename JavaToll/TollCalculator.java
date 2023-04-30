import java.time.LocalDateTime;

public class TollCalculator {

    public int calculateToll(Vehicle vehicle, LocalDateTime timestamp) {
        if (isWeekend(timestamp)) {
            return 0;
        }

        int baseToll = vehicle.getBaseToll();
        if (isRushHour(timestamp)) {
            return Math.max(baseToll, 18);
        }

        return baseToll;
    }

    private boolean isWeekend(LocalDateTime timestamp) {
        switch (timestamp.getDayOfWeek()) {
            case SATURDAY:
            case SUNDAY:
                return true;
            default:
                return false;
        }
    }

    private boolean isRushHour(LocalDateTime timestamp) {
        int hour = timestamp.getHour();
        return (hour >= 8 && hour < 9) || (hour >= 16 && hour < 17);
    }
}
