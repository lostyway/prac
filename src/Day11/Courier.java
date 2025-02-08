package Day11;

public class Courier implements Worker{
    private int salary;
    private Warehouse warehouse;

    public Courier(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public void doWork() {
        //System.out.println("Курьер выполнил свою работу.");
        salary += 100;
        warehouse.setBalance(warehouse.getBalance() + 1000);

    }

    @Override
    public void bonus() {
        if (warehouse.getBalance() >= 1000000) {
            System.out.println("Курьер получил бонус!");
            salary *= 2;
        }
    }

    @Override
    public String toString() {
        return "Courier{" +
                "salary=" + salary +
                '}';
    }
}
