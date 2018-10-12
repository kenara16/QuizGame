package Persistence;

/*
 * Abstract class - static factory method model to access DAO: Data Access Object Factory, an abstract class
 * to be implemented by different database DAO factory classes
 * to get xxxDAO where xxx is the entity type.
 * it has a static factory method getDAOFactory() that returns the proper DAO factory depending on the database
 * vendor input.
 */

/**
 *
 * @author Billy
 */
public abstract class DAOFactory {
    //List of DAO supported by the factory
    public static final String ORACLE = "oracle";
    public static final String NOSQL = "nosql";

    //DAO method to be implemented by concrete factories
    //TODO


    //Static method to get the proper DAO factory
    public static DAOFactory getDAOFactory(String databaseType){
        if (null == databaseType)
            return null;

        switch(databaseType.toLowerCase()){
            case "oracle":
                return new OracleDAOFactory();

            case "nosql":
                return new NoSQLDAOFactory();

            default:
                return null;
        }
    }

}
