package beatlibrarymanager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * FileManager saves and loads BeatLibrary data using a text file.
 * 
 * @author Jalen Bui
 */
public class FileManager
{
    /**
     * Saves the current clips to a text file.
     * 
     * @param fileName the name or path of the file
     * @param clips the clips to save
     * @throws FileNotFoundException if the file cannot be created
     */
    public void saveToFile(String fileName, ArrayList<AudioClip> clips) throws FileNotFoundException
    {
        File file = new File(fileName);
        PrintWriter writer = new PrintWriter(file);

        // Write one clip per line so the file can be loaded later.
        for (AudioClip clip : clips)
        {
            String type = "AudioClip";

            // Check which subclass the clip belongs to.
            if (clip instanceof Beat)
            {
                type = "Beat";
            }
            else if (clip instanceof Loop)
            {
                type = "Loop";
            }

            // Separate values with ;; so they can be split when loading.
            writer.println(type + ";;"
                    + clip.getTitle() + ";;"
                    + clip.getBpm() + ";;"
                    + clip.getGenre() + ";;"
                    + clip.getKey() + ";;"
                    + clip.getDuration() + ";;"
                    + clip.getNotes());
        }

        writer.close();
    }

    /**
     * Loads clips from a text file.
     * 
     * @param fileName the name or path of the file
     * @return the loaded clips
     * @throws FileNotFoundException if the file cannot be opened
     */
    public ArrayList<AudioClip> loadFromFile(String fileName) throws FileNotFoundException
    {
        ArrayList<AudioClip> loadedClips = new ArrayList<AudioClip>();
        File file = new File(fileName);
        Scanner input = new Scanner(file);

        // Read the file one line at a time.
        while (input.hasNextLine())
        {
            String line = input.nextLine();
            String[] parts = line.split(";;", -1);

            // Make sure the line has the expected format.
            if (parts.length == 7)
            {
                String type = parts[0];
                String title = parts[1];
                int bpm = Integer.parseInt(parts[2]);
                String genre = parts[3];
                String key = parts[4];
                String duration = parts[5];
                String notes = parts[6];

                // Rebuild the correct object type from the saved text.
                if (type.equals("Beat"))
                {
                    loadedClips.add(new Beat(title, bpm, genre, key, duration, notes));
                }
                else if (type.equals("Loop"))
                {
                    loadedClips.add(new Loop(title, bpm, genre, key, duration, notes));
                }
            }
        }

        input.close();
        return loadedClips;
    }
}