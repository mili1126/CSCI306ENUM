
/**
 * @author mili
 *
 */
public class Burner {
	public static final int TIME_DURATION = 2;
	
	public enum Temperature {
		HOT ("HOT SURFACE! DON'T TOUCH"), WARM ("CAREFUL"), COLD ("cooool");
		
		private String mTemperature;
		
		private Temperature(String temperature) {
			mTemperature = temperature;
		}

		@Override
		public String toString() {
			return mTemperature;
		}
	};
	
	private Temperature mTemperature;
	private Setting mSetting;

	private int mTimer;

	
	public Burner() {
		super();
		mSetting = Setting.OFF;
		mTemperature = Temperature.COLD;
		mTimer = 0;
	}

	public Temperature getTemperature() {
		return mTemperature;
	}
	
	public void updateTemperature() {
		if (mTimer > 0) mTimer--;
		if(mTimer==0) {
			switch (mSetting) {
			case HIGH:
				mTemperature = Temperature.HOT;
				break;
			case LOW:
				mTemperature = Temperature.WARM;
				break;
			case MEDIUM:
				mTemperature = Temperature.WARM;
				break;
			case OFF:
				mTemperature = Temperature.COLD;
				break;
			default:
				break;
			
			}
		}
	}
	
	public void increaseSetting () {

		switch (mSetting) {
		case HIGH:
			break;
		case LOW:
			mSetting = Setting.MEDIUM;
			break;
		case MEDIUM:
			mSetting = Setting.HIGH;
			break;
		case OFF:
			mSetting = Setting.LOW;
			break;
		default:
			break;
		}
		mTimer += TIME_DURATION;
		
	}
	
	public void decreaseSetting () {

		switch (mSetting) {
		case HIGH:
			mSetting = Setting.MEDIUM;
			break;
		case LOW:
			mSetting = Setting.OFF;
			break;
		case MEDIUM:
			mSetting = Setting.LOW;
			break;
		case OFF:
			break;
		default:
			break;		
		}
		mTimer += TIME_DURATION;
		
	}
	
	public void display () {
		System.out.println("[" + mSetting + "]" + "....." + mTemperature);
	}

}
