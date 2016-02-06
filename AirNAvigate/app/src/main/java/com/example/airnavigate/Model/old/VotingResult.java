package com.example.airnavigate.Model.old;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bistrov Alexey on 01.02.2016.
 */
public class VotingResult {
    @SerializedName("totalCount")
    @Expose
    private String totalCount;
    @SerializedName("page")
    @Expose
    private String page;
    @SerializedName("pageSize")
    @Expose
    private String pageSize;
    @SerializedName("wording")
    @Expose
    private String wording;
    @SerializedName("votes")
    @Expose
    private List<Voting> votes = new ArrayList<Voting>();

    /**
     *
     * @return
     * The totalCount
     */
    public String getTotalCount() {
        return totalCount;
    }

    /**
     *
     * @param totalCount
     * The totalCount
     */
    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

    /**
     *
     * @return
     * The page
     */
    public String getPage() {
        return page;
    }

    /**
     *
     * @param page
     * The page
     */
    public void setPage(String page) {
        this.page = page;
    }

    /**
     *
     * @return
     * The pageSize
     */
    public String getPageSize() {
        return pageSize;
    }

    /**
     *
     * @param pageSize
     * The pageSize
     */
    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    /**
     *
     * @return
     * The wording
     */
    public String getWording() {
        return wording;
    }

    /**
     *
     * @param wording
     * The wording
     */
    public void setWording(String wording) {
        this.wording = wording;
    }

    /**
     *
     * @return
     * The votes
     */
    public List<Voting> getVotes() {
        return votes;
    }

    /**
     *
     * @param votes
     * The votes
     */
    public void setVotes(List<Voting> votes) {
        this.votes = votes;
    }

}
