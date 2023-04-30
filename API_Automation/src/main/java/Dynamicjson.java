import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dynamicjson {

    @Test(dataProvider = "BooksData")
    public void addBook(String aisle, String isbn){
        RestAssured.baseURI="http://216.10.245.166";
        String response = given().header("Content-Type","application/json").
                body(Files.Addbook(aisle, isbn)).when()
                .post("/Library/Addbook.php")
                .then().assertThat().statusCode(200)
                .extract().response().asString();
        JsonPath js = new JsonPath(response);
        String id = js.get("ID");
        System.out.println(id);
    }

    @DataProvider(name="BooksData")
    public Object[][] getData(){
        return new Object[][] {{"objdfssdf","9363"},{"sdfsdfsdfs","23432"},{"sdfsdfsfawegr","54432"}};
    }
}
