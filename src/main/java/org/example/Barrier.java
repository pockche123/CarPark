package org.example;

import lombok.Getter;

@Getter
public class Barrier {

    private boolean up;

    private void raise(){
        this.up = true;
    }

    private void lower(){
        this.up = false;
    }

    private void update(){

    }

}
