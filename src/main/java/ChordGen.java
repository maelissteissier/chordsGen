import java.util.ArrayList;

import com.jsyn.JSyn;
import com.jsyn.Synthesizer;
import com.jsyn.unitgen.LineOut;

public class ChordGen {
	public static void main(String[] args) {
		try {
			String argKey = args[0];
			String argScaleType = args[1];
			String argNumberOfChords = args[2];
			String argStartingDegree = args[3];
			String typeOfSound = args[4];

			Note note;
			ChordProgression.ScaleType scaletype;
			int numberOfChords = Integer.parseInt(argNumberOfChords);
			int idxStartingDegree = Integer.parseInt(argStartingDegree);
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
				throw new Exception("Invalid KEY argument ! ");
			}

			if (argScaleType.toUpperCase().equals("MAJOR")) {
				scaletype = ChordProgression.ScaleType.MAJOR;
			} else if (argScaleType.toUpperCase().equals("MINOR")) {
				scaletype = ChordProgression.ScaleType.MINOR;
			} else {
				throw new Exception("chordGen: Invalid SCALETYPE argument !");
			}

			if (idxStartingDegree == 1){
				startingDegree = DegreeProgression.degree1;
			} else if (idxStartingDegree == 2){
				startingDegree = DegreeProgression.degree2;
			} else if (idxStartingDegree == 3){
				startingDegree = DegreeProgression.degree3;
			} else if (idxStartingDegree == 4){
				startingDegree = DegreeProgression.degree4;
			} else if (idxStartingDegree == 5){
				startingDegree = DegreeProgression.degree5;
			} else if (idxStartingDegree == 6){
				startingDegree = DegreeProgression.degree6;
			} else if (idxStartingDegree == 7){
				startingDegree = DegreeProgression.degree7;
			}else {
				throw new Exception("chordGen: Invalid DEGREE argument !");
			}

			// generates progression of 9 chords from degree1
			DegreeProgression myDegreeProgression = new DegreeProgression(startingDegree, numberOfChords);
			// create a chord progression in CMajor from myDegreeProgression
			ChordProgression myChordProgression = new ChordProgression(myDegreeProgression, scaletype, note);
			ArrayList<Chord> chordList = myChordProgression.getChordProgression();
			System.out.println(myDegreeProgression);
			System.out.println(myChordProgression);

			// Save generated chord progression in text-file readable for humans
			ReadWriteHelpers.saveHumanReadableChordProgression(myDegreeProgression, myChordProgression, argKey, argScaleType.toUpperCase());

			if (!typeOfSound.toUpperCase().equals("SILENT")) {

				Synthesizer mySynth = JSyn.createSynthesizer();
				LineOut myOut = new LineOut();
				mySynth.start();
				mySynth.add(myOut);
				myOut.start();
				ChordSequencePlayer myChordSequencePlayer = new ChordSequencePlayer(chordList, mySynth, myOut);
				if (typeOfSound.toUpperCase().equals("ARPEGGIOS") || typeOfSound.toUpperCase().equals("BOTH")) {
					//play chord progression in arpeggios
					myChordSequencePlayer.playShortSound();
				}
				if (typeOfSound.toUpperCase().equals("CHORDS") || typeOfSound.toUpperCase().equals("BOTH")){
					// play chord progression
					myChordSequencePlayer.play();
				}
				mySynth.stop();
			}


		}catch (ArrayIndexOutOfBoundsException aioobe){
			System.out.println("chordGen: Not enough arguments !\n" +
					"Usage: chordGen [KEY] [SCALETYPE] [NUMBER OF CHORDS] [STARTING DEGREE] [PLAY SOUND]\n\n" +
					"Arguments:\n" +
					"KEY,                   C, C# ...\n" +
					"SCALETYPE,             major or minor\n" +
					"NUMBER OF CHORDS,      number of chords you want to generate\n" +
					"STARTING DEGREE,       from 1 to 7\n" +
					"PLAY SOUND,            arpeggios, chords, both, silent");
		} catch (NullPointerException npe){
			System.out.println("chordGen: Not enough arguments !\n" +
					"Usage: chordGen [KEY] [SCALETYPE] [NUMBER OF CHORDS] [STARTING DEGREE] [PLAY SOUND]\n\n" +
					"Arguments:\n" +
					"KEY,                   C, C# ...\n" +
					"SCALETYPE,             major or minor\n" +
					"NUMBER OF CHORDS,      number of chords you want to generate\n" +
					"STARTING DEGREE,       from 1 to 7\n" +
					"PLAY SOUND,            arpeggios, chords, both, silent");
		} catch (Exception e){
			System.out.println(e.getMessage() +"\n" +
					"Usage: chordGen [KEY] [SCALETYPE] [NUMBER OF CHORDS] [STARTING DEGREE] [PLAY SOUND]\n\n" +
							"Arguments:\n" +
							"KEY,                   C, C# ...\n" +
							"SCALETYPE,             major or minor\n" +
							"NUMBER OF CHORDS,      number of chords you want to generate\n" +
							"STARTING DEGREE,       from 1 to 7\n" +
							"PLAY SOUND,            arpeggios, chords, both, silent");
		}
	}
}
