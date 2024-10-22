import java.util.*;

public class TextAdventure 
{
  FancyConsole console;
  Scanner inScanner;
  Player player;

  public TextAdventure()
  {
    console = new FancyConsole("Sunday Errands", 600, 800);
    inScanner = new Scanner(System.in);

    // feel free to change the player's starting values
    player = new Player("Bob", 100, 0);
  }

  public void play()
  {
    String input;
    // start of adventure. You can change this if you like
    console.setImage("hmart.jpg");

    // ask the user for their name.
    System.out.println("What is your name?\n");
    input = inScanner.nextLine();

    // Change ourHero's name
    // ADD CODE HERE
    player.changeName(input);
    

    
    // describe the starting situation. Feel free to change this
    System.out.println("On a lively Sunday morning, you and your mom arrive at the supermarket to get this weeks groceries.\nType (yes) when you are ready to enter!\n" + player.getName() + ": ");

    // get user input and go to the appropriate zone based on their input
    // ADD CODE HERE
    input = inScanner.nextLine();
    if (input.equals("yes")){
      enterZone1();
    }
  }

  private void enterZone1()
  {
    console.setImage("veggie.jpg");
    // ADD CODE HERE
    System.out.println("You've entered the veggie section with your mom.. wait, where'd she go?\n That's weird.\n The supermarket is pretty crowded. She must have gone on without you.\n Where will you look?");
    System.out.println("(drinks)\n(snacks)\n(bakery)\n(seafood)");
    String input = inScanner.nextLine();
    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE
    if (input.equals("drinks")){
      enterZone2();
    }else if(input.equals("snacks")){
      enterZone3();
    }else if(input.equals("bakery")){
      enterZone4();
    }else if(input.equals("seafood")){
      enterZone5();
    }
    // Take action or go to another zone based on their choice
    // ADD CODE HERE

  }

  private void enterZone2()
  {
    console.setImage("drinks.jpg");

    player.setHealth(player.getHealth()-15);
    System.out.println("HUNGER: " + player.getHealth());
    if (player.getHealth()>=70){
      System.out.println("You've entered the drink section. You're feeling a little hungry.\n It doesn't seem like your mom is around here. Where will you look?");
    }else if(player.getHealth()>=40){
      System.out.println("You've entered the drink section. You're feeling quite hungry..a drink might be nice.\nWhat will you do?");
      System.out.println("(steal(chance of +5 hunger))\n(keep looking)");
      String input =  inScanner.nextLine();
      if (input.equals("steal")){
        int num = (int)((Math.random()*3)+1);
        if (num!=4){
          player.setHealth(player.getHealth()+5);
          System.out.println("You successfully grabbed a drink. Hunger: " + player.getHealth() + "\nYour mom isn't here either.. Where will you look?");
        }else{
          System.out.println("There was too many people for you to grab a drink...");
        }
      }else if(input.equals("keep looking")){
        System.out.println("Your mom isn't here either.. Where will you look?");
      }
    }else if(player.getHealth()>=10){
      System.out.println("You've entered the drink section. You're feeling really hungry..a drink would be great.\nWhat will you do?");
      System.out.println("(steal(chance of +5 hunger))\n(keep looking)");
      String input =  inScanner.nextLine();
      if (input.equals("steal")){
        int num = (int)((Math.random()*3)+1);
        if (num!=4){
          player.setHealth(player.getHealth()+5);
          System.out.println("You successfully grabbed a drink. Hunger: " + player.getHealth() + "\nYou could've sworn you saw her here.. Where will you look?");
        }else{
          System.out.println("There was too many people for you to grab a drink...");
        }
      }else if(input.equals("keep looking")){
        System.out.println("You could've sworn you saw her here.. Where will you look?");
      }
    }
// add 0 hunger
    //choices
      System.out.println("(snacks)\n(bakery)\n(seafood)\n(dessert)");
      String input = inScanner.nextLine();
      if (input.equals("snacks")){
        enterZone3();
      }else if(input.equals("bakery")){
        enterZone4();
      }else if(input.equals("seafood")){
        enterZone5();
      }else if(input.equals("dessert")){
        enterZone6();
      }
    }
  

  


  private void enterZone3()
  {
    console.setImage("snacks.jpg");

    player.setHealth(player.getHealth()-15);
    System.out.println("HUNGER: " + player.getHealth());
    if (player.getHealth()>=70){
      System.out.println("You've entered the snack section. You're getting a bit hungry.\n It doesn't seem like your mom is around here. Where will you look?");
    }else if(player.getHealth()>=40){
      System.out.println("You've entered the snack section. You're feeling pretty hungry..a snack might be nice.\nWhat will you do?");
      System.out.println("(steal(chance of +10 hunger))\n(keep looking)");
      String input =  inScanner.nextLine();
      if (input.equals("steal")){
        int num = (int)((Math.random()*3)+1);
        if (num>=2){
          player.setHealth(player.getHealth()+10);
          System.out.println("You successfully grabbed a snack. Hunger: " + player.getHealth() + "\nYour mom isn't here either.. Where will you look?");
        }else{
          System.out.println("There was too many people for you to grab a snack...");
        }
      }else if(input.equals("keep looking")){
        System.out.println("Your mom isn't here either.. Where will you look?");
      }
    }else if(player.getHealth()>=10){
      System.out.println("You've entered the snack section. You're feeling really hungry..a drink would be great.\nWhat will you do?");
      System.out.println("(steal(chance of +10 hunger))\n(keep looking)");
      String input =  inScanner.nextLine();
      if (input.equals("steal")){
        int num = (int)((Math.random()*3)+1);
        if (num>=2){
          player.setHealth(player.getHealth()+10);
          System.out.println("You successfully grabbed a snack. Hunger: " + player.getHealth() + "\nYou were almost certain she was here.. Where will you look?");
        }else{
          System.out.println("There was too many people for you to grab a drink...");
        }
      }else if(input.equals("keep looking")){
        System.out.println("You were almost certain she was here.. Where will you look?");
      }
      //add 0 hunger
    }
    //choices
      System.out.println("(drinks)\n(bakery)\n(seafood)\n(dessert)");
      String input = inScanner.nextLine();
      if (input.equals("drinks")){
        enterZone2();
      }else if(input.equals("bakery")){
        enterZone4();
      }else if(input.equals("seafood")){
        enterZone5();
      }else if(input.equals("dessert")){
        enterZone6();
      }
    }
  

  

  private void enterZone4()
  {
    console.setImage("bakery.jpg");

    // change image
    // ADD CODE HERE

    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE

    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    
  }

  private void enterZone5()
  {
    console.setImage("seafood.jpg");

    // change image
    // ADD CODE HERE

    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE

    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    
  }

  private void enterZone6()
  {
    console.setImage("dessert.jpg");

    // change image
    // ADD CODE HERE

    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE

    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    
  }

  private void gameEnd()
  {
    // ADD CODE HERE

    inScanner.close();
  }
}