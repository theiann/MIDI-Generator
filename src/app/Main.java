package app;

import java.util.List;

import javax.sound.midi.*;
import file_reader.*;

public class Main {

	public static void main(String[] args) {
		try {
			List<MidiEventData> midiEvents = MidiCsvParser.parseCsv("./app.files/mystery_song.csv");
			Sequence sequence = new Sequence(Sequence.PPQ, 384);
			Track track = sequence.createTrack();
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
