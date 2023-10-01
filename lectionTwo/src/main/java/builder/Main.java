package builder;

public class Main {
    public static void main(String[] args) {
        Computer computer1 = new ComputerBuilder()
                .setCpu("Intel i7")
                .setGpu("NVIDIA RTX 3080")
                .setRam(32)
                .setStorage(1000)
                .setOs("Windows 10")
                .build();

        Computer computer2 = new ComputerBuilder()
                .setCpu("AMD Ryzen 9")
                .setGpu("AMD Radeon RX 6900 XT")
                .setRam(64)
                .setStorage(2000)
                .setOs("Linux")
                .build();

        System.out.println(computer1);
        System.out.println(computer2);
    }
}
