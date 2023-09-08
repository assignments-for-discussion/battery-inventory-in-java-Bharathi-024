package bunchbysoh;
import java.lang.*;
import static org.junit.Assert.assertTrue;

public class Main {
  static class CountsBySoH {
    public int healthy = 0;
    public int exchange = 0;
    public int failed = 0;
  };

  static CountsBySoH countBatteriesByHealth(int[] presentCapacities) {
    CountsBySoH counts = new CountsBySoH();
    float soh =0;
    for(int i=0;i<presentCapacities.length;i++)
    {
        soh=100*presentCapacities[i]/120;
        if(soh<=100 && soh>=80)
        {
            counts.healthy++;
        }
         else if(soh<80 && soh>=65)
        {
            counts.exchange++;
        }
         else
        {
            counts.failed++;
        }
        
    }
    return counts;
  }

  static void testBucketingByHealth() {
    System.out.println("Counting batteries by SoH...\n");
    int[] presentCapacities = {115, 118, 80, 95, 91, 77};
    CountsBySoH counts = countBatteriesByHealth(presentCapacities);
    assert(counts.healthy == 2);
    assert(counts.exchange == 3);
    assert(counts.failed == 1);
    System.out.println("Actual Healthy Count: " + counts.healthy);
System.out.println("Actual Exchange Count: " + counts.exchange);
System.out.println("Actual Failed Count: " + counts.failed);

    System.out.println("Done counting :)\n");
  }

  public static void main(String[] args) {
    testBucketingByHealth();
  }
}
