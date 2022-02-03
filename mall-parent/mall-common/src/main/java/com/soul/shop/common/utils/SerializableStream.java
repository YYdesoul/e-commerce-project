package com.soul.shop.common.utils;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.InputStream;

/**
 * 序列化的input stream
 */
@Data
@NoArgsConstructor
public class SerializableStream {
    private String base64;

    public SerializableStream(InputStream inputStream) {
        this.base64 = Base64DecodeMultipartFile.inputStreamToStream(inputStream);
    }

}
 
