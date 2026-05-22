package beatlibrarymanager;

import java.util.ArrayList;

/**
 * BeatLibrary stores and manages a collection of audio clips.
 * 
 * @author Jalen Bui
 */
public class BeatLibrary
{
    private ArrayList<AudioClip> clips;

    /**
     * Constructs an empty BeatLibrary.
     */
    public BeatLibrary()
    {
        clips = new ArrayList<AudioClip>();
    }

    /**
     * Adds a clip to the library.
     * 
     * @param clip the clip to add
     */
    public void addClip(AudioClip clip)
    {
        clips.add(clip);
    }

    /**
     * Removes the first clip with a matching title.
     * 
     * @param title the title of the clip to remove
     * @return true if a clip was removed, false otherwise
     */
    public boolean removeClip(String title)
    {
        for (int i = 0; i < clips.size(); i++)
        {
            if (clips.get(i).getTitle().equalsIgnoreCase(title))
            {
                clips.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Searches for clips whose title, genre, or key matches the keyword.
     * 
     * @param keyword the search word
     * @return matching clips as a string
     */
    public String searchClip(String keyword)
    {
        String results = "";

        for (AudioClip clip : clips)
        {
            if (clip.getTitle().equalsIgnoreCase(keyword)
                    || clip.getGenre().equalsIgnoreCase(keyword)
                    || clip.getKey().equalsIgnoreCase(keyword))
            {
                results += clip.getDetails() + "\n";
            }
        }

        if (results.equals(""))
        {
            return "No matching clips found.";
        }

        return results;
    }

    /**
     * Returns all clips in the library as a string.
     * 
     * @return all clip details
     */
    public String getAllClips()
    {
        String allClips = "";

        for (AudioClip clip : clips)
        {
            allClips += clip.getDetails() + "\n";
        }

        if (allClips.equals(""))
        {
            return "The library is empty.";
        }

        return allClips;
    }

    /**
     * Clears all clips from the library.
     */
    public void clearLibrary()
    {
        clips.clear();
    }
}