import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        ArtistController artistController = new ArtistController(Database.getConnection());
        AlbumController albumController = new AlbumController(Database.getConnection());

        /*artist.create("Marian Contrabas", "Romania");
        album.create("Marian si Amicii", 1, 2000);
        artist.create("Marian Contrabas1", "Romania1");
        album.create("Marian si Amicii2", 1, 2001);
        artist.create("Marian Bass", "Romania");
        album.create("Marian si Amicii", 2 , 2000);

        artistController.create("Marian", "Abc");
        albumController.create("Dododo", 3, 2010);
        */
        artistController.findByName("Marian Contrabas");
        albumController.findByArtist(1);


        artistController.findByName("Marian Baterist");
        albumController.findByArtist(2);


        albumController.findByArtist(3);

        


    }
}
