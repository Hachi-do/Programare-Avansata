import java.util.Objects;

public abstract class Vehicle {
     String name;


    abstract String getName();
    abstract void setName(String name);

    @Override
    public boolean equals(Object o){
        if(this==o)return true;

        if(o==null)return false;

        if(getClass()!=o.getClass())return false;

        Vehicle vehicle=(Vehicle) o;

        return Objects.equals(name,vehicle.name);

    }

    @Override
    abstract public String toString();

}
