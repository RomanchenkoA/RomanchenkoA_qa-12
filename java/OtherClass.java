import org.testng.annotations.Test;

public class OtherClass extends TestBase{

  @Test
  public void GroupCreationTest() {
    openAddressbook();
    login("admin", "secret");
    goToGroupsPage();
    initGroupCreation();
    fillGroupForm("name", "header", "footer");
    submitGroupCreation();
    returnToGroupsPage();
  }


}

