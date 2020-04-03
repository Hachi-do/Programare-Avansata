import java.awt.*;
import java.io.*;
import java.net.URI;

public class CatalogUtil {
    public static void save(Catalog catalog) throws IOException {
        try (OutputStream oos = new ObjectOutputStream(
                new FileOutputStream(catalog.getPath()))) {
            ((ObjectOutputStream) oos).writeObject(catalog);
        }
    }

    public static Catalog load(String path) throws IOException, ClassNotFoundException, InvalidCatalogException {
        Object object;
        try (var ois = new ObjectInputStream(new FileInputStream(path))) {
            object = ois.readObject();
        }
        if (!(object instanceof Catalog)) {
            throw new InvalidCatalogException();
        }
        return (Catalog) object;
    }

    public static void view(Document doc) throws IOException {
        Desktop desktop = Desktop.getDesktop();
        String location = doc.getLocation();
        desktop.browse(URI.create(location));
    }
}