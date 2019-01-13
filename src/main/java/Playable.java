import com.jsyn.Synthesizer;
import com.jsyn.unitgen.LineOut;

public interface Playable {
	public void play(Synthesizer newSynth, LineOut newLineout);
	public void playShortSound(Synthesizer newSynth, LineOut newLineout);
	public void stop(Synthesizer newSynth, LineOut newLineout);
}
