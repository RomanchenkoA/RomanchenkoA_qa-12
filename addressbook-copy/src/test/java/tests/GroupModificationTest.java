package tests;


import model.GroupData;
import org.testng.annotations.Test;

public class GroupModificationTest extends TestBase {


@Test
    public void TestModificationGroup(){
    app.goTo().groupsPage();
    if(!app.groups().isThereAGroup()){
        app.groups().createGroup(new GroupData().withName("name").withHeader("group").withFooter("footer"));
    }

    app.groups().selectGroup();
    app.groups().initGroupModification();
    app.groups().fillGroupForm(new GroupData().withName("name").withHeader("group").withFooter("footer"));
    app.groups().confirmGroupModification();
    app.groups().returnToGroupsPage();
}

}
