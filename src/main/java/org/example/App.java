package org.example;

import org.example.config.HibernateUtility;
import org.example.dao.ModelDao;
import org.example.models.json.JsomModel;
import org.example.models.xls.XLSModel;
import org.example.parser.GsonParser;
import org.example.parser.XLSParser;
import org.example.reader.JsonPackageReader;
import org.example.util.Util;

import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        ModelDao<JsomModel> jsomModelModelDao = new ModelDao<>(HibernateUtility.getSessionFactory());

        ModelDao<XLSModel> xlsModelModelDao = new ModelDao<>(HibernateUtility.getSessionFactory());

        List<JsomModel> jsomModels =  GsonParser.INSTANCE.parse(JsonPackageReader.INSTANCE.read(Util.JSONS_PATH));

        List<XLSModel> xlsModelList =  XLSParser.INSTANCE.parse(Util.XLS_PATH);

        jsomModelModelDao.save(jsomModels);

        xlsModelModelDao.save(xlsModelList);
    }
}
