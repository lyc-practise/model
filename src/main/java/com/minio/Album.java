package com.minio;

public class Album {
    private String fileName;
    private String bucketName;
    private String url;
    private String description;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("{[album]==>fileName:").append(fileName)
                .append(",bucket:").append(bucketName)
                .append(",url").append(url)
                .append(",description:").append(description).append("}");
        return builder.toString();
    }
}