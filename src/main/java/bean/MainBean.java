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
import java.util.Calendar;
import java.util.Date;
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
    private String greet;
    private boolean tab1;
    private boolean tab2;
    private boolean tab3;
    private String class1;
    private String class2;
    private String class3;

    /**
     * コンストラクタ
     */
    public MainBean() {
    }

    public void refreshStat() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        switch(calendar.get(Calendar.HOUR_OF_DAY)){
            case 5: case 6: case 7: case 8: case 9: case 10:
                greet = "はいおはようございます";
                break;
            case 11: case 12: case 13: case 14: case 15: case 16:
                greet = "はいこんにちは";
                break;
            default:
                greet = "はいこんばんは";
        }
        tab1 = true;
        try {
            URL urlObj = new URL("http://livetube.cc/index.live.json");
            HttpURLConnection http = (HttpURLConnection) urlObj.openConnection();
            http.setRequestMethod("GET");
            http.connect();
            
            InputStream is = http.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String s;
            streamURL = "http://h.livetube.cc/RCjinrai/";
            while ((s = reader.readLine()) != null) {
                if(isStreaming = s.indexOf("\"link\": \"RCjinrai/") > 0){
                    isStreaming = true;
                    streamURL = "http://h.livetube.cc/" + s.split("\"")[3];
                    break;
                }
            }
        } catch (Exception e) {
            isStreaming = false;
        }
    }
    
    public void switch1(){
        class1 = "active";
        class2 = "";
        class3 = "";
    }
    public void switch2(){
        class2 = "active";
        class1 = "";
        class3 = "";
    }
    public void switch3(){
        class3 = "active";
        class1 = "";
        class2 = "";
    }
}
