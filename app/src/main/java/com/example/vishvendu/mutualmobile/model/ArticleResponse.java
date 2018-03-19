package com.example.vishvendu.mutualmobile.model;

/**
 * Created by Vishvendu on 18-03-2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ArticleResponse {

    @SerializedName("ID")
    @Expose
    private int iD;
    @SerializedName("TITLE")
    @Expose
    private String tITLE;
    @SerializedName("URL")
    @Expose
    private String uRL;
    @SerializedName("PUBLISHER")
    @Expose
    private String pUBLISHER;
    @SerializedName("CATEGORY")
    @Expose
    private String cATEGORY;
    @SerializedName("HOSTNAME")
    @Expose
    private String hOSTNAME;
    @SerializedName("TIMESTAMP")
    @Expose
    private int tIMESTAMP;

    public int getID() {
        return iD;
    }

    public void setID(int iD) {
        this.iD = iD;
    }

    public String getTITLE() {
        return tITLE;
    }

    public void setTITLE(String tITLE) {
        this.tITLE = tITLE;
    }

    public String getURL() {
        return uRL;
    }

    public void setURL(String uRL) {
        this.uRL = uRL;
    }

    public String getPUBLISHER() {
        return pUBLISHER;
    }

    public void setPUBLISHER(String pUBLISHER) {
        this.pUBLISHER = pUBLISHER;
    }

    public String getCATEGORY() {
        return cATEGORY;
    }

    public void setCATEGORY(String cATEGORY) {
        this.cATEGORY = cATEGORY;
    }

    public String getHOSTNAME() {
        return hOSTNAME;
    }

    public void setHOSTNAME(String hOSTNAME) {
        this.hOSTNAME = hOSTNAME;
    }

    public int getTIMESTAMP() {
        return tIMESTAMP;
    }

    public void setTIMESTAMP(int tIMESTAMP) {
        this.tIMESTAMP = tIMESTAMP;
    }

}
