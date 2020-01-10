package Controller;

import Controller.commands.ExitCommand;
import Controller.commands.NextCommand;
import Controller.commands.PrevCommand;
import View.ImageDisplay;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    private ImageDisplay display;

    public CommandFactory(ImageDisplay display) {
        this.display = display;
    }

    public Map<String, Command> build(){
        Map<String,Command> commands = new HashMap<>();
        commands.put("Next", new NextCommand(display));
        commands.put("Prev", new PrevCommand(display));
        commands.put("Exit", new ExitCommand());
        return commands;
    }
}
