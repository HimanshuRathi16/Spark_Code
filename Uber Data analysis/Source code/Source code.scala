Problem Statement:
Find the days on which each basement has more trips.

val dataset = sc.textFile("/Path")
val header = dataset.first()
val format = new java.text.SimpleDateFormat("MM/dd/yyyy")
var days =Array("Sun","Mon","Tue","Wed","Thu","Fri","Sat")
val eliminate = dataset.filter(line => line != header)
val split = eliminate.map(line => line.split(",")).map { x => (x(0),format.parse(x(1)),x(3)) }
val combine = split.map(x => (x._1+" "+days(x._2.getDay),x._3.toInt))
val arrange = combine.reduceByKey(_+_).map(item => item.swap).sortByKey(false).collect.foreach(println)


