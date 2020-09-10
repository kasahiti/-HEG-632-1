import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
/**
 * Write a description of class PictureReader here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PictureReader
{
    // instance variables - replace the example below with your ow
    /**
     * Constructor for objects of class PictureReader
     */
    public PictureReader()
    {
        // initialise instance variables
    }

    /**
     * Read music files from the given library folder
     * with the given suffix.
     * @param folder The folder to look for files.
     * @param suffix The suffix of the audio type.
     */
    public ArrayList<Picture> readPictures(String folder, String suffix)
    {
        File pictureFolder = new File(folder);
        File[] pictureFiles = pictureFolder.listFiles((dir, name) -> 
                    name.toLowerCase().endsWith(suffix));
        
        // Put all the matching files into the organizer.
        ArrayList<Picture> tracks = 
            Arrays.stream(pictureFiles).
                   map(file -> new Picture(file.getPath())).
                   collect(Collectors.toCollection(ArrayList::new));
        return tracks;
    }
}
