import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class Depot {
    private String name;
    List<Vehicle> vehicles = new ArrayList<>(1);
    private int count = 0;

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public int getCount() {
        return count;
    }

    public Vehicle getVehicles() {
        return vehicles.get(count);
    }

    /***
     * Adds vehicles to an array list
     * @param vehicle is the vehicle to be added
     */
    public void setVehicle(Vehicle vehicle) {
        boolean ok = true;
        for (int i = 0; i < count; i++) {
            if (vehicles.get(i).equals(vehicle)) {
                System.out.println("Vehiculul exista deja in acest depou");
                ok=false;
                break;
            }
        }
        if (ok) {
            vehicles.add(count, vehicle);
            count++;
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null) return false;

        if (getClass() != o.getClass()) return false;

        Depot depot = (Depot) o;

        return Objects.equals(name, depot.name) && Objects.equals(count, depot.count) && vehicles.equals(depot.vehicles);

    }

    @Override
    public String toString() {
        return "Depot{" +
                "name='" + name + '\'' +
                ", vehicles=" + vehicles +
                ", count=" + count +
                '}';
    }
}
