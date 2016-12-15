package service.content

import java.util.Date

import domain.content.RawContent
import org.scalatest.{FeatureSpec, GivenWhenThen}

/**
  * Created by user42 on 2016/09/05.
  */
class ViewContentTest extends FeatureSpec with GivenWhenThen{
  feature("View shared content Service"){
    info("As an Editor")
    info("I want to download and view shared content")

    scenario("Test"){
      Given("Raw content")

      val content = "blah-blah-blah"

      val articleContent = RawContent("HBC", "123", new Date(),
                                      "John Doe", "SRC", "Cancer",
                                      "Fighting the symptoms", content,
                                      "text", "pending edit", "")

//      assert(articleContent.content == content) // Domain test


      val rawContentService = RawContentService
      rawContentService.create(articleContent)
      val futureResult = rawContentService.getContentById("HBC", "123")

//      futureResult.onComplete{
//        case Success(result) => println(s"Success $result")
//        case Failure(throwable) => println(s"Failure $throwable")
//
//      } // Repository test



    }

  }
}
