## Overview

This is a sample project that creates a local virtual machine and installs Spark and SBT.

It also includes a simple application to demonstrate connecting to a Scala class from the Spark Python shell.

## Quick Start

1- Clone the source *be sure to include submodules!*

```
$> git clone --recursive https://github.com/jeffusan/PlaceSparkDome.git
```

2- Create the VM: ```vagrant up```

3- Log into the VM: ```vagrant ssh```

4- Package the dependency:

```
$> cd /vagrant/apps
$> sbt package
```

5- Start Pyspark with the dependency in classpath

```
$> cd /opt/spark
$> ./bin/pyspark --driver-class-path /vagrant/apps/target/scala-2.10/helloworld_2.10-1.0.jar
```

6- Try it out:

```
pyspark>>> hello = sc._jvm.place.sparkdome.HelloWorld()

pyspark>>> rdd = hello.getRDDFromSC(sc._jsc)

pyspark>>> rdd
JavaObject id=XXX
```

## Submitting a Job

Submitting a python job which references the Scala class will work as follows:

1- Perform the tasks from the previous sequence until Step #5

2- Instead of step 5, do the following:

```
/opt/spark$>./bin/spark-submit --jars helloworld_2.10-1.0.jar hello_scala_spark.py
```

Notice the HelloWorld class is loaded differently within the Spark application.

```
import pyspark

from py4j.java_gateway import java_import

sc = pyspark.SparkContext(master='local[*]',
                          appName='HelloWorld')

helperClass = sc._jvm.java.lang.Thread.currentThread().getContextClassLoader().loadClass("place.sparkdome.HelloWorld")

helper = helperClass.newInstance()

print helper.getRDDFromSC(sc._jsc)
```
