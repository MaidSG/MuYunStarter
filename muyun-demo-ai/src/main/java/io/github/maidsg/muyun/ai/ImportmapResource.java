package io.github.maidsg.muyun.ai;

import io.quarkus.runtime.Startup;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.mvnpm.importmap.Aggregator;

/**
 * Dynamically create the import map
 */
@ApplicationScoped
@Path("/_importmap")
public class ImportmapResource {

    private String importmap;

    @GET
    @Path("/dynamic.importmap")
    @Produces("application/importmap+json")
    public String importMap() {
        return this.importmap;
    }

    @GET
    @Path("/dynamic-importmap.js")
    @Produces("application/javascript")
    public String importMapJson() {
        return JAVASCRIPT_CODE.formatted(this.importmap);
    }

    @PostConstruct
    void init() {
        Aggregator aggregator = new Aggregator();
        // Add our own mappings
        aggregator.addMapping("icons/", "/icons/");
        aggregator.addMapping("components/", "/components/");
        aggregator.addMapping("fonts/", "/fonts/");
        // add for pod env use
        aggregator.addMapping("lit-html", "/_static/lit-html/3.2.1/lit-html.js");
        aggregator.addMapping("lit/", "/_static/lit/3.2.1/");
        aggregator.addMapping("lit-html/", "/_static/lit-html/3.2.1/");
        aggregator.addMapping("lit", "/_static/lit/3.2.1/index.js");
        aggregator.addMapping("wc-bubble", "/_static/wc-bubble/0.1.7/dist/wc-bubble.js");
        aggregator.addMapping("lit-element/", "/_static/lit-element/4.1.1/");
        aggregator.addMapping("wc-bubble/", "/_static/wc-bubble/0.1.7/dist/");
        aggregator.addMapping("lit-element", "/_static/lit-element/4.1.1/index.js");
        aggregator.addMapping("wc-chatbot/", "/_static/wc-chatbot/0.2.0/dist/");
//        aggregator.addMapping("", "");
//        aggregator.addMapping("", "");
//        aggregator.addMapping("", "");
//        aggregator.addMapping("", "");
//        aggregator.addMapping("", "");
//        aggregator.addMapping("", "");
        this.importmap = aggregator.aggregateAsJson();
    }

    private static final String JAVASCRIPT_CODE = """
            const im = document.createElement('script');
            im.type = 'importmap';
            im.textContent = JSON.stringify(%s);
            document.currentScript.after(im);
            """;
}
