package service.content

import domain.content.Category
import org.scalatest.{FeatureSpec, GivenWhenThen}
import org.scalatestplus.play.PlaySpec
import scala.concurrent.ExecutionContext.Implicits.global

/**
 * Created by hashcode on 2015/07/27.
 */
class CateGoryServiceTest extends PlaySpec{

"CategoryService # getCategoryByID" should{

  "retrieved a category based on ID given" in {

    val  cat1 = Category("1","Health1","Health Care Category 2")
   //val newcate = Category("1","Health1","Health Care Category 1")

    val categoryService = CategoryService


    categoryService.apply().create(cat1)

    val retrievedCat= categoryService.apply().getCategory("1")

    retrievedCat map {
      o => o match {
        case Some(x) => {
          assert(x.name === "Health1")}
      }
    }

  }
}
  /*feature(" Category Service"){
    scenario(" Test "){
      Given(" Category Object ")
      val cat1 = Category("1","Health1","Health Care Category 1")
      val cat2 = Category("2","Health2","Health Care Category 2")
      val cat3 = Category("3","Health3","Health Care Category 3")

      CategoryService().create(cat1)
      CategoryService().create(cat2)
      CategoryService().create(cat3)

    }*/



}
