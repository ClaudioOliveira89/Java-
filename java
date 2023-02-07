import Java.sql.*;

public class JDBCExemple {
    public static void main(String[] args){
        Connectioin connection = null;
        try{

            Class.forName("com.mysql.jdbhc.Driver");
            connection = DriverManger.getConnection("jdbc:mysql//localhost:3306/database_name", "username", "password");
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select*from table_name");

            while (resultSet.next()){
                System.out.println(resultSet.getString("column_name"));
            }
        
            } catch (SQLException e) {
                System.out.println("Ocorreu um erro ao acessar o banco de dados: " + e.getMessage());
            } catch (ClassNotFoundException e) {
                System.out.println("Ocorreu um erro ao carregar o driver JDBC: "+ e.getMessage()); 
            } Finally {
            
            try {
                if (connection != null) {
                    Connection.close();   
                }
            } catch (SQLException e) {
                System.out.println("Ocorreu um erro ao fechar a conexãpo com o banco de daos: " + e.getMessage());
                }
             }
        }
    }
