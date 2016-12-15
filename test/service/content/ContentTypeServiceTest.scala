package service.content

import domain.content.ContentType
import org.scalatestplus.play.PlaySpec

/**
  * Created by Ethon on 2016/12/15.
  */
class ContentTypeServiceTest extends PlaySpec{

  "ContentTypeService # getContentTypeByID" should{
    "retrieved a contenttype based on ID given " in{

      val contenttype1 = ContentType("1","Book","Based on a true story")
      val contenttypeService = ContentTypeService

      contenttypeService.apply().create(contenttype1)

      val retrievedCon = contenttypeService.apply().getContentType("1")

      retrievedCon map{
        o => o match{
          case Some(x) =>{
            assert(x.name === "Book")
          }
        }
      }
    }
  }

}
