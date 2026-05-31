package beatlibrarymanager;

/**
 * Loop represents a loop object in the Beat Library Manager project.
 * 
 * @author Jalen Bui
 */
public class Loop extends AudioClip
{
    /**
     * Constructs a Loop object.
     * 
     * @param title the title of the loop
     * @param bpm the beats per minute
     * @param genre the genre of the loop
     * @param key the musical key
     * @param duration the duration of the loop
     * @param notes extra notes about the loop
     */
    public Loop(String title, int bpm, String genre, String key, String duration, String notes)
    {
        super(title, bpm, genre, key, duration, notes);
    }

    /**
     * Returns a formatted description of the loop.
     * 
     * @return loop details as a string
     */
    @Override
    public String getDetails()
    {
        return "Type: Loop, " + super.getDetails();
    }
}