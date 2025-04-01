package app;

import java.util.List;

import javax.sound.midi.*;
import file_reader.*;
import factory.*;


public class Main {

	public static void main(String[] args) {
		try {
			List<MidiEventData> midiEvents = MidiCsvParser.parseCsv("./src/files/test_file.csv");
			
			
			
			Sequence sequence = new Sequence(Sequence.PPQ, 384);
			Track track = sequence.createTrack();
			
			MidiEventFactoryAbstract factoryAbstract = new standardMidiEventFactoryAbstract();
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
