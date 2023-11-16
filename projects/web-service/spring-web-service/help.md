wsdl url: http://localhost:8080/ws/countries.wsdl

## request: 
```shell
curl --header "content-type: text/xml" -d @test/soap/requestcity.xml http://localhost:8080/ws | xmllint --format -
```
test/soap/requestcity.xml
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:gs="http://spring.io/guides/gs-producing-web-service">
    <soapenv:Header/>
    <soapenv:Body>
        <gs:getCityRequest>
            <gs:name>Spain</gs:name>
        </gs:getCityRequest>
    </soapenv:Body>
</soapenv:Envelope>
```


参考:
* [WebService到底是什么？](https://www.jianshu.com/p/49d7997ad3b7)
* [XML Schema Definition (XSD)](https://www.techtarget.com/whatis/definition/XSD-XML-Schema-Definition)
* [简单对象访问协议](https://zh.wikipedia.org/zh-cn/%E7%AE%80%E5%8D%95%E5%AF%B9%E8%B1%A1%E8%AE%BF%E9%97%AE%E5%8D%8F%E8%AE%AE)
* [Java SOAP 使用 IDEA 新建一个简单的 webservice 服务，并提供 SOAP 调用](https://blog.csdn.net/wuyujin1997/article/details/117645808)
* [Producing a SOAP web service](https://spring.io/guides/gs/producing-web-service/)