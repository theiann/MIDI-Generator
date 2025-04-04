package factory;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

public class StaccatoMidiEventFactory implements MidiEventFactory {
	
	
	
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
	@Override
	public MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException {
		ShortMessage msg = new ShortMessage();
		msg.setMessage(144+channel, note, velocity);
		MidiEvent event = new MidiEvent(msg, tick);
		return event;
	}

	
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
	@Override
	public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
		tick -= 120;
		ShortMessage msg = new ShortMessage();
		msg.setMessage(128+channel, note, 0);
		MidiEvent event = new MidiEvent(msg, tick);
		return event;
	}
}
