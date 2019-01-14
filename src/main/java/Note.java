
public class Note {

	// Musical representation for semitones from C (in same octave)
	public static final int C = 0;
	public static final int C_SHARP = 1;
	public static final int D = 2;
	public static final int D_SHARP = 3;
	public static final int E = 4;
	public static final int F = 5;
	public static final int F_SHARP = 6;
	public static final int G = 7;
	public static final int G_SHARP = 8;
	public static final int A = 9;
	public static final int A_SHARP = 10;
	public static final int B = 11;
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
		int idxSemiToneA440 = 45;
		this.octave = octave;
		idxSemiTone = note + 12*octave;
		Double r = Math.pow(2.0, (1.0/12.0));
		int n = idxSemiTone-idxSemiToneA440;
		frequency = 440*(Math.pow(r, n));
	}
	
	public Note(int idxSemiTone) {
		int idxSemiToneA440 = 45;
		this.idxSemiTone = idxSemiTone;
		if (idxSemiTone/12 == 0) {
		this.octave = 0;
		} else {
			this.octave = idxSemiTone/12 + 1;
		}
		IdxSemiToneRelativeToOctave = (idxSemiTone % 12);
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
		if (IdxSemiToneRelativeToOctave == 0) {
			note = "C";
		} else if (IdxSemiToneRelativeToOctave == 1) {
			note = "C#";
		} else if (IdxSemiToneRelativeToOctave == 2) {
			note = "D";
		} else if (IdxSemiToneRelativeToOctave == 3) {
			note = "D#";
		} else if (IdxSemiToneRelativeToOctave == 4) {
			note = "E";
		} else if (IdxSemiToneRelativeToOctave == 5) {
			note = "F";
		} else if (IdxSemiToneRelativeToOctave == 6) {
			note = "F#";
		} else if (IdxSemiToneRelativeToOctave == 7) {
			note = "G";
		} else if (IdxSemiToneRelativeToOctave == 8) {
			note = "G#";
		} else if (IdxSemiToneRelativeToOctave == 9) {
			note = "A";
		} else if (IdxSemiToneRelativeToOctave == 10) {
			note = "A#";
		} else if (IdxSemiToneRelativeToOctave == 11) {
			note = "B";
		}
		return note + octave + " (frequency : " + frequency + ", IdxSemiTone : " + idxSemiTone + ")";
	}
}

