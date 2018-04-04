import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.jasypt.util.text.BasicTextEncryptor;

import java.io.*;
import java.net.InetAddress;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String data = "{\n" +
                "    \"_index\": \"goog_03092018\",\n" +
                "    \"_type\": \"REPORT\",\n" +
                "    \"_id\": \"-127417804\",\n" +
                "    \"_version\": 5,\n" +
                "    \"found\": true,\n" +
                "    \"_source\": {\n" +
                "        \"name\": \"test3.txt\",\n" +
                "        \"cscId\": 135,\n" +
                "        \"nativeType\": \"file\",\n" +
                "        \"granted\": [\n" +
                "            \"View Content\"\n" +
                "        ],\n" +
                "        \"denied\": [],\n" +
                "        \"description\": \"\",\n" +
                "        \"theiaType\": \"REPORT\",\n" +
                "        \"mimeType\": \"text/plain\",\n" +
                "        \"contentLocator\": \"{\\\"locatorType\\\":\\\"com.motio.adf.content.google.util.GoogleContentLocator\\\",\\\"path\\\":\\\"0B5eRcT8dejbDTHFHNjU3RXhTczA\\\",\\\"ancestors\\\":\\\"ANCESTORS\\\",\\\"trackChanges\\\":false}\",\n" +
                "        \"mountPoints\": [\n" +
                "            148,\n" +
                "            0\n" +
                "        ]\n" +
                "    }\n" +
                "}";
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode rootNode = objectMapper.readTree(data);
            String ancestors = objectMapper.readTree(rootNode.path("_source").path("contentLocator").asText()).path("ancestors").asText();
            String parentId = objectMapper.readTree(rootNode.path("_source").path("contentLocator").asText()).path("path").asText();
            List<Long> mountPoints = new ArrayList<>();
            rootNode.path("_source").path("mountPoints").forEach(m -> mountPoints.add(m.asLong()));
            mountPoints.forEach(m -> System.out.println(m));
            System.out.println(ancestors);
            System.out.println(ancestors + "/" + parentId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
