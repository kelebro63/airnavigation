package com.example.airnavigate.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Bistrov Alexey on 01.02.2016.
 */
public class Voting {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("subject")
    @Expose
    private String subject;
    @SerializedName("voteDate")
    @Expose
    private String voteDate;
    @SerializedName("voteCount")
    @Expose
    private Integer voteCount;
    @SerializedName("forCount")
    @Expose
    private Integer forCount;
    @SerializedName("againstCount")
    @Expose
    private Integer againstCount;
    @SerializedName("abstainCount")
    @Expose
    private Integer abstainCount;
    @SerializedName("absentCount")
    @Expose
    private Integer absentCount;
    @SerializedName("resultType")
    @Expose
    private String resultType;
    @SerializedName("result")
    @Expose
    private Boolean result;

    /**
     *
     * @return
     * The id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     *
     * @param subject
     * The subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     *
     * @return
     * The voteDate
     */
    public String getVoteDate() {
        return voteDate;
    }

    /**
     *
     * @param voteDate
     * The voteDate
     */
    public void setVoteDate(String voteDate) {
        this.voteDate = voteDate;
    }

    /**
     *
     * @return
     * The voteCount
     */
    public Integer getVoteCount() {
        return voteCount;
    }

    /**
     *
     * @param voteCount
     * The voteCount
     */
    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    /**
     *
     * @return
     * The forCount
     */
    public Integer getForCount() {
        return forCount;
    }

    /**
     *
     * @param forCount
     * The forCount
     */
    public void setForCount(Integer forCount) {
        this.forCount = forCount;
    }

    /**
     *
     * @return
     * The againstCount
     */
    public Integer getAgainstCount() {
        return againstCount;
    }

    /**
     *
     * @param againstCount
     * The againstCount
     */
    public void setAgainstCount(Integer againstCount) {
        this.againstCount = againstCount;
    }

    /**
     *
     * @return
     * The abstainCount
     */
    public Integer getAbstainCount() {
        return abstainCount;
    }

    /**
     *
     * @param abstainCount
     * The abstainCount
     */
    public void setAbstainCount(Integer abstainCount) {
        this.abstainCount = abstainCount;
    }

    /**
     *
     * @return
     * The absentCount
     */
    public Integer getAbsentCount() {
        return absentCount;
    }

    /**
     *
     * @param absentCount
     * The absentCount
     */
    public void setAbsentCount(Integer absentCount) {
        this.absentCount = absentCount;
    }

    /**
     *
     * @return
     * The resultType
     */
    public String getResultType() {
        return resultType;
    }

    /**
     *
     * @param resultType
     * The resultType
     */
    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    /**
     *
     * @return
     * The result
     */
    public Boolean getResult() {
        return result;
    }

    /**
     *
     * @param result
     * The result
     */
    public void setResult(Boolean result) {
        this.result = result;
    }

}
