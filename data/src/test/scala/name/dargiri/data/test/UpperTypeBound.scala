package name.dargiri.data.test

/**
  * Created by chamadhu on 5/16/2016.
  */
object UpperTypeBound extends scala.App {
  val littleCompany: Company[SmallCompany] = new Company[SmallCompany](new SmallCompany)
  println(littleCompany)

  val bigCompany: Company[BigCompany] = new Company[BigCompany](new BigCompany)
  println(bigCompany)

  val bigInvestor: Investor = new Investor(bigCompany)
  println(bigInvestor)

  val smallInvestor:Investor = new Investor(littleCompany)
}

class Company[+T](val company: T)

class BigCompany

class SmallCompany extends BigCompany

class Investor(val company: Company[BigCompany])
