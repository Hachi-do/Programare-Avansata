public class Weapon implements Item {

    private WeaponType type;
    private double weight;
    private double value;

    public Weapon() {
    }

    public Weapon(WeaponType type, double weight, double value) {
        this.type = type;
        this.weight = weight;
        this.value = value;
    }

    @Override
    public String getName(){
        return type.name();
    }

    public WeaponType getType() {
        return type;
    }

    public void setType(WeaponType type) {
        this.type = type;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public enum WeaponType{
        PISTOL,
        SWORD,
        BAT;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Weapon";
    }
}
