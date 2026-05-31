package beatlibrarymanager;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * BeatLibraryGUI creates the graphical user interface for the Beat Library
 * Manager project.
 * 
 * @author Jalen Bui
 */
public class BeatLibraryGUI extends JFrame
{
    private BeatLibrary library;
    private FileManager fileManager;

    private JTextField titleField;
    private JTextField bpmField;
    private JTextField genreField;
    private JTextField keyField;
    private JTextField durationField;
    private JTextField notesField;
    private JTextField searchField;
    private JTextField fileField;
    private JTextField typeField;

    private JButton addButton;
    private JButton removeButton;
    private JButton searchButton;
    private JButton displayAllButton;
    private JButton saveButton;
    private JButton loadButton;
    private JButton clearButton;

    private JTextArea outputArea;

    /**
     * Constructs the Beat Library Manager GUI.
     */
    public BeatLibraryGUI()
    {
        library = new BeatLibrary();
        fileManager = new FileManager();

        setTitle("Beat Library Manager");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(9, 2));

        inputPanel.add(new JLabel("Clip Type (Beat or Loop):"));
        typeField = new JTextField();
        inputPanel.add(typeField);

        inputPanel.add(new JLabel("Title:"));
        titleField = new JTextField();
        inputPanel.add(titleField);

        inputPanel.add(new JLabel("BPM:"));
        bpmField = new JTextField();
        inputPanel.add(bpmField);

        inputPanel.add(new JLabel("Genre:"));
        genreField = new JTextField();
        inputPanel.add(genreField);

        inputPanel.add(new JLabel("Key:"));
        keyField = new JTextField();
        inputPanel.add(keyField);

        inputPanel.add(new JLabel("Duration:"));
        durationField = new JTextField();
        inputPanel.add(durationField);

        inputPanel.add(new JLabel("Notes:"));
        notesField = new JTextField();
        inputPanel.add(notesField);

        inputPanel.add(new JLabel("Search Keyword:"));
        searchField = new JTextField();
        inputPanel.add(searchField);

        inputPanel.add(new JLabel("File Name:"));
        fileField = new JTextField("clips.txt");
        inputPanel.add(fileField);

        add(inputPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 4));

        addButton = new JButton("Add Clip");
        removeButton = new JButton("Remove Clip");
        searchButton = new JButton("Search");
        displayAllButton = new JButton("Display All");
        saveButton = new JButton("Save");
        loadButton = new JButton("Load");
        clearButton = new JButton("Clear");

        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(displayAllButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);
        buttonPanel.add(clearButton);

        add(buttonPanel, BorderLayout.CENTER);

        outputArea = new JTextArea(12, 40);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        add(scrollPane, BorderLayout.SOUTH);

        // Connect each button to its matching method.
        addButton.addActionListener(e -> addClip());
        removeButton.addActionListener(e -> removeClip());
        searchButton.addActionListener(e -> searchClip());
        displayAllButton.addActionListener(e -> displayAllClips());
        saveButton.addActionListener(e -> saveLibrary());
        loadButton.addActionListener(e -> loadLibrary());
        clearButton.addActionListener(e -> clearFields());
    }

    /**
     * Adds a clip using the text field values.
     */
    public void addClip()
    {
        try
        {
            String type = typeField.getText().trim();
            String title = titleField.getText().trim();
            int bpm = Integer.parseInt(bpmField.getText().trim());
            String genre = genreField.getText().trim();
            String key = keyField.getText().trim();
            String duration = durationField.getText().trim();
            String notes = notesField.getText().trim();

            AudioClip clip;

            // Create the correct object type based on the user input.
            if (type.equalsIgnoreCase("Beat"))
            {
                clip = new Beat(title, bpm, genre, key, duration, notes);
            }
            else if (type.equalsIgnoreCase("Loop"))
            {
                clip = new Loop(title, bpm, genre, key, duration, notes);
            }
            else
            {
                outputArea.setText("Please enter Beat or Loop as the clip type.");
                return;
            }

            library.addClip(clip);
            outputArea.setText("Clip added successfully.\n\n" + library.getAllClips());
        }
        catch (NumberFormatException exception)
        {
            // BPM must be a number, so catch bad input here.
            outputArea.setText("Please enter a valid number for BPM.");
        }
    }

    /**
     * Removes a clip using the title field.
     */
    public void removeClip()
    {
        String title = titleField.getText().trim();
        boolean removed = library.removeClip(title);

        if (removed)
        {
            outputArea.setText("Clip removed successfully.\n\n" + library.getAllClips());
        }
        else
        {
            outputArea.setText("Clip not found.");
        }
    }

    /**
     * Searches for clips using the search field.
     */
    public void searchClip()
    {
        String keyword = searchField.getText().trim();
        outputArea.setText(library.searchClip(keyword));
    }

    /**
     * Displays all clips in the library.
     */
    public void displayAllClips()
    {
        outputArea.setText(library.getAllClips());
    }

    /**
     * Saves the library to a file.
     */
    public void saveLibrary()
    {
        try
        {
            String fileName = fileField.getText().trim();

            if (fileName.equals(""))
            {
                outputArea.setText("Please enter a file name.");
                return;
            }

            fileManager.saveToFile(fileName, library.getClips());
            outputArea.setText("Library saved to " + fileName);
        }
        catch (FileNotFoundException exception)
        {
            outputArea.setText("Error saving file. Please check the file name or path.");
        }
        catch (Exception exception)
        {
            outputArea.setText("Unexpected error while saving: " + exception.getMessage());
        }
    }

    /**
     * Loads the library from a file.
     */
    public void loadLibrary()
    {
        try
        {
            String fileName = fileField.getText().trim();

            if (fileName.equals(""))
            {
                outputArea.setText("Please enter a file name.");
                return;
            }

            ArrayList<AudioClip> loadedClips = fileManager.loadFromFile(fileName);
            library.setClips(loadedClips);
            outputArea.setText("Library loaded from " + fileName + "\n\n" + library.getAllClips());
        }
        catch (FileNotFoundException exception)
        {
            outputArea.setText("File not found. Please check the file name or path.");
        }
        catch (NumberFormatException exception)
        {
            outputArea.setText("Error reading file data.");
        }
        catch (Exception exception)
        {
            outputArea.setText("Unexpected error while loading: " + exception.getMessage());
        }
    }

    /**
     * Clears the text fields.
     */
    public void clearFields()
    {
        typeField.setText("");
        titleField.setText("");
        bpmField.setText("");
        genreField.setText("");
        keyField.setText("");
        durationField.setText("");
        notesField.setText("");
        searchField.setText("");
    }

    /**
     * Starts the GUI program.
     * 
     * @param args command line arguments
     */
    public static void main(String[] args)
    {
        BeatLibraryGUI gui = new BeatLibraryGUI();
        gui.setVisible(true);
    }
}