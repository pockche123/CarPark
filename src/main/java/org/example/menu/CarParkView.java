package org.example.menu;

public class CarParkView {


    public void showStartMenu(){
        System.out.println("--------------- Welcome to PJ's Parking -------------------");
        System.out.println(" Please pick the option for the parking type: ");
        System.out.println(" 1. Standard ");
        System.out.println(" 2. Accessible  ");
        System.out.println(" 3. Electric Vehicles (EV) ");
        System.out.println(" 4. Exit ");
    }

    public void showChoiceResults( int choice, int spaces){

        String[] spotNames = {"STANDARD", "ACCESSIBLE", "EV"};
        if(spaces > 0){
            System.out.println("There are currently " + spaces + " spaces available for " + spotNames[choice-1]  + " parking." );
        } else{
            System.out.println("Sorry. There are no more " + spotNames[choice-1] + " spaces.");
        }
    }

    public void showMembershipType(){
        System.out.println("Please select the type of membership: ");
        System.out.println("1. Member");
        System.out.println("2. Non-member");
        System.out.println("3. Go back");
        System.out.println("4. Exit");
    }


}
