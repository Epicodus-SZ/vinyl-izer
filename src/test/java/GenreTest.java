import org.junit.*;
import static org.junit.Assert.*;

public class GenreTest {
  @Test
  public void Genre_instantiatesCorrectly_true() {
    Genre testGenre = new Genre("jazz");
    assertEquals(true, testGenre instanceof Genre);
  }
  @Test
  public void getGenreName_returnsNameOfGenre_jazz() {
    Genre testGenre = new Genre("jazz");
    assertEquals("jazz", testGenre.getGenreName());
  }
  @Test
  public void resetGenre_clearsTheGenreList_0() {
    Genre testGenre = new Genre("jazz");
    Genre.reset();
    assertEquals(0, Genre.getSize());
  }
  @Test
  public void getSize_ReturnsTheSizeOfTheGenreList_2() {
    Genre.reset();
    Genre testGenre = new Genre("jazz");
    Genre testGenre2 = new Genre("country");
    assertEquals(2, Genre.getSize());
  }
  @Test
  public void find_ReturnsTheCorrectGenreName_() {
    Genre.reset();
    Genre testGenre = new Genre("jazz");
    Genre v2Genre = new Genre("country");
    Genre gotGenre = Genre.find(1);
    assertEquals("jazz", gotGenre.getGenreName());
  }

}
