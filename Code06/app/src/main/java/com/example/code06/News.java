package com.example.code06;

public class News {
    private String mTitle;
    private String mAuthor;
    private String mContent;
    private int mImageId;

    public String getTitle() {
        return getmTitle();
    }

    public void setTitle(String title) {
        this.setmTitle(title);
    }


    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String mAuthor) {
        this.mAuthor = mAuthor;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String mContent) {
        this.mContent = mContent;
    }

    public int getImageId() {
        return mImageId;
    }

    public void setImageId(int mImageId) {
        this.mImageId = mImageId;
    }
}
