package beatlibrarymanager;

/**
 * Beat represents a beat object in the Beat Library Manager project.
 * 
 * @author Jalen Bui
 */
public class Beat extends AudioClip
{
    /**
     * Constructs a Beat object.
     * 
     * @param title the title of the beat
     * @param bpm the beats per minute
     * @param genre the genre of the beat
     * @param key the musical key
     * @param duration the duration of the beat
     * @param notes extra notes about the beat
     */
    public Beat(String title, int bpm, String genre, String key, String duration, String notes)
    {
        super(title, bpm, genre, key, duration, notes);
    }

    /**
     * Returns a formatted description of the beat.
     * 
     * @return beat details as a string
     */
    @Override
    public String getDetails()
    {
        return "Type: Beat, " + super.getDetails();
    }
}