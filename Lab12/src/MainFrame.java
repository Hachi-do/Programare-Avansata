import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MainFrame extends JFrame {
    ControlPanel controlPanel=new ControlPanel(this);;
    DesingPanel desingPanel=new DesingPanel(this);

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //components
        add(controlPanel, BorderLayout.NORTH);
        add(desingPanel, BorderLayout.CENTER);

        pack();//layout mananger
    }
}
