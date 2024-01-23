/**
 * This class implements a dining philosopher.
 * 
 * @author Marc L. Smith
 * @version 1.0
 */
public class Philosopher extends Thread
{
    // instance variables 
    private Chopsticks cs;
    private int id;          // Philosopher's unique identifier
    //private TableMon table;  // Table where philosopher eats

    /**
     * Constructor for Philosopher objects 
     */
    public Philosopher(int id, Chopsticks cs)
    {
      // initialize instance variables
      this.id = id;
      this.cs = cs;
      //this.table = table;
    }

    public void pickupLeftRightEat(){
      synchronized (this.cs.getLeft(id)) {
        // philosopher has left chopstick!
        System.out.println("Philosopher " + this.id + " got left fork");
        
        synchronized (this.cs.getRight(id)) {
        // philosopher has right chopstick!
        System.out.println("Philosopher " + this.id + " got right fork");

      // eat
      System.out.println("Philosopher " + this.id + " eating...");
      this.delay( this.randomInt() ); // chew your food!

      // finished eating, so put down forks
        }
        }

      // eat
      System.out.println("Philosopher " + this.id + " eating...");
      this.delay( this.randomInt() ); // chew your food!

    }

    public void pickupRightLeftEat(){
      synchronized (this.cs.getRight(id)) {
        // philosopher has left chopstick!
        System.out.println("Philosopher " + this.id + " got right fork");
        
        synchronized (this.cs.getLeft(id)) {
        // philosopher has right chopstick!
        System.out.println("Philosopher " + this.id + " got left fork");

      // eat
      System.out.println("Philosopher " + this.id + " eating...");
      this.delay( this.randomInt() ); // chew your food!

      // finished eating, so put down forks
        }
        }

      // eat
      System.out.println("Philosopher " + this.id + " eating...");
      this.delay( this.randomInt() ); // chew your food!
    }


    /*
     * A dining philosopher's behavior 
     * is to eat and think -- forever!
     */ 
    public void run()
    {
      // don't all start in order of creation!
      this.delay( this.randomInt() );
	  
      while (true) {

        if(this.id == 1 | this.id == 3 | this.id == 5){
          pickupLeftRightEat();
        }else{
          pickupRightLeftEat();
        }
        
      // finished eating, so put down forks
      System.out.println("BURP! (Philosopher " + this.id + ")");

      // think
      System.out.println("Philosopher " + id + " thinking...");
      this.delay( this.randomInt() ); // can't rush genius!
      }
    }

    /**
     * Returns a random integer.
     */
    public int randomInt() {
      double r = Math.random();
      return (int) Math.floor( r * 100 ) + 1;
    }

    /**
     * Simulates a philosopher pausing for a given amount of time.
     */
    public void delay(int mSec) {
      try {
        Thread.sleep(mSec);
      } catch (InterruptedException ex) {}
    }
}

