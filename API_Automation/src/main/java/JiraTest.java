import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.io.File;

import static io.restassured.RestAssured.*;

public class JiraTest {
    public static void main(String[] args){
        RestAssured.baseURI="http://localhost:8080/";
        SessionFilter session = new SessionFilter();
        String response = given().header("Content-Type","application/json").body("{\n" +
                "    \"username\": \"deepaksihare891\",\n" +
                "    \"password\": \"Deepak@2406\"\n" +
                "}").log().all().filter(session).when().post("rest/auth/1/session").then().extract().response().asString();

        String expectedMessage = "Hi How are you?";
        //Add Comment
        String addCommentResponse = given().pathParam("id","10002").log().all().header("Content-Type","application/json").body("{\n" +
                "    \"body\": \""+expectedMessage+"\",\n" +
                "    \"visibility\": {\n" +
                "        \"type\": \"role\",\n" +
                "        \"value\": \"Administrators\"\n" +
                "    }\n" +
                "}").filter(session).when().post("rest/api/2/issue/{id}/comment").then().log().all().assertThat().statusCode(201).extract().response().asString();
        JsonPath js = new JsonPath(addCommentResponse);
        String commentId = js.getString("id");

        //Add Attachment
        given().header("X-Atlassian-Token","no-check").filter(session).pathParam("id","10002")
                .header("Content-Type","multipart/form-data")
                .multiPart("file",new File("Jira.txt")).when()
                .post("rest/api/2/issue/{id}/attachments").then().log().all().assertThat().statusCode(200);

        String issueDetails = given().filter(session).pathParam("key","10002")
                .queryParam("fields","comment").log().all()
                .when().get("rest/api/2/issue/{key}").then().log().all().extract().response().asString();

        System.out.println(issueDetails);

        JsonPath js1 = new JsonPath(issueDetails);
        int commentsCount = js1.getInt("fields.comment.comments.size()");
        for (int i=0;i<commentsCount;i++){
            String commentIdIssue = js1.get("fields.comment.comments["+i+"].id").toString();
            if(commentIdIssue.equalsIgnoreCase(commentId)){
                String message = js1.get("fields.comment.comments["+i+"].body").toString();
                System.out.println(message);
                Assert.assertEquals(message,expectedMessage);
            }
        }
    }
}
