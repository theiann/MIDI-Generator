package factory;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;

public interface MidiEventFactory {
	
	
	/**
	 * This method will create a new Note On Midi Event
	 * @param tick tick of the note
	 * @param note pitch of the note
	 * @param velocity velocity of the note
	 * @param channel channel of the note
	 * @return
	 * 			Returns the newly created MidiEvent
	 * @throws
	 * 			InvalidMidiDataException if the Midi data is invalid
	 */  		
	MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException;
	
	
	/**
	 * This method will create a new Note Off Midi Event
	 * @param tick tick of the note
	 * @param note pitch of the note
	 * @param channel channel of the note
	 * @return
	 * 			Returns the newly created MidiEvent
	 * @throws
	 * 			InvalidMidiDataException if the Midi data is invalid
	 */  		
	MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException;
}
