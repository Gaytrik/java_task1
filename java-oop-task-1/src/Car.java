class Car extends Machine implements Vehicle {

    @Override
    public void start() {
        System.out.println("Car started");
    }

    @Override
    public void stop() {
        System.out.println("Car stopped");
    }

    @Override
    void run() {
        System.out.println("Car is running smoothly");
    }

    public static void main(String[] args) {
        Car c = new Car();

        c.start();
        c.run();
        c.fuelType();
        c.stop();
    }
}