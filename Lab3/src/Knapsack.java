import java.util.ArrayList;
import java.util.List;

public class Knapsack {
    private double capacity;
    private List<Item> items = new ArrayList<>();

    public double getTotalWeight(){
        double totalWeight=0;
        for (Item item: items) {
            totalWeight+=item.getWeight();
        }
        return totalWeight;
    }

    public double getTotalValue(){
        double totalValue=0;
        for (Item item: items) {
            totalValue+=item.getValue();
        }
        return totalValue;

    }


    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        String str="Knapsack{ capacity= "+capacity+"\n"+"availible items:\n";
        for (Item item: items) {
            str+=item+": "+item.getName()+", weight="+item.getWeight()+", value="+item.getValue();
            str+=" (profit factor="+item.profitFactor()+")\n";
        }
        return str;

    }
}
