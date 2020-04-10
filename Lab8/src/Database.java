
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    public static ArtistController artist;
    public static AlbumController album;
    public static Connection connection;

    public static void create() {
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "marinik", "sql");
            Statement statement = connection.createStatement();

            artist = new ArtistController();
            album = new AlbumController();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void test() {
        if (connection != null) {
            /*artist.create("Marian Contrabas", "Romania");
            album.create("Marian si Amicii", 1, 2000);
            artist.create("Marian Contrabas1", "Romania1");
            album.create("Marian si Amicii2", 1, 2001);
            artist.create("Marian Bass", "Romania");
            album.create("Marian si Amicii3", 1, 2000);
            */


            artist.findByName("Marian Contrabas");
            album.findByArtist(1);

            artist.findByName("Marian Baterist");
        }
    }
}
