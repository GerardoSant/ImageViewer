package Controller.commands;

import Controller.Command;
import View.ImageDisplay;

public class NextCommand implements Command {

    private ImageDisplay display;

    public NextCommand(ImageDisplay display) {
        this.display = display;
    }

    @Override
    public void execute() {
        display.display((display.current().getNext()));
    }
}
