制作钥匙：

在装有java环境里
1，切换到DatGen.java目录,比如E目录
2，E:\>javac -d ./ DatGen.java
3，E:\>java DatGen '{"ipList":["127.0.0.1"],"codeList":["805000","805001","805002","805003","805004","805005","805020","805021","805022","805023","805024","805025","805026","805027","805040","805041","805042","805043","805044","805045","805046","805047","805048","805049","805050","805051","805052","805053","805054","805055","805056","805060","805061","805062","805063","805090","805091","805092","805093"]}'

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

