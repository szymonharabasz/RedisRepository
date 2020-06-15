package com.szymonharabasz.RedisRepository.model;

import java.net.URL;

public class WebpageSource {
    private String id;
    private URL url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }
}
