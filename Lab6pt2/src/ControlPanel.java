import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    private final MainFrame frame;
    private JButton saveBtn = new JButton("Save");
    //create all buttons (Load, Reset, Exit)
    private JButton loadBtn = new JButton("Load");
    private JButton resetBtn = new JButton("Reset");
    private JButton exitBtn = new JButton("Exit");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        //change the default layout manager (just for fun)
        setLayout(new GridLayout(1, 4));
        //add all buttons
        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);
        //configure listeners for all buttons
        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);
    }

    private void save(ActionEvent event) {
        try {
            ImageIO.write(frame.canvas.image, "PNG", new File("d:/test.png"));
        } catch (IOException exception) {
            System.err.println(exception);
        }
    }

    private void load(ActionEvent event) {
        JFileChooser fileChooser = new JFileChooser();
        File selectedFile;

        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();

            try {
                frame.canvas.image = ImageIO.read(selectedFile);
            } catch (IOException exception) {
                System.err.println(exception);
            }
        }
        frame.canvas.removeAll();
        frame.canvas.revalidate();
        frame.canvas.repaint();
    }

    private void reset(ActionEvent event) {
        frame.canvas.createOffscreenImage();
        frame.canvas.removeAll();
        frame.canvas.revalidate();
        frame.canvas.repaint();
    }

    private void exit(ActionEvent event) {
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }
}