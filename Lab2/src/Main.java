public class Main {

    public static void main(String[] args) {
        Client client1 = new Client();
        client1.setName("Client 1");
        client1.setTime(1);
        System.out.println(client1.getName());
        Client client2 = new Client("Client 2", 1);
        System.out.println(client2);

        Depot depot1 = new Depot();
        depot1.setName("Dodo");
        Vehicle truck1 = new Truck();
        truck1.setName("Truck");
        Vehicle drone = new Drone();
        drone.setName("Drone");
        Depot depot = new Depot();
        depot.setName("Dodo");
        System.out.println(depot.equals(depot1));
        depot1.setVehicle(truck1);
        depot.setVehicle(drone);
        Problem p1 = new Problem();
        p1.setDepot(depot1);
        p1.setDepot(depot);
        System.out.println(p1.getAllVehicles());
        p1.setDepot(depot1);
        p1.setClient(client1);
        p1.setClient(client1);

    }
}
