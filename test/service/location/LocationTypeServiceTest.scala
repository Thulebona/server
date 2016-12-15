package service.location

import domain.location.LocationType
import org.scalatestplus.play.PlaySpec

/**
  * Created by Ethon on 2016/12/15.
  */
class LocationTypeServiceTest extends PlaySpec {

  "LocationTypeService # getLocationByID" should{
    "retrieved a location based on ID given" in{

      val location1 = LocationType("1","Ethon","123","The state")
      val locationService = LocationTypeService
      locationService.saveOrUpdate(location1)

      val retrievedLoc = locationService.get("1")

      retrievedLoc map{
        o => o match {
          case Some(x) =>{
            assert(x.name === "Ethon")
          }
        }
      }
    }
  }

}
