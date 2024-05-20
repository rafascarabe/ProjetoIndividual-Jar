package captura.dados.slack;

import org.json.JSONObject;

import java.io.IOException;

public class EnviarMensagem{

    public static void main(String[] args) throws IOException, InterruptedException {

        JSONObject json = new JSONObject();
        json.put("text", "Boa noite!" );

        Slack.sendMessage(json);

    }
}
