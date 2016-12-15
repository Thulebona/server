package service.util

import org.scalatest.{FeatureSpec, GivenWhenThen}

/**
 * Created by hashcode on 2015/06/15.
 */
class AuthServiceTest extends FeatureSpec with GivenWhenThen{
  feature(" Test Hash Code "){
    info("Given a String")

    scenario(" Test String Hashing"){

      Given(" Give A string and Hashing Service")
      val auth = "Test123"
      val service = AuthService()

      When(" Hashed ")

      val res = service.hashAuth(auth)

      println(" The hasshed Value ", res)

      val isValid = service.hashCheck(auth,res)

      println(" Is Valid ", isValid)
    }
  }
}
