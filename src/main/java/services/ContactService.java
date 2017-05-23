package services;

import com.jfoenix.controls.JFXComboBox;
import models.ContactPerson;
import models.Group;

import java.util.List;

/**
 * Created by Fredrik on 22-05-2017.
 */
public class ContactService
{

    public boolean addContactToDB (String email, String phone) {


        ContactPerson cp = new ContactPerson();

        try {
            cp.set("email", email);
            cp.set("phone", phone);
            cp.saveIt();

            System.out.println("Contact oprettet");
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public void setGroupPicker (JFXComboBox pickGroup)
    {
        List<Group> groups = Group.findAll();

        for (Group g: groups)
        {
            pickGroup.getItems().add(g.get("name").toString());

        }

    }

    public void setContactPicker (JFXComboBox pickContact)
    {
        List <ContactPerson> contactEmails = ContactPerson.findAll();

        for (ContactPerson c: contactEmails)
        {
            pickContact.getItems().add(c.get("email"));
        }
    }


}
