
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.InputStream;
//import sun.audio.*;
//import sun.audio.AudioStream;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mucah
 */
public class AudioPlayerr {

    public static void playMusic(String filepath){

        FileInputStream yolal = null;
        try {
            yolal = new FileInputStream(filepath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        AudioStream muzik;
        try {
            muzik = new AudioStream(yolal);
            AudioPlayer.player.start(muzik);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
    