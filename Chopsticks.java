/**
 * Implements Chopsticks and Chopstick classes.
 * 
 * @author Eric Wnorowski
 * @version 1.0
 */
public class Chopsticks {

    class Chopstick{
        //instance variables
        private int id; // Chopstick ID

        public Chopstick(int id){
            this.id = id;
        }
    }

    // instance variables
    private Chopstick chopsitck; // chopstick
    private Chopstick[] chop_arr; // Table Chopsticks

    public Chopsticks(){
        this.chop_arr = make_arr();
    }

    public Chopsticks(Chopstick[] chop_arr){
        this.chop_arr = chop_arr;
    }
 
    public Chopstick[] make_arr(){
        Chopstick[] arr = new Chopstick[6];
        for(int i=1; i<6; i++){
            arr[i] = new Chopstick(i);
        }
        return arr;
    }

    public Chopstick getLeft(int id){
        return this.chop_arr[id];
    }

    public Chopstick getRight(int id){
        if(id == 1){
            return this.chop_arr[5];
        }else{
            return this.chop_arr[id - 1];
        }
    }

}