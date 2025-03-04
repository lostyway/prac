package lessons;

import java.util.Arrays;

public class Exceptions {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        StackTraceElement[] methods = Thread.currentThread().getStackTrace();
        for (StackTraceElement method : methods) {
            System.out.println(method.getClassName());
            System.out.println(method.getMethodName());

            System.out.println(method.getFileName());
            System.out.println(method.getLineNumber());

            System.out.println(method.getModuleName());
            System.out.println(method.getModuleVersion());
        }
    }
}
