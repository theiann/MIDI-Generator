package factory;

import javax.sound.midi.InvalidMidiDataException;

public interface MidiEventFactoryAbstract {
	
	/**
	 * This method will create a new MidiEventFactory
	 * @return
	 * 			Returns the newly created MidiEventFactory
	 */  		
	MidiEventFactory createFactory();
}

