package factory;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

public class StandardMidiEventFactory implements MidiEventFactory {

	@Override
	public MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException {
		ShortMessage msg = new ShortMessage();
		msg.setMessage(144+channel, note, velocity);
		MidiEvent event = new MidiEvent(msg, tick);
		return event;
	}

	@Override
	public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
		ShortMessage msg = new ShortMessage();
		msg.setMessage(128+channel, note, 0);
		MidiEvent event = new MidiEvent(msg, tick);
		return event;
	}

}
