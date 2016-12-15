package service.organisation

import java.util.Date

import domain.organisation.{Organisation, OrganisationLogo}
import org.scalatestplus.play.PlaySpec

import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by user42 on 2016/09/09.
  */
class OrganisationLogoTest extends PlaySpec{

  "OrganisationLogoServices # findDCompanyLogo" should {

    "find the logo of the organisation given name and id" in{

      val logoURL = "URL"

      val mapCoordinates = Map("34.157789" -> "19.015227")

      val newOrg = Organisation("123", "Impala", mapCoordinates,
        "", new Date(), "state")

      val newOrgLogo = OrganisationLogo("ELF", "123", logoURL,
        Some(""), "this logo",
        "mime", new Date())

      val organisationService     = OrganisationService
      val organizationLogService  = OrganisationLogoServices

      organisationService.saveOrUpdate(newOrg)
      organizationLogService.SaveOrUpdate(newOrgLogo)

      val org = organizationLogService.findDCompanyLogo("ELF","Impala")

      org map {
        o => o match {
          case Some(x) => {
            assert(x.url === logoURL)}
        }
      }


    }

  }

}
