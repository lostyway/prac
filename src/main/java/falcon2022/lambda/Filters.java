package falcon2022.lambda;

public enum Filters {
    NUMBER_FINDER("Поиск по точному совпадению номера"),
    SUBNUMBER_FINDER("Поиск по подстроке в номере"),
    COLOR_FINDER("Поиск по цвету"),
    YEAR_DIAPASON_FINDER("Поиск по диапазону годов выпуска");

    public final String descrtiption;

    Filters(String description) {
        this.descrtiption = description;
    }

    public String getDescription() {
        return descrtiption;
    }
}

