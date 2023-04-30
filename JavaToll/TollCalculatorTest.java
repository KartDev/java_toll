import java.time.LocalDateTime;

public class TollCalculatorTest {
    public static void main(String[] args) {
        TollCalculator tollCalculator = new TollCalculator();
        Vehicle car = new Car();
        Vehicle motorbike = new MotorBike();

        // Testa avgifter för bilar och motorcyklar
        LocalDateTime nonRushHour = LocalDateTime.of(2023, 5, 1, 10, 0);
        assert tollCalculator.calculateToll(car, nonRushHour) == 11;
        assert tollCalculator.calculateToll(motorbike, nonRushHour) == 8;

        // Testa avgifter under rusningstrafik
        LocalDateTime rushHourMorning = LocalDateTime.of(2023, 5, 1, 8, 30);
        LocalDateTime rushHourAfternoon = LocalDateTime.of(2023, 5, 1, 16, 30);
        assert tollCalculator.calculateToll(car, rushHourMorning) == 18;
        assert tollCalculator.calculateToll(car, rushHourAfternoon) == 18;
        assert tollCalculator.calculateToll(motorbike, rushHourMorning) == 18;
        assert tollCalculator.calculateToll(motorbike, rushHourAfternoon) == 18;

        // Testa avgiftsfria helger
        LocalDateTime weekend = LocalDateTime.of(2023, 5, 6, 10, 0);
        assert tollCalculator.calculateToll(car, weekend) == 0;
        assert tollCalculator.calculateToll(motorbike, weekend) == 0;

        System.out.println("Alla tester passerade!");
    }
}
