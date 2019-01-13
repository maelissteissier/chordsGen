import java.util.ArrayList;
import java.util.HashMap;

public class DegreeGenerator {
	public ArrayList<Degree> degreeProgression;
	public static Degree degree1 = new Degree(1);	
	public static Degree degree2 = new Degree(2);
	public static Degree degree3 = new Degree(3);
	public static Degree degree4 = new Degree(4);
	public static Degree degree5 = new Degree(5);
	public static Degree degree6 = new Degree(6);
	public static Degree degree7 = new Degree(7);



	
	public DegreeGenerator(Degree firstDegree, int chordProgressionSize) {
		degreeStructure();
		this.degreeProgression = new ArrayList<Degree>();
		this.degreeProgression.add(firstDegree);
		for (int i = 1; i < chordProgressionSize; i++) {
			this.degreeProgression.add(degreeProgression.get(i-1).getRandomConnectedDegree());
		}
		
	}
	
	public void printDegreeProgression() {
		for (int i = 0; i < this.degreeProgression.size(); i++ ) {
			System.out.println("Degree" + this.degreeProgression.get(i).degree);
		}
	}
	

	
	public void degreeStructure() {
	degree1.connectDegree(degree2);
	degree1.connectDegree(degree3);
	degree1.connectDegree(degree4);
	degree1.connectDegree(degree5);
	degree1.connectDegree(degree6);
	degree1.connectDegree(degree7);
	
	degree2.connectDegree(degree3);
	degree2.connectDegree(degree5);
	degree2.connectDegree(degree7);
	
	degree3.connectDegree(degree2);
	degree3.connectDegree(degree4);
	degree3.connectDegree(degree6);
	
	degree4.connectDegree(degree1);
	degree4.connectDegree(degree2);
	degree4.connectDegree(degree3);
	degree4.connectDegree(degree5);
	degree4.connectDegree(degree7);
	
	degree5.connectDegree(degree1);
	degree5.connectDegree(degree6);
	
	degree6.connectDegree(degree4);
	degree6.connectDegree(degree2);
	degree6.connectDegree(degree5);
	
	degree7.connectDegree(degree1);
	}
	
	public enum ScaleType {
		MAJOR,
		MINOR
	}

	
	public static ArrayList<Chord> degreesToChords(ArrayList<Degree> degreeProgression, ScaleType scaleType, Note tonic) {
		
		HashMap<Integer, Integer> majorDegreeMap = new HashMap<Integer, Integer>();
		majorDegreeMap.put(1, tonic.idxSemiTone);
		majorDegreeMap.put(2, (tonic.idxSemiTone + 2));
		majorDegreeMap.put(3, (tonic.idxSemiTone + 4));
		majorDegreeMap.put(4, (tonic.idxSemiTone + 5));
		majorDegreeMap.put(5, (tonic.idxSemiTone + 7));
		majorDegreeMap.put(6, (tonic.idxSemiTone + 9));
		majorDegreeMap.put(7, (tonic.idxSemiTone + 11));
		
		HashMap<Integer, Integer> minorDegreeMap = new HashMap<Integer, Integer>();
		minorDegreeMap.put(1, tonic.idxSemiTone);
		minorDegreeMap.put(2, (tonic.idxSemiTone + 2));
		minorDegreeMap.put(3, (tonic.idxSemiTone + 3));
		minorDegreeMap.put(4, (tonic.idxSemiTone + 5));
		minorDegreeMap.put(5, (tonic.idxSemiTone + 7));
		minorDegreeMap.put(6, (tonic.idxSemiTone + 8));
		minorDegreeMap.put(7, (tonic.idxSemiTone + 10));
		
		ArrayList<Chord> chordProgression = new ArrayList<Chord>();
		
		for (int i = 0 ; i < degreeProgression.size() ; i++) {
			
			int randomInversion = (int)(Math.random()*2);
		
			if (degreeProgression.get(i).degree == 1) {
				if (scaleType == ScaleType.MAJOR) {
					chordProgression.add(new Chord(new Note(majorDegreeMap.get(1)), Chord.ChordType.MAJOR, randomInversion));
				
				} else if (scaleType == ScaleType.MINOR) {
					chordProgression.add(new Chord(new Note(minorDegreeMap.get(1)), Chord.ChordType.MINOR, randomInversion));
				
				}
			} else if (degreeProgression.get(i).degree == 2) {
				if (scaleType == ScaleType.MAJOR) {
					chordProgression.add(new Chord(new Note(majorDegreeMap.get(2)), Chord.ChordType.MINOR, randomInversion));
				
				} else if (scaleType == ScaleType.MINOR) {
					chordProgression.add(new Chord(new Note(minorDegreeMap.get(2)), Chord.ChordType.DIMINISHED, randomInversion));
				
				}
			} else if (degreeProgression.get(i).degree == 3) {
				if (scaleType == ScaleType.MAJOR) {
					chordProgression.add(new Chord(new Note(majorDegreeMap.get(3)), Chord.ChordType.MINOR, randomInversion));
				
				} else if (scaleType == ScaleType.MINOR) {
					chordProgression.add(new Chord(new Note(minorDegreeMap.get(3)), Chord.ChordType.MAJOR, randomInversion));
				
				}
			} else if (degreeProgression.get(i).degree == 4) {
				if (scaleType == ScaleType.MAJOR) {
					chordProgression.add(new Chord(new Note(majorDegreeMap.get(4)), Chord.ChordType.MAJOR, 2));
				
				} else if (scaleType == ScaleType.MINOR) {
					chordProgression.add(new Chord(new Note(minorDegreeMap.get(4)), Chord.ChordType.MINOR, 2));
				
				}
			} else if (degreeProgression.get(i).degree == 5) {
				if (scaleType == ScaleType.MAJOR) {
					chordProgression.add(new Chord(new Note(majorDegreeMap.get(5)), Chord.ChordType.DOMINANT7TH, randomInversion));
				
				} else if (scaleType == ScaleType.MINOR) {
					chordProgression.add(new Chord(new Note(minorDegreeMap.get(5)), Chord.ChordType.MINOR7TH, randomInversion));
					
				}
			} else if (degreeProgression.get(i).degree == 6) {
				if (scaleType == ScaleType.MAJOR) {
					chordProgression.add(new Chord(new Note(majorDegreeMap.get(6)), Chord.ChordType.MINOR, 1));
				} else if (scaleType == ScaleType.MINOR) {
					chordProgression.add(new Chord(new Note(minorDegreeMap.get(6)), Chord.ChordType.MAJOR, 1));
				}
			} else if (degreeProgression.get(i).degree == 7) {
				if (scaleType == ScaleType.MAJOR) {
					chordProgression.add(new Chord(new Note(majorDegreeMap.get(7)), Chord.ChordType.DIMINISHED, randomInversion));
					
				} else if (scaleType == ScaleType.MINOR) {
					chordProgression.add(new Chord(new Note(minorDegreeMap.get(7)), Chord.ChordType.MAJOR, randomInversion));
					
				}
			}
		}
		return chordProgression;
	}

}
