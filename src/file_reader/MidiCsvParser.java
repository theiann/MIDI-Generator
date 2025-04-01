package file_reader;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class MidiCsvParser {
	
	
	
	public static List<MidiEventData> parseCsv(String fileString) throws FileNotFoundException{
		List<MidiEventData> list = new ArrayList<MidiEventData>();
		
		File file = new File(fileString);
		
		try (Scanner input = new Scanner(file)) {
			while(input.hasNextLine()) {
				String columns[] = input.nextLine().split(",");
				if(columns.length != 6) {
					throw new FileNotFoundException("File is invalid");
				}
				int startEndTick;
				int noteOnOff;
				int channel;
				int note;
				int velocity;
				int instrument;
				
				startEndTick = Integer.parseInt(columns[0]);
				if(columns[1].equals(" Note_on_c")) {
					noteOnOff = 144;
				}else {
					noteOnOff = 128;
				}
				channel = Integer.parseInt(columns[2]);
				note = Integer.parseInt(columns[3]);
				velocity = Integer.parseInt(columns[4]);
				instrument = Integer.parseInt(columns[5]);
				
				
				
				//System.out.println(startEndTick + ", " + noteOnOff + ", " + channel + ", " + note + ", " +  velocity + ", " + instrument);
				MidiEventData event = new MidiEventData(startEndTick, noteOnOff, channel, note, velocity, instrument);
				list.add(event); 
			
			}
			input.close();
		} catch (Exception E) {
			E.printStackTrace();
		}
		
		return list;
	}
}
