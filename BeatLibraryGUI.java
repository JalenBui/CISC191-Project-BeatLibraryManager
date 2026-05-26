package beatlibrarymanager;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * BeatLibraryGUI creates the basic graphical user interface for the
 * Beat Library Manager project.
 * 
 * @author Jalen Bui
 */
public class BeatLibraryGUI extends JFrame
{
    private JTextField titleField;
    private JTextField bpmField;
    private JTextField genreField;
    private JTextField keyField;
    private JTextField durationField;
    private JTextField notesField;

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
        setTitle("Beat Library Manager");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6, 2));

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

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        add(scrollPane, BorderLayout.SOUTH);
    }

    public static void main(String[] args)
    {
        BeatLibraryGUI gui = new BeatLibraryGUI();
        gui.setVisible(true);
    }
}