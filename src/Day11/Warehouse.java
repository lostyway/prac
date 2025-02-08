package Day11;

public class Warehouse {
    private int countOrder;
    private int balance;

    public int getBalance() {
        return balance;
    }

    public int getCountOrder() {
        return countOrder;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setCountOrder(int countOrder) {
        this.countOrder = countOrder;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "countOrder=" + countOrder +
                ", balance=" + balance +
                '}';
    }
}
