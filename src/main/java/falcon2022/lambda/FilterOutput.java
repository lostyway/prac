package falcon2022.lambda;

public class FilterOutput {
    private CarIdentifier carIdentifier;
    private String filter;

    public FilterOutput(CarIdentifier carIdentifier, String filter) {
        this.carIdentifier = carIdentifier;
        this.filter = filter;
    }

    public void showMenu() {
        boolean isRunningFilter = true;
        while (isRunningFilter)
            switch (filter) {
                case "1" -> {
                    System.out.println("Выбран фильтр: " + Filters.NUMBER_FINDER.getDescrtiption());
                }
                case "2" -> System.out.println();
                case "3" -> System.out.println();
                case "4" -> System.out.println();
                case "5" -> {
                    System.out.println("Выход...");
                    isRunningFilter = false;
                }
                default -> System.out.println("Введите корректный номер фильтра");
            }
    }
}
