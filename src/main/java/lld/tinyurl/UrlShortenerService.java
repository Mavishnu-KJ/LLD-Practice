package lld.tinyurl;

import java.util.HashMap;
import java.util.Map;

public class UrlShortenerService {
    private HashMap<String, UrlMapping> longToShort;
    private HashMap<String, UrlMapping> shortToLong;

    public String shortenURL(String longUrl){return null;};
    public String redirect(String shortUrl){return null;};
    public UrlMapping getStats(String shortUrl){return null;};

}
