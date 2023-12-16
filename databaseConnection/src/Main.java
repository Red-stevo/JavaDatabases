public class Main {

    private static TransportCompanyDAO transportCompanyDAO;
    private static memberModel model;


    public static void main(String[] args) throws Exception
    {
        insert();
        getInfor();
        deleteMember();
        updateMemberInfo();
    }

    public static void insert() throws Exception
    {
        transportCompanyDAO = new TransportCompanyDAO();

        model = new memberModel();
        model.setRegNo("M008");
        model.setMemberName("Ignitius Kinuthia");
        model.setMemberAddress("Kenya Kiambu Gatumdu");
        model.setMemberPhoneNumber(595694765);

        System.out.println(transportCompanyDAO.insertIntoTable("memeberTable", model));

    }

    public static void getInfor() throws Exception {
        transportCompanyDAO = new TransportCompanyDAO();
        model = new memberModel();

        model.setRegNo("M003");
        model = transportCompanyDAO.getInforByRegNo( "memeberTable",model.getRegNo());

        System.out.println("RegNo : "+model.getRegNo()+" Name : "+ model.getMemberName()+" Address : "
                + model.getMemberAddress()+" PhoneNo : "+model.getMemberPhoneNumber());
    }

    public static void deleteMember() throws Exception
    {
        transportCompanyDAO = new TransportCompanyDAO();

        System.out.println(transportCompanyDAO.deleteMember("memeberTable", "M006"));
    }

    public static void updateMemberInfo()throws Exception
    {
        transportCompanyDAO = new TransportCompanyDAO();
        System.out.println(transportCompanyDAO.updateMember("memeberTable", "M002","Bob Mirowe"));
    }
}