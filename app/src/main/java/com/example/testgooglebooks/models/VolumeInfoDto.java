package com.example.testgooglebooks.models;

import java.util.ArrayList;
import java.util.List;

public class VolumeInfoDto {
    private String title;
    private String subtitle;
    private ArrayList<String> authors;
    private String publisher;
    private String publishedDate;
    private String description;
    private List<IndustryIdentifierDto> industryIdentifiers;
    private List<ReadingModeDto> readingModesDto;
    private String printType;
    private List<String> categories;
    private int averageRating;
    private int ratingsCount;
    private String maturityRating;
    private Boolean allowAnonLogging;
    private String contentVersion;
    private PanelizationSummaryDto panelizationSummaryDto;
    private ImageLinksDto imageLinks;
    private String language;
    private String previewLink;
    private String infoLink;
    private String canonicalVolumeLink;


    @Override
    public String toString() {
        return "VolumeInfoDto{" +
                "title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", authors=" + authors +
                ", publisher='" + publisher + '\'' +
                ", publishedDate='" + publishedDate + '\'' +
                ", description='" + description + '\'' +
                ", industryIdentifiers=" + industryIdentifiers +
                ", readingModesDto=" + readingModesDto +
                ", printType='" + printType + '\'' +
                ", categories=" + categories +
                ", averageRating=" + averageRating +
                ", ratingsCount=" + ratingsCount +
                ", maturityRating='" + maturityRating + '\'' +
                ", allowAnonLogging=" + allowAnonLogging +
                ", contentVersion='" + contentVersion + '\'' +
                ", panelizationSummaryDto=" + panelizationSummaryDto +
                ", imageLinks=" + imageLinks +
                ", language='" + language + '\'' +
                ", previewLink='" + previewLink + '\'' +
                ", infoLink='" + infoLink + '\'' +
                ", canonicalVolumeLink='" + canonicalVolumeLink + '\'' +
                '}';
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<IndustryIdentifierDto> getIndustryIdentifiers() {
        return industryIdentifiers;
    }

    public void setIndustryIdentifiers(List<IndustryIdentifierDto> industryIdentifiers) {
        this.industryIdentifiers = industryIdentifiers;
    }

    public List<ReadingModeDto> getReadingModesDto() {
        return readingModesDto;
    }

    public void setReadingModesDto(List<ReadingModeDto> readingModesDto) {
        this.readingModesDto = readingModesDto;
    }

    public String getPrintType() {
        return printType;
    }

    public void setPrintType(String printType) {
        this.printType = printType;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public int getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(int averageRating) {
        this.averageRating = averageRating;
    }

    public int getRatingsCount() {
        return ratingsCount;
    }

    public void setRatingsCount(int ratingsCount) {
        this.ratingsCount = ratingsCount;
    }

    public String getMaturityRating() {
        return maturityRating;
    }

    public void setMaturityRating(String maturityRating) {
        this.maturityRating = maturityRating;
    }

    public Boolean getAllowAnonLogging() {
        return allowAnonLogging;
    }

    public void setAllowAnonLogging(Boolean allowAnonLogging) {
        this.allowAnonLogging = allowAnonLogging;
    }

    public String getContentVersion() {
        return contentVersion;
    }

    public void setContentVersion(String contentVersion) {
        this.contentVersion = contentVersion;
    }

    public PanelizationSummaryDto getPanelizationSummaryDto() {
        return panelizationSummaryDto;
    }

    public void setPanelizationSummaryDto(PanelizationSummaryDto panelizationSummaryDto) {
        this.panelizationSummaryDto = panelizationSummaryDto;
    }

    public ImageLinksDto getImageLinks() {
        return imageLinks;
    }

    public void setImageLinks(ImageLinksDto imageLinks) {
        this.imageLinks = imageLinks;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPreviewLink() {
        return previewLink;
    }

    public void setPreviewLink(String previewLink) {
        this.previewLink = previewLink;
    }

    public String getInfoLink() {
        return infoLink;
    }

    public void setInfoLink(String infoLink) {
        this.infoLink = infoLink;
    }

    public String getCanonicalVolumeLink() {
        return canonicalVolumeLink;
    }

    public void setCanonicalVolumeLink(String canonicalVolumeLink) {
        this.canonicalVolumeLink = canonicalVolumeLink;
    }

    public VolumeInfoDto(String title,
                         String subtitle,
                         List<String> authors,
                         String publisher,
                         String publishedDate,
                         String description,
                         List<IndustryIdentifierDto> industryIdentifiers,
                         List<ReadingModeDto> readingModesDto,
                         String printType,
                         List<String> categories,
                         int averageRating,
                         int ratingsCount,
                         String maturityRating,
                         Boolean allowAnonLogging,
                         String contentVersion,
                         PanelizationSummaryDto panelizationSummaryDto,
                         ImageLinksDto imageLinks,
                         String language,
                         String previewLink,
                         String infoLink,
                         String canonicalVolumeLink) {
        this.title = title;
        this.subtitle = subtitle;
        this.authors.addAll(authors);
        this.publisher = publisher;
        this.publishedDate = publishedDate;
        this.description = description;
        this.industryIdentifiers = industryIdentifiers;
        this.readingModesDto = readingModesDto;
        this.printType = printType;
        this.categories = categories;
        this.averageRating = averageRating;
        this.ratingsCount = ratingsCount;
        this.maturityRating = maturityRating;
        this.allowAnonLogging = allowAnonLogging;
        this.contentVersion = contentVersion;
        this.panelizationSummaryDto = panelizationSummaryDto;
        this.imageLinks = imageLinks;
        this.language = language;
        this.previewLink = previewLink;
        this.infoLink = infoLink;
        this.canonicalVolumeLink = canonicalVolumeLink;
    }
}