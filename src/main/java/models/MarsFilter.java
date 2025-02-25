package models;

public class MarsFilter {
    private int photoId;
    private String imageUrl;
    private String earthDate;

    public String getImageUrl() {
        return imageUrl != null ? imageUrl.replace("http://", "https://") : imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    public MarsFilter() {
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }


    public String getEarthDate() {
        return earthDate;
    }

    public void setEarthDate(String earthDate) {
        this.earthDate = earthDate;
    }
}
