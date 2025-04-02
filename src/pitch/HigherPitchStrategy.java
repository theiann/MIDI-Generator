package pitch;

public class HigherPitchStrategy implements PitchStrategy {
	/*
	 * This implements the pitch strategy interface and it increases the pitch 
	 * volume by 2 if called. If passed note value is 127 or 126, it would just return
	 * 127, since that is set as the maximum
	 */
	@Override
	public int modifyPitch(int note) {
		return Math.max(note+2,127); 
	}

}
