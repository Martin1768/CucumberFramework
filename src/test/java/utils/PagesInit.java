package utils;

import pages.AddEmployeePOM;
import pages.DashboardPOM;
import pages.LoginPOM;

public class PagesInit {
    public static LoginPOM loginPage;
    public static AddEmployeePOM addEmployeePage;
    public static DashboardPOM dashboardPage;

    public static void initPageObjects() {
        loginPage = new LoginPOM();
        addEmployeePage = new AddEmployeePOM();
        dashboardPage = new DashboardPOM();
    }

}
