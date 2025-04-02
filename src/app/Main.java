package app;

import java.util.List;

import javax.sound.midi.*;
import file_reader.*;
import factory.*;
import instrument.*;
import pitch.*;


public class Main {

	public static void main(String[] args) {
		try {
			List<MidiEventData> midiEvents = MidiCsvParser.parseCsv("./src/files/test_file.csv");
			
			
			
			Sequence sequence = new Sequence(Sequence.PPQ, 384);
			Track track = sequence.createTrack();
			
			MidiEventFactoryAbstract factoryAbstract = new StandardMidiEventFactoryAbstract();
			//MidiEventFactoryAbstract factoryAbstract = new LegatoMidiEventFactoryAbstract();
			//MidiEventFactoryAbstract factoryAbstract = new StaccatoMidiEventFactoryAbstract();
			MidiEventFactory factory = factoryAbstract.createFactory();
			
			
			// Choose an instrument strategy
			 InstrumentStrategy pianoStrategy = new AcousticGrandPianoStrategy();
			 InstrumentStrategy GuitarStrategy = new ElectricBassGuitarStrategy();
			 InstrumentStrategy trumpetStrategy = new TrumpetStrategy();
			 
			
			 pianoStrategy.applyInstrument(track, 1);   
			 GuitarStrategy.applyInstrument(track, 2);     
			 trumpetStrategy.applyInstrument(track, 0); 
			
			// Choose a pitch strategy
			PitchStrategy pitchStrategy = new LowerPitchStrategy();
			
			
			for(MidiEventData event : midiEvents) {
				int modifiedNote = pitchStrategy.modifyPitch(event.getNote());
				
				modifiedNote = pitchStrategy.modifyPitch(modifiedNote);

				
				
				
				if(event.getNoteOnOff() == ShortMessage.NOTE_ON) {
					track.add(factory.createNoteOn(event.getStartEndTick(),
							modifiedNote ,
							event.getVelocity(),
							event.getChannel()));
				}
				else {
					track.add(factory.createNoteOff(event.getStartEndTick(), modifiedNote, event.getChannel()));  
				}
			}
			
			
			
			
			for(MidiEventData event : midiEvents) {
				
				if(event.getNoteOnOff() == ShortMessage.NOTE_ON) {
					// Change the event.getNote() to modifiedNote once strategies are implemented!
					track.add(factory.createNoteOn(event.getStartEndTick(), 
							event.getNote(), event.getVelocity(), event.getChannel()));
					
					System.out.println("Created Note On");
					
				} else {
					// Change the event.getNote() to modifiedNote once strategies are implemented!
					track.add(factory.createNoteOff(event.getStartEndTick(), 
							event.getNote(), event.getChannel()));
					
					System.out.println("Created Note Off");
					
				}
			}
			
			// Playing the sequence
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequencer.setSequence(sequence);
			sequencer.start();
			
			while (sequencer.isRunning() | sequencer.isOpen()) {
				Thread.sleep(100);
			}
			Thread.sleep(500);
			sequencer.close();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
