package Controller.commands;

import Controller.Command;
import View.ImageDisplay;

public class PrevCommand implements Command {

    private ImageDisplay display;

    public PrevCommand(ImageDisplay display) {
        this.display = display;
    }

    @Override
    public void execute() {
        display.display(display.current().getPrev());
    }
}
