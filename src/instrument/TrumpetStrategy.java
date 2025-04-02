package instrument;

import javax.sound.midi.*;

public class TrumpetStrategy implements InstrumentStrategy {/*
	 * This class applies the Trumpet Instrument to the channel
	 * It does so with the MIDI program 56
	 */
		@Override
		public void applyInstrument(Track track, int channel) {
			try {
				ShortMessage addingInstrument = new ShortMessage(); 
				addingInstrument.setMessage(ShortMessage.PROGRAM_CHANGE, channel,56,0);
				track.add(new MidiEvent(addingInstrument,0));
			}
			catch(InvalidMidiDataException e){
				System.out.println("Could not apply Trumpet Instrument");
				
			}

		}
}
