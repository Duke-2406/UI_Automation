import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

    public static void main(String[] args){
        JsonPath js = new JsonPath(Files.CoursePrice());
        int count = js.getInt("courses.size()");
        System.out.println(count);
        int totolamount = js.getInt("dashboard.purchaseAmount");
        System.out.println(totolamount);
        String coursetitle = js.getString("courses[2].title");
        System.out.println(coursetitle);
    }
}