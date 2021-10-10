package by.training.project.dao.pool;

import by.training.project.dao.config.Config;
import by.training.project.dao.exception.DaoException;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.LinkedBlockingQueue;

public final class ConnectionPool {
//    private static Logger logger = Logger.getLogger(ConnectionPool.class);
    private static final String DB_URL_PROP = "db.url";
    private static final String DB_USER_PROP = "db.user";
    private static final String DB_PASSWORD_PROP = "db.password";
    private static final String DB_DRIVER_PROP = "db.jdbc-driver";
    private static final String DB_POOL_SIZE = "db.pool-size";
    private static final String DB_MAX_SIZE = "db.max-size";
  //  private static final String DB_
//    private String url = "jdbc:mysql://" + Config.DB_HOST.getValue() + ":" +
//            Config.DB_PORT.getValue() + "/" + Config.DB_NAME.getValue();
//    private String user = Config.DB_USER.getValue();
//    private String password = Config.DB_PASS.getValue();
    private int maxSize = 151; // standart max connections in MySql
    private int checkConnectionTimeout = 45;

    private final BlockingQueue<PooledConnection> freeConnections = new LinkedBlockingQueue<>();
    private final Set<PooledConnection> usedConnections = new ConcurrentSkipListSet<>();
    private Properties dbProperties;

    private ConnectionPool() {}

    public synchronized Connection getConnection() throws DaoException {
        PooledConnection connection = null;
        while(connection == null) {
            try {
                if(!freeConnections.isEmpty()) {
                    connection = freeConnections.take();
                    if(!connection.isValid(checkConnectionTimeout)) {
                        try {
                            connection.getConnection().close();
                        } catch(SQLException e) {}
                        connection = null;
                    }
                } else if(usedConnections.size() < maxSize) {
                    connection = createConnection();
                } else {
                    //logger.error("The limit of number of database connections is exceeded");
                    throw new DaoException("The limit of number of database connections is exceeded");
                }
            } catch(InterruptedException | SQLException e) {
                //logger.error("It is impossible to connect to a database", e);
                throw new DaoException(e);
            }
        }
        usedConnections.add(connection);
       // logger.debug(String.format("Connection was received from pool. Current pool size: %d used connections; %d free connection", usedConnections.size(), freeConnections.size()));
        return connection;
    }

    synchronized void freeConnection(PooledConnection connection) {
        try {
            if(connection.isValid(checkConnectionTimeout)) {
                connection.clearWarnings();
                connection.setAutoCommit(true);
                usedConnections.remove(connection);
                freeConnections.put(connection);
              //  logger.debug(String.format("Connection was returned into pool. Current pool size: %d used connections; %d free connection", usedConnections.size(), freeConnections.size()));
            }
        } catch(SQLException | InterruptedException e1) {
           // logger.warn("It is impossible to return database connection into pool", e1);
            try {
                connection.getConnection().close();
            } catch(SQLException e2) {}
        }
    }

    public synchronized void init() throws DaoException {
        try {
            InputStream input = getClass().getClassLoader().getResourceAsStream("db.properties");
            dbProperties = new Properties();
            dbProperties.load(input);
            destroy();
            Class.forName(dbProperties.getProperty(DB_DRIVER_PROP));
           // this.url = dbProperties.getProperty(DB_URL_PROP);
           // this.user = dbProperties.getProperty(DB_USER_PROP);
          //  this.password = dbProperties.getProperty(DB_PASSWORD_PROP);
            this.maxSize = Integer.parseInt(dbProperties.getProperty(DB_MAX_SIZE));
            this.checkConnectionTimeout = checkConnectionTimeout;
            for(int counter = 0; counter < Integer.parseInt(dbProperties.getProperty(DB_POOL_SIZE)); counter++) {
                freeConnections.put(createConnection());
            }
        } catch(ClassNotFoundException | SQLException | InterruptedException | IOException e) {
          //  logger.fatal("It is impossible to initialize connection pool", e);
            throw new DaoException(e);
        }
    }

    private static final ConnectionPool instance = new ConnectionPool();

    public static ConnectionPool getInstance() {
        return instance;
    }

    private PooledConnection createConnection() throws SQLException { // TODO exepction
        return new PooledConnection(DriverManager.getConnection(dbProperties.getProperty(DB_URL_PROP),
                dbProperties.getProperty(DB_USER_PROP), dbProperties.getProperty(DB_PASSWORD_PROP)));
    }

    public synchronized void destroy() {
        usedConnections.addAll(freeConnections);
        freeConnections.clear();
        for(PooledConnection connection : usedConnections) {
            try {
                connection.getConnection().close();
            } catch(SQLException e) {}
        }
        usedConnections.clear();
    }
}
