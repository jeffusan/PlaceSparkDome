import sbt._

object Version {
  val spark = "1.6.0"
  val py4j =  "0.9.1"
}

object Library {
  val sparkCore = "org.apache.spark" %% "spark-core" % Version.spark
  val py4j = "net.sf.py4j" % "py4j" % Version.py4j
}

object Dependencies {

  import Library._

  val hello = List(
    sparkCore,
    py4j
  )
}
