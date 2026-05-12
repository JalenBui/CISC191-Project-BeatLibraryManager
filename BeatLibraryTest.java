package beatlibrarymanager;

/**
 * BeatLibraryTest tests the AudioClip, Beat, and Loop classes.
 * 
 * @author Jalen Bui
 */
public class BeatLibraryTest
{
    public static void main(String[] args)
    {
        Beat beat1 = new Beat("Sunset Drums", 140, "Trap", "F minor", "00:32", "Heavy 808 pattern");
        Loop loop1 = new Loop("Late Night Loop", 128, "House", "A minor", "00:16", "Smooth repeating synth");

        System.out.println(beat1.getDetails());
        System.out.println(loop1.getDetails());
    }
}