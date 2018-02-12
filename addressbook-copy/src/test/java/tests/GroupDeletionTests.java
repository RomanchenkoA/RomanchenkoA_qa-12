package tests;

import model.GroupData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class GroupDeletionTests extends TestBase {
  @Test
  public void groupDeletionTest(){
    app.goTo().groupsPage();
    if(!app.groups().isThereAGroup()){
      app.groups().createGroup(new GroupData().withName("name").withHeader("group").withFooter("footer"));
    }
    //int before = app.groups().getGroupCount();
    List<GroupData> before = app.groups().getGroupList();
    app.groups().selectGroupByIndex(before.size()-1);
    app.groups().initGroupDeleted();
    app.groups().returnToGroupsPage();
    List<GroupData> after = app.groups().getGroupList();
    //int after = app.groups().getGroupCount();

    Assert.assertEquals(after.size(), before.size()-1);
    before.remove(before.size()-1);
    for(int i= 0; i< after.size(); i++){
      Assert.assertEquals(before.get(i), after.get(i));
    }
  }

  @Override
  public String toString() {
    return "GroupDeletionTests";
  }

  public void selectGroup() {

    app.groups().click(By.name("selected[]"));
  }

}
