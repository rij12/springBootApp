package co.uk.richardpricejones.app.config;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@Configuration
public class MongoConfig extends AbstractMongoConfiguration {

    @Value("${spring.data.mongodb.host}")
    private String MONGO_HOST;

    @Value("${spring.data.mongodb.port}")
    private String MONGO_PORT;

    @Value("${spring.data.mongodb.database}")
    private String MONGO_DATABASE_NAME;

    @Override
    protected String getDatabaseName() {
        return this.MONGO_DATABASE_NAME;
    }

    @Override
    public MongoClient mongoClient() {
        return new MongoClient(MONGO_HOST, Integer.parseInt(MONGO_PORT));
    }
}
