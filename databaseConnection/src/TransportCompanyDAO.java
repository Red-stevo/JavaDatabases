import java.sql.*;


public class TransportCompanyDAO {


    private Connection connection;
    public TransportCompanyDAO()throws Exception
    {
        Class.forName("org.mariadb.jdbc.Driver");
        String url = "jdbc:mariadb://127.0.0.1:3306/trasportCompanySchema";
        String userName = "steve";
        String userPassword = "sijui!";

        connection = DriverManager.getConnection(url, userName, userPassword);
        System.out.println("Connected .....");
    }

    public String insertIntoTable(String tableName, memberModel model) throws Exception
    {
        String query = "INSERT INTO "+tableName+" VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, model.getRegNo());
        preparedStatement.setString(2, model.getMemberName());
        preparedStatement.setString(3, model.getMemberAddress());
        preparedStatement.setInt(   4, model.getMemberPhoneNumber());

        preparedStatement.executeUpdate();
        return "Data Inserted Successfully";
    }

    public memberModel getInforByRegNo(String tableName, String memberRegNo) throws Exception
    {
        String query = "SELECT * FROM "+tableName+" WHERE memberRegNo=(?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, memberRegNo);

        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        memberModel model = new memberModel();
        model.setRegNo(resultSet.getString(1));
        model.setMemberName(resultSet.getString(2));
        model.setMemberAddress(resultSet.getString(3));
        model.setMemberPhoneNumber(resultSet.getInt(4));

         return model;
    }

    public String deleteMember(String tableName, String memeberRegNo)throws Exception
    {
        String query = "DELETE  FROM "+tableName+" WHERE memberRegNo = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, memeberRegNo);
        int resultSet = preparedStatement.executeUpdate();

        return resultSet+" row(s) affected.";
    }

    public String updateMember(String tableName, String memberRegNo, String newName)throws Exception
    {
        String query = "UPDATE "+tableName+" SET memeberName = ? WHERE memberRegNo = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1,newName);
        preparedStatement.setString(2,memberRegNo);

        int result = preparedStatement.executeUpdate();

        return result+" row(s) affected.";
    }

}
