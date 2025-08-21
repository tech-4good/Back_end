package tech4good.cruds.model;

import org.springframework.core.io.ByteArrayResource;

public class FileModel {
    private String name;
    private String contentType;
    private Long size;
    private ByteArrayResource content;

    public FileModel() {
    }

    public FileModel(String name, String contentType, Long size, ByteArrayResource content) {
        this.name = name;
        this.contentType = contentType;
        this.size = size;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public ByteArrayResource getContent() {
        return content;
    }

    public void setContent(ByteArrayResource content) {
        this.content = content;
    }
}
