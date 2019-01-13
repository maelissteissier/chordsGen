import java.util.ArrayList;

import com.jsyn.Synthesizer;
import com.jsyn.unitgen.LineOut;

public class ChordSequencePlayer implements Playable{
	public ArrayList<ChordPlayer> chordPlayers;
	public ArrayList<Chord> chordProgression;
	Synthesizer synth;
	LineOut lineOut;
	
	public ChordSequencePlayer(ArrayList<Chord> chordProgression, Synthesizer synthesizer, LineOut lineOut) {
		this.chordPlayers = new ArrayList<ChordPlayer>();
		this.chordProgression = chordProgression;
		this.synth = synthesizer;
		this.lineOut = lineOut;
		for (int i = 0 ; i < this.chordProgression.size() ; i++) {
			chordPlayers.add(new ChordPlayer(chordProgression.get(i), synthesizer, lineOut));
		}
		
	}
	
	

	public void play() {
		for (int i = 0 ; i < chordPlayers.size() ; i++) {
			chordPlayers.get(i).play();
			for (int idx = 0 ; idx < chordProgression.get(i).notes.size() ; idx++) {
				
			}
			try { Thread.sleep(1000); } catch(Exception e) {}	
			chordPlayers.get(i).stop();
		}
		
		
	}

	public void stop() {
	
		
	}
}
