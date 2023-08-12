package annotations.blog;

@AuditExecution
public class Driver {

    @AuditMethod
    public void updateControllerBuffer() throws InterruptedException {
        // Assume, it takes around 4 seconds to read data from an external device.
        Thread.sleep(4000);
        System.out.println("Controller buffer has I/O data.");
    }
}
