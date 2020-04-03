import java.util.ArrayList;
import java.util.List;

public class Problem {
    List<Client> clients = new ArrayList<Client>(5);
    List<Depot> depots = new ArrayList<Depot>(5);

    public Problem() {
    }

    /***
     * Adds depots to an array list
     * @param depot is the depot to be added
     */
    public void setDepot(Depot depot) {
        boolean ok = true;
        for (Depot d : depots) {
            if (d.equals(depot)) {
                System.out.println("Depoul a fost adaugat deja");
                ok = false;
                break;
            }
        }
        if (ok) {
            depots.add(depot);
        }

    }

    /***
     * Adds depots to an array list
     * @param client is the depot to be added
     */
    public void setClient(Client client) {
            if(clients.contains())
        boolean ok = true;
        for (Client c : clients) {
            if (c.equals(client)) {
                System.out.println("Clientul a fost deja servit");
                ok = false;
                break;
            }
        }
        if (ok) {
            clients.add(client);
        }

    }


    /***
     * Concatenates all the vehicles from every depot into an array list
     * @return an array list containing the vehicles
     */
    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles1 = new ArrayList<Vehicle>(4);
        for (Depot d : depots) {
            vehicles1.addAll(d.vehicles);
        }
        return vehicles1;
    }


}
