package builder;

public class ComputerBuilder {
    private String cpu;
    private String gpu;
    private int ram;
    private int storage;
    private String os;

    public ComputerBuilder setCpu(String cpu) {
        this.cpu = cpu;
        return this;
    }

    public ComputerBuilder setGpu(String gpu) {
        this.gpu = gpu;
        return this;
    }

    public ComputerBuilder setRam(int ram) {
        this.ram = ram;
        return this;
    }

    public ComputerBuilder setStorage(int storage) {
        this.storage = storage;
        return this;
    }

    public ComputerBuilder setOs(String os) {
        this.os = os;
        return this;
    }

    public Computer build() {
        return new Computer(cpu, gpu, ram, storage, os);
    }
}
