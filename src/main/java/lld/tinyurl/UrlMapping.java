package lld.tinyurl;

import java.time.LocalDateTime;

public class UrlMapping {
    private String longUrl;
    private String shortUrl;
    private User createdBy;
    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;
}
