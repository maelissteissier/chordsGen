import java.util.ArrayList;

import com.jsyn.Synthesizer;
import com.jsyn.unitgen.LineOut;

public class ChordPlayer implements Playable {
	private Chord chord;
	private SynthSound timbre;
	private Synthesizer synth;
	private LineOut lineOut;
	private ArrayList<SynthSound> soundList;
	
	public ChordPlayer(Chord chord, Synthesizer synthesizer, LineOut lineOut) {
		this.chord = chord;
		this.synth = synthesizer;
		this.lineOut = lineOut;
		this.soundList = getSoundFromChord(chord, synthesizer,lineOut);
	}

	public static ArrayList<SynthSound> getSoundFromChord(Chord chord, Synthesizer synthesizer, LineOut lineOut) {
		ArrayList<Note> chordNotes = chord.getNotes();
		ArrayList<SynthSound> soundList = new ArrayList<SynthSound>();
		for (int i = 0 ; i < chordNotes.size() ; i++) {
			soundList.add(new SynthSound(chordNotes.get(i).getFrequency(), 0.6, synthesizer, lineOut));
		}
		return soundList;
	}
	
	public void play(Synthesizer newSynth, LineOut newLineout) {
		for (int i = 0 ; i < soundList.size() ; i++) {
			soundList.get(i).play(newSynth, newLineout);
		}
	}
	public void playShortSound(Synthesizer newSynth, LineOut newLineout){
		for (int i = 0 ; i < soundList.size() ; i++) {
			soundList.get(i).playShortSound(newSynth, newLineout);
		}
	}

	public void stop(Synthesizer newSynth, LineOut newLineout) {
		for (int i = 0 ; i < soundList.size() ; i++) {
			soundList.get(i).stop(newSynth, newLineout);
		}
	}
	

}
