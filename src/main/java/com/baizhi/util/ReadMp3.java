package com.baizhi.util;

import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;

import java.io.File;

public class ReadMp3 {

    public static String read(String name) {
        File file = new File(name);
        try {
            MP3File f = (MP3File) AudioFileIO.read(file);
            MP3AudioHeader audioHeader = (MP3AudioHeader) f.getAudioHeader();
            return audioHeader.getTrackLength() / 60 + ":" + audioHeader.getTrackLength() % 60;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String size(String name) {
        File f = new File(name);
        if (f.exists() && f.isFile()) {
            if (f.length() >= (1024 * 1024)) {
                Long a = f.length() / 1024 % 1024;
                if (a.toString().length() <= 3) {
                    a = a / 100;
                    return (f.length() / 1024) / 1024 + "." + a + "MB";
                } else if (a.toString().length() == 4) {
                    return (f.length() / 1024) / 1024 + 1 + "MB";
                } else {
                    return (f.length() / 1024) / 1024 + "MB";
                }
            } else if (f.length() >= 1024) {
                Long a = f.length() % 1024;
                if (a.toString().length() <= 3) {
                    a = a / 100;
                    return f.length() / 1024 + "." + a + "KB";
                } else if (a.toString().length() == 4) {
                    return f.length() / 1024 + 1 + "KB";
                } else {
                    return f.length() / 1024 + "KB";
                }
            } else if (f.length() < 1024) {
                return f.length() + "B";
            }

        }
        return "file doesn't exist or is not a file";

    }

}