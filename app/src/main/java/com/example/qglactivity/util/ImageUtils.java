package com.example.qglactivity.util;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipeline;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 作者: qgl
 * 创建日期：2021/11/3
 * 描述:图片工具
 */
public class  ImageUtils {

    /**
     * 图片更新返回Uri
     * SimpleDraweeView
     * @param uri
     * @return
     */
    public static Uri getUri(String uri) {
        if (!"".equals(uri) && !"null".equals(uri)) {
            Uri imgurl = Uri.parse(uri);
            // 清除Fresco对这条验证码的缓存
            ImagePipeline imagePipeline = Fresco.getImagePipeline();
            imagePipeline.evictFromMemoryCache(imgurl);
            imagePipeline.evictFromDiskCache(imgurl);
            return imgurl;
        }
        return null;
    }



    // 保存图片到本地相册
    public static boolean saveImageToGallery(Context context, Bitmap bmp) {
        // 首先保存图片
        String storePath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "newMvp";
        File appDir = new File(storePath);
        if (!appDir.exists()) {
            appDir.mkdir();
        }
        String fileName = System.currentTimeMillis() + "screenshot.png";
        File file = new File(appDir, fileName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            //通过io流的方式来压缩保存图片
            boolean isSuccess = bmp.compress(Bitmap.CompressFormat.JPEG, 60, fos);
            fos.flush();
            fos.close();

            //把文件插入到系统图库
            //MediaStore.Images.Media.insertImage(context.getContentResolver(), file.getAbsolutePath(), fileName, null);
            //保存图片后发送广播通知更新数据库
            Uri uri = Uri.fromFile(file);
            context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, uri));
            if (isSuccess) {
                return true;
            } else {
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
} 