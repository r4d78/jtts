/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import lombok.Data;

/**
 * ログイン画面のBackingBean
 */
@Named(value = "MainBean")
@Data
@RequestScoped
public class MainBean {

    private boolean isStreaming;
    private String streamURL;

    /**
     * コンストラクタ
     */
    public MainBean() {
    }

    public void checkTube() {
        try {
            URL urlObj = new URL("http://livetube.cc/index.live.json");
            HttpURLConnection http = (HttpURLConnection) urlObj.openConnection();
            http.setRequestMethod("GET");
            http.connect();

            InputStream is = http.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String s;
            String temp = null;
            isStreaming = false;
            while ((s = reader.readLine()) != null) {
                if(isStreaming = s.indexOf("\"link\": \"sinsin13/") > 0){
                    streamURL = "http://h.livetube.cc/" + s.split("\"")[3];
                    break;
                }
            }
        } catch (Exception e) {
            isStreaming = false;
        }
    }
}
