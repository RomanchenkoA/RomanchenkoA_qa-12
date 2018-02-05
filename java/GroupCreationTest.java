import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {

  @Test
  public void groupCreationTest() {
    goToGroupsPage();
    initGroupCreation();
    fillGroupForm("group", "head", "foo");
    submitGroupCreation();
    returnToGroupsPage();

  }

  @Test
  public void GroupCreationTest1() {

    goToGroupsPage();
    initGroupCreation();
    fillGroupForm("group", "head", "foo");
    submitGroupCreation();
    returnToGroupsPage();

  }

  @Test
  public void GroupCreationEmptyTest() {

    goToGroupsPage();
    initGroupCreation();
    fillGroupForm("", "", "");
    submitGroupCreation();
    returnToGroupsPage();

  }

}
