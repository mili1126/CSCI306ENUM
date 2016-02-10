/**
 * 
 */

/**
 * @author mili
 *
 */
public enum Setting {
	OFF ("---"), LOW ("--+"), MEDIUM ("-++"), HIGH ("+++");
	private String mSetting;

	private Setting(String setting) {
		mSetting = setting;
	}
	
	@Override
	public String toString() {
		return mSetting;
	}
	
}
