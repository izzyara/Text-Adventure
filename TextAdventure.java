import java.util.*;

public class TextAdventure 
{
  FancyConsole console;
  Scanner inScanner;
  Player player;
  public int counter=1;

  public TextAdventure()
  {
    console = new FancyConsole("Sunday Errands", 800, 936);
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
    console.setImage("veggie1.jpg");
    // ADD CODE HERE
    System.out.println("You've entered the veggie section with your mom.. wait, where'd she go?\n That's weird.\n The supermarket is pretty crowded. She must have gone on without you.\n Where will you look?");
    System.out.println("(drinks)\n(snacks)\n(bakery)\n(seafood)\n" + player.getName() + ": ");
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
    if (player.getHealth()<0){
      player.setHealth(0);
    }
    System.out.println("HUNGER: " + player.getHealth());
    if (player.getHealth()>=85){
      System.out.println("You've entered the drink section. You're feeling a little hungry.\n It doesn't seem like your mom is around here. Where will you look?");
    }else if(player.getHealth()>=40){
      System.out.println("You've entered the drink section. You're feeling quite hungry..a drink might be nice.\nWhat will you do?");
      System.out.println("(steal(chance of +5 hunger))\n(keep looking)\n" + player.getName() + ": ");
      String input =  inScanner.nextLine();
      if (input.equals("steal")){
        int num = (int)((Math.random()*4)+1);
        counter++;
        if (num!=4){
          player.setHealth(player.getHealth()+5);
          System.out.println("You successfully grabbed a drink. HUNGER: " + player.getHealth() + "\nYour mom isn't here either.. Where will you look?");
        }else{
          System.out.println("There was too many people for you to grab a drink...");
        }
      }else if(input.equals("keep looking")){
        System.out.println("Your mom isn't here either.. Where will you look?");
      }
    }else if(player.getHealth()>=10){
      System.out.println("You've entered the drink section. You're feeling really hungry..a drink would be great.\nWhat will you do?");
      System.out.println("(steal(chance of +5 hunger))\n(keep looking)\n" + player.getName() + ": ");
      String input =  inScanner.nextLine();
      if (input.equals("steal")){
        int num = (int)((Math.random()*4)+1);
        if (num!=4){
          player.setHealth(player.getHealth()+5);
          System.out.println("You successfully grabbed a drink. Hunger: " + player.getHealth() + "\nYou could've sworn you saw her here.. Where will you look?");
        }else{
          System.out.println("There was too many people for you to grab a drink...");
        }
      }else if(input.equals("keep looking")){
        System.out.println("You could've sworn you saw her here.. Where will you look?");
      }
    }else if(player.getHealth()>=0){
      System.out.println("You're starving... You don't think you can keep going any longer...\n Where is she? You've been all over the supermarket...\nYour vision is getting blurry, and your mouth is dry.");
      System.out.println("Wait, what is that? Is that someone in front of you?\n You reach your arms out...");
      double chance = ((Math.random()*99)+1);
      if (chance<=((1/counter)*100)){
        System.out.println("Suddenly, you fall into familiar hands. Your mom found you just as you had thought you were done for!\n CONGRATS! You and your mom left the supermarket together after purchasing groceries for the week.\n GOOD ENDING");
        gameEnd();
      }else{
        System.out.println("You stumble forward and fall onto your hands. There was no one there...\nYou faint in the supermarket.\n BAD ENDING");
        gameEnd();
      }
    }
    //choices
      System.out.println("(snacks)\n(bakery)\n(seafood)\n(dessert)\n" + player.getName() + ": ");
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
    if (player.getHealth()<0){
      player.setHealth(0);
    }
    System.out.println("HUNGER: " + player.getHealth());
    if (player.getHealth()>=85){
      System.out.println("You've entered the snack section. These snacks are making you hungry.\n It doesn't seem like your mom is around here. Where will you look?");
    }else if(player.getHealth()>=40){
      System.out.println("You've entered the snack section. You're feeling pretty hungry..a snack might be nice.\nWhat will you do?");
      System.out.println("(steal(chance of +10 hunger))\n(keep looking)\n" + player.getName() + ": ");
      String input =  inScanner.nextLine();
      if (input.equals("steal")){
        int num = (int)((Math.random()*4)+1);
        counter++;
        if (num>=2){
          player.setHealth(player.getHealth()+10);
          System.out.println("You successfully grabbed a snack. HUNGER: " + player.getHealth() + "\nYour mom isn't here either.. Where will you look?");
        }else{
          System.out.println("There was too many people for you to grab a snack...");
        }
      }else if(input.equals("keep looking")){
        System.out.println("Your mom isn't here either.. Where will you look?");
      }
    }else if(player.getHealth()>=10){
      System.out.println("You've entered the snack section. You're feeling really hungry..a drink would be great.\nWhat will you do?");
      System.out.println("(steal(chance of +10 hunger))\n(keep looking)\n" + player.getName() + ": ");
      String input =  inScanner.nextLine();
      if (input.equals("steal")){
        int num = (int)((Math.random()*4)+1);
        counter++;
        if (num>=2){
          player.setHealth(player.getHealth()+10);
          System.out.println("You successfully grabbed a snack. HUNGER: " + player.getHealth() + "\nYou were almost certain she was here.. Where will you look?");
        }else{
          System.out.println("There was too many people for you to grab a drink...");
        }
      }else if(input.equals("keep looking")){
        System.out.println("You were almost certain she was here.. Where will you look?");
      }
    }else if(player.getHealth()>=0){
      System.out.println("You're starving... You don't think you can keep going any longer...\n Where is she? You've been all over the supermarket...\nYour vision is getting blurry, and your mouth is dry.");
      System.out.println("Wait, what is that? Is that someone in front of you?\n You reach your arms out...");
      double chance = ((Math.random()*99)+1);
      if (chance<=((1/counter)*100)){
        System.out.println("Suddenly, you fall into familiar hands. Your mom found you just as you had thought you were done for!\n CONGRATS! You and your mom left the supermarket together after purchasing groceries for the week.\n" + //
                    " GOOD ENDING");
        gameEnd();
      }else{
        System.out.println("You stumble forward and fall onto your hands. There was no one there...\nYou faint in the supermarket.\n BAD ENDING");
        gameEnd();
      }
    }
    //choices
      System.out.println("(drinks)\n(bakery)\n(seafood)\n(dessert)\n" + player.getName() + ": ");
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

    player.setHealth(player.getHealth()-15);
    if (player.getHealth()<0){
      player.setHealth(0);
    }
    System.out.println("HUNGER: " + player.getHealth());
    if (player.getHealth()>=85 || player.getHealth()<100){
      System.out.println("You've entered the bakery section. You're feeling a little hungry.\n It doesn't seem like your mom is around here. Where will you look?");
    }else if(player.getHealth()>=40){
      System.out.println("You've entered the bakery section. You're feeling quite hungry..a pastry would be nice.\nWhat will you do?");
      System.out.println("(steal(chance of +15 hunger))\n(keep looking)\n" + player.getName() + ": ");
      String input =  inScanner.nextLine();
      if (input.equals("steal")){
        int num = (int)((Math.random()*4)+1);
        counter++;
        if (num==3){
          player.setHealth(player.getHealth()+15);
          System.out.println("You successfully grabbed a pastry. HUNGER: " + player.getHealth() + "\nYour mom isn't here either.. Where will you look?");
        }else{
          System.out.println("There was too many people for you to grab a pastry...");
        }
      }else if(input.equals("keep looking")){
        System.out.println("Your mom isn't here either.. Where will you look?");
      }
    }else if(player.getHealth()>=10){
      System.out.println("You've entered the bakery section. Your stomach is grumbling..a pastry would be amazing.\nWhat will you do?");
      System.out.println("(steal(chance of +15 hunger))\n(keep looking)\n" + player.getName() + ": ");
      String input =  inScanner.nextLine();
      if (input.equals("steal")){
        int num = (int)((Math.random()*4)+1);
        counter++;
        if (num==3){
          player.setHealth(player.getHealth()+15);
          System.out.println("You successfully grabbed a pastry. HUNGER: " + player.getHealth() + "\nYou could've sworn you saw her here.. Where will you look?");
        }else{
          System.out.println("There was too many people for you to grab a pastry...");
        }
      }else if(input.equals("keep looking")){
        System.out.println("You could've sworn you saw her here.. Where will you look?");
      }
    }else if(player.getHealth()>=0){
      System.out.println("You're starving... You don't think you can keep going any longer...\n Where is she? You've been all over the supermarket...\nYour vision is getting blurry, and your mouth is dry.");
      System.out.println("Wait, what is that? Is that someone in front of you?\n You reach your arms out...");
      double chance = ((Math.random()*99)+1);
      if (chance<=((1/counter)*100)){
        System.out.println("Suddenly, you fall into familiar hands. Your mom found you just as you had thought you were done for!\n CONGRATS! You and your mom left the supermarket together after purchasing groceries for the week.\n" + //
                    " GOOD ENDING");
        gameEnd();
      }else{
        System.out.println("You stumble forward and fall onto your hands. There was no one there...\nYou faint in the supermarket.\n BAD ENDING");
        gameEnd();
      }
    }
    //choices
      System.out.println("(drinks)\n(snacks)\n(seafood)\n(dessert)\n" + player.getName() + ": ");
      String input = inScanner.nextLine();
      if (input.equals("drinks")){
        enterZone2();
      }else if(input.equals("snacks")){
        enterZone3();
      }else if(input.equals("seafood")){
        enterZone5();
      }else if(input.equals("dessert")){
        enterZone6();
      }
    }


