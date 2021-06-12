package BusinessLayer;

import ServiceLayer.InputManager;

public class Messenger {
    private InputManager inputManager;

    public Messenger(){
        inputManager = new InputManager();
    }

    public void sendMessage(String msg){
        inputManager.showMessage(msg);
    }
}
