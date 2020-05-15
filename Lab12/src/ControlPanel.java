import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class ControlPanel extends JPanel {
    private final MainFrame frame;
    private JButton createBtn = new JButton("Create");
    private JTextField nameText=new JTextField("Component text");
    private JTextField className= new JTextField("Class name");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        setLayout(new FlowLayout());

        //add buttons
        add(nameText);


        add(className);
        add(createBtn);

        createBtn.addActionListener(this::createBtn);

    }

    private void createBtn(ActionEvent event) {
                String componentName = "javax.swing." + className.getText();
                JComponent component=createComponent(componentName);

                if(component!=null){
                    Class clazz= component.getClass();
                    Method method;
                    try{
                        method=clazz.getMethod("setText",String.class);
                        method.invoke(component,nameText.toString());
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                    component.setName(nameText.toString());
                    frame.desingPanel.add(component);
                    revalidate();

                }
    }

     JComponent createComponent(String componentName){
        try {
            Class clazz = Class.forName(componentName);
            System.out.println(clazz.getPackage());
            return (JComponent) clazz.getConstructor().newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException ex) {
            System.out.println(ex.toString());
        }
        return null;
    }
}