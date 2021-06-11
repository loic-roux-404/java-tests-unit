package com.exam2.View;

import com.exam1.Controller.MusicalEventController;
import com.exam1.Controller.UserController;
import com.framework.SwingModules.FormBuilder;
import com.framework.SwingModules.PageBtn;

import javax.swing.*;
import java.util.HashMap;

/**
 * class Home
 * Form used to store homepage buttons to open other pages
 */
public class Home extends JPanel {
    public FormBuilder form = new FormBuilder(false).disableAllBtn();

    public HashMap<String, PageBtn> pages = new HashMap<>();

    // Pages
    public final static String SERVICES_LIST = "Services_list";
    public final static String SERVICES_ADD = "Services_add";
    public final static String SERVICES_TERMINATE = "Services_terminate";
    public final static String USERS_ADD = "Users_add";
    public final static String USERS_LIST = "Users_list";

    public Home() {
        this.addPageBtn(MusicalEventController.TITLE_ADD, SERVICES_ADD);
        this.addPageBtn(MusicalEventController.TITLE_TERMINATE, SERVICES_TERMINATE);
        this.addPageBtn(MusicalEventController.TITLE_TRACKING, SERVICES_LIST);
        this.addPageBtn(UserController.TITLE_LIST, USERS_LIST);
        this.addPageBtn(UserController.TITLE_ADD, USERS_ADD);

        form.create(this);
    }

    public void registerPage(String name, PageBtn pageBtn) {
        pages.put(name, pageBtn);
    }

    protected void addPageBtn(String name, String id) {
        PageBtn pageBtn = new PageBtn(name);
        pages.put(id, pageBtn);
        form.addField(name, pageBtn.getBtn());
    }

    public PageBtn page(String name) {
        return pages.get(name);
    }
}