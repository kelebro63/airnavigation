package com.example.airnavigate.Model;

/**
 * Created by Kelebro63 on 04.01.2016.
 */
public class Deputy {

    private String id;
    private String name;
    private String position;
    private Boolean isCurrent;
    private String credentialsStart;
    private String credentialsEnd;
    private String factionId;
    private String factionName;
    private String factionRole;
    private String partyNameInstr;
    private Boolean isActual;
    private String homePage;
    private String factionRegion;
    private String nameGenitive;
    private int lawcount;
    private String[] regions;
    private String familyAndInitials;
    private int speachCount;
    private String voteLink;
    private String transcriptLink;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsCurrent() {
        return isCurrent;
    }

    public void setIsCurrent(Boolean isCurrent) {
        this.isCurrent = isCurrent;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCredentialsStart() {
        return credentialsStart;
    }

    public void setCredentialsStart(String credentialsStart) {
        this.credentialsStart = credentialsStart;
    }

    public String getCredentialsEnd() {
        return credentialsEnd;
    }

    public void setCredentialsEnd(String credentialsEnd) {
        this.credentialsEnd = credentialsEnd;
    }

    public String getFactionId() {
        return factionId;
    }

    public void setFactionId(String factionId) {
        this.factionId = factionId;
    }

    public String getFactionName() {
        return factionName;
    }

    public void setFactionName(String factionName) {
        this.factionName = factionName;
    }

    public String getFactionRole() {
        return factionRole;
    }

    public void setFactionRole(String factionRole) {
        this.factionRole = factionRole;
    }

    public String getPartyNameInstr() {
        return partyNameInstr;
    }

    public void setPartyNameInstr(String partyNameInstr) {
        this.partyNameInstr = partyNameInstr;
    }

    public Boolean getIsActual() {
        return isActual;
    }

    public void setIsActual(Boolean isActual) {
        this.isActual = isActual;
    }

    public String getHomePage() {
        return homePage;
    }

    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }

    public String getFactionRegion() {
        return factionRegion;
    }

    public void setFactionRegion(String factionRegion) {
        this.factionRegion = factionRegion;
    }

    public String getNameGenitive() {
        return nameGenitive;
    }

    public void setNameGenitive(String nameGenitive) {
        this.nameGenitive = nameGenitive;
    }

    public int getLawcount() {
        return lawcount;
    }

    public void setLawcount(int lawcount) {
        this.lawcount = lawcount;
    }

    public String getFamilyAndInitials() {
        return familyAndInitials;
    }

    public void setFamilyAndInitials(String familyAndInitials) {
        this.familyAndInitials = familyAndInitials;
    }

    public String[] getRegions() {
        return regions;
    }

    public void setRegions(String[] regions) {
        this.regions = regions;
    }

    public int getSpeachCount() {
        return speachCount;
    }

    public void setSpeachCount(int speachCount) {
        this.speachCount = speachCount;
    }

    public String getVoteLink() {
        return voteLink;
    }

    public void setVoteLink(String voteLink) {
        this.voteLink = voteLink;
    }

    public String getTranscriptLink() {
        return transcriptLink;
    }

    public void setTranscriptLink(String transcriptLink) {
        this.transcriptLink = transcriptLink;
    }
}
