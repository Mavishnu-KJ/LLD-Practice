package lld.tinyurl;

import java.time.LocalDateTime;

public class UrlMapping {
    private final String longUrl;
    private final String shortCode; //shortUrl
    private final LocalDateTime createdAt;
    private final LocalDateTime expiresAt;
    private int clickCount;

    //Constructor
    public UrlMapping(String longUrl, String shortCode, int expiryDays) {
        this.longUrl = longUrl;
        this.shortCode = shortCode;
        this.createdAt = LocalDateTime.now();
        this.expiresAt = createdAt.plusDays(expiryDays);
        this.clickCount = 0;
    }

    //Getter methods
    public String getLongUrl() {
        return longUrl;
    }

    public String getShortCode() {
        return shortCode;
    }

    public int getClickCount() {
        return clickCount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    //Methods
    public boolean isExpired() {
        return LocalDateTime.now().isAfter(expiresAt);
    }

    public void incrementClick() {
        this.clickCount++;
    }

}
