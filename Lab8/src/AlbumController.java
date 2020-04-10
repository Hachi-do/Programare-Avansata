import java.sql.*;

public class AlbumController {
    private Connection connection;

    public AlbumController() {
        connection = Database.connection;
    }

    public void create(String name, int artistId, int releaseYear) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert into albums columns (name, artist_id, release_year) values(?,?,?)");
            statement.setString(1, name);
            statement.setInt(2, artistId);
            statement.setInt(3, releaseYear);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void findByArtist(int artistId) {
        try {
            PreparedStatement statement = connection.prepareStatement("select * from albums where artist_id=?");
            statement.setInt(1,artistId);
            ResultSet resultSet = statement.executeQuery();
            boolean gasit = false;
            while (resultSet.next() == true) {
                gasit = true;
                System.out.println("Id=" + resultSet.getInt("id"));
                System.out.println("Name=" + resultSet.getString("name"));
                System.out.println("Artist id=" + resultSet.getInt("artist_id"));
                System.out.println("Release year=" + resultSet.getInt("release_year"));
            }
            if (!gasit) {
                System.out.println("Nu a fost gasit artistul cu id-ul" + artistId);
            }
        } catch (SQLException e) {
            System.err.println("Err: " + e);
        }


    }
}
