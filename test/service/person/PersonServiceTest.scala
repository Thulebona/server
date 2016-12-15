package service.person

import domain.person._
import org.scalatestplus.play.PlaySpec
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by user42 on 2016/09/08.
  */
class PersonServiceTest extends PlaySpec{

  "PersonSrevice # getPerson" should{
    "find a person given an organisation and ID" in {

      val personRecord = Person ("HBC","35587", "John",
        "john@example.com", "Doe" , "*",
        true,false,true,true, "the state")

      val personService = PeopleService
      personService.saveOrUpdate(personRecord)


      val person = personService.getPersonByEmail("john@example.com")

      person map{
        o => o match{
          case Some(x) =>{
            assert(x.org === "HBC")
          }
        }
      }



    }
  }

  "PersonService #getById" should{
    "be true when the id exists" in{

      val personAddress =  PersonAddress("Add1","123","1 Tenant Street","7925","ADT001", new Date(),"")

      val personService = PersonAddressService
      personService.saveOrUpdate(personAddress)
        val addressType = personService.getValues("ADT001")

      personAddress map {
        o => o match{
          case Some(x) =>{
            assert(x.description === "1 Tenant Street")
          }
        }
      }
    }
  }





  "PersonService #getById" should{
    "be true when the id exists" in{
       val personLang = PersonLanguage("001", "123","LANG1", "English","English", "English", new Date(),"")
      val personService =  PersonLanguageService
      personService.saveOrUpdate(personLang)


      val person = personService.getPerson("HBC", "35587")

      person map {
        o => o match {
          case Some(x) => {
            assert(x.emailAddress === "john@example.com")}
        }
      }


    }
  }

  "PersonSrevice # getPersonByEmail" should{
    "find a person given an email" in {

      val personRecord = Person ("ELF","354", "Jane",
        "jane@example.com", "Max" , "*",
        true,false,true,true, "the state")

      val personService = PeopleService
      personService.saveOrUpdate(personRecord)

      val person = personService.getPersonByEmail("jane@example.com")

      person map {
        o => o match {
          case Some(x) => {
            assert(x.org === "ELF")}
        }
      }


      val language = personService.getValues("123")

      personService map{
        o => o match{
          case Some(x) =>{
            assert(x.writing === "English")
          }
        }
      }
    }
  }

  "PersonService #getById" should{
    "be true when the id exists" in {
      val personContact = PersonContact("1", "123", "CON001", "0766651268", "Active", new Date(),"")
      val personService = PersonContactService
      personService.saveOrUpdate(personContact)

      val contactType = personService.getValues("0766651268")

      contactType map{
        o => o match{
          case Some(x) =>{
            assert(x.contactValue === "0766651268")
          }
        }
      }
    }
  }

  /*feature("Creating user profile"){

    info("As a user")
    info("I want to add details to my profile")

    scenario("Test"){
      Given("")

      // Object creation
      val personRecord = Person ("HBC","123", "John",
                                  "john@example.com", "Doe" , "*",
                                  true,false,true,true, "the state")

      val addressType = AddressType ("ADT001", "Residential", "")
      val personAddress = PersonAddress("Add1", "123", "1 Tenant Street",
                                        "7925", "ADT001", new Date(), "")

      val language = Language("LANG1", "english", "")
      val personLang = PersonLanguage("001", "123", "LANG1", "English",
                                      "English", "English", new Date(),
                                      "")

      val gender = Gender("GEN01", "Male", "")
      val raceID = Race("R1", "BLACK", "")
      val personDemo = PersonDemographics("Demo1", "123", "GEN01",
        "R1", new Date (1989, 2, 12), "1", 5, new Date(), "current-state")

      val contactType = ContactType("CON001", "cell", "")
      val personContact = PersonContact("1", "123", "CON001",
                                        "0784117523", "Active",
                                        new Date(), "")
      // Use of objects in services
      val personService = PeopleService
      personService.saveOrUpdate(personRecord)

      val personAddressServ = PersonAddressService
      val addressService    = AddressTypeService
      addressService.saveOrUpdate(addressType)
      personAddressServ.saveOrUpdate(personAddress)

      val langService = LanguageService
      val personLangService = PersonLanguageService
      langService.saveOrUpdate(language)
      personLangService.saveOrUpdate(personLang)

      val genderServ = GenderService
      val personDemoService = PersonDemographicsService
      genderServ.saveOrUpdate(gender)
      personDemoService.saveOrUpdate(personDemo)

      val contact = ContactTypeService
      val personContactServ = PersonContactService
      contact.saveOrUpdate(contactType)
      personContactServ.saveOrUpdate(personContact)

      val futureRes = personService.getPerson("HBC", "123")

//      futureRes.onComplete{
//        case Success(result) => println(s"Success $result")
//        case Failure(throwable) => println(s"Failure $throwable")
//      }

    }
  }*/
}
