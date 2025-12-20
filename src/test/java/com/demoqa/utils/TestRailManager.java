package com.demoqa.utils;

import com.demoqa.config.ConfigManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class TestRailManager {
    private static final Logger logger = LoggerFactory.getLogger(TestRailManager.class);
    private static final String BASE_URL = ConfigManager.getProperty("testrail.url");
    private static final String USERNAME = ConfigManager.getProperty("testrail.user");
    private static final String PASSWORD = ConfigManager.getProperty("testrail.password");
    private static final boolean ENABLED = Boolean.parseBoolean(ConfigManager.getProperty("testrail.enabled", "false"));

    public static void addResultForTestCase(String testCaseId, int statusId, String comment) {
        if (!ENABLED)
            return;

        try {
            String runId = "1"; // This would typically be dynamic or passed in
            String endpoint = BASE_URL + "/index.php?/api/v2/add_result_for_case/" + runId + "/" + testCaseId;

            Map<String, Object> body = new HashMap<>();
            body.put("status_id", statusId);
            body.put("comment", comment);

            String jsonBody = new ObjectMapper().writeValueAsString(body);
            String auth = Base64.getEncoder().encodeToString((USERNAME + ":" + PASSWORD).getBytes());

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endpoint))
                    .header("Authorization", "Basic " + auth)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                    .build();

            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                logger.error("Failed to update TestRail: " + response.body());
            } else {
                logger.info("Updated TestRail for case " + testCaseId);
            }

        } catch (Exception e) {
            logger.error("Error updating TestRail", e);
        }
    }
}
