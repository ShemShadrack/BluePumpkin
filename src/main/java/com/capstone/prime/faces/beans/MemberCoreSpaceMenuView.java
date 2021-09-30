package com.capstone.prime.faces.beans;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class MemberCoreSpaceMenuView {

    private String page;

    @PostConstruct
    public void init() {
        page = "./webpages/club_manager/manager_homepage.xhtml"; //  Default include.
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
}
