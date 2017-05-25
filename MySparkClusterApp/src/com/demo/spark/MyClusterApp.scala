package com.demo.spark

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
/**
  * Created by Dilip on 25/05/2017.
  */
object MyClusterApp{
  def main (arg: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("MyClusterApp")
    val sc = new SparkContext(conf)

    val rdd = sc.textFile("wasbs:///HdiSamples/HdiSamples/SensorSampleData/hvac/HVAC.csv")

    //find the rows that have only one digit in the seventh column in the CSV file
    val rdd1 =  rdd.filter(s => s.split(",")(6).length() == 1)

    rdd1.saveAsTextFile("wasbs:///HVACOut")
  }

}