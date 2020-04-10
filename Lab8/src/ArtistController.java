import java.sql.*;

public class ArtistController {
    private Connection connection;

    public ArtistController() {
        connection = Database.connection;
    }

    public void create(String name, String country) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert into artists columns(name,country) values(?,?)");
            statement.setString(1,name);
            statement.setString(2,country);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void findByName(String name) {
        try {
            PreparedStatement statement = connection.prepareStatement("select * from artists where name like ? and rownum=1");
            statement.setString(1,name);
            ResultSet resultSet = statement.executeQuery();
            boolean gasit=false;
            while (resultSet.next() == true) {
                gasit=true;
                System.out.println("id=" + resultSet.getInt("id"));
                System.out.println("name=" + resultSet.getString("name"));
                System.out.println("country=" + resultSet.getString("country"));
            }
            if(!gasit)  {
                System.out.println("Nu a fost gasit artisutl "+ name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
