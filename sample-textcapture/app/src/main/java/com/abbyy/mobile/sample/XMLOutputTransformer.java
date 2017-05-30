package com.abbyy.mobile.sample;

import java.io.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * Created by DRSPEED-PC on 30.05.2017.
 */
public class XMLOutputTransformer {

    /**
     * Пути заданы для теста.
     * Для реальной сборки нужно передавать пути входного, выходного xml и xslt-шаблона в сигнатуре метода.
     * Это удобно, так как для разных документов можно задавать разные шаблоны.
     */
    private String InputXMLFilePath = "src\\main\\data\\Data.xml";
    private String OutputXMLFilePath = "src\\main\\data\\DataNew.xml";
    private String XSLTTemplPath = "src\\main\\data\\Data.xslt";

    public void XMLOutputTransformer(String InputXMLFilePath, String XSLTTemplPath, String OutputXMLFilePath){
        this.InputXMLFilePath = InputXMLFilePath;
        this.OutputXMLFilePath = OutputXMLFilePath;
        this.XSLTTemplPath = XSLTTemplPath;

        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer(new StreamSource(new File(XSLTTemplPath)));
            StreamSource streamSource = new StreamSource(new File(InputXMLFilePath));
            StreamResult streamResult = new StreamResult(new File(OutputXMLFilePath));
            transformer.transform(streamSource, streamResult);
            System.out.println("Done");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
