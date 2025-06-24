package com.kh.SpringBootFileUpload.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kh.SpringBootFileUpload.domain.Item;
import com.kh.SpringBootFileUpload.service.ItemMapperService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@MapperScan(basePackages = "com.kh.SpringBootFileUpload.mapper")
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemMapperService itemService;

    // 저장 경로 설정
    @Value("${upload.path}")
    private String uploadPath;

    // 자료 리스트 화면
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) throws Exception {
        List<Item> itemList = itemService.list();
        model.addAttribute("itemList", itemList);
        return "item/list";
    }

    // 자료 입력 화면
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerForm(Model model) {
        model.addAttribute("item", new Item());
        return "item/register";
    }

    // 자료 입력 내용 저장(파일을 외부저장소에 저장 후, DB에 정보 저장)
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(Item item, Model model) throws Exception {
        MultipartFile file = item.getPicture();
        log.info("originalName: " + file.getOriginalFilename());
        log.info("size: " + file.getSize());
        log.info("contentType: " + file.getContentType());
        // uploadFile(String originalName, byte[] fileData) 구조임
        // 업로드된 파일을 외부저장소에 저장하고, 저장된 파일명을 리턴하는 함수
        // 중복되지 않는 파일명을 붙여 저장소에 저장
        String createdFileName = uploadFile(file.getOriginalFilename(), file.getBytes());

        item.setPictureUrl(createdFileName);
        this.itemService.create(item);
        model.addAttribute("msg", "등록이 완료되었습니다.");
        return "item/success";
    }

    // 외부저장소에 파일명 지정하여 파일 저장
    private String uploadFile(String originalName, byte[] fileData) throws Exception {
        UUID uid = UUID.randomUUID();
        String createdFileName = uid.toString() + "_" + originalName;
        File target = new File(uploadPath, createdFileName);
        // 원본파일을 대상파일에 복사해주는 함수
        FileCopyUtils.copy(fileData, target);
        return createdFileName;
    }

    // 수정화면 내용 요청
    @RequestMapping(value = "/modify", method = RequestMethod.GET)
    public String modifyForm(Item item, Model model) throws Exception {
        Item _item = itemService.read(item);
        model.addAttribute("item",_item);
        return "item/modify";
    }

    // 수정 내용 저장 요청
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public String modify(Item item, Model model) throws Exception {
        MultipartFile file = item.getPicture();

        if (file != null && file.getSize() > 0) {
            // 외부저장소의 기존 파일을 삭제
            Item oldItem = itemService.read(item);
            String oldPictureUrl = oldItem.getPictureUrl();
            deleteFile(oldPictureUrl);

            log.info("originalName: " + file.getOriginalFilename());
            log.info("size: " + file.getSize());
            log.info("contentType: " + file.getContentType());
            String createdFileName = uploadFile(file.getOriginalFilename(), file.getBytes());
            item.setPictureUrl(createdFileName);
        }
        itemService.update(item);
        model.addAttribute("msg", "수정이 완료되었습니다.");
        return "item/success";
    }

    // 삭제화면 요청
    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public String removeForm(Item item, Model model) throws Exception {
        Item _item = itemService.read(item);
        model.addAttribute("item", _item);
        return "item/remove";
    }

    // 삭제 내용 처리
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String remove(Item item, Model model) throws Exception {
        // 외부저장소의 기존 파일을 삭제
        Item oldItem = itemService.read(item);
        String oldPictureUrl = oldItem.getPictureUrl();
        boolean flag = deleteFile(oldPictureUrl);
        if(flag == true){
            itemService.delete(item);
            model.addAttribute("msg", "삭제가 완료되었습니다.");
        }else{
            model.addAttribute("msg", "외부저장소 삭제 작업이 실패하였습니다.");
        }
        return "item/success";
    }

    // 외부저장소에 파일명 지정하여 파일 저장
    // d://upload/../window/system.ini -> 디렉토리 탈출공격
    private boolean deleteFile(String fileName) throws Exception {
        if(fileName.contains("..")){
            throw new IllegalArgumentException("잘못된 경로 입니다.");
        }

        // D:/springBootUploadFile/uuid_file.jpg => 파일로 인식되는 개체
        File file = new File(uploadPath, fileName);
        
        return (file.exists() == true)?(file.delete()):(false);
    }
    

    @ResponseBody
    @RequestMapping("/display")
    public ResponseEntity<byte[]> displayFile(Item item) throws Exception {
        InputStream in = null;
        ResponseEntity<byte[]> entity = null;

        Item _item = itemService.getPicture(item);
        String fileName = _item.getPictureUrl();
        log.info("FILE NAME: " + fileName);
        try {
            // uuid_file.jpg => "jpg"
            String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
            MediaType mType = getMediaType(formatName);
            // httpHeader 미디어 타입을 설정
            HttpHeaders headers = new HttpHeaders();
            // File.separator : OS마다 다른 경로 구분자 자동 지정
            in = new FileInputStream(uploadPath + File.separator + fileName);
            if (mType != null) {
                headers.setContentType(mType);
            }

            entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
        } finally {
            in.close();
        }
        return entity;
    }

    // 멀티미디어 타입 리턴 "jpg" => MediaType.IMAGE_JPEG
    private MediaType getMediaType(String formatName){ 
        if(formatName != null) {
            if(formatName.equals("JPG")) { 
                return MediaType.IMAGE_JPEG;
            }
            if(formatName.equals("GIF")) { 
                return MediaType.IMAGE_GIF;
            }
            if(formatName.equals("PNG")) { 
                return MediaType.IMAGE_PNG;
            }
        }
        return null;
    }
}
