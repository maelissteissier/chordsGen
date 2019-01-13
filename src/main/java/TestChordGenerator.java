import java.util.ArrayList;

import com.jsyn.JSyn;
import com.jsyn.Synthesizer;
import com.jsyn.unitgen.LineOut;

public class TestChordGenerator {
	public static void main(String[] args) {
		try {
			String argKey = args[0];
			String argScaleType = args[1];
			String argNumberOfChords = args[2];

			Note note = new Note(Note.C, 3);
			ChordProgression.ScaleType scaletype = ChordProgression.ScaleType.MAJOR;
			int numberOfChords = Integer.parseInt(argNumberOfChords);
			DegreeNode startingDegree = DegreeProgression.degree1;

			if (argKey.equals("C")){
				note = new Note(Note.C, 3);
			} else if (argKey.equals("C#") || argKey.equals("Db")){
				note = new Note(Note.C_SHARP, 3);
			} else if (argKey.equals("D")){
				note = new Note(Note.D, 3);
			} else if (argKey.equals("D#") || argKey.equals("Eb")){
				note = new Note(Note.D_SHARP, 3);
			} else if (argKey.equals("E") || argKey.equals("Fb")){
				note = new Note(Note.E, 3);
			} else if (argKey.equals("F")){
				note = new Note(Note.F, 3);
			} else if (argKey.equals("F#") || argKey.equals("Gb")){
				note = new Note(Note.F_SHARP, 3);
			} else if (argKey.equals("G")){
				note = new Note(Note.G, 3);
			} else if (argKey.equals("G#") || argKey.equals("Ab")){
				note = new Note(Note.G_SHARP, 3);
			} else if (argKey.equals("A")){
				note = new Note(Note.A, 3);
			} else if (argKey.equals("A#") || argKey.equals("Bb")){
				note = new Note(Note.A_SHARP, 3);
			} else if (argKey.equals("B") || argKey.equals("Cb")){
				note = new Note(Note.B, 3);
			} else {
				throw new Exception("Invalid Key argument ! ");
			}

			if (argScaleType.toUpperCase().equals("MAJOR")) {
				scaletype = ChordProgression.ScaleType.MAJOR;
			} else if (argScaleType.toUpperCase().equals("MINOR")) {
				scaletype = ChordProgression.ScaleType.MINOR;
			} else {
				throw new Exception("chordGen: Invalid scaletype argument !");
			}

			try{
				if (Integer.parseInt(args[3]) == 1){
					startingDegree = DegreeProgression.degree1;
				} else if (Integer.parseInt(args[3]) == 2){
					startingDegree = DegreeProgression.degree2;
				} else if (Integer.parseInt(args[3]) == 3){
					startingDegree = DegreeProgression.degree3;
				} else if (Integer.parseInt(args[3]) == 4){
					startingDegree = DegreeProgression.degree4;
				} else if (Integer.parseInt(args[3]) == 5){
					startingDegree = DegreeProgression.degree5;
				} else if (Integer.parseInt(args[3]) == 6){
					startingDegree = DegreeProgression.degree6;
				} else if (Integer.parseInt(args[3]) == 7){
					startingDegree = DegreeProgression.degree7;
				}
			}catch (Exception e){

			}

			Synthesizer mySynth = JSyn.createSynthesizer();
			LineOut myOut = new LineOut();
			// generates progression of 9 chords from degree1
			DegreeProgression myDegreeProgression = new DegreeProgression(startingDegree, numberOfChords);
			// create a chord progression in CMajor from myDegreeProgression
			ChordProgression myChordProgression = new ChordProgression(myDegreeProgression, scaletype, note);
			ArrayList<Chord> chordList = myChordProgression.getChordProgression();
			System.out.println(myDegreeProgression);
			System.out.println(myChordProgression);

			ChordSequencePlayer myChordSequencePlayer = new ChordSequencePlayer(chordList, mySynth, myOut);
			// play chord progression in arpeggios
			myChordSequencePlayer.playShortSound(mySynth, myOut);
			// play chord progression
			myChordSequencePlayer.play(mySynth, myOut);

			ReadWriteHelpers.saveHumanReadableChordProgression(myDegreeProgression, myChordProgression);

		}catch (ArrayIndexOutOfBoundsException aioobe){
			System.out.println("chordGen: Not enough arguments !\n" +
					"Usage: chordGen [KEY] [SCALETYPE] [NUMBER OF CHORDS] [STARTING DEGREE]\n\n" +
					"Arguments:\n" +
					"KEY,                   C, C# ...\n" +
					"SCALETYPE,             major or minor\n" +
					"NUMBER OF CHORDS,      number of chords you want to generate\n" +
					"STARTING DEGREE,       from 1 to 7");
		} catch (NullPointerException npe){
			System.out.println("chordGen: Not enough arguments !\n" +
					"Usage: chordGen [KEY] [SCALETYPE] [NUMBER OF CHORDS] [STARTING DEGREE]\n\n" +
					"Arguments:\n" +
					"KEY,                   C, C# ...\n" +
					"SCALETYPE,             major or minor\n" +
					"NUMBER OF CHORDS,      number of chords you want to generate\n" +
					"STARTING DEGREE,       from 1 to 7");
		} catch (Exception e){
			System.out.println(e.getMessage() +"\n" +
					"Usage: chordGen [KEY] [SCALETYPE] [NUMBER OF CHORDS] [STARTING DEGREE]\n\n" +
							"Arguments:\n" +
							"KEY,                   C, C# ...\n" +
							"SCALETYPE,             major or minor\n" +
							"NUMBER OF CHORDS,      number of chords you want to generate\n" +
							"STARTING DEGREE,       from 1 to 7");
		}
	}
}
