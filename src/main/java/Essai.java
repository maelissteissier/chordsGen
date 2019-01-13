import java.util.ArrayList;

import com.jsyn.JSyn;
import com.jsyn.Synthesizer;
import com.jsyn.unitgen.LineOut;

public class Essai {	
	
	
	public static void main(String[] args) {
	
		Synthesizer mySynth = JSyn.createSynthesizer();
		mySynth.start();
		LineOut myOut = new LineOut();
		mySynth.add(myOut);
		myOut.start();
		try { Thread.sleep(1000); } catch(Exception e) {}

		DegreeProgressionGenerator myDegreeProgression = new DegreeProgressionGenerator(DegreeProgressionGenerator.degree1, 9);
		ChordProgression myChordProgression = new ChordProgression(myDegreeProgression.getDegreeProgression(), ChordProgression.ScaleType.MAJOR, new Note(Note.C,3));
		ArrayList<Chord> chordList = myChordProgression.getChordProgression();
		System.out.println(myDegreeProgression);
		System.out.println(myChordProgression);
	
		ChordSequencePlayer caMarcheTu = new ChordSequencePlayer(chordList, mySynth, myOut);
		caMarcheTu.play();
		caMarcheTu.stop();
		
		
		/*Chord cm = new Chord(new Note(Note.c, 3), Chord.ChordType.DOMINANT7TH, 2);
		prettyPrintChord(cm);
		ChordPlayer test = new ChordPlayer(cm, mySynth, myOut);
		test.play();*/

	}
	
	public static void prettyPrintChord(Chord chord) {
		System.out.println("Accord de" + chord.getTonic().getIdxSemiToneRelativeToOctave() + chord.getChordType() + "renversement" + chord.getInversion());

		for (int i = 0 ; i < chord.getNotes().size() ; i++) {
			System.out.println("note " + i);
			
			if (chord.getNotes().get(i).getIdxSemiToneRelativeToOctave() == 1) {
				System.out.println("C" + chord.getNotes().get(i).getOctave());
			} else if (chord.getNotes().get(i).getIdxSemiToneRelativeToOctave() == 2) {
				System.out.println("C#"  + chord.getNotes().get(i).getOctave());
			} else if (chord.getNotes().get(i).getIdxSemiToneRelativeToOctave() == 3) {
				System.out.println("D"  + chord.getNotes().get(i).getOctave());
			} else if (chord.getNotes().get(i).getIdxSemiToneRelativeToOctave() == 4) {
				System.out.println("D#"  + chord.getNotes().get(i).getOctave());
			} else if (chord.getNotes().get(i).getIdxSemiToneRelativeToOctave() == 5) {
				System.out.println("E"  + chord.getNotes().get(i).getOctave());
			} else if (chord.getNotes().get(i).getIdxSemiToneRelativeToOctave() == 6) {
				System.out.println("F"  + chord.getNotes().get(i).getOctave());
			} else if (chord.getNotes().get(i).getIdxSemiToneRelativeToOctave() == 7) {
				System.out.println("F#"  + chord.getNotes().get(i).getOctave());
			} else if (chord.getNotes().get(i).getIdxSemiToneRelativeToOctave() == 8) {
				System.out.println("G"  + chord.getNotes().get(i).getOctave());
			} else if (chord.getNotes().get(i).getIdxSemiToneRelativeToOctave() == 9) {
				System.out.println("G#"  + chord.getNotes().get(i).getOctave());
			} else if (chord.getNotes().get(i).getIdxSemiToneRelativeToOctave() == 10) {
				System.out.println("A"  + chord.getNotes().get(i).getOctave());
			} else if (chord.getNotes().get(i).getIdxSemiToneRelativeToOctave() == 11) {
				System.out.println("A#"  + chord.getNotes().get(i).getOctave());
			} else if (chord.getNotes().get(i).getIdxSemiToneRelativeToOctave() == 12) {
				System.out.println("B"  + chord.getNotes().get(i).getOctave());
			}
		}	
	}

	public static void printChordProgression(ArrayList<Chord> chordProgression) {
		for (int i = 0; i < chordProgression.size(); i++ ) {
			prettyPrintChord(chordProgression.get(i));
		}
	}
	public static void printReferences(Note note) {
		System.out.println("autre reference");
		System.out.println(note.getIdxSemiTone());
		System.out.println(note.getFrequency());
		System.out.println(note.getOctave());
		System.out.println(note.getIdxSemiToneRelativeToOctave());
	}

}
