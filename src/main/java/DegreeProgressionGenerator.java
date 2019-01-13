import java.util.ArrayList;
import java.util.HashMap;


public class DegreeProgressionGenerator {

	private ArrayList<DegreeNode> degreeProgression;
	public static DegreeNode degree1 = new DegreeNode(1);
	public static DegreeNode degree2 = new DegreeNode(2);
	public static DegreeNode degree3 = new DegreeNode(3);
	public static DegreeNode degree4 = new DegreeNode(4);
	public static DegreeNode degree5 = new DegreeNode(5);
	public static DegreeNode degree6 = new DegreeNode(6);
	public static DegreeNode degree7 = new DegreeNode(7);


	public DegreeProgressionGenerator(DegreeNode firstDegree, int chordProgressionSize) {
		tonalDegreeStructure();
		this.degreeProgression = new ArrayList<DegreeNode>();
		this.degreeProgression.add(firstDegree);
		for (int i = 1; i < chordProgressionSize; i++) {
			this.degreeProgression.add(degreeProgression.get(i-1).getRandomConnectedDegree());
		}
	}

	public ArrayList<DegreeNode> getDegreeProgression() {
		return degreeProgression;
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < this.degreeProgression.size(); i++ ) {
			s = s + "Degree" + degreeProgression.get(i).getDegree() + "\n";
		}
		return s.trim();
	}

	/**
	 * Musically pertinent degree graph from simple tonal musical structure
	 */
	private void tonalDegreeStructure() {
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

	/**
	 * Transforms a degree progression in a real chord progression
	 * @param degreeProgression the degree progression
	 * @param scaleType (MAJOR or MINOR)
	 * @param tonic the note corresponding to the tonic of the scale chosen
	 * @return an ArrayList representing a real musically valid Chord progression
	 */
	/*public static ArrayList<Chord> degreesToChords(ArrayList<DegreeNode> degreeProgression, ScaleType scaleType, Note tonic) {
		
		HashMap<Integer, Integer> majorDegreeMap = new HashMap<Integer, Integer>();
		majorDegreeMap.put(1, tonic.getIdxSemiTone());
		majorDegreeMap.put(2, (tonic.getIdxSemiTone() + 2));
		majorDegreeMap.put(3, (tonic.getIdxSemiTone() + 4));
		majorDegreeMap.put(4, (tonic.getIdxSemiTone() + 5));
		majorDegreeMap.put(5, (tonic.getIdxSemiTone() + 7));
		majorDegreeMap.put(6, (tonic.getIdxSemiTone() + 9));
		majorDegreeMap.put(7, (tonic.getIdxSemiTone() + 11));
		
		HashMap<Integer, Integer> minorDegreeMap = new HashMap<Integer, Integer>();
		minorDegreeMap.put(1, tonic.getIdxSemiTone());
		minorDegreeMap.put(2, (tonic.getIdxSemiTone() + 2));
		minorDegreeMap.put(3, (tonic.getIdxSemiTone() + 3));
		minorDegreeMap.put(4, (tonic.getIdxSemiTone() + 5));
		minorDegreeMap.put(5, (tonic.getIdxSemiTone() + 7));
		minorDegreeMap.put(6, (tonic.getIdxSemiTone() + 8));
		minorDegreeMap.put(7, (tonic.getIdxSemiTone() + 10));
		
		ArrayList<Chord> chordProgression = new ArrayList<Chord>();
		
		for (int i = 0 ; i < degreeProgression.size() ; i++) {
			
			int randomInversion = (int)(Math.random()*2);

			if (degreeProgression.get(i).getDegree() == 1) {
				if (scaleType == ScaleType.MAJOR) {
					chordProgression.add(new Chord(new Note(majorDegreeMap.get(1)), Chord.ChordType.MAJOR, randomInversion));
				
				} else if (scaleType == ScaleType.MINOR) {
					chordProgression.add(new Chord(new Note(minorDegreeMap.get(1)), Chord.ChordType.MINOR, randomInversion));
				}
			} else if (degreeProgression.get(i).getDegree() == 2) {
				if (scaleType == ScaleType.MAJOR) {
					chordProgression.add(new Chord(new Note(majorDegreeMap.get(2)), Chord.ChordType.MINOR, randomInversion));
				
				} else if (scaleType == ScaleType.MINOR) {
					chordProgression.add(new Chord(new Note(minorDegreeMap.get(2)), Chord.ChordType.DIMINISHED, randomInversion));
				}
			} else if (degreeProgression.get(i).getDegree() == 3) {
				if (scaleType == ScaleType.MAJOR) {
					chordProgression.add(new Chord(new Note(majorDegreeMap.get(3)), Chord.ChordType.MINOR, randomInversion));
				
				} else if (scaleType == ScaleType.MINOR) {
					chordProgression.add(new Chord(new Note(minorDegreeMap.get(3)), Chord.ChordType.MAJOR, randomInversion));
				
				}
			} else if (degreeProgression.get(i).getDegree() == 4) {
				if (scaleType == ScaleType.MAJOR) {
					chordProgression.add(new Chord(new Note(majorDegreeMap.get(4)), Chord.ChordType.MAJOR, 2));
				
				} else if (scaleType == ScaleType.MINOR) {
					chordProgression.add(new Chord(new Note(minorDegreeMap.get(4)), Chord.ChordType.MINOR, 2));
				
				}
			} else if (degreeProgression.get(i).getDegree() == 5) {
				if (scaleType == ScaleType.MAJOR) {
					chordProgression.add(new Chord(new Note(majorDegreeMap.get(5)), Chord.ChordType.DOMINANT7TH, randomInversion));
				
				} else if (scaleType == ScaleType.MINOR) {
					chordProgression.add(new Chord(new Note(minorDegreeMap.get(5)), Chord.ChordType.MINOR7TH, randomInversion));
					
				}
			} else if (degreeProgression.get(i).getDegree() == 6) {
				if (scaleType == ScaleType.MAJOR) {
					chordProgression.add(new Chord(new Note(majorDegreeMap.get(6)), Chord.ChordType.MINOR, 1));
				} else if (scaleType == ScaleType.MINOR) {
					chordProgression.add(new Chord(new Note(minorDegreeMap.get(6)), Chord.ChordType.MAJOR, 1));
				}
			} else if (degreeProgression.get(i).getDegree() == 7) {
				if (scaleType == ScaleType.MAJOR) {
					chordProgression.add(new Chord(new Note(majorDegreeMap.get(7)), Chord.ChordType.DIMINISHED, randomInversion));
					
				} else if (scaleType == ScaleType.MINOR) {
					chordProgression.add(new Chord(new Note(minorDegreeMap.get(7)), Chord.ChordType.MAJOR, randomInversion));
					
				}
			}
		}
		return chordProgression;
	}*/

}
