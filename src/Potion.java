
import java.util.concurrent.atomic.AtomicBoolean;
public class Potion extends Item {
    protected AtomicBoolean isUsed;

    public AtomicBoolean getIsUsed(){
        return isUsed;
    }
    
    public boolean test(){
        boolean x = isUsed.compareAndSet(false, true);
        return x;
    }

    
}
