package service.organisation

import java.util.Date

import domain.organisation.Organisation
import org.scalatestplus.play.PlaySpec

import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by user42 on 2016/09/08.
  */
class OrganisationServiceTest extends PlaySpec{

  // OrganisationService isAvailable() method test
  "OrganisationService # isAvailable " should {

    "be true when the organisation id exists" in {

      val mapCoordinates = Map("34.157789" -> "19.015227")

      val newOrganization = Organisation("101", "Red Cross", mapCoordinates,
        "", new Date(), "state")

      val organisationService = OrganisationService
      organisationService.saveOrUpdate(newOrganization)

      val actual = organisationService.isAvailable(newOrganization.id)

      actual map {
        org => org match {
          case x => {
            assert(x == true)
          }
        }
      }

    }

  }

  // OrganisationService getById() method test
  "OrganisationService # getById " should {

    "show correct details when the organisation id is given" in {

      val mapCoordinates = Map("34.157789" -> "19.015227")

      val newOrganization = Organisation("10", "RedCross", mapCoordinates,
        "", new Date(), "state")

      val organisationService = OrganisationService
      organisationService.saveOrUpdate(newOrganization)

      val org = organisationService.getById(newOrganization.id)

      org map {
        o => o match {
          case Some(x) => {
            assert(x.name === "RedCross")
          }
        }
      }
    }

  }

}
