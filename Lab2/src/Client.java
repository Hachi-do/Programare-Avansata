import java.sql.Time;
import java.util.Objects;

public class Client {

    private String name;
    private int time;

    public Client() {
    }

    public Client(String name, int time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o){
        if(this==o)return true;

        if(o==null)return false;

        if(getClass()!=o.getClass())return false;

        Client client=(Client) o;

        return Objects.equals(name,client.name)&&Objects.equals(time,client.time);

    }

    @Override
    public String toString() {
        return "Client{" +
                " name='" + name + '\'' +
                ", time=" + time +
                '}';
    }
}
