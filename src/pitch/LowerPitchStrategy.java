package pitch;

public class LowerPitchStrategy implements PitchStrategy {
/*
 * This implements the pitch strategy interface and it reduces the pitch 
 * volume by 2 if called. If passed note value is 0 or 0, it would just return
 * 0, since that is set as the minimum
 */
	@Override   
	public int modifyPitch(int note) {
		return Math.min(note - 2,0); 
	}

}
