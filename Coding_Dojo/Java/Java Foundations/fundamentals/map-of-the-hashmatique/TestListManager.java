import java.util.HashMap;
public class TestListManager {
  public static void main(String[] args) {
    ListManager generator = new ListManager();

    HashMap<String, String> trackList = new HashMap<String, String>(); // Creates a trackList of type HashMap

    for (byte i = 0; i < 4; ++i) { // Adds in 4 songs that are stored by title
      String testTitle = String.format("title%d", i + 1);
      String testLyrics = String.format("lyrics%d", i + 1);

      generator.addTrack(trackList, testTitle, testLyrics);
    }

    for (byte i = 0; i < 4; ++i) {
      String testTitle = String.format("title%d", i + 1);
      generator.pullSongByTitle(trackList, testTitle); // Pulls out a single song by its track title and displays its lyrics
    }

    generator.viewTrackList(trackList); // Prints out all the track names and lyrics in the format Track: Lyrics
  }
}