  private void enterZone5()
  {
    console.setImage("seafood.jpg");

    player.setHealth(player.getHealth()-15);
    if (player.getHealth()<0){
      player.setHealth(0);
    }
    System.out.println("HUNGER: " + player.getHealth());
    if (player.getHealth()>=85){
      System.out.println("You've entered the seafood section. You're feeling a little hungry.\n It doesn't seem like your mom is around here. Where will you look?");
    }else if(player.getHealth()>=40){
      System.out.println("You've entered the seafood section. You see the seafood clerk standing in front of a selection of fish.\nWhat will you do?");
      System.out.println("(ask for help)\n(keep looking)\n" + player.getName() + ": ");
      String input =  inScanner.nextLine();
      if (input.equals("ask for help")){
        System.out.println("You ask the seafood clerk for help. He doesn't seem to be of any help.\n Seems like your mom isn't around here. Where will you look?");
      }else if(input.equals("keep looking")){
        System.out.println("Your mom isn't here either.. Where will you look?");
      }
    }else if(player.getHealth()>=10){
      System.out.println("You've entered the seafood section. The seafood clerk is mopping the floors.\nWhat will you do?");
      System.out.println("(ask for help)\n(keep looking)\n" + player.getName() + ": ");
      String input =  inScanner.nextLine();
      if (input.equals("ask for help")){
        System.out.println("You ask the seafood clerk for help. He looks at you like you're crazy...\n Seems like your mom isn't around here. Where will you look?");
      }else if(input.equals("keep looking")){
        System.out.println("Your mom isn't here either.. Where will you look?");
      }
    }else if(player.getHealth()>=0){
      System.out.println("You're starving... You don't think you can keep going any longer...\n Where is she? You've been all over the supermarket...\nYour vision is getting blurry, and your mouth is dry.");
      System.out.println("Wait, what is that? Is that someone in front of you?\n You reach your arms out...");
      double chance = ((Math.random()*99)+1);
      if (chance<=((1/counter)*100)){
        System.out.println("Suddenly, you fall into familiar hands. Your mom found you just as you had thought you were done for!\n CONGRATS! You and your mom left the supermarket together after purchasing groceries for the week.\n" + //
                    " GOOD ENDING");
        gameEnd();
      }else{
        System.out.println("You stumble forward and fall onto your hands. There was no one there...\nYou faint in the supermarket.\n BAD ENDING");
        gameEnd();
      }
    }
    //choices
      System.out.println("(drinks)\n(snacks)\n(bakery)\n(dessert)\n" + player.getName() + ": ");
      String input = inScanner.nextLine();
      if (input.equals("drinks")){
        enterZone2();
      }else if(input.equals("snacks")){
        enterZone3();
      }else if(input.equals("bakery")){
        enterZone4();
      }else if(input.equals("dessert")){
        enterZone6();
      }
    }


