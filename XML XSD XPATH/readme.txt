1 The XSD is in schema.xsd.

2a) Xml is product.xml
2b) copy the folder in /xml place it in your c-folder such that the file "Product.xml" is in the folder "file:///C:/xml/loadXMLFromFile/product.xml"
 execute Producttable.html in firefox to see the results.
 
3.XML to JSON Program.
XMLTODOMJSON.java
compile
javac XMLTODOMJSON.java

run
java XMLTODOMJSON "sample.xml"
 
 
*
2 2) xpath expression.
//ProductInformation[(number(substring(ProductReleaseDate,1,4))) > 2010]/CompanyInformation/(CompanyName|CompanyAddress/StreetName|CompanyAddress/City|CompanyAddress/Zipcode|CompanyAddress/Country)



Element='<CompanyName>SAP</CompanyName>'
Element='<StreetName>105_Street</StreetName>'
Element='<City>Walldorf</City>'
Element='<Zipcode>57575</Zipcode>'
Element='<Country>GERMANY</Country>'

Element='<CompanyName>SAP</CompanyName>'
Element='<StreetName>105_Street</StreetName>'
Element='<City>Walldorf</City>'
Element='<Zipcode>57575</Zipcode>'
Element='<Country>GERMANY</Country>'

Element='<CompanyName>Oracle</CompanyName>'
Element='<StreetName>103_Street</StreetName>'
Element='<City>PaloAlto</City>'
Element='<Zipcode>94065</Zipcode>'
Element='<Country>UNITED STATES</Country>'

Element='<CompanyName>Oracle</CompanyName>'
Element='<StreetName>103_Street</StreetName>'
Element='<City>PaloAlto</City>'
Element='<Zipcode>94065</Zipcode>'
Element='<Country>UNITED STATES</Country>'

Element='<CompanyName>MICROSOFT</CompanyName>'
Element='<StreetName>102_Street</StreetName>'
Element='<City>Seattle</City>'
Element='<Zipcode>98101</Zipcode>'
Element='<Country>UNITED STATES</Country>'