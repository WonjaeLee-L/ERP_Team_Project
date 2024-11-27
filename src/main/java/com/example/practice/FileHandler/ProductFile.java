package com.example.practice.FileHandler;

import net.coobird.thumbnailator.Thumbnailator;
import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

import net.coobird.thumbnailator.Thumbnails;

@Component
public class ProductFile {
    public String saveFile(MultipartFile file) throws Exception, AssertionError {

        String uploadDir = "C:/Data/aa/projectSample-master/src/main/resources/static/productImg/";
        String originName = file.getOriginalFilename();
        if (originName == null) throw new AssertionError("null");
        String fileName = UUID.randomUUID().toString() + "." + originName.split("\\.")[1];
        File target = getFile(uploadDir, fileName);

        FileCopyUtils.copy(file.getBytes(), target);
//        return fileName;
        return target.getPath();
    }

    private static File getFile(String uploadDir, String fileName) {
        File target = new File(uploadDir, fileName);
        // 뒤에 추가하는만큼 자르기
//        String thumbnail = uploadDir + fileName.substring(3)+"thumb";
//        Thumbnails.of(new File(thumbnail))
//                .size(50, 50)
//                .sourceRegion(Positions.CENTER, 50, 50)
//                .toFile(target);
//        File thumbnailFile = new File(thumbnail);
//        Thumbnailator.createThumbnail(thumbnail.toFile(), thumbnailFile, 50,50);

        if (!target.getParentFile().exists()) {
            target.getParentFile().mkdirs();
        }
        return target;
    }

//    @RequestMapping(value =)
//    public FileSystemResource fileDownload(MultipartFile file) {
//        File file = new File()
//    }

//    public String saveThumbnail(MultipartFile file) throws Exception, AssertionError {
//
//        String uploadDir = "C:/Data/aa/projectSample-master/src/main/resources/static/product_img/";
//        String originName = file.getOriginalFilename();
//        if (originName == null) throw new AssertionError("null");
//        String fileName = UUID.randomUUID().toString() + "." + originName.split("\\.")[1];
//        File target = new File(uploadDir, fileName);
//        // 뒤에 추가하는만큼 자르기
//        String thumbnail = uploadDir + fileName.substring(3)+"thumb";
//        Thumbnails.of(new File(thumbnail))
//                .size(50, 50)
//                .sourceRegion(Positions.CENTER, 50, 50)
//                .toFile(target);
////        File thumbnailFile = new File(thumbnail);
////        Thumbnailator.createThumbnail(thumbnail.toFile(), thumbnailFile, 50,50);
//
//        if (!target.getParentFile().exists()) {
//            target.getParentFile().mkdirs();
//        }
//
//        FileCopyUtils.copy(file.getBytes(), target);
////        return fileName;
//        return thumbnail;
//    }


}
