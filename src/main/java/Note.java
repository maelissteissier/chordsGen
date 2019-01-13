
public class Note {

	public int octave;
	public int idxSemiTone;
	public Double frequency;
	public int IdxSemiToneRelativeToOctave;
	
	
	public static int c = 1;
	public static int cS = 2;
	public static int d = 3;
	public static int dS = 4;
	public static int e = 5;
	public static int f = 6;
	public static int fS = 7;
	public static int g = 8;
	public static int gS = 9;
	public static int a = 10;
	public static int aS = 11;
	public static int b = 12;
	
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
}
