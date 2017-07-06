import java.util.ArrayList;
import java.util.List;

public class Genre {
  private String mName;
  private static List<Genre> instances = new ArrayList<Genre>();
  private int mId;
  private List<Vinyl> mVinyls;

  public Genre(String name){
    mName = name;
    instances.add(this);
    mId = instances.size();
    mVinyls = new ArrayList<Vinyl>();
  }
  public String getGenreName() {
    return mName;
  }
  public static void reset() {
    instances.clear();
  }
  public static int getSize() {
    return instances.size();
  }
  public static Genre find(int id) {
    return instances.get(id - 1);
  }
}
