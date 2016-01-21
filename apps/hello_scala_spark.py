import pyspark

from py4j.java_gateway import java_import

sc = pyspark.SparkContext(master='local[*]',
                          appName='HelloWorld')

helperClass = sc._jvm.java.lang.Thread.currentThread().getContextClassLoader().loadClass("place.sparkdome.HelloWorld")

helper = helperClass.newInstance()

print helper.getRDDFromSC(sc._jsc)
