package place.sparkdome

import org.apache.spark.rdd.RDD
import org.apache.spark.api.java.JavaSparkContext

import py4j.GatewayServer

class HelloWorld {

  def getRDDFromSC(sc: JavaSparkContext): RDD[Int] = {
    sc.parallelize(Seq(1,2,3,4,5,6,7,8,9,10))
  }

}
