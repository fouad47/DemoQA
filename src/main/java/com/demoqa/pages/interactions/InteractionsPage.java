package com.demoqa.pages.interactions;

import com.demoqa.pages.base.BasePage;
import com.microsoft.playwright.Page;

public class InteractionsPage extends BasePage {

    public InteractionsPage(Page page) {
        super(page);
    }

    private final String HomeSortableMenu = "//h5[normalize-space()='Interactions']";
    private final String sortableMenu = "//li[@id='item-0']//span[text()='Sortable']";
    private final String listTab = "#demo-tab-list";
    private final String gridTab = "#demo-tab-grid";

    public void navigateToSortable() {
        click(HomeSortableMenu);
        click(sortableMenu);
    }

    public void selectGrid() {
        click(gridTab);
    }
}
