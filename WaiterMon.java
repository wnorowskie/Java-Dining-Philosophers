/**
 * This class implements a waiter
 * 
 * @author Eric Wnorowski
 * @version 1.0
 */
public class WaiterMon{
    private int[] seated;
    private int num_seated;

    public WaiterMon(){
        this.seated = make_arr();
        this.num_seated = sum_seated(this.seated);
    }

    public int[] make_arr(){
        int[] arr = new int[6];
        for(int i=1; i<6;i++){
            arr[i] = 0;
            // all not seated
        }
        return arr;
    }
    
    public int sum_seated(int[] seated){
        int sum = 0;
        for(int i=1; i<6; i++){
            sum += seated[i];
        }
        return sum;
    }

    public synchronized void sitDown(int id){
        while (this.num_seated > 2){
            System.out.println("Philosopher " + id + " waiting to sit...");
            try{wait();}
                catch (InterruptedException ex) {}
                this.num_seated += 1;
        }
        
    }

    public synchronized void standUp(int id){
        System.out.println("Philosopher " + id + " put down forks.");

        notifyAll();
    }

}