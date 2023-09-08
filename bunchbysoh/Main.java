package bunchbysoh;

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
        if(soh<=100 && soh>80)
        {
            counts.healthy++;
        }
         else if(soh<80 && soh>65)
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
    assert(counts.healthy == counts.healthy);
    assert(counts.exchange == counts.exchange);
    assert(counts.failed == counts.failed);
    System.out.println("Healthy is="+counts.healthy);
    System.out.println("exchange is="+counts.exchange);
    System.out.println("counts.failed="+counts.failed);
    System.out.println("Done counting :)\n");
  }

  public static void main(String[] args) {
    testBucketingByHealth();
  }
}
