package service.location

import java.util.Date

import domain.location.AddressType
import domain.person.{Person, PersonAddress}
import org.scalatestplus.play.PlaySpec
import service.person.{PeopleService, PersonAddressService}
import scala.concurrent.ExecutionContext.Implicits.global
/**
  * Created by martian on 2016/12/07.
  */
class AddressTypeServiceTest extends PlaySpec {

  "AddressTypeService # get" should {

    "find the address type given an id " in {

//      val personRecord = Person ("HBC","35587", "John",
//        "john@example.com", "Doe" , "*",
//        true,false,true,true, "the state")
//
//      PeopleService.saveOrUpdate(personRecord)

      val addressType = AddressType("7890", "res", "state")

      val addressTypeService = AddressTypeService
      addressTypeService.saveOrUpdate(addressType)

//      val personAddress = PersonAddress("01", "35587", "residential", "9000", "7890", new Date(), "state")
//      PersonAddressService.saveOrUpdate(personAddress)

      val res = addressTypeService.get("7890")

      res map {
        o => o match {
          case Some(x) => {
            assert(x.name === "res")}
        }
      }


    }
  }

}
