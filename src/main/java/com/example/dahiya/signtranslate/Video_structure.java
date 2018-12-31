package com.example.dahiya.signtranslate;

public class Video_structure {

    private int _id;
    private String word;
    private String url;

    public Video_structure(String word, String url) {
        this.word = word;
        this.url = url;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
