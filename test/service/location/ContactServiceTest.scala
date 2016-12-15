package service.location

import domain.location.ContactType
import org.scalatestplus.play.PlaySpec

/**
  * Created by Ethon on 2016/12/15.
  */
class ContactServiceTest extends PlaySpec {

  "ContactService # getContactByID" should{
    "retrieved a contact on a given ID" in{

      val contact1 = ContactType ("1","Ethon","The state")
      val contactService = ContactTypeService

      contactService.saveOrUpdate(contact1)

      val retrievedContact = contactService.get("1")

      retrievedContact map{
        o => o match{
          case Some(x) =>{
            assert(x.name === "Ethon")
          }
        }
      }
    }
  }

}
