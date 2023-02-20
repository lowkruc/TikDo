package com.asemediatech.tiktokdownloader.utils;

import android.os.Environment;
import android.os.FileObserver;
import android.util.Log;
import android.webkit.MimeTypeMap;

import java.io.File;
import java.security.MessageDigest;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class SystemUtils {
    private static final char[] DIGITS_UPPER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private FileObserver fileObserver;
    public static String getRanInt(int i){
        StringBuilder sb=new StringBuilder();
        for (int j = 0; j <i ; j++) {
            String s=Integer.toHexString(new Random().nextInt(10));
            sb.append(s);
        }
        return sb.toString();
    }

    public static String md5Hex(byte[] bArr) {
        try {
            return new String(encodeHex(MessageDigest.getInstance("MD5").digest(bArr), DIGITS_UPPER));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static char[] encodeHex(byte[] bArr, char[] cArr) {
        int length = bArr.length;
        char[] cArr2 = new char[(length << 1)];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i + 1;
            cArr2[i] = cArr[(bArr[i2] & 240) >>> 4];
            i = i3 + 1;
            cArr2[i3] = cArr[bArr[i2] & 15];
        }
        return cArr2;
    }


    public List<File> getListFiles() {
        String pathx = Environment.getExternalStorageDirectory().toString()+"/TikDo Download/";
        File dir = new File(pathx);
        List<File> inFiles = new ArrayList<>();
        Queue<File> files = new LinkedList<>();
        if(dir.exists() && dir.listFiles() != null){
            files.addAll(Arrays.asList(dir.listFiles()));
            while (!files.isEmpty()) {
                File file = files.remove();
                if (file.isDirectory()) {
                    files.addAll(Arrays.asList(file.listFiles()));
                } else if (file.getName().endsWith(".mp4")) {
                    inFiles.add(file);
                }else if (file.getName().endsWith(".mp3")) {
                    inFiles.add(file);
                }
            }
            Log.d("FileList", inFiles.toString());
            return inFiles;
        }
        return null;
    }

    public String humanReadableByteCountSI(long bytes) {
        if (-1000 < bytes && bytes < 1000) {
            return bytes + " B";
        }
        CharacterIterator ci = new StringCharacterIterator("kMGTPE");
        while (bytes <= -999_950 || bytes >= 999_950) {
            bytes /= 1000;
            ci.next();
        }
        return String.format("%.1f %cB", bytes / 1000.0, ci.current());
    }

    public String getExtension (String filePath) {
        MimeTypeMap myMime = MimeTypeMap.getSingleton();
        return myMime.getMimeTypeFromExtension(fileExtension(filePath));
    }

    public static String fileExtension(String path) {
        if (path.indexOf("?") > -1) {
            path = path.substring(0, path.indexOf("?"));
        }
        if (path.lastIndexOf(".") == -1) {
            return null;
        } else {
            String ext = path.substring(path.lastIndexOf(".") + 1);
            if (ext.indexOf("%") > -1) {
                ext = ext.substring(0, ext.indexOf("%"));
            }
            if (ext.indexOf("/") > -1) {
                ext = ext.substring(0, ext.indexOf("/"));
            }
            return ext.toLowerCase();
        }
    }

}
