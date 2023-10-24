package builder;

public class Computer {
    private String cpu;
    private String gpu;
    private int ram;
    private int storage;
    private String os;

    public Computer(String cpu, String gpu, int ram, int storage, String os) {
        this.cpu = cpu;
        this.gpu = gpu;
        this.ram = ram;
        this.storage = storage;
        this.os = os;
    }

    // Геттеры для полей

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", gpu='" + gpu + '\'' +
                ", ram=" + ram +
                ", storage=" + storage +
                ", os='" + os + '\'' +
                '}';
    }
}
