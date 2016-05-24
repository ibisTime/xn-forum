制作钥匙：

在装有java环境里
1，切换到DatGen.java目录,比如E目录
2，E:\>javac -d ./ DatGen.java
3，E:\>java DatGen '{"ipList":["127.0.0.1"],"codeList":["702001","702002","702004","702005","702006","702010","702011","702012","702013","702014","702015","702016","702017","702018","702019","702200","702201","702202","702203","702300","702301","702302","702303","702304","702305","702306","702307","702380","702381","702400","702401","702402","702403","702404","702450","702451","702452","702453","702454","702455","702456","702457","702458","702459","702498","702499","702502","702503","702504","702505","702515","702516","702517","702600","702601","702602","702603","702604","702700","702701","702702","702703","702704","702705","702706","702707","702708","702709","702710","702800","702801","702802","702803","702804","702805","702900","702980","702981","702982","702983","702984","702985","702986","702987","702988","7020051","7020052","7020053","7020101","7020102","7020103","7020104","7020105","7020106","7020107","7020108","7020201","7020202","7020203","7020204"]}'

4，拷贝当前目录下的“config.dat”到项目“{项目路径}\src\main\resources”
5，验证：项目跑起来。在浏览器输入“http://IP:端口/项目名/api”，出现版本信息即成功。





部署步骤：
1，切换到本地tomcat部署包所在目录,例如
  cd /Users/myb858/Documents/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp5/wtpwebapps
  
2，打包
  scp -P57652 ./std-account.war root@120.55.113.192:/home/
  
  scp -P57652 ./std-account.war root@121.43.101.148:/mnt/wwwroot/
  
  
3，部署
  ssh root@120.55.113.192 -p 57652
  ssh root@121.43.101.148 -p 57652
  
  cd /mnt/wwwroot/tomcat_STD_account/webapps
  cp ./std-account/WEB-INF/classes/application.properties .
  cp ./std-account/WEB-INF/classes/config.properties .
  rm -rf std-account/
  rm -rf std-account.war
  mv /mnt/wwwroot/std-account.war .
  
  mv -f application.properties ./std-account/WEB-INF/classes/
  mv -f config.properties ./std-account/WEB-INF/classes/
  ../bin/shutdown.sh
  ../bin/startup.sh
  
4,起停tomcat_STD_account
  ../bin/shutdown.sh
  ../bin/startup.sh
  
http://121.43.101.148:7102/std-account/api

