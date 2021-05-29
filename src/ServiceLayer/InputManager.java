package ServiceLayer;

import PresentationLayer.CLI;

public class InputManager {
    CLI cli;

    public InputManager(){
        cli = new CLI();
    }

    public char getInput(){
        return cli.getInput();
    }

    public char getInput(String msg){
        return cli.getInput(msg);
    }
}
