import java.util.HashMap;
import java.util.Set;
public class ListManager {

  /**
   * Adds a track to the track list.
   * @param trackList The track list [HashMap<String, String>]
   * @param title The song title [String]
   * @param sampleLyrics The song lyrics [String]
   * @return An updated track list [HashMap<String, String>]
   */
  public HashMap<String, String> addTrack(HashMap<String, String> trackList, String title, String sampleLyrics) {

    trackList.put(title, sampleLyrics);
    
    return trackList;
  }

  /**
   * Pulls a song by its title and displays its lyrics.
   * @param trackList The track list [HashMap<String, String>]
   * @param title The song title [String]
   */
  public void pullSongByTitle(HashMap<String, String> trackList, String title) {
    // Set<String> keys = trackList.keySet(); // get the keys by using the keySet method
    String value = trackList.get(title);

    System.out.printf("----- %s -----\n", title);
    System.out.println(value);
    
  }

  /**
   * Displays the track list in the console.
   * @param trackList The track list [HashMap<String, String>]
   */
  public void viewTrackList(HashMap<String, String> trackList) {
    Set<String> keys = trackList.keySet(); // get the keys by using the keySet method

    System.out.println("----- Current Set List -----");
    for(String key : keys) {
      String value = trackList.get(key);
      System.out.printf("%s: %s \n", key, value);
    }
  }
}
