package com.asemediatech.tiktokdownloader.model;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class VideoModel {
    @SerializedName("aweme_detail")
    @Nullable
    public AwemeDetail awemeDetail;

    public AwemeDetail getAwemeDetail() {
        return awemeDetail;
    }

    public void setAwemeDetail(AwemeDetail awemeDetail) {
        this.awemeDetail = awemeDetail;
    }


    public class AwemeDetail{
        @SerializedName("author")
        public UserProfil userProfil;
        @SerializedName("aweme_id")
        public String videoId;
        @SerializedName("region")
        public String region;
        @SerializedName("video")
        public VideoData videoData;
        @SerializedName("desc")
        public String descVideo;
        @SerializedName("music")
        public MusicData musicData;

        public String getDescVideo() {
            return descVideo;
        }

        public void setDescVideo(String descVideo) {
            this.descVideo = descVideo;
        }

        public UserProfil getUserProfil() {
            return userProfil;
        }

        public void setUserProfil(UserProfil userProfil) {
            this.userProfil = userProfil;
        }

        public String getVideoId() {
            return videoId;
        }

        public void setVideoId(String videoId) {
            this.videoId = videoId;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public VideoData getVideoData() {
            return videoData;
        }

        public void setVideoData(VideoData videoData) {
            this.videoData = videoData;
        }

        public MusicData getMusicData() {
            return musicData;
        }

        public void setMusicData(MusicData musicData) {
            this.musicData = musicData;
        }

        public class VideoData{

            @SerializedName("download_addr")
            public WithWatermark withWatermark;
            @SerializedName("dynamic_cover")
            public DynamicCover dynamicCover;
            @SerializedName("origin_cover")
            public OriginCover originCover;
            @SerializedName("play_addr")
            public NoWatermark NoWatermark;
            @SerializedName("duration")
            public int duration;
            @SerializedName("bit_rate")
            public ArrayList<ListVideoData> listVideoData;


            public WithWatermark getWithWatermark() {
                return withWatermark;
            }

            public void setWithWatermark(WithWatermark withWatermark) {
                this.withWatermark = withWatermark;
            }

            public DynamicCover getDynamicCover() {
                return dynamicCover;
            }

            public void setDynamicCover(DynamicCover dynamicCover) {
                this.dynamicCover = dynamicCover;
            }

            public OriginCover getOriginCover() {
                return originCover;
            }

            public void setOriginCover(OriginCover originCover) {
                this.originCover = originCover;
            }

            public VideoData.NoWatermark getNoWatermark() {
                return NoWatermark;
            }

            public void setNoWatermark(VideoData.NoWatermark noWatermark) {
                NoWatermark = noWatermark;
            }

            public int getDuration() {
                return duration;
            }

            public void setDuration(int duration) {
                this.duration = duration;
            }

            public ArrayList<ListVideoData> getListVideoData() {
                return listVideoData;
            }

            public void setListVideoData(ArrayList<ListVideoData> listVideoData) {
                this.listVideoData = listVideoData;
            }

            public class WithWatermark{
                @SerializedName("data_size")
                public int size;
                @SerializedName("uri")
                public String uriKey;
                @SerializedName("url_list")
                public List urlData;

                public int getSize() {
                    return size;
                }

                public void setSize(int size) {
                    this.size = size;
                }

                public String getUriKey() {
                    return uriKey;
                }

                public void setUriKey(String uriKey) {
                    this.uriKey = uriKey;
                }

                public List getUrlData() {
                    return urlData;
                }

                public void setUrlData(List urlData) {
                    this.urlData = urlData;
                }

                @Override
                public String toString() {
                    return "WithWatermark{" +
                            "size=" + size +
                            ", uriKey='" + uriKey + '\'' +
                            ", urlData=" + urlData +
                            '}';
                }
            }
            public class DynamicCover{
                @SerializedName("uri")
                public String uriKey;
                @SerializedName("url_list")
                public List urlData;

                public String getUriKey() {
                    return uriKey;
                }

                public void setUriKey(String uriKey) {
                    this.uriKey = uriKey;
                }

                public List getUrlData() {
                    return urlData;
                }

                public void setUrlData(List urlData) {
                    this.urlData = urlData;
                }

                @Override
                public String toString() {
                    return "DynamicCover{" +
                            "uriKey='" + uriKey + '\'' +
                            ", urlData=" + urlData +
                            '}';
                }
            }

            public class OriginCover{
                @SerializedName("uri")
                public String uriKey;
                @SerializedName("url_list")
                public List urlData;

                public String getUriKey() {
                    return uriKey;
                }

                public void setUriKey(String uriKey) {
                    this.uriKey = uriKey;
                }

                public List getUrlData() {
                    return urlData;
                }

                public void setUrlData(List urlData) {
                    this.urlData = urlData;
                }

                @Override
                public String toString() {
                    return "OriginCover{" +
                            "uriKey='" + uriKey + '\'' +
                            ", urlData=" + urlData +
                            '}';
                }
            }

            public class NoWatermark{
                @SerializedName("data_size")
                public int size;
                @SerializedName("uri")
                public String uriKeyShort;
                @SerializedName("url_key")
                public String uriKeyFull;
                @SerializedName("url_list")
                public List urlData;

                public int getSize() {
                    return size;
                }

                public void setSize(int size) {
                    this.size = size;
                }

                public String getUriKeyShort() {
                    return uriKeyShort;
                }

                public void setUriKeyShort(String uriKeyShort) {
                    this.uriKeyShort = uriKeyShort;
                }

                public String getUriKeyFull() {
                    return uriKeyFull;
                }

                public void setUriKeyFull(String uriKeyFull) {
                    this.uriKeyFull = uriKeyFull;
                }

                public List getUrlData() {
                    return urlData;
                }

                public void setUrlData(List urlData) {
                    this.urlData = urlData;
                }

                @Override
                public String toString() {
                    return "NoWatermark{" +
                            "size=" + size +
                            ", uriKeyShort='" + uriKeyShort + '\'' +
                            ", uriKeyFull='" + uriKeyFull + '\'' +
                            ", urlData=" + urlData +
                            '}';
                }
            }

            public class ListVideoData{
                @SerializedName("bit_rate")
                public String bitRate;
                @SerializedName("quality_type")
                public String qualityType;
                @SerializedName("play_addr")
                public ListVideo listVideos;

                public String getBitRate() {
                    return bitRate;
                }

                public void setBitRate(String bitRate) {
                    this.bitRate = bitRate;
                }

                public String getQualityType() {
                    return qualityType;
                }

                public void setQualityType(String qualityType) {
                    this.qualityType = qualityType;
                }

                public ListVideo getListVideos() {
                    return listVideos;
                }

                public void setListVideos(ListVideo listVideos) {
                    this.listVideos = listVideos;
                }

                public class ListVideo{
                    @SerializedName("data_size")
                    public int size;
                    @SerializedName("uri")
                    public String uriKeyShort;
                    @SerializedName("url_key")
                    public String uriKeyFull;
                    @SerializedName("url_list")
                    public List urlData;

                    public int getSize() {
                        return size;
                    }

                    public void setSize(int size) {
                        this.size = size;
                    }

                    public String getUriKeyShort() {
                        return uriKeyShort;
                    }

                    public void setUriKeyShort(String uriKeyShort) {
                        this.uriKeyShort = uriKeyShort;
                    }

                    public String getUriKeyFull() {
                        return uriKeyFull;
                    }

                    public void setUriKeyFull(String uriKeyFull) {
                        this.uriKeyFull = uriKeyFull;
                    }

                    public List getUrlData() {
                        return urlData;
                    }

                    public void setUrlData(List urlData) {
                        this.urlData = urlData;
                    }

                    @Override
                    public String toString() {
                        return "ListVideo{" +
                                "size=" + size +
                                ", uriKeyShort='" + uriKeyShort + '\'' +
                                ", uriKeyFull='" + uriKeyFull + '\'' +
                                ", urlData=" + urlData +
                                '}';
                    }
                }

                @Override
                public String toString() {
                    return "ListVideoData{" +
                            "bitRate='" + bitRate + '\'' +
                            ", qualityType='" + qualityType + '\'' +
                            ", listVideos=" + listVideos +
                            '}';
                }
            }

            @Override
            public String toString() {
                return "VideoData{" +
                        "withWatermark=" + withWatermark +
                        ", dynamicCover=" + dynamicCover +
                        ", originCover=" + originCover +
                        ", NoWatermark=" + NoWatermark +
                        ", duration=" + duration +
                        ", listVideoData=" + listVideoData +
                        '}';
            }
        }

        public class MusicData{
            @SerializedName("title")
            public String titleMusic;
            @SerializedName("play_url")
            public ListMusic listMusic;

            public String getTitleMusic() {
                return titleMusic;
            }

            public void setTitleMusic(String titleMusic) {
                this.titleMusic = titleMusic;
            }

            public ListMusic getListMusic() {
                return listMusic;
            }

            public void setListMusic(ListMusic listMusic) {
                this.listMusic = listMusic;
            }

            public class ListMusic{
                @SerializedName("uri")
                public String url;

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }

        public class UserProfil{
            @SerializedName("birthday")
            public String birthday;
            @SerializedName("nickname")
            public String nickname;
            @SerializedName("sec_uid")
            public String secId;
            @SerializedName("uid")
            public String uid;
            @SerializedName("unique_id")
            public String username;
            @SerializedName("avatar_uri")
            public String avatarUri;

            public String getAvatarUri() {
                return avatarUri;
            }

            public void setAvatarUri(String avatarUri) {
                this.avatarUri = avatarUri;
            }

            public String getBirthday() {
                return birthday;
            }

            public void setBirthday(String birthday) {
                this.birthday = birthday;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getSecId() {
                return secId;
            }

            public void setSecId(String secId) {
                this.secId = secId;
            }

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            @Override
            public String toString() {
                return "UserProfil{" +
                        "birthday='" + birthday + '\'' +
                        ", nickname='" + nickname + '\'' +
                        ", secId='" + secId + '\'' +
                        ", uid='" + uid + '\'' +
                        ", username='" + username + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "AwemeDetail{" +
                    "userProfil=" + userProfil +
                    ", videoId='" + videoId + '\'' +
                    ", region='" + region + '\'' +
                    ", videoData=" + videoData +
                    ", descVideo='" + descVideo + '\'' +
                    ", musicData=" + musicData +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "VideoModel{" +
                "awemeDetail=" + awemeDetail +
                '}';
    }
}

