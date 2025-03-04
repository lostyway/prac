package falcon2022.lambda;

import java.util.Objects;

public final class CarIdentifier {
    private final String number;
    private final int yearStart;
    private final int yearFinish;
    private final String color;

    public CarIdentifier(String number, int yearStart, int yearFinish, String color) {
        this.number = number;
        this.yearStart = yearStart;
        this.yearFinish = yearFinish;
        this.color = color;
    }

    public String getNumber() {
        return number;
    }

    public int getYearStart() {
        return yearStart;
    }

    public int getYearFinish() {
        return yearFinish;
    }

    public String getColor() {
        return color;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        CarIdentifier that = (CarIdentifier) object;
        return yearStart == that.yearStart
                && yearFinish == that.yearFinish
                && Objects.equals(number, that.number)
                && Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, yearStart, yearFinish, color);
    }

    @Override
    public String toString() {
        return "CarIdentifier{" +
                "number='" + number + '\'' +
                ", yearStart=" + yearStart +
                ", yearFinish=" + yearFinish +
                ", color='" + color + '\'' +
                '}';
    }
}
