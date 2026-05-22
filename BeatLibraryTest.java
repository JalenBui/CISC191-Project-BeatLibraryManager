package beatlibrarymanager;

/**
 * BeatLibraryTest tests the AudioClip, Beat, Loop, and BeatLibrary classes.
 * 
 * @author Jalen Bui
 */
public class BeatLibraryTest
{
    public static void main(String[] args)
    {
        Beat beat1 = new Beat("MidChill Trap Drums", 140, "Trap", "F minor", "00:32", "Heavy 808 pattern");
        Loop loop1 = new Loop("Relaxed House Loop", 128, "House", "A minor", "00:16", "Smooth repeating synth");
        Beat beat2 = new Beat("Heavy Kick Snare Loop", 150, "Dubstep", "D minor", "00:28", "Aggressive drop idea");

        BeatLibrary library = new BeatLibrary();

        library.addClip(beat1);
        library.addClip(loop1);
        library.addClip(beat2);

        System.out.println("All clips:");
        System.out.println(library.getAllClips());

        System.out.println("Search results for Trap:");
        System.out.println(library.searchClip("Trap"));

        System.out.println("Removing Sunset Drums:");
        System.out.println(library.removeClip("Sunset Drums"));

        System.out.println("All clips after removal:");
        System.out.println(library.getAllClips());
    }
}