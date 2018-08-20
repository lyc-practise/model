package com.minio;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import io.minio.MinioClient;
import io.minio.ObjectStat;
import io.minio.Result;
import io.minio.errors.*;
import io.minio.messages.Item;
import org.xmlpull.v1.XmlPullParserException;

import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class MinioTest {

    private static String bucketName = "testbucket";
    private static String keyName = "hosts";
    private static String uploadFileName = "/etc/hosts";



    private static MinioClient getMinioClient(){
        try{
            return new MinioClient("47.104.241.116", 9990,
                    "AKIAIOSFODNN7EXAMPLE",
                    "wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY", false);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("获取minioClient失败");
        }

//        return null;

        List<List> res = JSON.parseObject("", new TypeReference<List<List>>(){});


        return null;
    }

    public static List<Album> listAlbums(String bucketName) throws NoSuchAlgorithmException,
            IOException, InvalidKeyException, XmlPullParserException, MinioException {

        List<Album> list = new ArrayList<Album>();

        // Initialize minio client object.

        MinioClient minioClient = getMinioClient();

        Iterable<Result<Item>> myObjects = minioClient.listObjects(bucketName);

        // Iterate over each elements and set album url.
        for (Result<Item> result : myObjects) {
            Item item = result.get();
            System.out.println(item.lastModified() + ", " + item.size() + ", " + item.objectName());

            // Create a new Album Object
            Album album = new Album();

            // Set the presigned URL in the album object
            album.setUrl(minioClient.presignedGetObject(bucketName, item.objectName(), 60 * 60 * 24));

            ObjectStat stat = minioClient.statObject("","");

            // Add the album object to the list holding Album objects
            list.add(album);

        }

        // Return list of albums.
        return list;
    }

    public static String upload(String bucket, File file)
            throws IOException, InvalidKeyException, NoSuchAlgorithmException, InsufficientDataException, InternalException, NoResponseException, InvalidBucketNameException, XmlPullParserException, ErrorResponseException, RegionConflictException, InvalidArgumentException, InvalidExpiresRangeException {
        MinioClient minioClient = getMinioClient();
        if(!minioClient.bucketExists(bucket)){
           minioClient.makeBucket(bucket);
        }

        minioClient.putObject(bucket, file.getName(),file.getAbsolutePath());
        return "";
//        return minioClient.presignedGetObject("bucket","scale_100_img.jpg", -1);
    }

    public static void download(String bucket , String objName, String dirFilePath) throws IOException, InvalidKeyException, NoSuchAlgorithmException, InsufficientDataException, InvalidArgumentException, InternalException, NoResponseException, InvalidBucketNameException, XmlPullParserException, ErrorResponseException {
        MinioClient minioClient = getMinioClient();
        InputStream inputStream = minioClient.getObject(bucket, objName);
        File dirfile = new File(dirFilePath);
        if(dirfile.exists()){
            dirfile.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(dirfile);
        byte[] bytes = new byte[1024];
        while( inputStream.read(bytes) != -1 ){
            fileOutputStream.write(bytes);
        }
        fileOutputStream.flush();
        fileOutputStream.close();
        inputStream.close();

    }

    public static void main(String[] args) throws MinioException, XmlPullParserException, NoSuchAlgorithmException, InvalidKeyException, IOException {

//        显示桶中的文件
//        List<Album> result = listAlbums("mybucket");
//        for(Album album : result){
//            System.out.println(album.getUrl());
//        }

//        上传文件
//        String url = upload("mybucket", new File("/Users/tesla/Documents/scale_100_img.jpg"));
//        System.out.println(url);

//        下载文件
         download("mybucket", "file.txt", "/Users/tesla/Documents/file2.txt");


    }


}
