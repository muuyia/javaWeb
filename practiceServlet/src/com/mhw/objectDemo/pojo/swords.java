package com.mhw.objectDemo.pojo;

import java.util.Date;

public class swords {

    private Integer id;

    private String spell;

    private String noun;

    private String verb;

    private String adjective;

    private String adverb;

    private String int_;

    private String det;

    private String pron;

    private String conj;

    private String prep;

    private String abbr;

    private String classify;

    private StatusWord status;

    private Integer queryCount;

    private Date time;

    public swords() {
    }

    public swords(Integer id, String spell, String noun, String verb, String adjective, String adverb, String int_,String det,String pron,String conj,String prep,String abbr,String classify, StatusWord status, Integer queryCount, Date time) {
        this.id = id;
        this.spell = spell;
        this.noun = noun;
        this.verb = verb;
        this.adjective = adjective;
        this.adverb = adverb;
        this.int_ = int_;
        this.det = det;
        this.pron = pron;
        this.conj = conj;
        this.prep = prep;
        this.abbr = abbr;
        this.classify = classify;
        this.status = status;
        this.queryCount = queryCount;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpell() {
        return spell;
    }

    public void setSpell(String spell) {
        this.spell = spell;
    }

    public String getNoun() {
        return noun;
    }

    public void setNoun(String noun) {
        this.noun = noun;
    }

    public String getVerb() {
        return verb;
    }

    public void setVerb(String verb) {
        this.verb = verb;
    }

    public String getAdjective() {
        return adjective;
    }

    public void setAdjective(String adjective) {
        this.adjective = adjective;
    }

    public String getAdverb() {
        return adverb;
    }

    public void setAdverb(String adverb) {
        this.adverb = adverb;
    }

    public String getInt_() {
        return int_;
    }

    public void setInt_(String int_) {
        this.int_ = int_;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public StatusWord getStatus() {
        return status;
    }

    public void setStatus(StatusWord status) {
        this.status = status;
    }

    public Integer getQueryCount() {
        return queryCount;
    }

    public void setQueryCount(Integer queryCount) {
        this.queryCount = queryCount;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getDet() {
        return det;
    }

    public void setDet(String det) {
        this.det = det;
    }

    public String getPron() {
        return pron;
    }

    public void setPron(String pron) {
        this.pron = pron;
    }

    public String getConj() {
        return conj;
    }

    public void setConj(String conj) {
        this.conj = conj;
    }

    public String getPrep() {
        return prep;
    }

    public void setPrep(String prep) {
        this.prep = prep;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", "+
                "\"spell\":\"" + spell + '\"' +
                ", \"noun\":\"" + noun + '\"' +
                ", \"verb\":\"" + verb + '\"' +
                ", \"adjective\":\"" + adjective + '\"' +
                ", \"adverb\":\"" + adverb + '\"' +
                ", \"int_\":\"" + int_ + '\"' +
                ", \"det\":\"" + det + '\"' +
                ", \"pron\":\"" + pron + '\"' +
                ", \"conj\":\"" + conj + '\"' +
                ", \"prep\":\"" + prep + '\"' +
                ", \"abbr\":\"" + abbr + '\"' +
                ", \"classify\":\"" + classify + '\"' +
                ", \"status\":\"" + status + '\"' +
                ", \"queryCount\":" + queryCount +
                ", \"time\":\"" + time + '\"' +
                '}';
    }
}
