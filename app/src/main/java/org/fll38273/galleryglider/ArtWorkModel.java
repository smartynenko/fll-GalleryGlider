package org.fll38273.galleryglider;

public class ArtWorkModel {
    // string course_name for storing artwork_name
    // and imgid for storing image id.
    private String artwork_name;
    private int img_id;

    private String asset_path;

    public ArtWorkModel(String artwork_name, int imgid) {
        this(artwork_name, imgid, "");
    }

    public ArtWorkModel(String artwork_name, int imgid, String asset_path) {
        this.artwork_name = artwork_name;
        this.img_id = imgid;
        this.asset_path = asset_path;
    }

    public String getArtworkName() {
        return artwork_name;
    }

    public void setArtworkName(String artwork_name) {
        this.artwork_name = artwork_name;
    }

    public int getImgId() {
        return img_id;
    }

    public void setImgId(int img_id) {
        this.img_id = img_id;
    }

    public String getAssetPath() { return asset_path; }
}
