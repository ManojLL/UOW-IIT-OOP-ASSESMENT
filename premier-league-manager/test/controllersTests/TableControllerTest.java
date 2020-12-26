package controllersTests;

import org.junit.Test;
import play.Application;
import play.inject.guice.GuiceApplicationBuilder;
import play.test.WithApplication;
import play.mvc.Http.RequestBuilder;
import play.mvc.Result;

import static org.junit.Assert.assertEquals;
import static play.test.Helpers.GET;
import static play.test.Helpers.route;
import static play.mvc.Http.Status.OK;

public class TableControllerTest extends WithApplication {
    @Override
    protected Application provideApplication() {
        return new GuiceApplicationBuilder().build();
    }

    @Test
    public void test_getTableAccordingToPoints() {
        RequestBuilder request = new RequestBuilder()
                .method(GET)
                .uri("/api/tables/points");
        Result result = route(app, request);
        assertEquals(OK, result.status());
        assertEquals("application/json", result.contentType().get());
    }

    @Test
    public void test_getTableAccordingToWins() {
        RequestBuilder request = new RequestBuilder()
                .method(GET)
                .uri("/api/tables/wins");
        Result result = route(app, request);
        assertEquals(OK, result.status());
        assertEquals("application/json", result.contentType().get());
    }

    @Test
    public void test_getTableAccordingToGoals() {
        RequestBuilder request = new RequestBuilder()
                .method(GET)
                .uri("/api/tables/goals");
        Result result = route(app, request);
        assertEquals(OK, result.status());
        assertEquals("application/json", result.contentType().get());
    }
}
