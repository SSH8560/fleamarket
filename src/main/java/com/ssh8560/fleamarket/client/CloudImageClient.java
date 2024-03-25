package com.ssh8560.fleamarket.client;

import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CloudImageClient {
    @Value("${cloud.bucket-name}")
    private String imageBucket;
    private final AmazonS3 s3;

    public String uploadImage(MultipartFile multipartFile) throws SdkClientException {
        String fileName = UUID.randomUUID().toString();
        String key = "item/" + fileName;
        ObjectMetadata metadata = new ObjectMetadata();

        metadata.setContentLength(multipartFile.getSize());
        metadata.setContentType(multipartFile.getContentType());

        try {
            PutObjectResult result = s3.putObject(new PutObjectRequest(imageBucket, key, multipartFile.getInputStream(), metadata)
                .withCannedAcl(CannedAccessControlList.PublicRead)
                .withSdkRequestTimeout(1000));

            return fileName;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
