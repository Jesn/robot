package com.zhongweixian.utils;

import com.zhongweixian.domain.shared.Contact;
import com.zhongweixian.domain.response.component.WechatHttpResponseBase;
import com.zhongweixian.exception.RobotException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;

public class WechatUtils {
    private static Logger logger = LoggerFactory.getLogger(WechatUtils.class);

    public static void checkBaseResponse(WechatHttpResponseBase response) {
        if (response.getBaseResponse().getRet() != 0) {
            logger.error("ret:{} , errorMsg:{}", response.getBaseResponse().getRet(), response.getBaseResponse().getErrMsg());
            throw new RobotException(response.getClass().getSimpleName() + " ret = " + response.getBaseResponse().getRet());
        }
    }

    public static String textDecode(String text) {
        if (text == null) {
            throw new IllegalArgumentException("text");
        }
        return new String(text.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
    }

    public static boolean isIndividual(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("contact");
        }
        return contact.getUserName().startsWith("@") && !contact.getUserName().startsWith("@@") && ((contact.getVerifyFlag() & 8) == 0);
    }

    public static boolean isChatRoom(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("contact");
        }
        return contact.getUserName().startsWith("@@");
    }

    public static boolean isMediaPlatform(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("contact");
        }
        return contact.getUserName().startsWith("@") && !contact.getUserName().startsWith("@@") && ((contact.getVerifyFlag() & 8) > 0);
    }
}
