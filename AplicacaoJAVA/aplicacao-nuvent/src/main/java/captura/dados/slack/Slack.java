package captura.dados.slack;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Slack {

    private static HttpClient client = HttpClient.newHttpClient(); //Nosso http, responsável por fazer as requisições e obter respostas
    private static final String url = "https://hooks.slack.com/services/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";


    public static void sendMessage(JSONObject content) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder( // receber a url
                URI.create(url))
                .header("accept", "application/json") //configurar os headers padrões
                .POST(HttpRequest.BodyPublishers.ofString(content.toString())) //postar a mensagem
                .build(); //terminar a requisição e armazenar no objeto request


        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString()); // vai receber a resposta do cliente


        System.out.println(String.format("Status: %s", response.statusCode())); // saber se aconteceu nossa solicitação
        System.out.println(String.format("Response: %s", response.body())); //capturar resposta
    }

}
