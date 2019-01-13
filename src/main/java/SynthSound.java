import java.util.ArrayList;
import com.jsyn.Synthesizer;
import com.jsyn.unitgen.FilterBandPass;
import com.jsyn.unitgen.FilterLowPass;
import com.jsyn.unitgen.LineOut;
import com.jsyn.unitgen.SawtoothOscillator;
import com.jsyn.unitgen.SineOscillator;

	public class SynthSound implements Playable {
		private Double frequency;
		private Double amplitude;
		private Synthesizer synthesizer;
		private SawtoothOscillator myOsc;
		private FilterLowPass lowPass;
		
		public SynthSound(Double frequency, Double amplitude, Synthesizer synthesizer, LineOut lineOut) {
			this.frequency = frequency;
			this.amplitude = amplitude;
			this.synthesizer = synthesizer;
			
			myOsc = new SawtoothOscillator();
			lowPass = new FilterLowPass();
			synthesizer.add(myOsc);
			synthesizer.add(lowPass);
			
			lowPass.output.connect(lineOut.input);
			lowPass.amplitude.set(0.6);
			lowPass.frequency.set(500);
			
			myOsc.output.connect(lowPass.input) ;
	        myOsc.frequency.set(frequency);
	        myOsc.amplitude.set(0);
		}

		public Double getFrequency() {
			return frequency;
		}

		public Double getAmplitude() {
			return amplitude;
		}

		public Synthesizer getSynthesizer() {
			return synthesizer;
		}

		public SawtoothOscillator getMyOsc() {
			return myOsc;
		}

		public FilterLowPass getLowPass() {
			return lowPass;
		}

		public void play() {
		    myOsc.amplitude.set(0.6);

		}
		public void playShortSound() {
			myOsc.amplitude.set(0.6);
			myOsc.frequency.set(frequency);
			try { Thread.sleep(500); } catch(Exception e) {}
		}
		public void stop() {
			myOsc.amplitude.set(0.0);
		}

		
}
