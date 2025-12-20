package com.demoqa.tests.interactions;

import com.demoqa.pages.interactions.InteractionsPage;
import com.demoqa.tests.base.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("Interactions")
@Feature("Sortable")
public class InteractionsTest extends BaseTest {

    private InteractionsPage interactionsPage;

    @BeforeMethod
    public void methodSetup() {
        interactionsPage = new InteractionsPage(page);
    }

    @Test
    public void verifySortableGrid() {
        interactionsPage.navigateToSortable();
        interactionsPage.selectGrid();
        // Add more assertions or DnD actions
    }
}
