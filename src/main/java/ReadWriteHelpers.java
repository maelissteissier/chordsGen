import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReadWriteHelpers {
    public static void saveHumanReadableChordProgression(DegreeProgression degreeProgression, ChordProgression chordProgression, String key, String scaletype){
        PrintWriter out;
        String fileName = new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss").format(new Date()) + ".HumanReadable";
        try {
            out = new PrintWriter( new FileWriter("savedGeneratedChords/" + fileName));
            out.println("Degree progression :\n\n" + degreeProgression + "\n");
            out.println("Chord progression in " + key + " " + scaletype + " :\n" );
            out.println(chordProgression);

            out.close();

        }catch (IOException ioe){
            System.out.println("I/O error");
        }
    }
}