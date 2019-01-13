import java.util.ArrayList;

public class Chord {

	private Note tonic;
	private ChordType chordType;
	private ArrayList<Note> notes;
	private int inversion;
	
	public enum ChordType {
		MAJOR,
		MINOR,
		AUGMENTED,
		DIMINISHED,
		DOMINANT7TH,
		MAJOR7TH,
		MINOR7TH
	}

	public Chord(Note tonic, ChordType chordType, int inversion) {
		this.tonic = tonic;
		this.chordType = chordType;
		this.inversion = inversion;
		this.notes = getChordNotes();
	}
	
	private ArrayList<Integer> getChordTypeIntervalls() {
		ArrayList<Integer> chordTypeIntervalls = new ArrayList<Integer>();
		if (chordType == ChordType.MAJOR) {
			chordTypeIntervalls.add(4);
			chordTypeIntervalls.add(3);
		} else if (chordType == ChordType.MINOR) {
			chordTypeIntervalls.add(3);
			chordTypeIntervalls.add(4);
		}  else if (chordType == ChordType.DIMINISHED) {
			chordTypeIntervalls.add(3);
			chordTypeIntervalls.add(3);
		}  else if (chordType == ChordType.AUGMENTED) {
			chordTypeIntervalls.add(4);
			chordTypeIntervalls.add(4);
		} else if (chordType == ChordType.DOMINANT7TH) {
			chordTypeIntervalls.add(4);
			chordTypeIntervalls.add(3);
			chordTypeIntervalls.add(3);
		} else if (chordType == ChordType.MAJOR7TH) {
			chordTypeIntervalls.add(4);
			chordTypeIntervalls.add(3);
			chordTypeIntervalls.add(4);
		} else if (chordType == ChordType.MINOR7TH) {
			chordTypeIntervalls.add(3);
			chordTypeIntervalls.add(4);
			chordTypeIntervalls.add(3);
		}
		return chordTypeIntervalls;
	}
	
	public ArrayList<Note> reverseChord(ArrayList<Note> chord) {	
		for (int i = 0; i < inversion ; i++) {
		Note tempNoteStore = chord.get(0);
		chord.remove(0);
		chord.add(new Note((tempNoteStore.getIdxSemiTone()+12)));
		}
		return chord;
	}
	
	public ArrayList<Note> getChordNotes() {
		ArrayList<Note> chord = new ArrayList<Note>();
		chord.add(tonic);
		for (int i = 0 ; i < getChordTypeIntervalls().size() ; i++) {
			chord.add(new Note((chord.get(i).getIdxSemiTone())+ (getChordTypeIntervalls().get(i))));
		}
		if (inversion != 0) {
			chord = reverseChord(chord);
		}
		return chord;
	}

	public Note getTonic() {
		return tonic;
	}

	public ChordType getChordType() {
		return chordType;
	}

	public ArrayList<Note> getNotes() {
		return notes;
	}

	public int getInversion() {
		return inversion;
	}

	public String toString() {
		String chord = "Accord " + chordType + " de " + tonic + ". Renversement " + inversion + "\n";

		for (int i = 0 ; i < notes.size() ; i++) {
			chord = chord + "note " + i + " : " + notes.get(i) + "\n";
		}
		return chord;
	}
}
