import java.util.ArrayList;
import java.util.HashMap;

public class ChordProgression {

    public enum ScaleType {
        MAJOR,
        MINOR
    }
    private ArrayList<Chord> chordProgression = new ArrayList<Chord>();
    public ChordProgression(DegreeProgression degreeProgression, ScaleType scaleType, Note tonic){
        chordProgression = degreesToChords(degreeProgression.getDegreeProgression(), scaleType, tonic );
    }

    /**
     * Transforms a degree progression in a real chord progression
     * @param degreeProgression the degree progression
     * @param scaleType (MAJOR or MINOR)
     * @param tonic the note corresponding to the tonic of the scale chosen
     * @return an ArrayList representing a real musically valid Chord progression
     */
    private ArrayList<Chord> degreesToChords(ArrayList<DegreeNode> degreeProgression, ScaleType scaleType, Note tonic) {

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
    }

    public ArrayList<Chord> getChordProgression() {
        return chordProgression;
    }

    public String toString(){
        String s = "";
        for (int i = 0; i < chordProgression.size(); i++ ) {
            s = s + chordProgression.get(i) + "\n";
        }
        return s;
    }
}
