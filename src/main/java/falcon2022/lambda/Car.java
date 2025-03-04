package falcon2022.lambda;

public class Car {
    private String number;
    private int year;
    private String color;
    private boolean actualTechnicalInspection;

    public Car(String number, int year, String color, boolean actualTechnicalInspection) {
        this.number = number;
        this.year = year;
        this.color = color;
        this.actualTechnicalInspection = actualTechnicalInspection;
    }

    public String getNumber() {
        return number;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public boolean isActualTechnicalInspection() {
        return actualTechnicalInspection;
    }

    @Override
    public String toString() {
        return """
                number: %s
                year: %d
                color: %s
                actualTechnicalInspection: %s
                """.formatted(
                number, year, color,
                actualTechnicalInspection ? "actual" : "not actual");
    }
}
