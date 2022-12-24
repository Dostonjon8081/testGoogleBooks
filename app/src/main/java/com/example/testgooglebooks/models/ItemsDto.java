package com.example.testgooglebooks.models;

public class ItemsDto {
    private String kind;
    private String id;
    private String etag;
    private String selfLink;
    private VolumeInfoDto volumeInfo;


    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getSelfLink() {
        return selfLink;
    }

    public void setSelfLink(String selfLink) {
        this.selfLink = selfLink;
    }

    public VolumeInfoDto getVolumeInfo() {
        return volumeInfo;
    }

    public void setVolumeInfo(VolumeInfoDto volumeInfo) {
        this.volumeInfo = volumeInfo;
    }

    public ItemsDto(String kind, String id, String etag, String selfLink, VolumeInfoDto volumeInfo) {
        this.kind = kind;
        this.id = id;
        this.etag = etag;
        this.selfLink = selfLink;
        this.volumeInfo = volumeInfo;
    }

    @Override
    public String toString() {
        return "ItemsDto{" +
                "kind='" + kind + '\'' +
                ", id='" + id + '\'' +
                ", etag='" + etag + '\'' +
                ", selfLink='" + selfLink + '\'' +
                ", volumeInfo=" + volumeInfo +
                '}';
    }
}
