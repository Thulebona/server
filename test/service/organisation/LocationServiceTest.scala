package service.organisation

import java.util.Date

import domain.location.LocationType
import domain.organisation.{Location, Organisation}
import org.scalatestplus.play.PlaySpec
import service.location.LocationTypeService
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by martian on 2016/11/24.
  */
class LocationServiceTest extends PlaySpec{

  "LocationService # findByID" should{


    "find the location of an organisation given name and id" in{

      val locTypeService  = LocationTypeService
      val locService      = LocationService

      val locationType    = LocationType("type2", "residential", "0000", "WC")
      locTypeService.saveOrUpdate(locationType)

      val location        = Location("123", "L000", "name", "type2", "899", "34.157789","19.015227","", "", new Date())
      locService.save(location)
      val res             = locService.findById("Impala" , "123")

      res map {
        o => o match {
          case Some(x) => {
            assert(x.name === "name")}
        }
      }
    }
  }

}
