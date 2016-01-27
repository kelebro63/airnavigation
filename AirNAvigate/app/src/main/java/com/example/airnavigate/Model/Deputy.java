package com.example.airnavigate.Model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kelebro63 on 04.01.2016.
 */
public class Deputy {

    private String id;
    private String family;
    private String name;
    private String patronymic;
    private String birthdate;
    private String credentialsStart;
    private Object credentialsEnd;
    private String factionId;
    private String factionName;
    private String factionRole;
    private String partyNameInstr;
    private String isActual;
    private Object homePage;
    private String factionRegion;
    private String nameGenitive;
    private Integer lawcount;
    private List<Object> regions = new ArrayList<Object>();
    private String familyAndInitials;
    private Integer speachCount;
    private String voteLink;
    private String transcriptLink;
    private List<Education> educations = new ArrayList<Education>();
    private List<Object> degrees = new ArrayList<Object>();
    private List<Object> ranks = new ArrayList<Object>();
    private List<Activity> activity = new ArrayList<Activity>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The family
     */
    public String getFamily() {
        return family;
    }

    /**
     *
     * @param family
     * The family
     */
    public void setFamily(String family) {
        this.family = family;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The patronymic
     */
    public String getPatronymic() {
        return patronymic;
    }

    /**
     *
     * @param patronymic
     * The patronymic
     */
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    /**
     *
     * @return
     * The birthdate
     */
    public String getBirthdate() {
        return birthdate;
    }

    /**
     *
     * @param birthdate
     * The birthdate
     */
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    /**
     *
     * @return
     * The credentialsStart
     */
    public String getCredentialsStart() {
        return credentialsStart;
    }

    /**
     *
     * @param credentialsStart
     * The credentialsStart
     */
    public void setCredentialsStart(String credentialsStart) {
        this.credentialsStart = credentialsStart;
    }

    /**
     *
     * @return
     * The credentialsEnd
     */
    public Object getCredentialsEnd() {
        return credentialsEnd;
    }

    /**
     *
     * @param credentialsEnd
     * The credentialsEnd
     */
    public void setCredentialsEnd(Object credentialsEnd) {
        this.credentialsEnd = credentialsEnd;
    }

    /**
     *
     * @return
     * The factionId
     */
    public String getFactionId() {
        return factionId;
    }

    /**
     *
     * @param factionId
     * The factionId
     */
    public void setFactionId(String factionId) {
        this.factionId = factionId;
    }

    /**
     *
     * @return
     * The factionName
     */
    public String getFactionName() {
        return factionName;
    }

    /**
     *
     * @param factionName
     * The factionName
     */
    public void setFactionName(String factionName) {
        this.factionName = factionName;
    }

    /**
     *
     * @return
     * The factionRole
     */
    public String getFactionRole() {
        return factionRole;
    }

    /**
     *
     * @param factionRole
     * The factionRole
     */
    public void setFactionRole(String factionRole) {
        this.factionRole = factionRole;
    }

    /**
     *
     * @return
     * The partyNameInstr
     */
    public String getPartyNameInstr() {
        return partyNameInstr;
    }

    /**
     *
     * @param partyNameInstr
     * The partyNameInstr
     */
    public void setPartyNameInstr(String partyNameInstr) {
        this.partyNameInstr = partyNameInstr;
    }

    /**
     *
     * @return
     * The isActual
     */
    public String getIsActual() {
        return isActual;
    }

    /**
     *
     * @param isActual
     * The isActual
     */
    public void setIsActual(String isActual) {
        this.isActual = isActual;
    }

    /**
     *
     * @return
     * The homePage
     */
    public Object getHomePage() {
        return homePage;
    }

    /**
     *
     * @param homePage
     * The homePage
     */
    public void setHomePage(Object homePage) {
        this.homePage = homePage;
    }

    /**
     *
     * @return
     * The factionRegion
     */
    public String getFactionRegion() {
        return factionRegion;
    }

    /**
     *
     * @param factionRegion
     * The factionRegion
     */
    public void setFactionRegion(String factionRegion) {
        this.factionRegion = factionRegion;
    }

    /**
     *
     * @return
     * The nameGenitive
     */
    public String getNameGenitive() {
        return nameGenitive;
    }

    /**
     *
     * @param nameGenitive
     * The nameGenitive
     */
    public void setNameGenitive(String nameGenitive) {
        this.nameGenitive = nameGenitive;
    }

    /**
     *
     * @return
     * The lawcount
     */
    public Integer getLawcount() {
        return lawcount;
    }

    /**
     *
     * @param lawcount
     * The lawcount
     */
    public void setLawcount(Integer lawcount) {
        this.lawcount = lawcount;
    }

    /**
     *
     * @return
     * The regions
     */
    public List<Object> getRegions() {
        return regions;
    }

    /**
     *
     * @param regions
     * The regions
     */
    public void setRegions(List<Object> regions) {
        this.regions = regions;
    }

    /**
     *
     * @return
     * The familyAndInitials
     */
    public String getFamilyAndInitials() {
        return familyAndInitials;
    }

    /**
     *
     * @param familyAndInitials
     * The familyAndInitials
     */
    public void setFamilyAndInitials(String familyAndInitials) {
        this.familyAndInitials = familyAndInitials;
    }

    /**
     *
     * @return
     * The speachCount
     */
    public Integer getSpeachCount() {
        return speachCount;
    }

    /**
     *
     * @param speachCount
     * The speachCount
     */
    public void setSpeachCount(Integer speachCount) {
        this.speachCount = speachCount;
    }

    /**
     *
     * @return
     * The voteLink
     */
    public String getVoteLink() {
        return voteLink;
    }

    /**
     *
     * @param voteLink
     * The voteLink
     */
    public void setVoteLink(String voteLink) {
        this.voteLink = voteLink;
    }

    /**
     *
     * @return
     * The transcriptLink
     */
    public String getTranscriptLink() {
        return transcriptLink;
    }

    /**
     *
     * @param transcriptLink
     * The transcriptLink
     */
    public void setTranscriptLink(String transcriptLink) {
        this.transcriptLink = transcriptLink;
    }

    /**
     *
     * @return
     * The educations
     */
    public List<Education> getEducations() {
        return educations;
    }

    /**
     *
     * @param educations
     * The educations
     */
    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }

    /**
     *
     * @return
     * The degrees
     */
    public List<Object> getDegrees() {
        return degrees;
    }

    /**
     *
     * @param degrees
     * The degrees
     */
    public void setDegrees(List<Object> degrees) {
        this.degrees = degrees;
    }

    /**
     *
     * @return
     * The ranks
     */
    public List<Object> getRanks() {
        return ranks;
    }

    /**
     *
     * @param ranks
     * The ranks
     */
    public void setRanks(List<Object> ranks) {
        this.ranks = ranks;
    }

    /**
     *
     * @return
     * The activity
     */
    public List<Activity> getActivity() {
        return activity;
    }

    /**
     *
     * @param activity
     * The activity
     */
    public void setActivity(List<Activity> activity) {
        this.activity = activity;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}