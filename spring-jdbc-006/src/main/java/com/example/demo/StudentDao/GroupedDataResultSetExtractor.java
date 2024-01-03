package com.example.demo.StudentDao;

import com.example.demo.Models.AddressGroupedDataModel;
import com.example.demo.Models.StudentModel;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


@Component
public class GroupedDataResultSetExtractor implements
        ResultSetExtractor<Map<String, List<String>>> {


    public Map<String, List<String>> extractData(ResultSet rs)
            throws SQLException, DataAccessException {

        {
            System.out.println("""
                    Map<String, List<String>> extractData(ResultSet rs)
                    Extracting Data.....>>>>
                    
                    """);
        }


        List<AddressGroupedDataModel> addressGroupedDataModelArrayList = new ArrayList<>();

        while (rs.next()) {
            AddressGroupedDataModel addressGroupedDataModel
                    = new AddressGroupedDataModel();

            addressGroupedDataModel.setName(rs.getString("student-second-name"));
            addressGroupedDataModel.setAddress(rs.getString("Address"));

            addressGroupedDataModelArrayList.add(addressGroupedDataModel);
        }

        analyseGroupedData(addressGroupedDataModelArrayList);

        return null;
    }

    public void analyseGroupedData(List<AddressGroupedDataModel> addressGroupedDataModelArrayList)
    {

        {
            System.out.println("""
                analyseGroupedData(List<AddressGroupedDataModel> addressGroupedDataModelArrayList)
                Analysing data.....>>>>
                
                """);
        }

        Set<String> addressSet = new HashSet<>();

        Map<String, List<String>> groupedData = new HashMap<>();


        String address;

        for(AddressGroupedDataModel groupedDataModel : addressGroupedDataModelArrayList)
        {
            addressSet.add(groupedDataModel.getAddress());
        }

        Iterator<String> addressIterator = addressSet.iterator();

        while (addressIterator.hasNext())
        {
            address  = addressIterator.next();

            List<String> namesList = new ArrayList<>();

            for(AddressGroupedDataModel groupedDataModel : addressGroupedDataModelArrayList)
            {
                if(address.equals(groupedDataModel.getAddress()))
                {
                    namesList.add(groupedDataModel.getName());
                }
            }
            groupedData.put(address,namesList);
        }
        System.out.println(groupedData);
    }
}
