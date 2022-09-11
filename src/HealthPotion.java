
import java.util.concurrent.atomic.AtomicBoolean;
public class HealthPotion extends Potion {
    protected int restoreHealthAmount = 5;

    HealthPotion(){
        super.name = "Health Potion";
        super.isUsed = new AtomicBoolean(false);
        
    }

    public int getHealthPotion(){
        return restoreHealthAmount;
    }
    
}
