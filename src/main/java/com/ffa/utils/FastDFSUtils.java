package com.ffa.utils;

import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;


public class FastDFSUtils {
    private static StorageClient1 client1;

    static {
        try {
            ClientGlobal.initByProperties("fastdfs-client.properties");
            TrackerClient trackerClient = new TrackerClient();
            TrackerServer trackerServer = trackerClient.getConnection();
            StorageServer storageServer = null;
            client1 = new StorageClient1(trackerServer, storageServer);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    public static String upload(MultipartFile file) {
        String name = file.getOriginalFilename();
        String s = null;
        try {
            s = client1.upload_file1(file.getBytes(), name.substring(name.lastIndexOf(".") + 1), null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
        return s;
    }


    public static byte[] downloadFile(String fileId) {
        try {
            byte[] content = client1.download_file1(fileId);//得到文件的字节数组
            return content;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



}
