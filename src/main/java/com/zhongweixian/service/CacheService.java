package com.zhongweixian.service;

import com.zhongweixian.domain.BaseUserCache;
import com.zhongweixian.domain.request.component.BaseRequest;
import com.zhongweixian.domain.shared.Contact;
import com.zhongweixian.domain.shared.Owner;
import com.zhongweixian.domain.shared.SyncCheckKey;
import com.zhongweixian.domain.shared.SyncKey;
import com.zhongweixian.utils.DeviceIdGenerator;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Component
public class CacheService {

    private Map<String, BaseUserCache> wxUserCache = new HashMap<>();

    public BaseUserCache getUserCache(String uid) {
        return wxUserCache.get(uid);
    }

    public void cacheUser(BaseUserCache baseUserCache) {
        wxUserCache.put(baseUserCache.getUin(), baseUserCache);
    }

    public void deleteCacheUser(String uid){
        wxUserCache.remove(uid);
    }



    public void reset() {
        this.hostUrl = null;
        this.syncUrl = null;
        this.fileUrl = null;
        this.passTicket = null;
        this.baseRequest = null;
        this.owner = null;
        this.syncCheckKey = null;
        this.syncKey = null;
        this.sKey = null;
        this.uuid = null;
        this.uin = null;
        this.sid = null;
        this.individuals.clear();
        this.mediaPlatforms.clear();
        this.chatRooms.clear();
    }

    private String uuid;
    private String hostUrl;
    private String syncUrl;
    private String fileUrl;
    private String passTicket;
    private BaseRequest baseRequest;
    private Owner owner;
    private SyncKey syncKey;
    private SyncCheckKey syncCheckKey;
    private String sKey;
    private String uin;
    private String sid;

    private Set<Contact> individuals = new HashSet<>();
    private Set<Contact> mediaPlatforms = new HashSet<>();
    private Set<Contact> chatRooms = new HashSet<>();

    private Set<String> contactNamesWithUnreadMessage = new HashSet<>();


    public String getHostUrl() {
        return hostUrl;
    }

    public void setHostUrl(String hostUrl) {
        this.hostUrl = hostUrl;
    }

    public String getPassTicket() {
        return passTicket;
    }

    public void setPassTicket(String passTicket) {
        this.passTicket = passTicket;
    }

    public BaseRequest getBaseRequest() {
        baseRequest.setDeviceID(DeviceIdGenerator.generate());
        return baseRequest;
    }

    public void setBaseRequest(BaseRequest baseRequest) {
        this.baseRequest = baseRequest;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public SyncKey getSyncKey() {
        return syncKey;
    }

    public void setSyncKey(SyncKey syncKey) {
        this.syncKey = syncKey;
    }

    public SyncCheckKey getSyncCheckKey() {
        return syncCheckKey;
    }

    public void setSyncCheckKey(SyncCheckKey syncCheckKey) {
        this.syncCheckKey = syncCheckKey;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getsKey() {
        return sKey;
    }

    public void setsKey(String sKey) {
        this.sKey = sKey;
    }

    public String getUin() {
        return uin;
    }

    public void setUin(String uin) {
        this.uin = uin;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public Set<Contact> getIndividuals() {
        return individuals;
    }

    public Set<Contact> getMediaPlatforms() {
        return mediaPlatforms;
    }

    public Set<Contact> getChatRooms() {
        return chatRooms;
    }

    public String getSyncUrl() {
        return syncUrl;
    }

    public void setSyncUrl(String syncUrl) {
        this.syncUrl = syncUrl;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public Set<String> getContactNamesWithUnreadMessage() {
        return contactNamesWithUnreadMessage;
    }
}