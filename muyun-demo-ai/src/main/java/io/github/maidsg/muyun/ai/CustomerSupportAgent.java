package io.github.maidsg.muyun.ai;

import io.quarkiverse.langchain4j.RegisterAiService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.ws.rs.Path;

@SessionScoped
@RegisterAiService
public interface CustomerSupportAgent {

    String chat(String userMessage);
}
