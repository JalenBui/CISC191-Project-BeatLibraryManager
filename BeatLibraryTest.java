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
        BeatLibrary library = new BeatLibrary();

        Beat beat1 = new Beat("MidChill Trap Drums", 140, "Trap", "F minor", "00:32", "Heavy 808 pattern");
        Loop loop1 = new Loop("Relaxed House Loop", 128, "House", "A minor", "00:16", "Smooth repeating synth");
        Beat beat2 = new Beat("Heavy Kick Snare Loop", 150, "Dubstep", "D minor", "00:28", "Aggressive drop idea");

        library.addClip(beat1);
        library.addClip(loop1);
        library.addClip(beat2);

        System.out.println("=== All Clips ===");
        System.out.println(library.getAllClips());

        System.out.println("=== Search: Trap ===");
        System.out.println(library.searchClip("Trap"));

        System.out.println("=== Search: A minor ===");
        System.out.println(library.searchClip("A minor"));

        System.out.println("=== Search: Jazz ===");
        System.out.println(library.searchClip("Jazz"));

        System.out.println("=== Remove Existing Clip ===");
        System.out.println(library.removeClip("MidChill Trap Drums"));

        System.out.println("=== Remove Nonexistent Clip ===");
        System.out.println(library.removeClip("Missing Clip"));

        System.out.println("=== All Clips After Removal ===");
        System.out.println(library.getAllClips());

        System.out.println("=== Clear Library ===");
        library.clearLibrary();
        System.out.println(library.getAllClips());

        System.out.println("=== Empty Search ===");
        System.out.println(library.searchClip(""));
    }
}