package Swing;

import Controller.Command;
import Controller.CommandFactory;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
    private Map<String,Command> commands;
    private Map<String,String> buttons;
    private SwingImageDisplay imageDisplay;


    public MainFrame(SwingImageDisplay imageDisplay) {
        this.imageDisplay = imageDisplay;
        commands = new CommandFactory(imageDisplay).build();
        initButtons();
        setLayout(new BorderLayout());
        add(buttonsBar(), BorderLayout.SOUTH);
        add(imageDisplay, BorderLayout.CENTER);
        setFrameSettings();
    }

    private void setFrameSettings() {
        setTitle("Image Viewer");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initButtons() {
        buttons = new HashMap();
        buttons.put("Next", ">");
        buttons.put("Prev", "<");
        buttons.put("Exit", "Exit");
    }

    private JPanel buttonsBar() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        for (Map.Entry<String, String> entry : buttons.entrySet()){
            JButton button = new JButton(entry.getValue());
            button.addActionListener(e -> commands.get(entry.getKey()).execute());
            panel.add(button);
        }
        return panel;
    }

    public void execute(){
        setVisible(true);
    }



}
