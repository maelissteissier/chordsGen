import java.util.ArrayList;

import com.jsyn.Synthesizer;
import com.jsyn.unitgen.LineOut;

public class ChordSequencePlayer implements Playable{
	private ArrayList<ChordPlayer> chordPlayers;
	private ArrayList<Chord> chordProgression;
	private Synthesizer synth;
	private LineOut lineOut;
	
	public ChordSequencePlayer(ArrayList<Chord> chordProgression, Synthesizer synthesizer, LineOut lineOut) {
		this.chordPlayers = new ArrayList<ChordPlayer>();
		this.chordProgression = chordProgression;
		this.synth = synthesizer;
		this.lineOut = lineOut;
		for (int i = 0 ; i < this.chordProgression.size() ; i++) {
			chordPlayers.add(new ChordPlayer(chordProgression.get(i), synthesizer, lineOut));
		}
	}

	public void play(Synthesizer newSynth, LineOut newLineout) {
		for (int i = 0 ; i < chordPlayers.size() ; i++) {
			chordPlayers.get(i).play(newSynth, newLineout);
			try { Thread.sleep(1000); } catch(Exception e) {}	
			chordPlayers.get(i).stop(newSynth, newLineout);
		}
	}
	public void playShortSound(Synthesizer newSynth, LineOut newLineout){
		for (int i = 0 ; i < chordPlayers.size() ; i++) {
			chordPlayers.get(i).playShortSound(newSynth, newLineout);
			try { Thread.sleep(1000); } catch(Exception e) {}
			chordPlayers.get(i).stop(newSynth, newLineout);
		}
	}

	public void stop(Synthesizer newSynth, LineOut newLineout) {
	
		
	}
}
