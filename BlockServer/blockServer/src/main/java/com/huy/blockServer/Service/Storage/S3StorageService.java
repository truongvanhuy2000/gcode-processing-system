package com.huy.blockServer.Service.Storage;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.huy.blockServer.Exception.StorageException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

@Service(value = "AmazonS3")
public class S3StorageService implements StorageService{
    @Value("${aws.accessKey}")
    private String awsAccesskey;
    @Value("${aws.secretKey}")
    private String secretKey;
    @Value("${aws.bucketName}")
    private String bucketName;
    private AmazonS3 s3Client;
    @Override
    public void init() {
        AWSCredentials awsCredentials = new BasicAWSCredentials(awsAccesskey, secretKey);
        s3Client = AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();
    }

    @Override
    public void store(MultipartFile multipartFile) {
        String fileName = multipartFile.getOriginalFilename();
        try {
            InputStream file = multipartFile.getInputStream();
            s3Client.putObject(bucketName, fileName, file, new ObjectMetadata());
        } catch (AmazonServiceException | IOException e) {
            throw new StorageException(e);
        }
    }

    public void load(String fileName){
        S3Object s3Object = s3Client.getObject(bucketName, fileName);
        S3ObjectInputStream inputStream = s3Object.getObjectContent();
        MultipartFile tempFile = new
    }
}
