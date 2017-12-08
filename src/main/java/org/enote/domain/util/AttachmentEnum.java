package org.enote.domain.util;

public enum AttachmentEnum {
    WEB_PAGE(1),
    PHOTO(2),
    AUDIO(3),
    VIDEO(4);

    private int type;

    AttachmentEnum(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
