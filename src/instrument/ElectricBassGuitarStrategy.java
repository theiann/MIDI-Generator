package instrument;

import javax.sound.midi.*;

public class ElectricBassGuitarStrategy implements InstrumentStrategy {
	/*
	 * This class applies the Electric bass guitar Instrument to 
	 * the passed channel number
	 * It does so with the MIDI PROGRAM_CHANGE by getting the program value to 33
	 */
		@Override
		public void applyInstrument(Track track, int channel) {
			try {
				ShortMessage addingInstrument = new ShortMessage(); 
				addingInstrument.setMessage(ShortMessage.PROGRAM_CHANGE, channel,33,0);
				track.add(new MidiEvent(addingInstrument,0));
			}
			catch(InvalidMidiDataException e){
				System.out.println("Could not apply Guitar Instrument");
				
			}

		}
}
