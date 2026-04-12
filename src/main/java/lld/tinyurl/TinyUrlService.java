package lld.tinyurl;

import java.util.HashMap;
import java.util.Map;

public class TinyUrlService {

    //shortCode -> UrlMapping (for fast redirection)
    private final Map<String, UrlMapping> shortToMapping = new HashMap<>();

    //longUrl -> shortCode (for idempotency - same URL always gives same short code)
    private final Map<String, String> longToShort = new HashMap<>();

    private long counter = 1000000000L;   // Starting counter to avoid very short codes initially
    private static final int CODE_LENGTH = 6;
    private static final String BASE62_CHARS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int DEFAULT_EXPIRY_DAYS = 365;

    //Methods
    public String shortenUrl(String longUrl){
        if (longUrl == null || longUrl.trim().isEmpty()) {
            throw new IllegalArgumentException("Long URL cannot be empty");
        }

        //Idempotency: Return existing short code if URL already exists
        if (longToShort.containsKey(longUrl)) {
            return longToShort.get(longUrl);
        }

        //Generate short code
        String shortCode = generateBase62Code();

        //Collision handling - very rare
        while (shortToMapping.containsKey(shortCode)) {
            shortCode = generateBase62Code();
        }

        UrlMapping mapping = new UrlMapping(longUrl, shortCode, DEFAULT_EXPIRY_DAYS);

        shortToMapping.put(shortCode, mapping);
        longToShort.put(longUrl, shortCode);

        System.out.println("✅ Short URL created: tiny.url/" + shortCode);
        return shortCode;

    }

    public String redirect(String shortCode) {
        UrlMapping mapping = shortToMapping.get(shortCode);

        if (mapping == null) {
            throw new IllegalArgumentException("Short URL not found");
        }

        if (mapping.isExpired()) {
            throw new IllegalArgumentException("This short URL has expired");
        }

        mapping.incrementClick();
        System.out.println("🔄 Redirecting tiny.url/" + shortCode + " → " + mapping.getLongUrl()
                + " | Clicks: " + mapping.getClickCount());

        return mapping.getLongUrl();
    }

    public void showAnalytics(String shortCode) {
        UrlMapping mapping = shortToMapping.get(shortCode);
        if (mapping == null) {
            System.out.println("Short URL not found");
            return;
        }
        System.out.println("Analytics for the shortCode "+shortCode);
        System.out.println("shortCode URL tiny.url/" + shortCode);
        System.out.println("Original URL : " + mapping.getLongUrl());
        System.out.println("Created At   : " + mapping.getCreatedAt());
        System.out.println("Expires At   : " + mapping.getExpiresAt());
        System.out.println("Total Clicks : " + mapping.getClickCount());
    }

    public String shortenWithCustomAlias(String longUrl, String customAlias) {
        if (shortToMapping.containsKey(customAlias)) {
            throw new IllegalArgumentException("Custom alias '" + customAlias + "' already taken");
        }

        UrlMapping mapping = new UrlMapping(longUrl, customAlias, DEFAULT_EXPIRY_DAYS);
        shortToMapping.put(customAlias, mapping);
        longToShort.put(longUrl, customAlias);

        System.out.println("✅ Custom short URL created: tiny.url/" + customAlias);
        return customAlias;
    }

    //Helper method - BASE62 GENERATION
    private String generateBase62Code() {
        long num = counter++;
        StringBuilder sb = new StringBuilder();

        while (num > 0) {
            sb.append(BASE62_CHARS.charAt((int) (num % 62)));
            num /= 62;
        }

        // Pad to minimum length if needed
        while (sb.length() < CODE_LENGTH) {
            sb.append('0');
        }

        return sb.reverse().toString();
    }

}
