package beatlibrarymanager;

/**
 * AudioClip stores shared information for beats and loops.
 * It acts as the parent class for the Beat Library Manager project.
 * 
 * @author Jalen Bui
 */
public class AudioClip
{
    private String title;
    private int bpm;
    private String genre;
    private String key;
    private String duration;
    private String notes;

    /**
     * Constructs an AudioClip object with all clip fields.
     * 
     * @param title the title of the clip
     * @param bpm the beats per minute
     * @param genre the genre of the clip
     * @param key the musical key
     * @param duration the clip duration
     * @param notes extra notes about the clip
     */
    public AudioClip(String title, int bpm, String genre, String key, String duration, String notes)
    {
        this.title = title;
        this.bpm = bpm;
        this.genre = genre;
        this.key = key;
        this.duration = duration;
        this.notes = notes;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public int getBpm()
    {
        return bpm;
    }

    public void setBpm(int bpm)
    {
        this.bpm = bpm;
    }

    public String getGenre()
    {
        return genre;
    }

    public void setGenre(String genre)
    {
        this.genre = genre;
    }

    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    public String getDuration()
    {
        return duration;
    }

    public void setDuration(String duration)
    {
        this.duration = duration;
    }

    public String getNotes()
    {
        return notes;
    }

    public void setNotes(String notes)
    {
        this.notes = notes;
    }

    /**
     * Returns a formatted description of the clip.
     * 
     * @return clip details as a string
     */
    public String getDetails()
    {
        return "Title: " + title
                + ", BPM: " + bpm
                + ", Genre: " + genre
                + ", Key: " + key
                + ", Duration: " + duration
                + ", Notes: " + notes;
    }
}