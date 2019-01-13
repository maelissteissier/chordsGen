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
		
		
		
		DegreeGenerator essai = new DegreeGenerator(DegreeGenerator.degree1, 9);
		ArrayList<Chord> chordList = DegreeGenerator.degreesToChords(essai.degreeProgression, DegreeGenerator.ScaleType.MAJOR, new Note(Note.c,3));
		essai.printDegreeProgression();
		printChordProgression(chordList);
	
		ChordSequencePlayer caMarcheTu = new ChordSequencePlayer(chordList, mySynth, myOut);
		caMarcheTu.play();
		
		
		/*Chord cm = new Chord(new Note(Note.c, 3), Chord.ChordType.DOMINANT7TH, 2);
		prettyPrintChord(cm);
		ChordPlayer test = new ChordPlayer(cm, mySynth, myOut);
		test.play();*/

	}
	
	public static void prettyPrintChord(Chord chord) {
		System.out.println("Accord de" + chord.tonic.IdxSemiToneRelativeToOctave + chord.chordType + "renversement" + chord.inversion);
		
		
		for (int i = 0 ; i < chord.notes.size() ; i++) {
			System.out.println("note" + i);
			
			if (chord.notes.get(i).IdxSemiToneRelativeToOctave == 1) {
				System.out.println("C" + chord.notes.get(i).octave);
			} else if (chord.notes.get(i).IdxSemiToneRelativeToOctave == 2) {
				System.out.println("C#"  + chord.notes.get(i).octave);
			} else if (chord.notes.get(i).IdxSemiToneRelativeToOctave == 3) {
				System.out.println("D"  + chord.notes.get(i).octave);
			} else if (chord.notes.get(i).IdxSemiToneRelativeToOctave == 4) {
				System.out.println("D#"  + chord.notes.get(i).octave);
			} else if (chord.notes.get(i).IdxSemiToneRelativeToOctave == 5) {
				System.out.println("E"  + chord.notes.get(i).octave);
			} else if (chord.notes.get(i).IdxSemiToneRelativeToOctave == 6) {
				System.out.println("F"  + chord.notes.get(i).octave);
			} else if (chord.notes.get(i).IdxSemiToneRelativeToOctave == 7) {
				System.out.println("F#"  + chord.notes.get(i).octave);
			} else if (chord.notes.get(i).IdxSemiToneRelativeToOctave == 8) {
				System.out.println("G"  + chord.notes.get(i).octave);
			} else if (chord.notes.get(i).IdxSemiToneRelativeToOctave == 9) {
				System.out.println("G#"  + chord.notes.get(i).octave);
			} else if (chord.notes.get(i).IdxSemiToneRelativeToOctave == 10) {
				System.out.println("A"  + chord.notes.get(i).octave);
			} else if (chord.notes.get(i).IdxSemiToneRelativeToOctave == 11) {
				System.out.println("A#"  + chord.notes.get(i).octave);
			} else if (chord.notes.get(i).IdxSemiToneRelativeToOctave == 12) {
				System.out.println("B"  + chord.notes.get(i).octave);
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
		System.out.println(note.idxSemiTone);
		System.out.println(note.frequency);
		System.out.println(note.octave);
		System.out.println(note.IdxSemiToneRelativeToOctave);
	}

}
