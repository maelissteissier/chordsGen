
public class Note {

	// Musical representation for semitones from C (in same octave)
	public static final int C = 1;
	public static final int C_SHARP = 2;
	public static final int D = 3;
	public static final int D_SHARP = 4;
	public static final int E = 5;
	public static final int F = 6;
	public static final int F_SHARP = 7;
	public static final int G = 8;
	public static final int G_SHARP = 9;
	public static final int A = 10;
	public static final int A_SHARP = 11;
	public static final int B = 12;
	// Numerical scientific pitch notation of octave
	private int octave;
	// semitone from C0
	private int idxSemiTone;
	// note frequency
	private Double frequency;
	// number of semitones from C in same octave
	private int IdxSemiToneRelativeToOctave;

	public Note(int note, int octave) {
		this.IdxSemiToneRelativeToOctave = note;
		int idxSemiToneA440 = 46;
		this.octave = octave;
		if (octave == 0) {
			idxSemiTone = note;
		} else {
			idxSemiTone = note + 12*octave;
		}
		Double r = Math.pow(2.0, (1.0/12.0));
		int n = idxSemiTone-idxSemiToneA440;
		frequency = 440*(Math.pow(r, n));
	}
	
	public Note(int idxSemiTone) {
		int idxSemiToneA440 = 46;
		this.idxSemiTone = idxSemiTone;
		if (idxSemiTone%12 == 0) {
		this.octave = ((idxSemiTone/12) - 1);
		} else {
			this.octave = idxSemiTone/12;
		}
		IdxSemiToneRelativeToOctave = (idxSemiTone - 12*(octave));
		Double r = Math.pow(2.0, (1.0/12.0));
		int n = idxSemiTone-idxSemiToneA440;
		frequency = 440*(Math.pow(r, n));
	}

	public int getOctave() {
		return octave;
	}

	public int getIdxSemiTone() {
		return idxSemiTone;
	}

	public Double getFrequency() {
		return frequency;
	}

	public int getIdxSemiToneRelativeToOctave() {
		return IdxSemiToneRelativeToOctave;
	}

	public String toString() {
		String note = "";
		if (IdxSemiToneRelativeToOctave == 1) {
			note = "C";
		} else if (IdxSemiToneRelativeToOctave == 2) {
			note = "C#";
		} else if (IdxSemiToneRelativeToOctave == 3) {
			note = "D";
		} else if (IdxSemiToneRelativeToOctave == 4) {
			note = "D#";
		} else if (IdxSemiToneRelativeToOctave == 5) {
			note = "E";
		} else if (IdxSemiToneRelativeToOctave == 6) {
			note = "F";
		} else if (IdxSemiToneRelativeToOctave == 7) {
			note = "F#";
		} else if (IdxSemiToneRelativeToOctave == 8) {
			note = "G";
		} else if (IdxSemiToneRelativeToOctave == 9) {
			note = "G#";
		} else if (IdxSemiToneRelativeToOctave == 10) {
			note = "A";
		} else if (IdxSemiToneRelativeToOctave == 11) {
			note = "A#";
		} else if (IdxSemiToneRelativeToOctave == 12) {
			note = "B";
		}
		return note + octave + " (fréquence : " + frequency + ", IdxSemiTone : " + idxSemiTone + ")";
	}
}

