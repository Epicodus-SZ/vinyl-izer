import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public"); //might not need
    String layout = "templates/layout.vtl";

    get("/", (request,response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      //if no genre's make one
      if (Genre.getSize()==0){
        Genre default1 = new Genre("Jazz");
        Vinyl newVinyl1 = new Vinyl("Kind of Blue");
        default1.addVinyl(newVinyl1);
        Genre default2 = new Genre("Rock");
        Vinyl newVinyl2 = new Vinyl("Radio Kaos");
        default2.addVinyl(newVinyl2);
      }
      model.put("genres", Genre.getAll());
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("genres/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Genre genre = Genre.find(Integer.parseInt(request.params(":id")));
      model.put("genre", genre);
      model.put("template", "templates/genre.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("vinyls/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("genres", Genre.getAll());
      model.put("template", "templates/newVinyl.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("vinyls/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Genre genre = Genre.find(Integer.parseInt(request.queryParams("selectGenres")));
      String title = request.queryParams("title");
      Vinyl newVinyl = new Vinyl(title);
      genre.addVinyl(newVinyl);
      model.put("genre", genre);
      model.put("template", "templates/genre.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
