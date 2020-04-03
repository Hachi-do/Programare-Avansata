public class Drone extends Vehicle {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Drone{" +
                "name='" + name + '\'' +
                '}';
    }
}

