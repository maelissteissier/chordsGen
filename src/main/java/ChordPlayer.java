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

	public Chord getChord() {
		return chord;
	}

	public SynthSound getTimbre() {
		return timbre;
	}

	public Synthesizer getSynth() {
		return synth;
	}

	public LineOut getLineOut() {
		return lineOut;
	}

	public ArrayList<SynthSound> getSoundList() {
		return soundList;
	}

	public void play() {
		for (int i = 0 ; i < soundList.size() ; i++) {
			soundList.get(i).play();
		}
	}
	public void playShortSound(){
		for (int i = 0 ; i < soundList.size() ; i++) {
			soundList.get(i).playShortSound();
		}
	}

	public void stop() {
		for (int i = 0 ; i < soundList.size() ; i++) {
			soundList.get(i).stop();
		}

	}
	

}
