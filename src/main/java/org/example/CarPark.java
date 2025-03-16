package org.example;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarPark {

//    private int carParkId;
    private int capacity;
    private int freeNormalSpaces;
    private int freeHandicappedSpaces;
    private Barrier barrier;
    private Sensor sensor;
    private IDReader idreader;
    private FullSign fullSign;
    private CarRegistry carRegistry;



    public void incrementNormalSpaces(){
        this.freeNormalSpaces += 1;
        System.out.println("The current free normal space is: " + freeNormalSpaces);
    }

    public void decrementNormalSpaces(){
        this.freeNormalSpaces -= 1;
        System.out.println("The current free space is: " + freeNormalSpaces);
    }

    public int spacesLeft(){
        int spacesLeft = this.capacity - this.freeNormalSpaces - this.freeHandicappedSpaces;
        return spacesLeft;
    }


    public void update() {
        //Place your carpark update logic here.
        //The pseudo code illustrates some of the actions required
        // in conjunction with other classes and will need further refinement.
        //1.  poll car park components (sensor/etc).
        //************************************************
        //3.  if car present at entrance then
        //4.    if ID valid && car park not full then
        //5.      raise barrier and let car pass
        //6.	  endif
        //7.  endif
        //************************************************
        //9.  if car present at exit then
        //10.   raise barrier and let car pass
        //11.   update records and increment spaces
        //12. endif
        //************************************************
        //14. if carpark full then
        //15.   turn on full sign
        //16: else
        //17.   turn off full sign
        //18. endif
        //************************************************
        //...and so on
    }
    
}
