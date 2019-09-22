package co.uk.richardpricejones.app.config;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@Configuration
@PropertySource("classpath:mongo.properties")
public class MongoConfig extends AbstractMongoConfiguration {

    @Value("${mongo.host}")
    private String MONGO_HOST;

    @Value("${mongo.port}")
    private String MONGO_PORT;

    @Value("${mongo.database}")
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