  private void enterZone6()
  {
    console.setImage("dessert.jpg");

    player.setHealth(player.getHealth()-15);
    if (player.getHealth()<0){
      player.setHealth(0);
    }
    System.out.println("HUNGER: " + player.getHealth());
    if (player.getHealth()>=85){
      System.out.println("You've entered the dessert section. You're feeling a little hungry.\n It doesn't seem like your mom is around here. Where will you look?");
    }else if(player.getHealth()>=40){
      System.out.println("You've entered the dessert section. You're feeling quite hungry..\nthe desserts here look great. But theres a shady guy standing right by you.\nWhat will you do?");
      System.out.println("(steal(chance of +20 hunger))\n(keep looking)\n" + player.getName() + ": ");
      String input =  inScanner.nextLine();
      if (input.equals("steal")){
        int num = (int)((Math.random()*4)+1);
        counter++;
        if (num==5){
          player.setHealth(player.getHealth()+20);
          System.out.println("You barely managed to grab a piece of dessert. HUNGER: " + player.getHealth() + "\nYour mom isn't here either.. Where will you look?");
        }else{
          System.out.println("The shady guy caught you trying to grab a piece of dessert. In the blink of an eye, you are snatched!\n As punishment, you are forced to do dishes for an eternity.\n BAD ENDING");
          gameEnd();
        }
      }else if(input.equals("keep looking")){
        System.out.println("Your mom isn't here either.. Where will you look?");
      }
    }else if(player.getHealth()>=10){
      System.out.println("You've entered the dessert section. Your stomach is killing you..\nthese desserts are just what you need. But a shady guy is hanging around this area.\nWhat will you do?");
      System.out.println("(steal(chance of +20 hunger))\n(keep looking)\n" + player.getName() + ": ");
      String input =  inScanner.nextLine();
      if (input.equals("steal")){
        int num = (int)((Math.random()*4)+1);
        counter++;
        if (num==5){
          player.setHealth(player.getHealth()+20);
          System.out.println("You successfully grabbed a piece of dessert. HUNGER: " + player.getHealth() + "\nYou were almost certain you saw her here.. Where will you look?");
        }else{
          System.out.println("The shady guy caught you trying to grab a piece of dessert. In the blink of an eye, you are snatched!\n As punishment, you are forced to do dishes for an eternity.\n BAD ENDING");
          gameEnd();
        }
      }else if(input.equals("keep looking")){
        System.out.println("You were almost certain you saw her here.. Where will you look?");
      }
    }else if(player.getHealth()>=0){
      System.out.println("You're starving... You don't think you can keep going any longer...\n Where is she? You've been all over the supermarket...\nYour vision is getting blurry, and your mouth is dry.");
      System.out.println("Wait, what is that? Is that someone in front of you?\n You reach your arms out...");
      double chance = ((Math.random()*99)+1);
      if (chance<=((1/counter)*100)){
        System.out.println("Suddenly, you fall into familiar hands. Your mom found you just as you had thought you were done for!\n CONGRATS! You and your mom left the supermarket together after purchasing groceries for the week.\n" + //
                    " GOOD ENDING");
        gameEnd();
      }else{
        System.out.println("You stumble forward and fall onto your hands. There was no one there...\nYou faint in the supermarket.\n BAD ENDING");
        gameEnd();
      }
    }
    //choices
      System.out.println("(drinks)\n(snacks)\n(seafood)\n(dessert)\n" + player.getName() + ": ");
      String input = inScanner.nextLine();
      if (input.equals("drinks")){
        enterZone2();
      }else if(input.equals("snacks")){
        enterZone3();
      }else if(input.equals("seafood")){
        enterZone5();
      }else if(input.equals("dessert")){
        enterZone6();
      }
    } 

  private void gameEnd()
  {
    // ADD CODE HERE  please stop right here  :() duck onesie

    inScanner.close();
  }
}