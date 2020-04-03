public class Truck extends Vehicle {


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "name='" + name + '\'' +
                '}';
    }
}
