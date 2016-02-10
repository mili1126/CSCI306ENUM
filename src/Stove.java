import java.util.ArrayList;

/**
 * @author mili
 *
 */

public class Stove {

	private ArrayList<Burner> mBurners;
	private int numBurner = 4;



	public Stove() {
		super();
		mBurners = new ArrayList<Burner> ();
		for (int i = 0; i < numBurner; i++) {
			Burner burner = new Burner();
			mBurners.add(burner);
		}
	}

	public void displayStove() {
		System.out.println("Stove ---------------");
		boolean hotBurner = false;
		for (Burner mBurner : mBurners) {
			mBurner.display();
			if (mBurner.getTemperature().equals(Burner.Temperature.HOT)) 
				hotBurner = true;
		}
		if (hotBurner) {
			System.out.println("RED LIGHT - HOT BURNER ALERT");
		}
		System.out.println("");
	}


	/**
	 * @param adjusts  
	 * an integer array represents the operations on the stove
	 * e.g.
	 * adjust[0] number of ups or downs for first burner 					
	 * adjust[1] number of ups or downs for second burner 
	 * adjust[2] number of ups or downs for third burner 
	 * adjust[3] number of ups or downs for fourth burner 
	 * 
	 * zero --- no operation 
	 * positive integer --- turn up(increseSetting) 
	 * negative integer --- turn down(decreaseSetting)
	 * 
	 * 
	 * @param time
	 * the number of minutes to be simulated
	 */
	public void simulateStove(int[] adjusts, int time) {
		int tempTime = time;
		for (int i=0; i < numBurner; i++) {
			// Set the timer and targeted setting
			if (adjusts[i] > 0) {
				while (adjusts[i] > 0) {
					mBurners.get(i).increaseSetting();
					adjusts[i]--;
				}
			}
			else {
				while (adjusts[i] < 0) {
					mBurners.get(i).decreaseSetting();
					adjusts[i]++;
				}
			}

			// Run the simulator and update the temperature
			while (tempTime > 0) {
				mBurners.get(i).updateTemperature();
				tempTime--;
			}

			// Reset the time
			tempTime = time;			
		}
		
		displayStove();
	}

	public void test() {

		displayStove();

		// With 6 iterations, burner 1 is HOT, but with 5 iterations it will still be COOL.
		int[] adjusts = new int[] {3,2,1,0};
		simulateStove(adjusts, 6);

		// With at least 2 iterations, burner 2 is HOT, but with 1 iteration it will still be WARM.
		adjusts = new int[] {-2, 1, -1, 0};
		simulateStove(adjusts, 4);

		// With 2 iterations, burner 2 is WARM, but with 1 iteration it will still be HOT.
		adjusts = new int[] {-1, -1, 0, 0};
		simulateStove(adjusts, 2);
	}

	public static void main(String[] args) {
		Stove stove = new Stove();
		stove.test();
	}

}
