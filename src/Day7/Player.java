package Day7;

public class Player {
    private int stamina;
    private final int MAX_STAMINA = 100;
    private final int MIN_STAMINA = 0;
    private static int countPlayers;

    public Player(int stamina) {
        if (stamina > MAX_STAMINA) {
            throw new RuntimeException("Вы ввели число, которое больше возможной стамины");
        }

        this.stamina = stamina;
        if (countPlayers < 6) {
            countPlayers++;
        }
    }

    public void run() {
        if (stamina == 0) {
            return;
        }
        stamina--;
        if (stamina == 0) {
            System.out.println("Игрок уходит с поля");
            countPlayers--;
        }
    }

    public static void info() {
        if (countPlayers < 6) {
            System.out.println("Команды неполные. На поле еще есть " + (6 - countPlayers) + " свободных мест");
        } else {
            System.out.println("На поле нет свободных мест");
        }
    }

    public static void main(String[] args) {
        Player player1 = new Player(100);
        Player player2 = new Player(90);
        Player player3 = new Player(95);
        Player player4 = new Player(97);
        Player player5 = new Player(93);
        info();
        Player player6 = new Player(100);
        info();
        for (int i = 0; i <= 120; i++) {
            player1.run();
        }
        info();
    }
}
