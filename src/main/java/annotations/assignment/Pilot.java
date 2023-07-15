package annotations.assignment;

@AuditExecution
public class Pilot {

    @AuditMethod
    public void calculateSetBit(){
        try{
            Thread.sleep(4000);
        }catch (InterruptedException exception){
            System.out.println("Thread interrupted.");
        }
        System.out.println("Wrapped up");
    }
}
