import java.util.ArrayList;
import java.util.List;

public class Vinyl {
  private String mTitle;
  private static List<Vinyl> instances = new ArrayList<Vinyl>();
  private int mId;

  public Vinyl(String title){
    mTitle = title;
    instances.add(this);
    mId = instances.size();
  }

  public String getTitle() {
    return mTitle;
  }

  public int getId() {
    return mId;
  }

  public static void reset(){
    instances.clear();
  }

  public static int getSize(){
    return instances.size();
  }

  public static Vinyl find(int id){
    return instances.get(id - 1);
  }
}
