package org.openjfx.logic.Billett;

import javafx.scene.control.TextField;


public class BillettNummerTextField extends TextField {

    public BillettNummerTextField(){
        this.setPromptText("1-20");
    }

    @Override
    public void replaceText(int i, int il, String string){
        if(string.matches("^[1-9][0-9]*$") || string.isEmpty()){
            super.replaceText(i, il, string);
        }
    }

    @Override
    public void replaceSelection(String string){
        super.replaceSelection(string);
    }

}
