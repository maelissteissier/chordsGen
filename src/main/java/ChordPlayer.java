import java.util.ArrayList;

import com.jsyn.Synthesizer;
import com.jsyn.unitgen.LineOut;

public class ChordPlayer implements Playable {
	Chord chord;
	Sound1 timbre;
	Synthesizer synth;
	LineOut lineOut;
	ArrayList<Sound1> soundList;
	
	public ChordPlayer(Chord chord, Synthesizer synthesizer, LineOut lineOut) {
		this.chord = chord;
		this.synth = synthesizer;
		this.lineOut = lineOut;
		this.soundList = getSoundFromChord(chord, synthesizer,lineOut);
		
	}

	public static ArrayList<Sound1> getSoundFromChord(Chord chord, Synthesizer synthesizer, LineOut lineOut) {
		ArrayList<Note> chordNotes = chord.notes;
		ArrayList<Sound1> soundList = new ArrayList<Sound1>();
		for (int i = 0 ; i < chordNotes.size() ; i++) {
			soundList.add(new Sound1(chordNotes.get(i).frequency, 0.6, synthesizer, lineOut));
		}
		return soundList;
	}
	
	public void play() {
		for (int i = 0 ; i < soundList.size() ; i++) {
			soundList.get(i).play();
		}
	
	}

	public void stop() {
		for (int i = 0 ; i < soundList.size() ; i++) {
			soundList.get(i).stop();
		}

	}
	

}
