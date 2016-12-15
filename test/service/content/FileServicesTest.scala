package service.content

import java.util.Date

import domain.content.{Media, RawContent}
import org.scalatest.{FeatureSpec, GivenWhenThen}

/**
  * Created by user42 on 2016/09/06.
  */
class FileServicesTest extends FeatureSpec with GivenWhenThen {

  feature("File Services"){

    info("As an Editor")
    info("I want to download supporting file attachments")

    scenario("Test"){
      Given("Content with an attachment")

      val articleContent = RawContent("HBC", "123", new Date(),
                                "John Doe", "SRC", "Cancer",
                                "Fighting the symptoms", "blah-blah-blah",
                                "text", "pending edit", "")

      val attachedMedia = Media("123", "M123", "MediaDesc",
                                "url", "mime", new Date(),
                                "fresh")

      assert(attachedMedia.contentId === articleContent.id)

//      val mediaService = MediaService
//      mediaService.create(attachedMedia)
//      val futureResult = mediaService.getContentMediaById("123", "M123")
//
//      futureResult.onComplete{
//         case Success(result) => println(s"Success $result")
//         case Failure(throwable) => println(s"Failure $throwable")
//      } // Repository test



    }


  }

}
