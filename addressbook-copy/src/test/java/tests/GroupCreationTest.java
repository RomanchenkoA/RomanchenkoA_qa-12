package tests;

import model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GroupCreationTest extends TestBase {

  @Test
  public void groupCreationTest() {

    app.goTo().groupsPage();
    app.groups().isThereAGroup();
    List<GroupData> before = app.groups().getGroupList();
   // int before = app.groups().getGroupCount();
    app.groups().initGroupCreation();
    app.groups().fillGroupForm(new GroupData().withName("name").withHeader("group").withFooter("footer"));
    app.groups().submitGroupCreation();
    app.groups().returnToGroupsPage();
    List<GroupData> after = app.groups().getGroupList();
   // int after = app.groups().getGroupCount();
    Assert.assertEquals(after.size(),before.size()+1);

  }

  @Test (enabled = false)
  public void GroupCreationTest1() {

    app.goToGroupsPage();
    app.groups().initGroupCreation();
    app.groups().fillGroupForm(new GroupData().withName("naxxme").withHeader("groggup").withFooter("foovvter"));
    app.groups().submitGroupCreation();
    app.groups().returnToGroupsPage();

  }

  @Test
  public void GroupCreationEmptyTest() {

    app.goToGroupsPage();
    app.groups().initGroupCreation();
    app.groups().fillGroupForm(new GroupData().withName("dfg").withHeader("grosgup").withFooter("footaaer"));
    app.groups().submitGroupCreation();
    app.groups().returnToGroupsPage();

  }

}
