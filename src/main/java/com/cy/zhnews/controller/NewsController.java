package com.cy.zhnews.controller;

import com.cy.zhnews.entity.vo.IndexObject;
import com.cy.zhnews.service.NewsService;
import com.cy.zhnews.service.ex.FileEmptyException;
import com.cy.zhnews.service.ex.FileSizeException;
import com.cy.zhnews.service.ex.FileStateException;
import com.cy.zhnews.service.ex.FileUploadIOException;
import com.cy.zhnews.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.util.*;

@RestController
@RequestMapping("/news/")
public class NewsController {

    @Autowired
    private NewsService newsService;

    /**
     * 允许上传的头像文件的最大大小
     */
    public static final long AVATAR_MAX_SIZE = 5 * 1024 * 1024;
    /**
     * 允许上传的头像文件的类型列表
     */
    public static final List<String> AVATAR_CONTENT_TYPES = new ArrayList<String>();

    static {
        AVATAR_CONTENT_TYPES.add("image/jpeg");
        AVATAR_CONTENT_TYPES.add("image/png");
    }

    @RequestMapping("insertTitle")
    public JsonResult insertTitle(@RequestParam("tilteImage") MultipartFile tilteImage,
                                  @RequestParam("content") String content,
                                  @RequestParam("title") String title,
                                  @RequestParam("tid") int tid,
                                  @RequestParam("essay")String essay) throws IOException, FileEmptyException, FileSizeException, FileStateException, FileUploadIOException {
        if (tilteImage.isEmpty()) {
            throw new FileEmptyException(
                    "上传图片失败！请选择有效的图片文件！");
        }

        // 检查文件大小是否超出限制
        if (tilteImage.getSize() > AVATAR_MAX_SIZE) {
            throw new FileSizeException(
                    "上传图片失败！不允许上传超过" + (AVATAR_MAX_SIZE / 1024) + "KB的图片文件！");
        }//

        // 检查文件类型是否超出限制
        if (!AVATAR_CONTENT_TYPES.contains(tilteImage.getContentType())) {
            throw new FileSizeException(
                    "上传图片失败！选择的文件类型超出了限制！\r\r允许使用的文件类型有：" + AVATAR_CONTENT_TYPES);
        }

        // 确定文件夹
        String parentPath = "/webapps/upload";
        File parent = new File("D:/IdeaProject/zhnews/src/main/resources/static"+parentPath);
        if (!parent.exists()) {
            parent.mkdirs();
        }
        System.out.println(parentPath);
        // 确定文件名
        String filename = UUID.randomUUID().toString();
        String originalFilename = tilteImage.getOriginalFilename();
        int beginIndex = originalFilename.lastIndexOf(".");
        String suffix = originalFilename.substring(beginIndex);
        String child = filename + suffix;

        // 保存用户上传的文件
        File dest = new File(parent, child);
        try {
            tilteImage.transferTo(dest);
        } catch (IllegalStateException e) {
            throw new FileStateException(
                    "上传文件失败！文件状态有误，请重新尝试！");
        } catch (IOException e) {
            throw new FileUploadIOException(
                    "上传文件失败！发生读写错误，请重新尝试！");
        }

        String txtPath = filename+".txt";
        BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(essay.getBytes("UTF-8"))));
        FileOutputStream out = new FileOutputStream("D:/IdeaProject/zhnews/src/main/resources/static/webapps/essay/"+txtPath);
        PrintWriter pw = new PrintWriter(out,true);
        String line;
        while ((line = reader.readLine())!=null){
            pw.println(line +"</br>");
            pw.flush();
        }
        pw.close();
        reader.close();
        // 将文件的路径记录到数据库
        String avatarPath = "/webapps/upload/" + child;
        Map<String,Object> map = new HashMap<>();
        map.put("title",title);
        map.put("content",content);
        map.put("tilteImage",avatarPath);
        map.put("tid",tid);
        map.put("essay", "/webapps/essay/" +txtPath);
        newsService.insertTitle(map);
        // 响应结果
        return new JsonResult("ok");
    }

    @RequestMapping("findAllObject")
    public JsonResult findAllObject(){
        List<IndexObject> indexObjects = newsService.selectAll();
        return new JsonResult(indexObjects);
    }

}
