package Day11;

public class Test {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        Courier courier = new Courier(warehouse);
        Picker picker = new Picker(warehouse);
        System.out.println(warehouse + " " + picker + " " + courier);
        picker.doWork();
        courier.doWork();
        System.out.println(warehouse + " " + picker + " " + courier);
        for (int i = 0; i < 1500; i++) {
            picker.doWork();
        }
        picker.bonus();
        System.out.println(warehouse + " " + picker + " " + courier);
    }
}
